package com.example.springboot.dao;

import com.example.springboot.entity.YearAmountsStatisticsResult;
import com.example.springboot.entity.AdvancedAgeBase;
import com.example.springboot.entity.ApplicationSituationResult;
import com.example.springboot.entity.CaseStatisticsResult;
import com.example.springboot.entity.CaseStatisticsResult2;
import com.example.springboot.entity.IndustryAmountsStatisticsResult;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
    
    List<CaseStatisticsResult> caseStatistics(AdvancedAgeBase base);
    
    List<CaseStatisticsResult2> caseStatistics2(AdvancedAgeBase base);
    
    List<CaseStatisticsResult2> caseStatistics3(AdvancedAgeBase base);
    
    List<ApplicationSituationResult> applicationSituation(AdvancedAgeBase base);
    
    List<YearAmountsStatisticsResult> yearAmountsStatistics(AdvancedAgeBase base);
    
    List<IndustryAmountsStatisticsResult> industryAmountsStatistics(AdvancedAgeBase base);
}