package daos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exceptions.*;

/**
 * Clase para controlar las transacciones con la base de datos
 * @author Rafael Velásquez
 *
 */
public class TransaccionesManager {

	private static final String DB_ERR = "Error de la base de datos";
	private static final String DB_CON_ERR = "Error al conectar con la base de datos";

	private Connection con;

	// para  obtener la conexión del pool de conexiones, ver WEB.xml
	public TransaccionesManager() throws ServiceException {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/Pericodelospalotes");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			throw new ServiceException(DB_ERR, e);
		} catch (NamingException e) {
			throw new ServiceException(DB_CON_ERR, e);
		}
	}
	
	/**
	 * Cierra una conexión y hace commit
	 * @throws DAOException
	 */
	public void closeCommit()throws DAOException  {
		try {
			if(con!=null){
				con.commit();
				con.close();
			}
		} catch (SQLException e) {
			throw new DAOException (DB_ERR, e);
		}
	}
	
	/**
	 * Realiza un commit en la pero sin cerrar la conexión
	 * @throws DAOException
	 */
	public void commit()throws DAOException  {
		try {
			if(con!=null){
				con.commit();

			}
		} catch (SQLException e) {
			throw new DAOException (DB_ERR, e);
		}
	}
	
	/**
	 * Cierra la conexión y hace un rollback
	 * @throws DAOException
	 */
	public void closeRollback() throws DAOException {
		try {
			if(con!=null){
				con.rollback();
				con.close();
			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}
	
	/**
	 * Hace un rollback pero sin cerrar la conexión
	 * @throws DAOException
	 */
	public void rollback() throws DAOException {
		try {
			if(con!=null){
				con.rollback();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}
	
	/**
	 * Cierra la conexión
	 * @throws DAOException
	 */
	public void close() throws DAOException {
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}
	/**
	 * Retorna la conexión
	 * @return
	 */
	public Connection getConexion() {

		return con;
	}

	/**
	 * Retronar un usuarioDAO
	 * @return
	 */
	public UsuarioDAO getUsuarioDAO() {
		
		return new UsuarioDAO(con);
	}

	public TestDAO getTestDAO() {
	
		return new TestDAO(con);
	}

	public PreguntaDAO getPreguntaDAO() {
		
		return new PreguntaDAO(con);
	}

	public HacerTestDAO getHacerTestDAO() {

		return new HacerTestDAO(con);
	}

	public ProfesorDAO getProfesorDAO() {
		return new ProfesorDAO(con);
	}



}
