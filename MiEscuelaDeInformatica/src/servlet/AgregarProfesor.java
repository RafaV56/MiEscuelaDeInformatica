package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Profesor;
import domain.Usuario;
import service.ServiceProfesor;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class AgregarProfesor
 */
public class AgregarProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProfesor() {
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
		String resultado="/agregarProfesor.jsp";
		Usuario usuario=(Usuario) request.getSession().getAttribute("usuario");
		String emailProfe=request.getParameter("emailProfesor");
		
		if (usuario==null) {
			resultado="/Welcome";
		}else if (emailProfe!=null) {
			
			ServiceProfesor agregarProfe=null;
			try{
			Usuario profesor=new Usuario();
			profesor.setEmail(emailProfe.trim());
			
			Profesor profe=new Profesor(profesor, usuario);
			
				agregarProfe=new ServiceProfesor();
				agregarProfe.insertarProfesor(profe);
				//si todo va bien respondo
				request.setAttribute("respuesta","El profesor se inserto correctamente");
				
			}catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}
		}	
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
