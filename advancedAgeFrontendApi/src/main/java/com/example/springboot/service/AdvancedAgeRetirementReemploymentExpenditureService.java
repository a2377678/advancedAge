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

	public int insertSelective(AdvancedAgeRetirementReemploymentExpenditure expenditure) {
		return advancedAgeRetirementReemploymentExpenditureMapper.insertSelective(expenditure);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentExpenditure expenditure) {
		return advancedAgeRetirementReemploymentExpenditureMapper.updateByPrimaryKeySelective(expenditure);
	}

	public AdvancedAgeRetirementReemploymentExpenditure selectByPrimaryKey(Integer id) {
		return advancedAgeRetirementReemploymentExpenditureMapper.selectByPrimaryKey(id);
	}

	public List<AdvancedAgeRetirementReemploymentExpenditure> selectByExample(
			AdvancedAgeRetirementReemploymentExpenditureExample advancedAgeRetirementReemploymentExpenditureExample) {
		return advancedAgeRetirementReemploymentExpenditureMapper.selectByExample(advancedAgeRetirementReemploymentExpenditureExample);
	}

	public int deleteByPrimaryKey(Integer id) {
		return advancedAgeRetirementReemploymentExpenditureMapper.deleteByPrimaryKey(id);
	}

	public int deleteByExample(
			AdvancedAgeRetirementReemploymentExpenditureExample advancedAgeRetirementReemploymentExpenditureExample) {
		return advancedAgeRetirementReemploymentExpenditureMapper.deleteByExample(advancedAgeRetirementReemploymentExpenditureExample);
	}

}
