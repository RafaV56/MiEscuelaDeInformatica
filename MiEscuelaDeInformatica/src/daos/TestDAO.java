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
	
	//crear insertar test***

}
