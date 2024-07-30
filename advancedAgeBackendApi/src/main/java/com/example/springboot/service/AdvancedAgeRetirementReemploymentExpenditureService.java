package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentExpenditureMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditure;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentExpenditureExample;

@Service
public class AdvancedAgeRetirementReemploymentExpenditureService {

	@Autowired
	AdvancedAgeRetirementReemploymentExpenditureMapper advancedAgeRetirementReemploymentExpenditureMapper;

	public List<AdvancedAgeRetirementReemploymentExpenditure> selectByExample(
			AdvancedAgeRetirementReemploymentExpenditureExample example) {
		return advancedAgeRetirementReemploymentExpenditureMapper.selectByExample(example);
	}
	
	
}
