package com.example.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeParticipateStudentMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentExample;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentKey;


@Service
public class RetirementAdvancedAgeParticipateStudentService{
	@Autowired
	RetirementAdvancedAgeParticipateStudentMapper retirementAdvancedAgeParticipateStudentMapper;
	
	public int insertSelective(RetirementAdvancedAgeParticipateStudent record) {
		int a = retirementAdvancedAgeParticipateStudentMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public RetirementAdvancedAgeParticipateStudent selectByPrimaryKey(RetirementAdvancedAgeParticipateStudentKey key) {
		RetirementAdvancedAgeParticipateStudent participate = retirementAdvancedAgeParticipateStudentMapper.selectByPrimaryKey(key);
		if(participate != null) {
			return participate;
		}else {
			return null;
		}
	}
	
	public List<RetirementAdvancedAgeParticipateStudent> selectByExample(RetirementAdvancedAgeParticipateStudentExample example){
		List<RetirementAdvancedAgeParticipateStudent> list = retirementAdvancedAgeParticipateStudentMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeParticipateStudent record) {
		int a = retirementAdvancedAgeParticipateStudentMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public int deleteByPrimaryKey(RetirementAdvancedAgeParticipateStudentKey key) {
		int a = retirementAdvancedAgeParticipateStudentMapper.deleteByPrimaryKey(key);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public int deleteByExample(RetirementAdvancedAgeParticipateStudentExample example) {
		int a = retirementAdvancedAgeParticipateStudentMapper.deleteByExample(example);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}