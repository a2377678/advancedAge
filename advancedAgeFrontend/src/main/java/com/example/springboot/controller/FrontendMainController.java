package com.example.springboot.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterKey;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.PdfUtil;
import com.example.springboot.util.RandomValidateCodeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class FrontendMainController {

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
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/change_password")
	public String change_password(){
		return "change_password";
	}
	
	@RequestMapping(value = "/schedule")
	public String schedule(HttpServletRequest request,Model model,String seq) {
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(seq+"seq") == null) {
			return "redirect:/login?type=AA";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base));
		// 行業別列表
		String result = api.httpGet(ip + "getIndustryList");
		JSONArray jsonArray = new JSONArray(result);
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// 縣市列表
		result = api.httpGet(ip + "getCityList");
		jsonArray = new JSONArray(result);
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		apply = new AdvancedAgeApply();
		if (session.getAttribute(seq+"seq") != null) {
			// ------申請表 start------
			apply.setSeq(session.getAttribute(seq+"seq").toString());
			AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", searchApply);

			String apiResponse = api.httpGet(ip + "getAreaList?cityCode=" + searchApply.getContactCity());
			jsonArray = new JSONArray(apiResponse);
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------申請表 end--------

			// ------計畫書 start------
			plan = new AdvancedAgePlan();
			employmentList = new AdvancedAgeEmploymentList();

			plan.setAdvancedAgeApplyId(searchApply.getId());
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
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
			// ------繼續雇用名單 start------
			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
			// ------繼續雇用名單 end------
//			employedSituation = new AdvancedAgeApplyEmployedSituation();
//			employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//			model.addAttribute("advancedAgeApplyEmployedSituations",
//					selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			// ------計畫書 end--------

			// ------檢附文件 start------
			attachment = new Attachment();

			// 設立登記證明文件
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 投保勞保或職災保險證明文件
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// 薪資證明或其他證明文件
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// 出勤證明
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------檢附文件 end--------
		}

		return "schedule";
	}
	
	@RequestMapping(value = "/schedule_pass")
	public String schedule_pass(HttpServletRequest request,Model model,String seq) {
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/login?type=AR";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base));
		

		return "schedule_pass";
	}
	
	@RequestMapping(value = "/employ_01")
	public String employ_01()
			throws FileNotFoundException, DocumentException {
		return "employ_01";
	}

	@RequestMapping(value = "/employ_02")
	public String employ_02(HttpServletRequest request, Model model,String seq) {
		System.out.println("seq = "+seq);
		model.addAttribute("seq", seq);
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06?seq="+seq;
		}
//		行業別列表
		String result = api.httpGet(ip + "getIndustryList");
		JSONArray jsonArray = new JSONArray(result);
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
//		縣市列表
		result = api.httpGet(ip + "getCityList");
		jsonArray = new JSONArray(result);
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

//      資料是否已存在
		apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(seq+"seq").toString());
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
		searchApply.setCompanyName(session.getAttribute(seq+"companyName").toString());
		searchApply.setSeq(session.getAttribute(seq+"seq").toString());
		model.addAttribute("apply", searchApply);

		String apiResponse = api.httpGet(ip + "getAreaList?cityCode=" + searchApply.getContactCity());
		jsonArray = new JSONArray(apiResponse);
		list = jsonArray.toList();
		model.addAttribute("areaList", list);

		return "employ_02";
	}

	@RequestMapping(value = "/employ_03")
	public String employ_03(HttpServletRequest request,Model model,String seq) {
		System.out.println("3seq = "+seq);
		model.addAttribute("seq", seq);
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06?seq="+seq;
		}
