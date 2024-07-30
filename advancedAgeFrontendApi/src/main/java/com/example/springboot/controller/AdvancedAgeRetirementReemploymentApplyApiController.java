package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApplyExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApplyKey;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataKey;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListKey;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResultExample;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentApplyService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentBasicDataService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentBenefitListService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentExpenditureService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentPlanService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentResultService;
import com.example.springboot.util.DateFormatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentApplyApiController {

	@Autowired
	AdvancedAgeRetirementReemploymentApplyService advancedAgeRetirementReemploymentApplyService;

	@Autowired
	AdvancedAgeRetirementReemploymentPlanService advancedAgeRetirementReemploymentPlanService;

	@Autowired
	AdvancedAgeRetirementReemploymentBenefitListService advancedAgeRetirementReemploymentBenefitListService;

	@Autowired
	AdvancedAgeRetirementReemploymentExpenditureService advancedAgeRetirementReemploymentExpenditureService;

	@Autowired
	AdvancedAgeRetirementReemploymentBasicDataService advancedAgeRetirementReemploymentBasicDataService;
	
	@Autowired
	AdvancedAgeRetirementReemploymentResultService advancedAgeRetirementReemploymentResultService;
	
	AdvancedAgeRetirementReemploymentApplyExample advancedAgeRetirementReemploymentApplyExample;

	AdvancedAgeRetirementReemploymentBenefitListKey advancedAgeRetirementReemploymentBenefitListKey;

	AdvancedAgeRetirementReemploymentBenefitListExample advancedAgeRetirementReemploymentBenefitListExample;

	AdvancedAgeRetirementReemploymentExpenditure advancedAgeRetirementReemploymentExpenditure;

	AdvancedAgeRetirementReemploymentExpenditureExample advancedAgeRetirementReemploymentExpenditureExample;

	AdvancedAgeRetirementReemploymentBasicDataKey advancedAgeRetirementReemploymentBasicDataKey;
	
	AdvancedAgeRetirementReemploymentBasicDataExample advancedAgeRetirementReemploymentBasicDataExample;

	AdvancedAgeRetirementReemploymentResultExample advancedAgeRetirementReemploymentResultExample;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Value("${api_token}")
	private String apiToken;

	@Value("${applyYear}")
	private String applyYear;
	
	@ApiOperation(value = "新增再就業補助申請書")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentApply", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentApply addAdvancedAgeRetirementReemploymentApply(
			AdvancedAgeRetirementReemploymentApply apply, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		apply.setApplyYear(applyYear);
		if (selectAdvancedAgeRetirementReemploymentApply(apply, token) == null) {
			advancedAgeRetirementReemploymentApplyService.insertSelective(apply);
		} else {
			apply.setUpdateTime(new Date());
			advancedAgeRetirementReemploymentApplyService.updateByPrimaryKeySelective(apply);
		}
		return selectAdvancedAgeRetirementReemploymentApply(apply, token) == null ? apply
				: selectAdvancedAgeRetirementReemploymentApply(apply, token);
	}

	@ApiOperation(value = "查詢再就業補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentApply", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentApply selectAdvancedAgeRetirementReemploymentApply(
			AdvancedAgeRetirementReemploymentApply apply, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		AdvancedAgeRetirementReemploymentApplyKey key = new AdvancedAgeRetirementReemploymentApplyKey();
		if (apply.getApplyYear() == null || apply.getApplyYear().equals("")) {
			key.setApplyYear(applyYear);
		} else {
			key.setApplyYear(apply.getApplyYear());
		}
		key.setSeq(apply.getSeq());
		return advancedAgeRetirementReemploymentApplyService.selectByPrimaryKey(key);
	}

	@ApiOperation(value = "新增再就業補助計畫書")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentPlan", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentPlan addAdvancedAgeRetirementReemploymentPlan(
			AdvancedAgeRetirementReemploymentPlan plan, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		advancedAgeRetirementReemploymentApplyExample = new AdvancedAgeRetirementReemploymentApplyExample();
		advancedAgeRetirementReemploymentApplyExample.createCriteria()
				.andIdEqualTo(plan.getAdvancedAgeRetirementReemploymentApplyId());
		if (selectAdvancedAgeRetirementReemploymentPlan(plan, token) == null) {
			advancedAgeRetirementReemploymentPlanService.insertSelective(plan);
		} else {
			advancedAgeRetirementReemploymentPlanService.updateByPrimaryKeySelective(plan);
		}
		return selectAdvancedAgeRetirementReemploymentPlan(plan, token) == null ? plan
				: selectAdvancedAgeRetirementReemploymentPlan(plan, token);
	}

	@ApiOperation(value = "查詢再就業補助計畫書")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentPlan", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentPlan selectAdvancedAgeRetirementReemploymentPlan(
			AdvancedAgeRetirementReemploymentPlan plan, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		return advancedAgeRetirementReemploymentPlanService
				.selectByPrimaryKey(plan.getAdvancedAgeRetirementReemploymentApplyId());
	}

	@ApiOperation(value = "新增再就業補助計畫人員名單")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBenefitList", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBenefitList addAdvancedAgeRetirementReemploymentBenefitList(
			AdvancedAgeRetirementReemploymentBenefitList benefitList, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		if (selectAdvancedAgeRetirementReemploymentBenefitList(benefitList, token) == null) {
			advancedAgeRetirementReemploymentBenefitListService.insertSelective(benefitList);
		} else {
			advancedAgeRetirementReemploymentBenefitListService.updateByPrimaryKeySelective(benefitList);
		}
		return benefitList;
	}

	@ApiOperation(value = "查詢再就業補助計畫人員名單(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBenefitList", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBenefitList selectAdvancedAgeRetirementReemploymentBenefitList(
			AdvancedAgeRetirementReemploymentBenefitList benefitList, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		advancedAgeRetirementReemploymentBenefitListKey = new AdvancedAgeRetirementReemploymentBenefitListKey();
		advancedAgeRetirementReemploymentBenefitListKey
				.setAdvancedAgeRetirementReemploymentPlanId(benefitList.getAdvancedAgeRetirementReemploymentPlanId());
		advancedAgeRetirementReemploymentBenefitListKey.setIdentification(benefitList.getIdentification());

		return advancedAgeRetirementReemploymentBenefitListService
				.selectByPrimaryKey(advancedAgeRetirementReemploymentBenefitListKey);
	}

	@ApiOperation(value = "查詢再就業補助計畫人員名單(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBenefitLists", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentBenefitList> selectAdvancedAgeRetirementReemploymentBenefitLists(
			AdvancedAgeRetirementReemploymentBenefitList benefitList, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		advancedAgeRetirementReemploymentBenefitListExample = new AdvancedAgeRetirementReemploymentBenefitListExample();
		advancedAgeRetirementReemploymentBenefitListExample.setOrderByClause("id asc");
		advancedAgeRetirementReemploymentBenefitListExample.createCriteria()
				.andAdvancedAgeRetirementReemploymentPlanIdEqualTo(
						benefitList.getAdvancedAgeRetirementReemploymentPlanId());

		return advancedAgeRetirementReemploymentBenefitListService
				.selectByExample(advancedAgeRetirementReemploymentBenefitListExample);
	}

	@ApiOperation(value = "刪除再就業補助計畫人員名單")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBenefitList", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBenefitList delAdvancedAgeRetirementReemploymentBenefitList(
			AdvancedAgeRetirementReemploymentBenefitList benefitList, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		if (selectAdvancedAgeRetirementReemploymentBenefitList(benefitList, token) != null) {
			advancedAgeRetirementReemploymentBenefitListService.deleteByPrimaryKey(benefitList);
		}
		return benefitList;
	}
	
	@ApiOperation(value = "用 Plan ID 刪除再就業補助計畫人員名單")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBenefitListbyPlanId", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentBenefitListbyPlanId(AdvancedAgeRetirementReemploymentBenefitList benefitList,String token) {
		if(token.equals(apiToken))
		{
			advancedAgeRetirementReemploymentBenefitListExample = new AdvancedAgeRetirementReemploymentBenefitListExample();
			advancedAgeRetirementReemploymentBenefitListExample.createCriteria().andAdvancedAgeRetirementReemploymentPlanIdEqualTo(benefitList.getAdvancedAgeRetirementReemploymentPlanId());
			advancedAgeRetirementReemploymentBenefitListService.deleteByExample(advancedAgeRetirementReemploymentBenefitListExample);
		}
		
	}

	@ApiOperation(value = "新增再就業補助計畫_經費概算表")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentExpenditure", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentExpenditure addAdvancedAgeRetirementReemploymentExpenditure(
			AdvancedAgeRetirementReemploymentExpenditure expenditure, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		if (selectAdvancedAgeRetirementReemploymentExpenditure(expenditure, token) == null) {
			advancedAgeRetirementReemploymentExpenditureService.insertSelective(expenditure);
		} else {
			advancedAgeRetirementReemploymentExpenditureService.updateByPrimaryKeySelective(expenditure);
		}
		return expenditure;
	}

	@ApiOperation(value = "查詢再就業補助計畫_經費概算表(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentExpenditure", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentExpenditure selectAdvancedAgeRetirementReemploymentExpenditure(
			AdvancedAgeRetirementReemploymentExpenditure expenditure, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		return advancedAgeRetirementReemploymentExpenditureService.selectByPrimaryKey(expenditure.getId());
	}

	@ApiOperation(value = "查詢再就業補助計畫_經費概算表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentExpenditures", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentExpenditure> selectAdvancedAgeRetirementReemploymentExpenditures(
			AdvancedAgeRetirementReemploymentExpenditure expenditure, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		advancedAgeRetirementReemploymentExpenditureExample = new AdvancedAgeRetirementReemploymentExpenditureExample();
		advancedAgeRetirementReemploymentExpenditureExample.setOrderByClause("id asc");
		advancedAgeRetirementReemploymentExpenditureExample.createCriteria()
				.andAdvancedAgeRetirementReemploymentApplyIdEqualTo(
						expenditure.getAdvancedAgeRetirementReemploymentApplyId());

		return advancedAgeRetirementReemploymentExpenditureService
				.selectByExample(advancedAgeRetirementReemploymentExpenditureExample);
	}

	@ApiOperation(value = "刪除再就業補助計畫_經費概算表")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentExpenditure", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentExpenditure delAdvancedAgeRetirementReemploymentExpenditure(
			AdvancedAgeRetirementReemploymentExpenditure expenditure, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		if (selectAdvancedAgeRetirementReemploymentExpenditure(expenditure, token) != null) {
			advancedAgeRetirementReemploymentExpenditureService.deleteByPrimaryKey(expenditure.getId());
		}
		return expenditure;
	}
	
	@ApiOperation(value = "用 Apply ID 刪除再就業補助計畫_經費概算表")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentExpenditurebyApplyId", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentExpenditurebyApplyId(AdvancedAgeRetirementReemploymentExpenditure expenditure,String token) {
		if(token.equals(apiToken))
		{
			advancedAgeRetirementReemploymentExpenditureExample = new AdvancedAgeRetirementReemploymentExpenditureExample();
			advancedAgeRetirementReemploymentExpenditureExample.createCriteria().andAdvancedAgeRetirementReemploymentApplyIdEqualTo(expenditure.getAdvancedAgeRetirementReemploymentApplyId());
			advancedAgeRetirementReemploymentExpenditureService.deleteByExample(advancedAgeRetirementReemploymentExpenditureExample);
		}
		
	}

	@ApiOperation(value = "新增再就業補助計畫_聯合辦理_基本資料表")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentBasicData", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBasicData addAdvancedAgeRetirementReemploymentExpenditure(
			AdvancedAgeRetirementReemploymentBasicData basicData, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		if (selectAdvancedAgeRetirementReemploymentBasicData(basicData, token) == null) {
			advancedAgeRetirementReemploymentBasicDataService.insertSelective(basicData);
		} else {
			advancedAgeRetirementReemploymentBasicDataService.updateByPrimaryKeySelective(basicData);
		}
		return basicData;
	}

	@ApiOperation(value = "查詢再就業補助計畫_聯合辦理_基本資料表(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBasicData", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBasicData selectAdvancedAgeRetirementReemploymentBasicData(
			AdvancedAgeRetirementReemploymentBasicData basicData, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		
		return advancedAgeRetirementReemploymentBasicDataService
				.selectByPrimaryKey(basicData);
	}

	@ApiOperation(value = "查詢再就業補助計畫_聯合辦理_基本資料表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBasicDataList", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentBasicData> selectAdvancedAgeRetirementReemploymentBasicDataList(
			AdvancedAgeRetirementReemploymentBasicData basicData, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		advancedAgeRetirementReemploymentBasicDataExample = new AdvancedAgeRetirementReemploymentBasicDataExample();
		advancedAgeRetirementReemploymentBasicDataExample.setOrderByClause("id asc");
		advancedAgeRetirementReemploymentBasicDataExample.createCriteria()
				.andAdvancedAgeRetirementReemploymentApplyIdEqualTo(
						basicData.getAdvancedAgeRetirementReemploymentApplyId());

		return advancedAgeRetirementReemploymentBasicDataService
				.selectByExample(advancedAgeRetirementReemploymentBasicDataExample);
	}
	
	@ApiOperation(value = "刪除再就業補助計畫_聯合辦理_基本資料表")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBasicData", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentBasicData delAdvancedAgeRetirementReemploymentBasicData(
			AdvancedAgeRetirementReemploymentBasicData basicData, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}

		if (selectAdvancedAgeRetirementReemploymentBasicData(basicData, token) != null) {
			advancedAgeRetirementReemploymentBasicDataService.deleteByPrimaryKey(basicData);
		}
		return basicData;
	}
	
	@ApiOperation(value = "用 Apply ID 刪除再就業補助計畫_聯合辦理_基本資料表")
	@RequestMapping(value = "/delAdvancedAgeRetirementReemploymentBasicDatabyApplyId", method = RequestMethod.POST)
	public void delAdvancedAgeRetirementReemploymentBasicDatabyApplyId(AdvancedAgeRetirementReemploymentBasicData basicData,String token) {
		if(token.equals(apiToken))
		{
			advancedAgeRetirementReemploymentBasicDataExample = new AdvancedAgeRetirementReemploymentBasicDataExample();
			advancedAgeRetirementReemploymentBasicDataExample.createCriteria().andAdvancedAgeRetirementReemploymentApplyIdEqualTo(basicData.getAdvancedAgeRetirementReemploymentApplyId());
			advancedAgeRetirementReemploymentBasicDataService.deleteByExample(advancedAgeRetirementReemploymentBasicDataExample);
		}
		
	}
	
	@ApiOperation(value = "新增再就業補助計畫_成果報告")
	@RequestMapping(value = "/addAdvancedAgeRetirementReemploymentResult", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentResult addAdvancedAgeRetirementReemploymentResult(
			AdvancedAgeRetirementReemploymentResult result, String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		if (selectAdvancedAgeRetirementReemploymentResult(result, token) == null) {
			advancedAgeRetirementReemploymentResultService.insertSelective(result);
		} else {
			advancedAgeRetirementReemploymentResultService.updateByPrimaryKeySelective(result);
		}
		return result;
	}

	@ApiOperation(value = "查詢再就業補助計畫_成果報告(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentResult", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentResult selectAdvancedAgeRetirementReemploymentResult(AdvancedAgeRetirementReemploymentResult result,
			String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		return advancedAgeRetirementReemploymentResultService.selectByPrimaryKey(result);
	}
}
