package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentBenefitListMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitList;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBenefitListKey;

@Service
public class AdvancedAgeRetirementReemploymentBenefitListService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentBenefitListMapper advancedAgeRetirementReemploymentBenefitListMapper;

	public int insertSelective(AdvancedAgeRetirementReemploymentBenefitList benefitList) {
		return advancedAgeRetirementReemploymentBenefitListMapper.insertSelective(benefitList);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentBenefitList benefitList) {
		return advancedAgeRetirementReemploymentBenefitListMapper.updateByPrimaryKeySelective(benefitList);
	}

	public AdvancedAgeRetirementReemploymentBenefitList selectByPrimaryKey(
			AdvancedAgeRetirementReemploymentBenefitListKey advancedAgeRetirementReemploymentBenefitListKey) {
		return advancedAgeRetirementReemploymentBenefitListMapper.selectByPrimaryKey(advancedAgeRetirementReemploymentBenefitListKey);
	}

	public List<AdvancedAgeRetirementReemploymentBenefitList> selectByExample(
			AdvancedAgeRetirementReemploymentBenefitListExample advancedAgeRetirementReemploymentBenefitListExample) {
		return advancedAgeRetirementReemploymentBenefitListMapper.selectByExample(advancedAgeRetirementReemploymentBenefitListExample);
	}

	public int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentBenefitList benefitList) {
		return advancedAgeRetirementReemploymentBenefitListMapper.deleteByPrimaryKey(benefitList);
	}

	public int deleteByExample(
			AdvancedAgeRetirementReemploymentBenefitListExample advancedAgeRetirementReemploymentBenefitListExample) {
		return advancedAgeRetirementReemploymentBenefitListMapper.deleteByExample(advancedAgeRetirementReemploymentBenefitListExample);
	}

}
