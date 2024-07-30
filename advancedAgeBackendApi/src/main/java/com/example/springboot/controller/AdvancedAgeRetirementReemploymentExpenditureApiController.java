package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureExample;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentExpenditureService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentExpenditureApiController {

	@Autowired
	AdvancedAgeRetirementReemploymentExpenditureService advancedAgeRetirementReemploymentExpenditureService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢再就業經費概算表(多筆)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentExpenditures", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentExpenditure> selectAdvancedAgeRetirementReemploymentExpenditures(AdvancedAgeRetirementReemploymentExpenditure expenditure, String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeRetirementReemploymentExpenditureExample example = new AdvancedAgeRetirementReemploymentExpenditureExample();
		example.createCriteria().andAdvancedAgeRetirementReemploymentApplyIdEqualTo(expenditure.getAdvancedAgeRetirementReemploymentApplyId());
		example.setOrderByClause("id asc");
		return advancedAgeRetirementReemploymentExpenditureService.selectByExample(example);
	}
}
