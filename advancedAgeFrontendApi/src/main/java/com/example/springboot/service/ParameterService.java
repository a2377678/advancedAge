package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.ParameterMapper;
import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterExample;

@Service
public class ParameterService{
	
	@Autowired
	ParameterMapper parameterMapper;
	
	
	public List<Parameter> selectByExample(ParameterExample example) {
		return parameterMapper.selectByExample(example);
	}
	
}