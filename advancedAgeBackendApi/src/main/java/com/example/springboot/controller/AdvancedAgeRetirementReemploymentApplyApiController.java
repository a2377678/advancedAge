package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentApplyService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentApplyApiController {
	
	@Autowired
	AdvancedAgeRetirementReemploymentApplyService advancedAgeRetirementReemploymentApplyService;
	
	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentApply", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentApply selectAdvancedAgeRetirementReemploymentApply(AdvancedAgeRetirementReemploymentApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return advancedAgeRetirementReemploymentApplyService.selectByPrimaryKey(apply);
	}
}
