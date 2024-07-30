package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptExample;
import com.example.springboot.service.AdvancedAgeEmploymentListReceiptService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeEmploymentListReceiptApiController { 
	
	@Autowired
	AdvancedAgeEmploymentListReceiptService advancedAgeEmploymentListReceiptService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用補助名單")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipts", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListReceiptExample example = new AdvancedAgeEmploymentListReceiptExample();
		example.createCriteria().andAdvancedAgeBaseIdEqualTo(advancedAgeEmploymentListReceipt.getAdvancedAgeBaseId());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListReceiptService.selectByExample(example);
	}
	
	@ApiOperation(value = "查詢繼續僱用補助名單 by base請領次數")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceiptsByFrequency", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceiptsByFrequency(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListReceiptExample example = new AdvancedAgeEmploymentListReceiptExample();
		example.createCriteria().andAdvancedAgeBaseIdEqualTo(advancedAgeEmploymentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(advancedAgeEmploymentListReceipt.getBaseAllowanceFrequency());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListReceiptService.selectByExample(example);
	}
	
	@ApiOperation(value = "編輯繼續僱用補助名單")
	@RequestMapping(value = "/editAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public int editAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		return advancedAgeEmploymentListReceiptService.updateByPrimaryKeySelective(advancedAgeEmploymentListReceipt);
	}
}