package com.example.springboot.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterKey;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.PdfUtil;
import com.example.springboot.util.RandomValidateCodeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class FrontendMainController {

	Logger logger = LogManager.getLogger(FrontendMainController.class);
	
	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	@Value("${encrypt_key}")
	private String key;
	
	@Value("${file_path}")
	private String filePath;
	
	HttpSession session;

	AdvancedAgeBase base;
	
	AdvancedAgeApply apply;

	AdvancedAgePlan plan;

	AdvancedAgeEmploymentList employmentList;

	AdvancedAgeEmploymentListReceipt employmentListReceipt;
	
	AdvancedAgeApplyEmployedSituation employedSituation;

	Attachment attachment;

	Parameter parameter;

	ParameterKey parameterKey;

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/employ")
	public String employ() {
		return "employ";
	}

	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("type") String type,Model model) {
		model.addAttribute("type",type);
		return "login";
	}
	
	@RequestMapping(value = "/change_password")
	public String change_password(){
		return "change_password";
	}
	
	@RequestMapping(value = "/schedule")
	public String schedule(HttpServletRequest request,Model model,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(session.getId()+"seq") == null) {
			redirectAttrs.addFlashAttribute("type", StringEscapeUtils.escapeHtml("AA"));
			return "redirect:/login";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base));
		// ???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		apply = new AdvancedAgeApply();
		if (session.getAttribute(session.getId()+"seq") != null) {
			// ------????????? start------
			apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
			AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", searchApply);

			String apiResponse = api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),"");
			jsonArray = new JSONArray(apiResponse);
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------????????? end--------

			// ------????????? start------
			plan = new AdvancedAgePlan();
			employmentList = new AdvancedAgeEmploymentList();

			plan.setAdvancedAgeApplyId(searchApply.getId());
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			
			if (searchPlan.getAttachEmploymentList() != null
					&& searchPlan.getAttachEmploymentList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("A");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileType("employmentList");
				attachment.setFileFrequency(1);
				model.addAttribute("employmentListAttachment", selectFiles(attachment).toList());
			}
			// ------?????????????????? start------
			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
			// ------?????????????????? end------
//			employedSituation = new AdvancedAgeApplyEmployedSituation();
//			employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//			model.addAttribute("advancedAgeApplyEmployedSituations",
//					selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			// ------????????? end--------

			// ------???????????? start------
			attachment = new Attachment();

			// ????????????????????????
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// ???????????????????????????????????????
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// ?????????????????????????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------???????????? end--------
		}

		return "schedule";
	}
	
	@RequestMapping(value = "/schedule_pass")
	public String schedule_pass(HttpServletRequest request,Model model,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			redirectAttrs.addFlashAttribute("type", StringEscapeUtils.escapeHtml("AR"));
			return "redirect:/login";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base));
		// ???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		apply = new AdvancedAgeApply();
		if (session.getAttribute(session.getId()+"seq") != null) {
			// ------????????? start------
			apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
			AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", searchApply);

			String apiResponse = api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),"");
			jsonArray = new JSONArray(apiResponse);
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------????????? end--------

			// ------????????? start------
			plan = new AdvancedAgePlan();
			employmentList = new AdvancedAgeEmploymentList();

			plan.setAdvancedAgeApplyId(searchApply.getId());
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			
			if (searchPlan.getAttachEmploymentList() != null
					&& searchPlan.getAttachEmploymentList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("A");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileType("employmentList");
				attachment.setFileFrequency(1);
				model.addAttribute("employmentListAttachment", selectFiles(attachment).toList());
			}
			// ------?????????????????? start------
			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
			// ------?????????????????? end------
//			employedSituation = new AdvancedAgeApplyEmployedSituation();
//			employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//			model.addAttribute("advancedAgeApplyEmployedSituations",
//					selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			// ------????????? end--------

			// ------???????????? start------
			attachment = new Attachment();

			// ????????????????????????
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// ???????????????????????????????????????
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// ?????????????????????????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------???????????? end--------
		}
		

		return "schedule_pass";
	}
	
	@RequestMapping(value = "/employ_01")
	public String employ_01()
			throws FileNotFoundException, DocumentException {
		return "employ_01";
	}

	@RequestMapping(value = "/employ_02")
	public String employ_02(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06";
		}
