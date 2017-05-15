package domain;

import util.Validator;
import exceptions.DomainException;

public class Usuario {
	
	/**
	 * Devuelve un usuario a partir de su email
	 * @param email
	 * @return usuario
	 */
	public static Usuario crearUsuario(String email){
		Usuario usuario=new Usuario();
		
		usuario.setEmail(email);
		
		return usuario;
	}
	/**
	 * Crea un usuario validado en todos sus campos.
	 * @param email
	 * @param nombre
	 * @param edad
	 * @param contrasena
	 * @return usuario validado
	 */
	public static Usuario crearUsuario(String email, String nombre, int edad,String nick, String contrasena){
		Usuario usuario=new Usuario();
		usuario.setEmail(email);
		usuario.setNombre(nombre);
		usuario.setEdad(edad);
		usuario.setNick(nick);
		usuario.setContrasena(contrasena);
		
		return usuario;
	}
	
	
	private String contrasena;
	private int edad;
	private String email;	
	private String nick;
	private String nombre;

	/**
	 *Crea un usuario para usar dentro de otros constructores
	 */
	public Usuario(){}
	
	/**
	 * Crea un usuario sin validar sus datos. para crear objetos con datos de la base de datos
	 * @param email
	 * @param nombre
	 * @param edad
	 * @param contrasena
	 */
	public Usuario(String email, String nombre, int edad,String nick, String contrasena) {
		this.email = email;
		this.nombre = nombre;
		this.edad = edad;
		this.nick=nick;
		this.contrasena = contrasena;
	}
	/**
	 * Retorna la contraseña del usuario
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * Retorna le edad del usuario
	 * @return
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Retorna el email del usuario
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Agrega el nick del usuario
	 * @return
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * retorna el nombre del usuario
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Valida la contraseña del usuario de 1 a 10 caracteres
	 * @param contrasena del usuario
	 */
	public void setContrasena(String contrasena) {
		if (Validator.length(contrasena.trim(), 1, 10)) {
			this.contrasena = contrasena;
		} else {
			throw new DomainException("La longitud de la contraseña no es correcta");
		}
		
	}

	/**
	 * Valida la edad del usuario, entre 7 y 120 años
	 * @param edad del usuario
	 */
	public void setEdad(int edad) {
		if(Validator.enteros(edad, 7, 120)){
			this.edad = edad;
		}else{
			throw new DomainException("La edad no es correcta, mínimo 7 y máximo 120 años");
		}
		
		
	}
	
	/**
	 * Valida el email, de 1 a 50 caracteres y que no sea nulo
	 * @param email email del usuario que es su clave primaria
	 */
	public void setEmail(String email) {
		
		if (Validator.length(email.trim(), 1, 50)) {
			this.email = email;
		} else {
			throw new DomainException("La longitud del email no es correcta");
		}
	}

	/**
	 * Válida el nick del usuario
	 * @param nick
	 */
	public void setNick(String nick) {
		if (Validator.length(nick.trim(), 1, 50)) {
			this.nick = nick;
		} else {
			throw new DomainException("La longitud de la contraseña no es correcta");
		}
	}
	

	/**
	 * Valida el nombre, de 1 a caracteres y que no sea nulo
	 * @param nombre nombre real del usuario
	 */
	public void setNombre(String nombre) {
		if (Validator.length(nombre.trim(), 1, 50)) {
			this.nombre = nombre;
		} else {
			throw new DomainException("La longitud del nombre no es correcta");
		}
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", edad="
				+ edad + ", contrasena=" + contrasena + "]";
	}
}
// hacer el servlet agregarUsuario y probar que llegen los datos correctamente
