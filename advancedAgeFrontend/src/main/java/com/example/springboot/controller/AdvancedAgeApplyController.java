package com.example.springboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
import com.example.springboot.entity.Attachment;
import com.example.springboot.util.CallApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller 
public class AdvancedAgeApplyController {
	
	CallApi api = new CallApi();
	
	HttpSession session;
	
	@Value("${api_ip}")
	public String ip;
	
	
	@RequestMapping(value = "/addAdvancedAgeApply", method = RequestMethod.POST)
	public void addAdvancedAgeApply(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeApply apply){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			apply.setAttachDocumentsApply("Y");
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip+"addAdvancedAgeApply",json);
		JSONObject object = new JSONObject(body);
		session.setAttribute(apply.getSeq()+"advancedAgeApplyId", object.get("id"));
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgePlan", method = RequestMethod.POST)
	public void addAdvancedAgePlan(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgePlan plan,String seq){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		plan.setAdvancedAgeApplyId(Integer.valueOf(session.getAttribute(seq+"advancedAgeApplyId").toString()));
		try {
			json = objectMapper.writeValueAsString(plan);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip+"addAdvancedAgePlan",json);
		JSONObject object = new JSONObject(body);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute(seq+"advancedAgePlanId", object.get("id"));
		session.setAttribute("advancedAgePlanId", object.get("id"));
		session.setAttribute("advancedAgeApplyId", object.get("advancedAgeApplyId"));
		AdvancedAgeApply apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(seq+"seq").toString());
		apply.setAttachDocumentsPlan("Y");
		addAdvancedAgeApply(request,response,apply);
	}
	
	@RequestMapping(value = "/addAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public void addAdvancedAgeEmploymentList(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeEmploymentList[] list){ 
		session = request.getSession();
		String seqData=session.getAttribute("advancedAgePlanId").toString();
		session.removeAttribute("advancedAgePlanId");
		session.removeAttribute("advancedAgeApplyId");
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setAdvancedAgePlanId(Integer.valueOf(seqData));
				try {
					json = objectMapper.writeValueAsString(list[i]);
					System.out.println("json : "+json);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"addAdvancedAgeEmploymentList",json);
				Thread.sleep(500);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentList(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeEmploymentList list,String seq){ 
		System.out.println("seq = "+seq);
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		list.setAdvancedAgePlanId(Integer.valueOf(session.getAttribute(seq+"advancedAgePlanId").toString()));
		try {
			json = objectMapper.writeValueAsString(list);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip+"delAdvancedAgeEmploymentList",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public void addAdvancedAgeEmploymentListReceipt(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeEmploymentListReceipt[] list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			for(int i=0;i<list.length;i++)
			{
				list[i].setCompanyName(session.getAttribute(list[i].getSeq()+"companyName").toString());
				try {
					json = objectMapper.writeValueAsString(list[i]);
					System.out.println("json : "+json);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				api.httpPost(ip+"addAdvancedAgeEmploymentListReceipt",json);
				Thread.sleep(500);
			}
			response.setContentType("text/html;charset=UTF-8");
		
			response.getWriter().print("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListReceipt(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeEmploymentListReceipt listReceipt){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(listReceipt);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip+"delAdvancedAgeEmploymentListReceipt",json);
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addAdvancedAgeApplyEmployedSituation", method = RequestMethod.POST)
	public void addAdvancedAgeApplyEmployedSituation(HttpServletRequest request, HttpServletResponse response
			,@RequestBody AdvancedAgeApplyEmployedSituation[] list){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		for(int i=0;i<list.length;i++)
		{
			list[i].setAdvancedAgePlanId(Integer.valueOf(session.getAttribute("advancedAgePlanId").toString()));
			try {
				json = objectMapper.writeValueAsString(list[i]);
				System.out.println("json : "+json);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			api.httpPost(ip+"addAdvancedAgeApplyEmployedSituation",json);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addATypeAdvancedAgeBase", method = RequestMethod.POST)
	public void addATypeAdvancedAgeBase(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeBase base){ 
		session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		
		try {
			json = objectMapper.writeValueAsString(base);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip+"addATypeAdvancedAgeBase",json);
		JSONObject object = new JSONObject(body);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value = "/editAdvancedAgeBase", method = RequestMethod.POST)
	public void editAdvancedAgeBase(HttpServletRequest request, HttpServletResponse response
			,AdvancedAgeBase base){ 
		//修改案件狀態
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		System.out.println("base id = "+base.getId());
		try {
			json = objectMapper.writeValueAsString(base);
			System.out.println("json : "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String body = api.httpPost(ip+"editAdvancedAgeBase",json);
		
		//修改補助名單此次請領次數
		json="";
		System.out.println("base id = "+base.getId());
		AdvancedAgeEmploymentListReceipt receipt = new AdvancedAgeEmploymentListReceipt();
		receipt.setAdvancedAgeBaseId(base.getId());
		try {
			json = objectMapper.writeValueAsString(receipt);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.httpPost(ip+"editAdvancedAgeEmploymentListReceipt",json);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}