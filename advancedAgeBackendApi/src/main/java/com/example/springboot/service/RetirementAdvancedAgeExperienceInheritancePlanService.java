package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeExperienceInheritancePlanMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlanExample;

@Service
public class RetirementAdvancedAgeExperienceInheritancePlanService{
	@Autowired
	RetirementAdvancedAgeExperienceInheritancePlanMapper retirementAdvancedAgeExperienceInheritancePlanMapper;
	
	public int insertSelective(RetirementAdvancedAgeExperienceInheritancePlan record) {
		int a = retirementAdvancedAgeExperienceInheritancePlanMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public List<RetirementAdvancedAgeExperienceInheritancePlan> selectByExample(RetirementAdvancedAgeExperienceInheritancePlanExample example){
		List<RetirementAdvancedAgeExperienceInheritancePlan> list = retirementAdvancedAgeExperienceInheritancePlanMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public RetirementAdvancedAgeExperienceInheritancePlan selectByPrimaryKey(Integer retirementAdvancedAgeExperienceInheritanceApplyId) {
		RetirementAdvancedAgeExperienceInheritancePlan plan = retirementAdvancedAgeExperienceInheritancePlanMapper.selectByPrimaryKey(retirementAdvancedAgeExperienceInheritanceApplyId);
		if(plan != null) {
			return plan;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritancePlan record) {
		int a = retirementAdvancedAgeExperienceInheritancePlanMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}