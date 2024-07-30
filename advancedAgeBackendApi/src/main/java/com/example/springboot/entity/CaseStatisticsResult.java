package com.example.springboot.entity;

import java.io.Serializable;

public class CaseStatisticsResult implements Serializable {

    private Integer id;

    private String companyName;
    
    private String year;

    private Integer nearHighEmploymentNumber;

    private Double continueEmploymentPercentage;

    private String industry;
    
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
    
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getNearHighEmploymentNumber() {
        return nearHighEmploymentNumber;
    }

    public void setNearHighEmploymentNumber(Integer nearHighEmploymentNumber) {
        this.nearHighEmploymentNumber = nearHighEmploymentNumber;
    }

    public Double getContinueEmploymentPercentage() {
        return continueEmploymentPercentage;
    }

    public void setContinueEmploymentPercentage(Double continueEmploymentPercentage) {
        this.continueEmploymentPercentage = continueEmploymentPercentage;
    }

}