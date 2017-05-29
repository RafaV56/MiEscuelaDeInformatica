package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceHacerTest;
import service.ServiceUsuario;

import domain.*;
import exceptions.DomainException;
import exceptions.ServiceException;

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
		Usuario usuario=(Usuario) request.getSession().getAttribute("usuario");
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
			testCorregido.setSuperado(contadorCorrectas>=superado?"s":"n");
			testCorregido.setCorrectas(contadorCorrectas);
			testCorregido.setErrores(preguntas-contadorCorrectas);
			testCorregido.setNombreTest(test.getNombre());
			
			
			/*Si hay usuario recupero el test 
			 *si está null lo inserto, si no, compruebo que si es superado
			 *si lo es no actualizo su estado. 
			 */
			if(usuario!=null){
				
				//recupero el test para saber si está superado				
				HacerTest hacerTest=null;
				HacerTest hacerTestBBDD=null;
				try{			
					serviceHacerTest=new ServiceHacerTest();
					hacerTest=new HacerTest(usuario, testCorregido, testCorregido.getSuperado());
					hacerTestBBDD=serviceHacerTest.recuperarHacerTest(hacerTest);
					if (hacerTestBBDD==null) {
						//si es null inserto el test creado en esté servlet
						serviceHacerTest.insertarHacerTest(hacerTest);
					}else if (hacerTestBBDD.getSuperado().equals("n")) {
						//Si no está superado en la BBDD compruebo si está superado.
						if (hacerTest.getSuperado().equals("s")) {
							//si lo está lo actualizo
							serviceHacerTest.modificarHacerTest(hacerTest);							
						}
					}else if(hacerTestBBDD.getSuperado().equals("s")){
						//Si fue superado anteriormete se informa al usuario
						testCorregido.setSuperadoAnteriormente(true);
					}else{
						throw new ServiceException("No se puede saber si el test fue superado anteriormete");
					}
				} catch (ServiceException e) {
					if(e.getCause()==null){
						testCorregido.setError(e.getMessage());
					}else{
						e.printStackTrace();// para administrador
						testCorregido.setError(e.getMessage());
					}
				}catch (DomainException e) {
					testCorregido.setError(e.getMessage());
				}	
			}//fin del si usu es null
	
		}else{
			testCorregido.setError("El text no existe");
		}
		//Se agrega la corrección del test a la sesión
		request.getSession().setAttribute("testCorregido", testCorregido);

		getServletContext().getRequestDispatcher("/respuestaTest.jsp").forward(request, response);

	}

}
