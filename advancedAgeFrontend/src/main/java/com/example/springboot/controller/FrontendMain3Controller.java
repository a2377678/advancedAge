package com.example.springboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterKey;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.PdfUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Controller
public class FrontendMain3Controller {

	Logger logger = LogManager.getLogger(FrontendMain3Controller.class);

	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	@Value("${file_path}")
	private String filePath;

	@Value("${mail_domain}")
	private String mailDomain;
	
	HttpSession session;

	AdvancedAgeBase base;

	AdvancedAgeRetirementReemploymentApply reemploymentApply;

	AdvancedAgeRetirementReemploymentPlan reemploymentPlan;

	AdvancedAgeRetirementReemploymentBenefitList benefitList;

	AdvancedAgeRetirementReemploymentExpenditure expenditure;

	AdvancedAgeRetirementReemploymentBasicData basicData;

	AdvancedAgeRetirementReemploymentResult result;

	Attachment attachment;

	Parameter parameter;

	ParameterKey parameterKey;

	@RequestMapping(value = "/schedule_career_login")
	public String schedule_career_login(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/login";
		}else {
			return "redirect:/schedule_career";
		}
		
	}

	@RequestMapping(value = "/schedule_career")
	public String schedule_career(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/schedule_career_login";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		searchBase = selectCTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		if (searchBase.getCaseStatus() != null) {
			// 行業別列表
			JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// 縣市列表
			String cityJsonString = api.httpPost(ip + "getCityList", "");
			jsonArray = new JSONArray(cityJsonString);
			list = jsonArray.toList();
			model.addAttribute("cityList", list);

			model.addAttribute("mailDomain", mailDomain);
			
			reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
			if (session.getAttribute(session.getId() + "seq") != null) {
				// ------申請表 start------
				reemploymentApply.setSeq(session.getAttribute(session.getId() + "seq").toString());
				AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
						reemploymentApply);
				model.addAttribute("apply", searchApply);

				jsonArray = new JSONArray(
						api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(), ""));
				list = jsonArray.toList();
				model.addAttribute("areaList", list);
				// ------申請表 end--------

				// ------計畫書 start------
				reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();

				reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
				AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
						reemploymentPlan, session.getId());
				model.addAttribute("subsidyType", parseSubsidyType(searchPlan.getSubsidyType()));
				model.addAttribute("multipleApplications", parseYNtoChinese(searchPlan.getMultipleApplications()));
				model.addAttribute("applySameYear", parseYNtoChinese(searchPlan.getApplySameYear()));
				model.addAttribute("executionCity", parseCity(cityJsonString, searchPlan.getExecutionCity()));
				model.addAttribute("plan", searchPlan);

				if (searchPlan.getAttachBenefitList() != null && searchPlan.getAttachBenefitList().equals("Y")) {
					attachment = new Attachment();
					attachment.setFileBelong("C");
					attachment.setFileBelongId(searchApply.getId());
					attachment.setFileType("advancedAgeRetirementReemploymentBenefitList");
					attachment.setFileFrequency(1);
					model.addAttribute("benefitListAttachment", selectFiles(attachment).toList());
				}

				benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(searchPlan.getId());
				model.addAttribute("benefitLists",
						selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList());
				// ------計畫書 end--------

				// ------經費概算 start------
				List<AdvancedAgeRetirementReemploymentExpenditure> expenditures = null;
				expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
				expenditure.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
				expenditures = selectAdvancedAgeRetirementReemploymentExpenditures(expenditure);
				model.addAttribute("expenditures", expenditures);
				// ------經費概算 end--------

				// ------聯合辦理單位 start------
				basicData = new AdvancedAgeRetirementReemploymentBasicData();
				List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = null;
				basicData.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
				basicDataList = selectAdvancedAgeRetirementReemploymentBasicDataList(basicData);
				model.addAttribute("basicDataList", basicDataList);
				// ------聯合辦理單位 end--------

				// ------檢附文件 start------
				attachment = new Attachment();

				// 設立登記證明文件
				attachment.setFileBelong("C");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileFrequency(1);
				attachment.setFileType("register");
				model.addAttribute("registerAttachment", selectFiles(attachment).toList());

				// 設立登記證明文件
				attachment.setFileType("jointAuthorize");
				model.addAttribute("jointAuthorizeAttachment", selectFiles(attachment).toList());

				// 其他經本署或各分署認定有必要提出之文件
				attachment.setFileType("necessary");
				model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
				// ------檢附文件 end--------
			}
		}
		return "schedule_career";
	}

	@RequestMapping(value = "/schedule_career_payment_login")
	public String schedule_teach_payment_login(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/login";
		}else {
			return "redirect:/schedule_career_payment";
		}
	}

	@RequestMapping(value = "/schedule_career_payment")
	public String schedule_career_payment(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null
			) {
//			redirectAttrs.addFlashAttribute("caseType", StringEscapeUtils.escapeHtml("C"));
			return "redirect:/schedule_career_payment_login";
		}
		
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		base = selectCTypeAdvancedAgeBase(base);
		model.addAttribute("base", base);
		
		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		reemploymentApply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(reemploymentApply);
		// 資料是否已存在
		result = new AdvancedAgeRetirementReemploymentResult();
		result.setSeq(session.getAttribute(session.getId() + "seq").toString());
		result.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
		model.addAttribute("result", selectAdvancedAgeRetirementReemploymentResult(result));

		attachment = new Attachment();
		if (base.getId() != null) {
			model.addAttribute("baseAllowanceFrequencyTime", base.getAllowanceFileStatusRecord().split(";").length);
			// 本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(base.getId());
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 成果報告
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());

			// 經費支用單據正本及明細表
			attachment.setFileType("expenditureDetails");
			model.addAttribute("expenditureDetailsAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "schedule_career_payment";
	}

	@RequestMapping(value = "/career")
	public String career(HttpServletRequest request) {
		session=request.getSession();
		if(session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "login";
		}else{
			return "career";
		}
		
	}

	@RequestMapping(value = "/career_01")
	public String career_01(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			session.setAttribute(session.getId() + "redirectPath", "career_02");
			return "redirect:/login";
		}else {
			return "redirect:/career_02";
		}
	}

	@RequestMapping(value = "/career_02")
	public String career_02(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}
