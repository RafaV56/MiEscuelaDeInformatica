package service;

import java.util.ArrayList;
import java.util.List;

import daos.HacerTestDAO;
import daos.TransaccionesManager;
import domain.HacerTest;
import domain.Usuario;

import exceptions.DAOException;
import exceptions.ServiceException;

/**
 * Realiza todos los servicios sobre quien hace un test en la aplicación
 * @author Pc
 *
 */
public class ServiceHacerTest {

	public ServiceHacerTest() {}
	
	
	public void insertarHacerTest(HacerTest hacerTest) throws ServiceException{
		TransaccionesManager trans =  null;
		try {

			trans =  new TransaccionesManager();
			HacerTestDAO hacerTestDAO = trans.getHacerTestDAO();
			hacerTestDAO.insertarHacerTest(hacerTest);


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
	
	/**
	 * Modifica un hacer test de la base de datos, acutaliza el campo superado
	 * @param hacerTest
	 * @throws ServiceException
	 */
	public void modificarHacerTest(HacerTest hacerTest) throws ServiceException{
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			HacerTestDAO hacerTestDAO = trans.getHacerTestDAO();
			hacerTestDAO.modificarHacerTest(hacerTest);


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
	
	/**
	 * Recupera un hacer test de la base de datos.
	 * @param hacerTest objeto hacer test de la base de datos
	 * @return
	 * @throws ServiceException
	 */
	public HacerTest recuperarHacerTest(HacerTest hacerTest) throws ServiceException{
		TransaccionesManager trans = null;

		try {
			trans = new TransaccionesManager();
			HacerTestDAO hacerTestDAO = trans.getHacerTestDAO();
			hacerTest = hacerTestDAO.recuperarHacerTest(hacerTest);


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
		return hacerTest;
	}


	/**
	 * Recupera todos los test desarrollados por un usuario
	 * @param usuario
	 * @return
	 * @throws ServiceException
	 */
	public List<HacerTest> recuperarTestDesarrollados(Usuario usuario) throws ServiceException {
		TransaccionesManager trans = null;
		List<HacerTest> list = new ArrayList<HacerTest>();
		try {

			trans = new TransaccionesManager();
			HacerTestDAO hacerTestDAO = trans.getHacerTestDAO();
			list = hacerTestDAO.recuperarTestDesarrollados(usuario);
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
