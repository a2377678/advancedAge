package com.example.springboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentReceipt;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SendEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class AdvancedAgeRetirementReemploymentApplyController {
	
	Logger logger = LogManager.getLogger(AdvancedAgeRetirementReemploymentApplyController.class);
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	public String ip;
	
	@Autowired
	SendEmail sendEmail;
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentApply", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentApply(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentApply apply){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			apply.setAttachDocumentsApply("Y");
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addAdvancedAgeRetirementReemploymentApply",json));
		session.setAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId", object.get("id"));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}

	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentPlan", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentPlan(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentPlan plan){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		plan.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString()));
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addAdvancedAgeRetirementReemploymentPlan",json));
		session.setAttribute(session.getId()+"advancedAgeRetirementReemploymentPlanId", object.get("id"));
		AdvancedAgeRetirementReemploymentApply apply = new AdvancedAgeRetirementReemploymentApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		apply.setAttachDocumentsPlan("Y");
		addAdvancedAgeRetirementReemploymentApply(request,response,apply);
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBenefitList", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentBenefitList(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeRetirementReemploymentBenefitList[] list){ 
		session = request.getSession();
		String seqData=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentPlanId").toString();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setAdvancedAgeRetirementReemploymentPlanId(Integer.valueOf(seqData));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentBenefitList",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBenefitList", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentBenefitList(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentBenefitList list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		list.setAdvancedAgeRetirementReemploymentPlanId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentPlanId").toString()));
		try {
			json = objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentBenefitList",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentExpenditure", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentExpenditure(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AdvancedAgeRetirementReemploymentExpenditure[] list) {
		session = request.getSession();
		String seqData=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(seqData));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentExpenditure",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentExpenditure", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentExpenditure(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentExpenditure expenditure){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(expenditure);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentExpenditure",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBasicData", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentBasicData(HttpServletRequest request, HttpServletResponse response,
			@RequestBody AdvancedAgeRetirementReemploymentBasicData[] list) {
		session = request.getSession();
		String seqData=session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(seqData));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentBasicData",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBasicData", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentBasicData(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentBasicData basicData){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			basicData.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString()));
			json = objectMapper.writeValueAsString(basicData);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentBasicData",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentReceipt", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentReceipt(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeRetirementReemploymentReceipt[] list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setCompanyName(session.getAttribute(session.getId()+"companyName").toString());
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addAdvancedAgeRetirementReemploymentReceipt",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentReceipt", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentReceipt(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentReceipt listReceipt){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(listReceipt);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"delAdvancedAgeRetirementReemploymentReceipt",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentResult", method = RequestMethod.POST)
	public void addAdvancedAgeRetirementReemploymentResult(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeRetirementReemploymentResult result){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		result.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeRetirementReemploymentApplyId").toString()));
		result.setSeq(session.getAttribute(session.getId()+"seq").toString());
		try {
			json = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addAdvancedAgeRetirementReemploymentResult",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addCTypeAdvancedAgeBase", method = RequestMethod.POST)
	public void addATypeAdvancedAgeBase(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeBase base,MailRecord mailRecord){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addCTypeAdvancedAgeBase",json);
		
		mailRecord.setMailType("D");
		mailRecord.setMailContent("已收到臺端申請 中高齡者退休後再就業準備協助措施，案件將進入審查狀態。如需補件，將會再發送電子郵件通知，請隨時注意郵件。\r\n"
				+ "\r\n"
				+ "此信為系統自動發送，無須回信。\r\n"
				+ "相關問題請洽各受理單位\r\n"
				+ "https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx");
		try {
			sendEmail.sendMail(mailRecord.getEmail(),"僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫案件申請通知", mailRecord.getMailContent());
		} catch (AddressException e1) {
			logger.warn(e1.getMessage());
		} catch (MessagingException e1) {
			logger.warn(e1.getMessage());
		} catch (Exception e1) {
			logger.warn(e1.getMessage());
		}
		
		try {
			json = objectMapper.writeValueAsString(mailRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addMailRecord",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/editAdvancedAgeBaseCType", method = RequestMethod.POST)
	public void editAdvancedAgeBase(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeBase base){ 
		//修改案件狀態
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"editAdvancedAgeBase",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
		
	}
}