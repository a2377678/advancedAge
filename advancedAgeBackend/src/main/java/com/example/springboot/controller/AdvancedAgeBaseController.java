package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class AdvancedAgeBaseController { 
	
	@Autowired
	public CallApi api;
	
	@Value("${api_ip}")
	private String ip;
	
	@RequestMapping(value = "/fileStatusSave", method = RequestMethod.POST)
	public void fileStatusSave(HttpServletRequest request, HttpServletResponse response,AdvancedAgeBase base){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("json = "+json);
		String jsondata = api.httpPost(ip+"fileStatusSave",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
//			if(jsondata !=null)
				response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/changeFileStatus", method = RequestMethod.POST)
	public void changeFileStatus(HttpServletRequest request, HttpServletResponse response,AdvancedAgeBase base){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("json = "+json);
		String jsondata = api.httpPost(ip+"changeFileStatus",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
//			if(jsondata !=null)
				response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/saveBase", method = RequestMethod.POST)
	public void saveBase(HttpServletRequest request, HttpServletResponse response,AdvancedAgeBase base){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("json = "+json);
		String jsondata = api.httpPost(ip+"saveBase",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
//			if(jsondata !=null)
				response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}