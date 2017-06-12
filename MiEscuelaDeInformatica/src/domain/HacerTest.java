package domain;

import java.io.Serializable;

import util.Validator;
import exceptions.DomainException;

/**
 * Representa la información de un test al momento de ser corregido
 * @author Pc
 *
 */
public class HacerTest implements Serializable{
	
	/**
	 * Versión de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Usuario usuario;
	private TestCorregido testCorregido;
	private String superado;
	
	/**
	 * Retorna un hacerTest validado en todos los campos
	 * @param usuario
	 * @param testCorregido
	 * @param superado
	 * @return
	 */
	public static HacerTest recuperarHacerTest(Usuario usuario, TestCorregido testCorregido,
			String superado){
		HacerTest hacer=new HacerTest();
		
		hacer.setUsuario(usuario);
		hacer.setTestCorregido(testCorregido);
		hacer.setSuperado(superado);
		
		return hacer;
	}
	
	/**
	 * Constructor para cargar 
	 * @param usuario
	 * @param testCorregido
	 * @param superado
	 */
	public HacerTest(Usuario usuario, TestCorregido testCorregido,
			String superado) {
		super();
		this.usuario = usuario;
		this.testCorregido = testCorregido;
		this.superado = superado;
	}
	
	public HacerTest() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		if (usuario!=null) {
			this.usuario = usuario;
		} else {
			throw new DomainException("El usuario el nulo");
		}
	}
	public TestCorregido getTestCorregido() {
		return testCorregido;
	}
	public void setTestCorregido(TestCorregido testCorregido) {
		if (testCorregido!=null) {
			this.testCorregido = testCorregido;
		} else {
			throw new DomainException("El test corregido es nulo");
		}
	}
	public String getSuperado() {
		return superado;
	}
	public void setSuperado(String superado) {
		if (superado==null) {
			this.superado=null;
		}else if (Validator.length(superado, 1, 1)) {
			if (superado.equals("s")) {
				this.superado = superado;
			}else if (superado.equals("n")) {
				this.superado = superado;			
			}else {
				throw new DomainException("El campo superado no es [s] o [n]");
			}
		}else {
			throw new DomainException("El campo superado no es válido");
		}
		
	}
	
	
}
