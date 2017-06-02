package service;

import daos.PreguntaDAO;
import daos.TransaccionesManager;
import daos.UsuarioDAO;
import domain.Pregunta;
import domain.Test;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicePregunta {
	
	public void insertarPregunta(Pregunta pregunta,Test test) throws ServiceException{
		TransaccionesManager trans = null;
		PreguntaDAO preguntaDAO=null;
		try {
			trans=new TransaccionesManager();
			preguntaDAO=trans.getPreguntaDAO();
			preguntaDAO.insertarPregunta(pregunta,test);


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
