package domain;

import java.util.List;

import exceptions.DomainException;

import util.Validator;

public class Test {
	/**
	 * El nombre del test debe tener 1-50 caracteres
	 */
	private String nombre;
	private Usuario creadoPor;
	
	private List<Pregunta> preguntas;
	
	/**
	 * Constructo sin parametros para usar en otros constructores
	 */
	public Test(){}
	
	
	/**
	 * Crea un test validado, con el nombre y el usuario
	 * @param nombre
	 * @param creadoPor
	 */
	public static Test crearTest(String nombre, Usuario creadoPor) {
		Test test=new Test();
		test.setNombre(nombre);
		test.setCreadoPor(creadoPor);
		return test;
	}



	/**
	 * Retorna un Test a partir de su nombre validado
	 * @param nombre
	 * @return
	 */
	public static Test crearTest(String nombre){
		Test test=new Test();
		
		test.setNombre(nombre);
		
		return test;
	}
	
	/**
	 * Contructor para recupera un test de la base de datos por su nombre
	 * @param nombre
	 */
	public Test(String nombre) {
		this.nombre = nombre;
	}

	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		if (Validator.length(nombre, 1, 50) ) {
			this.nombre = nombre;
		}else{
			throw new DomainException("El nombre del test no es correcto");
		}
	}
	public List getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List preguntas) {
		this.preguntas = preguntas;
	}
	
	
	public Usuario getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Usuario creadoPor) {
		if (creadoPor!=null) {
			this.creadoPor = creadoPor;
		} else {
			throw new DomainException("El creador del test no exite");
		}
		
	}
}
