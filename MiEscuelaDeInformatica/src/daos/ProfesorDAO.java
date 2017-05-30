package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import recursos.DbQuery;
import recursos.Recursos;
import domain.Usuario;
import exceptions.DAOException;

public class ProfesorDAO {
	
private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
	 */
	private Connection con;
	
	public ProfesorDAO(Connection con) {
		this.con=con;
	}

	public void insertarProfesor(Usuario profesor,Usuario alumno)throws DAOException{
		PreparedStatement st = null;
		try {
			//insert into profesores(profesor,alumno) values(?,?)
			st = con.prepareStatement(DbQuery.getInsertarProfesor());
			st.setString(1, profesor.getEmail());
			st.setString(2, alumno.getEmail());
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("Ya tienes a este profesor asignado");
			}else if (e.getErrorCode()==DbQuery.FK_REFERENCE) {
				throw new DAOException("El profesor no existe");
			}else{
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}

}
