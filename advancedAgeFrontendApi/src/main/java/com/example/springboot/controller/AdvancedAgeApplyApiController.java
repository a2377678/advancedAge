package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationKey;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptKey;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.service.AdvancedAgeApplyEmployedSituationService;
import com.example.springboot.service.AdvancedAgeApplyService;
import com.example.springboot.service.AdvancedAgeBaseService;
import com.example.springboot.service.AdvancedAgeEmploymentListReceiptService;
import com.example.springboot.service.AdvancedAgeEmploymentListService;
import com.example.springboot.service.AdvancedAgePlanService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeApplyApiController { 
	
	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	@Autowired
	AdvancedAgeApplyService advancedAgeApplyService;
	
	@Autowired
	AdvancedAgePlanService advancedAgePlanService;
	
	@Autowired
	AdvancedAgeEmploymentListService advancedAgeEmploymentListService;
	
	@Autowired
	AdvancedAgeEmploymentListReceiptService advancedAgeEmploymentListReceiptService;
	
	@Autowired
	AdvancedAgeApplyEmployedSituationService advancedAgeApplyEmployedSituationService;
	
	AdvancedAgeApplyExample advancedAgeApplyExample;
	
	AdvancedAgeEmploymentListKey advancedAgeEmploymentListKey;
	
	AdvancedAgeEmploymentListExample advancedAgeEmploymentListExample;
	
	AdvancedAgeApplyEmployedSituationKey advancedAgeApplyEmployedSituationKey;
	
	AdvancedAgeApplyEmployedSituationExample advancedAgeApplyEmployedSituationExample;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	AdvancedAgeEmploymentListReceiptKey advancedAgeEmploymentListReceiptKey;
	
	AdvancedAgeEmploymentListReceiptExample advancedAgeEmploymentListReceiptExample;
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	int applyYear=Integer.valueOf(sdf.format(date).substring(0,4))-1911;
	
	@ApiOperation(value = "新增繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/addAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply addAdvancedAgeApply(AdvancedAgeApply apply) {
		apply.setApplyYear(String.valueOf(applyYear));
		if(selectAdvancedAgeApply(apply) == null)
		{
			int a=advancedAgeApplyService.insertSelective(apply);
		}
		else
		{
			apply.setUpdateTime(date);
			int a=advancedAgeApplyService.updateByPrimaryKeySelective(apply);
		}
		return selectAdvancedAgeApply(apply) == null?apply:selectAdvancedAgeApply(apply);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply) {
		
		AdvancedAgeApplyKey key = new AdvancedAgeApplyKey();
		if(apply.getApplyYear() == null || apply.getApplyYear().equals(""))
		{
			key.setApplyYear(String.valueOf(applyYear));
		}else {
			key.setApplyYear(apply.getApplyYear());
		}
		key.setSeq(apply.getSeq());
		return advancedAgeApplyService.selectByPrimaryKey(key);
	}
	
	@ApiOperation(value = "新增繼續僱用高齡者補助計畫書")
	@RequestMapping(value = "/addAdvancedAgePlan", method = RequestMethod.POST)
	public AdvancedAgePlan addAdvancedAgePlan(AdvancedAgePlan plan) {
		advancedAgeApplyExample = new AdvancedAgeApplyExample();
		advancedAgeApplyExample.createCriteria().andIdEqualTo(plan.getAdvancedAgeApplyId());
		plan.setCompanyName(advancedAgeApplyService.selectByExample(advancedAgeApplyExample).get(0).getCompanyName());
		if(selectAdvancedAgePlan(plan) == null)
		{
			advancedAgePlanService.insertSelective(plan);
		}
		else
		{
			if(selectAdvancedAgePlan(plan).getAttachAssistanceMeasures() != null && selectAdvancedAgePlan(plan).getAttachAssistanceMeasures().equals("Y"))
				plan.setAttachAssistanceMeasures("Y");
			if(selectAdvancedAgePlan(plan).getAttachExpectedMeasuresEffectiveness() != null && selectAdvancedAgePlan(plan).getAttachExpectedMeasuresEffectiveness().equals("Y"))
				plan.setAttachExpectedMeasuresEffectiveness("Y");
			if(selectAdvancedAgePlan(plan).getAttachFriendlyMeasures() != null && selectAdvancedAgePlan(plan).getAttachFriendlyMeasures().equals("Y"))
				plan.setAttachFriendlyMeasures("Y");
			advancedAgePlanService.updateByPrimaryKeySelective(plan);
		}
		return selectAdvancedAgePlan(plan) == null?plan:selectAdvancedAgePlan(plan);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助計畫書")
	@RequestMapping(value = "/selectAdvancedAgePlan", method = RequestMethod.POST)
	public AdvancedAgePlan selectAdvancedAgePlan(AdvancedAgePlan plan) {
		return advancedAgePlanService.selectByPrimaryKey(plan.getAdvancedAgeApplyId());
	}
	
	@ApiOperation(value = "新增繼續僱用補助名單")
	@RequestMapping(value = "/addAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList addAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList) {
		if(selectAdvancedAgeEmploymentList(employmentList) == null)
		{
			advancedAgeEmploymentListService.insertSelective(employmentList);
		}
		else
		{
			if(employmentList.getLaborProtectionTime()==null) {
				employmentList.setLaborProtectionTime("");
			}
			else if(employmentList.getOccupationalAccidentProtectionTime()==null) {
				employmentList.setOccupationalAccidentProtectionTime("");
			}
			advancedAgeEmploymentListService.updateByPrimaryKeySelective(employmentList);
		}
		return employmentList;
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList selectAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList) {
		advancedAgeEmploymentListKey = new AdvancedAgeEmploymentListKey();
		advancedAgeEmploymentListKey.setAdvancedAgePlanId(employmentList.getAdvancedAgePlanId());
		advancedAgeEmploymentListKey.setIdentification(employmentList.getIdentification());
		
		return advancedAgeEmploymentListService.selectByPrimaryKey(advancedAgeEmploymentListKey);
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentLists", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentList> selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList employmentList) {
		advancedAgeEmploymentListExample = new AdvancedAgeEmploymentListExample();
		advancedAgeEmploymentListExample.setOrderByClause("id asc");
		advancedAgeEmploymentListExample.createCriteria().andAdvancedAgePlanIdEqualTo(employmentList.getAdvancedAgePlanId());
		
		return advancedAgeEmploymentListService.selectByExample(advancedAgeEmploymentListExample);
	}
	
	@ApiOperation(value = "刪除繼續僱用補助名單")
	@RequestMapping(value = "/delAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList delAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList) {
		if(selectAdvancedAgeEmploymentList(employmentList) != null)
		{
			advancedAgeEmploymentListService.deleteByPrimaryKey(employmentList);
		}
		return employmentList;
	}
	
	@ApiOperation(value = "用 ID 刪除繼續僱用補助名單")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListbyId", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListbyId(AdvancedAgeEmploymentList employmentList) {
		advancedAgeEmploymentListExample = new AdvancedAgeEmploymentListExample();
		advancedAgeEmploymentListExample.createCriteria().andAdvancedAgePlanIdEqualTo(employmentList.getAdvancedAgePlanId());
		System.out.println("del = "+advancedAgeEmploymentListService.deleteByExample(advancedAgeEmploymentListExample));
	}
	
	@ApiOperation(value = "新增繼續僱用補助名單_請領")
	@RequestMapping(value = "/addAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public AdvancedAgeEmploymentListReceipt addAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		if(selectAdvancedAgeEmploymentListReceipt(employmentListReceipt) == null)
		{
			employmentListReceipt.setBaseAllowanceFrequency(0);
			advancedAgeEmploymentListReceiptService.insertSelective(employmentListReceipt);
		}
		else
		{
			if(employmentListReceipt.getLaborProtectionExpiredTime()==null) {
				employmentListReceipt.setLaborProtectionExpiredTime("");
			}
			if(employmentListReceipt.getOccupationalAccidentProtectionExpiredTime()==null) {
				employmentListReceipt.setOccupationalAccidentProtectionExpiredTime("");
			}
			if(employmentListReceipt.getEmploymentMonthStartTime()==null)
			{
				employmentListReceipt.setEmploymentMonthStartTime("");
				employmentListReceipt.setHighMonthNumber(null);
				employmentListReceipt.setLowMonthNumber(null);
			}
			if(employmentListReceipt.getEmploymentMonthEndTime()==null)
			{
				employmentListReceipt.setEmploymentMonthEndTime("");
				employmentListReceipt.setHighMonthNumber(null);
				employmentListReceipt.setLowMonthNumber(null);
			}
			if(employmentListReceipt.getEmploymentHourStartTime()==null)
			{
				employmentListReceipt.setEmploymentHourStartTime("");
				employmentListReceipt.setHighHoursNumber(null);
				employmentListReceipt.setLowHoursNumber(null);
			}
			if(employmentListReceipt.getEmploymentHourEndTime()==null)
			{
				employmentListReceipt.setEmploymentHourEndTime("");
				employmentListReceipt.setHighHoursNumber(null);
				employmentListReceipt.setLowHoursNumber(null);
			}
			advancedAgeEmploymentListReceiptService.updateByPrimaryKeySelective(employmentListReceipt);
		}
		return employmentListReceipt;
	}
	
	@ApiOperation(value = "編輯繼續僱用補助名單_此次請領次數")
	@RequestMapping(value = "/editAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public AdvancedAgeEmploymentListReceipt editAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId());
		AdvancedAgeBase searchBase = advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		
		advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
		advancedAgeEmploymentListReceiptExample.setOrderByClause("id asc");
		advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(0);
		System.out.println("recore freq"+searchBase.getAllowanceFrequencyRecord().split(";").length);
		employmentListReceipt.setBaseAllowanceFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length);
		advancedAgeEmploymentListReceiptService.updateByExampleSelective(employmentListReceipt,advancedAgeEmploymentListReceiptExample);
		
		return employmentListReceipt;
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單_請領(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public AdvancedAgeEmploymentListReceipt selectAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		advancedAgeEmploymentListReceiptKey = new AdvancedAgeEmploymentListReceiptKey();
		advancedAgeEmploymentListReceiptKey.setAdvancedAgeBaseId(employmentListReceipt.getAdvancedAgeBaseId());
		advancedAgeEmploymentListReceiptKey.setSeq(employmentListReceipt.getSeq());
		advancedAgeEmploymentListReceiptKey.setFrequency(employmentListReceipt.getFrequency());
		advancedAgeEmploymentListReceiptKey.setIdentification(employmentListReceipt.getIdentification());
		
		return advancedAgeEmploymentListReceiptService.selectByPrimaryKey(advancedAgeEmploymentListReceiptKey);
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單_請領(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipts", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
		advancedAgeEmploymentListReceiptExample.setOrderByClause("id asc");
		advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andSeqEqualTo(employmentListReceipt.getSeq()).andBaseAllowanceFrequencyEqualTo(0);
		
		return advancedAgeEmploymentListReceiptService.selectByExample(advancedAgeEmploymentListReceiptExample);
	}
	
	@ApiOperation(value = "刪除繼續僱用補助名單_請領")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		if(selectAdvancedAgeEmploymentListReceipt(employmentListReceipt) != null)
		{
			advancedAgeEmploymentListReceiptService.deleteByPrimaryKey(employmentListReceipt);
		}
	}
	
	@ApiOperation(value = "用 ID 刪除繼續僱用補助名單_請領")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListReceiptbyId", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListReceiptbyId(AdvancedAgeEmploymentListReceipt employmentListReceipt) {
		advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
		advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(0);
		System.out.println("del = "+advancedAgeEmploymentListReceiptService.deleteByExample(advancedAgeEmploymentListReceiptExample));
	}
	
	@ApiOperation(value = "新增近3年申請繼續僱用補助人數及留用狀況")
	@RequestMapping(value = "/addAdvancedAgeApplyEmployedSituation", method = RequestMethod.POST)
	public AdvancedAgeApplyEmployedSituation addAdvancedAgeApplyEmployedSituation(AdvancedAgeApplyEmployedSituation employedSituation) {
		if(selectAdvancedAgeApplyEmployedSituation(employedSituation) == null)
		{
			advancedAgeApplyEmployedSituationService.insertSelective(employedSituation);
		}
		else
		{
			advancedAgeApplyEmployedSituationService.updateByPrimaryKeySelective(employedSituation);
		}
		return employedSituation;
	}
	
	@ApiOperation(value = "查詢近3年申請繼續僱用補助人數及留用狀況(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeApplyEmployedSituation", method = RequestMethod.POST)
	public AdvancedAgeApplyEmployedSituation selectAdvancedAgeApplyEmployedSituation(AdvancedAgeApplyEmployedSituation employedSituation) {
		advancedAgeApplyEmployedSituationKey = new AdvancedAgeApplyEmployedSituationKey();
		advancedAgeApplyEmployedSituationKey.setAdvancedAgePlanId(employedSituation.getAdvancedAgePlanId());
		advancedAgeApplyEmployedSituationKey.setIdentification(employedSituation.getIdentification());
		return advancedAgeApplyEmployedSituationService.selectByPrimaryKey(advancedAgeApplyEmployedSituationKey);
	}
	
	@ApiOperation(value = "查詢近3年申請繼續僱用補助人數及留用狀況(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeApplyEmployedSituations", method = RequestMethod.POST)
	public List<AdvancedAgeApplyEmployedSituation> selectAdvancedAgeApplyEmployedSituations(AdvancedAgeApplyEmployedSituation employedSituation) {
		advancedAgeApplyEmployedSituationExample = new AdvancedAgeApplyEmployedSituationExample();
		advancedAgeApplyEmployedSituationExample.createCriteria().andAdvancedAgePlanIdEqualTo(employedSituation.getAdvancedAgePlanId());
		
		return advancedAgeApplyEmployedSituationService.selectByExample(advancedAgeApplyEmployedSituationExample);
	}
	
	
}