package com.example.springboot.controller;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
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
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UnitExample;
import com.example.springboot.service.AdvancedAgeBaseService;
import com.example.springboot.service.UnitService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeBaseApiController { 

	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	@Autowired
	AdvancedAgeBaseService advancedAgeBaseApplyService;
	
	@Autowired
	UnitService unitService;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	UnitExample unitExample;
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	int applyYear=Integer.valueOf(sdf.format(date).substring(0,4))-1911;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助附件狀態")
	@RequestMapping(value = "/selectATypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectATypeAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(String.valueOf(applyYear));
		c.andCaseTypeEqualTo("A");
		List<AdvancedAgeBase> list = advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample);
		return list;
	}
	

	@ApiOperation(value = "新增繼續僱用高齡者補助申請書中高齡基礎表")
	@RequestMapping(value = "/addATypeAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase addAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		base.setYear(String.valueOf(applyYear));
		base.setCaseType("A");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andSeqEqualTo(base.getSeq()).andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> list=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		if(list.size()==0)
		{
			unitExample = new UnitExample();
			unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
			List<Unit> unit = unitService.selectByExample(unitExample);
			
			base.setFileStatusRecord("4、4、4、4、4、"+asdf.format(new Date()));
			base.setCaseStatus("1");
			base.setFileStatus("1");
			base.setUnit(unit.get(0).getCode());
			//A1F1111F6180001
			//(繼續僱用/北分署/新北市/線上/111年度/第一次開辦/統編後三碼618/流水號0001)
			base.setAaid("A"+base.getUnit()+base.getCity()+"1"+base.getYear().substring(1,3)+"F"+base.getSeq().substring(5)+String.format("%04d", list.size()+1));
			advancedAgeBaseService.insertSelective(base);
		}else {
			AdvancedAgeBase oldBase = list.get(0);
			oldBase.setId(null);
			oldBase.setFileStatusRecord(oldBase.getFileStatusRecord()+";4、4、4、4、4、"+asdf.format(new Date()).toString());
			oldBase.setFileStatus("3");
			oldBase.setUpdateTime(new Date());
			advancedAgeBaseService.updateByPrimaryKeySelective(oldBase);
		}
		
		return base;
	}
	
	@ApiOperation(value = "編輯繼續僱用高齡者補助狀態")
	@RequestMapping(value = "/editAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase editAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andIdEqualTo(base.getId());
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base,token);
		if(searchBase.getAllowanceFrequencyRecord()==null || searchBase.getAllowanceFrequencyRecord().equals("")) {
			base.setAllowanceFrequencyRecord("1、"+sdf.format(new Date()).toString()+"、0;");
		}else{
			base.setCaseStatus(null);
			base.setAllowanceFrequencyRecord(searchBase.getAllowanceFrequencyRecord()+(searchBase.getAllowanceFrequencyRecord().split(";").length+1)+"、"+sdf.format(new Date()).toString()+"、0;");
		}
		base.setId(null);
		base.setUpdateTime(new Date());
		advancedAgeBaseApplyService.updateByExampleSelective(base, advancedAgeBaseExample);
		return base;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助狀態")
	@RequestMapping(value = "/selectAdvancedAgeBaseById", method = RequestMethod.POST)
	public AdvancedAgeBase selectAdvancedAgeBaseById(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andIdEqualTo(base.getId());
		AdvancedAgeBase searchBase = advancedAgeBaseApplyService.selectByExample(advancedAgeBaseExample).get(0);
		return searchBase;
	}
}