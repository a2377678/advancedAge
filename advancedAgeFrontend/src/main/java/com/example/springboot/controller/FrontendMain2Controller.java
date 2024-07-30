package com.example.springboot.controller;

import java.io.File;
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
import org.json.JSONException;
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
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
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
public class FrontendMain2Controller {
	Logger logger = LogManager.getLogger(FrontendMain2Controller.class);
	
	CallApi api = new CallApi();

	@Value("${api_ip}")
	private String ip;

	@Value("${file_path}")
	private String filePath;
	
	@Value("${mail_domain}")
	private String mailDomain;
	
	HttpSession session;

	AdvancedAgeBase base;
	
	RetirementAdvancedAgeExperienceInheritanceApply apply;
	
	RetirementAdvancedAgeExperienceInheritancePlan plan;
	
	ExperienceInheritanceSpeakerList speakerList; 
	
	RetirementAdvancedAgeExperienceInheritanceSchedule schedule;
	
	RetirementAdvancedAgeParticipateStudent participate;
	
	RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure;
	
	RetirementAdvancedAgeExperienceInheritanceResult result;
	
	Attachment attachment;

	@RequestMapping(value = "/require_teach")
	public String require_teach() {
		return "require_teach";
	}
	
	@RequestMapping(value = "/teach")
	public String teach(HttpServletRequest request) {
		session=request.getSession();
		if(session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "login";
		}else{
			return "teach";
		}
	}
	
	@RequestMapping(value = "/teach_01")
	public String teach_01(HttpServletRequest request,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			session.setAttribute(session.getId()+"redirectPath", "teach_02");
			return "redirect:/login";
		}else {
			return "redirect:/teach_02";
		}
	}
	
	@RequestMapping(value = "/teach_02")
	public String teach_02(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
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
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		
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
		
		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
		list = jsonArray.toList();
		model.addAttribute("contactAreaList", list);
		
		model.addAttribute("registerAreaList", new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getRegisterCity(),"")).toList());

		
		return "teach_02";
	}
	
	@RequestMapping(value = "/teach_03")
	public String teach_03(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
		}
		
//      資料是否已存在
		plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		if (session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId") != null) {
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			RetirementAdvancedAgeExperienceInheritancePlan searchPlan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			if(searchPlan.getId()!=null) {
				speakerList = new ExperienceInheritanceSpeakerList();
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(searchPlan.getId());
				model.addAttribute("speakerLists",selectExperienceInheritanceSpeakerLists(speakerList).toList());
			}
			if (searchPlan.getAttachSpeakerList() != null
					&& searchPlan.getAttachSpeakerList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("B");
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
				attachment.setFileType("speakerList");
				attachment.setFileFrequency(1);
				model.addAttribute("speakerListAttachment", selectFiles(attachment).toList());
			}
		}
		
		
		return "teach_03";
	}
	
	@RequestMapping(value = "/teach_04")
	public String teach_04(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
		}
//		縣市列表
		model.addAttribute("cityList", new JSONArray(api.httpPost(ip + "getCityList", "")).toList());
//      資料是否已存在
		if (session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId") != null) {
			
			schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("scheduleLists",selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule).toList());
			
			participate = new RetirementAdvancedAgeParticipateStudent();
			participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("participateLists",selectRetirementAdvancedAgeParticipateStudents(participate).toList());
		}
		return "teach_04";
	}
	
	@RequestMapping(value = "/teach_05")
	public String teach_05(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
		}
//      資料是否已存在
		if (session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId") != null) {
			expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("expenditureLists",selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure).toList());
			
		}
		return "teach_05";
	}
	
	@RequestMapping(value = "/teach_06")
	public String teach_06(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
		}
//      資料是否已存在
		if (session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId") != null) {
			attachment = new Attachment();
			// 設立登記證明文件
			attachment.setFileBelong("B");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());
			
			//講師為退休高齡者證明文件
			attachment.setFileType("speakerRetirement");
			model.addAttribute("speakerRetirementAttachment", selectFiles(attachment).toList());
			
			//講師具專業技術及經驗證明文件
			attachment.setFileType("speakerExperience");
			model.addAttribute("speakerExperienceAttachment", selectFiles(attachment).toList());
			
			//僱用證明文件
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "teach_06";
	}
	
	@RequestMapping(value = "/teach_07")
	public String teach_07(HttpServletRequest request, Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		案件已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getFileStatus()!=null && !searchBase.getFileStatus().equals("2") && searchBase.getReviewStatus()!= null && !searchBase.getReviewStatus().equals("2"))
		{
			return "redirect:/teach_08";
		}
