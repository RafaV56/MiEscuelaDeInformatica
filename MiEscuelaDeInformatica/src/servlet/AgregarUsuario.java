package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import exceptions.DomainException;
import exceptions.ServiceException;

import service.ServiceUsuario;

/**
 * Servlet implementation class AgregarUsuario
 */
@WebServlet("/AgregarUsuario")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarUsuario() {
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
		
		//Variable para recuperar el resultado y enviar a la jsp correcta
		String resultado=null;
		
		
		//Validamos que esten bien
		Usuario usu=null;
		ServiceUsuario servicioUsuario=null;
		try{			
			
			//Recuperamos los parametros del formulario en registrar.jsp
			String email=(String)request.getParameter("email");
			String nombre=(String)request.getParameter("nombre");
			int edad=0;
			try {
				edad = Integer.parseInt((String)request.getParameter("edad"));
			} catch (NumberFormatException e1) {
				throw new ServiceException("La edad no es correcta");
			}
			String nick=(String)request.getParameter("nick");
			String contrasena=(String)request.getParameter("contrasena");
			
			
			usu=Usuario.crearUsuario(email, nombre, edad, nick, contrasena);
		
			//LLamamos al servicio de usuario para insertarlo
			servicioUsuario=new ServiceUsuario();
			
			//insertamos el usuario
			servicioUsuario.insertarUsuario(usu);
			//si todo fue bien regresamos a registrar y escribimos que es todo correcto
			resultado="/registra.jsp";
			request.setAttribute("respuesta","El usuario se inserto correctamente");
			
		} catch (ServiceException e) {
			if(e.getCause()==null){
				request.setAttribute("error",e.getMessage());
				resultado="/registra.jsp";
			}else{
				e.printStackTrace();// para administrador
				request.setAttribute("error",e.getMessage());
				resultado="/registra.jsp";
			}
		}catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
			resultado="/registra.jsp";
		}
		getServletContext().getRequestDispatcher(resultado).forward(request, response);//Error Lógico para usuario
		
	}
	//***hacer el jsp para que si hay error o esta bien el usuario se muestre
}
