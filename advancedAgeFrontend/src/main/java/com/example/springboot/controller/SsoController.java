package com.example.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SSOloginUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SsoController {
	
	Logger logger = LogManager.getLogger(SsoController.class);
	
	final private String loginSite = "https://hr.taiwanjobs.gov.tw/member/loginComp.aspx?";
	
	final private String sid = "Sid=0036";
	
	HttpSession session;
	
	@Autowired
	SSOloginUtil util;

	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;
	
	@PostMapping("/SSOdata")
	public ResponseEntity<String> ssoData(HttpServletRequest request, HttpServletResponse response) {
//		session = request.getSession();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		CompanyInfo info = new CompanyInfo();
		info = util.parseXmlStringToCompanyInfo(request.getParameter("Minfo"));
		ssoAddCompanyInfo(info);
//		session.setAttribute(session.getId()+"seq", info.getSeq());
//		session.setAttribute(session.getId()+"companyName", info.getCompanyName());
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/genLoginUrl")
	public String genLoginUrl(HttpServletRequest request, HttpServletResponse response,String seq) throws Exception {
		session = request.getSession();
		session.setAttribute(session.getId()+"Sso", seq);
		String url = loginSite + sid + "&Rid=" + session.getId() + "&Token=" + util.encode(sid);
		return url;
	}
	
	public void ssoAddCompanyInfo(CompanyInfo info) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip + "ssoAddCompanyInfo", json);
	}
}
