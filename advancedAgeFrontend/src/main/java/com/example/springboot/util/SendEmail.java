package com.example.springboot.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SendEmail{

	@Autowired
    private Environment env;
	
	public void sendMail(String toMail,String subject,String content) throws AddressException, MessagingException
	   {    
	        String user = env.getProperty("spring.mail.username");//user
	        String pwd = env.getProperty("spring.mail.password");//password
	        
	        /*
	         * host
	         * yahoo:"smtp.mail.yahoo.com"
	         * outlook:"smtp-mail.outlook.com"
	         */
	        String host =env.getProperty("spring.mail.host") ;
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", env.getProperty("spring.mail.port"));
	        properties.put("mail.smtp.user", user);

	        // creates a new session, no Authenticator (will connect() later)
	        Session session = Session.getDefaultInstance(properties);

	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);

	        msg.setFrom(new InternetAddress(user));
	        InternetAddress[] toAddresses = { new InternetAddress(toMail) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        // set plain text message
	        msg.setText(content);

	        // sends the e-mail
	        Transport t = session.getTransport("smtp");
	        t.connect(user, pwd);
	        t.sendMessage(msg, msg.getAllRecipients());
	        t.close();
	   }
}