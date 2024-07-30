package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeExperienceInheritanceExpenditureMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlanExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleKey;

@Service
public class RetirementAdvancedAgeExperienceInheritanceExpenditureService{
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceExpenditureMapper retirementAdvancedAgeExperienceInheritanceExpenditureMapper;

	public int insertSelective(RetirementAdvancedAgeExperienceInheritanceExpenditure record) {
		int a = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public List<RetirementAdvancedAgeExperienceInheritanceExpenditure> selectByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureExample example){
		List<RetirementAdvancedAgeExperienceInheritanceExpenditure> list = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public RetirementAdvancedAgeExperienceInheritanceExpenditure selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditureKey key) {
		RetirementAdvancedAgeExperienceInheritanceExpenditure plan = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.selectByPrimaryKey(key);
		if(plan != null) {
			return plan;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceExpenditure record) {
		int a = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	

	public int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceExpenditureKey key) {
		int a = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.deleteByPrimaryKey(key);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public int deleteByExample(RetirementAdvancedAgeExperienceInheritanceExpenditureExample example) {
		int a = retirementAdvancedAgeExperienceInheritanceExpenditureMapper.deleteByExample(example);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}