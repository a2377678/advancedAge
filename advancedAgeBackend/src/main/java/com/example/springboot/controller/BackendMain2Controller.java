package com.example.springboot.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jasypt.util.text.BasicTextEncryptor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springboot.entity.Pagination;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.entity.UserLoginRecord;
import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.FunctionList;
import com.example.springboot.entity.FunctionPermission;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.DateFormatUtil;
import com.example.springboot.util.SendEmail;
import com.example.springboot.util.Zip;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller 
public class BackendMain2Controller { 

	Logger logger = LogManager.getLogger(BackendMain2Controller.class);
	
	@Autowired
	public CallApi api;
	
	@Autowired
	SendEmail sendEmail;
	
	Zip zip = new Zip();
	
	@Value("${api_ip}")
	private String ip;
	
	@Value("${file_path}")
	private String filePath;
	
	@Value("${mail_domain}")
	private String mailDomain;

	@Value("${applyYear}")
	private String applyYear;
	
	HttpServletRequest request;
	
	HttpSession session;
	
	Attachment attachment;
	
	JSONArray jsonArray;
	
	Unit unit;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@RequestMapping(value = "/k01")
	public String k01(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------縣市列表 start------
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		model.addAttribute("cityList", jsonArray.toList());
		// ------縣市列表 end------
		//所有資料
		AdvancedAgeBase totalBase = new AdvancedAgeBase();
		totalBase.setYear(applyYear);
		model.addAttribute("totalBaseList", selectBTypeAdvancedAgeBase(totalBase).toList());
		model.addAttribute("year", applyYear);
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//查詢資料
		base.setFileStatus("4");//附件通過
		jsonArray = selectBTypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
		
		pagination.setNums(jsonArray.length());
//			List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		return "k01/k01";
	}
	
	@RequestMapping(value = "/k01_division")
	public String b01_division(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------縣市列表 start------
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		model.addAttribute("cityList", jsonArray.toList());
		// ------縣市列表 end------
		//所有資料
		AdvancedAgeBase totalBase = new AdvancedAgeBase();
		totalBase.setYear(applyYear);
		model.addAttribute("totalBaseList", selectBTypeAdvancedAgeBase(totalBase).toList());
		model.addAttribute("year", applyYear);
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//查詢資料
		jsonArray = selectBTypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		return "k01/k01_division";
	}
	
	@RequestMapping(value = "/l01")
	public String l01(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,UserInfo userInfo){ 
		session=request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("year", applyYear);
		model.addAttribute("base", base);
		model.addAttribute("unitList", getUnit().toList());
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setFileStatus("1、2、3");
			base.setYear(applyYear);
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectBTypeAdvancedAgeBaseFileStatus(base);
		JSONArray pageArray = new JSONArray();
		
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "l01/l01";
	}
	
	@RequestMapping(value = "/l01File")
	public String l01File(HttpServletRequest request,Model model,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		AdvancedAgeBase nbase = selectBTypeAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);
		
		//userinfo
		UserInfo userInfo = new UserInfo();
//		userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
		
		// ------申請表 start------
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		model.addAttribute("apply", searchApply);
		// ------申請表 end--------
		
		//負責人
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setSeq(base.getSeq());
		try {
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		}catch(JSONException e) {
			logger.warn(e.getMessage());
		}
		//文件
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
		
		model.addAttribute("mailDomain", mailDomain);
		
