package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeExperienceInheritanceResultMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResultExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResultKey;

@Service
public class RetirementAdvancedAgeExperienceInheritanceResultService{
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceResultMapper retirementAdvancedAgeExperienceInheritanceResultMapper;
	
	public int insertSelective(RetirementAdvancedAgeExperienceInheritanceResult record) {
		int a = retirementAdvancedAgeExperienceInheritanceResultMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public List<RetirementAdvancedAgeExperienceInheritanceResult> selectByExample(RetirementAdvancedAgeExperienceInheritanceResultExample example){
		List<RetirementAdvancedAgeExperienceInheritanceResult> list = retirementAdvancedAgeExperienceInheritanceResultMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public RetirementAdvancedAgeExperienceInheritanceResult selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceResultKey key){
		RetirementAdvancedAgeExperienceInheritanceResult plan = retirementAdvancedAgeExperienceInheritanceResultMapper.selectByPrimaryKey(key);
		if(plan != null) {
			return plan;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceResult record) {
		int a = retirementAdvancedAgeExperienceInheritanceResultMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}