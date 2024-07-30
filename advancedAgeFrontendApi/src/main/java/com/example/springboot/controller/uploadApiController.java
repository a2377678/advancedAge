package com.example.springboot.controller;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UnitExample;
import com.example.springboot.service.AdvancedAgeApplyService;
import com.example.springboot.service.AdvancedAgeBaseService;
import com.example.springboot.service.AdvancedAgeEmploymentListService;
import com.example.springboot.service.AdvancedAgePlanService;
import com.example.springboot.service.UnitService;
import com.example.springboot.util.DateFormatUtil;

import io.swagger.annotations.ApiOperation;

@RestController 
public class uploadApiController { 

	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	@Autowired
	AdvancedAgeApplyService advancedAgeApplyService;
	
	@Autowired
	AdvancedAgePlanService advancedAgePlanService;
	
	@Autowired
	AdvancedAgeEmploymentListService advancedAgeEmploymentListService;
	
	@Autowired
	UnitService unitService;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	UnitExample unitExample;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Value("${api_token}")
	private String apiToken;
	
	
	@ApiOperation(value = "新增繼續僱用高齡者補助申請書中高齡基礎表")
	@RequestMapping(value = "/addAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase addAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		unitExample = new UnitExample();
		unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
		List<Unit> unit = unitService.selectByExample(unitExample);
		base.setUnit(unit.get(0).getCode());
		base.setFileStatus("4");
		base.setReviewStatus("1");
		if(selectBase(base.getAaid(),token) == null)
		{
			advancedAgeBaseService.insertSelective(base);
		}else {
			advancedAgeBaseService.updateByPrimaryKeySelective(base);
		}
		
		return base;
	}
	
	@ApiOperation(value = "新增繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/addApply", method = RequestMethod.POST)
	public AdvancedAgeApply addApply(AdvancedAgeApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectApply(apply,token) == null)
		{
			advancedAgeApplyService.insertSelective(apply);
		}else {
			advancedAgeApplyService.updateByPrimaryKeySelective(apply);
		}
		return selectApply(apply,token) == null?apply:selectApply(apply,token);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectApply", method = RequestMethod.POST)
	public AdvancedAgeApply selectApply(AdvancedAgeApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		AdvancedAgeApplyKey key = new AdvancedAgeApplyKey();
		key.setApplyYear(apply.getApplyYear());
		key.setSeq(apply.getSeq());
		return advancedAgeApplyService.selectByPrimaryKey(key);
	}
	
	@ApiOperation(value = "新增繼續僱用高齡者補助計畫書")
	@RequestMapping(value = "/addPlan", method = RequestMethod.POST)
	public AdvancedAgePlan addPlan(AdvancedAgePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeApply apply = selectApplyExample(plan.getCompanyName());
		plan.setAdvancedAgeApplyId(apply.getId());
		if(selectPlan(plan,token) == null)
		{
			advancedAgePlanService.insertSelective(plan);
		}
		else {
			advancedAgePlanService.updateByPrimaryKeySelective(plan);
		}
		return selectPlan(plan,token) == null?plan:selectPlan(plan,token);
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助計畫書")
	@RequestMapping(value = "/selectPlan", method = RequestMethod.POST)
	public AdvancedAgePlan selectPlan(AdvancedAgePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return advancedAgePlanService.selectByPrimaryKey(plan.getAdvancedAgeApplyId());
	}
	
	public AdvancedAgeApply selectApplyExample(String companyName) {
		
		AdvancedAgeApplyExample applyExample = new AdvancedAgeApplyExample();
		applyExample.createCriteria().andCompanyNameEqualTo(companyName);
		applyExample.setOrderByClause("id desc");
		return advancedAgeApplyService.selectByExample(applyExample).get(0);
	}
	
	@ApiOperation(value = "新增繼續僱用補助名單")
	@RequestMapping(value = "/addEmployment", method = RequestMethod.POST)
	public AdvancedAgeEmploymentList addEmployment(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeBase base = selectBase(employmentList.getEmployeeId(),token);
		AdvancedAgeApply searchapply = new AdvancedAgeApply();
		searchapply.setApplyYear(base.getYear());
		searchapply.setSeq(base.getSeq());
		
		AdvancedAgeApply apply = new AdvancedAgeApply();
		apply = selectApply(searchapply, token);
		
		AdvancedAgePlan searchPlan = new AdvancedAgePlan();
		searchPlan.setAdvancedAgeApplyId(apply.getId());
		
		AdvancedAgePlan plan = new AdvancedAgePlan();
		plan = selectPlan(searchPlan, token);
		
		employmentList.setAdvancedAgePlanId(plan.getId());
		if(selectEmploymentList(employmentList,token) == null)
		{
			advancedAgeEmploymentListService.insertSelective(employmentList);
		}else {
			advancedAgeEmploymentListService.updateByPrimaryKeySelective(employmentList);
		}
		return employmentList;
	}
	
	public AdvancedAgeEmploymentList selectEmploymentList(AdvancedAgeEmploymentList employmentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListKey advancedAgeEmploymentListKey = new AdvancedAgeEmploymentListKey();
		advancedAgeEmploymentListKey.setAdvancedAgePlanId(employmentList.getAdvancedAgePlanId());
		advancedAgeEmploymentListKey.setIdentification(employmentList.getIdentification());
		
		return advancedAgeEmploymentListService.selectByPrimaryKey(advancedAgeEmploymentListKey);
	}
	
	public AdvancedAgeBase selectBase(String aaid,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		return advancedAgeBaseService.selectByPrimaryKey(aaid);
	}
}