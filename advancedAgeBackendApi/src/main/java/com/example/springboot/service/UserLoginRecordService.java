package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.UserLoginRecordMapper;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.entity.UserLoginRecord;
import com.example.springboot.entity.UserLoginRecordExample;

@Service
public class UserLoginRecordService{
	
	@Autowired
	UserLoginRecordMapper userLoginRecordMapper;
	
	public int insertSelective(UserLoginRecord record) {
		return userLoginRecordMapper.insertSelective(record);
	}
	
	public List<UserLoginRecord> selectByExample(UserLoginRecordExample example){
		return userLoginRecordMapper.selectByExample(example);
	}
}