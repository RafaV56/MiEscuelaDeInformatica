package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Controlador;
import domain.Correo;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class EnviarCorreo
 */
public class EnviarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarCorreo() {
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
		String email=request.getParameter("email");
		//EmailSenderService emailSender=null;
		//ServiceEmail sevicioEmail=null;
		
		Controlador emailControlador=null;
		Correo correo=null;
		try {	
			correo=new Correo();
			correo.setAsunto("Bienvenidos a la escuela de informatica");
			correo.setDestino("correo@gmail.com");
			correo.setMensaje("Bienvenidos a la escuela de informatica");
			correo.setUsuario("correo@gmail.com");
			correo.setPassword("???");
			
			emailControlador=new Controlador();
			System.out.println(emailControlador.enviarCorreo(correo));
			
			//emailSender=new EmailSenderService();
			//emailSender.sendEmail();
			
			//sevicioEmail=new ServiceEmail();
			
			//sevicioEmail.enviarEmail(email);
			
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
		} catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
		}
		
		getServletContext().getRequestDispatcher("/Welcome").forward(request, response);
	}

}
