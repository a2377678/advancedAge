package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.BlackList;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
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
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip+"addBlackList",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			blackList = objectMapper.readValue(jsondata, BlackList.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+StringEscapeUtils.escapeHtml(blackList.getId().toString())+"}");
		} catch (IOException e) {
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
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip+"editBlackListData",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			blackList = objectMapper.readValue(jsondata, BlackList.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+StringEscapeUtils.escapeHtml(blackList.getId().toString())+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}