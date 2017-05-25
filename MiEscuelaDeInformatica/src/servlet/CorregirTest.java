package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Pregunta;
import domain.Test;

/**
 * Servlet implementation class CorregirTest
 */
@WebServlet("/CorregirTest")
public class CorregirTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorregirTest() {
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
	
		//Recupero el test a corregir, creado en test.java 
		Test test=(Test) request.getSession().getAttribute("testCompleto");
		
		if (test!=null) {
			//todas las preguntas del test
			List<Pregunta> lista=test.getPreguntas();
			//el tamaño de las preguntas para sacar su 80%
			int preguntas=test.getPreguntas().size();
			//para superar el test se necesita el número mínimo de acertadas
			int superado=(int) Math.round(preguntas*0.80);
			//contador de las respuestas correctas
			int contadorCorrectas=0;
			//veo las respuestas correctas
			for (int i = 0; i < preguntas; i++) {
				String respuesta=request.getParameter("pregunta"+(i+1));
				
				if(lista.get(i).getCorrecta().equals(respuesta)){
					contadorCorrectas++;
				}
			}//fin del for
			
			String respuesta="n";
			//preguntar si a superado el test
			if (contadorCorrectas>=superado) {
				respuesta="s";
			}
			//parametro para recuperar en respuesta.jsp, supero el test o no.
			request.setAttribute("respuesta", respuesta);
		}else{
			request.setAttribute("error","El test no exite");
		}

		getServletContext().getRequestDispatcher("/respuestaTest.jsp").forward(request, response);

	}

}
