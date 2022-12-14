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
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituation;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationExample;
import com.example.springboot.entity.AdvancedAgeApplyEmployedSituationKey;
import com.example.springboot.entity.AdvancedAgeApplyExample;
import com.example.springboot.entity.AdvancedAgeApplyKey;
import com.example.springboot.entity.AdvancedAgeEmploymentList;
import com.example.springboot.entity.AdvancedAgeEmploymentListExample;
import com.example.springboot.entity.AdvancedAgeEmploymentListKey;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceipt;
import com.example.springboot.entity.AdvancedAgeEmploymentListReceiptExample;
import com.example.springboot.entity.AdvancedAgePlan;
import com.example.springboot.entity.Attachment;
import com.example.springboot.service.AdvancedAgeApplyEmployedSituationService;
import com.example.springboot.service.AdvancedAgeApplyService;
import com.example.springboot.service.AdvancedAgeEmploymentListReceiptService;
import com.example.springboot.service.AdvancedAgeEmploymentListService;
import com.example.springboot.service.AdvancedAgePlanService;
import com.example.springboot.service.AttachmentService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class AdvancedAgeEmploymentListReceiptApiController { 
	
	@Autowired
	AdvancedAgeEmploymentListReceiptService advancedAgeEmploymentListReceiptService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "??????????????????????????????")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceipts", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceipts(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListReceiptExample example = new AdvancedAgeEmploymentListReceiptExample();
		example.createCriteria().andAdvancedAgeBaseIdEqualTo(advancedAgeEmploymentListReceipt.getAdvancedAgeBaseId());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListReceiptService.selectByExample(example);
	}
	
	@ApiOperation(value = "?????????????????????????????? by base????????????")
	@RequestMapping(value = "/selectAdvancedAgeEmploymentListReceiptsByFrequency", method = RequestMethod.POST)
	public List<AdvancedAgeEmploymentListReceipt> selectAdvancedAgeEmploymentListReceiptsByFrequency(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		AdvancedAgeEmploymentListReceiptExample example = new AdvancedAgeEmploymentListReceiptExample();
		example.createCriteria().andAdvancedAgeBaseIdEqualTo(advancedAgeEmploymentListReceipt.getAdvancedAgeBaseId()).andBaseAllowanceFrequencyEqualTo(advancedAgeEmploymentListReceipt.getBaseAllowanceFrequency());
		example.setOrderByClause("id asc");
		return advancedAgeEmploymentListReceiptService.selectByExample(example);
	}
	
	@ApiOperation(value = "??????????????????????????????")
	@RequestMapping(value = "/editAdvancedAgeEmploymentListReceipt", method = RequestMethod.POST)
	public int editAdvancedAgeEmploymentListReceipt(AdvancedAgeEmploymentListReceipt advancedAgeEmploymentListReceipt,String token) {
		if(!token.equals(apiToken))
		{
			return 0;
		}
		return advancedAgeEmploymentListReceiptService.updateByPrimaryKeySelective(advancedAgeEmploymentListReceipt);
	}
}