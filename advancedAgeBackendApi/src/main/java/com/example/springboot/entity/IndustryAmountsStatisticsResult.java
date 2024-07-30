package com.example.springboot.entity;

import java.io.Serializable;

public class IndustryAmountsStatisticsResult implements Serializable {

    private String year;

    private Integer amounts;
    
    private String companyName;
    
    private static final long serialVersionUID = 1L;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}