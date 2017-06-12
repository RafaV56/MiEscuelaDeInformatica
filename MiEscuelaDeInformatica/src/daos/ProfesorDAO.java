package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recursos.DbQuery;
import recursos.Recursos;
import domain.Profesor;
import domain.Usuario;
import exceptions.DAOException;

/**
 * Actualiza la información de un Profesor sobre la BBDD
 * @author Pc
 *
 */
public class ProfesorDAO {
	
private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
	 */
	private Connection con;
	
	public ProfesorDAO(Connection con) {
		this.con=con;
	}

	/**
	 * Inserta un profesor
	 * @param profesor
	 * @param alumno
	 * @throws DAOException
	 */
	public void insertarProfesor(Profesor profesor)throws DAOException{
		PreparedStatement st = null;
		try {
			//insert into profesores(profesor,alumno) values(?,?)
			st = con.prepareStatement(DbQuery.getInsertarProfesor());
			st.setString(1, profesor.getProfesor().getEmail());
			st.setString(2, profesor.getAlumno().getEmail());
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("Ya tienes a este profesor asignado");
			}else if (e.getErrorCode()==DbQuery.FK_REFERENCE_MYSQL) {
				throw new DAOException("El profesor no existe");
			}else{
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
	}
	
	/**
	 * Recupera todos los profesores de un alumno
	 * @param alumno
	 * @return
	 * @throws DAOException
	 */
	public List<Profesor> recuperarProfesores(Usuario alumno)throws DAOException {
		PreparedStatement st = null;
		ResultSet rs =null ;
		List<Profesor> lista=null;
		
		Usuario profesor=null;
		Profesor profe=null;
		
			try {
				lista=new ArrayList<Profesor>();
				st = con.prepareStatement(DbQuery.getRecuperarProfesores());
				st.setString(1,alumno.getEmail());
				rs=st.executeQuery();
				while (rs.next()){
					String profesorEmail=rs.getString(1);
					profesor=new Usuario();
					profesor.setEmail(profesorEmail);
					profe=new Profesor(profesor, alumno);
					lista.add(profe);
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}
		return lista;
	}

	/**
	 * Recupera un profesor si el usuario lo es
	 * @param usuario
	 * @return
	 */
	public Profesor recuperarProfesor(Usuario usuario) {
		PreparedStatement st = null;
		ResultSet rs =null ;
		
		Profesor profe=null;
		Usuario profesor=null;
		
			try {
				st = con.prepareStatement(DbQuery.getRecuperarProfesor());
				st.setString(1,usuario.getEmail());
				rs=st.executeQuery();
				if (rs.next()){
					String profesorEmail=rs.getString(1);
					profesor=new Usuario();
					profesor.setEmail(profesorEmail);
					profe=new Profesor(profesor, usuario);
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}
		return profe;
	}

}
