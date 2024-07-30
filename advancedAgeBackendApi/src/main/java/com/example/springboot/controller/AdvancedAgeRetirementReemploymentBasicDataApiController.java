package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorize;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorizeExample;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentBasicDataService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentBasicDataApiController {

	@Autowired
	AdvancedAgeRetirementReemploymentBasicDataService advancedAgeRetirementReemploymentBasicDataService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢聯合辦理單位授權(多筆)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentBasicDatas", method = RequestMethod.POST)
	public List<AdvancedAgeRetirementReemploymentBasicData> selectAdvancedAgeRetirementReemploymentBasicDatas(AdvancedAgeRetirementReemploymentBasicData basicData, String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeRetirementReemploymentBasicDataExample example = new AdvancedAgeRetirementReemploymentBasicDataExample();
		example.createCriteria().andAdvancedAgeRetirementReemploymentApplyIdEqualTo(basicData.getAdvancedAgeRetirementReemploymentApplyId());
		example.setOrderByClause("id asc");
		return advancedAgeRetirementReemploymentBasicDataService.selectByExample(example);
	}
}
