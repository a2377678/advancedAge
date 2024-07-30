package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeApplyMapper;
import com.example.springboot.dao.AdvancedAgePlanMapper;
import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgePlan;

@Service
public class AdvancedAgePlanService{
	
	@Autowired
	AdvancedAgePlanMapper advancedAgePlanMapper;
	
	public int insertSelective(AdvancedAgePlan record) {
		int a = advancedAgePlanMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public AdvancedAgePlan selectByPrimaryKey(Integer advancedAgeApplyId) {
		AdvancedAgePlan advancedAgePlan = advancedAgePlanMapper.selectByPrimaryKey(advancedAgeApplyId);
		if(advancedAgePlan != null) {
			return advancedAgePlan;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgePlan record) {
		int a = advancedAgePlanMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}