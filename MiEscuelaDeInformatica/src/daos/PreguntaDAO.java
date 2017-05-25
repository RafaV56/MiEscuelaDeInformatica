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

	public List<Pregunta> recuperarPreguntas(Test test){
		
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
					//SELECT codigo_ejemplo,pregunta,a,b,c,d,e,correcta FROM preguntas p where nombre_test=?
					String codigo_ejemplo=rs.getString(1);
					String pregunta=rs.getString(2);
					String a=rs.getString(3);
					String b=rs.getString(4);
					String c=rs.getString(5);
					String d=rs.getString(6);
					String e=rs.getString(7);
					String correcta=rs.getString(8);
					
					i=new Pregunta(codigo_ejemplo,pregunta, a, b, c, d, e, correcta); 
					
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
