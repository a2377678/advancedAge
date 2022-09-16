package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeApplyEmployedSituation extends AdvancedAgeApplyEmployedSituationKey implements Serializable {
    private Integer id;

    private String employeeId;

    private String applyYear;

    private String name;

    private Double employedAmong;

    private String employedExpiredStatus;

    private Double employedExpiredResign;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear == null ? null : applyYear.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getEmployedAmong() {
        return employedAmong;
    }

    public void setEmployedAmong(Double employedAmong) {
        this.employedAmong = employedAmong;
    }

    public String getEmployedExpiredStatus() {
        return employedExpiredStatus;
    }

    public void setEmployedExpiredStatus(String employedExpiredStatus) {
        this.employedExpiredStatus = employedExpiredStatus == null ? null : employedExpiredStatus.trim();
    }

    public Double getEmployedExpiredResign() {
        return employedExpiredResign;
    }

    public void setEmployedExpiredResign(Double employedExpiredResign) {
        this.employedExpiredResign = employedExpiredResign;
    }
}