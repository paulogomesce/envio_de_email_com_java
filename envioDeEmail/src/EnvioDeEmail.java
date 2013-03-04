

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EnvioDeEmail {
 
	public static void main(String[] args) {
 
		final String username = "usuario@gmail.com";
		final String password = "senha";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		  });
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("paulogomes.tec@gmail.com", "Paulo Gomes"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("paulogomes.tec@gmail.com"));
			message.setSubject("Envio de E-mail Com Java");
			message.setText("Olá, este é um teste de envio de e-mail utilizando servidor smtp do gmail " +
					        "com a API mail do Java.");
 
			Transport.send(message);
 
			System.out.println("E-mail enviado com sucesso");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(e);
		}
	}
}