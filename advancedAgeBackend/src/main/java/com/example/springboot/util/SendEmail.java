package com.example.springboot.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail{

	SystemConfig config;
	
	public void sendMail(String toMail,String content) throws AddressException, MessagingException
	   {    
//			EDM ip: 172.21.210.30
//			帳號：wmsedm@msa.wda.gov.tw
//			密碼：Wms@123456789
	        String user = SystemConfig.getProperty("spring.mail.username");//user
	        String pwd = SystemConfig.getProperty("spring.mail.password");//password
//	        String from = SystemConfig.getProperty("spring.mail.username");//寄件人的email
	        /*
	         * host
	         * yahoo:"smtp.mail.yahoo.com"
	         * outlook:"smtp-mail.outlook.com"
	         */
//	        String host ="smtp.gmail.com" ;
	        String host =SystemConfig.getProperty("spring.mail.username") ;

	        String subject = "中高齡密碼"; 

	     // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", SystemConfig.getProperty("spring.mail.port"));
//	        properties.put("mail.smtp.auth", "true");
//	        properties.put("mail.smtp.starttls.enable", "true");
//	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	// *** BEGIN CHANGE
	        properties.put("mail.smtp.user", user);

	        // creates a new session, no Authenticator (will connect() later)
	        Session session = Session.getDefaultInstance(properties);
	// *** END CHANGE

	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);

	        msg.setFrom(new InternetAddress(user));
	        InternetAddress[] toAddresses = { new InternetAddress(toMail) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        // set plain text message
	        msg.setText(content);

	// *** BEGIN CHANGE
	        // sends the e-mail
	        Transport t = session.getTransport("smtp");
	        t.connect(user, pwd);
	        t.sendMessage(msg, msg.getAllRecipients());
	        t.close();
	// *** END CHANGE
	   }
}