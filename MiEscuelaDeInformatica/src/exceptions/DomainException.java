package exceptions;

/**
 * Clase excepci�n para la capa dominio
 * 
 * @author Rafael Vel�squez
 * 
 */
@SuppressWarnings("serial")
public class DomainException extends RuntimeException {

	/** Excepcion con mensaje */
	public DomainException(String message) {
		super(message);
	}

	/** Excepcion con mensaje y causa */
	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}

}
