package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.UnitMapper;
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UnitExample;

@Service
public class UnitService{
	
	@Autowired
	UnitMapper unitMapper;
	
	public List<Unit> selectByExample(UnitExample example){
		return unitMapper.selectByExample(example);
	}
	
}