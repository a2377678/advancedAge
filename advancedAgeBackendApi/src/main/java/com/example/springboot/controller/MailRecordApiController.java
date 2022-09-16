package com.example.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.MailRecord;
import com.example.springboot.entity.MailRecordExample;
import com.example.springboot.service.MailRecordService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class MailRecordApiController { 
	
	@Autowired
	MailRecordService mailRecordService;
	
	MailRecordExample mailRecordExample;
	
	@ApiOperation(value = "新增信件紀錄")
	@RequestMapping(value = "/addMailRecord", method = RequestMethod.POST)
	public MailRecord addMailRecord(MailRecord mailRecord) {
		mailRecordService.insertSelective(mailRecord);
		return mailRecord;
	}
	
	@ApiOperation(value = "查詢信件紀錄")
	@RequestMapping(value = "/selectMailRecord", method = RequestMethod.POST)
	public List<MailRecord> selectMailRecord(MailRecord mailRecord) {
		mailRecordExample = new MailRecordExample();
		mailRecordExample.createCriteria().andAdvancedAgeBaseIdEqualTo(mailRecord.getAdvancedAgeBaseId());
		mailRecordExample.setOrderByClause("id asc");
		return mailRecordService.selectByExample(mailRecordExample);
	}
}