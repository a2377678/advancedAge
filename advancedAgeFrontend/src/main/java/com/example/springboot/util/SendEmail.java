package com.example.springboot.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail{
	SystemConfig config;
	public void mail(String email,String content) {
		JavaMailSender mailSender = getJavaMailSender();
		SimpleMailMessage message = new SimpleMailMessage();  
		  
		message.setTo(email);
		message.setSubject("測試透過 Gmail 去發信");
		message.setText(content);
  
		mailSender.send(message);
	}
	
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername(SystemConfig.getProperty("spring.mail.username"));
		mailSender.setPassword(SystemConfig.getProperty("spring.mail.password"));
	      
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.debug", "true");
	      
		return mailSender;
	}
	
	public void sendmail(String email,String content) throws AddressException, MessagingException, IOException {
		config = new SystemConfig();
		
		Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com"); // 
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.socketFactory.port", "25");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");

        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SystemConfig.getProperty("spring.mail.username"),SystemConfig.getProperty("spring.mail.password"));
            }
        });

        mailSession.setDebug(true); // Enable the debug mode

        Message msg = new MimeMessage( mailSession );

        //--[ Set the FROM, TO, DATE and SUBJECT fields
        try {
            msg.setFrom( new InternetAddress( SystemConfig.getProperty("spring.mail.username") ) );
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email) );
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //msg.setSentDate(new Date());
        try {
            msg.setSubject( "Hello World!" );
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //--[ Create the body of the mail
        try {
            msg.setText(content);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //--[ Ask the Transport class to send our mail message
        try {
            Transport.send( msg );
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
	}
}