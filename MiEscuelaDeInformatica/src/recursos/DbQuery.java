package recursos;

/**
 * Representa todas las sentencias necesarias en la aplicaci�n para usarlas en la capa DAO
 * @author Pc
 *
 */
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
	public static final int FK_REFERENCE_MYSQL = 1452;
	
	/**
	 * Variable para modificar un usuario por medio de su email. necesita todos los campos
	 */
	private static final String modificarUsuario = "update usuario set nombre=?, edad=?, nick=?, contrasena=? where email=?";
	/**
	 * Variable que recupera un test segun un nombre de test.
	 */
	private static final String recuperarTest = "SELECT nombre FROM test where nombre=?";
	
	/**
	 * Variable que recupera las preguntas seg�n un nombre de test, recupera la pregunta y sus respuestas de [a-e] y respuesta correcta
	 */
	private static final String recupearPreguntas = "SELECT codigo_ejemplo,pregunta,a,b,c,d,e,correcta FROM preguntas p where nombre_test=?";
	/**
	 * Inserta un hacer test a la base de datos, se necesita su email, nombre test, superado;
	 */
	private static final String insertarHacerTest = "insert into hacer_test(email,nombre_test,superado) values(?,?,?);";
	/**
	 * Recupera un hacer test se necesita el email y el nombre del test
	 */
	private static final String recuperarHacerTest = "SELECT email,nombre_test,superado FROM hacer_test where email=? and nombre_test=?";
	private static final String modificarHacerTest = "update hacer_test set superado=? where email=? and nombre_test=?";
	private static final String recuperarTestDesarrollados = "SELECT nombre_test,superado FROM hacer_test where email=?";
	private static final String insertaProfesor = "insert into profesores(profesor,alumno) values(?,?)";
	private static final String recuperarProfesores = "SELECT profesor,alumno FROM profesores where alumno=?";
	private static final String recuperarProfesor ="select distinct profesor from profesores where profesor=?";
	private static final String insertarTest = "insert into test(nombre,creado_por) values(?,?)";
	private static final String insertarPregunta = "insert into preguntas(nombre_test,codigo_ejemplo,pregunta,a,b,c,d,e,correcta) values(?,?,?,?,?,?,?,?,?)";
	private static final String recuperarTodosTestProfesor = "SELECT nombre FROM test where creado_por=?";
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
	
	/**
	 * Recupera todas las preguntas por el nombre de test
	 * @return
	 */
	public static String getPreguntas(){
		return recupearPreguntas;
	}

	/**
	 * Inserta un hacer test 
	 * @return
	 */
	public static String getInsertarHacerTest() {
		return insertarHacerTest;
	}

	/**
	 * Recupera un hacer test
	 * @return
	 */
	public static String getRecuperarHacerTest() {
		return recuperarHacerTest;
	}

	/**
	 * Modifica un hacer test en la base de datos, cambiando superado a s o n. se necesita su email, y nombre del test
	 * @return
	 */
	public static String getModificarHacerTest() {
		return modificarHacerTest;
	}

	/**
	 * Recupera todos los test de un usuario, se necesita solo su email, recupera el nombre del test y si es superado
	 * @return
	 */
	public static String getRecuperarTestDesarrollados() {
		return recuperarTestDesarrollados;
	}

	/**
	 * Inserta un profesor, se necesita el email del profesor y el email del alumno
	 * @return
	 */
	public static String getInsertarProfesor() {
		return insertaProfesor;
	}

	/**
	 * Recupera todos los profesores de un alumno
	 * @return
	 */
	public static String getRecuperarProfesores() {
		return recuperarProfesores;
	}

	/**
	 * Recupera un profesor si el usuario lo es
	 * @return
	 */
	public static String getRecuperarProfesor() {
		return recuperarProfesor;
	}

	/**
	 * Inseta un test
	 * @return
	 */
	public static String getInsertarTest() {
		return insertarTest;
	}

	/**
	 * Inserta una preguntas
	 * @return
	 */
	public static String getInsertarPregunta(){
		return insertarPregunta;
	}

	/**
	 * Recupera el nombre de todos los test creados por un profesor
	 * @return
	 */
	public static String getRecuperarTodosTestProfesor() {
		
		return recuperarTodosTestProfesor;
	}
	
}
