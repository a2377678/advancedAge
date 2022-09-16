package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.CompanyInfoExample;
import com.example.springboot.service.CompanyInfoService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class CompanyInfoApiController { 
	
	@Autowired
	CompanyInfoService companyInfoService;
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	CompanyInfoExample companyInfoExample;
	
	@ApiOperation(value = "新增公司資訊(無卡申請)")
	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo addCompanyInfo(CompanyInfo info) {
		if(selectCompanyInfo(info) == null)
		{
			int a=companyInfoService.insertSelective(info);
		}
		else
		{
			info.setUpdateTime(date);
			int a=companyInfoService.updateByPrimaryKeySelective(info);
		}
		return selectCompanyInfo(info) == null?info:selectCompanyInfo(info);
	}
	
	@ApiOperation(value = "查詢公司資訊")
	@RequestMapping(value = "/selectCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo selectCompanyInfo(CompanyInfo info) {
		
		return companyInfoService.selectByPrimaryKey(info.getSeq());
	}
	
	@ApiOperation(value = "編輯公司資訊(無卡申請)")
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public int editCompanyInfo(CompanyInfo info) {
		companyInfoExample = new CompanyInfoExample();
		companyInfoExample.createCriteria().andSeqEqualTo(info.getSeq()).andCompanyNameEqualTo(info.getCompanyName())
		.andContactNameEqualTo(info.getContactName()).andContactJobtitleEqualTo(info.getContactJobtitle())
		.andContactWorkPhoneAreaCodeEqualTo(info.getContactWorkPhoneAreaCode()).andContactWorkPhoneEqualTo(info.getContactWorkPhone())
		.andContactWorkPhoneExtensionEqualTo(info.getContactWorkPhoneExtension()).andContactPhoneEqualTo(info.getContactPhone())
		.andEmailEqualTo(info.getEmail()).andAccountStatusEqualTo(info.getAccountStatus());
		
		int a = companyInfoService.updateByExampleSelective(info, companyInfoExample);
		
		return a;
	}
	
	@ApiOperation(value = "查詢公司資訊(登入、改密碼)")
	@RequestMapping(value = "/checkCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo checkCompanyInfo(CompanyInfo info) {
		companyInfoExample = new CompanyInfoExample();
		companyInfoExample.createCriteria().andSeqEqualTo(info.getSeq()).andPasswordEqualTo(info.getPassword());
		return companyInfoService.selectByExample(companyInfoExample).size()>0?companyInfoService.selectByExample(companyInfoExample).get(0):new CompanyInfo();
	}
	
	@ApiOperation(value = "查詢公司資訊(登入、改密碼)")
	@RequestMapping(value = "/changeCompanyPassword", method = RequestMethod.POST)
	public int changeCompanyPassword(CompanyInfo info) {
		return companyInfoService.updateByPrimaryKeySelective(info);
	}
}