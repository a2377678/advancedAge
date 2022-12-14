package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.FunctionPermission;
import com.example.springboot.entity.FunctionPermissionExample;
import com.example.springboot.service.FunctionPermissionService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class FunctionPermissionApiController { 
	
	@Autowired
	FunctionPermissionService functionPermissionService;
	
	FunctionPermission functionPermission;
	
	FunctionPermissionExample functionPermissionExample;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢function列表")
	@RequestMapping(value = "/selectFunctionPermission", method = RequestMethod.POST)
	public FunctionPermission selectFunctionPermission(FunctionPermission functionPermission,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return functionPermissionService.selectByPrimaryKey(functionPermission.getJurisdiction());
	}
	
	@ApiOperation(value = "編輯function列表")
	@RequestMapping(value = "/editFunctionPermission", method = RequestMethod.POST)
	public FunctionPermission editFunctionPermission(FunctionPermission functionPermission,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		functionPermission.setUpdateTime(new Date());
		functionPermissionService.updateByPrimaryKeySelective(functionPermission);
		return functionPermission;
	}
}