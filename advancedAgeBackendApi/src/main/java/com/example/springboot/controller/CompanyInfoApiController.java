package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.entity.CompanyInfo;
import com.example.springboot.entity.CompanyInfoExample;
import com.example.springboot.service.CompanyInfoService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class CompanyInfoApiController { 
	
	@Autowired
	CompanyInfoService companyInfoService;
	
	CompanyInfoExample companyInfoExample;
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	
	@ApiOperation(value = "查詢申請公司 帳號列表")
	@RequestMapping(value = "/selectCompanyInfo", method = RequestMethod.POST)
	public List<CompanyInfo> selectCompanyInfo(CompanyInfo info) {
		companyInfoExample = new CompanyInfoExample();
		CompanyInfoExample.Criteria c= companyInfoExample.createCriteria();
		if(info.getSeq() != null && !info.getSeq().equals("")) 
			c.andSeqEqualTo(info.getSeq());
		if(info.getCompanyName() != null && !info.getCompanyName().equals(""))
			c.andCompanyNameLike("%"+info.getCompanyName()+"%");
		if(info.getAccountStatus() != null && !info.getAccountStatus().equals("")) {
			c.andAccountStatusEqualTo(info.getAccountStatus());
		}
		List<CompanyInfo> list = companyInfoService.selectByExample(companyInfoExample);
		
		return list;
	}
	
	@ApiOperation(value = "查詢申請公司資料")
	@RequestMapping(value = "/selectCompanyInfoData", method = RequestMethod.POST)
	public CompanyInfo selectCompanyInfoData(CompanyInfo info) {
		return companyInfoService.selectByPrimaryKey(info.getSeq());
	}
	
	@ApiOperation(value = "編輯公司資訊(無卡申請)")
	@RequestMapping(value = "/editCompanyInfo", method = RequestMethod.POST)
	public int editCompanyInfo(CompanyInfo info) {
		info.setUpdateTime(date);
		int a=companyInfoService.updateByPrimaryKeySelective(info);
		
		return a;
	}
}