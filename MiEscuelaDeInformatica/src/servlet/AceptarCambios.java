package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

import service.ServiceUsuario;


/**
 * Servlet implementation class AceptarCambios
 */
@WebServlet(description = "Acepta los cambios enviados desde el formulario editarPerfil.jsp", urlPatterns = { "/AceptarCambios" })
public class AceptarCambios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceptarCambios() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado="/Welcome";
		//si el usuario no es válido no se puede ir a editar
		if (request.getSession().getAttribute("usuario")==null) {
			request.getSession().invalidate();
			resultado="/Welcome";
		}else{
			//parametros del formulario ediarPerfil.jsp
			String cambiarContrasena=request.getParameter("cambiarContrasena");	
			String nombre=request.getParameter("nombre");	
			String email=request.getParameter("email");	
			String edadString=request.getParameter("edad");
			int edad=0;
			String nick=request.getParameter("nick");	
			
			//recupero el usuario de la sesión
			HttpSession sesion=request.getSession();
			Usuario usuarioSesion=(Usuario) sesion.getAttribute("usuario");
		
			//Creamos el usuario y el servicio 
			Usuario usuarioModificar=null;
			ServiceUsuario servicioUsuario=null;
			
			//si quiere cambiar la contraseña 
			if (cambiarContrasena.equals("s")) {
				String contrasenaVieja=request.getParameter("contrasenaVieja");	
				String contrasena=request.getParameter("contrasena");	
				String rContrasena=request.getParameter("rContrasena");	
				
				try{			
					
					if (!contrasenaVieja.equals(usuarioSesion.getContrasena())) {
						throw new ServiceException("La contrasena antigua es incorrecta");
					}
					if (!contrasena.equals(rContrasena)) {
						throw new ServiceException("Las contraseñas nuevas no son iguales");
					}
					
					try {
						edad = Integer.parseInt(edadString);
					} catch (NumberFormatException e1) {
						throw new ServiceException("La edad no es correcta");
					}
					
					
					usuarioModificar=Usuario.crearUsuario(email, nombre, edad, nick, contrasena);
				
					//LLamamos al servicio de usuario para insertarlo
					servicioUsuario=new ServiceUsuario();
					
					//modificamos el usuario
					servicioUsuario.modificarUsuario(usuarioModificar);
									
					//cambiamos el usuario de la sesion por el nuevo
					usuarioModificar=servicioUsuario.recuperarUsuario(usuarioSesion);
					sesion.removeAttribute("usuario");
					sesion.setAttribute("usuario", usuarioModificar);
					
					//si todo fue bien regresamos a editarPerfil y escribimos que es todo correcto
					resultado="/editarPerfil.jsp";
					request.setAttribute("respuesta","El usuario se modificó correctamente");
					//cambiamos el nick de la barra superior
					sesion.removeAttribute("nickUsuario");
					sesion.setAttribute("nickUsuario", usuarioModificar.getNick());
				} catch (ServiceException e) {
					if(e.getCause()==null){
						request.setAttribute("error",e.getMessage());
						resultado="/editarPerfil.jsp";
					}else{
						e.printStackTrace();// para administrador
						request.setAttribute("error",e.getMessage());
						resultado="/editarPerfil.jsp";
					}
				}catch (DomainException e) {
					request.setAttribute("error", e.getMessage());
					resultado="/editarPerfil.jsp";
				}	
			}else{
				
				try{			
					try {
						edad = Integer.parseInt(edadString);
					} catch (NumberFormatException e1) {
						throw new ServiceException("La edad no es correcta");
					}
					String contrasena=usuarioSesion.getContrasena();
					usuarioModificar=Usuario.crearUsuario(email, nombre, edad, nick, contrasena);
				
					//LLamamos al servicio de usuario para insertarlo
					servicioUsuario=new ServiceUsuario();
					
					//modificamos el usuario
					servicioUsuario.modificarUsuario(usuarioModificar);
									
					//cambiamos el usuario de la sesion por el nuevo
					usuarioModificar=servicioUsuario.recuperarUsuario(usuarioSesion);
					sesion.removeAttribute("usuario");
					sesion.setAttribute("usuario", usuarioModificar);
					
					//si todo fue bien regresamos a editarPerfil y escribimos que es todo correcto
					resultado="/editarPerfil.jsp";
					request.setAttribute("respuesta","El usuario se modificó correctamente");
					//cambiamos el nick de la barra superior
					sesion.removeAttribute("nickUsuario");
					sesion.setAttribute("nickUsuario", usuarioModificar.getNick());
					
					
				} catch (ServiceException e) {
					if(e.getCause()==null){
						request.setAttribute("error",e.getMessage());
						resultado="/editarPerfil.jsp";
					}else{
						e.printStackTrace();// para administrador
						request.setAttribute("error",e.getMessage());
						resultado="/editarPerfil.jsp";
					}
				}catch (DomainException e) {
					request.setAttribute("error", e.getMessage());
					resultado="/editarPerfil.jsp";
				}
				
			}
			

		}
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
