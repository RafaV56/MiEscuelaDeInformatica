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

	// para  octener la conexion del pool de conexiones, ver WEB.xml
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
//	
//	public void closeCommit()throws DAOException  {
//		try {
//			if(con!=null){
//				con.commit();
//				con.close();
//			}
//
//
//		} catch (SQLException e) {
//			throw new DAOException (DB_ERR, e);
//		}
//	}
//	public void commit()throws DAOException  {
//		try {
//			if(con!=null){
//				con.commit();
//
//			}
//
//
//		} catch (SQLException e) {
//			throw new DAOException (DB_ERR, e);
//		}
//	}
//	public void closeRollback() throws DAOException {
//		try {
//			if(con!=null){
//				con.rollback();
//				con.close();
//			}
//
//		} catch (SQLException e) {
//			throw new DAOException(DB_ERR, e);
//		}
//	}
//	public void rollback() throws DAOException {
//		try {
//			if(con!=null){
//				con.rollback();
//
//			}
//
//		} catch (SQLException e) {
//			throw new DAOException(DB_ERR, e);
//		}
//	}
//	public void close() throws DAOException {
//		try {
//			if(con!=null){
//				con.close();
//
//			}
//
//		} catch (SQLException e) {
//			throw new DAOException(DB_ERR, e);
//		}
//		// TODO Auto-generated method stub
//
//	}
//	public Connection getConexion() {
//
//		return con;
//	}
//
//	public ClienteDAO getClienteDAO() {
//		return new ClienteDAO(con);
//	}
//	public IvaDAO getIvaDAO() {
//		return new IvaDAO(con);
//
//	}
//	public FormaPagoDAO getFormaPagoDAO() {
//		return new FormaPagoDAO(con);
//
//	}
//	public TarifaDAO getTarifaDAO() {
//		return new TarifaDAO(con);
//
//	}
//	public daos.ProveedorDAO getProveedorDAO() {
//		// TODO Auto-generated method stub
//		return new ProveedorDAO(con);
//	}
//	public daos.ArticuloDAO getArticuloDAO() {
//		// TODO Auto-generated method stub
//		return new ArticuloDAO(con);
//	}
//	public daos.FamiliaDAO getFamiliaDAO() {
//		// TODO Auto-generated method stub
//		return new FamiliaDAO(con);
//	}
//	public daos.ExistenciaDAO getExistenciaDAO() {
//		// TODO Auto-generated method stub
//		return  new ExistenciaDAO(con);
//	}
//	public daos.AlmacenDAO getAlmacenDAO() {
//		// TODO Auto-generated method stub
//		return new AlmacenDAO(con);
//	}
//	//pedidos
//	public PedidoDAO getPedidoDAO() {
//		// TODO Auto-generated method stub
//		return new PedidoDAO(con);
//	}
//	// LinPed
//	public LinPedDAO getLinPedDAO() {
//		// TODO Auto-generated method stub
//		return new LinPedDAO(con);
//	}
//
//
//	public AlbaranDAO getAlbaranDAO() {
//		// TODO Auto-generated method stub
//		return new AlbaranDAO(con);
//	}
//	public LinAlbDAO getLinAlbDAO() {
//		// TODO Auto-generated method stub
//		return new LinAlbDAO(con);
//	}
//	public ContadorFactDAO getContadorFactDAO() {
//		// TODO Auto-generated method stub
//		return new ContadorFactDAO(con);
//	}
//	public FacturaDAO getFacturaDAO() {
//		// TODO Auto-generated method stub
//		return new FacturaDAO(con);
//	}
//	public ReciboDAO getReciboDAO() {
//		// TODO Auto-generated method stub
//		return new ReciboDAO(con);
//	}
//
//



}
