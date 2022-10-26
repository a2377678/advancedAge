package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "新增公司資訊(無卡申請)")
	@RequestMapping(value = "/addCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo addCompanyInfo(CompanyInfo info,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectCompanyInfo(info,token) == null)
		{
			companyInfoService.insertSelective(info);
		}
		else
		{
			info.setUpdateTime(date);
			companyInfoService.updateByPrimaryKeySelective(info);
		}
		return selectCompanyInfo(info,token) == null?info:selectCompanyInfo(info,token);
	}
	
	@ApiOperation(value = "查詢公司資訊")
	@RequestMapping(value = "/selectCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo selectCompanyInfo(CompanyInfo info,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return companyInfoService.selectByPrimaryKey(info.getSeq());
	}
	
	@ApiOperation(value = "編輯公司資訊(無卡申請)")
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo editCompanyInfo(CompanyInfo info,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		companyInfoExample = new CompanyInfoExample();
		companyInfoExample.createCriteria().andSeqEqualTo(info.getSeq()).andCompanyNameEqualTo(info.getCompanyName())
		.andContactNameEqualTo(info.getContactName()).andContactJobtitleEqualTo(info.getContactJobtitle())
		.andContactWorkPhoneAreaCodeEqualTo(info.getContactWorkPhoneAreaCode()).andContactWorkPhoneEqualTo(info.getContactWorkPhone())
		.andContactWorkPhoneExtensionEqualTo(info.getContactWorkPhoneExtension()).andContactPhoneEqualTo(info.getContactPhone())
		.andEmailEqualTo(info.getEmail());
		info.setUpdateTime(new Date());
		companyInfoService.updateByExampleSelective(info, companyInfoExample);
		
		return companyInfoService.selectByPrimaryKey(info.getSeq());
	}
	
	@ApiOperation(value = "查詢公司資訊(登入、改密碼)")
	@RequestMapping(value = "/checkCompanyInfo", method = RequestMethod.POST)
	public CompanyInfo checkCompanyInfo(CompanyInfo info,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		companyInfoExample = new CompanyInfoExample();
		companyInfoExample.createCriteria().andSeqEqualTo(info.getSeq()).andPasswordEqualTo(info.getPassword());
		return companyInfoService.selectByExample(companyInfoExample).size()>0?companyInfoService.selectByExample(companyInfoExample).get(0):new CompanyInfo();
	}
	
	@ApiOperation(value = "查詢公司資訊(登入、改密碼)")
	@RequestMapping(value = "/changeCompanyPassword", method = RequestMethod.POST)
	public int changeCompanyPassword(CompanyInfo info,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		return companyInfoService.updateByPrimaryKeySelective(info);
	}
}