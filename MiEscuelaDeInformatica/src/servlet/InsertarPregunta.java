package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServicePregunta;
import domain.Pregunta;
import domain.Test;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class InsertarPregunta
 */
public class InsertarPregunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarPregunta() {
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
		
		String codigo=request.getParameter("codigoEjemplo");
		String pregunta=request.getParameter("pregunta");
		String respuestaA=request.getParameter("respuestaA");
		String respuestaB=request.getParameter("respuestaB");
		String respuestaC=request.getParameter("respuestaC");
		String respuestaD=request.getParameter("respuestaD");
		String respuestaE=request.getParameter("respuestaE");
		String respuestaValida=request.getParameter("respuestaValida");
		
		Test test=(Test)request.getSession().getAttribute("test");
		
		Pregunta preguntaInsertar=null;
		ServicePregunta servicePregunta=null;
		
		try {
			servicePregunta=new ServicePregunta();
			preguntaInsertar=Pregunta.crearPregunta(codigo, pregunta, respuestaA, respuestaB, respuestaC, respuestaD, respuestaE, respuestaValida);
			servicePregunta.insertarPregunta(preguntaInsertar, test);
			
			request.setAttribute("respuesta", "La pregunta se añadio correctamente");
		} catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
		}
		getServletContext().getRequestDispatcher(response.encodeURL(resultado)).forward(request, response);
	}

}
