package recursos;

public class DbQuery {

	/**
	 * Variable para la select de un usuario completo por su email.
	 */
	private static final String recuprarUsuario = "SELECT email,nombre,edad,nick,contrasena from usuario where email=?";
	/**
	 * Variable para insertar un usuario a la base de datos
	 */
	private static final String insertarUsuario = "insert into usuario values(?,?,?,?,?)";
	/**
	 * Error en la clave primaria de una base de datos de MY_SQL
	 */
	public static final int DUPLICATE_PK_MYSQL = 1062;

	/**
	 * Retorna la select de un usuario completo por su pk [email]
	 * @return select
	 */
	public static String getRecuperarUsuario() {
		
		return recuprarUsuario;
	}

	/**
	 * Retorna la select para insertar un usuario
	 * @return select para insertar el usuario
	 */
	public static String getInsertarUsuario() {
		return insertarUsuario;
	}
	
	

	
}
