package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeEmploymentListMapper;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;

@Service
public class AdvancedAgeEmploymentListService{
	
	@Autowired
	AdvancedAgeEmploymentListMapper advancedAgeEmploymentListMapper;
	
	public int insertSelective(AdvancedAgeEmploymentList record) {
		return advancedAgeEmploymentListMapper.insertSelective(record);
	}
	
	public AdvancedAgeEmploymentList selectByPrimaryKey(AdvancedAgeEmploymentListKey key) {
		return advancedAgeEmploymentListMapper.selectByPrimaryKey(key);
	}
	
	public List<AdvancedAgeEmploymentList> selectByExample(AdvancedAgeEmploymentListExample example){
		return advancedAgeEmploymentListMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeEmploymentList record) {
		return advancedAgeEmploymentListMapper.updateByPrimaryKeySelective(record);
	}
	
	public int deleteByPrimaryKey(AdvancedAgeEmploymentListKey key) {
		return advancedAgeEmploymentListMapper.deleteByPrimaryKey(key);
	}
}