package service;

import daos.HacerTestDAO;
import daos.ProfesorDAO;
import daos.TransaccionesManager;
import domain.Usuario;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServiceAgregarProfesor {
	
	public void insertarProfesor(Usuario profesor,Usuario alumno) throws ServiceException{
		
		//verificamos que el alumno y el profesor no son el mismo
		if (profesor.getEmail().equals(alumno.getEmail())) {
			throw new ServiceException("El profesor y el alumno son el mismo");
		}else{
			TransaccionesManager trans =  null;
			try {

				trans =  new TransaccionesManager();
				ProfesorDAO insertarProfesorDAO = trans.getProfesorDAO();
				insertarProfesorDAO.insertarProfesor(profesor,alumno);
					//hacer el profesor DAO y domain

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

}
