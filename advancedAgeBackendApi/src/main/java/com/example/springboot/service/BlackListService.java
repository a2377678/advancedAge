package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.BlackListMapper;
import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.BlackListExample;

@Service
public class BlackListService{
	
	@Autowired
	BlackListMapper blackListMapper;
	
	public int insertSelective(BlackList record) {
		return blackListMapper.insertSelective(record);
	}
	
	public List<BlackList> selectByExample(BlackListExample example){
		return blackListMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(BlackList record) {
		return blackListMapper.updateByPrimaryKeySelective(record);
	}
	
	public BlackList selectByPrimaryKey(Integer id) {
		return blackListMapper.selectByPrimaryKey(id);
	}
}