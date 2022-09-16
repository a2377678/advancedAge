package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.FunctionPermissionMapper;
import com.example.springboot.entity.FunctionPermission;

@Service
public class FunctionPermissionService{
	
	@Autowired
	FunctionPermissionMapper functionPermissionMapper;
	
	public FunctionPermission selectByPrimaryKey(Integer jurisdiction) {
		return functionPermissionMapper.selectByPrimaryKey(jurisdiction);
	}
	
	public int updateByPrimaryKeySelective(FunctionPermission record) {
		return functionPermissionMapper.updateByPrimaryKeySelective(record);
	}
	
}