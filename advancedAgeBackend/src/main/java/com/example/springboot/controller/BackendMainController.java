package com.example.springboot.controller;

import java.io.BufferedOutputStream;
import java.io.File;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class BackendMainController { 

	Logger logger = LogManager.getLogger(BackendMainController.class);
	
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
	
	AdvancedAgeBase advancedAgeBase;
	
	AdvancedAgeApply advancedAgeApply;
	
	Attachment attachment;
	
	JSONArray jsonArray;
	
	Unit unit;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,UserInfo userInfo){ 
		session = request.getSession();
		if(userInfo.getAccount()!=null) {
			userInfo.setPassword(AesUtil.encrypt(userInfo.getPassword()).toString());
			UserInfo loginUser=selectUserInfoLogin(userInfo);
			
			if(loginUser.getAccount()!=null)
			{
				if(loginUser.getStatus()==1)
				{
					FunctionPermission functionPermission= new FunctionPermission();
					functionPermission.setJurisdiction(loginUser.getJurisdiction());
					session.removeAttribute("message");
					session.setAttribute(session.getId()+"id",loginUser.getId());
					session.setAttribute(session.getId()+"account",loginUser.getAccount());
					session.setAttribute(session.getId()+"name",loginUser.getName());
					session.setAttribute(session.getId()+"unitName",getUnitName(loginUser.getUnit()));
					session.setAttribute(session.getId()+"unit",loginUser.getUnit());
					session.setAttribute(session.getId()+"jurisdiction",loginUser.getJurisdiction());
					session.setAttribute(session.getId()+"functionPermission",selectFunctionPermission(functionPermission,1));
					session.setAttribute(session.getId()+"functionPermission2",selectFunctionPermission(functionPermission,2));
					session.setAttribute(session.getId()+"functionPermission3",selectFunctionPermission(functionPermission,3));
					UserLoginRecord loginRecord = new UserLoginRecord();
					loginRecord.setLoginId(loginUser.getId());
					loginRecord.setAccount(loginUser.getAccount());
					loginRecord.setJurisdiction(loginUser.getJurisdiction());
					loginRecord.setUnit(loginUser.getUnit());
					loginRecord.setUsername(loginUser.getName());
					addUserLoginRecord(loginRecord);
					return "redirect:/a01";
				}
				else
				{
					session.setAttribute("message","帳號已停用");
				}
			}
			else
			{
				session.setAttribute("message","帳號 或 密碼錯誤");
			}
			
		}
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request){ 
		session= request.getSession();
		session.removeAttribute(session.getId()+"message");
		session.removeAttribute(session.getId()+"id");
		session.removeAttribute(session.getId()+"account");
		session.removeAttribute(session.getId()+"unitName");
		session.removeAttribute(session.getId()+"unit");
		session.removeAttribute(session.getId()+"jurisdiction");
		session.removeAttribute(session.getId()+"functionPermission");
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/")
	public String root(HttpServletRequest request,String account){ 
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(account+"account") == null) {
			return "redirect:/login";
		}
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,String account){ 
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(account+"account") == null) {
			return "redirect:/login";
		}
		return "index";
	}
	
	@RequestMapping(value = "/saveRar", method = RequestMethod.POST)
	public void saveRar(HttpServletResponse response,Attachment attachment,String date){ 
		try {
			zip.ZipDirs(filePath+"/A/"+attachment.getFileBelongId(), date+".rar", true, f -> true,filePath+"/A/"+attachment.getFileBelongId()+"/register/"+attachment.getFileFrequency(),filePath+"/A/"+attachment.getFileBelongId()+"/salary/"+attachment.getFileFrequency(),filePath+"/A/"+attachment.getFileBelongId()+"/insure/"+attachment.getFileFrequency(),filePath+"/A/"+attachment.getFileBelongId()+"/attendance/"+attachment.getFileFrequency(),filePath+"/A/"+attachment.getFileBelongId()+"/necessary/"+attachment.getFileFrequency());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("success;"+"downloadRar?path=/A/"+attachment.getFileBelongId()+"/"+date+".rar");
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
	
	@RequestMapping(value = "/saveReceiptRar", method = RequestMethod.POST)
	public void saveReceiptRar(HttpServletResponse response,Attachment attachment){
		try {
			zip.ZipDirs(filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId(), "receiptFiles.rar", true, f -> true,filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"approved"+File.separator+attachment.getFileFrequency(),filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"receipt"+File.separator+attachment.getFileFrequency(),filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"employment"+File.separator+attachment.getFileFrequency(),filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"salary"+File.separator+attachment.getFileFrequency(),filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"attendance"+File.separator+attachment.getFileFrequency(),filePath+File.separator+"BA"+File.separator+attachment.getFileBelongId()+File.separator+"necessary"+File.separator+attachment.getFileFrequency());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("success;"+"downloadRar?path=/BA/"+attachment.getFileBelongId()+"/receiptFiles.rar");
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
	
	@RequestMapping(value = "/downloadRar")
	public void downloadRar(String path,HttpServletResponse response) {
		path=filePath+path;
//    下載的檔名是啥
      String fileName = path.substring(path.lastIndexOf("/") + 1);
      FileInputStream in = null;
      ServletOutputStream out = null;
      try{
//    設定瀏覽器能夠支援下載的東西，中文檔名需要指定編碼方式，否則可能會亂碼
      response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));//分號改成冒號會展示圖片而不會下載
//    獲取下載檔案的輸入流
      in=new FileInputStream(path);
//    建立緩衝區
      int len=0;
      byte[] buffer=new byte[1024];
//    獲取outputStream物件
      out= response.getOutputStream();
//    將FileOutputStream流寫入buffer,使用outputStream將緩衝區資料輸出到客戶端
      while((len=in.read(buffer))>0)
      {
          out.write(buffer,0,len);
      }
      }catch(IOException e) {
    	  logger.warn(e.getMessage());
      }finally {
    	  try {
    		  if(in != null) {
    			  in.close();
    		  }
    		  if(out != null) {
    			  out.close();
    		  }
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
          
      }
	 }

	@RequestMapping(value = "/saveRarAll", method = RequestMethod.POST)
	public void saveRarAll(HttpServletResponse response,Attachment attachment,String date){ 
		try {
			zip.ZipDirs(filePath+"/A/"+attachment.getFileBelongId(), "allFile.rar", true, f -> true,filePath+"/A/"+attachment.getFileBelongId()+"/register",filePath+"/A/"+attachment.getFileBelongId()+"/salary",filePath+"/A/"+attachment.getFileBelongId()+"/insure",filePath+"/A/"+attachment.getFileBelongId()+"/attendance",filePath+"/A/"+attachment.getFileBelongId()+"/necessary");
			
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/a01")
	public String a01(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,UserInfo userInfo){ 
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
		jsonArray = selectATypeAdvancedAgeBaseFileStatus(base);
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
		return "a01/a01";
	}
	
	@RequestMapping(value = "/file")
	public String file(HttpServletRequest request,Model model,AdvancedAgeApply apply){ 
		session=request.getSession();
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		AdvancedAgeBase nbase = selectATypeAdvancedAgeBaseFileStatusRecord(base);
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
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
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
		attachment.setFileBelong("A");
		attachment.setFileBelongId(searchApply.getId());
		attachment.setFileType("register");
		model.addAttribute("registerAttachment", selectFiles(attachment).toList());

		// 投保勞保或職災保險證明文件
		attachment.setFileType("insure");
		model.addAttribute("insureAttachment", selectFiles(attachment).toList());

		// 薪資證明文件
		attachment.setFileType("salary");
		model.addAttribute("salaryAttachment", selectFiles(attachment).toList());
		
		// 出勤證明文件
		attachment.setFileType("attendance");
		model.addAttribute("attendanceAttachment", selectFiles(attachment).toList());
		
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
		return "a01/file";
	}
	
	@RequestMapping(value = "/a02")
	public String a02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination,UserInfo userInfo){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
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
		jsonArray = selectATypeAdvancedAgeBaseFileStatus(base);
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
		return "a02/a02";
	}
	
	@RequestMapping(value = "/testMail", method = RequestMethod.GET)
	public void testMail(HttpServletRequest request, HttpServletResponse response) {
		try {
			sendEmail.sendMail("a2377678@gmail.com","backend 測試通知", "backend test");
		} catch (AddressException e1) {
			logger.warn(e1.getMessage());
		} catch (MessagingException e1) {
			logger.warn(e1.getMessage());
		} catch (Exception e1) {
			logger.warn(e1.getMessage());
		}
	}
	
	@RequestMapping(value = "/account01")
	public String account01(HttpServletRequest request,Model model,CompanyInfo info,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("companyInfo", info);
		info.setAccountStatus("1");
		//所有資料
		jsonArray = selectCompanyInfo(info);
		JSONArray pageArray = new JSONArray();
		//分頁
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
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
		model.addAttribute("infoList", pageArray.toList());
		
		return "account/account01";
	}
	
	@RequestMapping(value = "/account01_1")
	public String account01_1(HttpServletRequest request,Model model,CompanyInfo info,Pagination pagination,String searchSeq,String searchCompanyName){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("searchSeq", searchSeq);
		model.addAttribute("searchCompanyName", searchCompanyName);
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
				
		//------ 縣市列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList",""));
		list = jsonArray.toList();
		model.addAttribute("cityList", list);
		//------ 縣市列表 end----
		
		//------ 公司資訊 start----
		JSONObject companyInfo = selectCompanyInfoData(info);
		model.addAttribute("companyInfoData",companyInfo );
		model.addAttribute("searchInfo",info );
		
		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + companyInfo.getString("registerCity"),""));
		list = jsonArray.toList();
		model.addAttribute("registerAreaList", list);
		
		jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + companyInfo.getString("registerCity"),""));
		list = jsonArray.toList();
		model.addAttribute("contactAreaList", list);
		//------ 公司資訊 end-----
		
		attachment = new Attachment();
		//------ 設立登記證明文件 start----
		attachment.setFileBelong("E");
		attachment.setFileBelongId(Integer.valueOf(info.getId()));
		attachment.setFileType("register");
		model.addAttribute("registerAttachment", selectFiles(attachment).toList());
		//------ 設立登記證明文件 end----
		
		//------ 設立登記證明文件 start----
		attachment.setFileBelong("E");
		attachment.setFileBelongId(Integer.valueOf(info.getId()));
		attachment.setFileType("authorize");
		model.addAttribute("authorizeAttachment", selectFiles(attachment).toList());
		//------ 設立登記證明文件 end----
				
		return "account/account01_1";
	}
	
	@RequestMapping(value = "/account02")
	public String account02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		//所有資料
		CompanyInfo info = new CompanyInfo();
		info.setAccountStatus("3");
		jsonArray = selectCompanyInfo(info);
		JSONArray pageArray = new JSONArray();
		//分頁
		if(pagination.getNumbersOfPage()==null)
		{
			pagination = new Pagination("1","10");
		}
		pagination.setNums(jsonArray.length());
