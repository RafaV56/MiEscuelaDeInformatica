package domain;

import java.util.List;

import exceptions.DomainException;

import util.Validator;

public class Test {
		/**
	 * El nombre del test debe tener 1-50 caracteres
	 */
	private String nombre;
		private List preguntas;
	
	/**
	 * Constructo sin parametros para usar en otros constructores
	 */
	public Test(){}
	
	/**
	 * Retorna un Test a partir de su nombre
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
		if (nombre==null) {
			this.nombre=nombre;
		}else if (Validator.length(nombre, 1, 50) ) {
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
	
	@Override
	public String toString() {
		return "Test [nombre=" + nombre + ", preguntas=" + preguntas + "]";
	}

}
