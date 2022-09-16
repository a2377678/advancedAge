package com.example.springboot.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.AdvancedAgeBaseExample;
import com.example.springboot.entity.Attachment;
import com.example.springboot.entity.SiteInspection;
import com.example.springboot.entity.SiteInspectionExample;
import com.example.springboot.service.SiteInspectionService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class SiteInspectionApiController { 
	
	@Autowired
	SiteInspectionService siteInspectionService;
	
	SiteInspection siteInspection;
	
	SiteInspectionExample siteInspectionExample;
	
	@ApiOperation(value = "新增實地查核")
	@RequestMapping(value = "/addSiteInspection", method = RequestMethod.POST)
	public SiteInspection addSiteInspection(SiteInspection siteInspection) {
		int id = siteInspectionService.insertSelective(siteInspection);
		return siteInspection;
	}
	
	@ApiOperation(value = "查詢實地查核")
	@RequestMapping(value = "/selectSiteInspection", method = RequestMethod.POST)
	public List<SiteInspection> selectSiteInspection(SiteInspection siteInspection) {
		siteInspectionExample = new SiteInspectionExample();
		SiteInspectionExample.Criteria c= siteInspectionExample.createCriteria();
		if(!siteInspection.getSeq().equals("")) 
			c.andSeqEqualTo(siteInspection.getSeq());
		if(!siteInspection.getUnit().equals(""))
			c.andUnitEqualTo(siteInspection.getUnit());
		if(!siteInspection.getResult().equals(""))
			if(siteInspection.getResult().equals("1"))
				c.andResultBetween("1", "2");
			else
				c.andResultEqualTo(siteInspection.getResult());
		List<SiteInspection> list = siteInspectionService.selectByExample(siteInspectionExample);
		return list;
	}
	
	@ApiOperation(value = "查詢實地查核資料")
	@RequestMapping(value = "/selectSiteInspectionData", method = RequestMethod.POST)
	public SiteInspection selectSiteInspectionData(SiteInspection siteInspection) {
		return siteInspectionService.selectByPrimaryKey(siteInspection.getId());
	}
	
	@ApiOperation(value = "編輯實地查核資料")
	@RequestMapping(value = "/editSiteInspectionData", method = RequestMethod.POST)
	public SiteInspection editSiteInspectionData(SiteInspection siteInspection) {
		siteInspection.setUpdateTime(new Date());
		siteInspectionService.updateByPrimaryKeySelective(siteInspection);
		return siteInspection;
	}
}