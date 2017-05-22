package domain;

import java.util.List;

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
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if (nombre==null) {
			this.nombre=nombre;
		}else if (Validator.length(nombre, 1, 50) ) {
			this.nombre = nombre;
		}
	}
	public List getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List preguntas) {
		this.preguntas = preguntas;
	}

}
