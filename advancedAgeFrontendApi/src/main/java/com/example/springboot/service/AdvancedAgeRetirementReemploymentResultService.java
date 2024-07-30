package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentResultMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResult;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentResultExample;

@Service
public class AdvancedAgeRetirementReemploymentResultService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentResultMapper advancedAgeRetirementReemploymentResultMapper;

	public int insertSelective(AdvancedAgeRetirementReemploymentResult result) {
		return advancedAgeRetirementReemploymentResultMapper.insertSelective(result);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentResult result) {
		return advancedAgeRetirementReemploymentResultMapper.updateByPrimaryKeySelective(result);
	}

	public AdvancedAgeRetirementReemploymentResult selectByPrimaryKey(AdvancedAgeRetirementReemploymentResult result) {
		return advancedAgeRetirementReemploymentResultMapper.selectByPrimaryKey(result);
	}

}
