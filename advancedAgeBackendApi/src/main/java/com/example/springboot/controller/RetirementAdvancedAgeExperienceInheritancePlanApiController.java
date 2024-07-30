package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritancePlanService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritancePlanApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritancePlanService retirementAdvancedAgeExperienceInheritancePlanService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritancePlan", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritancePlan selectRetirementAdvancedAgeExperienceInheritancePlan(RetirementAdvancedAgeExperienceInheritancePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return retirementAdvancedAgeExperienceInheritancePlanService.selectByPrimaryKey(plan.getRetirementAdvancedAgeExperienceInheritanceApplyId());
	}
}