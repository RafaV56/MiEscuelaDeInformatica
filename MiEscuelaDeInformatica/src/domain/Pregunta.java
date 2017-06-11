package domain;



import exceptions.DomainException;
import util.Validator;

/**
 * Reprasenta a una pregunta de un test
 * @author Pc
 *
 */
public class Pregunta {

	private String codigo_ejemplo;
	private String pregunta;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String valida;
	
	
	/**
	 * Retorna una pregunta validad en todos sus campos
	 * @param codigo_ejemplo
	 * @param pregunta
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param valida
	 * @return
	 */
	public static Pregunta crearPregunta(String codigo_ejemplo,String pregunta, String a, String b, String c, String d,
			String e, String valida){
		Pregunta pre=new Pregunta();
		
		pre.setCodigo_ejemplo(codigo_ejemplo);
		pre.setPregunta(pregunta);
        pre.setA(a);		
        pre.setB(b);
		pre.setC(c);
		pre.setD(d);
		pre.setE(e);
		pre.setValida(valida);		
		
		pre.validarPregunta();
		
		return pre;		
	}
	
	/**
	 * valida que la pregunta no sea nula y tenga dos respuestas mínimo, ademas de validar la respuesta 
	 */
	private void validarPregunta() {
		if (pregunta==null) {
			throw new DomainException("El campo pregunta no es válido");
		}
		int contador=0;
		
		if (a==null) {
			contador++;
		}
		if (b==null) {
			contador++;
		}
		if (c==null) {
			contador++;
		}
		if (d==null) {
			contador++;
		}
		if (e==null) {
			contador++;
		}
		
		if (contador>=4) {
			throw new DomainException("Mínimo debes tener dos respuestas");
		}
		
		//falta validar la respuesta correcta con con la valida
		
		
	}


	public Pregunta(){}
	
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
			String e, String valida) {
		this.codigo_ejemplo=codigo_ejemplo;
		this.pregunta = pregunta;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.valida = valida;
	}	
		
	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}
	public String getCodigo_ejemplo() {
		return codigo_ejemplo;
	}
	public String getCorrecta() {
		return valida;
	}
	public String getD() {
		return d;
	}
	public String getE() {
		return e;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setA(String a) {
		if(a==null || a.equals("")){
			this.a=null;
		}else if (Validator.length(a.trim(), 1, 250)) {
			this.a = a;
		}else{
			throw new DomainException("La respuesta (a) no es correcta, máximo 250 caracteres");
		}
	}
	public void setB(String b) {
		if(b==null || b.equals("")){
			this.b=null;
		}else if (Validator.length(b.trim(), 1, 250)) {
			this.b = b;
		}else{
			throw new DomainException("La respuesta (b) no es correcta, máximo 250 caracteres");
		}
	}
	public void setC(String c) {
		if(c==null || c.equals("")){
			this.c=null;
		}else if (Validator.length(c.trim(), 1, 250)) {
			this.c = c;
		}else{
			throw new DomainException("La respuesta (c) no es correcta, máximo 250 caracteres");
		}
	}
	public void setCodigo_ejemplo(String codigo_ejemplo) {
		if(codigo_ejemplo==null || codigo_ejemplo.equals("")){
			this.codigo_ejemplo=null;
		}else if (Validator.length(codigo_ejemplo.trim(), 1, 2000)) {
			this.codigo_ejemplo = codigo_ejemplo;
		}else{
			throw new DomainException("El código de ejemplo no es correcto, máximo 2000 caracteres");
		}
	}
	
	/**
	 * Si todo va bien la pregunta es correcta
	 * @param correcta
	 */
	public void setValida(String correcta) {
		if (correcta.equals("a")) {
			this.valida = correcta;
		} else if(correcta.equals("b")){
			this.valida = correcta;
		}else if(correcta.equals("c")){
			this.valida = correcta;
		}else if(correcta.equals("d")){
			this.valida = correcta;
		}else if(correcta.equals("e")){
			this.valida = correcta;
		}else{
			throw new DomainException("La respuesta no tiene un valor correcto");
		}
	}
	public void setD(String d) {
		if(d==null || d.equals("")){
			this.d=null;
		}else if (Validator.length(d.trim(), 1, 250)) {
			this.d = d;
		}else{
			throw new DomainException("La respuesta (d) no es correcta, máximo 250 caracteres");
		}
	}
	public void setE(String e) {
		if(e==null || e.equals("")){
			this.e=null;
		}else if (Validator.length(e.trim(), 1, 250)) {
			this.e = e;
		}else{
			throw new DomainException("La respuesta (e) no es correcta, máximo 250 caracteres");
		}
	}
	public void setPregunta(String pregunta) {
		if (Validator.length(pregunta.trim(), 1, 250)) {
			this.pregunta = pregunta;
		}else{
			throw new DomainException("La pregunta no es correcta, máximo 250 caracteres");
		}
		
	}
}
