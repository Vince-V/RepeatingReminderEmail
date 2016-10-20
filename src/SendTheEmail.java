import java.util.Properties;
import java.util.TimerTask;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;

import java.io.UnsupportedEncodingException;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

import java.util.TimerTask;
 
public class SendTheEmail {
  public void run(){
	  try{
		  
	  Properties useProp = new Properties();
	  useProp.put("mail.smtp.host", "yourExchangeEmail.lookitup.com");
	  useProp.put("mail.smtp.host","587");
	  useProp.put("mail.smtp.ssl.trust","yourExchangeEmail.lookitup.com");
	  useProp.put("mail.smtp.auth","true");
	  useProp.put("mail.smtp.connectiontimeout","10000");
	  
	  final String yourEmailUserId = "userid";
	  final String yourEmailpwd = "password";

	  Session sessionForEmail = Session.getInstance(useProp, new Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication(yourEmailUserId,yourEmailpwd);
	     }
	   });  
	  
	  
	  sessionForEmail.setDebug(true);
	  InternetAddress fromEmailAddress = new InternetAddress("someemailaddress@email.com","someemailaddress@email.com");
	  InternetAddress toEmailAddress = new InternetAddress("someToemailaddress@email.com","someToemailaddress@email.com");
	  
	  String emailSubjectLine = "Teammates, don't forget to check that thing, and send report";
	  String emailMessageBody = "Teammates, don't forget to check this link https://afdfsd.com. And send report if there's an issue";
	  
	  Message message = new MimeMessage(sessionForEmail);
	  message.setFrom(fromEmailAddress);
	  
	  Transport transportForEmail = sessionForEmail.getTransport("smtp");
	  transportForEmail.connect();
	  
	  
	  }catch(MessagingException me){
		  System.out.println(me.getMessage()+ me.getStackTrace());		 
	  }catch(UnsupportedEncodingException uee){
		  System.out.println(uee.getMessage());		 
	  }  
  }
}
