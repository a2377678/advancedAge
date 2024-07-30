package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.ReportMapper;
import com.example.springboot.entity.YearAmountsStatisticsResult;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.ApplicationSituationResult;
import com.example.springboot.entity.CaseStatisticsResult;
import com.example.springboot.entity.CaseStatisticsResult2;
import com.example.springboot.entity.IndustryAmountsStatisticsResult;

@Service
public class ReportService{
	
	@Autowired
	ReportMapper reportMapper;
	
	public List<CaseStatisticsResult> caseStatistics(AdvancedAgeBase base) {
		return reportMapper.caseStatistics(base);
	}
	
	public List<CaseStatisticsResult2> caseStatistics2(AdvancedAgeBase base) {
		return reportMapper.caseStatistics2(base);
	}

	public List<CaseStatisticsResult2> caseStatistics3(AdvancedAgeBase base) {
		return reportMapper.caseStatistics3(base);
	}
	
	public List<ApplicationSituationResult> applicationSituation(AdvancedAgeBase base) {
		return reportMapper.applicationSituation(base);
	}
	
	public List<YearAmountsStatisticsResult> yearAmountsStatistics(AdvancedAgeBase base) {
		return reportMapper.yearAmountsStatistics(base);
	}
	
	public List<IndustryAmountsStatisticsResult> industryAmountsStatistics(AdvancedAgeBase base) {
		return reportMapper.industryAmountsStatistics(base);
	}
}