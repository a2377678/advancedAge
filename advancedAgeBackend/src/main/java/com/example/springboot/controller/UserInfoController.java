package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.UserInfo;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class UserInfoController {

	Logger logger = LogManager.getLogger(UserInfoController.class);
	
	@Autowired
	CallApi api;

	@Value("${api_ip}")
	private String ip;

	HttpSession session;
	
	@Value("${encrypt_key}")
	private String key;
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public void changePassword(HttpServletRequest request, HttpServletResponse response, UserInfo info,String newPassword) {
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "selectUserInfoData", json));
		try {
			if(AesUtil.decrypt(object.get("password").toString().replaceAll(" ","+").getBytes()).equals(info.getPassword()))
			{
				info.setPassword(AesUtil.encrypt(newPassword));
				try {
					json = objectMapper.writeValueAsString(info);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip + "editUserInfoData", json);
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