package service;

import daos.PreguntaDAO;
import daos.TransaccionesManager;
import domain.Pregunta;
import domain.Test;
import exceptions.DAOException;
import exceptions.ServiceException;

/**
 * Realiza todos los servicios sobre una preguntas en la aplicación
 * @author Pc
 *
 */
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
