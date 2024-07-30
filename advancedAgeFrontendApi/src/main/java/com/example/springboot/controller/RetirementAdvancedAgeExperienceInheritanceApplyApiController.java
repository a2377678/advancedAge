package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import com.example.springboot.entity.ExperienceInheritanceSpeakerList;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListExample;
import com.example.springboot.entity.ExperienceInheritanceSpeakerListKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApply;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceApplyKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditure;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceExpenditureKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlan;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritancePlanExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResult;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceResultKey;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceSchedule;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleExample;
import com.example.springboot.entity.RetirementAdvancedAgeExperienceInheritanceScheduleKey;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudent;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentExample;
import com.example.springboot.entity.RetirementAdvancedAgeParticipateStudentKey;
import com.example.springboot.service.AdvancedAgeBaseService;
import com.example.springboot.service.ExperienceInheritanceSpeakerListService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceApplyService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceExpenditureService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritancePlanService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceResultService;
import com.example.springboot.service.RetirementAdvancedAgeExperienceInheritanceScheduleService;
import com.example.springboot.service.RetirementAdvancedAgeParticipateStudentService;
import com.example.springboot.util.DateFormatUtil;

import io.swagger.annotations.ApiOperation;

@RestController 
public class RetirementAdvancedAgeExperienceInheritanceApplyApiController { 
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceApplyService applyService;
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritancePlanService planService;
	
	@Autowired
	ExperienceInheritanceSpeakerListService speakerListService;

	@Autowired
	RetirementAdvancedAgeExperienceInheritanceScheduleService scheduleService;

	@Autowired
	RetirementAdvancedAgeParticipateStudentService participateService;
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceExpenditureService expenditureService;
	
	@Autowired
	RetirementAdvancedAgeExperienceInheritanceResultService resultService;
	
	RetirementAdvancedAgeExperienceInheritanceApplyExample applyExample;
	
	RetirementAdvancedAgeExperienceInheritancePlanExample planExample;
	
	ExperienceInheritanceSpeakerListExample speakerListExample;
	
	ExperienceInheritanceSpeakerListKey speakerListKey ;
	
	RetirementAdvancedAgeExperienceInheritanceScheduleExample scheduleExample;
	
	RetirementAdvancedAgeExperienceInheritanceScheduleKey scheduleKey;
	
	RetirementAdvancedAgeParticipateStudentExample participateExample;
	
	RetirementAdvancedAgeParticipateStudentKey participateKey;
	
	RetirementAdvancedAgeExperienceInheritanceExpenditureKey expenditureKey;
	
	RetirementAdvancedAgeExperienceInheritanceExpenditureExample expenditureExample;
	
	RetirementAdvancedAgeExperienceInheritanceResultKey resultKey;
	
	DateFormatUtil dateFormatUtil;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Value("${api_token}")
	private String apiToken;

