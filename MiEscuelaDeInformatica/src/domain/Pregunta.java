package domain;

import exceptions.DomainException;
import util.Validator;

public class Pregunta {

	private String pregunta;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String correcta;
	
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		if (Validator.length(pregunta, 1, 250)) {
			this.pregunta = pregunta;
		}else{
			throw new DomainException("La pregunta no es correcta, máximo 250 caracteres");
		}
		
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getCorrecta() {
		return correcta;
	}
	public void setCorrecta(String correcta) {
		if (correcta.equals("a")) {
			this.correcta = correcta;
		} else if(correcta.equals("b")){
			this.correcta = correcta;
		}else if(correcta.equals("c")){
			this.correcta = correcta;
		}else if(correcta.equals("d")){
			this.correcta = correcta;
		}else if(correcta.equals("e")){
			this.correcta = correcta;
		}else{
			throw new DomainException("La respuesta no tiene un valor correcto");
		}
		//seguir creando los domain ************************************
	}	
}
