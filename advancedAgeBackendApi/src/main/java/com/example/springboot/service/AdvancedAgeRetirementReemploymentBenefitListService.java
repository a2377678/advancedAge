package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentBenefitListMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListExample;

@Service
public class AdvancedAgeRetirementReemploymentBenefitListService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentBenefitListMapper advancedAgeRetirementReemploymentBenefitListMapper;

	public List<AdvancedAgeRetirementReemploymentBenefitList> selectByExample(
			AdvancedAgeRetirementReemploymentBenefitListExample example) {
		return advancedAgeRetirementReemploymentBenefitListMapper.selectByExample(example);
	}

}
