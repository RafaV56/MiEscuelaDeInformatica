package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import exceptions.ServiceException;

import service.ServiceUsuario;

/**
 * Servlet implementation class AgregarUsuario
 */
@WebServlet("/AgregarUsuario")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarUsuario() {
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
		String nombre=(String)request.getParameter("nombre");
		String email=(String)request.getParameter("email");
		String edad=(String)request.getParameter("edad");
		String nick=(String)request.getParameter("nick");
		String contrasena=(String)request.getParameter("contrasena");
		System.out.println("Nombre: "+nombre+" Email: "+email+" Edad: "+edad+" Nick: "+nick+" Contraseña: "+contrasena);
		
		ServiceUsuario serviceUsuario=new ServiceUsuario();
		Usuario usu=null;
		try {
			 usu=serviceUsuario.recuperarUsuario(new Usuario("rafaelvelasquez@gmail.com","rafael",32,"55","nadie"));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Nombre: "+usu.getNombre()+" Email: "+usu.getEmail()+" Edad: "+usu.getEdad()+" Nick: "+usu.getNick()+" Contraseña: "+usu.getContrasena());
		
		getServletContext().getRequestDispatcher("/registra.jsp").forward(request, response);
	}

}
