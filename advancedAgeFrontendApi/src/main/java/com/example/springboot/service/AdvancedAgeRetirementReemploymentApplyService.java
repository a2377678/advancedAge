package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentApplyMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApplyKey;

@Service
public class AdvancedAgeRetirementReemploymentApplyService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentApplyMapper advancedAgeRetirementReemploymentApplyMapper;

	public int insertSelective(AdvancedAgeRetirementReemploymentApply apply) {
		return advancedAgeRetirementReemploymentApplyMapper.insertSelective(apply);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentApply apply) {
		return advancedAgeRetirementReemploymentApplyMapper.updateByPrimaryKeySelective(apply);
	}
	
	public AdvancedAgeRetirementReemploymentApply selectByPrimaryKey(AdvancedAgeRetirementReemploymentApplyKey key) {
		return advancedAgeRetirementReemploymentApplyMapper.selectByPrimaryKey(key);
	}

}
