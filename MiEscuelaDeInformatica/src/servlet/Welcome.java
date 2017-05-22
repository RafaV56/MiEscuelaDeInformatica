package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet(description = "De bienvenida", urlPatterns = { "/Welcome" })
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
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
		
		//veo si tengo cookies del usuario para agregarlas a la sesión
		Cookie todas[]=request.getCookies();
		
		for (Cookie cookie : todas) {
			if (cookie.getName().equals("email")) {
				request.getSession().setAttribute("email", cookie.getValue());
			}
			if (cookie.getName().equals("contrasena")) {
				request.getSession().setAttribute("contasena", cookie.getValue());
			}
			
			
		}
		//para la barra de navegación
		request.getSession().setAttribute("barra", "Welcome");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
