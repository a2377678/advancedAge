package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.FunctionListMapper;
import com.example.springboot.entity.FunctionList;
import com.example.springboot.entity.FunctionListExample;

@Service
public class FunctionListService{
	
	@Autowired
	FunctionListMapper functionListMapper;
	
	public List<FunctionList> selectByExample(FunctionListExample example){
		return functionListMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(FunctionList record) {
		return functionListMapper.updateByPrimaryKeySelective(record);
	}
	
	public FunctionList selectByPrimaryKey(String account) {
		return functionListMapper.selectByPrimaryKey(account);
	}
}