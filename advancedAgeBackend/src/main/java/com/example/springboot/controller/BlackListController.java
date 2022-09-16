package com.example.springboot.controller;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.BlackList;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SendEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class BlackListController { 
	
	@Autowired
	CallApi api;
	
	@Value("${api_ip}")
	private String ip;
	
	@RequestMapping(value = "/addBlackList", method = RequestMethod.POST)
	public void addBlackList(HttpServletRequest request, HttpServletResponse response,BlackList blackList){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("json = "+json);
		String jsondata = api.httpPost(ip+"addBlackList",json);
		System.out.println("jsondata = "+jsondata);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			blackList = objectMapper.readValue(jsondata, BlackList.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+blackList.getId()+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/editBlackListData", method = RequestMethod.POST)
	public void editBlackListData(HttpServletRequest request, HttpServletResponse response,BlackList blackList){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("json = "+json);
		String jsondata = api.httpPost(ip+"editBlackListData",json);
		System.out.println("jsondata = "+jsondata);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			blackList = objectMapper.readValue(jsondata, BlackList.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+blackList.getId()+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}