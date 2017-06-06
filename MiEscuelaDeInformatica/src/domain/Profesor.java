package domain;

import java.util.List;

import exceptions.DomainException;

public class Profesor {
	
	private Usuario profesor;
	private Usuario alumno;
	List<Test> testProfesor; 
	
	
	/**
	 * Crea un profesor validado
	 * @param profesor
	 * @param alumno
	 * @param list  test creados por el profesor
	 * @return
	 */
	public static Profesor crearProfesor(Usuario profesor,Usuario alumno,List<Test> testProfe){
		Profesor profe=new Profesor();
		profe.setProfesor(profesor);
		profe.setAlumno(alumno);		
		profe.setTestProfesor(testProfe);
		
		return profe;
	}
	
	public Profesor() {
		super();
	}

	/**
	 * Crea un profesor sin validar, para crear desde la base de datos
	 * @param profesor
	 * @param alumno
	 */
	public Profesor(Usuario profesor, Usuario alumno) {
		super();
		this.profesor = profesor;
		this.alumno = alumno;
	}

	public Usuario getProfesor() {
		return profesor;
	}
	

	public List<Test> getTestProfesor() {
		return testProfesor;
	}

	public void setTestProfesor(List<Test> testProfesor) {
		this.testProfesor = testProfesor;
	}

	public void setProfesor(Usuario profesor) {
		if (profesor!=null) {
			this.profesor = profesor;
		}else {
 			throw new DomainException("El profesor no exite");
		}
	}

	public Usuario getAlumno() {
		return alumno;
	}

	public void setAlumno(Usuario alumno) {
		if (alumno!=null) {
			this.alumno = alumno;
		}else {
 			throw new DomainException("El alumno no exite");
		}
		
	}

}
