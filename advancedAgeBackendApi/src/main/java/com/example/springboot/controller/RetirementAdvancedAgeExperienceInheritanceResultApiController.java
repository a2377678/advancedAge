package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceResultService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritanceResultApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceResultService retirementAdvancedAgeExperienceInheritanceResultService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceResult", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceResult selectRetirementAdvancedAgeExperienceInheritanceResult(RetirementAdvancedAgeExperienceInheritanceResult result,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return retirementAdvancedAgeExperienceInheritanceResultService.selectByPrimaryKey(result);
	}
}