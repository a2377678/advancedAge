package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.UserInfoMapper;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.entity.UserInfoExample;

@Service
public class UserInfoService{
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	public int insertSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}
	
	public List<UserInfo> selectByExample(UserInfoExample example){
		return userInfoMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(UserInfo record) {
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	public UserInfo selectByPrimaryKey(String account) {
		return userInfoMapper.selectByPrimaryKey(account);
	}
}