package com.example.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.UserLoginRecord;
import com.example.springboot.entity.UserLoginRecordExample;
import com.example.springboot.service.UserLoginRecordService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class UserLoginRecordApiController { 

	Logger logger = LogManager.getLogger(UserLoginRecordApiController.class);
	
	@Autowired
	UserLoginRecordService userLoginRecordService;
	
	UserLoginRecord userLoginRecord;
	
	UserLoginRecordExample userLoginRecordExample;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增登入紀錄")
	@RequestMapping(value = "/addUserLoginRecord", method = RequestMethod.POST)
	public int addUserLoginRecord(UserLoginRecord userLoginRecord,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		
		return userLoginRecordService.insertSelective(userLoginRecord);
	}
	
	@ApiOperation(value = "查詢登入紀錄")
	@RequestMapping(value = "/selectUserLoginRecord", method = RequestMethod.POST)
	public List<UserLoginRecord> selectUserLoginRecord(UserLoginRecord userLoginRecord,String loginStartDate,String loginEndDate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		userLoginRecordExample = new UserLoginRecordExample();
		UserLoginRecordExample.Criteria c= userLoginRecordExample.createCriteria();
//		UserLoginRecordExample.Criteria c2= userLoginRecordExample.createCriteria();
		if(userLoginRecord.getUnit() != null && !userLoginRecord.getUnit().equals("")) 
			c.andUnitEqualTo(userLoginRecord.getUnit());
		if(userLoginRecord.getJurisdiction() != null)
			c.andJurisdictionEqualTo(userLoginRecord.getJurisdiction());
		if(userLoginRecord.getUsername() != null && !userLoginRecord.getUsername().equals("")) {
			c.andUsernameLike("%"+userLoginRecord.getUsername()+"%");
		}
		if(!loginStartDate.equals("")) {
			loginStartDate = Integer.valueOf(loginStartDate.substring(0,3))+1911+loginStartDate.substring(3)+" 00:00:00";
			try {
				c.andLoginTimeGreaterThan(formatter.parse(loginStartDate));
			} catch (ParseException e) {
				logger.warn(e.getMessage());
			}
		}
		if(!loginEndDate.equals("")) {
			loginEndDate = Integer.valueOf(loginEndDate.substring(0,3))+1911+loginEndDate.substring(3)+" 23:59:59";
			try {
				c.andLoginTimeLessThan(formatter.parse(loginEndDate));
			} catch (ParseException e) {
				logger.warn(e.getMessage());
			}
		}
		userLoginRecordExample.setOrderByClause("login_time desc");
		List<UserLoginRecord> list = userLoginRecordService.selectByExample(userLoginRecordExample);
		return list;
	}
}