//		行業別列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
//		縣市列表
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);
		
//      資料是否已存在
		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		reemploymentApply.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
				reemploymentApply);
		
		
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setSeq(base.getSeq());
		try {
			JSONObject CompanyInfo_jsonobject = selectCompanyInfoData(cinfo);
			model.addAttribute("companyInfoData", CompanyInfo_jsonobject);
			model.addAttribute("companyRegisterAreaList", new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + CompanyInfo_jsonobject.get("registerCity"),"")).toList());
			model.addAttribute("companyContactAreaList", new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + CompanyInfo_jsonobject.get("contactCity"),"")).toList());
			model.addAttribute("apply", searchApply);
			
		}catch(JSONException e) {
			if(session.getAttribute(session.getId()+"companyName") != null)
			{
				searchApply.setCompanyName(session.getAttribute(session.getId()+"companyName").toString());
			}
			searchApply.setSeq(session.getAttribute(session.getId()+"seq").toString());
			model.addAttribute("apply", searchApply);
			logger.warn(e.getMessage());
		}

		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(), ""));
		list = jsonArray.toList();
		model.addAttribute("contactAreaList", list);

		model.addAttribute("registerAreaList",
				new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getRegisterCity(), "")).toList());

		return "career_02";
	}

	@RequestMapping(value = "/career_03")
	public String career_03(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}
