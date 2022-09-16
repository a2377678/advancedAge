package com.example.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.AdvancedAgeApply;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationKey;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.Attachment;
import com.example.springboot.service.AdvancedAgeApplyEmployedSituationService;
import com.example.springboot.service.AdvancedAgeApplyService;
import com.example.springboot.service.AdvancedAgeEmploymentListService;
import com.example.springboot.service.AdvancedAgePlanService;
import com.example.springboot.service.AttachmentService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeEmploymentListApiController { 
	
	@Autowired
	AdvancedAgeEmploymentListService advancedAgeEmploymentListService;
	
	@ApiOperation(value = "查詢繼續僱用補助名單")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentLists", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentList> selectAdvancedAgeEmploymentLists(AdvancedAgeEmploymentList advancedAgeEmploymentList) {
		AdvancedAgeEmploymentListExample example = new AdvancedAgeEmploymentListExample();
		example.createCriteria().andAdvancedAgePlanIdEqualTo(advancedAgeEmploymentList.getAdvancedAgePlanId());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListService.selectByExample(example);
	}
}