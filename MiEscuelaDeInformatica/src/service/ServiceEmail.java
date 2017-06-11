package service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import exceptions.ServiceException;

public class ServiceEmail {
	
	public void enviarEmail(String usuario) throws ServiceException{
		
		Properties props=new Properties();
		
		props.put("mail.smtp.hots", "smtp-relay.gmail.com");
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		
		
		Session session=Session.getDefaultInstance(props,
				new javax.mail.Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication("MiEscuelaDeInformatica@gmail.com", "??");	
				}
				}
				
				);
				
		try{
			session.setDebug(true);
			Message message=new MimeMessage(session);
			// Quien envia el correo
			message.setFrom(new InternetAddress("MiEscuelaDeInformatica@gmail.com"));
			// A quien va dirigido
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario));
			message.setSubject("Escuela de informatica");
			message.setText("Bienvenido a la escuela");
			
			Transport.send(message);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServiceException("El email no se pudo enviar");
			
		}
		
	}

}