		//信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("A");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		sdf = new SimpleDateFormat("yyyyMMdd");
		model.addAttribute("today", sdf.format(new Date()));
		return "l01/file";
	}
	
	@RequestMapping(value = "/l02")
	public String l02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,UserInfo userInfo){ 
		session=request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("year", applyYear);
		model.addAttribute("base", base);
		model.addAttribute("unitList", getUnit().toList());
		base.setFileStatus("3");
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setYear(applyYear);
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectBTypeAdvancedAgeBaseFileStatus(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		
		return "l02/l02";
	}
	
	@RequestMapping(value = "/saveRar2", method = RequestMethod.POST)
	public void saveRar2(HttpServletResponse response,Attachment attachment,String date){ 
		try {
			zip.ZipDirs(filePath+"/B/"+attachment.getFileBelongId(), date+".rar", true, f -> true,filePath+"/B/"+attachment.getFileBelongId()+"/register/"+attachment.getFileFrequency(),filePath+"/B/"+attachment.getFileBelongId()+"/speakerRetirement/"+attachment.getFileFrequency(),filePath+"/B/"+attachment.getFileBelongId()+"/speakerExperience/"+attachment.getFileFrequency(),filePath+"/B/"+attachment.getFileBelongId()+"/employment/"+attachment.getFileFrequency(),filePath+"/B/"+attachment.getFileBelongId()+"/necessary/"+attachment.getFileFrequency());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("success;"+"downloadRar?path=/B/"+attachment.getFileBelongId()+"/"+date+".rar");
		} catch (IOException e) {
			logger.warn(e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().print("fail");
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/allowanceSaveRar2", method = RequestMethod.POST)
	public void allowanceSaveRar2(HttpServletResponse response,Attachment attachment,String date){ 
		try {
			zip.ZipDirs(filePath+"/BA/"+attachment.getFileBelongId(), date+".rar", true, f -> true,filePath+"/BA/"+attachment.getFileBelongId()+"/approved/"+attachment.getFileFrequency(),filePath+"/BA/"+attachment.getFileBelongId()+"/receipt/"+attachment.getFileFrequency(),filePath+"/BA/"+attachment.getFileBelongId()+"/result/"+attachment.getFileFrequency(),filePath+"/BA/"+attachment.getFileBelongId()+"/expenditure/"+attachment.getFileFrequency(),filePath+"/BA/"+attachment.getFileBelongId()+"/speakerFee/"+attachment.getFileFrequency(),filePath+"/BA/"+attachment.getFileBelongId()+"/necessary/"+attachment.getFileFrequency());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("success;"+"downloadRar?path=/BA/"+attachment.getFileBelongId()+"/"+date+".rar");
		} catch (IOException e) {
			logger.warn(e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().print("fail");
			} catch (IOException e1) {
				logger.warn(e1.getMessage());
			}
		}
	}
	
	@RequestMapping(value = "/m01")
	public String m01(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		base.setYear(applyYear);
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setCaseStatus("1、2、3");
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		base.setFileStatus("4"); //附件通過
		jsonArray = selectBTypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
		//分頁
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
			
		return "m01/m01";
	}
	
	@RequestMapping(value = "/m01_1")
	public String m01_1(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//			userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			//負責人
			try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			}catch(JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------
			
			// ------縣市列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----
			
			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(),""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------講師名單 start------
			ExperienceInheritanceSpeakerList speakerList = new ExperienceInheritanceSpeakerList();
			if(plan.getId()!=null) {
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(plan.getId());
				JSONArray speakerList_JSONArray=selectExperienceInheritanceSpeakerLists(speakerList);
				model.addAttribute("speakerListSize", speakerList_JSONArray.toList().size());
			}
			// ------講師名單 end------
			
			// ------課程規劃 start------
			RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			if(apply.getId()!=null) {
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
				double scheduleTime=0.0;
				int participateNumber=0;
				for(int i=0;i<schedule_JSONArray.toList().size();i++) {
					scheduleTime=scheduleTime+Double.valueOf(schedule_JSONArray.getJSONObject(i).get("teachingHours").toString());
					participateNumber=participateNumber+Integer.valueOf(schedule_JSONArray.getJSONObject(i).get("participateNumber").toString());
				}
				model.addAttribute("schedule", schedule_JSONArray.toList());
				model.addAttribute("scheduleSize", schedule_JSONArray.toList().size());
				model.addAttribute("scheduleTime", scheduleTime);
				model.addAttribute("participateNumber", participateNumber);
			}
			// ------課程規劃 end------
						
			// ------參訓學員 start------
			RetirementAdvancedAgeParticipateStudent participateStudent = new RetirementAdvancedAgeParticipateStudent();
			if(apply.getId()!=null) {
				participateStudent.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				model.addAttribute("participateStudentSize", selectRetirementAdvancedAgeParticipateStudents(participateStudent).toList().size());
			}
			// ------參訓學員 end------
			
			// ------經費概算 start------
			RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			if(apply.getId()!=null) {
				expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray expenditure_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
				double totalPrice=0.0,totalAmounts=0.0;
				for(int i=0;i<expenditure_JSONArray.toList().size();i++) {
					totalPrice=totalPrice+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("unitPrice").toString())*Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amount").toString());
					totalAmounts=totalAmounts+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amounts").toString());
				}
				model.addAttribute("totalPrice", totalPrice);
				model.addAttribute("totalAmounts", totalAmounts);
				model.addAttribute("expenditureSize", expenditure_JSONArray.toList().size());
			}
			// ------經費概算 end------
			
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate=sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("B");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		return "m01/m01_1";
	}
	
	@RequestMapping(value = "/m01_1_print")
	public String m01_1_print(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//			userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			//負責人
			try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			}catch(JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------
			
			// ------縣市列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----
			
			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(),""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			
			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getRegisterCity(),""));
			list = jsonArray.toList();
			model.addAttribute("registerAreaList", list);
			// ------鄉鎮市區 end----
						
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------講師名單 start------
			ExperienceInheritanceSpeakerList speakerList = new ExperienceInheritanceSpeakerList();
			if(plan.getId()!=null) {
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(plan.getId());
				JSONArray speakerList_JSONArray=selectExperienceInheritanceSpeakerLists(speakerList);
				model.addAttribute("speakerListSize", speakerList_JSONArray.toList().size());
			}
			// ------講師名單 end------
			
			// ------課程規劃 start------
			RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			if(apply.getId()!=null) {
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
				double scheduleTime=0.0;
				int participateNumber=0;
				for(int i=0;i<schedule_JSONArray.toList().size();i++) {
					scheduleTime=scheduleTime+Double.valueOf(schedule_JSONArray.getJSONObject(i).get("teachingHours").toString());
					participateNumber=participateNumber+Integer.valueOf(schedule_JSONArray.getJSONObject(i).get("participateNumber").toString());
				}
				model.addAttribute("schedule", schedule_JSONArray.toList());
				model.addAttribute("scheduleSize", schedule_JSONArray.toList().size());
				model.addAttribute("scheduleTime", scheduleTime);
				model.addAttribute("participateNumber", participateNumber);
			}
			// ------課程規劃 end------
						
			// ------參訓學員 start------
			RetirementAdvancedAgeParticipateStudent participateStudent = new RetirementAdvancedAgeParticipateStudent();
			if(apply.getId()!=null) {
				participateStudent.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				model.addAttribute("participateStudentSize", selectRetirementAdvancedAgeParticipateStudents(participateStudent).toList().size());
			}
			// ------參訓學員 end------
			
			// ------經費概算 start------
			RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			if(apply.getId()!=null) {
				expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray expenditure_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
				double totalPrice=0.0,totalAmounts=0.0;
				for(int i=0;i<expenditure_JSONArray.toList().size();i++) {
					totalPrice=totalPrice+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("unitPrice").toString())*Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amount").toString());
					totalAmounts=totalAmounts+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amounts").toString());
				}
				model.addAttribute("totalPrice", totalPrice);
				model.addAttribute("totalAmounts", totalAmounts);
				model.addAttribute("expenditureSize", expenditure_JSONArray.toList().size());
			}
			// ------經費概算 end------
			
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate=sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("B");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		return "m01/m01_1_print";
	}
	
	@RequestMapping(value = "/speakerList")
	public String speakerList(HttpServletRequest request,Model model,AdvancedAgeBase base,RetirementAdvancedAgeExperienceInheritanceApply apply){
		session=request.getSession();
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------講師名單 start------
			ExperienceInheritanceSpeakerList speakerList = new ExperienceInheritanceSpeakerList();
			if(plan.getId()!=null) {
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(plan.getId());
				JSONArray speakerList_JSONArray=selectExperienceInheritanceSpeakerLists(speakerList);
				model.addAttribute("speakerList", speakerList_JSONArray.toList());
				model.addAttribute("speakerListSize", speakerList_JSONArray.toList().size());
			}
			// ------講師名單 end------
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5,7));
			model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		}
		return "m01/speakerList";
	}
	
	@RequestMapping(value = "/exportSpeakerExcel")
	public void exportSpeakerExcel(Model model,HttpServletResponse response,RetirementAdvancedAgeExperienceInheritanceApply apply) throws IOException {
		//創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//創建工作表
		XSSFSheet sheet = wb.createSheet("講師名單清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6*256);
		sheet.setColumnWidth(1, 13*256);
		sheet.setColumnWidth(2, 14*256);
		sheet.setColumnWidth(3, 16*256);
		sheet.setColumnWidth(4, 13*256);
		sheet.setColumnWidth(5, 14*256);
		sheet.setColumnWidth(6, 13*256);
		sheet.setColumnWidth(7, 15*256);
		sheet.setColumnWidth(8, 13*256);
		sheet.setColumnWidth(9, 20*256);
		row.setHeightInPoints(30);//設置行高

		 // 字體格式
		XSSFFont font = wb.createFont();
		font.setBold(true); // 粗體字
		font.setFontName("微軟正黑體");
		font.setFontHeightInPoints((short) 12);
		
		XSSFFont font1 = wb.createFont();
		font1.setBold(true); // 粗體字
		font1.setFontName("微軟正黑體");
		font1.setFontHeightInPoints((short) 11);
		font1.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
		
		XSSFFont font2 = wb.createFont();
		font2.setFontName("微軟正黑體");
		font2.setFontHeightInPoints((short) 12);
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style.setBorderBottom(BorderStyle.THICK);
		
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style1.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style2.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		
		//創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("講師姓名");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("出生年月日");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("身分證字號");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("保險類型");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue("加保日期");
		cell.setCellStyle(style);
		
		cell = row.createCell(6);
		cell.setCellValue("職務類型");
		cell.setCellStyle(style);
		
		cell = row.createCell(7);
		cell.setCellValue("親等關係");
		cell.setCellStyle(style);
		
		cell = row.createCell(8);
		cell.setCellValue("工時類型");
		cell.setCellStyle(style);
		
		cell = row.createCell(9);
		cell.setCellValue("計畫執行方式");
		cell.setCellStyle(style);
		
		row = sheet.createRow(1);
		row.setHeightInPoints(20);//設置行高
		
		cell = row.createCell(2);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(5);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		
		// ------申請表 start------
		apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		if(apply.getId()!=null) {
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
		}
		// ------計畫表 end--------
		
		// ------講師名單 start------
		ExperienceInheritanceSpeakerList speakerList = new ExperienceInheritanceSpeakerList();
		JSONArray speakerList_JSONArray = new JSONArray();
		if(plan.getId()!=null) {
			speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(plan.getId());
			speakerList_JSONArray=selectExperienceInheritanceSpeakerLists(speakerList);
		}
		// ------講師名單 end------
		
		String date="";
		for(int i=0;i<speakerList_JSONArray.toList().size();i++)
		{
			row = sheet.createRow(i+2);
			row.setHeightInPoints(25);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(style2);
			
			cell = row.createCell(1);
			cell.setCellValue(speakerList_JSONArray.getJSONObject(i).get("name").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(2);
			if(speakerList_JSONArray.getJSONObject(i).get("birthday").toString().length()==7){
				date=speakerList_JSONArray.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}else if(speakerList_JSONArray.getJSONObject(i).get("birthday").toString().length()==7) {
				date=speakerList_JSONArray.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			cell.setCellValue(speakerList_JSONArray.getJSONObject(i).get("identification").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			if(speakerList_JSONArray.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				cell.setCellValue("勞工保險");
			}else if(speakerList_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				cell.setCellValue("職災保險");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			if(speakerList_JSONArray.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				date=speakerList_JSONArray.getJSONObject(i).get("laborProtectionTime").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}else if(speakerList_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				date=speakerList_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			if(speakerList_JSONArray.getJSONObject(i).get("manager").equals("Y")){
				cell.setCellValue("主管");
			}else if(speakerList_JSONArray.getJSONObject(i).get("manager").equals("N")) {
				cell.setCellValue("非主管");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			if(speakerList_JSONArray.getJSONObject(i).get("relatives").equals("Y")){
				cell.setCellValue("三等親內");
			}else if(speakerList_JSONArray.getJSONObject(i).get("relatives").equals("N")) {
				cell.setCellValue("非三等親");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(8);
			if(speakerList_JSONArray.getJSONObject(i).get("workingHours").equals("A")){
				cell.setCellValue("全時");
			}else if(speakerList_JSONArray.getJSONObject(i).get("workingHours").equals("P")) {
				cell.setCellValue("部分工時");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(9);
			if(speakerList_JSONArray.getJSONObject(i).get("executionWay").equals("S")) {
				cell.setCellValue("實務技術指導");
			}else if(speakerList_JSONArray.getJSONObject(i).get("executionWay").equals("C")) {
				cell.setCellValue("教育訓練課程講授");
			}else {
				cell.setCellValue("其他");
			}
			cell.setCellStyle(style2);
			
		}
		// ------繼續僱用名單 end--------
		
		String filename = "講師名單清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

		+ new String(filename.getBytes(),"iso8859-1")+".xlsx");

		//excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

		response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}
	
	@RequestMapping(value = "/schedule")
	public String schedule(HttpServletRequest request,Model model,AdvancedAgeBase base,RetirementAdvancedAgeExperienceInheritanceApply apply){
		session=request.getSession();
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------課程規劃 start------
			RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			if(apply.getId()!=null) {
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
				double scheduleTime=0.0;
				for(int i=0;i<schedule_JSONArray.toList().size();i++) {
					scheduleTime=scheduleTime+Double.valueOf(schedule_JSONArray.getJSONObject(i).get("teachingHours").toString());
				}
				model.addAttribute("schedule", schedule_JSONArray.toList());
				model.addAttribute("scheduleSize", schedule_JSONArray.toList().size());
				model.addAttribute("scheduleTime", scheduleTime);
			}
			// ------課程規劃 end------
						
			// ------縣市列表 start----
			model.addAttribute("cityList", new JSONArray(api.httpPost(ip + "getCityList","")).toList());
			// ------縣市列表 end----
			
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5,7));
			model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		}
		return "m01/schedule";
	}
	
	@RequestMapping(value = "/exportScheduleExcel")
	public void exportScheduleExcel(Model model,HttpServletResponse response,RetirementAdvancedAgeExperienceInheritanceApply apply) throws IOException {
		//創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//創建工作表
		XSSFSheet sheet = wb.createSheet("規劃課程清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6*256);
		sheet.setColumnWidth(1, 22*256);
		sheet.setColumnWidth(2, 22*256);
		sheet.setColumnWidth(3, 20*256);
		sheet.setColumnWidth(4, 20*256);
		sheet.setColumnWidth(5, 13*256);
		sheet.setColumnWidth(6, 30*256);
		sheet.setColumnWidth(7, 13*256);
		sheet.setColumnWidth(8, 20*256);
		sheet.setColumnWidth(9, 20*256);
		sheet.setColumnWidth(10, 20*256);
		row.setHeightInPoints(30);//設置行高

		 // 字體格式
		XSSFFont font = wb.createFont();
		font.setBold(true); // 粗體字
		font.setFontName("微軟正黑體");
		font.setFontHeightInPoints((short) 12);
		
		XSSFFont font1 = wb.createFont();
		font1.setBold(true); // 粗體字
		font1.setFontName("微軟正黑體");
		font1.setFontHeightInPoints((short) 11);
		font1.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
		
		XSSFFont font2 = wb.createFont();
		font2.setFontName("微軟正黑體");
		font2.setFontHeightInPoints((short) 12);
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style.setBorderBottom(BorderStyle.THICK);
		style.setWrapText(true); 
		
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style1.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style1.setWrapText(true); 
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style2.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style2.setWrapText(true); 
		
		//創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("預計執行期間(起)");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("預計執行期間(迄)");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("計畫執行地");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("預計開課時間");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue("課程名稱");
		cell.setCellStyle(style);
		
		cell = row.createCell(6);
		cell.setCellValue("課程大綱");
		cell.setCellStyle(style);
		
		cell = row.createCell(7);
		cell.setCellValue("講師名稱");
		cell.setCellStyle(style);
		
		cell = row.createCell(8);
		cell.setCellValue("預計授課時數");
		cell.setCellStyle(style);
		
		cell = row.createCell(9);
		cell.setCellValue("預計參訓人數");
		cell.setCellStyle(style);
		
		cell = row.createCell(10);
		cell.setCellValue("預計參訓學員");
		cell.setCellStyle(style);
		
		row = sheet.createRow(1);
		row.setHeightInPoints(20);//設置行高
		
		cell = row.createCell(1);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(2);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(4);
		cell.setCellValue("00:00-00:00");
		cell.setCellStyle(style1);
		
		cell = row.createCell(8);
		cell.setCellValue("(請填寫數字)");
		cell.setCellStyle(style1);
		
		cell = row.createCell(9);
		cell.setCellValue("(請填寫數字)");
		cell.setCellStyle(style1);
		
		cell = row.createCell(10);
		cell.setCellValue("(請填寫文字)");
		cell.setCellStyle(style1);
		// ------申請表 start------
		apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		if(apply.getId()!=null) {
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
		}
		// ------計畫表 end--------
		
		// ------課程規劃 start------
		RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
		JSONArray schedule_JSONArray = new JSONArray();
		if(apply.getId()!=null) {
			schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
		}
		// ------課程規劃 end------

		// ------縣市列表 start----
		JSONArray city_JSONArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		// ------縣市列表 end----
		
		String data="",index="";
		for(int i=0;i<schedule_JSONArray.toList().size();i++)
		{
			row = sheet.createRow(i+2);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(style2);
			
			data=schedule_JSONArray.getJSONObject(i).get("executionStartTime").toString();
			data=data.substring(0, 3)+"/"+data.substring(3, 5)+"/"+data.substring(5);
			cell = row.createCell(1);
			cell.setCellValue(data);
			cell.setCellStyle(style2);
			
			data=schedule_JSONArray.getJSONObject(i).get("executionEndTime").toString();
			data=data.substring(0, 3)+"/"+data.substring(3, 5)+"/"+data.substring(5);
			cell = row.createCell(2);
			cell.setCellValue(data);
			cell.setCellStyle(style2);
			cell = row.createCell(4);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("executionTime").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			data=schedule_JSONArray.getJSONObject(i).get("executionCity").toString();
			for(int j=0;j<city_JSONArray.toList().size();j++) {
				if(city_JSONArray.getJSONObject(j).get("code").equals(data)) {
					data=city_JSONArray.getJSONObject(j).get("name").toString();
					break;
				}
			}
			cell.setCellValue(data);
			cell.setCellStyle(style2);
			
			cell = row.createCell(4);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("executionTime").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("subject").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			data="";
			index=schedule_JSONArray.getJSONObject(i).get("introduction").toString();
			while(index.indexOf("\\n")!=-1) {
				if(data.equals("")) {
					data=index.substring(0,index.indexOf("\\n"))+"\r\n";
				}else
				{
					data=data+index.substring(0,index.indexOf("\\n"));
				}
				index=index.substring(index.indexOf("\\n")+2,index.length());
				
			}
			data=data+index;
			cell.setCellValue(data);
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("speakerName").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(8);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("teachingHours").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(9);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("participateNumber").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(10);
			cell.setCellValue(schedule_JSONArray.getJSONObject(i).get("participatePeople").toString());
			cell.setCellStyle(style2);
			
		}
		// ------繼續僱用名單 end--------
		
		String filename = "規劃課程清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

		+ new String(filename.getBytes(),"iso8859-1")+".xlsx");

		//excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

		response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}
	
	@RequestMapping(value = "/participate")
	public String participate(HttpServletRequest request,Model model,AdvancedAgeBase base,RetirementAdvancedAgeExperienceInheritanceApply apply){
		session=request.getSession();
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------

			// ------課程規劃 start------
			RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			if(apply.getId()!=null) {
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
				int participateNumber=0;
				for(int i=0;i<schedule_JSONArray.toList().size();i++) {
					participateNumber=participateNumber+Integer.valueOf(schedule_JSONArray.getJSONObject(i).get("participateNumber").toString());
				}
				model.addAttribute("participateNumber", participateNumber);
			}
			// ------課程規劃 end------
			
			// ------參訓學員 start------
			RetirementAdvancedAgeParticipateStudent participateStudent = new RetirementAdvancedAgeParticipateStudent();
			if(apply.getId()!=null) {
				participateStudent.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray participate_JSONArray=selectRetirementAdvancedAgeParticipateStudents(participateStudent);
				model.addAttribute("participate", participate_JSONArray.toList());
				model.addAttribute("participateSize", participate_JSONArray.toList().size());
			}
			// ------參訓學員 end------
						
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5,7));
			model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		}
		return "m01/participate";
	}
	
	@RequestMapping(value = "/exportParticipateExcel")
	public void exportParticipateExcel(Model model,HttpServletResponse response,RetirementAdvancedAgeExperienceInheritanceApply apply) throws IOException {
		//創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//創建工作表
		XSSFSheet sheet = wb.createSheet("參訓學員清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 14*256);
		sheet.setColumnWidth(3, 14*256);
		sheet.setColumnWidth(4, 8*256);
		sheet.setColumnWidth(5, 8*256);
		sheet.setColumnWidth(6, 14*256);
		sheet.setColumnWidth(7, 14*256);
		sheet.setColumnWidth(8, 14*256);
		row.setHeightInPoints(30);//設置行高

		 // 字體格式
		XSSFFont font = wb.createFont();
		font.setBold(true); // 粗體字
		font.setFontName("微軟正黑體");
		font.setFontHeightInPoints((short) 12);
		
		XSSFFont font1 = wb.createFont();
		font1.setBold(true); // 粗體字
		font1.setFontName("微軟正黑體");
		font1.setFontHeightInPoints((short) 11);
		font1.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
		
		XSSFFont font2 = wb.createFont();
		font2.setFontName("微軟正黑體");
		font2.setFontHeightInPoints((short) 12);
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style.setBorderBottom(BorderStyle.THICK);
		style.setWrapText(true); 
		
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style1.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style1.setWrapText(true); 
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style2.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style2.setWrapText(true); 
		
		//創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("參訓學員姓名");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("保險類型");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("加保日期");
		cell.setCellStyle(style);
		
		CellRangeAddress region = new CellRangeAddress(0, 0, 4, 5);
		sheet.addMergedRegion(region);
		cell = row.createCell(4);
		cell.setCellValue("年資");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellStyle(style);
		
		cell = row.createCell(6);
		cell.setCellValue("職務類型");
		cell.setCellStyle(style);
		
		cell = row.createCell(7);
		cell.setCellValue("部門");
		cell.setCellStyle(style);
		
		cell = row.createCell(8);
		cell.setCellValue("工時類型");
		cell.setCellStyle(style);
		
		row = sheet.createRow(1);
		row.setHeightInPoints(20);//設置行高
		
		cell = row.createCell(3);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(4);
		cell.setCellValue("年");
		cell.setCellStyle(style1);
		
		cell = row.createCell(5);
		cell.setCellValue("月");
		cell.setCellStyle(style1);
		
		// ------申請表 start------
		apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		if(apply.getId()!=null) {
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
		}
		// ------計畫表 end--------
		
		// ------參訓學員 start------
		RetirementAdvancedAgeParticipateStudent participateStudent = new RetirementAdvancedAgeParticipateStudent();
		JSONArray participate_JSONArray = new JSONArray();
		if(apply.getId()!=null) {
			participateStudent.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			participate_JSONArray=selectRetirementAdvancedAgeParticipateStudents(participateStudent);
		}
		// ------參訓學員 end------
					
		String data="",index="";
		for(int i=0;i<participate_JSONArray.toList().size();i++)
		{
			row = sheet.createRow(i+2);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(style2);
			
			cell = row.createCell(1);
			cell.setCellValue(participate_JSONArray.getJSONObject(i).get("name").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(2);
			if(participate_JSONArray.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				cell.setCellValue("勞工保險");
			}else if(participate_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				cell.setCellValue("職災保險");
			}
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			if(participate_JSONArray.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				data=participate_JSONArray.getJSONObject(i).get("laborProtectionTime").toString();
				cell.setCellValue(data.substring(0, 3)+"/"+data.substring(3, 5)+"/"+data.substring(5));
			}else if(participate_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				data=participate_JSONArray.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
				cell.setCellValue(data.substring(0, 3)+"/"+data.substring(3, 5)+"/"+data.substring(5));
			}
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			cell.setCellValue(participate_JSONArray.getJSONObject(i).get("seniority").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			cell.setCellValue(participate_JSONArray.getJSONObject(i).get("seniorityMonth").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(6);
			if(participate_JSONArray.getJSONObject(i).get("manager").equals("Y")){
				cell.setCellValue("主管");
			}else if(participate_JSONArray.getJSONObject(i).get("manager").equals("N")) {
				cell.setCellValue("非主管");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			cell.setCellValue(participate_JSONArray.getJSONObject(i).get("department").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(8);
			if(participate_JSONArray.getJSONObject(i).get("workingHours").equals("A")){
				cell.setCellValue("全時");
			}else if(participate_JSONArray.getJSONObject(i).get("workingHours").equals("P")) {
				cell.setCellValue("部分工時");
			}
			cell.setCellStyle(style2);

		}
		// ------繼續僱用名單 end--------
		
		String filename = "參訓學員清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

		+ new String(filename.getBytes(),"iso8859-1")+".xlsx");

		//excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

		response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}
	
	@RequestMapping(value = "/expenditure")
	public String expenditure(HttpServletRequest request,Model model,AdvancedAgeBase base,RetirementAdvancedAgeExperienceInheritanceApply apply){
		session=request.getSession();
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------經費概算 start------
			RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			if(apply.getId()!=null) {
				expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray expenditure_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
				model.addAttribute("expenditure", expenditure_JSONArray.toList());
				model.addAttribute("expenditureSize", expenditure_JSONArray.toList().size());
			}
			// ------經費概算 end------
			
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5,7));
			model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		}
		return "m01/expenditure";
	}
	
	@RequestMapping(value = "/exportExpenditureExcel")
	public void exportExpenditureExcel(Model model,HttpServletResponse response,RetirementAdvancedAgeExperienceInheritanceApply apply) throws IOException {
		//創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//創建工作表
		XSSFSheet sheet = wb.createSheet("經費概算清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 14*256);
		sheet.setColumnWidth(3, 14*256);
		sheet.setColumnWidth(4, 12*256);
		sheet.setColumnWidth(5, 20*256);
		sheet.setColumnWidth(6, 14*256);
		row.setHeightInPoints(30);//設置行高

		 // 字體格式
		XSSFFont font = wb.createFont();
		font.setBold(true); // 粗體字
		font.setFontName("微軟正黑體");
		font.setFontHeightInPoints((short) 12);
		
		XSSFFont font1 = wb.createFont();
		font1.setBold(true); // 粗體字
		font1.setFontName("微軟正黑體");
		font1.setFontHeightInPoints((short) 11);
		font1.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
		
		XSSFFont font2 = wb.createFont();
		font2.setFontName("微軟正黑體");
		font2.setFontHeightInPoints((short) 12);
		
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style.setBorderBottom(BorderStyle.THICK);
		style.setWrapText(true); 
		
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style1.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style1.setWrapText(true); 
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment(HorizontalAlignment.CENTER); // 水平置中
		style2.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直置中
		style2.setWrapText(true); 
		
		//創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("項目");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("單價");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("數量");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("總價");
		cell.setCellStyle(style);
		
		cell = row.createCell(5);
		cell.setCellValue("申請本部補助");
		cell.setCellStyle(style);
		
		cell = row.createCell(6);
		cell.setCellValue("說明");
		cell.setCellStyle(style);
		
		row = sheet.createRow(1);
		row.setHeightInPoints(20);//設置行高
		
		
		// ------申請表 start------
		apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
		if(apply.getId()!=null) {
			plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
		}
		// ------計畫表 end--------
		
		// ------經費概算 start------
		RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
		JSONArray expenditure_JSONArray = new JSONArray();
		if(apply.getId()!=null) {
			expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			expenditure_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
		}
		// ------經費概算 end------
					
		String data="",index="";
		for(int i=0;i<expenditure_JSONArray.toList().size();i++)
		{
			row = sheet.createRow(i+2);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(style2);
			
			cell = row.createCell(1);
			cell.setCellValue(expenditure_JSONArray.getJSONObject(i).get("planName").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(2);
			cell.setCellValue(expenditure_JSONArray.getJSONObject(i).get("unitPrice").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			cell.setCellValue(expenditure_JSONArray.getJSONObject(i).get("amount").toString());
			cell.setCellStyle(style2);

			data=String.valueOf(Integer.valueOf(expenditure_JSONArray.getJSONObject(i).get("unitPrice").toString())*Integer.valueOf(expenditure_JSONArray.getJSONObject(i).get("amount").toString()));
			cell = row.createCell(4);
			cell.setCellValue(data);
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			cell.setCellValue(expenditure_JSONArray.getJSONObject(i).get("amounts").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			cell.setCellValue(expenditure_JSONArray.getJSONObject(i).get("description").toString());
			cell.setCellStyle(style2);

			cell.setCellStyle(style2);

		}
		// ------繼續僱用名單 end--------
		
		String filename = "經費概算清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

		+ new String(filename.getBytes(),"iso8859-1")+".xlsx");

		//excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

		response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}
	
	@RequestMapping(value = "/file_text")
	public String file_text(HttpServletRequest request,Model model,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		AdvancedAgeBase nbase = selectBTypeAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);
		
		//userinfo
		UserInfo userInfo = new UserInfo();
//		userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
		
		// ------申請表 start------
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		model.addAttribute("apply", searchApply);
		// ------申請表 end--------
		
		//負責人
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setSeq(base.getSeq());
		try {
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		}catch(JSONException e) {
			logger.warn(e.getMessage());
		}
		
		model.addAttribute("mailDomain", mailDomain);
		
		//信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("C");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		sdf = new SimpleDateFormat("yyyyMMdd");
		model.addAttribute("today", sdf.format(new Date()));
		return "m01/file_text";
	}
	
	@RequestMapping(value = "/m02")
	public String m02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		base.setYear(applyYear);
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setCaseStatus("3、4、8");
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectBTypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		
		return "m02/m02";
	}
	
	@RequestMapping(value = "/m02_1")
	public String m02_1(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//			userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			
			//負責人
			try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			}catch(JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------
			
			// ------縣市列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----
			
			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(),""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			
			// ------計畫表 start------
			RetirementAdvancedAgeExperienceInheritancePlan plan = new RetirementAdvancedAgeExperienceInheritancePlan();
			if(apply.getId()!=null) {
				plan.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				plan = selectRetirementAdvancedAgeExperienceInheritancePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------講師名單 start------
			ExperienceInheritanceSpeakerList speakerList = new ExperienceInheritanceSpeakerList();
			if(plan.getId()!=null) {
				speakerList.setRetirementAdvancedAgeExperienceInheritancePlanId(plan.getId());
				JSONArray speakerList_JSONArray=selectExperienceInheritanceSpeakerLists(speakerList);
				model.addAttribute("speakerListSize", speakerList_JSONArray.toList().size());
			}
			// ------講師名單 end------
			
			// ------課程規劃 start------
			RetirementAdvancedAgeExperienceInheritanceSchedule schedule = new RetirementAdvancedAgeExperienceInheritanceSchedule();
			if(apply.getId()!=null) {
				schedule.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray schedule_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceSchedules(schedule);
				double scheduleTime=0.0;
				int participateNumber=0;
				for(int i=0;i<schedule_JSONArray.toList().size();i++) {
					scheduleTime=scheduleTime+Double.valueOf(schedule_JSONArray.getJSONObject(i).get("teachingHours").toString());
					participateNumber=participateNumber+Integer.valueOf(schedule_JSONArray.getJSONObject(i).get("participateNumber").toString());
				}
				model.addAttribute("scheduleSize", schedule_JSONArray.toList().size());
				model.addAttribute("scheduleTime", scheduleTime);
				model.addAttribute("participateNumber", participateNumber);
			}
			// ------課程規劃 end------
						
			// ------參訓學員 start------
			RetirementAdvancedAgeParticipateStudent participateStudent = new RetirementAdvancedAgeParticipateStudent();
			if(apply.getId()!=null) {
				participateStudent.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				model.addAttribute("participateStudentSize", selectRetirementAdvancedAgeParticipateStudents(participateStudent).toList().size());
			}
			// ------參訓學員 end------
			
			// ------經費概算 start------
			RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure = new RetirementAdvancedAgeExperienceInheritanceExpenditure();
			if(apply.getId()!=null) {
				expenditure.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
				JSONArray expenditure_JSONArray=selectRetirementAdvancedAgeExperienceInheritanceExpenditures(expenditure);
				double totalPrice=0.0,totalAmounts=0.0;
				for(int i=0;i<expenditure_JSONArray.toList().size();i++) {
					totalPrice=totalPrice+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("unitPrice").toString())*Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amount").toString());
					totalAmounts=totalAmounts+Double.valueOf(expenditure_JSONArray.getJSONObject(i).get("amounts").toString());
				}
				model.addAttribute("totalPrice", totalPrice);
				model.addAttribute("totalAmounts", totalAmounts);
				model.addAttribute("expenditureSize", expenditure_JSONArray.toList().size());
			}
			// ------經費概算 end------
			
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate=sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("B");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		return "m02/m02_1";
	}
	
	@RequestMapping(value = "/n01")
	public String n01(HttpServletRequest request,Model model,Pagination pagination,AdvancedAgeBase base){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		base.setYear(applyYear);
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setCaseStatus("5、6、7");
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectBTypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
		//分頁
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "n01/n01";
	}
	
	@RequestMapping(value = "/n01_1")
	public String n01_1(HttpServletRequest request,Model model,Pagination pagination,AdvancedAgeBase base,RetirementAdvancedAgeExperienceInheritanceApply apply){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectBTypeAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			
			// ------申請表 start------
			apply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			
			//負責人
			try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			}catch(JSONException e) {
				logger.warn(e.getMessage());
			}
			
			// ------成果報告 start------
			RetirementAdvancedAgeExperienceInheritanceResult result = new RetirementAdvancedAgeExperienceInheritanceResult();
			result.setRetirementAdvancedAgeExperienceInheritanceApplyId(apply.getId());
			result.setSeq(apply.getSeq());
			model.addAttribute("result", selectRetirementAdvancedAgeExperienceInheritanceResult(result));
			// ------成果報告 end------
			
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate=sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4))-1911+todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("B");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		return "n01/n01_1";
	}
	
	@RequestMapping(value = "/n01File")
	public String n01File(HttpServletRequest request,Model model,RetirementAdvancedAgeExperienceInheritanceApply apply){ 
		session=request.getSession();
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		AdvancedAgeBase nbase = selectBTypeAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);
		
		//userinfo
		UserInfo userInfo = new UserInfo();
//		userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
		
		// ------申請表 start------
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = selectRetirementAdvancedAgeExperienceInheritanceApply(apply);
		model.addAttribute("apply", searchApply);
		// ------申請表 end--------
		
		//負責人
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setSeq(base.getSeq());
		try {
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		}catch(JSONException e) {
			logger.warn(e.getMessage());
		}
		
		//文件
		attachment = new Attachment();
		// 本計畫核准函影本
		attachment.setFileBelong("BA");
		attachment.setFileBelongId(nbase.getId());
		attachment.setFileType("approved");
		model.addAttribute("approvedAttachment", selectFiles(attachment).toList());
		
		//請款之領據正本
		attachment.setFileType("receipt");
		model.addAttribute("receiptAttachment", selectFiles(attachment).toList());
		
		//成果報告內容附件
		attachment.setFileType("result");
		model.addAttribute("resultAttachment", selectFiles(attachment).toList());
		
		//經費支用單據明細
		attachment.setFileType("expenditure");
		model.addAttribute("expenditureAttachment", selectFiles(attachment).toList());
		
		// 講師鐘點費印領清冊
		attachment.setFileType("speakerFee");
		model.addAttribute("speakerFeeAttachment", selectFiles(attachment).toList());
		
		// 其他文件
		attachment.setFileType("necessary");
		model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());
				
		model.addAttribute("mailDomain", mailDomain);
		
		//信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("B");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		sdf = new SimpleDateFormat("yyyyMMdd");
		model.addAttribute("today", sdf.format(new Date()));
		return "n01/file";
	}
	
	@RequestMapping(value = "/o01")
	public String o01(HttpServletRequest request,Model model,BlackList blackList,Pagination pagination){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("blackList", blackList);
		model.addAttribute("unitList", getUnit().toList());
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				blackList.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectBlackList(blackList);
		JSONArray pageArray = new JSONArray();
		
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("blackListData", pageArray.toList());
		return "o01/o01";
	}
	
	@RequestMapping(value = "/o01_1")
	public String o01_1(HttpServletRequest request,Model model,BlackList blackList,String searchSeq,String searchUnit,
			String searchBanStartDate,String searchBanEndDate){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		//userinfo
		UserInfo userInfo = new UserInfo();
//		userInfo.setUnit(selectBlackListData(blackList).get("unit").toString());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
				
		model.addAttribute("searchSeq", searchSeq);
		model.addAttribute("searchUnit", searchUnit);
		model.addAttribute("searchBanStartDate", searchBanStartDate);
		model.addAttribute("searchBanEndDate", searchBanEndDate);
		model.addAttribute("blackList", blackList);
		model.addAttribute("unitList", getUnit().toList());
		model.addAttribute("blackListData", selectBlackListData(blackList));
		//文件
		attachment = new Attachment();
		// 公文
		attachment.setFileBelong("BL");
		attachment.setFileBelongId(blackList.getId());
		attachment.setFileType("blackList");
		model.addAttribute("blackListAttachment", selectFiles(attachment).toList());
		return "o01/o01_1";
	}
	
	@RequestMapping(value = "/o01_02")
	public String o01_02(HttpServletRequest request,Model model,AdvancedAgeBase base){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		if(base.getSeq()!=null && !base.getSeq().equals(""))
		{
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectBTypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "o01/o01_02";
	}
	
	@RequestMapping(value = "/o02")
	public String o02(HttpServletRequest request,Model model,SiteInspection siteInspection,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("siteInspection", siteInspection);
		model.addAttribute("unitList", getUnit().toList());
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				siteInspection.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		siteInspection.setCaseType("B");
		jsonArray = selectSiteInspection(siteInspection);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("siteInspectionData", pageArray.toList());
		return "o02/o02";
	}
	
	@RequestMapping(value = "/o02_1")
	public String o02_1(HttpServletRequest request,Model model,SiteInspection siteInspection,String searchSeq,String searchUnit,String searchResult){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		
		model.addAttribute("searchSeq", searchSeq);
		model.addAttribute("searchResult", searchResult);
		model.addAttribute("searchUnit", searchUnit);
		model.addAttribute("siteInspection", siteInspection);
		model.addAttribute("unitList", getUnit().toList());
		model.addAttribute("siteInspectionData", selectSiteInspectionData(siteInspection));
		//文件
		attachment = new Attachment();
		// 公文
		attachment.setFileBelong("SI");
		attachment.setFileBelongId(siteInspection.getId());
		attachment.setFileType("siteInspection");
		model.addAttribute("siteInspectionAttachment", selectFiles(attachment).toList());
		
		// 其他文件
		attachment.setFileType("siteInspectionOther");
		model.addAttribute("siteInspectionOtherAttachment", selectFiles(attachment).toList());
		return "o02/o02_1";
	}
	
	@RequestMapping(value = "/o02_02")
	public String o02_02(HttpServletRequest request,Model model,AdvancedAgeBase base){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		if(base.getSeq()!=null && !base.getSeq().equals(""))
		{
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectBTypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "o02/o02_02";
	}
	
	@RequestMapping(value = "/q01")
	public String q01(HttpServletRequest request,String account){ 
		return "q01/q01";
	}
	
	@RequestMapping(value = "/q02")
	public String q02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("B");
		
		if(pagination.getNumbersOfPage()==null)
		{
			base.setYear(applyYear);
			pagination = new Pagination("1","10");
		}
		jsonArray = selectCaseStatistics2(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("base", base);
		model.addAttribute("caseStatisticsList", pageArray.toList());
		return "q02/q02";
	}
	
	@RequestMapping(value = "/q03")
	public String q03(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("B");
		if(pagination.getNumbersOfPage()==null)
		{
			base.setUnit("A");
			pagination = new Pagination("1","10");
		}
		jsonArray = selectApplicationSituation(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("base", base);
		model.addAttribute("applicationSituationList", pageArray.toList());
		return "q03/q03";
	}
	
	@RequestMapping(value = "/q04")
	public String q04(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		base.setCaseType("B");
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		jsonArray = selectIndustryAmountsStatistics(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("base", base);
		model.addAttribute("industryAmountsStatisticsList", pageArray.toList());
		return "q04/q04";
	}
	
	@RequestMapping(value = "/q05")
	public String q05(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("B");
		if(pagination.getNumbersOfPage()==null)
		{
			base.setYear(applyYear);
			pagination = new Pagination("1","10");
		}
		jsonArray = selectYearAmountsStatistics(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("base", base);
		model.addAttribute("yearAmountsStatisticsList", pageArray.toList());
		return "q05/q05";
	}
	
	@RequestMapping(value = "/r01")
	public String r01(HttpServletRequest request,Model model,UserInfo userInfo){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		userInfo.setAccount(session.getAttribute(session.getId()+"account").toString());
		model.addAttribute("userInfoData", selectUserInfoData(userInfo));
		model.addAttribute("unitList", getUnit().toList());
		return "r01/r01";
	}
	
	@RequestMapping(value = "/r02")
	public String r02(HttpServletRequest request,Model model,UserInfo userInfo,String userAccount,Pagination pagination){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		
		userInfo.setAccount(userAccount);
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectUserInfo(userInfo);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("userInfoData", pageArray.toList());
		
		model.addAttribute("searchUserInfo", userInfo);
		
		model.addAttribute("unitList", getUnit().toList());
		return "r02/r02";
	}
	
	@RequestMapping(value = "/r02_1")
	public String r02_1(HttpServletRequest request,Model model,UserInfo userInfo,String editAccount){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		ObjectMapper objectMapper = new ObjectMapper();
		if(userInfo.getUnit() == null) {
			userInfo.setAccount(editAccount);
			JSONObject jsondata = selectUserInfoData(userInfo);
			
			
			try {
				userInfo = objectMapper.readValue(jsondata.toString(), UserInfo.class);
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			userInfo.setPassword(AesUtil.decrypt(userInfo.getPassword().replaceAll(" ","+").getBytes()));
			
			model.addAttribute("unitList", getUnit().toList());
			model.addAttribute("userInfoData",userInfo);
			return "r02/r02_1";
		}
		else{
			
			String json="";
			userInfo.setAccount(editAccount);
			if(!userInfo.getPassword().equals("")) {
				userInfo.setPassword(AesUtil.encrypt(userInfo.getPassword()));
			}else {
				userInfo.setPassword(null);
			}
			try {
				json = objectMapper.writeValueAsString(userInfo);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			
			api.httpPost(ip+"editUserInfoData",json);
			return "r02/r02";
		}
	}
	
	@RequestMapping(value = "/r02_02")
	public String r02_02(HttpServletRequest request,Model model,UserInfo userInfo,String userAccount){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("unitList", getUnit().toList());
		if(userInfo.getUnit() != null) {
			userInfo.setAccount(userAccount);
			userInfo.setPassword(AesUtil.encrypt(userInfo.getPassword()));
			ObjectMapper objectMapper = new ObjectMapper();
			String json="";
			try {
				json = objectMapper.writeValueAsString(userInfo);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip+"addUserInfo",json);
			return "r02/r02";
		}
		else {
			return "r02/r02_02";
		}
	}
	
	@RequestMapping(value = "/r03")
	public String r03(HttpServletRequest request,Model model,UserInfo userInfo){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		FunctionList functionList = new FunctionList();
		functionList.setCaseType("B");
		model.addAttribute("functionList", selectFunctionList(functionList).toList());
		return "r03/r03";
	}
	
	@RequestMapping(value = "/r04")
	public String r04(HttpServletRequest request,Model model,UserLoginRecord userLoginRecord,String loginStartDate,String loginEndDate,Pagination pagination){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectUserLoginRecord(userLoginRecord,loginStartDate,loginEndDate);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("userLoginRecordDate", pageArray.toList());
		
		model.addAttribute("userLoginRecord", userLoginRecord);
		model.addAttribute("loginStartDate", loginStartDate);
		model.addAttribute("loginEndDate", loginEndDate);
		model.addAttribute("unitList", getUnit().toList());
		return "r04/r04";
	}
	
	public JSONArray selectBTypeAdvancedAgeBase(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectBTypeAdvancedAgeBase",json));
		return array;
	}
	
	public JSONArray selectBTypeAdvancedAgeBaseFileStatus(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectBTypeAdvancedAgeBaseFileStatus",json));
		return array;
	}
	
	public AdvancedAgeBase selectBTypeAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectBTypeAdvancedAgeBaseFileStatusRecord",json);
		JSONArray array = new JSONArray(jsondata);
		try {
			if (!jsondata.equals(""))
				advancedAgeBase = objectMapper.readValue(array.getJSONObject(0).toString(), AdvancedAgeBase.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return advancedAgeBase;
	}
	
	public AdvancedAgeBase selectBTypeAdvancedAgeBaseData(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectBTypeAdvancedAgeBaseData", json);
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

	public RetirementAdvancedAgeExperienceInheritancePlan selectRetirementAdvancedAgeExperienceInheritancePlan(RetirementAdvancedAgeExperienceInheritancePlan plan) {
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
	
	public JSONArray selectUserInfo(UserInfo userInfo){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectUserInfo",json));
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
	
	public JSONArray selectMailRecord(MailRecord mailRecord){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(mailRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectMailRecord",json));
		return array;
	}
	
	public JSONArray selectBlackList(BlackList blackList){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectBlackList",json));
		return array;
	}
	
	public JSONObject selectBlackListData(BlackList blackList){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"selectBlackListData",json));
		return object;
	}

	public JSONArray selectSiteInspection(SiteInspection siteInspection){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectSiteInspection",json));
		return array;
	}

	public JSONObject selectSiteInspectionData(SiteInspection siteInspection){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"selectSiteInspectionData",json));
		return object;
	}
	
	public JSONObject selectUserInfoData(UserInfo userInfo){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"selectUserInfoData",json));
		return object;
	}

	public JSONArray selectFunctionList(FunctionList functionList){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectFunctionList",json));
		return array;
	}

	public JSONArray selectUserLoginRecord(UserLoginRecord userLoginRecord,String loginStartDate,String loginEndDate){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			
			json = objectMapper.writeValueAsString(userLoginRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		json = json.substring(0,json.length()-1)+",\"loginStartDate\":"+(loginStartDate == null || loginStartDate.equals("")?"":"\""+loginStartDate+"\"")+",\"loginEndDate\":"+(loginEndDate==null || loginEndDate.equals("")?"":"\""+loginEndDate+"\"")+"}";
		JSONArray array = new JSONArray(api.httpPost(ip+"selectUserLoginRecord",json));
		return array;
	}
	
	public JSONArray selectCaseStatistics2(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCaseStatistics2", json));
		return array;
	}
	
	public JSONArray selectApplicationSituation(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectApplicationSituation", json));
		return array;
	}
	
	public JSONArray selectIndustryAmountsStatistics(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectIndustryAmountsStatistics", json));
		return array;
	}
	
	public JSONArray selectYearAmountsStatistics(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectYearAmountsStatistics", json));
		return array;
	}
	
	public void setModel(String sid,Model model) {
		model.addAttribute("id", session.getAttribute(sid+"id"));
		model.addAttribute("account", session.getAttribute(sid+"account"));
		model.addAttribute("name", session.getAttribute(sid+"name"));
		model.addAttribute("unitName", session.getAttribute(sid+"unitName"));
		model.addAttribute("unit", session.getAttribute(sid+"unit"));
		model.addAttribute("jurisdiction", session.getAttribute(sid+"jurisdiction"));
		model.addAttribute("functionPermission", session.getAttribute(sid+"functionPermission"));
		model.addAttribute("functionPermission2", session.getAttribute(sid+"functionPermission2"));
		model.addAttribute("functionPermission3", session.getAttribute(sid+"functionPermission3"));
	}
	
	public JSONArray getUnit() {
		return new JSONArray(api.httpPost(ip + "getUnit", ""));
	}
}