	@Value("${applyYear}")
	private String applyYear;
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_申請書")
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceApply", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceApply addRetirementAdvancedAgeExperienceInheritanceApply(RetirementAdvancedAgeExperienceInheritanceApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		apply.setApplyYear(applyYear);
		if(selectRetirementAdvancedAgeExperienceInheritanceApply(apply,token) == null)
		{
			applyService.insertSelective(apply);
		}
		else
		{
			apply.setUpdateTime(dateFormatUtil.getDate());
			applyService.updateByPrimaryKeySelective(apply);
		}
		return selectRetirementAdvancedAgeExperienceInheritanceApply(apply,token) == null?apply:selectRetirementAdvancedAgeExperienceInheritanceApply(apply,token);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_申請書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceApply", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceApply selectRetirementAdvancedAgeExperienceInheritanceApply(RetirementAdvancedAgeExperienceInheritanceApply apply,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		RetirementAdvancedAgeExperienceInheritanceApplyKey key = new RetirementAdvancedAgeExperienceInheritanceApplyKey();
		if(apply.getApplyYear() == null || apply.getApplyYear().equals(""))
		{
			key.setApplyYear(applyYear);
		}else {
			key.setApplyYear(apply.getApplyYear());
		}
		key.setSeq(apply.getSeq());
		return applyService.selectByPrimaryKey(key);
	}
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_計畫書")
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritancePlan", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritancePlan addRetirementAdvancedAgeExperienceInheritancePlan(RetirementAdvancedAgeExperienceInheritancePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		dateFormatUtil = new DateFormatUtil(new Date());
		plan.setApplyYear(applyYear);
		if(selectRetirementAdvancedAgeExperienceInheritancePlan(plan,token) == null)
		{
			planService.insertSelective(plan);
		}
		else
		{
			planService.updateByPrimaryKeySelective(plan);
		}
		return selectRetirementAdvancedAgeExperienceInheritancePlan(plan,token) == null?plan:selectRetirementAdvancedAgeExperienceInheritancePlan(plan,token);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_計畫書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritancePlan", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritancePlan selectRetirementAdvancedAgeExperienceInheritancePlan(RetirementAdvancedAgeExperienceInheritancePlan plan,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return planService.selectByPrimaryKey(plan.getRetirementAdvancedAgeExperienceInheritanceApplyId());
	}
	
	@ApiOperation(value = "新增傳承專業技術及經驗之講師名單")
	@RequestMapping(value = "/addExperienceInheritanceSpeakerList", method = RequestMethod.POST)
	public ExperienceInheritanceSpeakerList addExperienceInheritanceSpeakerList(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectExperienceInheritanceSpeakerList(speakerList,token) == null)
		{
			speakerListService.insertSelective(speakerList);
		}
		else
		{
			if(speakerList.getLaborProtectionTime()==null) {
				speakerList.setLaborProtectionTime("");
			}
			else if(speakerList.getOccupationalAccidentProtectionTime()==null) {
				speakerList.setOccupationalAccidentProtectionTime("");
			}
			speakerListService.updateByPrimaryKeySelective(speakerList);
		}
		return speakerList;
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗之講師名單(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectExperienceInheritanceSpeakerList", method = RequestMethod.POST)
	public ExperienceInheritanceSpeakerList selectExperienceInheritanceSpeakerList(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		speakerListKey = new ExperienceInheritanceSpeakerListKey();
		speakerListKey.setRetirementAdvancedAgeExperienceInheritancePlanId(speakerList.getRetirementAdvancedAgeExperienceInheritancePlanId());
		speakerListKey.setIdentification(speakerList.getIdentification());
		
		return speakerListService.selectByPrimaryKey(speakerListKey);
	}
	
	@ApiOperation(value = "查詢傳承專業技術及經驗之講師名單(多筆，畫面顯示)")
	@RequestMapping(value = "/selectExperienceInheritanceSpeakerLists", method = RequestMethod.POST)
	public List<ExperienceInheritanceSpeakerList> selectExperienceInheritanceSpeakerLists(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		speakerListExample = new ExperienceInheritanceSpeakerListExample();
		speakerListExample.setOrderByClause("id asc");
		speakerListExample.createCriteria().andRetirementAdvancedAgeExperienceInheritancePlanIdEqualTo(speakerList.getRetirementAdvancedAgeExperienceInheritancePlanId());
		
		return speakerListService.selectByExample(speakerListExample);
	}
	
	@ApiOperation(value = "刪除傳承專業技術及經驗之講師名單")
	@RequestMapping(value = "/delExperienceInheritanceSpeakerList", method = RequestMethod.POST)
	public ExperienceInheritanceSpeakerList delExperienceInheritanceSpeakerList(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectExperienceInheritanceSpeakerList(speakerList,token) != null)
		{
			speakerListService.deleteByPrimaryKey(speakerList);
		}
		return speakerList;
	}
	
	@ApiOperation(value = "用 ID 刪除傳承專業技術及經驗之講師名單")
	@RequestMapping(value = "/delExperienceInheritanceSpeakerListbyId", method = RequestMethod.POST)
	public void delExperienceInheritanceSpeakerListbyId(ExperienceInheritanceSpeakerList speakerList,String token) {
		if(token.equals(apiToken))
		{
			speakerListExample = new ExperienceInheritanceSpeakerListExample();
			speakerListExample.createCriteria().andRetirementAdvancedAgeExperienceInheritancePlanIdEqualTo(speakerList.getRetirementAdvancedAgeExperienceInheritancePlanId());
			speakerListService.deleteByExample(speakerListExample);
		}
	}
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表")
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceSchedule", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceSchedule addRetirementAdvancedAgeExperienceInheritanceSchedule(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeExperienceInheritanceSchedule(schedule,token) == null)
		{
			scheduleService.insertSelective(schedule);
		}
		else
		{
			scheduleService.updateByPrimaryKeySelective(schedule);
		}
		return schedule;
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceSchedule", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceSchedule selectRetirementAdvancedAgeExperienceInheritanceSchedule(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		scheduleKey = new RetirementAdvancedAgeExperienceInheritanceScheduleKey();
		scheduleKey.setRetirementAdvancedAgeExperienceInheritanceApplyId(schedule.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		scheduleKey.setSubject(schedule.getSubject());
		scheduleKey.setExecutionEndTime(schedule.getExecutionEndTime());
		scheduleKey.setExecutionStartTime(schedule.getExecutionStartTime());
		scheduleKey.setExecutionTime(schedule.getExecutionTime());
		return scheduleService.selectByPrimaryKey(scheduleKey);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceSchedules", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeExperienceInheritanceSchedule> selectRetirementAdvancedAgeExperienceInheritanceSchedules(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		scheduleExample = new RetirementAdvancedAgeExperienceInheritanceScheduleExample();
		scheduleExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(schedule.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		scheduleExample.setOrderByClause("id asc");
		
		return scheduleService.selectByExample(scheduleExample);
	}
	
	@ApiOperation(value = "刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表")
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceSchedule", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceSchedule delRetirementAdvancedAgeExperienceInheritanceSchedule(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeExperienceInheritanceSchedule(schedule,token) != null)
		{
			scheduleService.deleteByPrimaryKey(schedule);
		}
		return schedule;
	}
	
	@ApiOperation(value = "用 ID 刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_課程規劃表")
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceSchedulebyId", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeExperienceInheritanceSchedulebyId(RetirementAdvancedAgeExperienceInheritanceSchedule schedule,String token) {
		if(token.equals(apiToken))
		{
			scheduleExample = new RetirementAdvancedAgeExperienceInheritanceScheduleExample();
			scheduleExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(schedule.getRetirementAdvancedAgeExperienceInheritanceApplyId());
			scheduleService.deleteByExample(scheduleExample);
		}
	}
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表")
	@RequestMapping(value = "/addRetirementAdvancedAgeParticipateStudent", method = RequestMethod.POST)
	public RetirementAdvancedAgeParticipateStudent addRetirementAdvancedAgeParticipateStudent(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeParticipateStudent(participate,token) == null)
		{
			participateService.insertSelective(participate);
		}
		else
		{
			if(participate.getLaborProtectionTime()==null) {
				participate.setLaborProtectionTime("");
			}
			else if(participate.getOccupationalAccidentProtectionTime()==null) {
				participate.setOccupationalAccidentProtectionTime("");
			}
			participateService.updateByPrimaryKeySelective(participate);
		}
		return participate;
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeParticipateStudent", method = RequestMethod.POST)
	public RetirementAdvancedAgeParticipateStudent selectRetirementAdvancedAgeParticipateStudent(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		participateKey = new RetirementAdvancedAgeParticipateStudentKey();
		participateKey.setRetirementAdvancedAgeExperienceInheritanceApplyId(participate.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		participateKey.setName(participate.getName());
		participateKey.setSeniority(participate.getSeniority());
		return participateService.selectByPrimaryKey(participateKey);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeParticipateStudents", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeParticipateStudent> selectRetirementAdvancedAgeParticipateStudents(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		participateExample = new RetirementAdvancedAgeParticipateStudentExample();
		participateExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(participate.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		participateExample.setOrderByClause("id asc");
		
		return participateService.selectByExample(participateExample);
	}
	
	@ApiOperation(value = "刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表")
	@RequestMapping(value = "/delRetirementAdvancedAgeParticipateStudent", method = RequestMethod.POST)
	public RetirementAdvancedAgeParticipateStudent delRetirementAdvancedAgeParticipateStudent(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeParticipateStudent(participate,token) != null)
		{
			participateService.deleteByPrimaryKey(participate);
		}
		return participate;
	}
	
	@ApiOperation(value = "用 ID 刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_參訓學員表")
	@RequestMapping(value = "/delRetirementAdvancedAgeParticipateStudentbyId", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeParticipateStudentbyId(RetirementAdvancedAgeParticipateStudent participate,String token) {
		if(token.equals(apiToken))
		{
			participateExample = new RetirementAdvancedAgeParticipateStudentExample();
			participateExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(participate.getRetirementAdvancedAgeExperienceInheritanceApplyId());
			participateService.deleteByExample(participateExample);
		}
	}
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表")
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceExpenditure", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceExpenditure addRetirementAdvancedAgeExperienceInheritanceExpenditure(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeExperienceInheritanceExpenditure(expenditure,token) == null)
		{
			expenditureService.insertSelective(expenditure);
		}
		else
		{
			expenditureService.updateByPrimaryKeySelective(expenditure);
		}
		return expenditure;
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表(單筆，新增時確認是否已存在)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceExpenditure", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceExpenditure selectRetirementAdvancedAgeExperienceInheritanceExpenditure(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		expenditureKey = new RetirementAdvancedAgeExperienceInheritanceExpenditureKey();
		expenditureKey.setRetirementAdvancedAgeExperienceInheritanceApplyId(expenditure.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		expenditureKey.setPlanName(expenditure.getPlanName());
		return expenditureService.selectByPrimaryKey(expenditureKey);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表(多筆，畫面顯示)")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceExpenditures", method = RequestMethod.POST)
	public List<RetirementAdvancedAgeExperienceInheritanceExpenditure> selectRetirementAdvancedAgeExperienceInheritanceExpenditures(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		expenditureExample = new RetirementAdvancedAgeExperienceInheritanceExpenditureExample();
		expenditureExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(expenditure.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		expenditureExample.setOrderByClause("id asc");
		
		return expenditureService.selectByExample(expenditureExample);
	}
	
	@ApiOperation(value = "刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表")
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceExpenditure", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceExpenditure delRetirementAdvancedAgeExperienceInheritanceExpenditure(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeExperienceInheritanceExpenditure(expenditure,token) != null)
		{
			expenditureService.deleteByPrimaryKey(expenditure);
		}
		return expenditure;
	}

	@ApiOperation(value = "用 ID 刪除僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_經費概算表")
	@RequestMapping(value = "/delRetirementAdvancedAgeExperienceInheritanceExpenditurebyId", method = RequestMethod.POST)
	public void delRetirementAdvancedAgeExperienceInheritanceExpenditurebyId(RetirementAdvancedAgeExperienceInheritanceExpenditure expenditure,String token) {
		if(token.equals(apiToken))
		{
			expenditureExample = new RetirementAdvancedAgeExperienceInheritanceExpenditureExample();
			expenditureExample.createCriteria().andRetirementAdvancedAgeExperienceInheritanceApplyIdEqualTo(expenditure.getRetirementAdvancedAgeExperienceInheritanceApplyId());
			expenditureService.deleteByExample(expenditureExample);
		}
	}
	
	@ApiOperation(value = "新增僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_成果報告")
	@RequestMapping(value = "/addRetirementAdvancedAgeExperienceInheritanceResult", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceResult addRetirementAdvancedAgeExperienceInheritanceResult(RetirementAdvancedAgeExperienceInheritanceResult result,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		if(selectRetirementAdvancedAgeExperienceInheritanceResult(result,token) == null)
		{
			resultService.insertSelective(result);
		}
		else
		{
			resultService.updateByPrimaryKeySelective(result);
		}
		return selectRetirementAdvancedAgeExperienceInheritanceResult(result,token) == null?result:selectRetirementAdvancedAgeExperienceInheritanceResult(result,token);
	}
	
	@ApiOperation(value = "查詢僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫_申請書")
	@RequestMapping(value = "/selectRetirementAdvancedAgeExperienceInheritanceResult", method = RequestMethod.POST)
	public RetirementAdvancedAgeExperienceInheritanceResult selectRetirementAdvancedAgeExperienceInheritanceResult(RetirementAdvancedAgeExperienceInheritanceResult result,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		
		resultKey = new RetirementAdvancedAgeExperienceInheritanceResultKey();
		resultKey.setSeq(result.getSeq());
		resultKey.setRetirementAdvancedAgeExperienceInheritanceApplyId(result.getRetirementAdvancedAgeExperienceInheritanceApplyId());
		return resultService.selectByPrimaryKey(resultKey);
	}
}