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
		int a = advancedAgeApplyMapper.insertSelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
	
	public AdvancedAgeApply selectByPrimaryKey(AdvancedAgeApplyKey key) {
		AdvancedAgeApply advancedAgeApply = advancedAgeApplyMapper.selectByPrimaryKey(key);
		if(advancedAgeApply != null) {
			return advancedAgeApply;
		}else {
			return null;
		}
	}
	
	public List<AdvancedAgeApply> selectByExample(AdvancedAgeApplyExample example){
		List<AdvancedAgeApply> list = advancedAgeApplyMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeApply record) {
		int a = advancedAgeApplyMapper.updateByPrimaryKeySelective(record);
		if(Integer.valueOf(a) != null){
			return a;
		}else{
			return 0;
		}
	}
}