//					List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i=0;i<pagination.getNumbersOfPage();i++) {
			int index=pagination.getNumbersOfPage()*(pagination.getPage()-1)+i;
			if(index<jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		
		//分頁資料
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("infoList", pageArray.toList());
		return "account/account02";
	}
	
	@RequestMapping(value = "/account02_1")
	public String account02_1(HttpServletRequest request,Model model,CompanyInfo info,Pagination pagination){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		//------ 公司資訊 start----
		JSONObject companyInfo = selectCompanyInfoData(info);
		model.addAttribute("companyInfoData",companyInfo );
		//------ 公司資訊 end-----
		
		attachment = new Attachment();
		//------ 設立登記證明文件 start----
		attachment.setFileBelong("FG");
		attachment.setFileBelongId(Integer.valueOf(info.getId()));
		attachment.setFileType("register");
		model.addAttribute("registerAttachment", selectFiles(attachment).toList());
		//------ 設立登記證明文件 end----
		
		return "account/account02_1";
	}
	
	@RequestMapping(value = "/b01")
	public String b01(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
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
		model.addAttribute("totalBaseList", selectATypeAdvancedAgeBase(totalBase).toList());
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
		jsonArray = selectATypeAdvancedAgeBase(base);
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
		return "b01/b01";
	}
	
	@RequestMapping(value = "/b01_division")
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
		model.addAttribute("totalBaseList", selectATypeAdvancedAgeBase(totalBase).toList());
		model.addAttribute("year", applyYear);
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//查詢資料
		jsonArray = selectATypeAdvancedAgeBase(base);
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
		return "b01/b01_division";
	}
	
	@RequestMapping(value = "/b02")
	public String b02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
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
		jsonArray = selectATypeAdvancedAgeBase(base);
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
		return "b02/b02";
	}
	
	@RequestMapping(value = "/b02_1")
	public String b02_1(HttpServletRequest request,Model model,AdvancedAgeBase base,AdvancedAgeApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("base", base);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
			apply = selectAdvancedAgeApply(apply);
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
			AdvancedAgePlan plan = new AdvancedAgePlan();
			if(apply.getId()!=null) {
				plan.setAdvancedAgeApplyId(apply.getId());
				plan = selectAdvancedAgePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------繼續僱用名單 start------
			AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
			if(plan.getId()!=null) {
				employmenyList.setAdvancedAgePlanId(plan.getId());
				model.addAttribute("employmenyListSize", selectAdvancedAgeEmploymentLists(employmenyList).toList().size());
			}
			// ------繼續僱用名單 end--------
			
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
			siteInspection.setCaseType("A");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		return "b02/b02_1";
	}
	
	@RequestMapping(value = "/b02_1_print")
	public String b02_1_print(HttpServletRequest request,Model model,AdvancedAgeBase base,AdvancedAgeApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
			apply = selectAdvancedAgeApply(apply);
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
			AdvancedAgePlan plan = new AdvancedAgePlan();
			if(apply.getId()!=null) {
				plan.setAdvancedAgeApplyId(apply.getId());
				plan = selectAdvancedAgePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------繼續僱用名單 start------
			AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
			if(plan.getId()!=null) {
				employmenyList.setAdvancedAgePlanId(plan.getId());
				model.addAttribute("employmenyListSize", selectAdvancedAgeEmploymentLists(employmenyList).toList().size());
			}
			// ------繼續僱用名單 end--------
			
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
			siteInspection.setCaseType("A");
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
		
		return "b02/b02_1_print";
	}

	@RequestMapping(value = "/employmentList")
	public String employmentList(HttpServletRequest request,Model model,AdvancedAgeBase base,AdvancedAgeApply apply){
		session=request.getSession();
		setModel(session.getId(),model);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------
			
			// ------申請表 start------
			apply = selectAdvancedAgeApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			
			// ------計畫表 start------
			AdvancedAgePlan plan = new AdvancedAgePlan();
			if(apply.getId()!=null) {
				plan.setAdvancedAgeApplyId(apply.getId());
				plan = selectAdvancedAgePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			
			// ------繼續僱用名單 start------
			AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
			if(plan.getId()!=null) {
				employmenyList.setAdvancedAgePlanId(plan.getId());
				model.addAttribute("employmenyList", selectAdvancedAgeEmploymentLists(employmenyList).toList());
				model.addAttribute("employmenyListSize", selectAdvancedAgeEmploymentLists(employmenyList).toList().size());
			}
			// ------繼續僱用名單 end--------
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5,7));
			model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		}
		return "b02/employmentList";
	}
	
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(Model model,HttpServletResponse response,AdvancedAgeApply apply) throws IOException {
		//創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		//創建工作表
		XSSFSheet sheet = wb.createSheet("補助名單清冊");
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
		sheet.setColumnWidth(9, 17*256);
		sheet.setColumnWidth(10, 17*256);
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
		cell.setCellValue("編號");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("勞工姓名");
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
		cell.setCellValue("經常性薪資");
		cell.setCellStyle(style);
		
		cell = row.createCell(10);
		cell.setCellValue("非經常性薪資");
		cell.setCellStyle(style);
		
		row = sheet.createRow(1);
		row.setHeightInPoints(20);//設置行高
		
		cell = row.createCell(2);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(5);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);
		
		cell = row.createCell(9);
		cell.setCellValue("前3個月總和");
		cell.setCellStyle(style1);
		
		cell = row.createCell(10);
		cell.setCellValue("前3個月總和");
		cell.setCellStyle(style1);
		
		// ------申請表 start------
		apply = selectAdvancedAgeApply(apply);
		model.addAttribute("apply", apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		AdvancedAgePlan plan = new AdvancedAgePlan();
		if(apply.getId()!=null) {
			plan.setAdvancedAgeApplyId(apply.getId());
			plan = selectAdvancedAgePlan(plan);
			model.addAttribute("plan", plan);
		}
		// ------計畫表 end--------
		
		// ------繼續僱用名單 start------
		AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
		JSONArray employmanetList = new JSONArray();
		if(plan.getId()!=null) {
			employmenyList.setAdvancedAgePlanId(plan.getId());
			employmanetList=selectAdvancedAgeEmploymentLists(employmenyList);
		}
		String date="";
		for(int i=0;i<employmanetList.toList().size();i++)
		{
			row = sheet.createRow(i+2);
			row.setHeightInPoints(25);
			cell = row.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(style2);
			
			cell = row.createCell(1);
			cell.setCellValue(employmanetList.getJSONObject(i).get("name").toString());
			cell.setCellStyle(style2);
			
			cell = row.createCell(2);
			if(employmanetList.getJSONObject(i).get("birthday").toString().length()==7){
				date=employmanetList.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}else if(employmanetList.getJSONObject(i).get("birthday").toString().length()==7) {
				date=employmanetList.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}
			cell.setCellStyle(style2);
			
			cell = row.createCell(3);
			cell.setCellValue(employmanetList.getJSONObject(i).get("identification").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			if(employmanetList.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				cell.setCellValue("勞工保險");
			}else if(employmanetList.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				cell.setCellValue("職災保險");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			if(employmanetList.getJSONObject(i).get("laborProtectionTime").toString().length()==7){
				date=employmanetList.getJSONObject(i).get("laborProtectionTime").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}else if(employmanetList.getJSONObject(i).get("occupationalAccidentProtectionTime").toString().length()==7) {
				date=employmanetList.getJSONObject(i).get("occupationalAccidentProtectionTime").toString();
				cell.setCellValue(date.substring(0, 3)+"/"+date.substring(3, 5)+"/"+date.substring(5));
			}
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			if(employmanetList.getJSONObject(i).get("manager").equals("Y")){
				cell.setCellValue("主管");
			}else if(employmanetList.getJSONObject(i).get("manager").equals("N")) {
				cell.setCellValue("非主管");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			if(employmanetList.getJSONObject(i).get("relatives").equals("Y")){
				cell.setCellValue("三等親內");
			}else if(employmanetList.getJSONObject(i).get("relatives").equals("N")) {
				cell.setCellValue("非三等親");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(8);
			if(employmanetList.getJSONObject(i).get("workingHours").equals("A")){
				cell.setCellValue("全時");
			}else if(employmanetList.getJSONObject(i).get("workingHours").equals("P")) {
				cell.setCellValue("部分工時");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(9);
			cell.setCellValue(employmanetList.getJSONObject(i).get("recurringSalary").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(10);
			cell.setCellValue(employmanetList.getJSONObject(i).get("notRecurringSalary").toString());
			cell.setCellStyle(style2);
			
		}
		// ------繼續僱用名單 end--------
		
		String filename = "補助名單清冊";

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
	
	@RequestMapping(value = "/b02_file_text")
	public String b02_file_text(HttpServletRequest request,Model model,AdvancedAgeApply apply){ 
		session=request.getSession();
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		AdvancedAgeBase nbase = selectATypeAdvancedAgeBaseFileStatusRecord(base);
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
		AdvancedAgeApply searchApply = selectAdvancedAgeApply(apply);
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
		return "b02/file_text";
	}
	
	@RequestMapping(value = "/b03")
	public String b03(HttpServletRequest request,Model model,BlackList blackList,Pagination pagination){
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
		
		return "b03/b03";
	}
	
	@RequestMapping(value = "/b03_1")
	public String b03_1(HttpServletRequest request,Model model,BlackList blackList,String searchSeq,String searchUnit,
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
		return "b03/b03_1";
	}
	
	@RequestMapping(value = "/b03_02")
	public String b03_02(HttpServletRequest request,Model model,AdvancedAgeBase base){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		if(base.getSeq()!=null && !base.getSeq().equals(""))
		{
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectATypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "b03/b03_02";
	}
	
	@RequestMapping(value = "/b04")
	public String b04(HttpServletRequest request,Model model,SiteInspection siteInspection,Pagination pagination){ 
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
		siteInspection.setCaseType("A");
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
		
		return "b04/b04";
	}
	
	@RequestMapping(value = "/b04_1")
	public String b04_1(HttpServletRequest request,Model model,SiteInspection siteInspection,String searchSeq,String searchUnit,String searchResult){
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
		return "b04/b04_1";
	}
	
	@RequestMapping(value = "/b04_02")
	public String b04_02(HttpServletRequest request,Model model,AdvancedAgeBase base){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		if(base.getSeq()!=null && !base.getSeq().equals(""))
		{
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectATypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "b04/b04_02";
	}
	
	@RequestMapping(value = "/b05")
	public String b05(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
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
			base.setCaseStatus("3、4、8");
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectATypeAdvancedAgeBase(base);
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
		return "b05/b05";
	}
	
	@RequestMapping(value = "/b05_1")
	public String b05_1(HttpServletRequest request,Model model,AdvancedAgeBase base,AdvancedAgeApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("base", base);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
			apply = selectAdvancedAgeApply(apply);
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
			AdvancedAgePlan plan = new AdvancedAgePlan();
			if(apply.getId()!=null) {
				plan.setAdvancedAgeApplyId(apply.getId());
				plan = selectAdvancedAgePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------繼續僱用名單 start------
			AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
			if(plan.getId()!=null) {
				employmenyList.setAdvancedAgePlanId(plan.getId());
				model.addAttribute("employmenyListSize", selectAdvancedAgeEmploymentLists(employmenyList).toList().size());
			}
			// ------繼續僱用名單 end--------
			
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
			siteInspection.setCaseType("A");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		return "b05/b05_1";
	}
	
	@RequestMapping(value = "/c01")
	public String c01(HttpServletRequest request,Model model,Pagination pagination,AdvancedAgeBase base){
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
		
//		base.setYear(applyYear);
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			base.setCaseStatus("5、6、7");
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//所有資料
		jsonArray = selectATypeAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();
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
		
		return "c01/c01";
	}
	
	@RequestMapping(value = "/c01_1")
	public String c01_1(HttpServletRequest request,Model model,AdvancedAgeBase base,AdvancedAgeApply apply){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		model.addAttribute("base", base);
		if(apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
			apply = selectAdvancedAgeApply(apply);
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
			
			// ------計畫表 start------
			AdvancedAgePlan plan = new AdvancedAgePlan();
			if(apply.getId()!=null) {
				plan.setAdvancedAgeApplyId(apply.getId());
				plan = selectAdvancedAgePlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------繼續僱用名單 start------
			AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
			if(plan.getId()!=null) {
				employmenyList.setAdvancedAgePlanId(plan.getId());
				model.addAttribute("employmenyList", selectAdvancedAgeEmploymentLists(employmenyList).toList());
			}
			// ------繼續僱用名單 end--------
			// ------繼續僱用名單_請領 start------
			AdvancedAgeEmploymentListReceipt employmenyListReceipt = new AdvancedAgeEmploymentListReceipt();
			if(base.getId()!=null) {
				employmenyListReceipt.setAdvancedAgeBaseId(base.getId());
				model.addAttribute("employmenyListReceipt", selectAdvancedAgeEmploymentListReceipts(employmenyListReceipt).toList());
			}
			// ------繼續僱用名單_請領 end--------
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
			siteInspection.setCaseType("A");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		return "c01/c01_1";
	}
	
	@RequestMapping(value = "/c01_file")
	public String c01_file(HttpServletRequest request,Model model,AdvancedAgeEmploymentListReceipt listReceipt,String year){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		// ------基礎表 start------
		base.setYear(year);
		base.setSeq(listReceipt.getSeq());
		AdvancedAgeBase searchBase = selectATypeAdvancedAgeBaseData(base);
		model.addAttribute("base", searchBase);
		model.addAttribute("frequency", listReceipt.getBaseAllowanceFrequency());
		// ------基礎表 end------
		
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
//			userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList",""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
				
		// ------申請表 start------
		AdvancedAgeApply apply= new AdvancedAgeApply();
		apply.setSeq(listReceipt.getSeq());
		apply.setApplyYear(year);
		apply = selectAdvancedAgeApply(apply);
		model.addAttribute("apply", apply);
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
		// 原核定函文件
		attachment.setFileBelong("BA");
		attachment.setFileBelongId(listReceipt.getAdvancedAgeBaseId());
		attachment.setFileFrequency(listReceipt.getBaseAllowanceFrequency());
		attachment.setFileType("approved");
		model.addAttribute("approvedAttachment", selectApprovedFiles(attachment).toList());

		// 領據證明文件
		attachment.setFileType("receipt");
		model.addAttribute("receiptAttachment", selectApprovedFiles(attachment).toList());

		// 雇用證明文件
		attachment.setFileType("employment");
		model.addAttribute("employmentAttachment", selectApprovedFiles(attachment).toList());
		
		// 薪資證明文件
		attachment.setFileType("salary");
		model.addAttribute("salaryAttachment", selectApprovedFiles(attachment).toList());
		
		// 出勤證明文件
		attachment.setFileType("attendance");
		model.addAttribute("attendanceAttachment", selectApprovedFiles(attachment).toList());
		
		// 其他證明文件
		attachment.setFileType("necessary");
		model.addAttribute("necessaryAttachment", selectApprovedFiles(attachment).toList());
		
		model.addAttribute("mailDomain", mailDomain);
		
		//信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(searchBase.getId());
		mailRecord.setMailType("B");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		sdf = new SimpleDateFormat("yyyyMMdd");
		model.addAttribute("today", sdf.format(new Date()));
		return "c01/c01_file";
	}
	
	@RequestMapping(value = "/c01_list")
	public String c01_list(HttpServletRequest request,Model model,AdvancedAgeEmploymentListReceipt listReceipt,String year){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		
		model.addAttribute("base", base);
		// ------基礎表 start------
		base.setYear(year);
		base.setSeq(listReceipt.getSeq());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
		AdvancedAgeApply apply= new AdvancedAgeApply();
		apply.setSeq(listReceipt.getSeq());
		apply.setApplyYear(year);
		apply = selectAdvancedAgeApply(apply);
		model.addAttribute("apply", apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		AdvancedAgePlan plan = new AdvancedAgePlan();
		if(apply.getId()!=null) {
			plan.setAdvancedAgeApplyId(apply.getId());
			plan = selectAdvancedAgePlan(plan);
			model.addAttribute("plan", plan);
		}
		// ------計畫表 end--------
		// ------繼續僱用名單 start------
		AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
		if(plan.getId()!=null) {
			employmenyList.setAdvancedAgePlanId(plan.getId());
			model.addAttribute("employmenyList", selectAdvancedAgeEmploymentLists(employmenyList).toList());
		}
		// ------繼續僱用名單 end--------
		// ------繼續僱用名單_請領 start------
		model.addAttribute("employmenyListReceipt", selectAdvancedAgeEmploymentListReceiptsByFrequency(listReceipt).toList());
		// ------繼續僱用名單_請領 end--------
		sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
		model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
		model.addAttribute("month", sdf.format(new Date()).substring(5,7));
		model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		return "c01/c01_list";
	}
	
	@RequestMapping(value = "/c01_file_content")
	public String c01_file_content(HttpServletRequest request,Model model,AdvancedAgeBase base){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		// ------基礎表 start------
		AdvancedAgeBase searchBase = selectATypeAdvancedAgeBaseData(base);
		model.addAttribute("base", searchBase);
		// ------基礎表 end------
		
		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		
		model.addAttribute("mailDomain", mailDomain);
		
		//信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(searchBase.getId());
		mailRecord.setMailType("B");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		sdf = new SimpleDateFormat("yyyyMMdd");
		model.addAttribute("today", sdf.format(new Date()));
		
		return "c01/c01_file_content";
	}
	
	@RequestMapping(value = "/c01_result")
	public String c01_result(HttpServletRequest request,Model model,AdvancedAgeEmploymentListReceipt listReceipt,String year){ 
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		
		model.addAttribute("base", base);
		// ------基礎表 start------
		base.setYear(year);
		base.setSeq(listReceipt.getSeq());
		model.addAttribute("base", selectATypeAdvancedAgeBase(base).toList());
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
		AdvancedAgeApply apply= new AdvancedAgeApply();
		apply.setSeq(listReceipt.getSeq());
		apply.setApplyYear(year);
		apply = selectAdvancedAgeApply(apply);
		model.addAttribute("apply", apply);
		// ------申請表 end--------
		
		// ------計畫表 start------
		AdvancedAgePlan plan = new AdvancedAgePlan();
		if(apply.getId()!=null) {
			plan.setAdvancedAgeApplyId(apply.getId());
			plan = selectAdvancedAgePlan(plan);
			model.addAttribute("plan", plan);
		}
		// ------計畫表 end--------
		// ------繼續僱用名單 start------
		AdvancedAgeEmploymentList employmenyList = new AdvancedAgeEmploymentList();
		if(plan.getId()!=null) {
			employmenyList.setAdvancedAgePlanId(plan.getId());
			model.addAttribute("employmenyList", selectAdvancedAgeEmploymentLists(employmenyList).toList());
		}
		// ------繼續僱用名單 end--------
		// ------繼續僱用名單_請領 start------
		model.addAttribute("employmenyListReceipt", selectAdvancedAgeEmploymentListReceiptsByFrequency(listReceipt).toList());
		// ------繼續僱用名單_請領 end--------
		sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911)+sdf.format(new Date()).substring(4));
		model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0,4))-1911));
		model.addAttribute("month", sdf.format(new Date()).substring(5,7));
		model.addAttribute("day", sdf.format(new Date()).substring(8,10));
		return "c01/c01_result";
	}
	
	@RequestMapping(value = "/i01")
	public String i01(HttpServletRequest request,String account){ 
		return "i01/i01";
	}
	
	@RequestMapping(value = "/i02")
	public String i02(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
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
		base.setCaseType("A");
		
		if(pagination.getNumbersOfPage()==null)
		{
			base.setYear(applyYear);
			pagination = new Pagination("1","10");
		}
		jsonArray = selectCaseStatistics(base);
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
		return "i02/i02";
	}
	
	@RequestMapping(value = "/i03")
	public String i03(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("A");
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
		return "i03/i03";
	}
	
	@RequestMapping(value = "/i04")
	public String i04(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		base.setCaseType("A");
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
		return "i04/i04";
	}
	
	@RequestMapping(value = "/i05")
	public String i05(HttpServletRequest request,Model model,AdvancedAgeBase base,Pagination pagination){ 
		session=request.getSession();
		setModel(session.getId(),model);
		dateFormatUtil = new DateFormatUtil(new Date());
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("A");
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
		return "i05/i05";
	}
	
	@RequestMapping(value = "/j01")
	public String j01(HttpServletRequest request,Model model,UserInfo userInfo){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		userInfo.setAccount(session.getAttribute(session.getId()+"account").toString());
		model.addAttribute("userInfoData", selectUserInfoData(userInfo));
		model.addAttribute("unitList", getUnit().toList());
		return "j01/j01";
	}
	
	@RequestMapping(value = "/j02")
	public String j02(HttpServletRequest request,Model model,UserInfo userInfo,String userAccount,Pagination pagination){
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
		return "j02/j02";
	}
	
	@RequestMapping(value = "/j02_1")
	public String j02_1(HttpServletRequest request,Model model,UserInfo userInfo,String editAccount){
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
			return "j02/j02_1";
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
			return "j02/j02";
		}
	}
	
	@RequestMapping(value = "/j02_02")
	public String j02_02(HttpServletRequest request,Model model,UserInfo userInfo,String userAccount){
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
			return "j02/j02";
		}
		else {
			return "j02/j02_02";
		}
	}

	@RequestMapping(value = "/j03")
	public String j03(HttpServletRequest request,Model model,UserInfo userInfo){
		session=request.getSession();
		if (session == null || !request.isRequestedSessionIdValid() || session.getAttribute(session.getId()+"account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(),model);
		FunctionList functionList = new FunctionList();
		functionList.setCaseType("A");
		model.addAttribute("functionList", selectFunctionList(functionList).toList());
		return "j03/j03";
	}
	

	@RequestMapping(value = "/j04")
	public String j04(HttpServletRequest request,Model model,UserLoginRecord userLoginRecord,String loginStartDate,String loginEndDate,Pagination pagination){
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
		return "j04/j04";
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
	public String selectFunctionPermission(FunctionPermission functionPermission,int type) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(functionPermission);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip+"selectFunctionPermission",json));
		if(type>1) {
			return object.get("functionCode"+type).toString();
		}else {
			return object.get("functionCode").toString();
		}
	}
	
	public String getUnitName(String unitCode) {
		JSONArray unitArray = getUnit();
		for(int i=0;i<unitArray.length();i++)
		{
			if(unitArray.getJSONObject(i).get("code").equals(unitCode))
			{
				return unitArray.getJSONObject(i).get("name").toString();
			}
		}
		return null;
	}
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public void sendMail(HttpServletRequest request, HttpServletResponse response,MailRecord mailRecord){
		try {
			sendEmail.sendMail(mailRecord.getEmail(),"補件通知", mailRecord.getMailContent());
		} catch (AddressException e1) {
			logger.warn(e1.getMessage());
		} catch (MessagingException e1) {
			logger.warn(e1.getMessage());
		} catch (Exception e1) {
			logger.warn(e1.getMessage());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
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
	
	@RequestMapping(value = "/sendCompanyInfoMail", method = RequestMethod.POST)
	public void sendCompanyInfoMail(HttpServletRequest request, HttpServletResponse response,MailRecord mailRecord,String companyName,String seq,String pwd){
		mailRecord.setMailContent("您好\r\n"
				+ "貴公司 "+companyName+" 於勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統註冊帳號  "+seq+"\r\n"
				+ "\r\n"
				+ "您的預設密碼為："+pwd+"\r\n"
				+ "\r\n"
				+ "請於以下網址前往修改密碼：\r\n"
				+ mailDomain+"/advancedAgeFrontend/change_password");
		try {
			sendEmail.sendMail(mailRecord.getEmail(),"<密碼通知信> 勞動力發展署-促進中高齡及高齡者就業相關補助計畫系統",mailRecord.getMailContent());
		} catch (AddressException e1) {
			logger.warn(e1.getMessage());
		} catch (MessagingException e1) {
			logger.warn(e1.getMessage());
		} catch (Exception e1) {
			logger.warn(e1.getMessage());
		}
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
	
	public JSONArray selectATypeAdvancedAgeBase(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectATypeAdvancedAgeBase",json));
		return array;
	}
	
	public AdvancedAgeBase selectATypeAdvancedAgeBaseData(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectATypeAdvancedAgeBaseData", json);
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
	
	public void addUserLoginRecord(UserLoginRecord userLoginRecord) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			
			json = objectMapper.writeValueAsString(userLoginRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		api.httpPost(ip+"addUserLoginRecord",json);
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
	
	public JSONArray selectCompanyInfo(CompanyInfo info){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(info);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectCompanyInfo",json));
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
	
	public UserInfo selectUserInfoLogin(UserInfo userInfo){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectUserInfoLogin",json);
		UserInfo searchUser = new UserInfo();
		try {
			if (!jsondata.equals(""))
				searchUser = objectMapper.readValue(jsondata, UserInfo.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchUser;
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
	
	public JSONArray selectATypeAdvancedAgeBaseFileStatus(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip+"selectATypeAdvancedAgeBaseFileStatus",json));
		return array;
	}
	
	public AdvancedAgeBase selectATypeAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase advancedAgeBase){ 
		ObjectMapper objectMapper = new ObjectMapper();
		String json="";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip+"selectATypeAdvancedAgeBaseFileStatusRecord",json);
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
	
	public AdvancedAgePlan selectAdvancedAgePlan(AdvancedAgePlan plan) {
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
	
	public JSONArray selectAdvancedAgeEmploymentListReceiptsByFrequency(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(employmentListReceipt);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeEmploymentListReceiptsByFrequency", json));
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
	
	public JSONArray selectApprovedFiles(Attachment attachment) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(attachment);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectApprovedFiles", json));
		return array;
	}
	
	public JSONArray selectCaseStatistics(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCaseStatistics", json));
		return array;
	}
	
	public JSONArray selectApplicationSituation(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
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
		String json = "";
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
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectYearAmountsStatistics", json));
		return array;
	}
	
	public JSONArray getUnit() {
		return new JSONArray(api.httpPost(ip + "getUnit", ""));
	}
}