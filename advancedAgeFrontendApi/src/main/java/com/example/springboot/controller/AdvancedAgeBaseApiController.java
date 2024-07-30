package com.example.springboot.controller;

import java.nio.charset.StandardCharsets;
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
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentApply;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlan;
import com.example.springboot.entity.AdvancedAgeRetirementReemploymentPlanExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.entity.Unit;
import com.example.springboot.entity.UnitExample;
import com.example.springboot.service.AdvancedAgeBaseService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentApplyService;
import com.example.springboot.service.AdvancedAgeRetirementReemploymentPlanService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceApplyService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceScheduleService;
import com.example.springboot.service.UnitService;
import com.example.springboot.util.DateFormatUtil;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeBaseApiController { 

	@Autowired
	AdvancedAgeBaseService advancedAgeBaseService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceApplyService applyService;
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceScheduleService scheduleService;
	
	@Autowired
	AdvancedAgeRetirementReemploymentApplyService advancedAgeRetirementReemploymentApplyService;
	
	@Autowired
	AdvancedAgeRetirementReemploymentPlanService planService;
	
	AdvancedAgeBaseExample advancedAgeBaseExample;
	
	UnitExample unitExample;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Value("${api_token}")
	private String apiToken;
	
	@Value("${applyYear}")
	private String applyYear;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助附件狀態")
	@RequestMapping(value = "/selectAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(applyYear);
		c.andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		
		return list;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助附件狀態")
	@RequestMapping(value = "/selectATypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectATypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(applyYear);
		c.andCaseTypeEqualTo("A");
		List<AdvancedAgeBase> list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		
		return list;
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫")
	@RequestMapping(value = "/selectBTypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectBTypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(applyYear);
		c.andCaseTypeEqualTo("B");
		List<AdvancedAgeBase> list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		
		return list;
	}
	
	@ApiOperation(value = "查詢再就業補助附件狀態")
	@RequestMapping(value = "/selectCTypeAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectCTypeAdvancedAgeBaseFileStatus(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andYearEqualTo(applyYear);
		c.andCaseTypeEqualTo("C");
		List<AdvancedAgeBase> list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		
		return list;
	}
	

	@ApiOperation(value = "新增繼續僱用高齡者補助申請書中高齡基礎表")
	@RequestMapping(value = "/addATypeAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase addATypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		base.setYear(applyYear);
		base.setCaseType("A");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> totalList=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
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
			base.setReviewStatus("1");
			base.setUnit(unit.get(0).getCode());
			//A1F1111F6180001
			//(繼續僱用/北分署/新北市/線上/111年度/第一次開辦/統編後三碼618/流水號0001)
//			base.setAaid("A"+base.getUnit()+base.getCity()+"1"+base.getYear()+"F"+base.getSeq().substring(5)+String.format("%04d", list.size()+1));
			
			//(僱用退休高齡者/北分署/111年度/09月份/流水號001)
			base.setAaid("A"+base.getUnit()+base.getYear()+dateFormatUtil.getMonth()+String.format("%03d", totalList.size()+1));
			advancedAgeBaseService.insertSelective(base);
		}else {
			AdvancedAgeBase oldBase = list.get(0);
			oldBase.setId(null);
			if(oldBase.getFileStatus().equals("2")) {
				oldBase.setFileStatusRecord(oldBase.getFileStatusRecord()+";4、4、4、4、4、"+asdf.format(new Date()).toString());
				oldBase.setFileStatus("3");
			}
			oldBase.setUpdateTime(new Date());
			oldBase.setReviewStatus("1");
			advancedAgeBaseService.updateByPrimaryKeySelective(oldBase);
		}
		
		return base;
	}
	
	@ApiOperation(value = "新增僱用退休高齡者申請書中高齡基礎表")
	@RequestMapping(value = "/addBTypeAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase addBTypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		base.setYear(applyYear);
		base.setCaseType("B");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> totalList=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andSeqEqualTo(base.getSeq()).andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> list=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		RetirementAdvancedAgeExperienceInheritanceApply searchApply = new RetirementAdvancedAgeExperienceInheritanceApply();
		RetirementAdvancedAgeExperienceInheritanceApplyKey key = new RetirementAdvancedAgeExperienceInheritanceApplyKey();
		key.setApplyYear(base.getYear());
		key.setSeq(base.getSeq());
		searchApply = applyService.selectByPrimaryKey(key);
		
		RetirementAdvancedAgeExperienceInheritanceScheduleExample scheduleExample = new RetirementAdvancedAgeExperienceInheritanceScheduleExample();
		scheduleExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(searchApply.getId());
		List<RetirementAdvancedAgeExperienceInheritanceSchedule> scheduleList=scheduleService.selectByExample(scheduleExample);
		String executionCity="";
		if(scheduleList.size()==0) {
			executionCity=searchApply.getRegisterCity();
		}else {
			for(int i=0;i<scheduleList.size();i++) {
				if(executionCity.equals("")) {
					executionCity=scheduleList.get(i).getExecutionCity();
				}else {
					//多個計畫執行地，用登記地址縣市
					if(!executionCity.equals(scheduleList.get(i).getExecutionCity())) {
						executionCity=searchApply.getRegisterCity();
						break;
					}
				}
			}
		}
		
		base.setCity(executionCity);
		if(list.size()==0)
		{
			unitExample = new UnitExample();
			unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
			List<Unit> unit = unitService.selectByExample(unitExample);
			
			base.setFileStatusRecord("4、4、4、4、4、"+asdf.format(new Date()));
			base.setCaseStatus("1");
			base.setFileStatus("1");
			base.setReviewStatus("1");
			base.setUnit(unit.get(0).getCode());
			//A1F1111F6180001
			//(僱用退休高齡者/北分署/新北市/線上/111年度/第一次開辦/統編後三碼618/流水號0001)
//			base.setAaid("B"+base.getUnit()+base.getCity()+"1"+base.getYear()+"F"+base.getSeq().substring(5)+String.format("%04d", list.size()+1));
			//AA11109001
			//(僱用退休高齡者/北分署/111年度/09月份/流水號001)
			base.setAaid("B"+base.getUnit()+base.getYear()+dateFormatUtil.getMonth()+String.format("%03d", totalList.size()+1));
			advancedAgeBaseService.insertSelective(base);
		}else {
			unitExample = new UnitExample();
			unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
			List<Unit> unit = unitService.selectByExample(unitExample);
			
			AdvancedAgeBase oldBase = list.get(0);
			oldBase.setId(null);
			if(oldBase.getFileStatus().equals("2")) {
				oldBase.setFileStatusRecord(oldBase.getFileStatusRecord()+";4、4、4、4、4、"+asdf.format(new Date()).toString());
				oldBase.setFileStatus("3");
			}
			oldBase.setUnit(unit.get(0).getCode());
			oldBase.setUpdateTime(new Date());
			oldBase.setReviewStatus("1");
			advancedAgeBaseService.updateByPrimaryKeySelective(oldBase);
		}
		
		return base;
	}
	
	@ApiOperation(value = "新增再就業補助申請書中高齡基礎表")
	@RequestMapping(value = "/addCTypeAdvancedAgeBase", method = RequestMethod.POST)
	public AdvancedAgeBase addCTypeAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		base.setYear(applyYear);
		base.setCaseType("C");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> totalList=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andSeqEqualTo(base.getSeq()).andYearEqualTo(base.getYear()).andCaseTypeEqualTo(base.getCaseType());
		List<AdvancedAgeBase> list=advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		AdvancedAgeRetirementReemploymentApply searchApply = new AdvancedAgeRetirementReemploymentApply();
		searchApply.setApplyYear(base.getYear());
		searchApply.setSeq(base.getSeq());
		searchApply = advancedAgeRetirementReemploymentApplyService.selectByPrimaryKey(searchApply);
		
		AdvancedAgeRetirementReemploymentPlan searchPlan = planService.selectByPrimaryKey(searchApply.getId());
		String executionCity = searchPlan.getExecutionCity();
		if(executionCity==null || "".equals(executionCity) || executionCity.split(";").length > 1) {
			executionCity=searchApply.getRegisterCity();
		}
		
		base.setCity(executionCity);
		
		if(list.size()==0)
		{
			unitExample = new UnitExample();
			unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
			List<Unit> unit = unitService.selectByExample(unitExample);
			
			base.setFileStatusRecord("4、4、4、"+asdf.format(new Date()));
			base.setCaseStatus("1");
			base.setFileStatus("1");
			base.setReviewStatus("1");
			base.setUnit(unit.get(0).getCode());
			//C1F1111F6180001
			//(再就業/北分署/新北市/線上/111年度/第一次開辦/統編後三碼618/流水號0001)
//			base.setAaid("C"+base.getUnit()+base.getCity()+"1"+base.getYear().substring(1,3)+"F"+base.getSeq().substring(5)+String.format("%04d", list.size()+1));
//			advancedAgeBaseService.insertSelective(base);
			//AA11109001
			//(再就業高齡者/北分署/111年度/09月份/流水號001)
			base.setAaid("C"+base.getUnit()+base.getYear()+dateFormatUtil.getMonth()+String.format("%03d", totalList.size()+1));
			advancedAgeBaseService.insertSelective(base);
		}else {
			unitExample = new UnitExample();
			unitExample.createCriteria().andIncludeCityLike("%"+base.getCity()+"%");
			List<Unit> unit = unitService.selectByExample(unitExample);
			
			AdvancedAgeBase oldBase = list.get(0);
			oldBase.setId(null);
			if(oldBase.getFileStatus().equals("2")) {
				oldBase.setFileStatusRecord(oldBase.getFileStatusRecord()+";4、4、4、"+asdf.format(new Date()).toString());
				oldBase.setFileStatus("3");
			}
			oldBase.setUnit(unit.get(0).getCode());
			oldBase.setUpdateTime(new Date());
			oldBase.setReviewStatus("1");
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
		SimpleDateFormat asdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		advancedAgeBaseExample.createCriteria().andIdEqualTo(base.getId());
		AdvancedAgeBase searchBase = selectAdvancedAgeBaseById(base,token);
		if(searchBase.getAllowanceFrequencyRecord()==null || searchBase.getAllowanceFrequencyRecord().equals("")) {
			if(searchBase.getCaseType().equals("A")) {
				base.setAllowanceFrequencyRecord("1、"+sdf.format(new Date()).toString()+"、0;");
			}
		}else{
			if(searchBase.getCaseType().equals("A")) {
//				20230202 
//				base.setCaseStatus(null);
				base.setAllowanceFrequencyRecord(searchBase.getAllowanceFrequencyRecord()+(searchBase.getAllowanceFrequencyRecord().split(";").length+1)+"、"+sdf.format(new Date()).toString()+"、0;");
			}
		}
		if(searchBase.getAllowanceFileStatusRecord()==null || searchBase.getAllowanceFileStatusRecord().equals("")) {
			if(searchBase.getCaseType().equals("A")) {
				base.setAllowanceFileStatusRecord("4、4、4、4、4、4、"+asdf.format(new Date()));
			}else if(searchBase.getCaseType().equals("B")) {
				base.setAllowanceFileStatusRecord("4、4、4、4、4、4、"+asdf.format(new Date()));
			}else if(searchBase.getCaseType().equals("C")) {
				base.setAllowanceFileStatusRecord("4、4、4、4、4、"+asdf.format(new Date()));
			}
			base.setAllowanceFileStatus("1");
		}else {
			if(searchBase.getCaseType().equals("A")) {
				base.setAllowanceFileStatusRecord(searchBase.getAllowanceFileStatusRecord()+";4、4、4、4、4、4、"+asdf.format(new Date()));
			}else if(searchBase.getCaseType().equals("B")) {
				base.setAllowanceFileStatusRecord(searchBase.getAllowanceFileStatusRecord()+";4、4、4、4、4、4、"+asdf.format(new Date()));
			}else if(searchBase.getCaseType().equals("C")) {
				base.setAllowanceFileStatusRecord(searchBase.getAllowanceFileStatusRecord()+";4、4、4、4、4、"+asdf.format(new Date()));
			}
			base.setAllowanceFileStatus("3");
		}
		base.setId(null);
		base.setUpdateTime(new Date());
		advancedAgeBaseService.updateByExampleSelective(base, advancedAgeBaseExample);
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
		AdvancedAgeBase searchBase = advancedAgeBaseService.selectByExample(advancedAgeBaseExample).get(0);
		return searchBase;
	}
	
	@ApiOperation(value = "查詢繼續僱用高齡者請領資料")
	@RequestMapping(value = "/selectAllowanceAdvancedAgeBase", method = RequestMethod.POST)
	public List<AdvancedAgeBase> selectAllowanceAdvancedAgeBase(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		advancedAgeBaseExample = new AdvancedAgeBaseExample();
		AdvancedAgeBaseExample.Criteria c= advancedAgeBaseExample.createCriteria();
		c.andSeqEqualTo(base.getSeq());
		c.andCaseTypeEqualTo("A");
		advancedAgeBaseExample.setOrderByClause("year desc");
		List<AdvancedAgeBase> list = advancedAgeBaseService.selectByExample(advancedAgeBaseExample);
		
		return list;
	}
}