//      資料是否已存在
		plan = new AdvancedAgePlan();
		employmentList = new AdvancedAgeEmploymentList();
		System.out.println("session.getAttribute(seq+\"advancedAgeApplyId\") = "+session.getAttribute(seq+"advancedAgeApplyId")+"seq = "+seq);
		if (session.getAttribute(seq+"advancedAgeApplyId") != null) {
			plan.setAdvancedAgeApplyId(Integer.valueOf(session.getAttribute(seq+"advancedAgeApplyId").toString()));
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
			model.addAttribute("plan", searchPlan);
			//0727刪除
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
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(seq+"advancedAgeApplyId").toString()));
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
	public String employ_04(HttpServletRequest request,Model model,String seq) {
		System.out.println("4seq = "+seq);
		model.addAttribute("seq", seq);
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06?seq="+seq;
		}
//      資料是否已存在
		attachment = new Attachment();
		if (session.getAttribute(seq+"advancedAgeApplyId") != null) {
			// 設立登記證明文件
			attachment.setFileBelong("A");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(seq+"advancedAgeApplyId").toString()));
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 投保勞保或職災保險證明文件
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// 薪資證明
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// 出勤證明
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}

		return "employ_04";
	}

	@RequestMapping(value = "/employ_05")
	public String employ_05(HttpServletRequest request,Model model,String seq) {
		System.out.println("5seq = "+seq);
		model.addAttribute("seq", seq);
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(seq+"seq").toString());
		if(selectATypeAdvancedAgeBase(base).getFileStatus()!=null && !selectATypeAdvancedAgeBase(base).getFileStatus().equals("2"))
		{
			return "redirect:/employ_06?seq="+seq;
		}
		// 行業別列表
		String result = api.httpGet(ip + "getIndustryList");
		JSONArray jsonArray = new JSONArray(result);
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// 縣市列表
		result = api.httpGet(ip + "getCityList");
		jsonArray = new JSONArray(result);
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

		apply = new AdvancedAgeApply();
		if (session.getAttribute(seq+"seq") != null) {
			// ------申請表 start------
			apply.setSeq(session.getAttribute(seq+"seq").toString());
			AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", searchApply);

			String apiResponse = api.httpGet(ip + "getAreaList?cityCode=" + searchApply.getContactCity());
			jsonArray = new JSONArray(apiResponse);
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------申請表 end--------

			// ------計畫書 start------
			plan = new AdvancedAgePlan();

			plan.setAdvancedAgeApplyId(searchApply.getId());
			AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
			model.addAttribute("plan", searchPlan);
			
			if (searchPlan.getAttachEmploymentList() != null
					&& searchPlan.getAttachEmploymentList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("A");
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(seq+"advancedAgeApplyId").toString()));
				attachment.setFileType("employmentList");
				attachment.setFileFrequency(1);
				model.addAttribute("employmentListAttachment", selectFiles(attachment).toList());
			}
			// ------繼續雇用名單 start------
			employmentList = new AdvancedAgeEmploymentList();
			employmentList.setAdvancedAgePlanId(searchPlan.getId());
			model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
			// ------繼續雇用名單 end------
