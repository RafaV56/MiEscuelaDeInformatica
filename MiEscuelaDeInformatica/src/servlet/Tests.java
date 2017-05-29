package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Test;

import exceptions.DomainException;
import exceptions.ServiceException;

import service.ServicioTest;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Tests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tests() {
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
		String respuesta="/test.jsp";
		//recupero un el parametro para repetir un test
		String intentar=request.getParameter("intentar");
		//si no hay intento el test es null y se tiene que crear.
		if (intentar==null) {
			//recuperamos el nombre del test
			String nombreTest=request.getParameter("nombre");
			
			//llamo al servicio para recuperar el test de la base de datos
			ServicioTest servicioTest=null;
			Test test=null;
			try{
				servicioTest=new ServicioTest();
				//recupero el test con el nombre
				test=new Test(nombreTest);
							
				test=servicioTest.recuperarTest(test);
				
				request.getSession().setAttribute("testCompleto", test);
			
			}catch (ServiceException e) {
				request.setAttribute("error", e.getMessage());
			}catch (DomainException e) {
				request.setAttribute("error", e.getMessage());
			}
		}//fin del si
		
		
		getServletContext().getRequestDispatcher(respuesta).forward(request, response);
	}

}
