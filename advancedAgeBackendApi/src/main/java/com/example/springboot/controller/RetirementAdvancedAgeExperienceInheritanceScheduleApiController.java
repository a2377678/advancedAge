package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceScheduleService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritanceScheduleApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceScheduleService scheduleService;

	@Value("${api_token}")
	private String apiToken;
	
	RetirementAdvancedAgeExperienceInheritanceScheduleExample scheduleExample;
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceSchedules", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeExperienceInheritanceSchedule> selectRetirementAdvancedAgeExperienceInheritanceSchedules(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		scheduleExample = new RetirementAdvancedAgeExperienceInheritanceScheduleExample();
		scheduleExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(schedule.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		scheduleExample.setOrderByClause("id asc");
		
		return scheduleService.selectByExample(scheduleExample);
	}
}