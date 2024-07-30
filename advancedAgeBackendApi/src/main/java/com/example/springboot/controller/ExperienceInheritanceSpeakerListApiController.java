package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListExample;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListKey;
import com.example.springboot.service.ExperienceInheritanceSpeakerListService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class ExperienceInheritanceSpeakerListApiController { 
	
	@Autowired
	ExperienceInheritanceSpeakerListService speakerListService;

	ExperienceInheritanceSpeakerListExample speakerListExample;
	
	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢傳承專業技術及經驗之講師名單(多筆，畫面顯示)")
	@RequestMapping(value = "/selectExperienceInheritanceSpeakerLists", method = RequestMethod.POST)
	public List<ExperienceInheritanceSpeakerList> selectExperienceInheritanceSpeakerLists(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		speakerListExample = new ExperienceInheritanceSpeakerListExample();
		speakerListExample.setOrderByClause("id asc");
		speakerListExample.createCriteria().andRetirementAdvancedAgeExperienceInheritancePlanIdEqualTo(speakerList.getRetirementAdvancedAgeExperienceInheritancePlanId());
		
		return speakerListService.selectByExample(speakerListExample);
	}
}