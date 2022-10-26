package com.example.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.UserInfo;
import com.example.springboot.entity.UserInfoExample;
import com.example.springboot.service.UserInfoService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class UserInfoApiController { 
	
	@Autowired
	UserInfoService userInfoService;
	
	UserInfo userInfo;
	
	UserInfoExample userInfoExample;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增使用者")
	@RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
	public int addUserInfo(UserInfo userInfo,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		
		return userInfoService.insertSelective(userInfo);
	}
	
	@ApiOperation(value = "查詢使用者名單")
	@RequestMapping(value = "/selectUserInfo", method = RequestMethod.POST)
	public List<UserInfo> selectUserInfo(UserInfo userInfo,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		userInfoExample = new UserInfoExample();
		UserInfoExample.Criteria c= userInfoExample.createCriteria();
		if(userInfo.getUnit() != null && !userInfo.getUnit().equals("")) 
			c.andUnitEqualTo(userInfo.getUnit());
		if(userInfo.getJurisdiction() != null)
			c.andJurisdictionEqualTo(userInfo.getJurisdiction());
		if(userInfo.getStatus() != null) {
			c.andStatusEqualTo(userInfo.getStatus());
		}
		if(userInfo.getName() != null && !userInfo.getName().equals("")) {
			c.andNameLike("%"+userInfo.getName()+"%");
		}
		if(userInfo.getAccount() != null && !userInfo.getAccount().equals("")) {
			c.andAccountLike("%"+userInfo.getAccount()+"%");
		}
		List<UserInfo> list = userInfoService.selectByExample(userInfoExample);
		return list;
	}
	
	@ApiOperation(value = "查詢使用者資料")
	@RequestMapping(value = "/selectUserInfoData", method = RequestMethod.POST)
	public UserInfo selectUserInfoData(UserInfo userInfo,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return userInfoService.selectByPrimaryKey(userInfo.getAccount());
	}
	
	@ApiOperation(value = "使用者登入")
	@RequestMapping(value = "/selectUserInfoLogin", method = RequestMethod.POST)
	public UserInfo selectUserInfoLogin(UserInfo userInfo,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		userInfoExample = new UserInfoExample();
		UserInfoExample.Criteria c= userInfoExample.createCriteria();
		c.andAccountEqualTo(userInfo.getAccount()).andPasswordEqualTo(userInfo.getPassword());
		List<UserInfo> loginList = userInfoService.selectByExample(userInfoExample);
		UserInfo login = new UserInfo();
		if(loginList.size()>0)
		{
			login = loginList.get(0);
		}
		return login;
	}
	
	@ApiOperation(value = "編輯使用者資料")
	@RequestMapping(value = "/editUserInfoData", method = RequestMethod.POST)
	public int editUserInfoData(UserInfo userInfo,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		userInfo.setUpdateTime(new Date());
		return userInfoService.updateByPrimaryKeySelective(userInfo);
	}
}