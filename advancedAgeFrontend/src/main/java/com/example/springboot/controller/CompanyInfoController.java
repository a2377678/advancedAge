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

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CompanyInfoController {

	Logger logger = LogManager.getLogger(CompanyInfoController.class);
	
	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	HttpSession session;

	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public void addCompanyInfo(HttpServletRequest request, HttpServletResponse response, CompanyInfo info) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "addCompanyInfo", json));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(StringEscapeUtils.escapeHtml(object.get("id").toString()));
		} catch (IOException e) {
			logger.warn(e.getMessage());
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
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "editCompanyInfo", json));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(StringEscapeUtils.escapeHtml(object.get("id").toString()));
		} catch (IOException e) {
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
			searchInfo.setPassword(AesUtil.encrypt(info.getPassword()));
			json = objectMapper.writeValueAsString(searchInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		} 
		JSONObject object = new JSONObject(api.httpPost(ip+"checkCompanyInfo",json));
		
		try {
			if(AesUtil.decrypt(object.get("password").toString().replaceAll(" ","+").getBytes()).equals(info.getPassword()))
			{
				info.setPassword(AesUtil.encrypt(newPassword));
				try {
					json = objectMapper.writeValueAsString(info);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip + "changeCompanyPassword", json);
				response.getWriter().print("success");
			}
			else
			{
				response.getWriter().print("fail");
			}
			response.setContentType("text/html;charset=UTF-8");
		
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} catch (JSONException e) {
			logger.warn(e.getMessage());
		}
	}
}