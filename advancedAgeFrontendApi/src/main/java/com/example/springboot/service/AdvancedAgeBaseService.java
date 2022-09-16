package com.example.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeBaseMapper;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;

@Service
public class AdvancedAgeBaseService{
	
	@Autowired
	AdvancedAgeBaseMapper advancedAgeBaseMapper;
	
	public int insert(AdvancedAgeBase record) {
		return advancedAgeBaseMapper.insert(record);
	}
	
	public int insertSelective(AdvancedAgeBase record) {
		return advancedAgeBaseMapper.insertSelective(record);
	}
	
	public List<AdvancedAgeBase> selectByExample(AdvancedAgeBaseExample example){
		return advancedAgeBaseMapper.selectByExample(example);
	}

	public int updateByPrimaryKeySelective(AdvancedAgeBase record) {
		return advancedAgeBaseMapper.updateByPrimaryKeySelective(record);
	}
	
	public int updateByExampleSelective(AdvancedAgeBase record,AdvancedAgeBaseExample example) {
		return advancedAgeBaseMapper.updateByExampleSelective(record,example);
	}
}