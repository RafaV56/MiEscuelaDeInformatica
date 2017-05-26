package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import recursos.DbQuery;
import recursos.Recursos;
import domain.HacerTest;
import domain.Test;
import domain.TestCorregido;
import domain.Usuario;
import exceptions.DAOException;

public class HacerTestDAO {
	
	private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
	 */
	private Connection con;

	public HacerTestDAO(Connection con) {
		this.con = con;
	}
	
	/**
	 * Inserta un usuario validado a la base de datos
	 */
	public void insertarHacerTest(HacerTest hacerTest)throws DAOException{
		PreparedStatement st = null;
		
		Usuario usu=null;
		TestCorregido test=null;
		//si el test a sido superado es s
		
		try {
			usu=hacerTest.getUsuario();
			test=hacerTest.getTestCorregido();
			
			//insert into hacer_test(email,nombre_test,superado) values('rafael@hotmail.com','java-identificadores','n');
			st = con.prepareStatement(DbQuery.getInsertarHacerTest());
			st.setString(1, usu.getEmail());
			st.setString(2, test.getNombreTest());
			if (hacerTest.getSuperado()!=null) {
				st.setString(3, hacerTest.getSuperado());
			} else {
				st.setNull(3, Types.VARCHAR);
			}
			
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("La corrección del test ya existe");
			}else {
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}
	
	//Hacer recupearar test********************

}
