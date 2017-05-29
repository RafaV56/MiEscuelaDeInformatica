package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceHacerTest;
import service.ServicioTest;

import domain.HacerTest;
import domain.Test;
import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class EditarPerfil
 */
@WebServlet("/EditarPerfil")
public class EditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPerfil() {
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
		String resultado="/editarPerfil.jsp";
		
		Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
		
		List<HacerTest> testDesarrollados=null;
		ServiceHacerTest servicioHacerTest=null;
		//si el usuario no es válido no se puede ir a editar
		if (usuario==null) {
			request.getSession().invalidate();
			resultado="/Welcome";
		}else{
			try {
				// preguntar si tiene test respondidos
				servicioHacerTest = new ServiceHacerTest();
				testDesarrollados = servicioHacerTest.recuperarTestDesarrollados(usuario);
				//agrego los test a la sesion
				request.getSession().setAttribute("testDesarrollados", testDesarrollados);

			} catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			} catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
