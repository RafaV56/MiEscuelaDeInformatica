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
	 * Error en la clave ajena de una base de datos de MY_SQL
	 */
	public static final int FK_REFERENCE = 1452;
	
	/**
	 * Variable para modificar un usuario por medio de su email. necesita todos los campos
	 */
	private static final String modificarUsuario = "update usuario set nombre=?, edad=?, nick=?, contrasena=? where email=?";
	/**
	 * Variable que recupera un test segun un nombre de test, recuepra la pregunta y sus respuestas de [a-e] y respuesta correcta
	 */
	private static final String recuperarTest = "SELECT pregunta,a,b,c,d,e,correcta FROM preguntas p where nombre_test=?";

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

	/**
	 * retorna update para modificar un usuario
	 * @return update que modifica un usuario en todos sus campos por su email
	 */
	public static String getModificarUsuario() {
		return modificarUsuario;
	}
	
	/**
	 * Recupera un test de la base de datos, necesita saber el nombre del test
	 * @return todas las preguntas relacionadas con test
	 */
	public static String getTest() {
		return recuperarTest;
	}
	
	

	
}
