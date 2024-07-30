package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentResultService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvancedAgeRetirementReemploymentResultApiController {
	
	@Autowired
	AdvancedAgeRetirementReemploymentResultService advancedAgeRetirementReemploymentResultService;
	
	@Value("${api_token}")
	private String apiToken;

	@ApiOperation(value = "查詢再就業補助計畫_成果報告(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectAdvancedAgeRetirementReemploymentResult", method = RequestMethod.POST)
	public AdvancedAgeRetirementReemploymentResult selectAdvancedAgeRetirementReemploymentResult(AdvancedAgeRetirementReemploymentResult result,
			String token) {
		if (!token.equals(apiToken)) {
			return null;
		}
		return advancedAgeRetirementReemploymentResultService.selectByPrimaryKey(result);
	}
}
