package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/addAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply addAdvancedAgeApply(AdvancedAgeApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		apply.setApplyYear(String.valueOf(applyYear));
		if(selectAdvancedAgeApply(apply,token) == null)
		{
			advancedAgeApplyService.insertSelective(apply);
		}
		else
		{
			apply.setUpdateTime(date);
			advancedAgeApplyService.updateByPrimaryKeySelective(apply);
		}
		return selectAdvancedAgeApply(apply,token) == null?apply:selectAdvancedAgeApply(apply,token);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
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
	public AdvancedAgePlan addAdvancedAgePlan(AdvancedAgePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeApplyExample = new AdvancedAgeApplyExample();
		advancedAgeApplyExample.createCriteria().andIdEqualTo(plan.getAdvancedAgeApplyId());
		plan.setCompanyName(advancedAgeApplyService.selectByExample(advancedAgeApplyExample).get(0).getCompanyName());
		if(selectAdvancedAgePlan(plan,token) == null)
		{
			advancedAgePlanService.insertSelective(plan);
		}
		else
		{
			if(selectAdvancedAgePlan(plan,token).getAttachAssistanceMeasures() != null && selectAdvancedAgePlan(plan,token).getAttachAssistanceMeasures().equals("Y"))
				plan.setAttachAssistanceMeasures("Y");
			if(selectAdvancedAgePlan(plan,token).getAttachExpectedMeasuresEffectiveness() != null && selectAdvancedAgePlan(plan,token).getAttachExpectedMeasuresEffectiveness().equals("Y"))
				plan.setAttachExpectedMeasuresEffectiveness("Y");
			if(selectAdvancedAgePlan(plan,token).getAttachFriendlyMeasures() != null && selectAdvancedAgePlan(plan,token).getAttachFriendlyMeasures().equals("Y"))
				plan.setAttachFriendlyMeasures("Y");
			advancedAgePlanService.updateByPrimaryKeySelective(plan);
		}
		return selectAdvancedAgePlan(plan,token) == null?plan:selectAdvancedAgePlan(plan,token);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助計畫書")
	@RequestMapping(value = "/selectAdvancedAgePlan", method = RequestMethod.POST)
	public AdvancedAgePlan selectAdvancedAgePlan(AdvancedAgePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return advancedAgePlanService.selectByPrimaryKey(plan.getAdvancedAgeApplyId());
	}
	
	@ApiOperation(value = "新增繼續僱用補助名單")
	@RequestMapping(value = "/addAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList addAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectAdvancedAgeEmploymentList(employmentList,token) == null)
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
	public AdvancedAgeEmploymentList selectAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeEmploymentListKey = new AdvancedAgeEmploymentListKey();
		advancedAgeEmploymentListKey.setAdvancedAgePlanId(employmentList.getAdvancedAgePlanId());
		advancedAgeEmploymentListKey.setIdentification(employmentList.getIdentification());
		
		return advancedAgeEmploymentListService.selectByPrimaryKey(advancedAgeEmploymentListKey);
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentLists", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentList> selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeEmploymentListExample = new AdvancedAgeEmploymentListExample();
		advancedAgeEmploymentListExample.setOrderByClause("id asc");
		advancedAgeEmploymentListExample.createCriteria().andAdvancedAgePlanIdEqualTo(employmentList.getAdvancedAgePlanId());
		
		return advancedAgeEmploymentListService.selectByExample(advancedAgeEmploymentListExample);
	}
	
	@ApiOperation(value = "刪除繼續僱用補助名單")
	@RequestMapping(value = "/delAdvancedAgeEmploymentList", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList delAdvancedAgeEmploymentList(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectAdvancedAgeEmploymentList(employmentList,token) != null)
		{
			advancedAgeEmploymentListService.deleteByPrimaryKey(employmentList);
		}
		return employmentList;
	}
	
	@ApiOperation(value = "用 ID 刪除繼續僱用補助名單")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListbyId", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListbyId(AdvancedAgeEmploymentList employmentList,String token) {
		if(token.equals(apiToken))
		{
			advancedAgeEmploymentListExample = new AdvancedAgeEmploymentListExample();
			advancedAgeEmploymentListExample.createCriteria().andAdvancedAgePlanIdEqualTo(employmentList.getAdvancedAgePlanId());
			advancedAgeEmploymentListService.deleteByExample(advancedAgeEmploymentListExample);
		}
		
	}
	
	@ApiOperation(value = "新增繼續僱用補助名單_請領")
	@RequestMapping(value = "/addAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public AdvancedAgeEmploymentListReceipt addAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectAdvancedAgeEmploymentListReceipt(employmentListReceipt,token) == null)
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
	public AdvancedAgeEmploymentListReceipt editAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId());
		AdvancedAgeBase searchBase = advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		
		advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
		advancedAgeEmploymentListReceiptExample.setOrderByClause("id asc");
		advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(0);
		employmentListReceipt.setBaseAllowanceFrequency(searchBase.getAllowanceFrequencyRecord().split(";").length);
		advancedAgeEmploymentListReceiptService.updateByExampleSelective(employmentListReceipt,advancedAgeEmploymentListReceiptExample);
		
		return employmentListReceipt;
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單_請領(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public AdvancedAgeEmploymentListReceipt selectAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeEmploymentListReceiptKey = new AdvancedAgeEmploymentListReceiptKey();
		advancedAgeEmploymentListReceiptKey.setAdvancedAgeBaseId(employmentListReceipt.getAdvancedAgeBaseId());
		advancedAgeEmploymentListReceiptKey.setSeq(employmentListReceipt.getSeq());
		advancedAgeEmploymentListReceiptKey.setFrequency(employmentListReceipt.getFrequency());
		advancedAgeEmploymentListReceiptKey.setIdentification(employmentListReceipt.getIdentification());
		
		return advancedAgeEmploymentListReceiptService.selectByPrimaryKey(advancedAgeEmploymentListReceiptKey);
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單_請領(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipts", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
		advancedAgeEmploymentListReceiptExample.setOrderByClause("id asc");
		advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andSeqEqualTo(employmentListReceipt.getSeq()).andBaseAllowanceFrequencyEqualTo(0);
		
		return advancedAgeEmploymentListReceiptService.selectByExample(advancedAgeEmploymentListReceiptExample);
	}
	
	@ApiOperation(value = "刪除繼續僱用補助名單_請領")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(token.equals(apiToken))
		{
			if(selectAdvancedAgeEmploymentListReceipt(employmentListReceipt,token) != null)
			{
				advancedAgeEmploymentListReceiptService.deleteByPrimaryKey(employmentListReceipt);
			}
		}
		
	}
	
	@ApiOperation(value = "用 ID 刪除繼續僱用補助名單_請領")
	@RequestMapping(value = "/delAdvancedAgeEmploymentListReceiptbyId", method = RequestMethod.POST)
	public void delAdvancedAgeEmploymentListReceiptbyId(AdvancedAgeEmploymentListReceipt employmentListReceipt,String token) {
		if(token.equals(apiToken))
		{
			advancedAgeEmploymentListReceiptExample = new AdvancedAgeEmploymentListReceiptExample();
			advancedAgeEmploymentListReceiptExample.createCriteria().andAdvancedAgeBaseIdEqualTo(employmentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(0);
			advancedAgeEmploymentListReceiptService.deleteByExample(advancedAgeEmploymentListReceiptExample);
		}
	}
	
	@ApiOperation(value = "新增近3年申請繼續僱用補助人數及留用狀況")
	@RequestMapping(value = "/addAdvancedAgeApplyEmployedSituation", method = RequestMethod.POST)
	public AdvancedAgeApplyEmployedSituation addAdvancedAgeApplyEmployedSituation(AdvancedAgeApplyEmployedSituation employedSituation,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectAdvancedAgeApplyEmployedSituation(employedSituation,token) == null)
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
	public AdvancedAgeApplyEmployedSituation selectAdvancedAgeApplyEmployedSituation(AdvancedAgeApplyEmployedSituation employedSituation,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeApplyEmployedSituationKey = new AdvancedAgeApplyEmployedSituationKey();
		advancedAgeApplyEmployedSituationKey.setAdvancedAgePlanId(employedSituation.getAdvancedAgePlanId());
		advancedAgeApplyEmployedSituationKey.setIdentification(employedSituation.getIdentification());
		return advancedAgeApplyEmployedSituationService.selectByPrimaryKey(advancedAgeApplyEmployedSituationKey);
	}
	
	@ApiOperation(value = "查詢近3年申請繼續僱用補助人數及留用狀況(多筆，畫面顯示)")
	@RequestMapping(value = "/selectAdvancedAgeApplyEmployedSituations", method = RequestMethod.POST)
	public List<AdvancedAgeApplyEmployedSituation> selectAdvancedAgeApplyEmployedSituations(AdvancedAgeApplyEmployedSituation employedSituation,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeApplyEmployedSituationExample = new AdvancedAgeApplyEmployedSituationExample();
		advancedAgeApplyEmployedSituationExample.createCriteria().andAdvancedAgePlanIdEqualTo(employedSituation.getAdvancedAgePlanId());
		
		return advancedAgeApplyEmployedSituationService.selectByExample(advancedAgeApplyEmployedSituationExample);
	}
	
	
}