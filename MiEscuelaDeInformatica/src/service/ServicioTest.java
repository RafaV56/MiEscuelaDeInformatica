package service;

import java.util.List;

import daos.PreguntaDAO;
import daos.TestDAO;
import daos.TransaccionesManager;
import daos.UsuarioDAO;
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
			preguntas=preguntaDAO.recuperarPreguntas(test);
			
			//añado las preguntas al test
			test.setPreguntas(preguntas);

			//cierro la conexión
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
		return test;
	}
	
	/**
	 * Inserta el nombre del test y su creador
	 * @param test
	 * @throws ServiceException 
	 */
	public void insertarTest(Test test) throws ServiceException{
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			TestDAO testDAO = trans.getTestDAO();
			testDAO.insertarTest(test);


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
