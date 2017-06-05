package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProfesor;
import service.ServiceUsuario;
import service.ServicioTest;
import domain.Profesor;
import domain.Test;
import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class VerProfesores
 */
@WebServlet("/VerProfesores")
public class VerProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerProfesores() {
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
		String resultado="/verProfesores.jsp";
		
		Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
		
		List<Profesor> profesores=null;
		ServiceProfesor servicioProfesor=null;
		ServiceUsuario servicioUsuario=null;
		
		//servicio para ver los test del profesor y pintarlos en su descripción
		ServicioTest servicioTest=null;
		List<Test> listaTest=null;
		
		//si el usuario no es válido no se puede ir a editar
		if (usuario==null) {
			request.getSession().invalidate();
			resultado="/Welcome";
		}else{
			try {
				//Recupero todos los profesores del usuario
				servicioProfesor = new ServiceProfesor();
				profesores = servicioProfesor.recuperarTodosProfesores(usuario);
				
				//Servicio para añadir datos del profesor 
				servicioUsuario=new ServiceUsuario();
				Usuario usu=null;
				
				for (Profesor profesor : profesores) {
					usu=servicioUsuario.recuperarUsuario(profesor.getProfesor());
					profesor.getProfesor().setNick(usu.getNick());
					profesor.getProfesor().setNombre(usu.getNombre());
					
					//Recupero sus test si tiene
					servicioTest=new ServicioTest();
					listaTest=servicioTest.recuperarTodosTestProfesor(profesor);
					profesor.setTestProfesor(listaTest);				
				}
							
				//agrego los profesores a la sesion
				request.getSession().setAttribute("profesores", profesores);

			} catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			} catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);

	}

}
