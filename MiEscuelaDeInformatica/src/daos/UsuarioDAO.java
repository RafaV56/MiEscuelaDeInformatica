package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recursos.DbQuery;
import recursos.Recursos;
import domain.Usuario;
import exceptions.DAOException;

public class UsuarioDAO {
	private static final String DB_ERR = "Error de la base de datos";

	public static final int ORACLE_DUPLICATE_PK = 1;
	private static final int ORACLE_DELETE_FK = 2292;
	private static final int ORACLE_FALLO_FK = 2291;
	
	/**
	 * conexi�n a la base de datos
	 */
	private Connection con;

	public UsuarioDAO(Connection con) {
		this.con = con;
	}
	
	
	/**
	 * Recupera un usuario de la base de datos, se necesita un usuario con el email verificado
	 * @param usuario
	 * @return usuario completo
	 * @throws DAOException
	 */
	public Usuario recuperarUsuario(Usuario usuario)throws DAOException {
		PreparedStatement st = null;
		ResultSet rs =null ;
		Usuario i=null;
		
			try {
				st = con.prepareStatement(DbQuery.getRecuperarUsuario());
				st.setString(1,usuario.getEmail());
				rs=st.executeQuery();
				if (rs.next()){
					String email=rs.getString(1);
					String nombre=rs.getString(2);
					int edad=rs.getInt(3);
					String nick=rs.getString(4);
					String contrasena=rs.getString(5);
					i=new Usuario(email, nombre, edad, nick, contrasena); 
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}
		return i;
	}

}
