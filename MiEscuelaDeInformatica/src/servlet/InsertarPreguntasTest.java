package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceProfesor;
import service.ServicioTest;
import domain.Profesor;
import domain.Test;
import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class InsertarPreguntasTest
 */
@WebServlet("/InsertarPreguntasTest")
public class InsertarPreguntasTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarPreguntasTest() {
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
		String resultado="/insertarPreguntasTest.jsp";
		
		Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
		String nombreTest=request.getParameter("nombreTest");
		//llamamos al servicio Profesor para saber si el usuario es profesor
		ServiceProfesor servicioProfesor=null;
		Profesor profesor=null;
		
		//Llamamos al servicio test para insertar el test
		ServicioTest servicioTest=null;
		Test test=null;
		
		if (usuario==null) {
			request.getSession().invalidate();
			resultado="/Welcome";
		}else{
			try {
				servicioProfesor = new ServiceProfesor();
				profesor=servicioProfesor.recuperarProfesor(usuario);
				
				//Si no es profesor se enviar al controlador de agregar test
				if (profesor==null) {
					resultado="/AgregarTest";
				//Si el nombre del test es nulo o vacio se envia el error	
				}else if (nombreTest==null || nombreTest.equals("")) {
					request.setAttribute("error","El nombre del test está vacio, intentalo de nuevo");
					resultado="/agregarTest.jsp";
				}else{
					//ahora recuperamos el test de la base de datos
					servicioTest=new ServicioTest();
					test=Test.crearTest(nombreTest, usuario);
					Test testBBDD=servicioTest.recuperarTest(test);
					//si el test es nullo no existe
					if (testBBDD==null) {
						request.setAttribute("error","El test con el nombre: "+nombreTest+" no exite, Créalo primero en el panel superior");
						resultado="/agregarTest.jsp";
					}else{
						//si todo va bien, agregamos el test a la sesion y vamos a insertarRepuesta.jsp
						request.getSession().setAttribute("test", test);
					}
				}

			} catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			} catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}			
			
		}
		
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
