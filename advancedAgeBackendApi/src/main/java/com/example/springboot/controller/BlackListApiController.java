package com.example.springboot.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.BlackList;
import com.example.springboot.entity.BlackListExample;
import com.example.springboot.service.BlackListService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class BlackListApiController { 
	
	@Autowired
	BlackListService blackListService;
	
	BlackList blackList;
	
	BlackListExample blackListExample;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增黑名單")
	@RequestMapping(value = "/addBlackList", method = RequestMethod.POST)
	public BlackList addBlackList(BlackList blackList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		blackListService.insertSelective(blackList);
		return blackList;
	}
	
	@ApiOperation(value = "查詢黑名單")
	@RequestMapping(value = "/selectBlackList", method = RequestMethod.POST)
	public List<BlackList> selectBlackList(BlackList blackList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		blackListExample = new BlackListExample();
		BlackListExample.Criteria c= blackListExample.createCriteria();
		if(!blackList.getSeq().equals("")) 
			c.andSeqEqualTo(blackList.getSeq());
		if(!blackList.getUnit().equals(""))
			c.andUnitEqualTo(blackList.getUnit());
		if(!blackList.getBanStartDate().equals("")) {
			c.andBanEndDateGreaterThanOrEqualTo(blackList.getBanStartDate());
		}
		if(!blackList.getBanEndDate().equals("")) {
			c.andBanStartDateLessThanOrEqualTo(blackList.getBanEndDate());
		}
		List<BlackList> list = blackListService.selectByExample(blackListExample);
		return list;
	}
	
	@ApiOperation(value = "查詢黑名單資料")
	@RequestMapping(value = "/selectBlackListData", method = RequestMethod.POST)
	public BlackList selectBlackListData(BlackList blackList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return blackListService.selectByPrimaryKey(blackList.getId());
	}
	
	@ApiOperation(value = "編輯黑名單資料")
	@RequestMapping(value = "/editBlackListData", method = RequestMethod.POST)
	public BlackList editBlackListData(BlackList blackList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		blackList.setUpdateTime(new Date());
		blackListService.updateByPrimaryKeySelective(blackList);
		return blackList;
	}
}