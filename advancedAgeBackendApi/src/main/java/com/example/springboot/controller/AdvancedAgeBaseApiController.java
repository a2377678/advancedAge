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
import com.example.springboot.util.DateFormatUtil;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeBaseApiController { 
	
	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
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
		if(base.getCity() != null && !base.getCity().equals(""))
			c.andCityEqualTo(base.getCity());
		if(base.getFileStatus() != null && !base.getFileStatus().equals(""))
			c.andFileStatusEqualTo(base.getFileStatus());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢所有補助")
	@RequestMapping(value = "/selectAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectAdvancedAgeBase(AdvancedAgeBase base,String token) {
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
		c.andCaseTypeEqualTo(base.getCaseType());
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
		if(base.getFileStatus() != null && !base.getFileStatus().equals("")) {
			if(base.getFileStatus().length()>1)
			{
				List<String> fileStatus = new ArrayList<String>();
				for(String status:base.getFileStatus().split("、")) {
					fileStatus.add(status);
				}
				c.andFileStatusIn(fileStatus);
			}
			else {
				c.andFileStatusEqualTo(base.getFileStatus());
			}
		}
		if(base.getCity() != null && !base.getCity().equals(""))
			c.andCityEqualTo(base.getCity());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
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
		if(base.getSeq() != null && !base.getSeq().equals("")) 
			c.andSeqEqualTo(base.getSeq());
		if(base.getUnit() != null && !base.getUnit().equals(""))
			c.andUnitEqualTo(base.getUnit());
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("A");
		if(base.getFileStatus().length()>1)
		{
			List<String> fileStatus = new ArrayList<String>();
			for(String status:base.getFileStatus().split("、")) {
				fileStatus.add(status);
			}
			c.andFileStatusIn(fileStatus);
		}
		else {
			c.andFileStatusEqualTo(base.getFileStatus());
		}
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢附件狀態")
	@RequestMapping(value = "/selectAdvancedAgeBaseFileStatus", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
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
		c.andCaseTypeEqualTo(base.getCaseType());
		c.andFileStatusEqualTo(base.getFileStatus());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(!"".equals(base.getCaseType())) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
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
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢所有補助附件紀錄")
	@RequestMapping(value = "/selectAdvancedAgeBaseFileStatusRecord", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo(base.getCaseType());
		c.andIdEqualTo(base.getId());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "繼續僱用高齡者補助附件紀錄")
	@RequestMapping(value = "/fileStatusSave", method = RequestMethod.POST)
	public AdvancedAgeBase fileStatusSave(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "繼續僱用高齡者附件狀態")
	@RequestMapping(value = "/changeFileStatus", method = RequestMethod.POST)
	public AdvancedAgeBase changeFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		base.setEmailTime(new Date());
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "繼續僱用高齡者附件狀態")
	@RequestMapping(value = "/changeFileStatus2", method = RequestMethod.POST)
	public AdvancedAgeBase changeFileStatus2(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		base.setReviewEmailTime(new Date());
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
		return base;
	}
	
	@ApiOperation(value = "繼續僱用高齡者附件狀態")
	@RequestMapping(value = "/changeFileStatus3", method = RequestMethod.POST)
	public AdvancedAgeBase changeFileStatus3(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		base.setAllowanceEmailTime(new Date());
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
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
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
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
		advancedAgeBaseService.updateByPrimaryKeySelective(base);
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
		AdvancedAgeBase result= new AdvancedAgeBase();
		if(token.equals(apiToken)) {
			result=advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		}
		return result;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助資料")
	@RequestMapping(value = "/selectCTypeAdvancedAgeBaseData", method = RequestMethod.POST)
	public AdvancedAgeBase selectCTypeAdvancedAgeBaseData(AdvancedAgeBase base,String token) {
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
		c.andCaseTypeEqualTo("C");
		AdvancedAgeBase result= new AdvancedAgeBase();
		if(token.equals(apiToken)) {
			result=advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		}
		return result;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗補助")
	@RequestMapping(value = "/selectBTypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectBTypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
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
		c.andCaseTypeEqualTo("B");
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
		if(base.getCity() != null && !base.getCity().equals(""))
			c.andCityEqualTo(base.getCity());
		if(base.getFileStatus() != null && !base.getFileStatus().equals(""))
			c.andFileStatusEqualTo(base.getFileStatus());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗補助附件狀態")
	@RequestMapping(value = "/selectBTypeAdvancedAgeBaseFileStatus", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectBTypeAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
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
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("B");
		if(base.getFileStatus().length()>1)
		{
			List<String> fileStatus = new ArrayList<String>();
			for(String status:base.getFileStatus().split("、")) {
				fileStatus.add(status);
			}
			c.andFileStatusIn(fileStatus);
		}
		else {
			c.andFileStatusEqualTo(base.getFileStatus());
		}
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗補助附件狀態")
	@RequestMapping(value = "/selectCTypeAdvancedAgeBaseFileStatus", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectCTypeAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
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
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("C");
		if(base.getFileStatus().length()>1)
		{
			List<String> fileStatus = new ArrayList<String>();
			for(String status:base.getFileStatus().split("、")) {
				fileStatus.add(status);
			}
			c.andFileStatusIn(fileStatus);
		}
		else {
			c.andFileStatusEqualTo(base.getFileStatus());
		}
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗補助附件紀錄")
	@RequestMapping(value = "/selectBTypeAdvancedAgeBaseFileStatusRecord", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectBTypeAdvancedAgeBaseFileStatusRecord(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(base.getYear());
		c.andCaseTypeEqualTo("B");
		c.andIdEqualTo(base.getId());
		List<AdvancedAgeBase> list = new ArrayList<>();
		if(token.equals(apiToken)) {
			list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		}
		return list;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗補助資料")
	@RequestMapping(value = "/selectBTypeAdvancedAgeBaseData", method = RequestMethod.POST)
	public AdvancedAgeBase selectBTypeAdvancedAgeBaseData(AdvancedAgeBase base,String token) {
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
		c.andCaseTypeEqualTo("B");
		AdvancedAgeBase result= new AdvancedAgeBase();
		if(token.equals(apiToken)) {
			result=advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		}
		return result;
	}
}