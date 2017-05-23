package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recursos.DbQuery;
import recursos.Recursos;

import domain.Pregunta;
import domain.Test;
import exceptions.DAOException;

public class PreguntaDAO {
	
	private static final String DB_ERR = "Error de la base de datos";
	
	/**
	 * conexión a la base de datos
	 */
	private Connection con;
	
	public PreguntaDAO(Connection con) {
		this.con = con;
	}

	public List<Pregunta> recuperarPregunta(Test test){
		
		List<Pregunta> preguntas=null;
		PreparedStatement st = null;
		ResultSet rs =null ;
		Pregunta i=null;		
			try {
				preguntas=new ArrayList<Pregunta>();
				st = con.prepareStatement(DbQuery.getPreguntas());
				st.setString(1,test.getNombre());
				rs=st.executeQuery();
				while (rs.next()){

					String pregunta=rs.getString(1);
					String a=rs.getString(2);
					String b=rs.getString(3);
					String c=rs.getString(4);
					String d=rs.getString(5);
					String e=rs.getString(6);
					String correcta=rs.getString(7);
					
					i=new Pregunta(pregunta, a, b, c, d, e, correcta); 
					
					preguntas.add(i);
				}		

			} catch (SQLException e) {
				throw new DAOException(DB_ERR, e);
			} finally {
			Recursos.closeResultSet(rs);
			Recursos.closePreparedStatement(st);
			
		}		
		return preguntas;		
	}

}
