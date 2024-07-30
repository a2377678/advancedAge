package com.example.springboot.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.SendEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class RetirementAdvancedAgeExperienceInheritanceApplyController {
	
	Logger logger = LogManager.getLogger(AdvancedAgeApplyController.class);
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	public String ip;
	
	@Autowired
	SendEmail sendEmail;
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceApply", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceApply(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceApply",json));
		session.setAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId", object.get("id"));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritancePlan", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritancePlan(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritancePlan plan){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritancePlan",json));
		session.setAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritancePlanId", object.get("id"));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addExperienceInheritanceSpeakerList", method = RequestMethod.POST)
	public void addExperienceInheritanceSpeakerList(HttpServletRequest request, HttpServletResponse response
			,@RequestBody ExperienceInheritanceSpeakerList[] list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setRetirementAdvancedAgeExperienceInheritancePlanId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritancePlanId").toString()));
				try {
					json = objectMapper.writeValueAsString(list[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addExperienceInheritanceSpeakerList",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delExperienceInheritanceSpeakerList", method = RequestMethod.POST)
	public void delExperienceInheritanceSpeakerList(HttpServletRequest request, HttpServletResponse response
			,ExperienceInheritanceSpeakerList list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritancePlanId")!=null) {
			list.setRetirementAdvancedAgeExperienceInheritancePlanId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritancePlanId").toString()));
			try {
				json = objectMapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"delExperienceInheritanceSpeakerList",json);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceSchedule", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceSchedule(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeExperienceInheritanceSchedule[] scheduleList){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<scheduleList.length;i++)
			{
				scheduleList[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
				try {
					json = objectMapper.writeValueAsString(scheduleList[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceSchedule",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceSchedule", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeExperienceInheritanceSchedule(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceSchedule schedule){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId")!=null) {
			schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			try {
				json = objectMapper.writeValueAsString(schedule);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"delRetirementAdvancedAgeExperienceInheritanceSchedule",json);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeParticipateStudent", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeParticipateStudent(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeParticipateStudent[] ParticipateList){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<ParticipateList.length;i++)
			{
				ParticipateList[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
				try {
					json = objectMapper.writeValueAsString(ParticipateList[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeParticipateStudent",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delRetirementAdvancedAgeParticipateStudent", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeParticipateStudent(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeParticipateStudent participate){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId")!=null) {
			participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			try {
				json = objectMapper.writeValueAsString(participate);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"delRetirementAdvancedAgeParticipateStudent",json);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceExpenditure", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceExpenditure(HttpServletRequest request, HttpServletResponse response
			,@RequestBody RetirementAdvancedAgeExperienceInheritanceExpenditure[] expenditureList){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<expenditureList.length;i++)
			{
				expenditureList[i].setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
				try {
					json = objectMapper.writeValueAsString(expenditureList[i]);
				} catch (JsonProcessingException e) {
					logger.warn(e.getMessage());
				}
				api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceExpenditure",json);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceExpenditure", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeExperienceInheritanceExpenditure(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceExpenditure schedule){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		if(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId")!=null) {
			schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			try {
				json = objectMapper.writeValueAsString(schedule);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"delRetirementAdvancedAgeExperienceInheritanceExpenditure",json);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/addBTypeAdvancedAgeBase", method = RequestMethod.POST)
	public void addBTypeAdvancedAgeBase(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeBase base,MailRecord mailRecord){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addBTypeAdvancedAgeBase",json);
		
		mailRecord.setMailType("D");
		mailRecord.setMailContent("已收到臺端申請 僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫，案件將進入審查狀態。如需補件，將會再發送電子郵件通知，請隨時注意郵件。\r\n"
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
	
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceResult", method = RequestMethod.POST)
	public void addRetirementAdvancedAgeExperienceInheritanceResult(HttpServletRequest request, HttpServletResponse response
			,RetirementAdvancedAgeExperienceInheritanceResult result){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			result.setCompanyName(session.getAttribute(session.getId()+"companyName").toString());
			result.setSeq(session.getAttribute(session.getId()+"seq").toString());
			result.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			json = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"addRetirementAdvancedAgeExperienceInheritanceResult",json));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/editAdvancedAgeBaseBType", method = RequestMethod.POST)
	public void editAdvancedAgeBaseBType(HttpServletRequest request, HttpServletResponse response
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
