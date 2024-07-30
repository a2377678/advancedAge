package com.example.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class ExternalApiController { 
	
	Logger logger = LogManager.getLogger(ExternalApiController.class);
	
	@Autowired
	public CallApi api;
	
	@Value("${tsb_api_ip}")
	private String ip;
	
	@RequestMapping(value = "/getTsbApplyData", method = RequestMethod.POST)
	public void getTsbApplyData(HttpServletRequest request, HttpServletResponse response,String allowanceId){
		JSONObject jsonObject=null;
		String jsondata = api.httpGet(ip+"tsb/GetTsbApplyData/"+allowanceId);
		try {
			jsonObject= new JSONObject(jsondata);
		}catch (JSONException err){
			logger.warn("Error", err.toString());
		}
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			if(jsonObject != null)
			{
//			response.getWriter().print("{\"status\":\"success\",\"id\":"+StringEscapeUtils.escapeHtml(siteInspection.getId().toString())+"}");
			response.getWriter().print("{\"status\":\"success\",\"tsbWorkDate\":\""+StringEscapeUtils.escapeHtml(Integer.valueOf(jsonObject.get("tsbWorkDate").toString().substring(0,4))-1911+jsonObject.get("tsbWorkDate").toString().substring(4,10))+
					"\",\"tsbSDate\":\""+StringEscapeUtils.escapeHtml(Integer.valueOf(jsonObject.get("tsbSDate").toString().substring(0,4))-1911+jsonObject.get("tsbSDate").toString().substring(4,10))+
					"\",\"tsbEDate\":\""+StringEscapeUtils.escapeHtml(Integer.valueOf(jsonObject.get("tsbEDate").toString().substring(0,4))-1911+jsonObject.get("tsbEDate").toString().substring(4,10))+
					"\",\"tsbTotalMoney\":\""+StringEscapeUtils.escapeHtml(jsonObject.get("tsbTotalMoney").toString().substring(0, jsonObject.get("tsbTotalMoney").toString().indexOf(".")))+
					"\",\"tsbApplyMoney\":\""+StringEscapeUtils.escapeHtml(jsonObject.get("tsbApplyMoney").toString().substring(0, jsonObject.get("tsbApplyMoney").toString().indexOf(".")))+
					"\",\"tsbDecMoney\":\""+StringEscapeUtils.escapeHtml(jsonObject.get("tsbDecMoney").toString().substring(0, jsonObject.get("tsbDecMoney").toString().indexOf(".")))+
					"\",\"tsbApprovedDate\":\""+StringEscapeUtils.escapeHtml(Integer.valueOf(jsonObject.get("tsbApprovedDate").toString().substring(0,4))-1911+jsonObject.get("tsbApprovedDate").toString().substring(4,10))+
					"\",\"tsbApprovedNo\":\""+jsonObject.get("tsbApprovedNo").toString()+
					"\"}");
			}else {
				response.getWriter().print("{\"status\":\"fail\"}");
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
}