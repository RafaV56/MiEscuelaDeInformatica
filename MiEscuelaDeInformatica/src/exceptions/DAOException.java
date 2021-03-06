package exceptions;

/**
 * Clase de excepcion para la capa de acceso a persistencia (base de datos)
 * 
 * @author Rafael Vel�squez
 *
 */
@SuppressWarnings("serial")
public class DAOException extends RuntimeException {

	/** Excepcion con mensaje */
	public DAOException(String message) {
		super(message);
	}

	/** Excepcion con mensaje y causa */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
