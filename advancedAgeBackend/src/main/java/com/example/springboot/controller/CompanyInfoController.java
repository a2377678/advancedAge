package com.example.springboot.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CompanyInfoController {

	Logger logger = LogManager.getLogger(CompanyInfoController.class);
	@Autowired
	CallApi api;

	@Value("${api_ip}")
	private String ip;

	HttpSession session;
	
	static String SPECIAL_CHARS="!@#$%^&*_=+-/";
	
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public void editCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		info.setVerifyTime(new Date());
		String pwd=randomPassword();
		try {
			info.setPassword(AesUtil.encrypt(pwd));
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} 
		api.httpPost(ip + "editCompanyInfo", json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(pwd);
		} catch (IOException e) {
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