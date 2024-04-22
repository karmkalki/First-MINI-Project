package in.ashokit.email;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailGenerator {

    @Autowired
    private JavaMailSender emailSender;

	
	 public void sendSimpleMessage(String to, String subject, String text) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("goranksharma3002@gmail.com"); // Set your email address
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(text);
	        emailSender.send(message);
	    }
	
	    public boolean sendEmailWithAttachment(String to, String subject, String text, File F) throws IOException, MessagingException {
	/* send any file which is available in our project directry if we send F1 then .projet file send
	    	File F1=new File("C:\\Users\\abhis\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\JRTP-Insurance-MiniPro-1/.project");
	  */try {
	    	MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,true); 
	        helper.setFrom("goranksharma3002@gmail.com"); // Set your email address
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text,true);//true represent body content html text

	        helper.addAttachment( F.getName(), F);

	        emailSender.send(message);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return true;
	  }
}
