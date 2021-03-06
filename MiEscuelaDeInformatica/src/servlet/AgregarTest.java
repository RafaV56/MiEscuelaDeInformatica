package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProfesor;
import service.ServiceUsuario;

import domain.Profesor;
import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class AgregarTest
 */
@WebServlet("/AgregarTest")
public class AgregarTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarTest() {
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
		String resultado="/agregarTest.jsp";
		
		Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
		
		//llamamos al servicio Profesor para saber si el usuario es profesor
		ServiceProfesor servicioProfesor=null;
		Profesor profesor=null;
		
		if (usuario==null) {
			request.getSession().invalidate();
			resultado="/Welcome";
		}else{
			try {
				servicioProfesor = new ServiceProfesor();
				profesor=servicioProfesor.recuperarProfesor(usuario);
				
				//Si el profesor es null, el usuario no es profesor y se le envia el mensaje de error
				if (profesor==null) {
					request.setAttribute("error","No eres profesor");
				}
				
				//si todo va bien no hay errores
				
			} catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			} catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}			
			
		}
		
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
