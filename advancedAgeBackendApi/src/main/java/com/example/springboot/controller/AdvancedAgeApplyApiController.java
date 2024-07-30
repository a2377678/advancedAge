package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.service.AdvancedAgeApplyService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeApplyApiController { 
	
	@Autowired
	AdvancedAgeApplyService advancedAgeApplyService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		AdvancedAgeApplyKey key = new AdvancedAgeApplyKey();
		key.setApplyYear(String.valueOf(apply.getApplyYear()));
		key.setSeq(apply.getSeq());
		return advancedAgeApplyService.selectByPrimaryKey(key);
	}
}