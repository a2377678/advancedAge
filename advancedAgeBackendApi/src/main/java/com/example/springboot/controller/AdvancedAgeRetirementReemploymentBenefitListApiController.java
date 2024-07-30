package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListExample;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentBenefitListService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentBenefitListApiController {

	@Autowired
	AdvancedAgeRetirementReemploymentBenefitListService advancedAgeRetirementReemploymentBenefitListService;
	
	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢計畫受益人員名單")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBenefitLists", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentBenefitList> selectAdvancedAgeRetirementReemploymentBenefitLists(AdvancedAgeRetirementReemploymentBenefitList benefitList, String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeRetirementReemploymentBenefitListExample example = new AdvancedAgeRetirementReemploymentBenefitListExample();
		example.createCriteria().andAdvancedAgeRetirementReemploymentPlanIdEqualTo(benefitList.getAdvancedAgeRetirementReemploymentPlanId());
		example.setOrderByClause("id asc");
		return advancedAgeRetirementReemploymentBenefitListService.selectByExample(example);
	}
}
