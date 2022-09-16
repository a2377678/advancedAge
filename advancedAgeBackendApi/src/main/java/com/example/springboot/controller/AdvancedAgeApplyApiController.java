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
public class AdvancedAgeApplyApiController { 
	
	@Autowired
	AdvancedAgeApplyService advancedAgeApplyService;
	
	@ApiOperation(value = "查詢繼續僱用高齡者補助申請書")
	@RequestMapping(value = "/selectAdvancedAgeApply", method = RequestMethod.POST)
	public AdvancedAgeApply selectAdvancedAgeApply(AdvancedAgeApply apply) {
		
		AdvancedAgeApplyKey key = new AdvancedAgeApplyKey();
		key.setApplyYear(String.valueOf(apply.getApplyYear()));
		key.setSeq(apply.getSeq());
		return advancedAgeApplyService.selectByPrimaryKey(key);
	}
}