package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceUsuario;

import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class Identificar
 */
@WebServlet("/Identificar")
public class Identificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Identificar() {
        super();
        // TODO Auto-generated constructor stub
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
		String resultado="/perfil.jsp";
		
		request.getSession().setAttribute("barra", "registrar");
		
		Usuario usuario=null;
		String email=null;
		String contrasena=null;
		//String recuerdame=null;
		ServiceUsuario serviceUsuario=null;
		try {
			email=request.getParameter("emailUsuario");
			contrasena=request.getParameter("contrasena");
			//System.out.println("email:"+email+" contrasena: "+contrasena);	
			usuario=Usuario.crearUsuario(email);
			
			serviceUsuario=new ServiceUsuario();
			
			//Creo un usuario de la base de datos
			usuario=serviceUsuario.recuperarUsuario(usuario);
			
			if (usuario==null) {
				request.setAttribute("error","El email de usuario no es válido");

			}else{
				if (!usuario.getContrasena().equals(contrasena)) {
					request.setAttribute("error", "Contraseña invalida");
				}else{
					//Es una continuación de una sesión existente o si es una nueva sesión.
					HttpSession session=request.getSession();// igual que true
					//asignar atributos a las sesión
					session.setAttribute("usuario", usuario);
					session.setAttribute("nickUsuario", usuario.getNick());
					session.setMaxInactiveInterval(30*60);
					
				}
			}
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
		}catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
		}
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);//Error Lógico para usuario
	}

}
