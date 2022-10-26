package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Unit;
import com.example.springboot.service.UnitService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class UnitApiController { 
	
	@Autowired
	UnitService unitService;
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	int applyYear=Integer.valueOf(sdf.format(date).substring(0,4))-1911;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢單位")
	@RequestMapping(value = "/getUnit", method = RequestMethod.POST)
	public List<Unit> getUnit(String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return unitService.selectByExample(null);
	}
}