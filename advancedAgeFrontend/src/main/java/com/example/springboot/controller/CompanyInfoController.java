package com.example.springboot.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SendEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CompanyInfoController {

	Logger logger = LogManager.getLogger(CompanyInfoController.class);
	
	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	@Value("${mail_domain}")
	private String mailDomain;
	
	static String SPECIAL_CHARS="!@#$%^&*_=+-/";
	
	@Autowired
	SendEmail sendEmail;
	
	HttpSession session;

	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public void addCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info,MailRecord mailRecord) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		
		//密碼加密
		String pwd=randomPassword();
		info.setPassword(AesUtil.encrypt(pwd));
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		response.setContentType("text/html;charset=UTF-8");
		String check = api.httpPost(ip + "selectCompanyInfo", json);
		if(check.equals("")) {
			JSONObject object = new JSONObject(api.httpPost(ip + "addCompanyInfo", json));
			mailRecord.setMailType("E");
			mailRecord.setMailContent("您好\r\n"
					+ "貴公司 "+info.getCompanyName()+" 於勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統註冊帳號  "+info.getSeq()+"\r\n"
					+ "\r\n"
					+ "您的預設密碼為："+pwd+"\r\n"
					+ "\r\n"
					+ "請於以下網址前往修改密碼：\r\n"
					+ mailDomain+"/advancedAgeFrontend/change_password");
			try {
				sendEmail.sendMail(mailRecord.getEmail(),"<密碼通知信> 勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統",mailRecord.getMailContent());
			} catch (AddressException e1) {
				logger.warn(e1.getMessage());
			} catch (MessagingException e1) {
				logger.warn(e1.getMessage());
			} catch (Exception e1) {
				logger.warn(e1.getMessage());
			}
			
			try {
				json = objectMapper.writeValueAsString(mailRecord);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"addMailRecord",json);
			
			try {
				response.getWriter().print(StringEscapeUtils.escapeHtml(object.get("id").toString()));
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}else {
			try {
				response.getWriter().print("fail");
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public void editCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info,MailRecord mailRecord) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		//密碼加密
		String pwd=randomPassword();
		info.setPassword(AesUtil.encrypt(pwd));
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			JSONObject object = new JSONObject(api.httpPost(ip + "editCompanyInfo", json));
			mailRecord.setMailType("E");
			mailRecord.setMailContent("您好\r\n"
					+ "貴公司 "+info.getCompanyName()+" 於勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統註冊帳號  "+info.getSeq()+"\r\n"
					+ "\r\n"
					+ "您的預設密碼為："+pwd+"\r\n"
					+ "\r\n"
					+ "請於以下網址前往修改密碼：\r\n"
					+ mailDomain+"/advancedAgeFrontend/change_password");
			try {
				sendEmail.sendMail(mailRecord.getEmail(),"<密碼通知信> 勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統",mailRecord.getMailContent());
			} catch (AddressException e1) {
				logger.warn(e1.getMessage());
			} catch (MessagingException e1) {
				logger.warn(e1.getMessage());
			} catch (Exception e1) {
				logger.warn(e1.getMessage());
			}
			response.getWriter().print(StringEscapeUtils.escapeHtml(object.get("id").toString()));
		} catch (IOException e) {
			try {
				response.getWriter().print("fail");
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			logger.warn(e.getMessage());
			
		}catch (JSONException e) {
			try {
				response.getWriter().print("fail");
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public void changePassword(HttpServletRequest request, HttpServletResponse response, CompanyInfo info,String newPassword) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		CompanyInfo searchInfo = new CompanyInfo();
		try {
			searchInfo.setSeq(info.getSeq());
//			searchInfo.setPassword(AesUtil.encrypt(info.getPassword()));
			json = objectMapper.writeValueAsString(searchInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		} 
		JSONObject object = new JSONObject(api.httpPost(ip+"selectCompanyInfo",json));
		try {
			if(!newPassword.equals(""))
			{
				info.setPassword(AesUtil.encrypt(newPassword));
			}
			try {
				json = objectMapper.writeValueAsString(info);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip + "changeCompanyPassword", json);
			response.getWriter().print("success");
			
			response.setContentType("text/html;charset=UTF-8");
		
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} catch (JSONException e) {
			logger.warn(e.getMessage());
		}
	}
	
	private static char nextChar(SecureRandom rnd) {
		switch (rnd.nextInt(4)) {
		case 0:
			return (char) ('a' + rnd.nextInt(26));
		case 1:
			return (char) ('A' + rnd.nextInt(26));
		case 2:
			return (char) ('0' + rnd.nextInt(10));
		default:
			return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
		}
	}

	public static String randomPassword(){
		char[] chars = new char[12];
		SecureRandom rnd = new SecureRandom();
		rnd.setSeed((new Date()).getTime());
		for (int i = 0; i < 12; i++) {
			chars[i] = nextChar(rnd);
		}
		String password=new String(chars);
		return password;
	}
}