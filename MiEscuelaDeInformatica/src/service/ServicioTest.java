package service;

import java.util.List;

import daos.PreguntaDAO;
import daos.TestDAO;
import daos.TransaccionesManager;
import domain.Pregunta;
import domain.Test;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioTest {
	
	/**
	 * Recupera un test completo de la base de datos solo se necesita su nombre
	 * @param test usuario con el email
	 * @return test completo
	 * @throws ServiceException
	 */
	public Test recuperarTest(Test test) throws ServiceException{
		TransaccionesManager trans = null;
		TestDAO testDAO=null;
		PreguntaDAO preguntaDAO=null;
		List<Pregunta> preguntas=null;

		try {
			trans = new TransaccionesManager();
			testDAO= trans.getTestDAO();
			preguntaDAO=trans.getPreguntaDAO();
			test = testDAO.recuperarTest(test);
			
			//si el test es nullo lanzo una DAOException
			if (test==null) {
				throw new DAOException("El test no existe");
			}
			
			//recupero las preguntas con el nombre del test
			preguntas=preguntaDAO.recuperarPregunta(test);
			
			//a�ado las preguntas al test
			test.setPreguntas(preguntas);

			//cierro la conexi�n
			trans.closeCommit();
			
		} catch (DAOException e) {
			try{
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error L�gico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
		return test;
	}
}
