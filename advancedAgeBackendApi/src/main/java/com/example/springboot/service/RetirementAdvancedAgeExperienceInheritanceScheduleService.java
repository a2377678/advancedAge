package com.example.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeExperienceInheritanceScheduleMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleKey;


@Service
public class RetirementAdvancedAgeExperienceInheritanceScheduleService{
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceScheduleMapper retirementAdvancedAgeExperienceInheritanceScheduleMapper;
	
	public int insertSelective(RetirementAdvancedAgeExperienceInheritanceSchedule record) {
		int a = retirementAdvancedAgeExperienceInheritanceScheduleMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public RetirementAdvancedAgeExperienceInheritanceSchedule selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceScheduleKey key) {
		RetirementAdvancedAgeExperienceInheritanceSchedule schedule = retirementAdvancedAgeExperienceInheritanceScheduleMapper.selectByPrimaryKey(key);
		if(schedule != null) {
			return schedule;
		}else {
			return null;
		}
	}
	
	public List<RetirementAdvancedAgeExperienceInheritanceSchedule> selectByExample(RetirementAdvancedAgeExperienceInheritanceScheduleExample example){
		List<RetirementAdvancedAgeExperienceInheritanceSchedule> list = retirementAdvancedAgeExperienceInheritanceScheduleMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceSchedule record) {
		int a = retirementAdvancedAgeExperienceInheritanceScheduleMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public int deleteByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceScheduleKey key) {
		int a = retirementAdvancedAgeExperienceInheritanceScheduleMapper.deleteByPrimaryKey(key);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public int deleteByExample(RetirementAdvancedAgeExperienceInheritanceScheduleExample example) {
		int a = retirementAdvancedAgeExperienceInheritanceScheduleMapper.deleteByExample(example);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}