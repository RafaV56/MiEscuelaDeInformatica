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

	public void insertarPregunta(Pregunta pregunta, Test test) {
		PreparedStatement st = null;
		try {
			//insert into preguntas(nombre_test,codigo_ejemplo,pregunta,a,b,c,d,e,correcta) values(?,?,?,?,?,?,?,?,?)"
			st = con.prepareStatement(DbQuery.getInsertarPregunta());
			
			st.setString(1, test.getNombre());
			if(pregunta.getCodigo_ejemplo()!=null){
				st.setString(2, pregunta.getCodigo_ejemplo());
			}else{
				st.setNull(2, Types.VARCHAR);
			}
			st.setString(3, pregunta.getPregunta());
			if(pregunta.getA()!=null){
				st.setString(4, pregunta.getA());
			}else{
				st.setNull(4, Types.VARCHAR);
			}
			if(pregunta.getB()!=null){
				st.setString(5, pregunta.getB());
			}else{
				st.setNull(5, Types.VARCHAR);
			}
			if(pregunta.getC()!=null){
				st.setString(6, pregunta.getC());
			}else{
				st.setNull(6, Types.VARCHAR);
			}
			if(pregunta.getD()!=null){
				st.setString(7, pregunta.getD());
			}else{
				st.setNull(7, Types.VARCHAR);
			}
			if(pregunta.getE()!=null){
				st.setString(8, pregunta.getE());
			}else{
				st.setNull(8, Types.VARCHAR);
			}
			st.setString(9, pregunta.getCorrecta());
				
			// ejecutamos el insert.			
			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == DbQuery.DUPLICATE_PK_MYSQL) {
				throw new DAOException("La pregunta está repetida");
			}else if (e.getErrorCode() == DbQuery.FK_REFERENCE_MYSQL) {
				throw new DAOException("El nombre del test no existe");
			}else{
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			
		}	
		
	}

}
