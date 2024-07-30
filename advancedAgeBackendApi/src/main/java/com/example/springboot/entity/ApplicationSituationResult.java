package com.example.springboot.entity;

import java.io.Serializable;

public class ApplicationSituationResult implements Serializable {

    private Integer id;

    private String year;

    private Integer totalCase;
    
    private Integer successCase;
    
    private Integer failCase;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(Integer totalCase) {
        this.totalCase = totalCase;
    }

    public Integer getSuccessCase() {
        return successCase;
    }

    public void setSuccessCase(Integer successCase) {
        this.successCase = successCase;
    }

    public Integer getFailCase() {
        return failCase;
    }

    public void setFailCase(Integer failCase) {
        this.failCase = failCase;
    }

}