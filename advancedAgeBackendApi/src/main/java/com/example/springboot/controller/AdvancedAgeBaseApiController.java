package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.service.AdvancedAgeBaseService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeBaseApiController { 
	
	@Autowired
	AdvancedAgeBaseService advancedAgeBaseApplyService;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	int applyYear=Integer.valueOf(sdf.format(date).substring(0,4))-1911;
	
	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助")
	@RequestMapping(value = "/selectATypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectATypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		if(base.getSeq() != null && !base.getSeq().equals("")) 
			c.andSeqEqualTo(base.getSeq());
		if(base.getUnit() != null && !base.getUnit().equals(""))
			c.andUnitEqualTo(base.getUnit());
		if(base.getYear() != null && !base.getYear().equals(""))
			c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("A");
		if(base.getCompanyName() != null && !base.getCompanyName().equals(""))
			c.andCompanyNameLike("%"+base.getCompanyName()+"%");
		if(base.getCaseStatus() != null && !base.getCaseStatus().equals(""))
		{	if(base.getCaseStatus().length()>1)
			{
				List<String> caseStatus = new ArrayList<String>();
				for(String status:base.getCaseStatus().split("、")) {
					caseStatus.add(status);
				}
				c.andCaseStatusIn(caseStatus);
			}
			else {
				c.andCaseStatusEqualTo(base.getCaseStatus());
			}
		}
		if(base.getFileStatus() != null && !base.getFileStatus().equals(""))
			c.andFileStatusEqualTo(base.getFileStatus());
		List<AdvancedAgeBase> list = advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample);
		return list;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助附件狀態")
	@RequestMapping(value = "/selectATypeAdvancedAgeBaseFileStatus", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectATypeAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		if(!base.getSeq().equals("")) 
			c.andSeqEqualTo(base.getSeq());
		if(!base.getUnit().equals(""))
			c.andUnitEqualTo(base.getUnit());
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("A");
		c.andFileStatusEqualTo(base.getFileStatus());
		List<AdvancedAgeBase> list = advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample);
		return list;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助附件紀錄")
	@RequestMapping(value = "/selectATypeAdvancedAgeBaseFileStatusRecord", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectATypeAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("A");
		c.andIdEqualTo(base.getId());
		List<AdvancedAgeBase> list = advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample);
		return list;
	}
	
	@ApiOperation(value = "繼續僱用高齡者補助附件紀錄")
	@RequestMapping(value = "/fileStatusSave", method = RequestMethod.POST)
	public AdvancedAgeBase fileStatusSave(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseApplyService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "繼續僱用高齡者附件狀態")
	@RequestMapping(value = "/changeFileStatus", method = RequestMethod.POST)
	public AdvancedAgeBase changeFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseApplyService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "儲存繼續僱用高齡者資料")
	@RequestMapping(value = "/saveBase", method = RequestMethod.POST)
	public AdvancedAgeBase saveBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		base.setUpdateTime(new Date());
		advancedAgeBaseApplyService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "繼續僱用高齡者附件狀態_寄信")
	@RequestMapping(value = "/changeEmailTime", method = RequestMethod.POST)
	public AdvancedAgeBase changeEmailTime(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		base.setEmailTime(new Date());
		advancedAgeBaseApplyService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助資料")
	@RequestMapping(value = "/selectATypeAdvancedAgeBaseData", method = RequestMethod.POST)
	public AdvancedAgeBase selectATypeAdvancedAgeBaseData(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		if(!base.getSeq().equals("")) 
			c.andSeqEqualTo(base.getSeq());
		if(!base.getYear().equals(""))
			c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("A");
		
		AdvancedAgeBase result=advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample).get(0);
		return result;
	}
}