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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail{
	SystemConfig config;
//	public void mail(String email,String content) {
//		JavaMailSender mailSender = getJavaMailSender();
//		SimpleMailMessage message = new SimpleMailMessage();  
//		  
//		message.setTo(email);
//		message.setSubject("���ճz�L Gmail �h�o�H");
//		message.setText(content);
//  
//		mailSender.send(message);
//	}
//	
//	public JavaMailSender getJavaMailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(587);
//		mailSender.setUsername(SystemConfig.getProperty("spring.mail.username"));
//		mailSender.setPassword(SystemConfig.getProperty("spring.mail.password"));
//	      
//		Properties props = mailSender.getJavaMailProperties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.auth", "true");
////		props.put("mail.smtp.starttls.enable", "true");
////		props.put("mail.smtp.starttls.required", "true");
//		props.put("mail.debug", "true");
//	      
//		return mailSender;
//	}
//	
//	public void sendmail(String email,String content) throws AddressException, MessagingException, IOException {
//		config = new SystemConfig();
//		
//		Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.host", "smtp.gmail.com"); // 
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true"); 
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "25");
//        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "true");
//
//        MailSSLSocketFactory sf = null;
//        try {
//            sf = new MailSSLSocketFactory();
//        } catch (GeneralSecurityException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//        sf.setTrustAllHosts(true);
//        props.put("mail.smtp.ssl.socketFactory", sf);
//
//        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(SystemConfig.getProperty("spring.mail.username"),SystemConfig.getProperty("spring.mail.password"));
//            }
//        });
//
//        mailSession.setDebug(true); // Enable the debug mode
//
//        Message msg = new MimeMessage( mailSession );
//
//        //--[ Set the FROM, TO, DATE and SUBJECT fields
//        try {
//            msg.setFrom( new InternetAddress( SystemConfig.getProperty("spring.mail.username") ) );
//        } catch (AddressException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email) );
//        } catch (AddressException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //msg.setSentDate(new Date());
//        try {
//            msg.setSubject( "Hello World!" );
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //--[ Create the body of the mail
//        try {
//            msg.setText(content);
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //--[ Ask the Transport class to send our mail message
//        try {
//            Transport.send( msg );
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }   
//	}
	
	public void sendMail(String toMail,String content) throws AddressException, MessagingException
	   {    
			System.out.println("username = "+SystemConfig.getProperty("spring.mail.username"));
			System.out.println("password = "+SystemConfig.getProperty("spring.mail.password"));
			System.out.println("host = "+SystemConfig.getProperty("spring.mail.host"));
			System.out.println("port = "+SystemConfig.getProperty("spring.mail.port"));
//			EDM ip: 172.21.210.30
//			帳號：wmsedm@msa.wda.gov.tw
//			密碼：Wms@123456789
//			String user = "yaosheng@heroic.com.tw";//user
//	        String pwd = "jjlcksycjxvetagm";//password
//	        String to= "a2377678@gmail.com";
//	        String from = "yaosheng@heroic.com.tw";//寄件人的email
	        String user = SystemConfig.getProperty("spring.mail.username");//user
	        String pwd = SystemConfig.getProperty("spring.mail.password");//password
	        String to= toMail;
	        String from = SystemConfig.getProperty("spring.mail.username");//寄件人的email
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
	        InternetAddress[] toAddresses = { new InternetAddress(to) };
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
	        System.out.println("email finish");
	// *** END CHANGE
	   }
}