//		???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
//		????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

//      ?????????????????????
		apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
		searchApply.setCompanyName(session.getAttribute(session.getId()+"companyName").toString());
		searchApply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		model.addAttribute("apply", searchApply);

		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
		list = jsonArray.toList();
		model.addAttribute("areaList", list);

		return "employ_02";
	}

	@RequestMapping(value = "/employ_03")
	public String employ_03(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06?seq="+session.getId();
		}
//      ?????????????????????
		plan = new AdvancedAgePlan();
		employmentList = new AdvancedAgeEmploymentList();
		if (session.getAttribute(session.getId()+"advancedAgeApplyId") != null) {
			plan.setAdvancedAgeApplyId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeApplyId").toString()));
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			//0727??????
//			if (searchPlan.getAttachAssistanceMeasures() != null
//					&& searchPlan.getAttachAssistanceMeasures().equals("Y")) {
//				attachment = new Attachment();
//				attachment.setFileBelong("A");
//				attachment.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//				attachment.setFileType("assistanceMeasures");
//				attachment.setFileFrequency(1);
//				model.addAttribute("assistanceMeasuresAttachment", selectFiles(attachment).toList());
//			}
//			
//			if (searchPlan.getAttachFriendlyMeasures() != null
//					&& searchPlan.getAttachFriendlyMeasures().equals("Y")) {
//				attachment = new Attachment();
//				attachment.setFileBelong("A");
//				attachment.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//				attachment.setFileType("friendlyMeasures");
//				attachment.setFileFrequency(1);
//				model.addAttribute("friendlyMeasuresAttachment", selectFiles(attachment).toList());
//			}
//			
//			if (searchPlan.getAttachExpectedMeasuresEffectiveness() != null
//					&& searchPlan.getAttachExpectedMeasuresEffectiveness().equals("Y")) {
//				attachment = new Attachment();
//				attachment.setFileBelong("A");
//				attachment.setFileBelongId(Integer.valueOf(session.getAttribute("advancedAgeApplyId").toString()));
//				attachment.setFileType("expectedMeasuresEffectiveness");
//				attachment.setFileFrequency(1);
//				model.addAttribute("expectedMeasuresEffectivenessAttachment", selectFiles(attachment).toList());
//			}
			
			if (searchPlan.getAttachEmploymentList() != null
					&& searchPlan.getAttachEmploymentList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("A");
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeApplyId").toString()));
				attachment.setFileType("employmentList");
				attachment.setFileFrequency(1);
				model.addAttribute("employmentListAttachment", selectFiles(attachment).toList());
			}
			
			if (searchPlan.getId() != null) {
				employmentList = new AdvancedAgeEmploymentList();
				employmentList.setAdvancedAgePlanId(searchPlan.getId());
				model.addAttribute("advancedAgeEmploymentLists",
						selectAdvancedAgeEmploymentLists(employmentList).toList());

//				employedSituation = new AdvancedAgeApplyEmployedSituation();
//				employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//				model.addAttribute("advancedAgeApplyEmployedSituations",
//						selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			} else {
				model.addAttribute("advancedAgeEmploymentLists", "[]");
//				model.addAttribute("advancedAgeApplyEmployedSituations", "[]");
			}
		}

		return "employ_03";
	}

	@RequestMapping(value = "/employ_04")
	public String employ_04(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06";
		}
