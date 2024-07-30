package com.example.springboot.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorize;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.FunctionList;
import com.example.springboot.entity.MailRecord;
import com.example.springboot.entity.Pagination;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.entity.UserLoginRecord;
import com.example.springboot.util.AesUtil;
import com.example.springboot.util.CallApi;
import com.example.springboot.util.DateFormatUtil;
import com.example.springboot.util.SendEmail;
import com.example.springboot.util.Zip;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BackendMain3Controller {

	Logger logger = LogManager.getLogger(BackendMain3Controller.class);

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

	Attachment attachment;

	JSONArray jsonArray;

	Unit unit;

	DateFormatUtil dateFormatUtil;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@RequestMapping(value = "/saveRarCtype", method = RequestMethod.POST)
	public void saveRarCtype(HttpServletResponse response, Attachment attachment, String date) {
		try {
			zip.ZipDirs(filePath + "/C/" + attachment.getFileBelongId(), date + ".rar", true, f -> true,
					filePath + "/C/" + attachment.getFileBelongId() + "/register/" + attachment.getFileFrequency(),
					filePath + "/C/" + attachment.getFileBelongId() + "/jointAuthorize/"
							+ attachment.getFileFrequency(),
					filePath + "/C/" + attachment.getFileBelongId() + "/necessary/" + attachment.getFileFrequency());
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter()
					.print("success;" + "downloadRar?path=/C/" + attachment.getFileBelongId() + "/" + date + ".rar");
		} catch (IOException e) {
			logger.warn(e.getMessage());
		}
	}

	@RequestMapping(value = "/s01")
	public String s01(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("base", base);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		// ------縣市列表 start------
		jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
		model.addAttribute("cityList", jsonArray.toList());
		// ------縣市列表 end------
		// 所有資料
		AdvancedAgeBase totalBase = new AdvancedAgeBase();
		totalBase.setYear(applyYear);
		totalBase.setCaseType("C");
		model.addAttribute("totalBaseList", selectAdvancedAgeBase(totalBase).toList());
		model.addAttribute("year", applyYear);
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 查詢資料
		base.setFileStatus("4");// 附件通過
		base.setCaseType("C");
		jsonArray = selectAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
//					List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());

		// ------人員列表 start------
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// ------人員列表 end------
		return "s01/s01";
	}

	@RequestMapping(value = "/s01_division")
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
		totalBase.setCaseType("C");
		model.addAttribute("totalBaseList", selectAdvancedAgeBase(totalBase).toList());
		model.addAttribute("year", applyYear);
		
		//初始狀態查詢
		if(pagination.getNumbersOfPage()==null)
		{
			if(!session.getAttribute(session.getId()+"unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId()+"unit").toString());
			pagination = new Pagination("1","10");
		}
		//查詢資料
		base.setCaseType("C");
		jsonArray = selectAdvancedAgeBase(base);
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
		return "s01/s01_division";
	}
	
	@RequestMapping(value = "/t01")
	public String t01(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination,
			UserInfo userInfo) {
		session = request.getSession();
		if (!request.isRequestedSessionIdValid() || session == null
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("year", applyYear);
		model.addAttribute("base", base);
		model.addAttribute("unitList", getUnit().toList());

		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			base.setFileStatus("1、2、3");
			base.setYear(applyYear);
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 所有資料
		jsonArray = selectCTypeAdvancedAgeBaseFileStatus(base);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "t01/t01";
	}

	@RequestMapping(value = "/t01File")
	public String t01File(HttpServletRequest request, Model model, AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		setModel(session.getId(), model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		base.setCaseType("C");
		AdvancedAgeBase nbase = selectAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);

		// userinfo
		UserInfo userInfo = new UserInfo();
//		userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------

		// ------申請表 start------
		AdvancedAgeRetirementReemploymentApply searchApply = selectAdvancedAgeRetirementReemploymentApply(apply);
		model.addAttribute("apply", searchApply);

		// ------申請表 end--------

		// 負責人
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setSeq(base.getSeq());
		try {
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		}catch(JSONException e) {
			logger.warn(e.getMessage());
		}

		// 文件
		attachment = new Attachment();
		// 設立登記證明文件
		attachment.setFileBelong("C");
		attachment.setFileBelongId(searchApply.getId());
		attachment.setFileType("register");
		model.addAttribute("registerAttachment", selectFiles(attachment).toList());

		// 聯合辦理單位授權書
		attachment.setFileType("jointAuthorize");
		model.addAttribute("jointAuthorizeAttachment", selectFiles(attachment).toList());

		// 其他經本署或各分署認定有必要提出之文件
		attachment.setFileType("necessary");
		model.addAttribute("necessaryAttachment", selectFiles(attachment).toList());

		model.addAttribute("mailDomain", mailDomain);
		model.addAttribute("date", getROCDate());

		// 信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("A");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		return "t01/file";
	}

	@RequestMapping(value = "/t02")
	public String t02(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination,
			UserInfo userInfo) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		model.addAttribute("year", applyYear);
		model.addAttribute("base", base);
		model.addAttribute("unitList", getUnit().toList());
		base.setFileStatus("3");
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			base.setYear(applyYear);
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 查詢資料
		jsonArray = selectCTypeAdvancedAgeBaseFileStatus(base);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());

		return "t02/t02";
	}

	@RequestMapping(value = "/u01")
	public String u01(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
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
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			base.setCaseStatus("1、2、3");
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 查詢資料
		base.setFileStatus("4");// 附件通過
		base.setCaseType("C");
		jsonArray = selectAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
//							List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "u01/u01";
	}

	@RequestMapping(value = "/u01_1")
	public String u01_1(HttpServletRequest request, Model model, AdvancedAgeBase base,
			AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		model.addAttribute("base", base);
		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//						userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			model.addAttribute("apply", apply);
			model.addAttribute("companyAttributes", parseCompanyAttributes(apply.getCompanyAttributes()));
			// ------申請表 end--------
			// 負責人
			try {
				CompanyInfo cinfo = new CompanyInfo();
				cinfo.setSeq(base.getSeq());
				model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			} catch (JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------

			// ------縣市列表 start----
			String cityJsonString = api.httpPost(ip + "getCityList", "");
			jsonArray = new JSONArray(cityJsonString);
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----

			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(), ""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("subsidyType", parseSubsidyType(plan.getSubsidyType()));
				model.addAttribute("executionCity", parseCity(cityJsonString, plan.getExecutionCity()));
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------計畫受益人員名單 start------
			AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			if (plan.getId() != null) {
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
				model.addAttribute("benefitListSize",
						selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList().size());
			}
			// ------計畫受益人員名單 end--------
			// ------經費概算 start------
			AdvancedAgeRetirementReemploymentExpenditure expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			if (apply.getId() != null) {
				expenditure.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = selectAdvancedAgeRetirementReemploymentExpenditures(
						expenditure);
				model.addAttribute("expenditureListSize", expenditureList.size());
				model.addAttribute("expenditureListSum", sumsOfExpenditure(expenditureList));
				model.addAttribute("expenditureListAmountsSum", sumsOfExpenditureAmounts(expenditureList));
			}
			// ------經費概算 end--------
			// ------聯合辦理單位授權基本資料 start------
			AdvancedAgeRetirementReemploymentBasicData basicData = new AdvancedAgeRetirementReemploymentBasicData();
			if (apply.getId() != null) {
				basicData.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = selectAdvancedAgeRetirementReemploymentBasicDatas(
						basicData);
				model.addAttribute("basicDataListSize", basicDataList.size());
			}
			// ------聯合辦理單位授權基本資料 end--------
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("C");
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

		return "u01/u01_1";
	}

	@RequestMapping(value = "/u01_1_print")
	public String u01_1_print(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination,
			AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);

		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//						userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			model.addAttribute("apply", apply);
			model.addAttribute("companyAttributes", parseCompanyAttributes(apply.getCompanyAttributes()));
			// ------申請表 end--------
			// 負責人
			try {
				CompanyInfo cinfo = new CompanyInfo();
				cinfo.setSeq(base.getSeq());
				model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			} catch (JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------

			// ------縣市列表 start----
			String cityJsonString = api.httpPost(ip + "getCityList", "");
			jsonArray = new JSONArray(cityJsonString);
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----

			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(), ""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("subsidyType", parseSubsidyType(plan.getSubsidyType()));
				model.addAttribute("executionCity", parseCity(cityJsonString, plan.getExecutionCity()));
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------計畫受益人員名單 start------
			AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			if (plan.getId() != null) {
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
				model.addAttribute("benefitListSize",
						selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList().size());
			}
			// ------計畫受益人員名單 end--------
			// ------經費概算 start------
			AdvancedAgeRetirementReemploymentExpenditure expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			if (apply.getId() != null) {
				expenditure.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = selectAdvancedAgeRetirementReemploymentExpenditures(
						expenditure);
				model.addAttribute("expenditureListSize", expenditureList.size());
				model.addAttribute("expenditureListSum", sumsOfExpenditure(expenditureList));
				model.addAttribute("expenditureListAmountsSum", sumsOfExpenditureAmounts(expenditureList));
			}
			// ------經費概算 end--------
			// ------聯合辦理單位授權基本資料 start------
			AdvancedAgeRetirementReemploymentBasicData basicData = new AdvancedAgeRetirementReemploymentBasicData();
			if (apply.getId() != null) {
				basicData.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = selectAdvancedAgeRetirementReemploymentBasicDatas(
						basicData);
				model.addAttribute("basicDataListSize", basicDataList.size());
			}
			// ------聯合辦理單位授權基本資料 end--------
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------

			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("C");
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
		return "u01/u01_1_print";
	}

	@RequestMapping(value = "/personnelList")
	public String personnelList(HttpServletRequest request,Model model, AdvancedAgeBase base, AdvancedAgeRetirementReemploymentApply apply) {
		session=request.getSession();
		setModel(session.getId(), model);
		if (apply.getApplyYear() != null) {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911)
					+ sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5, 7));
			model.addAttribute("day", sdf.format(new Date()).substring(8, 10));
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------

			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			// ------申請表 end--------

			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------

			// ------受益人員名單 start------
			AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			if (plan.getId() != null) {
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
				JSONArray personnelList_JSONArray = selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList);
				model.addAttribute("personnelList", personnelList_JSONArray.toList());
				model.addAttribute("personnelListSize", personnelList_JSONArray.toList().size());
			}
			// ------受益人員名單 end------
		}
		return "u01/personnelList";
	}

	@RequestMapping(value = "/exportPersonnelExcel")
	public void exportPersonnelExcel(Model model, HttpServletResponse response,
			AdvancedAgeRetirementReemploymentApply apply) throws IOException {
		// 創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		// 創建工作表
		XSSFSheet sheet = wb.createSheet("受益人員名單清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6 * 256);
		sheet.setColumnWidth(1, 13 * 256);
		sheet.setColumnWidth(2, 14 * 256);
		sheet.setColumnWidth(3, 16 * 256);
		sheet.setColumnWidth(4, 13 * 256);
		sheet.setColumnWidth(5, 14 * 256);
		sheet.setColumnWidth(6, 13 * 256);
		sheet.setColumnWidth(7, 15 * 256);
		row.setHeightInPoints(30);// 設置行高

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

		// 創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("受益人員");
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
		cell.setCellValue("工時類型");
		cell.setCellStyle(style);

		row = sheet.createRow(1);
		row.setHeightInPoints(20);// 設置行高

		cell = row.createCell(2);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);

		cell = row.createCell(5);
		cell.setCellValue("yyy/mm/dd");
		cell.setCellStyle(style1);

		// ------申請表 start------
		apply = selectAdvancedAgeRetirementReemploymentApply(apply);
		// ------申請表 end--------

		// ------計畫表 start------
		AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
		if (apply.getId() != null) {
			plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
			plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
		}
		// ------計畫表 end--------

		// ------受益人員名單 start------
		AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
		JSONArray benefitJsonArray = new JSONArray();
		if (plan.getId() != null) {
			benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
			benefitJsonArray = selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList);
		}
		String date = "";
		for (int i = 0; i < benefitJsonArray.toList().size(); i++) {
			row = sheet.createRow(i + 2);
			row.setHeightInPoints(25);
			cell = row.createCell(0);
			cell.setCellValue(i + 1);
			cell.setCellStyle(style2);

			cell = row.createCell(1);
			cell.setCellValue(benefitJsonArray.getJSONObject(i).get("name").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(2);
			if (benefitJsonArray.getJSONObject(i).get("birthday").toString().length() == 7) {
				date = benefitJsonArray.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date.substring(0, 3) + "/" + date.substring(3, 5) + "/" + date.substring(5));
			} else {
				date = benefitJsonArray.getJSONObject(i).get("birthday").toString();
				cell.setCellValue(date);
			}
			cell.setCellStyle(style2);

			cell = row.createCell(3);
			cell.setCellValue(benefitJsonArray.getJSONObject(i).get("identification").toString());
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			if (benefitJsonArray.getJSONObject(i).get("insuranceType").toString().equals("L")) {
				cell.setCellValue("勞工保險");
			} else if (benefitJsonArray.getJSONObject(i).get("insuranceType").toString().equals("Z")) {
				cell.setCellValue("職災保險");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			if (benefitJsonArray.getJSONObject(i).get("insuranceTime").toString().length() == 7) {
				date = benefitJsonArray.getJSONObject(i).get("insuranceTime").toString();
				cell.setCellValue(date.substring(0, 3) + "/" + date.substring(3, 5) + "/" + date.substring(5));
			} else {
				date = benefitJsonArray.getJSONObject(i).get("insuranceTime").toString();
				cell.setCellValue(date);
			}
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			if (benefitJsonArray.getJSONObject(i).get("manager").equals("Y")) {
				cell.setCellValue("主管");
			} else if (benefitJsonArray.getJSONObject(i).get("manager").equals("N")) {
				cell.setCellValue("非主管");
			}
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			if (benefitJsonArray.getJSONObject(i).get("workingHours").equals("A")) {
				cell.setCellValue("全時");
			} else if (benefitJsonArray.getJSONObject(i).get("workingHours").equals("P")) {
				cell.setCellValue("部分工時");
			}
			cell.setCellStyle(style2);
		}
		// ------受益人員名單 end------

		String filename = "受益人員名單清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

				+ new String(filename.getBytes(), "iso8859-1") + ".xlsx");

		// excel寫入輸出流

		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

				response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}

	@RequestMapping(value = "/u01Expenditure")
	public String u01Expenditure(HttpServletRequest request,Model model, AdvancedAgeBase base, AdvancedAgeRetirementReemploymentApply apply) {
		session=request.getSession();
		setModel(session.getId(), model);
		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------

			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			// ------申請表 end------

			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end------

			// ------經費概算 start------
			AdvancedAgeRetirementReemploymentExpenditure expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			if (apply.getId() != null) {
				expenditure.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = selectAdvancedAgeRetirementReemploymentExpenditures(
						expenditure);
				model.addAttribute("expenditure", expenditureList);
				model.addAttribute("expenditureListSize", expenditureList.size());
				model.addAttribute("expenditureListSum", sumsOfExpenditure(expenditureList));
				model.addAttribute("expenditureListAmountsSum", sumsOfExpenditureAmounts(expenditureList));
			}
			// ------經費概算 end------

			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911)
					+ sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5, 7));
			model.addAttribute("day", sdf.format(new Date()).substring(8, 10));

		}
		return "u01/expenditure";
	}

	@RequestMapping(value = "/u01exportExpenditureExcel")
	public void u01ExportExpenditureExcel(Model model, HttpServletResponse response,
			AdvancedAgeRetirementReemploymentApply apply) throws IOException {
		// 創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		// 創建工作表
		XSSFSheet sheet = wb.createSheet("經費概算清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6 * 256);
		sheet.setColumnWidth(1, 24 * 256);
		sheet.setColumnWidth(2, 12 * 256);
		sheet.setColumnWidth(3, 12 * 256);
		sheet.setColumnWidth(4, 12 * 256);
		sheet.setColumnWidth(5, 20 * 256);
		sheet.setColumnWidth(6, 20 * 256);
		sheet.setColumnWidth(7, 20 * 256);
		row.setHeightInPoints(30);// 設置行高

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

		// 創建單元格
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
		cell.setCellValue("申請本計畫補助");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("申請其他單位補助");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("說明");
		cell.setCellStyle(style);

		row = sheet.createRow(1);
		row.setHeightInPoints(20);// 設置行高

		cell = row.createCell(6);
		cell.setCellValue("( 無則免填 )");
		cell.setCellStyle(style1);

		// ------申請表 start------
		apply = selectAdvancedAgeRetirementReemploymentApply(apply);
		// ------申請表 end--------

		// ------經費概算 start------
		AdvancedAgeRetirementReemploymentExpenditure expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
		List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = new ArrayList<>();
		if (apply.getId() != null) {
			expenditure.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
			expenditureList = selectAdvancedAgeRetirementReemploymentExpenditures(expenditure);
		}
		// ------經費概算 end--------

		String data = "", index = "";
		for (int i = 0; i < expenditureList.size(); i++) {
			expenditure = expenditureList.get(i);

			row = sheet.createRow(i + 2);
			cell = row.createCell(0);
			cell.setCellValue(i + 1);
			cell.setCellStyle(style2);

			cell = row.createCell(1);
			cell.setCellValue(expenditure.getPlanName());
			cell.setCellStyle(style2);

			cell = row.createCell(2);
			cell.setCellValue(expenditure.getUnitPrice());
			cell.setCellStyle(style2);

			cell = row.createCell(3);
			cell.setCellValue(expenditure.getAmount());
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			cell.setCellValue(expenditure.getUnitPrice() * expenditure.getAmount());
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			cell.setCellValue(expenditure.getAmounts());
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			if (expenditure.getOtherAmounts() == null) {
				cell.setCellValue("");
			} else {
				cell.setCellValue(expenditure.getOtherAmounts());
			}
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			cell.setCellValue(expenditure.getDescription());
			cell.setCellStyle(style2);
		}

		String filename = "經費概算清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

				+ new String(filename.getBytes(), "iso8859-1") + ".xlsx");

		// excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

				response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}

	@RequestMapping(value = "/jointUnit")
	public String jointUnit(HttpServletRequest request,Model model, AdvancedAgeBase base, AdvancedAgeRetirementReemploymentApply apply) {
		session=request.getSession();
		setModel(session.getId(), model);
		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList().get(0));
			// ------基礎表 end--------

			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			// ------申請表 end------

			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end------

			// ------計畫受益人員名單 start------
			AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			if (plan.getId() != null) {
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
				model.addAttribute("benefitListSize",
						selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList().size());
			}
			// ------計畫受益人員名單 end--------

			// ------單位基本資料 start------
			AdvancedAgeRetirementReemploymentBasicData basicData = new AdvancedAgeRetirementReemploymentBasicData();
			List<AdvancedAgeRetirementReemploymentBasicData> list = new ArrayList<>();
			if (apply.getId() != null) {
				basicData.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				list = selectAdvancedAgeRetirementReemploymentBasicDatas(basicData);
				model.addAttribute("basicDataListSize", list.size());
			}
			model.addAttribute("basicData", list);
			// ------單位基本資料 end--------

			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			model.addAttribute("time", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911)
					+ sdf.format(new Date()).substring(4));
			model.addAttribute("year", (Integer.valueOf((String) sdf.format(new Date()).substring(0, 4)) - 1911));
			model.addAttribute("month", sdf.format(new Date()).substring(5, 7));
			model.addAttribute("day", sdf.format(new Date()).substring(8, 10));
		}
		return "u01/jointUnit";
	}

	@RequestMapping(value = "/exportJointUnitExcel")
	public void exportJointUnitExcel(Model model, HttpServletResponse response,
			AdvancedAgeRetirementReemploymentApply apply) throws IOException {
		// 創建工作簿
		XSSFWorkbook wb = new XSSFWorkbook();
		// 創建工作表
		XSSFSheet sheet = wb.createSheet("經費概算清冊");
		XSSFRow row = sheet.createRow(0);
		sheet.setColumnWidth(0, 6 * 256);
		sheet.setColumnWidth(1, 24 * 256);
		sheet.setColumnWidth(2, 13 * 256);
		sheet.setColumnWidth(3, 28 * 256);
		sheet.setColumnWidth(4, 34 * 256);
		sheet.setColumnWidth(5, 13 * 256);
		sheet.setColumnWidth(6, 20 * 256);
		sheet.setColumnWidth(7, 10 * 256);
		sheet.setColumnWidth(8, 10 * 256);
		sheet.setColumnWidth(9, 22 * 256);
		sheet.setColumnWidth(10, 18 * 256);
		sheet.setColumnWidth(11, 20 * 256);
		sheet.setColumnWidth(12, 12 * 256);
		sheet.setColumnWidth(13, 16 * 256);
		row.setHeightInPoints(30);// 設置行高

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

		// 創建單元格
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("次序");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("單位名稱");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("統一編號");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("主要營業項目");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("行業別");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("單位規模");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("投保證號");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("負責人");
		cell.setCellStyle(style);

		cell = row.createCell(8);
		cell.setCellValue("聯絡人");
		cell.setCellStyle(style);

		cell = row.createCell(9);
		cell.setCellValue("聯絡電話");
		cell.setCellStyle(style);

		cell = row.createCell(10);
		cell.setCellValue("聯絡手機");
		cell.setCellStyle(style);

		cell = row.createCell(11);
		cell.setCellValue("電子信箱");
		cell.setCellStyle(style);

		cell = row.createCell(12);
		cell.setCellValue("員工人數");
		cell.setCellStyle(style);

		cell = row.createCell(13);
		cell.setCellValue("預計參與人數");
		cell.setCellStyle(style);

		row = sheet.createRow(1);
		row.setHeightInPoints(20);// 設置行高

		cell = row.createCell(3);
		cell.setCellValue("主要業務、產品、服務項目");
		cell.setCellStyle(style1);

		cell = row.createCell(6);
		cell.setCellValue("( 超過2組請用;隔開 )");
		cell.setCellStyle(style1);

		cell = row.createCell(9);
		cell.setCellValue("(區碼)電話號碼#分機");
		cell.setCellStyle(style1);

		// ------申請表 start------
		apply = selectAdvancedAgeRetirementReemploymentApply(apply);
		// ------申請表 end--------

		// ------經費概算 start------
		AdvancedAgeRetirementReemploymentBasicData basicData = new AdvancedAgeRetirementReemploymentBasicData();
		List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = new ArrayList<>();
		if (apply.getId() != null) {
			basicData.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
			basicDataList = selectAdvancedAgeRetirementReemploymentBasicDatas(basicData);
		}
		// ------經費概算 end--------

		String data = "", index = "";
		for (int i = 0; i < basicDataList.size(); i++) {
			basicData = basicDataList.get(i);

			row = sheet.createRow(i + 2);
			cell = row.createCell(0);
			cell.setCellValue(i + 1);
			cell.setCellStyle(style2);

			cell = row.createCell(1);
			cell.setCellValue(basicData.getCompanyName());
			cell.setCellStyle(style2);

			cell = row.createCell(2);
			cell.setCellValue(basicData.getSeq());
			cell.setCellStyle(style2);

			cell = row.createCell(3);
			cell.setCellValue(basicData.getBusinessItem());
			cell.setCellStyle(style2);

			cell = row.createCell(4);
			cell.setCellValue(basicData.getIndustry());
			cell.setCellStyle(style2);

			cell = row.createCell(5);
			cell.setCellValue(basicData.getUnitSize());
			cell.setCellStyle(style2);

			cell = row.createCell(6);
			cell.setCellValue(basicData.getGuaranteeNumber());
			cell.setCellStyle(style2);

			cell = row.createCell(7);
			cell.setCellValue(basicData.getPrincipal());
			cell.setCellStyle(style2);

			cell = row.createCell(8);
			cell.setCellValue(basicData.getContactName());
			cell.setCellStyle(style2);

			cell = row.createCell(9);
			cell.setCellValue("(" + basicData.getContactWorkPhoneAreaCode() + ")" + basicData.getContactWorkPhone()
					+ "#" + basicData.getContactWorkPhoneExtension());
			cell.setCellStyle(style2);

			cell = row.createCell(10);
			cell.setCellValue(basicData.getContactPhone());
			cell.setCellStyle(style2);

			cell = row.createCell(11);
			cell.setCellValue(basicData.getEmail());
			cell.setCellStyle(style2);

			cell = row.createCell(12);
			cell.setCellValue(basicData.getEmployeeNumber());
			cell.setCellStyle(style2);

			cell = row.createCell(13);
			cell.setCellValue(basicData.getParticipateNumber());
			cell.setCellStyle(style2);
		}

		String filename = "聯合辦理單位清冊";

		// 清空response
		response.reset();

		// 設置response的Header
		response.setHeader("Content-Disposition", "attachment;filename="

				+ new String(filename.getBytes(), "iso8859-1") + ".xlsx");

		// excel寫入輸出流
		wb.write(response.getOutputStream());

		OutputStream toClient = new BufferedOutputStream(

				response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=utf-8");

		toClient.flush();
		toClient.close();
		wb.close();
	}

	@RequestMapping(value = "/u01_file_text")
	public String u01_file_text(HttpServletRequest request, Model model, AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		setModel(session.getId(), model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		base.setCaseType("C");
		AdvancedAgeBase nbase = selectAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);

		// userinfo
		UserInfo userInfo = new UserInfo();
//				userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------

		// ------申請表 start------
		apply = selectAdvancedAgeRetirementReemploymentApply(apply);
		model.addAttribute("apply", apply);
		// ------申請表 end--------
		// 負責人
		try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		} catch (JSONException e) {
			logger.warn(e.getMessage());
		}

		model.addAttribute("mailDomain", mailDomain);
		model.addAttribute("date", getROCDate());
		// 信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("C");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		return "u01/file_text";
	}

	@RequestMapping(value = "/u02")
	public String u02(HttpServletRequest request, Model model, AdvancedAgeBase base, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
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
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			base.setCaseStatus("3、4、8");
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 查詢資料
		base.setCaseType("C");
		jsonArray = selectAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
//							List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "u02/u02";
	}

	@RequestMapping(value = "/u02_1")
	public String u02_1(HttpServletRequest request, Model model, AdvancedAgeBase base,
			AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		model.addAttribute("base", base);
		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//						userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			model.addAttribute("apply", apply);
			model.addAttribute("companyAttributes", parseCompanyAttributes(apply.getCompanyAttributes()));
			// ------申請表 end--------
			// 負責人
			try {
				CompanyInfo cinfo = new CompanyInfo();
				cinfo.setSeq(base.getSeq());
				model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			} catch (JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------行業別列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
			List<Object> list = jsonArray.toList();
			model.addAttribute("industryList", list);
			// ------行業別列表 end------

			// ------縣市列表 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getCityList", ""));
			list = jsonArray.toList();
			model.addAttribute("cityList", list);
			// ------縣市列表 end----

			// ------鄉鎮市區 start----
			jsonArray = new JSONArray(api.httpPost(ip + "getAreaList?cityCode=" + apply.getContactCity(), ""));
			list = jsonArray.toList();
			model.addAttribute("areaList", list);
			// ------鄉鎮市區 end----
			// ------計畫表 start------
			AdvancedAgeRetirementReemploymentPlan plan = new AdvancedAgeRetirementReemploymentPlan();
			if (apply.getId() != null) {
				plan.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				plan = selectAdvancedAgeRetirementReemploymentPlan(plan);
				model.addAttribute("subsidyType", parseSubsidyType(plan.getSubsidyType()));
				model.addAttribute("plan", plan);
			}
			// ------計畫表 end--------
			// ------計畫受益人員名單 start------
			AdvancedAgeRetirementReemploymentBenefitList benefitList = new AdvancedAgeRetirementReemploymentBenefitList();
			if (plan.getId() != null) {
				benefitList.setAdvancedAgeRetirementReemploymentPlanId(plan.getId());
				model.addAttribute("benefitListSize",
						selectAdvancedAgeRetirementReemploymentBenefitLists(benefitList).toList().size());
			}
			// ------計畫受益人員名單 end--------
			// ------計畫受益人員名單 start------
			AdvancedAgeRetirementReemploymentExpenditure expenditure = new AdvancedAgeRetirementReemploymentExpenditure();
			if (apply.getId() != null) {
				expenditure.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = selectAdvancedAgeRetirementReemploymentExpenditures(
						expenditure);
				model.addAttribute("expenditureListSize", expenditureList.size());
				model.addAttribute("expenditureListSum", sumsOfExpenditure(expenditureList));
				model.addAttribute("expenditureListAmountsSum", sumsOfExpenditureAmounts(expenditureList));
			}
			// ------計畫受益人員名單 end--------
			// ------聯合辦理單位授權 start------
			AdvancedAgeRetirementReemploymentBasicData basicData = new AdvancedAgeRetirementReemploymentBasicData();
			if (apply.getId() != null) {
				basicData.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = selectAdvancedAgeRetirementReemploymentBasicDatas(
						basicData);
				model.addAttribute("basicDataListSize", basicDataList.size());
			}
			// ------聯合辦理單位授權 end--------
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("C");
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
		return "u02/u02_1";
	}

	@RequestMapping(value = "/v01")
	public String v01(HttpServletRequest request, Model model, Pagination pagination, AdvancedAgeBase base) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
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
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			base.setCaseStatus("5、6、7");
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				base.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 查詢資料
		base.setFileStatus("4");// 附件通過
		base.setCaseType("C");
		jsonArray = selectAdvancedAgeBase(base);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
//							List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("baseList", pageArray.toList());
		return "v01/v01";
	}

	@RequestMapping(value = "/v01_1")
	public String v01_1(HttpServletRequest request, Model model, AdvancedAgeBase base,
			AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		if (apply.getApplyYear() != null) {
			// ------基礎表 start------
			base.setYear(apply.getApplyYear());
			base.setCaseType("C");
			model.addAttribute("base", selectAdvancedAgeBase(base).toList());
			// ------基礎表 end------
			// ------人員列表 start------
			UserInfo userInfo = new UserInfo();
//									userInfo.setUnit(nbase.getVerifyUnit());
			model.addAttribute("userList", selectUserInfo(userInfo).toList());
			// ------人員列表 end------
			// ------單位列表 start------
			model.addAttribute("unitList", getUnit().toList());
			// ------單位列表 end------
			// ------申請表 start------
			apply = selectAdvancedAgeRetirementReemploymentApply(apply);
			model.addAttribute("apply", apply);
			// ------申請表 end--------
			// 負責人
			try {
				CompanyInfo cinfo = new CompanyInfo();
				cinfo.setSeq(base.getSeq());
				model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
			} catch (JSONException e) {
				logger.warn(e.getMessage());
			}
			// ------成果報告 start------
			AdvancedAgeRetirementReemploymentResult result = new AdvancedAgeRetirementReemploymentResult();
			if (apply.getId() != null) {
				result.setAdvancedAgeRetirementReemploymentApplyId(apply.getId());
				result.setSeq(apply.getSeq());
				result = selectAdvancedAgeRetirementReemploymentResult(result);
				model.addAttribute("result", result);
			}
			// ------成果報告 end--------
			// ------停止補助名單 start------
			BlackList blackList = new BlackList();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = sdf.format(new Date());
			blackList.setSeq(base.getSeq());
			blackList.setUnit("");
			blackList.setBanStartDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			blackList.setBanEndDate(Integer.valueOf(todayDate.substring(0, 4)) - 1911 + todayDate.substring(4));
			jsonArray = selectBlackList(blackList);
			model.addAttribute("blackList", jsonArray.toList());
			// ------停止補助名單 end--------
			// ------實地查核 start------
			SiteInspection siteInspection = new SiteInspection();
			siteInspection.setSeq(base.getSeq());
			siteInspection.setResult("3");
			siteInspection.setUnit("");
			siteInspection.setCaseType("C");
			jsonArray = selectSiteInspection(siteInspection);
			model.addAttribute("siteInspection", jsonArray.toList());
			// ------實地查核 end------
		}
		return "v01/v01_1";
	}

	@RequestMapping(value = "/v01File")
	public String v01File(HttpServletRequest request, Model model, AdvancedAgeRetirementReemploymentApply apply) {
		session = request.getSession();
		setModel(session.getId(), model);
		AdvancedAgeBase base = new AdvancedAgeBase();
		base.setYear(apply.getApplyYear());
		base.setSeq(apply.getSeq());
		base.setId(apply.getId());
		base.setCaseType("C");
		AdvancedAgeBase nbase = selectAdvancedAgeBaseFileStatusRecord(base);
		model.addAttribute("base", nbase);

		// userinfo
		UserInfo userInfo = new UserInfo();
//				userInfo.setUnit(nbase.getVerifyUnit());
		model.addAttribute("userList", selectUserInfo(userInfo).toList());
		model.addAttribute("unitList", getUnit().toList());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------

		// ------申請表 start------
		apply = selectAdvancedAgeRetirementReemploymentApply(apply);
		model.addAttribute("apply", apply);
		// ------申請表 end--------

		// 負責人
		try {
			CompanyInfo cinfo = new CompanyInfo();
			cinfo.setSeq(base.getSeq());
			model.addAttribute("companyInfoData", selectCompanyInfoData(cinfo));
		} catch (JSONException e) {
			logger.warn(e.getMessage());
		}

		// 文件
		attachment = new Attachment();

		// 本計畫核准函影本
		attachment.setFileBelong("BA");
		attachment.setFileBelongId(nbase.getId());
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

		model.addAttribute("mailDomain", mailDomain);
		model.addAttribute("date", getROCDate());

		// 信件歷史紀錄
		MailRecord mailRecord = new MailRecord();
		mailRecord.setAdvancedAgeBaseId(nbase.getId());
		mailRecord.setMailType("B");
		model.addAttribute("mailRecord", selectMailRecord(mailRecord).toList());
		return "v01/file";
	}

	@RequestMapping(value = "/w01")
	public String w01(HttpServletRequest request, Model model, BlackList blackList, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		model.addAttribute("blackList", blackList);
		model.addAttribute("unitList", getUnit().toList());
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				blackList.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 所有資料
		jsonArray = selectBlackList(blackList);
		JSONArray pageArray = new JSONArray();

		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("blackListData", pageArray.toList());
		return "w01/w01";
	}

	@RequestMapping(value = "/w01_1")
	public String w01_1(HttpServletRequest request, Model model, BlackList blackList, String searchSeq,
			String searchUnit, String searchBanStartDate, String searchBanEndDate) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		// userinfo
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
		// 文件
		attachment = new Attachment();
		// 公文
		attachment.setFileBelong("BL");
		attachment.setFileBelongId(blackList.getId());
		attachment.setFileType("blackList");
		model.addAttribute("blackListAttachment", selectFiles(attachment).toList());
		return "w01/w01_1";
	}

	@RequestMapping(value = "/w01_02")
	public String w01_02(HttpServletRequest request, Model model, AdvancedAgeBase base) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		if (base.getSeq() != null && !base.getSeq().equals("")) {
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectCTypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "w01/w01_02";
	}

	@RequestMapping(value = "/w02")
	public String w02(HttpServletRequest request, Model model, SiteInspection siteInspection, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		model.addAttribute("siteInspection", siteInspection);
		model.addAttribute("unitList", getUnit().toList());
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			if (!session.getAttribute(session.getId() + "unit").toString().equals("F"))
				siteInspection.setUnit(session.getAttribute(session.getId() + "unit").toString());
			pagination = new Pagination("1", "10");
		}
		// 所有資料
		siteInspection.setCaseType("C");
		jsonArray = selectSiteInspection(siteInspection);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("siteInspectionData", pageArray.toList());
		return "w02/w02";
	}

	@RequestMapping(value = "/w02_1")
	public String w02_1(HttpServletRequest request, Model model, SiteInspection siteInspection, String searchSeq,
			String searchUnit, String searchResult) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userList", selectUserInfo(userInfo).toList());

		model.addAttribute("searchSeq", searchSeq);
		model.addAttribute("searchResult", searchResult);
		model.addAttribute("searchUnit", searchUnit);
		model.addAttribute("siteInspection", siteInspection);
		model.addAttribute("unitList", getUnit().toList());
		model.addAttribute("siteInspectionData", selectSiteInspectionData(siteInspection));
		// 文件
		attachment = new Attachment();
		// 公文
		attachment.setFileBelong("SI");
		attachment.setFileBelongId(siteInspection.getId());
		attachment.setFileType("siteInspection");
		model.addAttribute("siteInspectionAttachment", selectFiles(attachment).toList());

		// 其他文件
		attachment.setFileType("siteInspectionOther");
		model.addAttribute("siteInspectionOtherAttachment", selectFiles(attachment).toList());
		return "w02/w02_1";
	}

	@RequestMapping(value = "/w02_02")
	public String w02_02(HttpServletRequest request, Model model, AdvancedAgeBase base) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		if (base.getSeq() != null && !base.getSeq().equals("")) {
			base.setYear(applyYear);
			model.addAttribute("searchBase", selectCTypeAdvancedAgeBaseData(base));
		}
		model.addAttribute("base", base);
		return "w02/w02_02";
	}
	
	@RequestMapping(value = "/y01")
	public String y01(HttpServletRequest request,String account){ 
		return "y01/y01";
	}

	@RequestMapping(value = "/y02")
	public String y02(HttpServletRequest request, Model model,AdvancedAgeBase base,Pagination pagination) {
		session = request.getSession();
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		// ------行業別列表 start----
		jsonArray = new JSONArray(api.httpPost(ip + "getIndustryList", ""));
		List<Object> list = jsonArray.toList();
		model.addAttribute("industryList", list);
		// ------行業別列表 end------
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("C");
		
		if(pagination.getNumbersOfPage()==null)
		{
			base.setYear(applyYear);
			pagination = new Pagination("1","10");
		}
		jsonArray = selectCaseStatistics3(base);
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
		return "y02/y02";
	}

	@RequestMapping(value = "/y03")
	public String y03(HttpServletRequest request, Model model,AdvancedAgeBase base,Pagination pagination) {
		session = request.getSession();
		setModel(session.getId(), model);
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("C");
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
		return "y03/y03";
	}

	@RequestMapping(value = "/y04")
	public String y04(HttpServletRequest request, Model model,AdvancedAgeBase base,Pagination pagination) {
		session = request.getSession();
		setModel(session.getId(), model);
		base.setCaseType("C");
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
		return "y04/y04";
	}

	@RequestMapping(value = "/y05")
	public String y05(HttpServletRequest request, Model model,AdvancedAgeBase base,Pagination pagination) {
		session = request.getSession();
		setModel(session.getId(), model);
		dateFormatUtil = new DateFormatUtil(new Date());
		// ------單位列表 start------
		model.addAttribute("unitList", getUnit().toList());
		// ------單位列表 end------
		base.setCaseType("C");
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
		return "y05/y05";
	}

	@RequestMapping(value = "/z01")
	public String z01(HttpServletRequest request, Model model, UserInfo userInfo) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		userInfo.setAccount(session.getAttribute(session.getId() + "account").toString());
		model.addAttribute("userInfoData", selectUserInfoData(userInfo));
		model.addAttribute("unitList", getUnit().toList());
		return "z01/z01";
	}

	@RequestMapping(value = "/z02")
	public String z02(HttpServletRequest request, Model model, UserInfo userInfo, String userAccount,
			Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		userInfo.setAccount(userAccount);
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			pagination = new Pagination("1", "10");
		}
		// 所有資料
		jsonArray = selectUserInfo(userInfo);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("userInfoData", pageArray.toList());

		model.addAttribute("searchUserInfo", userInfo);

		model.addAttribute("unitList", getUnit().toList());
		return "z02/z02";
	}

	@RequestMapping(value = "/z02_1")
	public String z02_1(HttpServletRequest request, Model model, UserInfo userInfo, String editAccount) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		ObjectMapper objectMapper = new ObjectMapper();
		if (userInfo.getUnit() == null) {
			userInfo.setAccount(editAccount);
			JSONObject jsondata = selectUserInfoData(userInfo);

			try {
				userInfo = objectMapper.readValue(jsondata.toString(), UserInfo.class);
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			userInfo.setPassword(AesUtil.decrypt(userInfo.getPassword().replaceAll(" ", "+").getBytes()));

			model.addAttribute("unitList", getUnit().toList());
			model.addAttribute("userInfoData", userInfo);
			return "z02/z02_1";
		} else {

			String json = "";

			userInfo.setAccount(editAccount);
			userInfo.setPassword(AesUtil.encrypt(userInfo.getPassword()));
			try {
				json = objectMapper.writeValueAsString(userInfo);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}

			api.httpPost(ip + "editUserInfoData", json);
			return "z02/z02";
		}
	}

	@RequestMapping(value = "/z02_02")
	public String z02_02(HttpServletRequest request, Model model, UserInfo userInfo, String userAccount) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		model.addAttribute("unitList", getUnit().toList());
		if (userInfo.getUnit() != null) {
			userInfo.setAccount(userAccount);
			userInfo.setPassword(AesUtil.encrypt(userInfo.getPassword()));
			ObjectMapper objectMapper = new ObjectMapper();
			String json = "";
			try {
				json = objectMapper.writeValueAsString(userInfo);
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
			api.httpPost(ip + "addUserInfo", json);
			return "z02/z02";
		} else {
			return "z02/z02_02";
		}
	}

	@RequestMapping(value = "/z03")
	public String z03(HttpServletRequest request, Model model, UserInfo userInfo) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		FunctionList functionList = new FunctionList();
		functionList.setCaseType("C");
		model.addAttribute("functionList", selectFunctionList(functionList).toList());
		return "z03/z03";
	}

	@RequestMapping(value = "/z04")
	public String z04(HttpServletRequest request, Model model, UserLoginRecord userLoginRecord, String loginStartDate,
			String loginEndDate, Pagination pagination) {
		session = request.getSession();
		if (session == null || !request.isRequestedSessionIdValid()
				|| session.getAttribute(session.getId() + "account") == null) {
			return "redirect:/login";
		}
		setModel(session.getId(), model);
		// 初始狀態查詢
		if (pagination.getNumbersOfPage() == null) {
			pagination = new Pagination("1", "10");
		}
		// 所有資料
		jsonArray = selectUserLoginRecord(userLoginRecord, loginStartDate, loginEndDate);
		JSONArray pageArray = new JSONArray();
		pagination.setNums(jsonArray.length());
		for (int i = 0; i < pagination.getNumbersOfPage(); i++) {
			int index = pagination.getNumbersOfPage() * (pagination.getPage() - 1) + i;
			if (index < jsonArray.length()) {
				pageArray.put(jsonArray.get(index));
			}
		}

		// 分頁資料
		model.addAttribute("pagination", pagination);
		model.addAttribute("userLoginRecordDate", pageArray.toList());

		model.addAttribute("userLoginRecord", userLoginRecord);
		model.addAttribute("loginStartDate", loginStartDate);
		model.addAttribute("loginEndDate", loginEndDate);
		model.addAttribute("unitList", getUnit().toList());
		return "z04/z04";
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

	public JSONArray selectBlackList(BlackList blackList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectBlackList", json));
		return array;
	}

	public JSONObject selectBlackListData(BlackList blackList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(blackList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "selectBlackListData", json));
		return object;
	}

	public JSONArray selectSiteInspection(SiteInspection siteInspection) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectSiteInspection", json));
		return array;
	}

	public JSONObject selectSiteInspectionData(SiteInspection siteInspection) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(siteInspection);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "selectSiteInspectionData", json));
		return object;
	}

	public List<AdvancedAgeRetirementReemploymentBasicData> selectAdvancedAgeRetirementReemploymentBasicDatas(
			AdvancedAgeRetirementReemploymentBasicData basicData) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(basicData);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsonArray = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentBasicDatas", json);
		List<AdvancedAgeRetirementReemploymentBasicData> basicDataList = new ArrayList<>();
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
		}
		return basicDataList;
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
		List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList = new ArrayList<>();
		if (!"[]".equals(jsonArray)) {
			try {
				expenditureList = objectMapper.readValue(jsonArray,
						new TypeReference<List<AdvancedAgeRetirementReemploymentExpenditure>>() {
						});
			} catch (JsonMappingException e) {
				logger.warn(e.getMessage());
			} catch (JsonProcessingException e) {
				logger.warn(e.getMessage());
			}
		}
		return expenditureList;
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

	public AdvancedAgeRetirementReemploymentPlan selectAdvancedAgeRetirementReemploymentPlan(
			AdvancedAgeRetirementReemploymentPlan plan) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeRetirementReemploymentPlan searchPlan = new AdvancedAgeRetirementReemploymentPlan();
		try {
			json = objectMapper.writeValueAsString(plan);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeRetirementReemploymentPlan", json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchPlan = mapper.readValue(jsondata, AdvancedAgeRetirementReemploymentPlan.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchPlan;
	}

	public JSONArray selectAdvancedAgeBaseFileStatus(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeBaseFileStatus", json));
		return array;
	}

	public JSONArray selectCTypeAdvancedAgeBaseFileStatus(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCTypeAdvancedAgeBaseFileStatus", json));
		return array;
	}

	public AdvancedAgeBase selectAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectAdvancedAgeBaseFileStatusRecord", json);
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
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchApply = mapper.readValue(jsondata, AdvancedAgeRetirementReemploymentApply.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchApply;
	}

	public JSONArray selectAdvancedAgeBase(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectAdvancedAgeBase", json));
		return array;
	}

	public AdvancedAgeBase selectCTypeAdvancedAgeBaseData(AdvancedAgeBase base) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		AdvancedAgeBase searchBase = new AdvancedAgeBase();
		try {
			json = objectMapper.writeValueAsString(base);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		String jsondata = api.httpPost(ip + "selectCTypeAdvancedAgeBaseData", json);
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
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (!jsondata.equals(""))
				searchResult = mapper.readValue(jsondata, AdvancedAgeRetirementReemploymentResult.class);
		} catch (JsonMappingException e) {
			logger.warn(e.getMessage());
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		return searchResult;
	}

	public JSONArray selectCaseStatistics3(AdvancedAgeBase advancedAgeBase) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(advancedAgeBase);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectCaseStatistics3", json));
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

	public void setModel(String sid, Model model) {
		model.addAttribute("id", session.getAttribute(sid + "id"));
		model.addAttribute("account", session.getAttribute(sid + "account"));
		model.addAttribute("name", session.getAttribute(sid + "name"));
		model.addAttribute("unitName", session.getAttribute(sid + "unitName"));
		model.addAttribute("unit", session.getAttribute(sid + "unit"));
		model.addAttribute("jurisdiction", session.getAttribute(sid + "jurisdiction"));
		model.addAttribute("functionPermission", session.getAttribute(sid + "functionPermission"));
		model.addAttribute("functionPermission2", session.getAttribute(sid + "functionPermission2"));
		model.addAttribute("functionPermission3", session.getAttribute(sid + "functionPermission3"));
	}

	public JSONArray selectUserInfo(UserInfo userInfo) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectUserInfo", json));
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

	public JSONObject selectUserInfoData(UserInfo userInfo) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(userInfo);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONObject object = new JSONObject(api.httpPost(ip + "selectUserInfoData", json));
		return object;
	}

	public JSONArray getUnit() {
		return new JSONArray(api.httpPost(ip + "getUnit", ""));
	}

	public JSONArray selectMailRecord(MailRecord mailRecord) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(mailRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectMailRecord", json));
		return array;
	}

	public JSONArray selectUserLoginRecord(UserLoginRecord userLoginRecord, String loginStartDate,
			String loginEndDate) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {

			json = objectMapper.writeValueAsString(userLoginRecord);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		json = json.substring(0, json.length() - 1) + ",\"loginStartDate\":"
				+ (loginStartDate == null || loginStartDate.equals("") ? "" : "\"" + loginStartDate + "\"")
				+ ",\"loginEndDate\":"
				+ (loginEndDate == null || loginEndDate.equals("") ? "" : "\"" + loginEndDate + "\"") + "}";
		JSONArray array = new JSONArray(api.httpPost(ip + "selectUserLoginRecord", json));
		return array;
	}

	public JSONArray selectFunctionList(FunctionList functionList) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(functionList);
		} catch (JsonProcessingException e) {
			logger.warn(e.getMessage());
		}
		JSONArray array = new JSONArray(api.httpPost(ip + "selectFunctionList", json));
		return array;
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

	public String getROCDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int applyYear = Integer.valueOf(sdf.format(date).substring(0, 4)) - 1911;
		return applyYear + "年" + sdf.format(date).substring(4, 6) + "月" + sdf.format(date).substring(6, 8) + "日";
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

	public int sumsOfExpenditure(List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList) {
		int sum = 0;
		for (AdvancedAgeRetirementReemploymentExpenditure expenditure : expenditureList) {
			sum += expenditure.getUnitPrice() * expenditure.getAmount();
		}
		return sum;
	}

	public int sumsOfExpenditureAmounts(List<AdvancedAgeRetirementReemploymentExpenditure> expenditureList) {
		int sum = 0;
		for (AdvancedAgeRetirementReemploymentExpenditure expenditure : expenditureList) {
			sum += expenditure.getAmounts();
		}
		return sum;
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
}
