package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentPlanMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;

@Service
public class AdvancedAgeRetirementReemploymentPlanService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentPlanMapper advancedAgeRetirementReemploymentPlanMapper;

	public AdvancedAgeRetirementReemploymentPlan selectByPrimaryKey(Integer advancedAgeRetirementReemploymentApplyId) {
		return advancedAgeRetirementReemploymentPlanMapper.selectByPrimaryKey(advancedAgeRetirementReemploymentApplyId);
	}

}
