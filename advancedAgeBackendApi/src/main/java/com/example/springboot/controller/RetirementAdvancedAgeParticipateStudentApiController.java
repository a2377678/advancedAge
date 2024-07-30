package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentExample;
import com.example.springboot.service.RetirementAdvancedAgeParticipateStudentService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeParticipateStudentApiController { 

	@Autowired
	RetirementAdvancedAgeParticipateStudentService participateService;

	@Value("${api_token}")
	private String apiToken;
	
	RetirementAdvancedAgeParticipateStudentExample participateExample;

	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeParticipateStudents", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeParticipateStudent> selectRetirementAdvancedAgeParticipateStudents(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		participateExample = new RetirementAdvancedAgeParticipateStudentExample();
		participateExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(participate.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		participateExample.setOrderByClause("id asc");
		
		return participateService.selectByExample(participateExample);
	}
}