package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeParticipateStudent extends RetirementAdvancedAgeParticipateStudentKey implements Serializable {
    private Integer id;

    private String laborProtectionTime;

    private String occupationalAccidentProtectionTime;

    private String manager;

    private String department;

    private String workingHours;

    private Integer seniorityMonth;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours == null ? null : workingHours.trim();
    }

    public Integer getSeniorityMonth() {
        return seniorityMonth;
    }

    public void setSeniorityMonth(Integer seniorityMonth) {
        this.seniorityMonth = seniorityMonth;
    }
}