package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentBasicDataMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataKey;

@Service
public class AdvancedAgeRetirementReemploymentBasicDataService {
	
	@Autowired
	AdvancedAgeRetirementReemploymentBasicDataMapper advancedAgeRetirementReemploymentBasicDataMapper;

	public int insertSelective(AdvancedAgeRetirementReemploymentBasicData basicData) {
		return advancedAgeRetirementReemploymentBasicDataMapper.insertSelective(basicData);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeRetirementReemploymentBasicData basicData) {
		return advancedAgeRetirementReemploymentBasicDataMapper.updateByPrimaryKeySelective(basicData);
	}

	public AdvancedAgeRetirementReemploymentBasicData selectByPrimaryKey(
			AdvancedAgeRetirementReemploymentBasicDataKey advancedAgeRetirementReemploymentBasicDataKey) {
		return advancedAgeRetirementReemploymentBasicDataMapper.selectByPrimaryKey(advancedAgeRetirementReemploymentBasicDataKey);
	}

	public List<AdvancedAgeRetirementReemploymentBasicData> selectByExample(
			AdvancedAgeRetirementReemploymentBasicDataExample advancedAgeRetirementReemploymentBasicDataExample) {
		return advancedAgeRetirementReemploymentBasicDataMapper.selectByExample(advancedAgeRetirementReemploymentBasicDataExample);
	}

	public int deleteByPrimaryKey(AdvancedAgeRetirementReemploymentBasicData basicData) {
		return advancedAgeRetirementReemploymentBasicDataMapper.deleteByPrimaryKey(basicData);
	}

	public int deleteByExample(
			AdvancedAgeRetirementReemploymentBasicDataExample advancedAgeRetirementReemploymentBasicDataExample) {
		return advancedAgeRetirementReemploymentBasicDataMapper.deleteByExample(advancedAgeRetirementReemploymentBasicDataExample);
	}

}
