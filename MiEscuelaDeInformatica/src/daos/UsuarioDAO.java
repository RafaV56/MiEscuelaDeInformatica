package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recursos.DbQuery;
import recursos.Recursos;
import domain.Usuario;
import exceptions.DAOException;

/**
 * Actualiza la información de un usuario sobre la BBDD
 * @author Pc
 *
 */
public class UsuarioDAO {
	private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
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
	
	
	/**
	 * Inserta un usuario validado a la base de datos
	 */
	public void insertarUsuario(Usuario usuario)throws DAOException{
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(DbQuery.getInsertarUsuario());
			st.setString(1, usuario.getEmail());
			st.setString(2, usuario.getNombre());
			st.setInt(3, usuario.getEdad());
			st.setString(4, usuario.getNick());
			st.setString(5, usuario.getContrasena());
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("El usuario ya existe");
			}else {
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}
	
	/**
	 * Modifica un usuario de la base de datos
	 * @param usuario Usuario válido con todos sus campos
	 */
	public void modificarUsuario(Usuario usuario){	
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(DbQuery.getModificarUsuario());
			//"update usuario set nombre=?, edad=?, nick=?, contrasena=? where email=?";
			st.setString(1, usuario.getNombre());
			st.setInt(2, usuario.getEdad());
			st.setString(3, usuario.getNick());
			st.setString(4, usuario.getContrasena());
			st.setString(5, usuario.getEmail());
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}

}
