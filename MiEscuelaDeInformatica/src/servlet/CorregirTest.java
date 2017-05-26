package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceHacerTest;

import domain.Pregunta;
import domain.Test;
import domain.TestCorregido;

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
		TestCorregido testCorregido=new TestCorregido();
		ServiceHacerTest serviceHacerTest=null;
		if (test!=null) {
			//Agrego el tema y la tecnología
			String nombre=test.getNombre();
	    	String tema=nombre.substring(nombre.indexOf("-")+1);
	    	String tecnologia=nombre.substring(0, nombre.indexOf("-"));   	
	    	testCorregido.setTema(tema);
	    	testCorregido.setTecnologia(tecnologia);
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
			
			//preguntar si a superado el test
			testCorregido.setSuperado(contadorCorrectas>=superado);
			testCorregido.setCorrectas(contadorCorrectas);
			testCorregido.setErrores(preguntas-contadorCorrectas);
			testCorregido.setNombreTest(test.getNombre());
			
			
			//
		//	serviceHacerTest = new ServiceHacerTest(usuario,testCorregido);			
	
		}else{
			testCorregido.setError("El text no existe");
		}
		//Se agrega la corrección del test a la sesión
		request.getSession().setAttribute("testCorregido", testCorregido);

		getServletContext().getRequestDispatcher("/respuestaTest.jsp").forward(request, response);

	}

}
