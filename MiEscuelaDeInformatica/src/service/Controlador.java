package service;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import domain.Correo;
import exceptions.ServiceException;

public class Controlador {

	public Controlador () {
		
	}
	
	public boolean enviarCorreo(Correo c) throws ServiceException{
		try {
			Properties p = new Properties ();
			p.put("mail.smtp.host", "mail.elinformaticopersonal.com");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.port", "25");
			p.put("mail.smtp.user", c.getUsuario());
			p.put("mail.smtp.auth", "true"); // true o false si necesita el check de autentificación
			
			Session s = Session.getDefaultInstance(p, null);
			s.setDebug(true);
			BodyPart texto = new MimeBodyPart();
			texto.setText(c.getMensaje());
			
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);
			
			MimeMessage mensaje = new MimeMessage (s);
			mensaje.setFrom(new InternetAddress(c.getUsuario()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
			mensaje.setSubject(c.getAsunto());
			mensaje.setContent(m);
			
			Transport t = s.getTransport("smtp");
			t.connect(c.getUsuario(), c.getPassword());
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();
			
		
			
		} catch (Exception e) {
			 new ServiceException("El email no se pudo enviar desde el controlador de emails");
		}
		return true;
	}
	
	
}
