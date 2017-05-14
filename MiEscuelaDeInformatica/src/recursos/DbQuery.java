package recursos;

public class DbQuery {

	/**
	 * Variable para la select de un usuario completo por su email.
	 */
	private static final String usuario = "SELECT email,nombre,edad,nick,contrasena from usuario where email=?";

	/**
	 * Retorna la select de un usuario completo por su pk [email]
	 * @return select
	 */
	public static String getRecuperarUsuario() {
		
		return usuario;
	}
	
	

	
}
