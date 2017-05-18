package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CerrarSeion
 */
@WebServlet(description = "Cierra la sesión de usuario", urlPatterns = { "/CerrarSeion" })
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesion() {
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
		String resultado="/Welcome";
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getRequestedSessionId());
//		System.out.println(request.getRequestURL());
//		System.out.println(request.getPathInfo());
//		System.out.println(request.getProtocol());
//		System.out.println(request.getLocalAddr());
		//ver como volver a donde estaba*****
		request.getSession().invalidate();
		
		getServletContext().getRequestDispatcher(resultado).forward(request, response);
	}

}
