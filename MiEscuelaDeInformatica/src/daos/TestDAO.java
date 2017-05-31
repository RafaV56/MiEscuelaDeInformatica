package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recursos.DbQuery;
import recursos.Recursos;

import domain.Test;
import exceptions.DAOException;

public class TestDAO {
	
	private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
	 */
	private Connection con;

	/**
	 * Contructro para usar desde transaccionesManager
	 * @param con conexion a la base de datos
	 */
	public TestDAO(Connection con) {
		this.con = con;
	}
	
	/**
	 * Recupera un test por su nombre
	 * @param test
	 * @return
	 */
	public Test recuperarTest(Test test){
		PreparedStatement st = null;
		ResultSet rs =null ;
		Test i=null;
		
			try {
				st = con.prepareStatement(DbQuery.getTest());
				st.setString(1,test.getNombre());
				rs=st.executeQuery();
				if (rs.next()){
					String nombre=rs.getString(1);
					i=new Test(nombre); 
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}
		return i;
		
		
	}
	
	/**
	 * Inserta un test en la base de datos
	 * @param test
	 */
	public void insertarTest(Test test){
		PreparedStatement st = null;
		try {
			//insert into test(nombre,creado_por) values(?,?)
			st = con.prepareStatement(DbQuery.getInsertarTest());
			st.setString(1, test.getNombre());
			st.setString(2, test.getCreadoPor().getEmail());
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("El Test ya existe, intenta otro nombre");
			}else if (e.getErrorCode() == DbQuery.FK_REFERENCE_MYSQL) {
				throw new DAOException("El usuario creador del test no existe");
			}else {
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}

}
