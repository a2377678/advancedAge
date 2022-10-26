package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Parameter;
import com.example.springboot.entity.ParameterExample;
import com.example.springboot.service.ParameterService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class ParameterApiController { 
	
	@Autowired
	ParameterService parameterService;
	
	ParameterExample parameterExample;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢產業別")
	@RequestMapping(value = "/getIndustryList", method = RequestMethod.POST)
	public List<Parameter> getIndustryList(String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		parameterExample = new ParameterExample();
		parameterExample.setOrderByClause("code");
		parameterExample.createCriteria().andIdentifyCodeLike("industry");
		List<Parameter> list = parameterService.selectByExample(parameterExample);
		return list; 
	}
	
	@ApiOperation(value = "查詢縣市")
	@RequestMapping(value = "/getCityList", method = RequestMethod.POST)
	public List<Parameter> getCityList(String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		parameterExample = new ParameterExample();
		parameterExample.createCriteria().andIdentifyCodeLike("city");
		List<Parameter> list = parameterService.selectByExample(parameterExample);
		
		return list; 
	}
	
	@ApiOperation(value = "查詢地區")
	@RequestMapping(value = "/getAreaList", method = RequestMethod.POST)
	public List<Parameter> getAreaList(@RequestParam(value="cityCode") String cityCode,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		parameterExample = new ParameterExample();
		parameterExample.createCriteria().andIdentifyCodeLike("area").andCodeLike(cityCode+"%");
		List<Parameter> list = parameterService.selectByExample(parameterExample);
		
		return list; 
	}
}