package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.service.AdvancedAgeEmploymentListService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeEmploymentListApiController { 
	
	@Autowired
	AdvancedAgeEmploymentListService advancedAgeEmploymentListService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用補助名單")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentLists", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentList> selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList advancedAgeEmploymentList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListExample example = new AdvancedAgeEmploymentListExample();
		example.createCriteria().andAdvancedAgePlanIdEqualTo(advancedAgeEmploymentList.getAdvancedAgePlanId());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListService.selectByExample(example);
	}
}