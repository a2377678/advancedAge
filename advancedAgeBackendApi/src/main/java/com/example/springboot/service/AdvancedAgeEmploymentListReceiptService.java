package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.AdvancedAgeEmploymentListReceiptMapper;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptKey;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;

@Service
public class AdvancedAgeEmploymentListReceiptService{
	
	@Autowired
	AdvancedAgeEmploymentListReceiptMapper advancedAgeEmploymentListReceiptMapper;
	
	public int insertSelective(AdvancedAgeEmploymentListReceipt record) {
		return advancedAgeEmploymentListReceiptMapper.insertSelective(record);
	}
	
	public AdvancedAgeEmploymentListReceipt selectByPrimaryKey(AdvancedAgeEmploymentListReceiptKey key) {
		return advancedAgeEmploymentListReceiptMapper.selectByPrimaryKey(key);
	}
	
	public List<AdvancedAgeEmploymentListReceipt> selectByExample(AdvancedAgeEmploymentListReceiptExample example){
		return advancedAgeEmploymentListReceiptMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(AdvancedAgeEmploymentListReceipt record) {
		return advancedAgeEmploymentListReceiptMapper.updateByPrimaryKeySelective(record);
	}
	
	public int deleteByPrimaryKey(AdvancedAgeEmploymentListReceiptKey key) {
		return advancedAgeEmploymentListReceiptMapper.deleteByPrimaryKey(key);
	}
}