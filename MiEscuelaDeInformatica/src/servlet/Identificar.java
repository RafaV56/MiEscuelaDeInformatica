package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Usuario usuario=null;
		String email=null;
		String contrasena=null;
		//String recuerdame=null;
		ServiceUsuario serviceUsuario=null;
		try {
			email=request.getParameter("emailUsuario");
			contrasena=request.getParameter("contrasena");
			System.out.println("email:"+email+" contrasena: "+contrasena);	
			usuario=Usuario.crearUsuario(email);
			
			serviceUsuario=new ServiceUsuario();
			
			usuario=serviceUsuario.recuperarUsuario(usuario);
			
			System.out.println(usuario);
			
			
			
			
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
		}catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
		}
				
				
		//System.out.println("entro en indentificar");
		
		getServletContext().getRequestDispatcher(resultado).forward(request, response);//Error Lógico para usuario
	}

}
