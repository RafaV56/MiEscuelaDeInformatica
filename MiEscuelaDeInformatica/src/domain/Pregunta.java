package domain;

import exceptions.DomainException;
import util.Validator;

public class Pregunta {

	private String codigo_ejemplo;
	private String pregunta;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String correcta;
	
	/**
	 * Contructor para recuperar una pregunta de la base de datos
	 * @param pregunta 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param correcta
	 */
	public Pregunta(String codigo_ejemplo,String pregunta, String a, String b, String c, String d,
			String e, String correcta) {
		this.codigo_ejemplo=codigo_ejemplo;
		this.pregunta = pregunta;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.correcta = correcta;
	}	
		
	public String getCodigo_ejemplo() {
		return codigo_ejemplo;
	}

	public void setCodigo_ejemplo(String codigo_ejemplo) {
		if (Validator.length(codigo_ejemplo, 1, 2000)) {
			this.codigo_ejemplo = codigo_ejemplo;
		}else{
			throw new DomainException("El código de ejemplo no es correcto, máximo 2000 caracteres");
		}
	}

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
	}

	@Override
	public String toString() {
		return "Pregunta [codigo_ejemplo=" + codigo_ejemplo + ", pregunta="
				+ pregunta + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", e=" + e + ", correcta=" + correcta + "]";
	}
	

	
}