//		縣市列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("cityList", list);
//      資料是否已存在
		reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();
		if (session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId") != null) {
			List<Object> benefitLists = new ArrayList<>();
			reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(
					session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
			AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
					reemploymentPlan, session.getId());
			model.addAttribute("plan", searchPlan);

			if (searchPlan.getId() != null) {
				benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(searchPlan.getId());
				benefitLists = selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList();
			}
			
			if (searchPlan.getAttachBenefitList() != null && searchPlan.getAttachBenefitList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("C");
				attachment.setFileBelongId(Integer.valueOf(
						session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
				attachment.setFileType("advancedAgeRetirementReemploymentBenefitList");
				attachment.setFileFrequency(1);
				model.addAttribute("advancedAgeRetirementReemploymentBenefitListAttachment",
						selectFiles(attachment).toList());
			} 
			
			model.addAttribute("advancedAgeRetirementReemploymentBenefitLists", benefitLists);

		}
		return "career_03";
	}

	@RequestMapping(value = "/career_04")
	public String career_04(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}
//      資料是否已存在
		reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();
		expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
		List<AdvancedAgeRetirementReemploymentExpenditure> expenditures = null;
		if (session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId") != null) {
			Integer applyId = Integer.valueOf(
					session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString());
			reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(applyId);
			AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
					reemploymentPlan, session.getId());
			model.addAttribute("plan", searchPlan);
			if (searchPlan.getAttachExpenditure() != null && searchPlan.getAttachExpenditure().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("C");
				attachment.setFileBelongId(applyId);
				attachment.setFileType("advancedAgeRetirementReemploymentExpenditure");
				attachment.setFileFrequency(1);
				model.addAttribute("advancedAgeRetirementReemploymentExpenditureAttachment",
						selectFiles(attachment).toList());
			}
			
			expenditure.setAdvancedAgeRetirementReemploymentApplyId(applyId);
			expenditures = selectAdvancedAgeRetirementReemploymentExpenditures(expenditure);
			model.addAttribute("expenditures", expenditures);
		} else {
			expenditures = new ArrayList<>();
			model.addAttribute("expenditures", expenditures);
		}
		return "career_04";
	}

	@RequestMapping(value = "/career_05")
	public String career_05(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}
//		行業別列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);

//      資料是否已存在
		reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();
		basicData = new AdvancedAgeRetirementReemploymentBasicData();
		List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = null;
		if (session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId") != null) {
			Integer applyId = Integer.valueOf(
					session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString());
			reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(applyId);
			AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
					reemploymentPlan, session.getId());
			model.addAttribute("plan", searchPlan);
			if (searchPlan.getAttachBasicData() != null && searchPlan.getAttachBasicData().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("C");
				attachment.setFileBelongId(applyId);
				attachment.setFileType("advancedAgeRetirementReemploymentBasicDataList");
				attachment.setFileFrequency(1);
				model.addAttribute("advancedAgeRetirementReemploymentBasicDataListAttachment",
						selectFiles(attachment).toList());
			} 
			basicData.setAdvancedAgeRetirementReemploymentApplyId(applyId);
			basicDataList = selectAdvancedAgeRetirementReemploymentBasicDataList(basicData);
			model.addAttribute("basicDataList", basicDataList);
		} else {
			basicDataList = new ArrayList<>();
			model.addAttribute("basicDataList", basicDataList);
		}

		return "career_05";
	}

	@RequestMapping(value = "/career_06")
	public String career_06(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}

