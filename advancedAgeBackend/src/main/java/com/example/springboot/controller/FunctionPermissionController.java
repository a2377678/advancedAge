package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.FunctionPermission;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class FunctionPermissionController { 

	Logger logger = LogManager.getLogger(FunctionPermissionController.class);
	
	@Autowired
	CallApi api;
	
	@Value("${api_ip}")
	private String ip;
	
	@RequestMapping(value = "/selectFunctionPermission", method = RequestMethod.POST)
	public void selectFunctionPermission(HttpServletRequest request, HttpServletResponse response,FunctionPermission functionPermission){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionPermission);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectFunctionPermission",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			functionPermission = objectMapper.readValue(jsondata, FunctionPermission.class);
			response.getWriter().print("{\"status\":\"success\",\"code\":\""+StringEscapeUtils.escapeHtml(functionPermission.getFunctionCode())+"\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/selectFunctionPermissionCtype", method = RequestMethod.POST)
	public void selectFunctionPermissionCtype(HttpServletRequest request, HttpServletResponse response,FunctionPermission functionPermission){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionPermission);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectFunctionPermission",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			functionPermission = objectMapper.readValue(jsondata, FunctionPermission.class);
			response.getWriter().print("{\"status\":\"success\",\"code\":\""+StringEscapeUtils.escapeHtml(functionPermission.getFunctionCode3())+"\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/editFunctionPermission", method = RequestMethod.POST)
	public void editFunctionPermission(HttpServletRequest request, HttpServletResponse response,FunctionPermission functionPermission){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionPermission);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"editFunctionPermission",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("{\"status\":\"success\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/selectFunctionPermission2", method = RequestMethod.POST)
	public void selectFunctionPermission2(HttpServletRequest request, HttpServletResponse response,FunctionPermission functionPermission){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionPermission);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectFunctionPermission",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			functionPermission = objectMapper.readValue(jsondata, FunctionPermission.class);
			response.getWriter().print("{\"status\":\"success\",\"code\":\""+StringEscapeUtils.escapeHtml(functionPermission.getFunctionCode2())+"\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
}