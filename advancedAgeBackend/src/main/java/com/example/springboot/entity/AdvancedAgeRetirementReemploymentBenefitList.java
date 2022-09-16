package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentBenefitList extends AdvancedAgeRetirementReemploymentBenefitListKey implements Serializable {
    private Integer id;

    private String employeeId;

    private String name;

    private String birthday;

    private String laborProtectionTime;

    private String occupationalAccidentProtectionTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getLaborProtectionTime() {
        return laborProtectionTime;
    }

    public void setLaborProtectionTime(String laborProtectionTime) {
        this.laborProtectionTime = laborProtectionTime == null ? null : laborProtectionTime.trim();
    }

    public String getOccupationalAccidentProtectionTime() {
        return occupationalAccidentProtectionTime;
    }

    public void setOccupationalAccidentProtectionTime(String occupationalAccidentProtectionTime) {
        this.occupationalAccidentProtectionTime = occupationalAccidentProtectionTime == null ? null : occupationalAccidentProtectionTime.trim();
    }
}