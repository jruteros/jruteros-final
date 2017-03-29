package clasesUtiles;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail  extends Thread {

	private String direccion;
	private String mensaje;
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public SendMail(String direccion, String mensaje) {
		super();
		this.direccion = direccion;
		this.mensaje = mensaje;
	}
	public void run() {
		this.enviar();
	}

	public void enviar() {

		final String username = "jruteros2016@gmail.com";
		final String password = "jrut___123";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jruteros2016@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(direccion));
			message.setSubject("Bienvenido a JRuteros");
			message.setText(mensaje);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
