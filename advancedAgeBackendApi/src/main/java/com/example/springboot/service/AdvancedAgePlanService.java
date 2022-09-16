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
		return advancedAgePlanMapper.insertSelective(record);
	}
	
	public AdvancedAgePlan selectByPrimaryKey(Integer advancedAgeApplyId) {
		return advancedAgePlanMapper.selectByPrimaryKey(advancedAgeApplyId);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgePlan record) {
		return advancedAgePlanMapper.updateByPrimaryKeySelective(record);
	}
}