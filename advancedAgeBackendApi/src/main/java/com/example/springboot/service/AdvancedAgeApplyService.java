package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeApplyMapper;
import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;

@Service
public class AdvancedAgeApplyService{
	
	@Autowired
	AdvancedAgeApplyMapper advancedAgeApplyMapper;
	
	public int insertSelective(AdvancedAgeApply record) {
		return advancedAgeApplyMapper.insertSelective(record);
	}
	
	public AdvancedAgeApply selectByPrimaryKey(AdvancedAgeApplyKey key) {
		return advancedAgeApplyMapper.selectByPrimaryKey(key);
	}
	
	public List<AdvancedAgeApply> selectByExample(AdvancedAgeApplyExample example){
		return advancedAgeApplyMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeApply record) {
		return advancedAgeApplyMapper.updateByPrimaryKeySelective(record);
	}
}