package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentPlanMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;

@Service
public class AdvancedAgeRetirementReemploymentPlanService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentPlanMapper advancedAgeRetirementReemploymentPlanMapper;

	public int insertSelective(AdvancedAgeRetirementReemploymentPlan plan) {
		return advancedAgeRetirementReemploymentPlanMapper.insertSelective(plan);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentPlan plan) {
		return advancedAgeRetirementReemploymentPlanMapper.updateByPrimaryKeySelective(plan);
	}

	public AdvancedAgeRetirementReemploymentPlan selectByPrimaryKey(Integer advancedAgeRetirementReemploymentApplyId) {
		return advancedAgeRetirementReemploymentPlanMapper.selectByPrimaryKey(advancedAgeRetirementReemploymentApplyId);
	}

}