//			employedSituation = new AdvancedAgeApplyEmployedSituation();
//			employedSituation.setAdvancedAgePlanId(searchPlan.getId());
//			model.addAttribute("advancedAgeApplyEmployedSituations",
//					selectAdvancedAgeApplyEmployedSituations(employedSituation).toList());
			// ------計畫書 end--------

			// ------檢附文件 start------
			attachment = new Attachment();

			// 設立登記證明文件
			attachment.setFileBelong("A");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileFrequency(1);
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());

			// 投保勞保或職災保險證明文件
			attachment.setFileType("insure");
			model.addAttribute("insureAttachment", selectFiles(attachment).toList());

			// 薪資證明或其他證明文件
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// 出勤證明
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			// ------檢附文件 end--------
		}

		return "employ_05";
	}

	@RequestMapping(value = "/employ_06")
	public String employ_06(HttpServletRequest request,Model model,String seq) {
		model.addAttribute("seq", seq);
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
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
	public String employ_payment_02(HttpServletRequest request, Model model,String seq) {
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("seq", seq);
		model.addAttribute("baseId", session.getAttribute(seq+"baseId").toString());
//		-----------申請過後不能再申請---------
//		base = new AdvancedAgeBase();
//		base.setId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
//		if(Integer.valueOf(selectAdvancedAgeBaseById(base).getCaseStatus())>3)
//		{
//			return "redirect:/employ_payment_05?seq="+seq;
//		}
		/*//------------自動帶入名稱 start------------
		// ------申請表 start------
		apply = new AdvancedAgeApply();
		apply.setSeq(session.getAttribute(seq+"seq").toString());
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
		// ------申請表 end--------

		// ------計畫書 start------
		plan = new AdvancedAgePlan();
		plan.setAdvancedAgeApplyId(searchApply.getId());
		AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
		
		// ------繼續雇用名單 start------
		employmentList = new AdvancedAgeEmploymentList();
		employmentList.setAdvancedAgePlanId(searchPlan.getId());
		JSONArray array = selectAdvancedAgeEmploymentLists(employmentList);
		List<String> name = new ArrayList<String>(); 
		for(int i=0;i<array.toList().size();i++)
		{
			name.add(array.getJSONObject(i).getString("name"));
		}
		model.addAttribute("advancedAgeEmploymentName", name);
		//------------自動帶入名稱 end------------*/
			
		employmentListReceipt = new AdvancedAgeEmploymentListReceipt();
		employmentListReceipt.setAdvancedAgeBaseId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
		employmentListReceipt.setSeq(session.getAttribute(seq+"seq").toString());
		model.addAttribute("advancedAgeEmploymentListReceipts",selectAdvancedAgeEmploymentListReceipts(employmentListReceipt).toList());

		
		return "employ_payment_02";
	}

	@RequestMapping(value = "/employ_payment_03")
	public String employ_payment_03(HttpServletRequest request, Model model,String seq) {
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("seq", seq);
		model.addAttribute("baseId", session.getAttribute(seq+"baseId").toString());
		
//		-----------申請過後不能再申請---------
		base = new AdvancedAgeBase();
		base.setId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
//		if(Integer.valueOf(selectAdvancedAgeBaseById(base).getCaseStatus())>3)
//		{
//			return "redirect:/employ_payment_05?seq="+seq;
//		}
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base);
		if(searchBase.getAllowanceFrequencyRecord() != null)
		{
			model.addAttribute("baseAllowanceFrequencyTime", searchBase.getAllowanceFrequencyRecord().split(";").length);
		}
		
//      資料是否已存在
		attachment = new Attachment();
		if (session.getAttribute(seq+"baseId") != null) {
			// 原核定函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 薪資證明
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
						
			// 薪資證明
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// 出勤證明
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "employ_payment_03";
	}

	@RequestMapping(value = "/employ_payment_04")
	public String employ_payment_04(HttpServletRequest request, Model model,String seq) {
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
			return "redirect:/employ_payment_01";
		}
		model.addAttribute("seq",seq);
		model.addAttribute("baseId", session.getAttribute(seq+"baseId").toString());
//		-----------申請過後不能再申請---------
//		base = new AdvancedAgeBase();
		base.setId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
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
		employmentListReceipt.setAdvancedAgeBaseId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
		employmentListReceipt.setSeq(session.getAttribute(seq+"seq").toString());
		model.addAttribute("advancedAgeEmploymentListReceipts",selectAdvancedAgeEmploymentListReceipts(employmentListReceipt).toList());
		
		attachment = new Attachment();
		if (session.getAttribute(seq+"baseId") != null) {
			// 原核定函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(seq+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());

			// 領據
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());

			// 薪資證明
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
						
			// 薪資證明
			attachment.setFileType("salary");
			model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
			
			// 出勤證明
			attachment.setFileType("attendance");
			model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "employ_payment_04";
	}

	@RequestMapping(value = "/employ_payment_05")
	public String employ_payment_05(HttpServletRequest request, Model model,String seq) {
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(seq+"seq") == null) {
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
//		行業別列表
		String result = api.httpGet(ip + "getIndustryList");
		JSONArray jsonArray = new JSONArray(result);
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
//		縣市列表
		result = api.httpGet(ip + "getCityList");
		jsonArray = new JSONArray(result);
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
		System.out.println("path = "+path);
		path=filePath+path;
//    下載的檔名是啥
      String fileName = path.substring(path.lastIndexOf("/") + 1);
      try{
//    設定瀏覽器能夠支援下載的東西，中文檔名需要指定編碼方式，否則可能會亂碼
      response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));//分號改成冒號會展示圖片而不會下載
