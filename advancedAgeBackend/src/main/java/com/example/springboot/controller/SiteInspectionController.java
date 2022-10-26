package com.example.springboot.controller;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SendEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class SiteInspectionController { 

	Logger logger = LogManager.getLogger(SiteInspectionController.class);
	
	@Autowired
	CallApi api;
	
	@Value("${api_ip}")
	private String ip;
	
	@RequestMapping(value = "/addSiteInspection", method = RequestMethod.POST)
	public void addSiteInspection(HttpServletRequest request, HttpServletResponse response,SiteInspection siteInspection){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"addSiteInspection",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			siteInspection = objectMapper.readValue(jsondata, SiteInspection.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+StringEscapeUtils.escapeHtml(siteInspection.getId().toString())+"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/editSiteInspectionData", method = RequestMethod.POST)
	public void editSiteInspectionData(HttpServletRequest request, HttpServletResponse response,SiteInspection siteInspection){
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"editSiteInspectionData",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			siteInspection = objectMapper.readValue(jsondata, SiteInspection.class);
			response.getWriter().print("{\"status\":\"success\",\"id\":"+StringEscapeUtils.escapeHtml(siteInspection.getId().toString())+"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
}