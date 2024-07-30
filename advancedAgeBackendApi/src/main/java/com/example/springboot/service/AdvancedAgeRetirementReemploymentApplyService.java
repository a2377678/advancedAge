package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentApplyMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;

@Service
public class AdvancedAgeRetirementReemploymentApplyService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentApplyMapper advancedAgeRetirementReemploymentApplyMapper;

	public AdvancedAgeRetirementReemploymentApply selectByPrimaryKey(AdvancedAgeRetirementReemploymentApply apply) {
		return advancedAgeRetirementReemploymentApplyMapper.selectByPrimaryKey(apply);
	}

}