//    獲取下載檔案的輸入流
      FileInputStream in=new FileInputStream(path);
//      System.out.println("path after = "+path);
//    建立緩衝區
      int len=0;
      byte[] buffer=new byte[1024];
//    獲取outputStream物件
      ServletOutputStream out= response.getOutputStream();
//    將FileOutputStream流寫入buffer,使用outputStream將緩衝區資料輸出到客戶端
      while((len=in.read(buffer))>0)
      {
          out.write(buffer,0,len);
      }

      in.close();
      out.close();
      }catch(Exception e) {
    	  e.getStackTrace();
      }
	 }
	
	@RequestMapping(value = "/pdf")
	public void pdf(String seq,HttpServletResponse response) throws FileNotFoundException, DocumentException {
		// 第一步：建立一個文件例項 設定文件紙張為A4，文件排列方式為橫向排列
		// 實現A4紙頁面 並且縱向排列（不設定則為橫向
		Document document = new Document();
		// 第二步：建立PdfWriter物件，設定pdf生成路徑
		// 申請資料
		apply = new AdvancedAgeApply();
		apply.setSeq(seq);
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
				
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(filePath+"/A/"+searchApply.getId()+"/data.pdf"));
		// 第三步：開啟文件進行我們需要的操作
		document.open();

		// 第四步：建立第一頁（如果只有一頁的話，這一步可以省略）
