package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.RetirementAdvancedAgeExperienceInheritanceApplyMapper;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;

@Service
public class RetirementAdvancedAgeExperienceInheritanceApplyService{
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceApplyMapper retirementAdvancedAgeExperienceInheritanceApplyMapper;
	
	public int insertSelective(RetirementAdvancedAgeExperienceInheritanceApply record) {
		int a = retirementAdvancedAgeExperienceInheritanceApplyMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public RetirementAdvancedAgeExperienceInheritanceApply selectByPrimaryKey(RetirementAdvancedAgeExperienceInheritanceApplyKey key) {
		RetirementAdvancedAgeExperienceInheritanceApply apply = retirementAdvancedAgeExperienceInheritanceApplyMapper.selectByPrimaryKey(key);
		if(apply != null) {
			return apply;
		}else {
			return null;
		}
	}
	
	public List<RetirementAdvancedAgeExperienceInheritanceApply> selectByExample(RetirementAdvancedAgeExperienceInheritanceApplyExample example){
		List<RetirementAdvancedAgeExperienceInheritanceApply> list = retirementAdvancedAgeExperienceInheritanceApplyMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(RetirementAdvancedAgeExperienceInheritanceApply record) {
		int a = retirementAdvancedAgeExperienceInheritanceApplyMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}