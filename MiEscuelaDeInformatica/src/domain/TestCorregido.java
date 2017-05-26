package domain;

public class TestCorregido {
	
	private String tema;
	private String tecnologia;
	private String nombreTest;
	private boolean superado;
	/**
	 * Agregar un error cuando el test fuera null
	 */
	private String error;
	/**
	 * Preguntas acertadas correctamente
	 */
	private int correctas;
	/**
	 * Errores al contestar las preguntas de un test
	 */
	private int errores;
	
	/**
	 * Constructor sin par�metros
	 */
	public TestCorregido() {}
	/**
	 * Test completo sus campos pueden ser nulos
	 * @param tema
	 * @param tecnologia
	 * @param nombreTest
	 * @param superado
	 * @param error
	 * @param correctas
	 * @param errores
	 */
	public TestCorregido(String tema, String tecnologia, String nombreTest,
			boolean superado, String error, int correctas, int errores) {
		super();
		this.tema = tema;
		this.tecnologia = tecnologia;
		this.nombreTest = nombreTest;
		this.superado = superado;
		this.error = error;
		this.correctas = correctas;
		this.errores = errores;
	}
	/**
	 * Tema de la tecnolog�a
	 * @return
	 */
	public String getTema() {
		return tema;
	}
	/**
	 * Agregar el tema de la tecnolog�a
	 * @param tema
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * Tecnolog�a a del test
	 * @return
	 */
	public String getTecnologia() {
		return tecnologia;
	}

	/**
	 * Tecnologia a tratar
	 * @param tecnologia nombre de la tecnolog�a
	 */
	public void setTecnologia(String tecnologia) {
		this.tecnologia = capitalize(tecnologia);
	}

	public String getNombreTest() {
		return nombreTest;
	}
	/**
	 * Nombre del test a corregir
	 * @param nombreTest
	 */
	public void setNombreTest(String nombreTest) {
		this.nombreTest = nombreTest;
	}
	/**
	 * Retorna true si es superado
	 * @return
	 */
	public boolean isSuperado() {
		return superado;
	}
	/**
	 * Si a superado el test agregar true
	 * @param superado
	 */
	public void setSuperado(boolean superado) {
		this.superado = superado;
	}
	/**
	 * Retorna el mensaje de error de una correcci�n, generalmente el test es null
	 * @return
	 */
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * Respuesta correctas del test
	 * @return
	 */
	public int getCorrectas() {
		return correctas;
	}
	public void setCorrectas(int correctas) {
		this.correctas = correctas;
	}
	/**
	 * Respuestas erroneas del test
	 * @return
	 */
	public int getErrores() {
		return errores;
	}
	public void setErrores(int errores) {
		this.errores = errores;
	}

	/**
	 * Letra capital a una palabra
	 * @param s
	 * @return
	 */
	private String capitalize(String s) {
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	@Override
	public String toString() {
		return "TestCorregido [tema=" + tema + ", tecnologia=" + tecnologia
				+ ", nombreTest=" + nombreTest + ", superado=" + superado
				+ ", error=" + error + ", correctas=" + correctas
				+ ", errores=" + errores + "]";
	}

}