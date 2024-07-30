package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeRetirementReemploymentBasicDataMapper;
import com.example.springboot.dao.AdvancedAgeRetirementReemploymentJointAuthorizeMapper;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicData;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentBasicDataExample;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorize;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentJointAuthorizeExample;

@Service
public class AdvancedAgeRetirementReemploymentBasicDataService {

	@Autowired
	AdvancedAgeRetirementReemploymentBasicDataMapper advancedAgeRetirementReemploymentBasicDataMapper;

	public List<AdvancedAgeRetirementReemploymentBasicData> selectByExample(
			AdvancedAgeRetirementReemploymentBasicDataExample example) {
		return advancedAgeRetirementReemploymentBasicDataMapper.selectByExample(example);
	}
	
}
