package com.example.springboot.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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

	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	HttpSession session;
	
	@Value("${encrypt_key}")
	private String key;

	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public void addCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip + "addCompanyInfo", json);
		JSONObject object = new JSONObject(body);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(object.get("id"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public void editCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip + "editCompanyInfo", json);
		System.out.println("company id = " + body);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public void changePassword(HttpServletRequest request, HttpServletResponse response, CompanyInfo info,String newPassword) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		CompanyInfo searchInfo = new CompanyInfo();
		try {
			searchInfo.setSeq(info.getSeq());
			searchInfo.setPassword(encryptPassword(info.getPassword(),key));
			json = objectMapper.writeValueAsString(searchInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip+"checkCompanyInfo",json);
		JSONObject object = new JSONObject(jsondata);
		
		try {
			System.out.println("decryptPassword = "+decryptPassword(object.get("password").toString(),key));
			System.out.println("info.getPassword() = "+info.getPassword());
			if(decryptPassword(object.get("password").toString(),key).equals(info.getPassword()))
			{
				info.setPassword(encryptPassword(newPassword,key));
				try {
					json = objectMapper.writeValueAsString(info);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsondata = api.httpPost(ip + "changeCompanyPassword", json);
				response.getWriter().print("success");
			}
			else
			{
				response.getWriter().print("fail");
			}
			response.setContentType("text/html;charset=UTF-8");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	    byte[] result = cipher.doFinal(Base64.getDecoder().decode(data.replace(" ","+")));
	    return new String(result);
	}
}