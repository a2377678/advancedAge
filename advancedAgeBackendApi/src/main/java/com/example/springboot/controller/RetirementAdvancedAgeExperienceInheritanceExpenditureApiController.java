package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureExample;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceExpenditureService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritanceExpenditureApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceExpenditureService expenditureService;

	@Value("${api_token}")
	private String apiToken;

	RetirementAdvancedAgeExperienceInheritanceExpenditureExample expenditureExample;
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceExpenditures", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeExperienceInheritanceExpenditure> selectRetirementAdvancedAgeExperienceInheritanceExpenditures(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		expenditureExample = new RetirementAdvancedAgeExperienceInheritanceExpenditureExample();
		expenditureExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(expenditure.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		expenditureExample.setOrderByClause("id asc");
		
		return expenditureService.selectByExample(expenditureExample);
	}
}