package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.FunctionList;
import com.example.springboot.entity.FunctionListExample;
import com.example.springboot.service.FunctionListService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class FunctionListApiController { 
	
	@Autowired
	FunctionListService functionListService;
	
	FunctionList functionList;
	
	FunctionListExample functionListExample;
	
	@ApiOperation(value = "查詢function列表")
	@RequestMapping(value = "/selectFunctionList", method = RequestMethod.POST)
	public List<FunctionList> selectFunctionList(FunctionList functionList) {
		return functionListService.selectByExample(null);
	}
}