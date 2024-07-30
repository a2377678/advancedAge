package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceApplyService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritanceApplyApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceApplyService retirementAdvancedAgeExperienceInheritanceApplyService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceApply", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceApply selectRetirementAdvancedAgeExperienceInheritanceApply(RetirementAdvancedAgeExperienceInheritanceApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		RetirementAdvancedAgeExperienceInheritanceApplyKey key = new RetirementAdvancedAgeExperienceInheritanceApplyKey();
		key.setApplyYear(String.valueOf(apply.getApplyYear()));
		key.setSeq(apply.getSeq());
		return retirementAdvancedAgeExperienceInheritanceApplyService.selectByPrimaryKey(key);
	}
}