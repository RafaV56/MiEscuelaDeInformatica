package service;

import java.util.ArrayList;
import java.util.List;

import daos.ProfesorDAO;
import daos.TransaccionesManager;
import domain.Profesor;
import domain.Usuario;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServiceProfesor {
	
	public void insertarProfesor(Profesor profesor) throws ServiceException{
		
		//verificamos que el alumno y el profesor no son el mismo
		if (profesor.getAlumno().getEmail().equals(profesor.getProfesor().getEmail())) {
			throw new ServiceException("El profesor y el alumno son el mismo");
		}else{
			TransaccionesManager trans =  null;
			try {

				trans =  new TransaccionesManager();
				ProfesorDAO insertarProfesorDAO = trans.getProfesorDAO();
				insertarProfesorDAO.insertarProfesor(profesor);

				trans.closeCommit();
			} catch (DAOException e) {

				try{
					trans.closeRollback();
				}catch (DAOException e1){
					throw new ServiceException(e.getMessage(),e1);//Error interno
				}

				if(e.getCause()==null){
					throw new ServiceException(e.getMessage());//Error Lógico
				}else{

					throw new ServiceException(e.getMessage(),e);//Error interno
				}

			}
			
		}
		
	}
	
	public List<Profesor> recuperarTodosProfesores(Usuario alumno) throws ServiceException{
		TransaccionesManager trans = null;
		List<Profesor> list = new ArrayList<Profesor>();
		try {

			trans = new TransaccionesManager();
			ProfesorDAO profesorDAO = trans.getProfesorDAO();
			list = profesorDAO.recuperarProfesores(alumno);
			trans.closeCommit();
		} catch (DAOException e) {
			try{
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error Lógico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
		return list;
	}

}