//      資料是否已存在
		if (session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId") != null) {
			// 行業別列表
			JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// 縣市列表
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);

	      	// 申請書
			apply = new RetirementAdvancedAgeExperienceInheritanceApply();
			apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
			RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", searchApply);

			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			
			// 計劃書
			plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			RetirementAdvancedAgeExperienceInheritancePlan searchPlan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan,session.getId());
			model.addAttribute("plan", searchPlan);
			
			// 傳承專業技術及經驗之講師名單
			speakerList = new ExperienceInheritanceSpeakerList();
			speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(searchPlan.getId());
			model.addAttribute("speakerLists",selectExperienceInheritanceSpeakerLists(speakerList).toList());
			
			if (searchPlan.getAttachSpeakerList() != null
					&& searchPlan.getAttachSpeakerList().equals("Y")) {
				attachment = new Attachment();
				attachment.setFileBelong("B");
				attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
				attachment.setFileType("speakerList");
				attachment.setFileFrequency(1);
				model.addAttribute("speakerListAttachment", selectFiles(attachment).toList());
			}
			
			// 課程規劃表
			schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("scheduleLists",selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule).toList());
			
			// 參訓學員表
			participate = new RetirementAdvancedAgeParticipateStudent();
			participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("participateLists",selectRetirementAdvancedAgeParticipateStudents(participate).toList());
			
			// 經費概算表
			expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			model.addAttribute("expenditureLists",selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure).toList());
			
			attachment = new Attachment();
			// 設立登記證明文件
			attachment.setFileBelong("B");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
			attachment.setFileType("register");
			model.addAttribute("registerAttachment", selectFiles(attachment).toList());
			
			//講師為退休高齡者證明文件
			attachment.setFileType("speakerRetirement");
			model.addAttribute("speakerRetirementAttachment", selectFiles(attachment).toList());
			
			//講師具專業技術及經驗證明文件
			attachment.setFileType("speakerExperience");
			model.addAttribute("speakerExperienceAttachment", selectFiles(attachment).toList());
			
			//僱用證明文件
			attachment.setFileType("employment");
			model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
			
			// 其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "teach_07";
	}
	
	@RequestMapping(value = "/teach_08")
	public String teach_08(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase=new AdvancedAgeBase();
		searchBase=selectBTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		
		// 行業別列表
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// 縣市列表
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);

      	// 申請書
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		model.addAttribute("apply", searchApply);

		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
		list = jsonArray.toList();
		model.addAttribute("areaList", list);
		
		// 計劃書
		plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		RetirementAdvancedAgeExperienceInheritancePlan searchPlan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan,session.getId());
		model.addAttribute("plan", searchPlan);
		
		// 傳承專業技術及經驗之講師名單
		speakerList = new ExperienceInheritanceSpeakerList();
		speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(searchPlan.getId());
		model.addAttribute("speakerLists",selectExperienceInheritanceSpeakerLists(speakerList).toList());
		
		if (searchPlan.getAttachSpeakerList() != null
				&& searchPlan.getAttachSpeakerList().equals("Y")) {
			attachment = new Attachment();
			attachment.setFileBelong("B");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileType("speakerList");
			attachment.setFileFrequency(1);
			model.addAttribute("speakerListAttachment", selectFiles(attachment).toList());
		}
		
		// 課程規劃表
		schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
		schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("scheduleLists",selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule).toList());
		
		// 參訓學員表
		participate = new RetirementAdvancedAgeParticipateStudent();
		participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("participateLists",selectRetirementAdvancedAgeParticipateStudents(participate).toList());
		
		// 經費概算表
		expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
		expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("expenditureLists",selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure).toList());
		
		attachment = new Attachment();
		// 設立登記證明文件
		attachment.setFileBelong("B");
		attachment.setFileBelongId(searchApply.getId());
		attachment.setFileType("register");
		model.addAttribute("registerAttachment", selectFiles(attachment).toList());
		
		//講師為退休高齡者證明文件
		attachment.setFileType("speakerRetirement");
		model.addAttribute("speakerRetirementAttachment", selectFiles(attachment).toList());
		
		//講師具專業技術及經驗證明文件
		attachment.setFileType("speakerExperience");
		model.addAttribute("speakerExperienceAttachment", selectFiles(attachment).toList());
		
		//僱用證明文件
		attachment.setFileType("employment");
		model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
		
		// 其他經本署或各分署認定有必要提出之文件
		attachment.setFileType("necessary");
		model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		return "teach_08";
	}
	
	@RequestMapping(value = "/pdfBType")
	public void pdfBType(HttpServletRequest request,HttpServletResponse response) {
		session=request.getSession();
		// 第一步：建立一個文件例項 設定文件紙張為A4，文件排列方式為橫向排列
		// 實現A4紙頁面 並且縱向排列（不設定則為橫向
		Document document = new Document();
		// 第二步：建立PdfWriter物件，設定pdf生成路徑
		// 申請資料
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		FileOutputStream outputStream = null;
		try {
			 File directory = new File(filePath+"/B/"+searchApply.getId()+"/data.pdf").getCanonicalFile();
			//路徑是否存在
			if (!directory.getParentFile().exists()) {
			    try {
			    	boolean checkPFile = directory.getParentFile().mkdirs();
			    	if(checkPFile)
			    	{
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
		JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		JSONObject jsonObject = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getIndustry().equals(jsonObject.get("code"))) {
				cell.setPhrase(new Paragraph("行業別:" + jsonObject.get("name"), content));
				table2.addCell(cell);
				break;
			}
		}
		String companyAttributes=searchApply.getCompanyAttributes().equals("B")?"民營事業單位":searchApply.getCompanyAttributes().equals("G")?"民間團體":searchApply.getCompanyAttributes().equals("G")?"私立學校":"";
		cell.setPhrase(new Paragraph("單位屬性:" +companyAttributes , content));
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
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			if (searchApply.getContactCity().equals(jsonObject.get("code"))) {
				address = jsonObject.get("name").toString();
				// 地區列表
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
		plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		RetirementAdvancedAgeExperienceInheritancePlan searchPlan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan,session.getId());
		spaceCell.setPhrase(new Paragraph("主要業務/產品/服務:" + searchPlan.getItems(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("友善高齡者職場措施：" + searchPlan.getFriendlyMeasures(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		cell.setPhrase(new Paragraph("員工總人數:" + searchPlan.getEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("未滿29歲人數:" + searchPlan.getLowerEmploymentNumber(), content));
		table4.addCell(cell);
		
		cell.setPhrase(new Paragraph("29歲至44歲人數:" + searchPlan.getLowEmploymentNumber(), content));
		table4.addCell(cell);
		
		cell.setPhrase(new Paragraph("45歲至64歲人數:" + searchPlan.getMiddleEmploymentNumber(), content));
		table4.addCell(cell);
		
		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		cell.setPhrase(new Paragraph("65歲以上人數:" + searchPlan.getHighEmploymentNumber(), content));
		table4.addCell(cell);

		cell.setPhrase(new Paragraph("申請退休者人數:" + searchPlan.getRetirementEmploymentNumber(), content));
		table4.addCell(cell);
		
		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("計畫之必要性/可行性:" + searchPlan.getPlanDescription(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		String executionWay="";
		if(searchPlan.getExecutionWay().indexOf("S")!=-1)
		{
			executionWay="實務技術指導";
		}
		if(searchPlan.getExecutionWay().indexOf("C")!=-1)
		{
			if(executionWay.equals("")) {
				executionWay="教育訓練課程講授";
			}else {
				executionWay=executionWay+"、教育訓練課程講授";
			}
		}
		if(searchPlan.getExecutionWay().indexOf("O")!=-1)
		{
			if(executionWay.equals("")) {
				executionWay="其他";
			}else {
				executionWay=executionWay+"、其他:"+searchPlan.getExecutionWayDescription();
			}
		}
		spaceCell.setPhrase(new Paragraph("執行方式 ( 可複選 ):" + executionWay, content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		spaceCell.setPhrase(new Paragraph("預計執行期間:" + searchPlan.getPlanStartTime() + " ~ " + searchPlan.getPlanEndTime(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);

		document.add(table4);

		// 計畫達成指標及預期效益
		document.add(new Paragraph("計畫達成指標及預期效益", title));
		document.add(new Paragraph("\n"));
		
		table4.flushContent();
		
		spaceCell.setPhrase(new Paragraph("預計傳承之內容及時數:" + searchPlan.getExperienceInheritance(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		spaceCell.setPhrase(new Paragraph("參加課程或接受指導人次:" + searchPlan.getParticipate(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		spaceCell.setPhrase(new Paragraph("其他效益說明:" + searchPlan.getBenefit(), content));
		table4.addCell(spaceCell);

		spaceCell.setPhrase(new Paragraph("\n"));
		table4.addCell(spaceCell);
		
		document.add(table4);
		
		
		// 傳承專業技術及經驗之講師名單
		document.add(new Paragraph("傳承專業技術及經驗之講師名單", title));
		document.add(new Paragraph("\n"));
		if (searchPlan.getAttachSpeakerList() != null
				&& searchPlan.getAttachSpeakerList().equals("Y")) {
			PdfPTable table3EmploymentList = new PdfPTable(3);
			table3EmploymentList.setWidthPercentage(100);
		
			attachment = new Attachment();
			attachment.setFileBelong("B");
			attachment.setFileBelongId(searchApply.getId());
			attachment.setFileType("speakerList");
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
			table3EmploymentList.addCell(spaceCell);
			
			document.add(table3EmploymentList);
		}
		if (searchPlan.getAttachSpeakerList() != null
				&& searchPlan.getAttachSpeakerList().equals("N")) {
			
			PdfPTable table10EmploymentList = new PdfPTable(10);
			table10EmploymentList.setWidthPercentage(100);
			
			cell.setPhrase(new Paragraph("編號", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("勞工姓名", table));
			table10EmploymentList.addCell(cell);
			
			cell.setPhrase(new Paragraph("出生日期", table));
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
			
			cell.setPhrase(new Paragraph("計畫執行方式", table));
			table10EmploymentList.addCell(cell);
			
			
//			spaceCell.setPhrase(new Paragraph("\n"));
//			table10EmploymentList.addCell(spaceCell);

			speakerList = new ExperienceInheritanceSpeakerList();
			speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(searchPlan.getId());
			JSONArray speaker = selectExperienceInheritanceSpeakerLists(speakerList);
			
			for(int i=0;i<speaker.toList().size();i++)
			{
				cell.setPhrase(new Paragraph(String.valueOf(i+1), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(speaker.getJSONObject(i).get("name").toString(), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(speaker.getJSONObject(i).get("birthday").toString(), table));
				table10EmploymentList.addCell(cell);
				
				cell.setPhrase(new Paragraph(speaker.getJSONObject(i).get("identification").toString(), table));
				table10EmploymentList.addCell(cell);
				if(speaker.getJSONObject(i).get("laborProtectionTime").toString().length()==7)
				{
					cell.setPhrase(new Paragraph("勞工保險", table));
					table10EmploymentList.addCell(cell);
					
					String date=speaker.getJSONObject(i).get("laborProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}else if(speaker.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
					cell.setPhrase(new Paragraph("職災保險", table));
					table10EmploymentList.addCell(cell);
					
					String date=speaker.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
					cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), table));
					table10EmploymentList.addCell(cell);
				}
				
				if(speaker.getJSONObject(i).get("manager").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("主管", table));
					table10EmploymentList.addCell(cell);
				}else if(speaker.getJSONObject(i).get("manager").toString().equals("N")) {
					cell.setPhrase(new Paragraph("非主管", table));
					table10EmploymentList.addCell(cell);
				}
				
				if(speaker.getJSONObject(i).get("relatives").toString().equals("Y")) {
					cell.setPhrase(new Paragraph("三等親內", table));
					table10EmploymentList.addCell(cell);
				}else if(speaker.getJSONObject(i).get("relatives").toString().equals("N")) {
					cell.setPhrase(new Paragraph("非三等親", table));
					table10EmploymentList.addCell(cell);
				}

				if(speaker.getJSONObject(i).get("workingHours").toString().equals("A")) {
					cell.setPhrase(new Paragraph("全時", table));
					table10EmploymentList.addCell(cell);
				}else if(speaker.getJSONObject(i).get("workingHours").toString().equals("P")) {
					cell.setPhrase(new Paragraph("部分工時", table));
					table10EmploymentList.addCell(cell);
				}
				
				if(speaker.getJSONObject(i).get("executionWay").toString().equals("S")) {
					cell.setPhrase(new Paragraph("實務技術指導", table));
					table10EmploymentList.addCell(cell);
				}else if(speaker.getJSONObject(i).get("executionWay").toString().equals("C")) {
					cell.setPhrase(new Paragraph("教育訓練課程講授", table));
					table10EmploymentList.addCell(cell);
				}else {
					cell.setPhrase(new Paragraph("其他", table));
					table10EmploymentList.addCell(cell);
				}
			}
			document.add(table10EmploymentList);
		}
		
		// 課程規劃
		document.add(new Paragraph("課程規劃", title));
		document.add(new Paragraph("\n"));
		
		schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
		schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		JSONArray scheduleList = selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
		
		for(int i=0;i<scheduleList.toList().size();i++)
		{
			table2.flushContent();
			table4.flushContent();
			
			cell.setPhrase(new Paragraph("預計執行期間:", content));
			table2.addCell(cell);
			
			cell.setPhrase(new Paragraph("課程名稱:", content));
			table2.addCell(cell);
			
			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("executionStartTime").toString()+" ~ "+scheduleList.getJSONObject(i).get("executionEndTime").toString(), content));
			table2.addCell(cell);
			
			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("subject").toString(), content));
			table2.addCell(cell);
		
			cell.setPhrase(new Paragraph("開課時間", content));
			table4.addCell(cell);
			
			cell.setPhrase(new Paragraph("講師姓名", content));
			table4.addCell(cell);
			
			cell.setPhrase(new Paragraph("預計授課時數", content));
			table4.addCell(cell);
			
			cell.setPhrase(new Paragraph("預計參訓人數", content));
			table4.addCell(cell);

			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("executionTime").toString().replace("=", ":"), content));
			table4.addCell(cell);

			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("speakerName").toString(), content));
			table4.addCell(cell);

			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("teachingHours").toString(), content));
			table4.addCell(cell);

			cell.setPhrase(new Paragraph(scheduleList.getJSONObject(i).get("participateNumber").toString(), content));
			table4.addCell(cell);
			
			spaceCell.setPhrase(new Paragraph("課程大綱:" + scheduleList.getJSONObject(i).get("introduction").toString(), content));
			table4.addCell(spaceCell);
			
			spaceCell.setPhrase(new Paragraph("預計參訓學員:" + scheduleList.getJSONObject(i).get("participatePeople").toString(), content));
			table4.addCell(spaceCell);
			
			document.add(table2);
			document.add(table4);
			document.add(new Paragraph("\n"));
		}
		
		// 參訓學員名單
		document.add(new Paragraph("參訓學員名單", title));
		document.add(new Paragraph("\n"));
				
		PdfPTable table8 = new PdfPTable(8);
		table8.setWidthPercentage(100);
		
		participate = new RetirementAdvancedAgeParticipateStudent();
		participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		JSONArray participateList = selectRetirementAdvancedAgeParticipateStudents(participate);
		
		cell.setPhrase(new Paragraph("編號", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("勞工姓名", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("保險類型", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("加保日期", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("年資", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("職務類型", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("工時類型", content));
		table8.addCell(cell);
		
		cell.setPhrase(new Paragraph("部門", content));
		table8.addCell(cell);
		
		for(int i=0;i<participateList.toList().size();i++)
		{
			cell.setPhrase(new Paragraph(String.valueOf(i+1), content));
			table8.addCell(cell);
			
			cell.setPhrase(new Paragraph(participateList.getJSONObject(i).get("name").toString(), content));
			table8.addCell(cell);
			
			if(participateList.getJSONObject(i).get("laborProtectionTime").toString().length()==7)
			{
				cell.setPhrase(new Paragraph("勞工保險", content));
				table8.addCell(cell);
				
				String date=participateList.getJSONObject(i).get("laborProtectionTime").toString();
				cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), content));
				table8.addCell(cell);
			}else if(participateList.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				cell.setPhrase(new Paragraph("職災保險", content));
				table8.addCell(cell);
				
				String date=participateList.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
				cell.setPhrase(new Paragraph(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5), content));
				table8.addCell(cell);
			}
			
			cell.setPhrase(new Paragraph(participateList.getJSONObject(i).get("seniority").toString(), content));
			table8.addCell(cell);
			

			if(participateList.getJSONObject(i).get("manager").toString().equals("Y")) {
				cell.setPhrase(new Paragraph("主管", content));
				table8.addCell(cell);
			}else if(participateList.getJSONObject(i).get("manager").toString().equals("N")) {
				cell.setPhrase(new Paragraph("非主管", content));
				table8.addCell(cell);
			}

			if(participateList.getJSONObject(i).get("workingHours").toString().equals("A")) {
				cell.setPhrase(new Paragraph("全時", content));
				table8.addCell(cell);
			}else if(participateList.getJSONObject(i).get("workingHours").toString().equals("P")) {
				cell.setPhrase(new Paragraph("部分工時", content));
				table8.addCell(cell);
			}
			
			cell.setPhrase(new Paragraph(participateList.getJSONObject(i).get("department").toString(), content));
			table8.addCell(cell);
		}
		document.add(table8);
		
		// 申請補助經費概算
		document.add(new Paragraph("申請補助經費概算", title));
		document.add(new Paragraph("\n"));
		
		PdfPTable table3 = new PdfPTable(3);
		table3.setWidthPercentage(100);
		
		expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
		expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		JSONArray expenditureList = selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
		
		for(int i=0;i<expenditureList.toList().size();i++) {
			
			cell.setPhrase(new Paragraph("項目", content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph("單價", content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph("數量", content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph(expenditureList.getJSONObject(i).get("planName").toString(), content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph(expenditureList.getJSONObject(i).get("unitPrice").toString(), content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph(expenditureList.getJSONObject(i).get("amount").toString(), content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph("總價", content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph("申請本部補助", content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph("說明", content));
			table3.addCell(cell);
			
			String totalAmounts=String.valueOf(Integer.valueOf(expenditureList.getJSONObject(i).get("unitPrice").toString())*Integer.valueOf(expenditureList.getJSONObject(i).get("amount").toString()));
			cell.setPhrase(new Paragraph(totalAmounts, content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph(expenditureList.getJSONObject(i).get("amounts").toString(), content));
			table3.addCell(cell);
			
			cell.setPhrase(new Paragraph(expenditureList.getJSONObject(i).get("description").toString(), content));
			table3.addCell(cell);
			
			spaceCell.setPhrase(new Paragraph("\n"));
			table3.addCell(spaceCell);
		}
		document.add(table3);
		// 檢附文件
		document.add(new Paragraph("檢附文件", title));
		document.add(new Paragraph("\n"));

		table3.flushContent();

		spaceCell.setPhrase(new Paragraph("設立登記證明文件:", content));
		table3.addCell(spaceCell);
		attachment = new Attachment();
		// 設立登記證明文件
		attachment.setFileBelong("B");
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

		spaceCell.setPhrase(new Paragraph("講師為退休高齡者證明文件:", content));
		table3.addCell(spaceCell);
		// 投保勞保或職災保險證明文件
		attachment.setFileType("speakerRetirement");
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

		spaceCell.setPhrase(new Paragraph("講師具專業技術及經驗證明文件:", content));
		table3.addCell(spaceCell);
		// 薪資證明或其他證明文件
		attachment.setFileType("speakerExperience");
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
		
		spaceCell.setPhrase(new Paragraph("僱用證明文件:", content));
		table3.addCell(spaceCell);
		// 出勤證明文件
		attachment.setFileType("employment");
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
		}catch(FileNotFoundException e ) {
			logger.warn(e.getMessage());
		}catch(DocumentException e) {
			logger.warn(e.getMessage());
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
		finally {
			try {
				if(outputStream != null)
				{
					outputStream.close();
				}
			} catch (IOException e) {
				logger.warn(e.getMessage());
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print("{\"status\":\"success\",\"path\":\""+"/B/"+StringEscapeUtils.escapeHtml(searchApply.getId().toString())+"/data.pdf\"}");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}

	}
	
	@RequestMapping(value = "/schedule_teach_login")
	public String schedule_teach_login(HttpServletRequest request,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/login";
		}else {
			return "redirect:/schedule_teach";
		}
		
	}
	
	@RequestMapping(value = "/schedule_teach")
	public String schedule_teach(HttpServletRequest request,Model model,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/schedule_teach_login";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase=new AdvancedAgeBase();
		searchBase=selectBTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		if(searchBase.getCaseStatus()!=null) {
			// 行業別列表
			JSONArray jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// 縣市列表
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
	
			model.addAttribute("mailDomain", mailDomain);
			if (session.getAttribute(session.getId()+"seq") != null) {
				// ------申請表 start------
				// 申請書
				apply = new RetirementAdvancedAgeExperienceInheritanceApply();
				apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
				RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
				model.addAttribute("apply", searchApply);

				jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + searchApply.getContactCity(),""));
				list = jsonArray.toList();
				model.addAttribute("areaList", list);
				
				// 計劃書
				plan = new RetirementAdvancedAgeExperienceInheritancePlan();
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
				RetirementAdvancedAgeExperienceInheritancePlan searchPlan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan,session.getId());
				model.addAttribute("plan", searchPlan);
				
				// 傳承專業技術及經驗之講師名單
				speakerList = new ExperienceInheritanceSpeakerList();
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(searchPlan.getId());
				model.addAttribute("speakerLists",selectExperienceInheritanceSpeakerLists(speakerList).toList());
				
				if (searchPlan.getAttachSpeakerList() != null
						&& searchPlan.getAttachSpeakerList().equals("Y")) {
					attachment = new Attachment();
					attachment.setFileBelong("B");
					attachment.setFileBelongId(searchApply.getId());
					attachment.setFileType("speakerList");
					attachment.setFileFrequency(1);
					model.addAttribute("speakerListAttachment", selectFiles(attachment).toList());
				}
				
				// 課程規劃表
				schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
				model.addAttribute("scheduleLists",selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule).toList());
				
				// 參訓學員表
				participate = new RetirementAdvancedAgeParticipateStudent();
				participate.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
				model.addAttribute("participateLists",selectRetirementAdvancedAgeParticipateStudents(participate).toList());
				
				// 經費概算表
				expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
				expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
				model.addAttribute("expenditureLists",selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure).toList());
				
				attachment = new Attachment();
				// 設立登記證明文件
				attachment.setFileBelong("B");
				attachment.setFileBelongId(searchApply.getId());
				attachment.setFileType("register");
				model.addAttribute("registerAttachment", selectFiles(attachment).toList());
				
				//講師為退休高齡者證明文件
				attachment.setFileType("speakerRetirement");
				model.addAttribute("speakerRetirementAttachment", selectFiles(attachment).toList());
				
				//講師具專業技術及經驗證明文件
				attachment.setFileType("speakerExperience");
				model.addAttribute("speakerExperienceAttachment", selectFiles(attachment).toList());
				
				//僱用證明文件
				attachment.setFileType("employment");
				model.addAttribute("employmentAttachment", selectFiles(attachment).toList());
				
				// 其他經本署或各分署認定有必要提出之文件
				attachment.setFileType("necessary");
				model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
			}
		}
		return "schedule_teach";
	}
	
	@RequestMapping(value = "/schedule_teach_payment_login")
	public String schedule_teach_payment_login(HttpServletRequest request,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/login";
		}else {
			return "redirect:/schedule_teach_payment";
		}
	}
	
	@RequestMapping(value = "/schedule_teach_payment")
	public String schedule_teach_payment(HttpServletRequest request,Model model,RedirectAttributes redirectAttrs) {
		session=request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/schedule_teach_payment_login";
		}
		
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		base=selectBTypeAdvancedAgeBase(base);
		model.addAttribute("base",base );
		
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		
		result = new RetirementAdvancedAgeExperienceInheritanceResult();
		result.setSeq(session.getAttribute(session.getId()+"seq").toString());
		result.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("result", selectRetirementAdvancedAgeExperienceInheritanceResult(result));
		
		if (base.getId() != null) {
			model.addAttribute("baseAllowanceFrequencyTime", base.getAllowanceFileStatusRecord().split(";").length);
			attachment = new Attachment();
			//本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(base.getId());
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());
			
			//請款之領據正本
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());
			
			//成果報告之內容附件
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());
			
			//經費支用單據正本及明細表
			attachment.setFileType("expenditure");
			model.addAttribute("expenditureAttachment", selectFiles(attachment).toList());
			
			//內聘講師鐘點費印領清冊
			attachment.setFileType("speakerFee");
			model.addAttribute("speakerFeeAttachment", selectFiles(attachment).toList());
			
			//其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "schedule_teach_payment";
	}
	
	@RequestMapping(value = "/teach_payment")
	public String teach_payment(HttpServletRequest request) {
		session=request.getSession();
		if(session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "login";
		}else{
			return "teach_payment";
		}
		
	}

	@RequestMapping(value = "/teach_payment_01")
	public void teach_payment_01(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttrs) throws IOException {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			response.getWriter().print("success;login");
		}else {
			base = new AdvancedAgeBase();
			base.setSeq(session.getAttribute(session.getId()+"seq").toString());
			AdvancedAgeBase searchBase = selectBTypeAdvancedAgeBase(base);
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
				response.getWriter().print("success;teach_payment_02");
			}
		}
	}
	
	@RequestMapping(value = "/teach_payment_02")
	public String teach_payment_02(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/teach_payment_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		請領已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/teach_payment_05";
		}
		session.setAttribute("base", searchBase);
//      資料是否已存在
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		session.setAttribute(session.getId() + "retirementAdvancedAgeExperienceInheritanceApplyId", searchApply.getId());
		model.addAttribute("base", searchBase);
		model.addAttribute("apply", searchApply);
		
//      資料是否已存在
		result = new RetirementAdvancedAgeExperienceInheritanceResult();
		result.setSeq(searchApply.getSeq());
		result.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("result", selectRetirementAdvancedAgeExperienceInheritanceResult(result));
		return "teach_payment_02";
	}
	
	@RequestMapping(value = "/teach_payment_03")
	public String teach_payment_03(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/teach_payment_01";
		}
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId"));
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		請領已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/teach_payment_05";
		}
//      資料是否已存在
		if (session.getAttribute(session.getId()+"baseId") != null) {
			attachment = new Attachment();
			//本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());
			
			//請款之領據正本
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());
			
			//成果報告之內容附件
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());
			
			//經費支用單據正本及明細表
			attachment.setFileType("expenditure");
			model.addAttribute("expenditureAttachment", selectFiles(attachment).toList());
			
			//內聘講師鐘點費印領清冊
			attachment.setFileType("speakerFee");
			model.addAttribute("speakerFeeAttachment", selectFiles(attachment).toList());
			
			//其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "teach_payment_03";
	}
	
	@RequestMapping(value = "/teach_payment_04")
	public String teach_payment_04(HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "seq") == null) {
			return "redirect:/teach_payment_01";
		}
		model.addAttribute("baseId", session.getAttribute(session.getId()+"baseId"));
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
//		請領已送出
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		if(searchBase.getCaseStatus()!=null && !searchBase.getCaseStatus().equals("4") && !searchBase.getAllowanceFileStatus().equals("2"))
		{
			return "redirect:/teach_payment_05";
		}
//      資料是否已存在
		result = new RetirementAdvancedAgeExperienceInheritanceResult();
		result.setSeq(session.getAttribute(session.getId()+"seq").toString());
		result.setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer.valueOf(session.getAttribute(session.getId()+"retirementAdvancedAgeExperienceInheritanceApplyId").toString()));
		model.addAttribute("result", selectRetirementAdvancedAgeExperienceInheritanceResult(result));
		
		if (session.getAttribute(session.getId()+"baseId") != null) {
			attachment = new Attachment();
			//本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());
			
			//請款之領據正本
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());
			
			//成果報告之內容附件
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());
			
			//經費支用單據正本及明細表
			attachment.setFileType("expenditure");
			model.addAttribute("expenditureAttachment", selectFiles(attachment).toList());
			
			//內聘講師鐘點費印領清冊
			attachment.setFileType("speakerFee");
			model.addAttribute("speakerFeeAttachment", selectFiles(attachment).toList());
			
			//其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "teach_payment_04";
	}
	
	@RequestMapping(value = "/teach_payment_05")
	public String teach_payment_05(HttpServletRequest request,Model model) {
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"seq") == null) {
			return "redirect:/teach_payment_01";
		}
		base = new AdvancedAgeBase();
		base.setSeq(session.getAttribute(session.getId()+"seq").toString());
		AdvancedAgeBase searchBase=selectBTypeAdvancedAgeBase(base);
		model.addAttribute("base", searchBase);
		model.addAttribute("baseAllowanceFrequencyTime", searchBase.getAllowanceFileStatusRecord().split(";").length);
		
		apply = new RetirementAdvancedAgeExperienceInheritanceApply();
		apply.setSeq(session.getAttribute(session.getId()+"seq").toString());
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		
		result = new RetirementAdvancedAgeExperienceInheritanceResult();
		result.setSeq(session.getAttribute(session.getId()+"seq").toString());
		result.setRetirementAdvancedAgeExperienceInheritanceApplyId(searchApply.getId());
		model.addAttribute("result", selectRetirementAdvancedAgeExperienceInheritanceResult(result));
		
		if (session.getAttribute(session.getId()+"baseId") != null) {
			attachment = new Attachment();
			//本計畫核准函影本
			attachment.setFileBelong("BA");
			attachment.setFileBelongId(Integer.valueOf(session.getAttribute(session.getId()+"baseId").toString()));
			attachment.setFileType("approved");
			model.addAttribute("approvedAttachment", selectFiles(attachment).toList());
			
			//請款之領據正本
			attachment.setFileType("receipt");
			model.addAttribute("receiptAttachment", selectFiles(attachment).toList());
			
			//成果報告之內容附件
			attachment.setFileType("result");
			model.addAttribute("resultAttachment", selectFiles(attachment).toList());
			
			//經費支用單據正本及明細表
			attachment.setFileType("expenditure");
			model.addAttribute("expenditureAttachment", selectFiles(attachment).toList());
			
			//內聘講師鐘點費印領清冊
			attachment.setFileType("speakerFee");
			model.addAttribute("speakerFeeAttachment", selectFiles(attachment).toList());
			
			//其他經本署或各分署認定有必要提出之文件
			attachment.setFileType("necessary");
			model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
		}
		return "teach_payment_05";
	}
	
	public RetirementAdvancedAgeExperienceInheritanceApply selectRetirementAdvancedAgeExperienceInheritanceApply(RetirementAdvancedAgeExperienceInheritanceApply apply) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = new RetirementAdvancedAgeExperienceInheritanceApply();
		try {
			json = objectMapper.writeValueAsString(apply);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectRetirementAdvancedAgeExperienceInheritanceApply", json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchApply = mapper.readValue(jsondata, RetirementAdvancedAgeExperienceInheritanceApply.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchApply;
	}
	
	public RetirementAdvancedAgeExperienceInheritancePlan selectRetirementAdvancedAgeExperienceInheritancePlan(RetirementAdvancedAgeExperienceInheritancePlan plan,String sid) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		RetirementAdvancedAgeExperienceInheritancePlan searchPlan = new RetirementAdvancedAgeExperienceInheritancePlan();
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectRetirementAdvancedAgeExperienceInheritancePlan", json);
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (!jsondata.equals(""))
				searchPlan = mapper.readValue(jsondata, RetirementAdvancedAgeExperienceInheritancePlan.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}

		session.setAttribute(sid+"retirementAdvancedAgeExperienceInheritancePlanId", searchPlan.getId());
		return searchPlan;
	}
	
	public JSONArray selectExperienceInheritanceSpeakerLists(ExperienceInheritanceSpeakerList speakerList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(speakerList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectExperienceInheritanceSpeakerLists", json));
		return array;
	}
	
	public JSONArray selectRetirementAdvancedAgeExperienceInheritanceSchedules(RetirementAdvancedAgeExperienceInheritanceSchedule schedule) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(schedule);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectRetirementAdvancedAgeExperienceInheritanceSchedules", json));
		return array;
	}
	
	public JSONArray selectRetirementAdvancedAgeParticipateStudents(RetirementAdvancedAgeParticipateStudent participate) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(participate);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectRetirementAdvancedAgeParticipateStudents", json));
		return array;
	}
	
	public RetirementAdvancedAgeExperienceInheritanceResult selectRetirementAdvancedAgeExperienceInheritanceResult(RetirementAdvancedAgeExperienceInheritanceResult result) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		RetirementAdvancedAgeExperienceInheritanceResult searchResult = new RetirementAdvancedAgeExperienceInheritanceResult();
		try {
			json = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectRetirementAdvancedAgeExperienceInheritanceResult", json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchResult = mapper.readValue(jsondata, RetirementAdvancedAgeExperienceInheritanceResult.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchResult;
	}
	
	public JSONArray selectRetirementAdvancedAgeExperienceInheritanceExpenditures(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(expenditure);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectRetirementAdvancedAgeExperienceInheritanceExpenditures", json));
		return array;
	}
	
	public AdvancedAgeBase selectBTypeAdvancedAgeBase(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectBTypeAdvancedAgeBase", json));
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
	
	public JSONObject selectCompanyInfoData(CompanyInfo info){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"selectCompanyInfoData",json));
		return object;
	}
}