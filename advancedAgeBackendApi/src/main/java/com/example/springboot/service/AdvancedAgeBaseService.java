package com.example.springboot.service;

import java.util.List;

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
	
	public List<AdvancedAgeBase> selectByExample(AdvancedAgeBaseExample example){
		return advancedAgeBaseMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeBase record) {
		return advancedAgeBaseMapper.updateByPrimaryKeySelective(record);
	}
}