//		資料是否已存在
		attachment = new Attachment();
		if (session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId") != null) {
			// 設立登記證明文件
			attachment.setFileBelong("C");
			attachment.setFileBelongId(Integer.valueOf(
					session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 投保勞保或職災保險證明文件
			attachment.setFileType("jointAuthorize");
			model.addAttribute("jointAuthorizeAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "career_06";
	}

	@RequestMapping(value = "/career_07")
	public String career_07(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeBase searchBase=selectCTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/career_08";
		}

		// 行業別列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// 縣市列表
		String cityJsonString = api.httpPost(ip + "getCityList", "");
		jsonArray = new JSONArray(cityJsonString);
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		if (session.getAttribute(session.getId() + "seq") != null) {
			// ------申請表 start------
			reemploymentApply.setSeq(session.getAttribute(session.getId() + "seq").toString());
			AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
					reemploymentApply);
			model.addAttribute("companyAttributes", parseCompanyAttributes(searchApply.getCompanyAttributes()));
			model.addAttribute("apply", searchApply);

			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(), ""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------申請表 end--------

			// ------計畫書 start------
			reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();

			reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
					reemploymentPlan, session.getId());
			model.addAttribute("subsidyType", parseSubsidyType(searchPlan.getSubsidyType()));
			model.addAttribute("multipleApplications", parseYNtoChinese(searchPlan.getMultipleApplications()));
			model.addAttribute("applySameYear", parseYNtoChinese(searchPlan.getApplySameYear()));
			model.addAttribute("executionCity", parseCity(cityJsonString, searchPlan.getExecutionCity()));
			model.addAttribute("plan", searchPlan);

			if (searchPlan.getAttachBenefitList() != null && searchPlan.getAttachBenefitList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("C");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileType("advancedAgeRetirementReemploymentBenefitList");
				attachment.setFileFrequency(1);
				model.addAttribute("benefitListAttachment", selectFiles(attachment).toList());
			}

			benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			benefitList.setAdvancedAgeRetirementReemploymentPlanId(searchPlan.getId());
			model.addAttribute("benefitLists",
					selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList());
			// ------計畫書 end--------

			// ------經費概算 start------
			List<AdvancedAgeRetirementReemploymentExpenditure> expenditures = null;
			expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			expenditure.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			expenditures = selectAdvancedAgeRetirementReemploymentExpenditures(expenditure);
			model.addAttribute("expenditures", expenditures);
			// ------經費概算 end--------

			// ------聯合辦理單位 start------
			basicData = new AdvancedAgeRetirementReemploymentBasicData();
			List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = null;
			basicData.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			basicDataList = selectAdvancedAgeRetirementReemploymentBasicDataList(basicData);
			model.addAttribute("basicDataList", basicDataList);
			// ------聯合辦理單位 end--------

			// ------檢附文件 start------
			attachment = new Attachment();

			// 設立登記證明文件
			attachment.setFileBelong("C");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 設立登記證明文件
			attachment.setFileType("jointAuthorize");
			model.addAttribute("jointAuthorizeAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------檢附文件 end--------
		}
		return "career_07";
	}

	@RequestMapping(value = "/career_08")
	public String career_08(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase=new AdvancedAgeBase();
		searchBase=selectCTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		
		// 行業別列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// 縣市列表
		String cityJsonString = api.httpPost(ip + "getCityList", "");
		jsonArray = new JSONArray(cityJsonString);
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
//		if (session.getAttribute(session.getId() + "seq") != null) {
			// ------申請表 start------
			reemploymentApply.setSeq(session.getAttribute(session.getId() + "seq").toString());
			AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
					reemploymentApply);
			model.addAttribute("companyAttributes", parseCompanyAttributes(searchApply.getCompanyAttributes()));
			model.addAttribute("apply", searchApply);

			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(), ""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------申請表 end--------

			// ------計畫書 start------
			reemploymentPlan = new AdvancedAgeRetirementReemploymentPlan();

			reemploymentPlan.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			AdvancedAgeRetirementReemploymentPlan searchPlan = selectAdvancedAgeRetirementReemploymentPlan(
					reemploymentPlan, session.getId());
			model.addAttribute("subsidyType", parseSubsidyType(searchPlan.getSubsidyType()));
			model.addAttribute("multipleApplications", parseYNtoChinese(searchPlan.getMultipleApplications()));
			model.addAttribute("applySameYear", parseYNtoChinese(searchPlan.getApplySameYear()));
			model.addAttribute("executionCity", parseCity(cityJsonString, searchPlan.getExecutionCity()));
			model.addAttribute("plan", searchPlan);

			if (searchPlan.getAttachBenefitList() != null && searchPlan.getAttachBenefitList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("C");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileType("advancedAgeRetirementReemploymentBenefitList");
				attachment.setFileFrequency(1);
				model.addAttribute("benefitListAttachment", selectFiles(attachment).toList());
			}

			benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			benefitList.setAdvancedAgeRetirementReemploymentPlanId(searchPlan.getId());
			model.addAttribute("benefitLists",
					selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList());
			// ------計畫書 end--------

			// ------經費概算 start------
			List<AdvancedAgeRetirementReemploymentExpenditure> expenditures = null;
			expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			expenditure.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			expenditures = selectAdvancedAgeRetirementReemploymentExpenditures(expenditure);
			model.addAttribute("expenditures", expenditures);
			// ------經費概算 end--------

			// ------聯合辦理單位 start------
			basicData = new AdvancedAgeRetirementReemploymentBasicData();
			List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = null;
			basicData.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
			basicDataList = selectAdvancedAgeRetirementReemploymentBasicDataList(basicData);
			model.addAttribute("basicDataList", basicDataList);
			// ------聯合辦理單位 end--------

			// ------檢附文件 start------
			attachment = new Attachment();

			// 設立登記證明文件
			attachment.setFileBelong("C");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 設立登記證明文件
			attachment.setFileType("jointAuthorize");
			model.addAttribute("jointAuthorizeAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------檢附文件 end--------
//		}
		return "career_08";
	}

	@RequestMapping(value = "/pdfCType")
	public void pdfCType(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		// 第一步：建立一個文件例項 設定文件紙張為A4，文件排列方式為橫向排列
		// 實現A4紙頁面 並且縱向排列（不設定則為橫向
		Document document = new Document();
		// 第二步：建立PdfWriter物件，設定pdf生成路徑
		// 申請資料
		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		reemploymentApply.setSeq(session.getAttribute(session.getId() + "seq").toString());
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
				reemploymentApply);
		FileOutputStream outputStream = null;

		try {
			File directory = new File(filePath + "/C/" + searchApply.getId() + "/data.pdf").getCanonicalFile();
			// 路徑是否存在
			if (!directory.getParentFile().exists()) {
				try {
					boolean checkPFile = directory.getParentFile().mkdirs();
					if (checkPFile) {
						directory.createNewFile();
					}
				} catch (IOException e) {
					logger.warn(e.getMessage());
				}
			}

			outputStream = new FileOutputStream(directory);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
			// 第三步：開啟文件進行我們需要的操作
			document.open();

			// 第四步：建立第一頁（如果只有一頁的話，這一步可以省略）
//	        document.newPage();
			// 第五步：在文件中新增內容

			// 字型
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

			document.add(new Paragraph("申請書", title));
			document.add(new Paragraph("\n"));

			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);

			cell.setPhrase(new Paragraph("單位名稱:" + searchApply.getCompanyName(), content));
			table2.addCell(cell);
			cell.setPhrase(new Paragraph("統一編號:" + searchApply.getSeq(), content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			// 行業別列表
			JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			JSONObject jsonObject = null;
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				if (searchApply.getIndustry().equals(jsonObject.get("code"))) {
					cell.setPhrase(new Paragraph("行業別:" + jsonObject.get("name"), content));
					table2.addCell(cell);
					break;
				}
			}

			String companyAttributes = searchApply.getCompanyAttributes().equals("1") ? "民營事業單位"
					: searchApply.getCompanyAttributes().equals("2") ? "民間團體"
							: searchApply.getCompanyAttributes().equals("3") ? "私立學校" : "";
			cell.setPhrase(new Paragraph("單位屬性:" + companyAttributes, content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			cell.setPhrase(new Paragraph("投保證號:" + searchApply.getGuaranteeNumber().replace(";", ","), content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);
			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			String address = "";
			// 縣市列表
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				if (searchApply.getContactCity().equals(jsonObject.get("code"))) {
					address = jsonObject.get("name").toString();
					// 地區列表
					jsonArray = new JSONArray(
							api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(), ""));
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

			spaceCell.setPhrase(new Paragraph("聯絡地址:" + address + searchApply.getContactAddress(), content));
			table2.addCell(spaceCell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			cell.setPhrase(new Paragraph("聯絡人:" + searchApply.getContactName(), content));
			table2.addCell(cell);

			cell.setPhrase(new Paragraph("聯絡人職稱:" + searchApply.getContactJobtitle(), content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			if (searchApply.getContactWorkPhoneExtension().equals("")) {
				cell.setPhrase(new Paragraph(
						"聯絡電話:" + searchApply.getContactWorkPhoneAreaCode() + "-" + searchApply.getContactWorkPhone(),
						content));
				table2.addCell(cell);
			} else {
				cell.setPhrase(new Paragraph("聯絡電話:" + searchApply.getContactWorkPhoneAreaCode() + "-"
						+ searchApply.getContactWorkPhone() + " #" + searchApply.getContactWorkPhoneExtension(),
						content));
				table2.addCell(cell);
			}
			cell.setPhrase(new Paragraph("行動電話:" + searchApply.getContactPhone(), content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			cell.setPhrase(new Paragraph("傳真號碼:" + searchApply.getFaxAreaCode() + "-" + searchApply.getFax(), content));
			table2.addCell(cell);

			cell.setPhrase(new Paragraph("電子信箱:" + searchApply.getEmail(), content));
			table2.addCell(cell);

			spaceCell.setPhrase(new Paragraph("\n"));
			table2.addCell(spaceCell);

			document.add(table2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/career_payment")
	public String career_payment(HttpServletRequest request) {
		session=request.getSession();
		if(session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "login";
		}else{
			return "career_payment";
		}
	}

	@RequestMapping(value = "/career_payment_01")
	public void career_payment_01(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttrs) throws IOException {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			response.getWriter().print("success;login");
		}else {
			base = new AdvancedAgeBase();
			base.setSeq(session.getAttribute(session.getId()+"seq").toString());
			AdvancedAgeBase searchBase = selectCTypeAdvancedAgeBase(base);
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
			}else if(searchBase.getCaseStatus().equals("3")) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("approved");
			}
			else{
				session.setAttribute(session.getId()+"baseId", searchBase.getId());
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("success;career_payment_02");
			}
		}
	}

	@RequestMapping(value = "/career_payment_02")
	public String career_payment_02(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_payment_01";
		}
//		-----------申請過後不能再申請---------
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase = selectCTypeAdvancedAgeBase(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/career_payment_05";
		}
		session.setAttribute("base", searchBase);
//      資料是否已存在
		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		reemploymentApply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(
				reemploymentApply);
		session.setAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId", searchApply.getId());
		model.addAttribute("apply", searchApply);
		
//      資料是否已存在
		result = new AdvancedAgeRetirementReemploymentResult();
		result.setSeq(searchApply.getSeq());
		result.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
		model.addAttribute("result", selectAdvancedAgeRetirementReemploymentResult(result));
		return "career_payment_02";
	}

	@RequestMapping(value = "/career_payment_03")
	public String career_payment_03(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_payment_01";
		}
//		-----------申請過後不能再申請---------
		base = new AdvancedAgeBase();
		base.setId(Integer.valueOf(session.getAttribute(session.getId() + "baseId").toString()));
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/career_payment_05";
		}
		model.addAttribute("baseId", session.getAttribute(session.getId() + "baseId").toString());
//		資料是否已存在
		attachment = new Attachment();
		if (session.getAttribute(session.getId() + "baseId") != null) {
			// 本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId() + "baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 成果報告
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());

			// 經費支用單據正本及明細表
			attachment.setFileType("expenditureDetails");
			model.addAttribute("expenditureDetailsAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "career_payment_03";
	}

	@RequestMapping(value = "/career_payment_04")
	public String career_payment_04(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_payment_01";
		}
//		-----------申請過後不能再申請---------
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId"));
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase = selectCTypeAdvancedAgeBase(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/career_payment_05";
		}
//		model.addAttribute("baseId", session.getAttribute(session.getId() + "baseId").toString());

//		資料是否已存在
		result = new AdvancedAgeRetirementReemploymentResult();
		result.setSeq(session.getAttribute(session.getId() + "seq").toString());
		result.setAdvancedAgeRetirementReemploymentApplyId(Integer.valueOf(
				session.getAttribute(session.getId() + "advancedAgeRetirementReemploymentApplyId").toString()));
		model.addAttribute("result", selectAdvancedAgeRetirementReemploymentResult(result));

		attachment = new Attachment();
		if (session.getAttribute(session.getId() + "baseId") != null) {
			// 本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId() + "baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 成果報告
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());

			// 經費支用單據正本及明細表
			attachment.setFileType("expenditureDetails");
			model.addAttribute("expenditureDetailsAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "career_payment_04";
	}

	@RequestMapping(value = "/career_payment_05")
	public String career_payment_05(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/career_payment_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase = selectCTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		model.addAttribute("baseAllowanceFrequencyTime", searchBase.getAllowanceFileStatusRecord().split(";").length);
		
		reemploymentApply = new AdvancedAgeRetirementReemploymentApply();
		reemploymentApply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(reemploymentApply);
		
		result = new AdvancedAgeRetirementReemploymentResult();
		result.setSeq(session.getAttribute(session.getId() + "seq").toString());
		result.setAdvancedAgeRetirementReemploymentApplyId(searchApply.getId());
		model.addAttribute("result", selectAdvancedAgeRetirementReemploymentResult(result));

		attachment = new Attachment();
		if (session.getAttribute(session.getId() + "baseId") != null) {
			// 本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId() + "baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 成果報告
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());

			// 經費支用單據正本及明細表
			attachment.setFileType("expenditureDetails");
			model.addAttribute("expenditureDetailsAttachment", selectFiles(attachment).toList());

			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "career_payment_05";
	}

	public AdvancedAgeRetirementReemploymentResult selectAdvancedAgeRetirementReemploymentResult(
			AdvancedAgeRetirementReemploymentResult result) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeRetirementReemploymentResult searchResult = new AdvancedAgeRetirementReemploymentResult();
		try {
			json = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentResult", json);
		try {
			if (!jsondata.equals(""))
				searchResult = objectMapper.readValue(jsondata, AdvancedAgeRetirementReemploymentResult.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchResult;
	}

	@RequestMapping(value = "/require_career")
	public String require_career() {
		return "require_career";
	}

	public JSONObject checkCompanyInfo(CompanyInfo info) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "checkCompanyInfo", json));
		return object;
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

		try {
			if (!jsondata.equals(""))
				searchBase = objectMapper.readValue(jsondata, AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}

	public AdvancedAgeBase selectCTypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCTypeAdvancedAgeBase", json));
		try {
			if (array.length() > 0) {
				searchBase = objectMapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);
			}
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchBase;
	}

	public AdvancedAgeRetirementReemploymentApply selectAdvancedAgeRetirementReemploymentApply(
			AdvancedAgeRetirementReemploymentApply apply) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeRetirementReemploymentApply searchApply = new AdvancedAgeRetirementReemploymentApply();
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentApply", json);
		try {
			if (!jsondata.equals(""))
				searchApply = objectMapper.readValue(jsondata, AdvancedAgeRetirementReemploymentApply.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchApply;
	}

	public AdvancedAgeRetirementReemploymentPlan selectAdvancedAgeRetirementReemploymentPlan(
			AdvancedAgeRetirementReemploymentPlan plan, String sid) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeRetirementReemploymentPlan searchPlan = new AdvancedAgeRetirementReemploymentPlan();
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentPlan", json);

		try {
			if (!jsondata.equals(""))
				searchPlan = objectMapper.readValue(jsondata, AdvancedAgeRetirementReemploymentPlan.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		session.setAttribute(sid + "advancedAgeRetirementReemploymentPlanId", searchPlan.getId());
		return searchPlan;
	}

	public JSONArray selectAdvancedAgeRetirementReemploymentBenefitLists(
			AdvancedAgeRetirementReemploymentBenefitList benefitList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(benefitList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentBenefitLists", json));
		return array;
	}

	public List<AdvancedAgeRetirementReemploymentExpenditure> selectAdvancedAgeRetirementReemploymentExpenditures(
			AdvancedAgeRetirementReemploymentExpenditure expenditure) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(expenditure);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsonArray = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentExpenditures", json);
		List<AdvancedAgeRetirementReemploymentExpenditure> expenditures = null;
		if (!"[]".equals(jsonArray)) {
			try {
				expenditures = objectMapper.readValue(jsonArray,
						new TypeReference<List<AdvancedAgeRetirementReemploymentExpenditure>>() {
						});
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
		} else {
			expenditures = new ArrayList<>();
		}
		return expenditures;
	}

	private List<AdvancedAgeRetirementReemploymentBasicData> selectAdvancedAgeRetirementReemploymentBasicDataList(
			AdvancedAgeRetirementReemploymentBasicData basicData) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(basicData);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsonArray = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentBasicDataList", json);
		List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = null;
		if (!"[]".equals(jsonArray)) {
			try {
				basicDataList = objectMapper.readValue(jsonArray,
						new TypeReference<List<AdvancedAgeRetirementReemploymentBasicData>>() {
						});
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
		} else {
			basicDataList = new ArrayList<>();
		}
		return basicDataList;
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

	public String parseSubsidyType(Integer number) {
		String output = "";
		if (number == null) {
			return output;
		}
		switch (number) {
		case 1:
			output = "職涯諮詢";
			break;
		case 2:
			output = "就業諮詢";
			break;
		case 4:
			output = "創業諮詢";
			break;
		case 3:
			output = "職涯諮詢;就業諮詢";
			break;
		case 5:
			output = "職涯諮詢;創業諮詢";
			break;
		case 6:
			output = "就業諮詢;創業諮詢";
			break;
		case 7:
			output = "職涯諮詢;就業諮詢;創業諮詢";
			break;
		default:
			break;
		}
		return output;
	}

	public String parseCompanyAttributes(String companyAttributes) {
		String output = "";
		if (companyAttributes == null) {
			return output;
		}
		switch (companyAttributes) {
		case "1":
			output = "民營事業單位";
			break;
		case "2":
			output = "民間團體";
			break;
		case "3":
			output = "私立學校";
			break;
		default:
			break;
		}
		return output;
	}

	public String parseYNtoChinese(String input) {
		if ("Y".equals(input)) {
			input = "有";
		} else if ("N".equals(input)) {
			input = "無";
		} else {
			input = "";
		}
		return input;
	}

	public String parseCity(String jsondata, String input) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Parameter> parameterList = new ArrayList<>();
		if (input == null) {
			return "";
		}
		String[] data = input.split(";");
		;
		String output = "";
		if (!"[]".equals(jsondata)) {
			try {
				parameterList = objectMapper.readValue(jsondata, new TypeReference<List<Parameter>>() {
				});
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
		}
		for (int i = 0; i < data.length; i++) {
			for (Parameter parameter : parameterList) {
				if (parameter.getCode().equals(data[i]) && data.length == 1) {
					output = parameter.getName();
				} else if (parameter.getCode().equals(data[i]) && data.length == i + 1) {
					output += parameter.getName();
				} else if (parameter.getCode().equals(data[i])) {
					output += parameter.getName() + "、";
				}
			}
		}
		return output;
	}

	public JSONObject selectCompanyInfoData(CompanyInfo info) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "selectCompanyInfoData", json));
		return object;
	}
}
