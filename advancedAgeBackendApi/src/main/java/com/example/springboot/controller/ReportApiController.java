package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.YearAmountsStatisticsResult;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.ApplicationSituationResult;
import com.example.springboot.entity.CaseStatisticsResult;
import com.example.springboot.entity.CaseStatisticsResult2;
import com.example.springboot.entity.IndustryAmountsStatisticsResult;
import com.example.springboot.service.ReportService;

import io.swagger.annotations.ApiOperation;

@RestController 
public class ReportApiController { 
	
	@Autowired
	ReportService reportService;

	@Value("${api_token}")
	private String apiToken;
	
	@ApiOperation(value = "繼續雇用_案件統計分析")
	@RequestMapping(value = "/selectCaseStatistics", method = RequestMethod.POST)
	public List<CaseStatisticsResult> selectCaseStatistics(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.caseStatistics(base);
	}
	
	@ApiOperation(value = "傳承經驗_案件統計分析")
	@RequestMapping(value = "/selectCaseStatistics2", method = RequestMethod.POST)
	public List<CaseStatisticsResult2> selectCaseStatistics2(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.caseStatistics2(base);
	}

	@ApiOperation(value = "傳承經驗_案件統計分析")
	@RequestMapping(value = "/selectCaseStatistics3", method = RequestMethod.POST)
	public List<CaseStatisticsResult2> selectCaseStatistics3(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.caseStatistics3(base);
	}
	
	@ApiOperation(value = "近三年事業單位申請情形")
	@RequestMapping(value = "/selectApplicationSituation", method = RequestMethod.POST)
	public List<ApplicationSituationResult> selectApplicationSituation(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.applicationSituation(base);
	}
	
	@ApiOperation(value = "事業單位申請金額統計")
	@RequestMapping(value = "/selectIndustryAmountsStatistics", method = RequestMethod.POST)
	public List<IndustryAmountsStatisticsResult> selectIndustryAmountsStatistics(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.industryAmountsStatistics(base);
	}
	
	@ApiOperation(value = "年度申請金額統計")
	@RequestMapping(value = "/selectYearAmountsStatistics", method = RequestMethod.POST)
	public List<YearAmountsStatisticsResult> selectYearAmountsStatistics(AdvancedAgeBase base,String token) {
		if(!token.equals(apiToken))
		{
			return null;
		}
		return reportService.yearAmountsStatistics(base);
	}
}