package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import recursos.DbQuery;
import recursos.Recursos;
import domain.HacerTest;
import domain.TestCorregido;
import domain.Usuario;
import exceptions.DAOException;

/**
 * Actualiza la información de quien hace un test sobre la BBDD
 * @author Pc
 *
 */
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
	

	/**
	 * Recupera una corrección de test de la base de datos se necesita el email y el nombre del test
	 * @param hacerTest
	 * @return
	 * @throws DAOException
	 */
	public HacerTest recuperarHacerTest(HacerTest hacerTest)throws DAOException {
		PreparedStatement st = null;
		ResultSet rs =null ;
		HacerTest test=null;
		
		Usuario usuario=null;
		TestCorregido testCorregido=null;
		
			try {
				usuario=hacerTest.getUsuario();
				testCorregido=hacerTest.getTestCorregido();
				//"SELECT email,nombre_test,superado FROM hacer_test where email=? and nombre_test=?";
				st = con.prepareStatement(DbQuery.getRecuperarHacerTest());
				st.setString(1,usuario.getEmail());
				st.setString(2,testCorregido.getNombreTest());
				rs=st.executeQuery();
				if (rs.next()){
					String superado=rs.getString(3);
					test=new HacerTest(usuario, testCorregido, superado); 
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}
		return test;
	}
	
	/**
	 * Modifica un hacer test de la base de datos, de superado s a no superado n
	 * @param hacerTest
	 */
	public void modificarHacerTest(HacerTest hacerTest){	
		PreparedStatement st = null;
		try {
			//update hacer_test set superado=? where email=? and nombre_test=?
			st = con.prepareStatement(DbQuery.getModificarHacerTest());
			st.setString(1, hacerTest.getSuperado());
			st.setString(2, hacerTest.getUsuario().getEmail());
			st.setString(3, hacerTest.getTestCorregido().getNombreTest());
	
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}

	/**
	 * Recupera todos test desarrollados por un usuario
	 * @param usuario usuario registrado en la aplicación
	 * @return todos los test realizados por el usuario
	 */
	public List<HacerTest> recuperarTestDesarrollados(Usuario usuario) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<HacerTest> list = new ArrayList<HacerTest>();
		try {
			st = con.prepareStatement(DbQuery.getRecuperarTestDesarrollados());
			st.setString(1, usuario.getEmail());
			rs = st.executeQuery();
			while (rs.next()) {
				TestCorregido testCorregido=new TestCorregido();
				testCorregido.setNombreTest(rs.getString(1));
				HacerTest  hacerTest = new HacerTest(usuario,testCorregido,rs.getString(2));
				
				list.add(hacerTest);
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
		}
		return list;
	}
}