//      ?????????????????????
		attachment = new Attachment();
		if (session.getAttribute(session.getId()+"advancedAgeApplyId") != null) {
			// ????????????????????????
			attachment.setFileBelong("A");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeApplyId").toString()));
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// ???????????????????????????????????????
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// ????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}

		return "employ_04";
	}

	@RequestMapping(value = "/employ_05")
	public String employ_05(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06";
		}
		// ???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		apply = new AdvancedAgeApply();
		if (session.getAttribute(session.getId()+"seq") != null) {
			// ------????????? start------
			apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
			AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", searchApply);

			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------????????? end--------

			// ------????????? start------
			plan = new AdvancedAgePlan();

			plan.setAdvancedAgeApplyId(searchApply.getId());
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			
			if (searchPlan.getAttachEmploymentList() != null
					&& searchPlan.getAttachEmploymentList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("A");
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"advancedAgeApplyId").toString()));
				attachment.setFileType("employmentList");
				attachment.setFileFrequency(1);
				model.addAttribute("employmentListAttachment", selectFiles(attachment).toList());
			}
			// ------?????????????????? start------
			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
			// ------?????????????????? end------
//			employedSituation = new AdvancedAgeApplyEmployedSituation();
//			employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//			model.addAttribute("advancedAgeApplyEmployedSituations",
//					selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			// ------????????? end--------

			// ------???????????? start------
			attachment = new Attachment();

			// ????????????????????????
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// ???????????????????????????????????????
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// ?????????????????????????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------???????????? end--------
		}

		return "employ_05";
	}

	@RequestMapping(value = "/employ_06")
	public String employ_06(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_01";
		}
		return "employ_06";
	}

	@RequestMapping(value = "/employ_payment")
	public String employ_payment() {
		return "employ_payment";
	}
	
	@RequestMapping(value = "/employ_payment_01")
	public String employ_payment_01() {
		return "employ_payment_01";
	}
	
	@RequestMapping(value = "/employ_payment_02")
	public String employ_payment_02(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("seq", session.getAttribute(session.getId()+"seq"));
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId").toString());
//		-----------???????????????????????????---------
//		base = new AdvancedAgeBase();
//		base.setId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
//		if(Integer.valueOf(selectAdvancedAgeBaseById(base).getCaseStatus())>3)
//		{
//			return "redirect:/employ_payment_05?seq="+seq;
//		}
		/*//------------?????????????????? start------------
		// ------????????? start------
		apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(seq+"seq").toString());
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
		// ------????????? end--------

		// ------????????? start------
		plan = new AdvancedAgePlan();
		plan.setAdvancedAgeApplyId(searchApply.getId());
		AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
		
		// ------?????????????????? start------
		employmentList = new AdvancedAgeEmploymentList();
		employmentList.setAdvancedAgePlanId(searchPlan.getId());
		JSONArray array = selectAdvancedAgeEmploymentLists(employmentList);
		List<String> name = new ArrayList<String>(); 
		for(int i=0;i<array.toList().size();i++)
		{
			name.add(array.getJSONObject(i).getString("name"));
		}
		model.addAttribute("advancedAgeEmploymentName", name);
		//------------?????????????????? end------------*/
			
		employmentListReceipt = new AdvancedAgeEmploymentListReceipt();
		employmentListReceipt.setAdvancedAgeBaseId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
		employmentListReceipt.setSeq(session.getAttribute(session.getId()+"seq").toString());
		model.addAttribute("advancedAgeEmploymentListReceipts",selectAdvancedAgeEmploymentListReceipts(employmentListReceipt).toList());

		
		return "employ_payment_02";
	}

	@RequestMapping(value = "/employ_payment_03")
	public String employ_payment_03(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId").toString());
		
//		-----------???????????????????????????---------
		base = new AdvancedAgeBase();
		base.setId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
//		if(Integer.valueOf(selectAdvancedAgeBaseById(base).getCaseStatus())>3)
//		{
//			return "redirect:/employ_payment_05?seq="+seq;
//		}
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
		if(searchBase.getAllowanceFrequencyRecord() != null)
		{
			model.addAttribute("baseAllowanceFrequencyTime", searchBase.getAllowanceFrequencyRecord().split(";").length);
		}
		
//      ?????????????????????
		attachment = new Attachment();
		if (session.getAttribute(session.getId()+"baseId") != null) {
			// ??????????????????
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// ??????
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// ????????????
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
						
			// ????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "employ_payment_03";
	}

	@RequestMapping(value = "/employ_payment_04")
	public String employ_payment_04(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId").toString());
//		-----------???????????????????????????---------
//		base = new AdvancedAgeBase();
		base.setId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
//		if(Integer.valueOf(selectAdvancedAgeBaseById(base).getCaseStatus())>3)
//		{
//			return "redirect:/employ_payment_05?seq="+seq;
//		}
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
		if(searchBase.getAllowanceFrequencyRecord() != null)
		{
			model.addAttribute("baseAllowanceFrequencyTime", searchBase.getAllowanceFrequencyRecord().split(";").length);
		}
		
		employmentListReceipt = new AdvancedAgeEmploymentListReceipt();
		employmentListReceipt.setAdvancedAgeBaseId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
		employmentListReceipt.setSeq(session.getAttribute(session.getId()+"seq").toString());
		model.addAttribute("advancedAgeEmploymentListReceipts",selectAdvancedAgeEmploymentListReceipts(employmentListReceipt).toList());
		
		attachment = new Attachment();
		if (session.getAttribute(session.getId()+"baseId") != null) {
			// ??????????????????
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// ??????
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// ????????????
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
						
			// ????????????
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// ????????????
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// ?????????????????????????????????????????????????????????
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "employ_payment_04";
	}

	@RequestMapping(value = "/employ_payment_05")
	public String employ_payment_05(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		return "employ_payment_05";
	}
	
	@RequestMapping(value = "/password_01")
	public String password_01() {
		return "password_01";
	}

	@RequestMapping(value = "/password_02")
	public String password_02() {
		return "password_02";
	}

	@RequestMapping(value = "/register_01")
	public String register_01(Model model) {
//		???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
//		????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		return "register_01";
	}

	@RequestMapping(value = "/register_02")
	public String register_02() {
		return "register_02";
	}

	@RequestMapping(value = "/require")
	public String require() {
		return "require";
	}

	@RequestMapping(value = "/sitemap")
	public String sitemap() {
		return "sitemap";
	}

	@RequestMapping(value = "/downloadSample")
	public String downloadSample() {
		return "download";
	}

	@RequestMapping(value = "/service")
	public String service() {
		return "service";
	}

	@RequestMapping(value = "/teaching")
	public String teaching() {
		return "teaching";
	}
	
	@RequestMapping(value = "/downloadPdf")
	public void downloadPdf(String path,HttpServletResponse response) {
		path=filePath+path;
//    ?????????????????????
      String fileName = path.substring(path.lastIndexOf("/") + 1);
      FileInputStream in = null;
      ServletOutputStream out = null;
      try{
//	      ?????????????????????????????????????????????????????????????????????????????????????????????????????????
	      response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));//????????????????????????????????????????????????
//	      ??????????????????????????????
	      in = new FileInputStream(path);
//	      ???????????????
	      int len=0;
	      byte[] buffer=new byte[1024];
//	      ??????outputStream??????
	      out = response.getOutputStream();
//	      ???FileOutputStream?????????buffer,??????outputStream????????????????????????????????????
	      while((len=in.read(buffer))>0)
	      {
	          out.write(buffer,0,len);
	      }
	
      }catch(IOException e) {
    	  logger.warn(e.getMessage());
      }finally {
    	  try {
			in.close();
			out.close();
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
      }
	 }
	
	@RequestMapping(value = "/pdf")
	public void pdf(HttpServletRequest request,HttpServletResponse response) {
		session=request.getSession();
		// ???????????????????????????????????? ?????????????????????A4????????????????????????????????????
		// ??????A4????????? ??????????????????????????????????????????
		Document document = new Document();
		// ??????????????????PdfWriter???????????????pdf????????????
		// ????????????
		apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
		FileOutputStream outputStream = null;
		try {
		
			outputStream = new FileOutputStream(filePath+"/A/"+searchApply.getId()+"/data.pdf");
		PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
		// ???????????????????????????????????????????????????
		document.open();

		// ?????????????????????????????????????????????????????????????????????????????????
//        document.newPage();
		// ????????????????????????????????????

		// ??????
		Font title = PdfUtil.createFont(18, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
		Font content = PdfUtil.createFont(12, Font.NORMAL, BaseColor.BLACK);
		Font table = PdfUtil.createFont(8, Font.NORMAL, BaseColor.BLACK);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);

		PdfPCell cell3 = new PdfPCell();
		cell3.setBorder(Rectangle.NO_BORDER);
		cell3.setColspan(2);

		PdfPCell spaceCell = new PdfPCell();
		spaceCell.setBorder(Rectangle.NO_BORDER);
		spaceCell.setColspan(9);

		document.add(new Paragraph("?????????", title));
		document.add(new Paragraph("\n"));

		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(100);

		

		cell.setPhrase(new Paragraph("????????????:" + searchApply.getCompanyName(), content));
		table2.addCell(cell);
		cell.setPhrase(new Paragraph("????????????:" + searchApply.getSeq(), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		// ???????????????
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		JSONObject jsonObject = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getIndustry().equals(jsonObject.get("code"))) {
				cell.setPhrase(new Paragraph("?????????:" + jsonObject.get("name"), content));
				table2.addCell(cell);
				break;
			}
		}

		cell.setPhrase(new Paragraph("????????????:" + searchApply.getGuaranteeNumber().replace(";", ","), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		String address = "";
		// ????????????
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getContactCity().equals(jsonObject.get("code"))) {
				address = jsonObject.get("name").toString();
				// ????????????
				jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
				for (int j = 0; j < jsonArray.length(); j++) {
					jsonObject = jsonArray.getJSONObject(j);
					if (searchApply.getContactArea().equals(jsonObject.get("code"))) {
						address += jsonObject.get("name").toString();
						break;
					}
				}
				break;
			}
		}

		spaceCell.setPhrase(new Paragraph("????????????:" + address + searchApply.getContactAddress(), content));
		table2.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		cell.setPhrase(new Paragraph("?????????:" + searchApply.getContactName(), content));
		table2.addCell(cell);

		cell.setPhrase(new Paragraph("???????????????:" + searchApply.getContactJobtitle(), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		if (searchApply.getContactWorkPhoneExtension().equals("")) {
			cell.setPhrase(new Paragraph(
					"????????????:" + searchApply.getContactWorkPhoneAreaCode() + "-" + searchApply.getContactWorkPhone(),
					content));
			table2.addCell(cell);
		} else {
			cell.setPhrase(new Paragraph("????????????:" + searchApply.getContactWorkPhoneAreaCode() + "-"
					+ searchApply.getContactWorkPhone() + " #" + searchApply.getContactWorkPhoneExtension(), content));
			table2.addCell(cell);
		}
		cell.setPhrase(new Paragraph("????????????:" + searchApply.getContactPhone(), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		cell.setPhrase(new Paragraph("????????????:" + searchApply.getFaxAreaCode() + "-" + searchApply.getFax(), content));
		table2.addCell(cell);

		cell.setPhrase(new Paragraph("????????????:" + searchApply.getEmail(), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		document.add(table2);

		// ?????????
		document.add(new Paragraph("?????????", title));
		document.add(new Paragraph("\n"));

		PdfPTable table4 = new PdfPTable(4);
		table4.setWidthPercentage(100);

		// ????????????
		plan = new AdvancedAgePlan();
		plan.setAdvancedAgeApplyId(searchApply.getId());
		AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,session.getId());
		spaceCell.setPhrase(new Paragraph("????????????/??????/??????:" + searchPlan.getItems(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		cell.setPhrase(new Paragraph("??????????????????:" + searchPlan.getEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("65???????????????:" + searchPlan.getHighEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("45~64?????????:" + searchPlan.getMiddleEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("44???????????????:" + searchPlan.getLowEmploymentNumber(), content));
		table4.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		cell.setPhrase(new Paragraph("??????65?????????(A):" + searchPlan.getNearHighEmploymentNumber(), content));
		table4.addCell(cell);

		cell3.setPhrase(new Paragraph("????????????????????????(B):" + searchPlan.getContinueEmploymentNumber(), content));
		table4.addCell(cell3);

		spaceCell.setPhrase(new Paragraph("??????????????????(C):" + searchPlan.getContinueEmploymentPercentage() + "%", content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		document.add(table4);

		// ??????????????????????????????
		document.add(new Paragraph("??????????????????????????????", title));
		document.add(new Paragraph("\n"));
		
		if (searchPlan.getAttachEmploymentList() != null
				&& searchPlan.getAttachEmploymentList().equals("Y")) {
			PdfPTable table3EmploymentList = new PdfPTable(3);
			table3EmploymentList.setWidthPercentage(100);
		
			attachment = new Attachment();
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileType("employmentList");
			attachment.setFileFrequency(1);
			JSONArray employmentList = selectFiles(attachment);
			
			cell.setPhrase(new Paragraph(employmentList.getJSONObject(0).get("fileName").toString(), content));
			table3EmploymentList.addCell(cell);

			cell.setPhrase(new Paragraph(employmentList.getJSONObject(0).get("createTime").toString().replace("-", "/").substring(0,
					employmentList.getJSONObject(0).get("createTime").toString().lastIndexOf(":")), content));
			table3EmploymentList.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(employmentList.getJSONObject(0).get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3EmploymentList.addCell(cell);
			
			spaceCell.setPhrase(new Paragraph("\n"));
			table3EmploymentList.addCell(cell);
			
			document.add(table3EmploymentList);
		}
		if (searchPlan.getAttachEmploymentList() != null
				&& searchPlan.getAttachEmploymentList().equals("N")) {
			
			PdfPTable table10EmploymentList = new PdfPTable(10);
			table10EmploymentList.setWidthPercentage(100);
			
			cell.setPhrase(new Paragraph("??????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("???????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("???????????????", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("??????????????????", table));
			table10EmploymentList.addCell(cell);
			
//			spaceCell.setPhrase(new Paragraph("\n"));
//			table10EmploymentList.addCell(spaceCell);

			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			JSONArray employment = selectAdvancedAgeEmploymentLists(employmentList);
			
			for(int i=0;i<employment.toList().size();i++)
			{
				cell.setPhrase(new Paragraph(String.valueOf(i+1), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("name").toString(), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("identification").toString(), table));
				table10EmploymentList.addCell(cell);
				if(employment.getJSONObject(i).get("laborProtectionTime").toString().length()==7)
				{
					cell.setPhrase(new Paragraph("????????????", table));
					table10EmploymentList.addCell(cell);
					
					String date=employment.getJSONObject(i).get("laborProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
					cell.setPhrase(new Paragraph("????????????", table));
					table10EmploymentList.addCell(cell);
					
					String date=employment.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}
				
				if(employment.getJSONObject(i).get("manager").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("??????", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("manager").toString().equals("N")) {
					cell.setPhrase(new Paragraph("?????????", table));
					table10EmploymentList.addCell(cell);
				}
				
				if(employment.getJSONObject(i).get("relatives").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("????????????", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("relatives").toString().equals("N")) {
					cell.setPhrase(new Paragraph("????????????", table));
					table10EmploymentList.addCell(cell);
				}

				if(employment.getJSONObject(i).get("workingHours").toString().equals("A")) {
					cell.setPhrase(new Paragraph("??????", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("workingHours").toString().equals("P")) {
					cell.setPhrase(new Paragraph("????????????", table));
					table10EmploymentList.addCell(cell);
				}
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("recurringSalary").toString(), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("notRecurringSalary").toString(), table));
				table10EmploymentList.addCell(cell);

			}
			document.add(table10EmploymentList);
		}
		// ------?????????????????? start------
//		employmentList = new AdvancedAgeEmploymentList();
//		employmentList.setAdvancedAgePlanId(searchPlan.getId());
//		model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
//		// ------?????????????????? end------
//		ASDSA
		// ????????????
		document.add(new Paragraph("????????????", title));
		document.add(new Paragraph("\n"));

		PdfPTable table3 = new PdfPTable(3);
		table3.setWidthPercentage(100);

		spaceCell.setPhrase(new Paragraph("????????????????????????:", content));
		table3.addCell(spaceCell);
		attachment = new Attachment();
		// ????????????????????????
		attachment.setFileBelong("A");
		attachment.setFileBelongId(Integer.valueOf(searchApply.getId()));
		attachment.setFileFrequency(1);
		attachment.setFileType("register");
		jsonArray = selectFiles(attachment);
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			cell.setPhrase(new Paragraph(jsonObject.get("fileName").toString(), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(jsonObject.get("createTime").toString().replace("-", "/").substring(0,
					jsonObject.get("createTime").toString().lastIndexOf(":")), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(jsonObject.get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3.addCell(cell);
		}
		spaceCell.setPhrase(new Paragraph("\n"));
		table3.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("???????????????????????????????????????:", content));
		table3.addCell(spaceCell);
		// ???????????????????????????????????????
		attachment.setFileType("insure");
		jsonArray = selectFiles(attachment);

		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			cell.setPhrase(new Paragraph(jsonObject.get("fileName").toString(), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(jsonObject.get("createTime").toString().replace("-", "/").substring(0,
					jsonObject.get("createTime").toString().lastIndexOf(":")), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(jsonObject.get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3.addCell(cell);
		}
		spaceCell.setPhrase(new Paragraph("\n"));
		table3.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("??????????????????:", content));
		table3.addCell(spaceCell);
		// ?????????????????????????????????
		attachment.setFileType("salary");
		jsonArray = selectFiles(attachment);

		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			cell.setPhrase(new Paragraph(jsonObject.get("fileName").toString(), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(jsonObject.get("createTime").toString().replace("-", "/").substring(0,
					jsonObject.get("createTime").toString().lastIndexOf(":")), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(jsonObject.get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3.addCell(cell);
		}
		spaceCell.setPhrase(new Paragraph("\n"));
		table3.addCell(spaceCell);
		
		spaceCell.setPhrase(new Paragraph("??????????????????:", content));
		table3.addCell(spaceCell);
		// ??????????????????
		attachment.setFileType("attendance");
		jsonArray = selectFiles(attachment);

		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			cell.setPhrase(new Paragraph(jsonObject.get("fileName").toString(), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(jsonObject.get("createTime").toString().replace("-", "/").substring(0,
					jsonObject.get("createTime").toString().lastIndexOf(":")), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(jsonObject.get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3.addCell(cell);
		}
		spaceCell.setPhrase(new Paragraph("\n"));
		table3.addCell(spaceCell);
		
		spaceCell.setPhrase(new Paragraph("????????????:", content));
		table3.addCell(spaceCell);
		// ????????????
		attachment.setFileType("necessary");
		jsonArray = selectFiles(attachment);

		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			cell.setPhrase(new Paragraph(jsonObject.get("fileName").toString(), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(jsonObject.get("createTime").toString().replace("-", "/").substring(0,
					jsonObject.get("createTime").toString().lastIndexOf(":")), content));
			table3.addCell(cell);

			cell.setPhrase(new Paragraph(
					(double) Math.round(Double.valueOf(jsonObject.get("fileSize").toString()) / 1024 * 10) / 10 + " KB",
					content));
			table3.addCell(cell);
		}
		
		document.add(table3);
		// ????????????
		document.close();
		// ???????????????
		pdfWriter.close();
		}catch(FileNotFoundException e ) {
			logger.warn(e.getMessage());
		}catch(DocumentException e) {
			logger.warn(e.getMessage());
		}
		finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("{\"status\":\"success\",\"path\":\""+"/A/"+StringEscapeUtils.escapeHtml(searchApply.getId().toString())+"/data.pdf\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}

	}

	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeApply searchApply = new AdvancedAgeApply();
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeApply", json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchApply = mapper.readValue(jsondata, AdvancedAgeApply.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchApply;
	}

	public AdvancedAgePlan selectAdvancedAgePlan(AdvancedAgePlan plan,String sid) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgePlan searchPlan = new AdvancedAgePlan();
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgePlan", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchPlan = mapper.readValue(jsondata, AdvancedAgePlan.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		session.setAttribute(sid+"advancedAgePlanId", searchPlan.getId());
		return searchPlan;
	}

	public JSONArray selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList employmentList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeEmploymentLists", json));
		return array;
	}

	public JSONArray selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentListReceipt);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeEmploymentListReceipts", json));
		return array;
	}
	
	public JSONArray selectAdvancedAgeApplyEmployedSituations(AdvancedAgeApplyEmployedSituation employmentSituation) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentSituation);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeApplyEmployedSituations", json));
		return array;
	}

	public JSONArray selectFiles(Attachment attachment) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(attachment);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectFiles", json));
		return array;
	}
	
	public AdvancedAgeBase selectATypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectATypeAdvancedAgeBase", json));
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (array.length()>0) {
				searchBase = mapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);}
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}
	
	public AdvancedAgeBase selectAdvancedAgeBaseById(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeBaseById", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchBase = mapper.readValue(jsondata, AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}
	
	@RequestMapping(value = "/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");// ??????????????????,???????????????????????????????????????
		response.setHeader("Pragma", "No-cache");// ????????????????????????????????????????????????????????????
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
		randomValidateCode.getRandcode(request, response);// ???????????????????????????
	}

	/**
	 * ???????????????
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkVerify", method = RequestMethod.POST)
	public void checkVerify(HttpServletRequest request, HttpServletResponse response, String verifyInput,CompanyInfo info)
			throws IOException {
		try {
			session = request.getSession();
			// ???session??????????????????
			String inputStr = verifyInput;
			String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
			if (random == null) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
			if (random != null && random.equals(inputStr)) {
				info.setPassword(AesUtil.encrypt(info.getPassword()));
				JSONObject company = checkCompanyInfo(info);
				if(company.get("seq").equals(null))
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("password error");
				}else
				{
					session.setAttribute(session.getId()+"seq", info.getSeq());
					session.setAttribute(session.getId()+"companyName", company.get("companyName"));
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("success");
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("fail");
		} 
	}

	@RequestMapping(value = "/paymentCheckVerify", method = RequestMethod.POST)
	public void paymentCheckVerify(HttpServletRequest request, HttpServletResponse response, String verifyInput,CompanyInfo info)
			throws IOException {
		try {
			session = request.getSession();
			// ???session??????????????????
			String inputStr = verifyInput;
			String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
			if (random == null) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
			if (random != null && random.equals(inputStr)) {
				info.setPassword(AesUtil.encrypt(info.getPassword()));
				JSONObject company = checkCompanyInfo(info);
				if(company.get("seq").equals(null))
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("password error");
				}else
				{
					session.setAttribute(session.getId()+"seq", info.getSeq());
					session.setAttribute(session.getId()+"companyName", company.get("companyName"));
					base = new AdvancedAgeBase();
					base.setSeq(info.getSeq());
					AdvancedAgeBase searchBase = selectATypeAdvancedAgeBase(base);
					if(searchBase.getSeq()== null )
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("no base");
					}else if(searchBase.getCaseStatus().equals("1"))
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("audit");
					}else if(searchBase.getCaseStatus().equals("2"))
					{
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("failed");
					}
					else{
						session.setAttribute(session.getId()+"baseId", searchBase.getId());
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("success");
					}
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
		} catch (IOException e) {
			logger.warn(e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("fail");
		}
	}
	
	public JSONObject checkCompanyInfo(CompanyInfo info){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"checkCompanyInfo",json));
		return object;
	}
	
}