//        document.newPage();
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
		String result = api.httpGet(ip + "getIndustryList");
		JSONArray jsonArray = new JSONArray(result);
		JSONObject jsonObject = null;
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getIndustry().equals(jsonObject.get("code"))) {
				cell.setPhrase(new Paragraph("行業別:" + jsonObject.get("name"), content));
				table2.addCell(cell);
				break;
			}
		}

		cell.setPhrase(new Paragraph("投保證號:" + searchApply.getGuaranteeNumber().replace(";", ","), content));
		table2.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table2.addCell(spaceCell);

		String address = "";
		// 縣市列表
		result = api.httpGet(ip + "getCityList");
		jsonArray = new JSONArray(result);
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getContactCity().equals(jsonObject.get("code"))) {
				address = jsonObject.get("name").toString();
				// 地區列表
				result = api.httpGet(ip + "getAreaList?cityCode=" + searchApply.getContactCity());
				jsonArray = new JSONArray(result);
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
					+ searchApply.getContactWorkPhone() + " #" + searchApply.getContactWorkPhoneExtension(), content));
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

		// 計畫書
		document.add(new Paragraph("計畫書", title));
		document.add(new Paragraph("\n"));

		PdfPTable table4 = new PdfPTable(4);
		table4.setWidthPercentage(100);

		// 申請資料
		plan = new AdvancedAgePlan();
		plan.setAdvancedAgeApplyId(searchApply.getId());
		AdvancedAgePlan searchPlan = selectAdvancedAgePlan(plan,seq);
		spaceCell.setPhrase(new Paragraph("主要業務/產品/服務:" + searchPlan.getItems(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		cell.setPhrase(new Paragraph("目前員工人數:" + searchPlan.getEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("65歲以上人數:" + searchPlan.getHighEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("45~64歲人數:" + searchPlan.getMiddleEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("44歲以下人數:" + searchPlan.getLowEmploymentNumber(), content));
		table4.addCell(cell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		cell.setPhrase(new Paragraph("屆臨65歲人數(A):" + searchPlan.getNearHighEmploymentNumber(), content));
		table4.addCell(cell);

		cell3.setPhrase(new Paragraph("規劃繼續僱用人數(B):" + searchPlan.getContinueEmploymentNumber(), content));
		table4.addCell(cell3);

		spaceCell.setPhrase(new Paragraph("繼續僱用比例(C):" + searchPlan.getContinueEmploymentPercentage() + "%", content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		document.add(table4);

		// 繼續僱用補助名單清冊
		document.add(new Paragraph("繼續僱用補助名單清冊", title));
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
			
			cell.setPhrase(new Paragraph("標號", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("勞工姓名", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("身分證字號", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("保險類型", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("加保日期", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("職務類型", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("親等關係", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("工時類型", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("經常性薪資", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("非經常性薪資", table));
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
					cell.setPhrase(new Paragraph("勞工保險", table));
					table10EmploymentList.addCell(cell);
					
					String date=employment.getJSONObject(i).get("laborProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
					cell.setPhrase(new Paragraph("職災保險", table));
					table10EmploymentList.addCell(cell);
					
					String date=employment.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}
				
				if(employment.getJSONObject(i).get("manager").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("主管", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("manager").toString().equals("N")) {
					cell.setPhrase(new Paragraph("非主管", table));
					table10EmploymentList.addCell(cell);
				}
				
				if(employment.getJSONObject(i).get("relatives").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("三等親內", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("relatives").toString().equals("N")) {
					cell.setPhrase(new Paragraph("非三等親", table));
					table10EmploymentList.addCell(cell);
				}

				if(employment.getJSONObject(i).get("workingHours").toString().equals("A")) {
					cell.setPhrase(new Paragraph("全時", table));
					table10EmploymentList.addCell(cell);
				}else if(employment.getJSONObject(i).get("workingHours").toString().equals("P")) {
					cell.setPhrase(new Paragraph("部分工時", table));
					table10EmploymentList.addCell(cell);
				}
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("recurringSalary").toString(), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(employment.getJSONObject(i).get("notRecurringSalary").toString(), table));
				table10EmploymentList.addCell(cell);

			}
			document.add(table10EmploymentList);
		}
		// ------繼續雇用名單 start------
//		employmentList = new AdvancedAgeEmploymentList();
//		employmentList.setAdvancedAgePlanId(searchPlan.getId());
//		model.addAttribute("advancedAgeEmploymentLists", selectAdvancedAgeEmploymentLists(employmentList).toList());
//		// ------繼續雇用名單 end------
//		ASDSA
		// 檢附文件
		document.add(new Paragraph("檢附文件", title));
		document.add(new Paragraph("\n"));

		PdfPTable table3 = new PdfPTable(3);
		table3.setWidthPercentage(100);

		spaceCell.setPhrase(new Paragraph("設立登記證明文件:", content));
		table3.addCell(spaceCell);
		attachment = new Attachment();
		// 設立登記證明文件
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

		spaceCell.setPhrase(new Paragraph("投保勞保或職災保險證明文件:", content));
		table3.addCell(spaceCell);
		// 投保勞保或職災保險證明文件
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

		spaceCell.setPhrase(new Paragraph("薪資證明文件:", content));
		table3.addCell(spaceCell);
		// 薪資證明或其他證明文件
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
		
		spaceCell.setPhrase(new Paragraph("出勤證明文件:", content));
		table3.addCell(spaceCell);
		// 出勤證明文件
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
		
		spaceCell.setPhrase(new Paragraph("其他文件:", content));
		table3.addCell(spaceCell);
		// 其他文件
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
		// 關閉文件
		document.close();
		// 關閉書寫流
		pdfWriter.close();
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("{\"status\":\"success\",\"path\":\""+"/A/"+searchApply.getId()+"/data.pdf\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeApply searchApply = new AdvancedAgeApply();
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeApply", json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchApply = mapper.readValue(jsondata, AdvancedAgeApply.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchApply;
	}

	public AdvancedAgePlan selectAdvancedAgePlan(AdvancedAgePlan plan,String seq) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgePlan searchPlan = new AdvancedAgePlan();
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgePlan", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchPlan = mapper.readValue(jsondata, AdvancedAgePlan.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute(seq+"advancedAgePlanId", searchPlan.getId());
		return searchPlan;
	}

	public JSONArray selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList employmentList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeEmploymentLists", json);
		JSONArray array = new JSONArray(jsondata);
		return array;
	}

	public JSONArray selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentListReceipt);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeEmploymentListReceipts", json);
		JSONArray array = new JSONArray(jsondata);
		return array;
	}
	
	public JSONArray selectAdvancedAgeApplyEmployedSituations(AdvancedAgeApplyEmployedSituation employmentSituation) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentSituation);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeApplyEmployedSituations", json);
		JSONArray array = new JSONArray(jsondata);
		return array;
	}

	public JSONArray selectFiles(Attachment attachment) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(attachment);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectFiles", json);
		JSONArray array = new JSONArray(jsondata);
		return array;
	}
	
	public AdvancedAgeBase selectATypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectATypeAdvancedAgeBase", json);
		JSONArray array = new JSONArray(jsondata);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (array.length()>0) {
				searchBase = mapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeBaseById", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchBase = mapper.readValue(jsondata, AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchBase;
	}
	
	@RequestMapping(value = "/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 設置相應類型,告訴瀏覽器輸出的內容為圖片
			response.setHeader("Pragma", "No-cache");// 設置響應頭信息，告訴瀏覽器不要緩存此內容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
			randomValidateCode.getRandcode(request, response);// 輸出驗證碼圖片方法
		} catch (Exception e) {
//            logger.error("獲取驗證碼失敗>>>>   ", e);
		}
	}

	/**
	 * 校驗驗證碼
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkVerify", method = RequestMethod.POST)
	public void checkVerify(HttpServletRequest request, HttpServletResponse response, String verifyInput,CompanyInfo info)
			throws IOException {
		try {
			session = request.getSession();
			// 從session中獲取隨機數
			String inputStr = verifyInput;
			String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
			if (random == null) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
			if (random.equals(inputStr)) {
				System.out.println("search = ");
				info.setPassword(encryptPassword(info.getPassword(),key));
				JSONObject company = checkCompanyInfo(info);
				if(company.get("seq").equals(null))
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("password error");
				}else
				{
					session.setAttribute(info.getSeq()+"seq", info.getSeq());
					session.setAttribute(info.getSeq()+"companyName", company.get("companyName"));
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("success;"+info.getSeq());
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
		} catch (Exception e) {
//            logger.error("驗證碼校驗失敗", e);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("fail");
		}
	}

	@RequestMapping(value = "/paymentCheckVerify", method = RequestMethod.POST)
	public void paymentCheckVerify(HttpServletRequest request, HttpServletResponse response, String verifyInput,CompanyInfo info)
			throws IOException {
		try {
			session = request.getSession();
			// 從session中獲取隨機數
			String inputStr = verifyInput;
			String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
			if (random == null) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
			if (random.equals(inputStr)) {
				info.setPassword(encryptPassword(info.getPassword(),key));
				JSONObject company = checkCompanyInfo(info);
				if(company.get("seq").equals(null))
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("password error");
				}else
				{
					session.setAttribute(info.getSeq()+"seq", info.getSeq());
					session.setAttribute(info.getSeq()+"companyName", company.get("companyName"));
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
						session.setAttribute(info.getSeq()+"baseId", searchBase.getId());
						response.setContentType("text/html;charset=UTF-8");
						response.getWriter().print("success;"+info.getSeq());
					}
				}
			} else {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("fail");
			}
		} catch (Exception e) {
//            logger.error("驗證碼校驗失敗", e);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsondata = api.httpPost(ip+"checkCompanyInfo",json);
		JSONObject object = new JSONObject(jsondata);
		return object;
	}
	
	public String encryptPassword(String data, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
	    byte[] result = cipher.doFinal(data.getBytes());
	    return Base64.getEncoder().encodeToString(result);
	}
}
