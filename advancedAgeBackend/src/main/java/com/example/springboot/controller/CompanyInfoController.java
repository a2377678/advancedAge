package com.example.springboot.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CompanyInfoController {

	@Autowired
	CallApi api;

	@Value("${api_ip}")
	private String ip;

	HttpSession session;
	
	@Value("${encrypt_key}")
	private String key;
	
	static String SPECIAL_CHARS="!@#$%^&*_=+-/";
	
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public void editCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		info.setVerifyTime(new Date());
		try {
			info.setPassword(encryptPassword(randomPassword(),key));
			json = objectMapper.writeValueAsString(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip + "editCompanyInfo", json);
	}
	
	private static char nextChar(Random rnd) {
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

	public static String randomPassword() throws Exception {
		char[] chars = new char[12];
		Random rnd = new Random();
		for (int i = 0; i < 12; i++) {
			chars[i] = nextChar(rnd);
		}
		String password=new String(chars);
        
		return password;
	}

	public String encryptPassword(String data, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
	    byte[] result = cipher.doFinal(data.getBytes());
	    return Base64.getEncoder().encodeToString(result);
	}

	public String decryptPassword(String data, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
	    byte[] result = cipher.doFinal(Base64.getDecoder().decode(data));
	    return new String(result);
	}
}