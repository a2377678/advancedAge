package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentPlanService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentPlanApiController {

	@Autowired
	AdvancedAgeRetirementReemploymentPlanService advancedAgeRetirementReemploymentPlanService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢再就業補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentPlan", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentPlan selectAdvancedAgeRetirementReemploymentPlan(AdvancedAgeRetirementReemploymentPlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return advancedAgeRetirementReemploymentPlanService.selectByPrimaryKey(plan.getAdvancedAgeRetirementReemploymentApplyId());
	}
}
