package com.example.springboot.entity;

import java.io.Serializable;

public class ExperienceInheritanceSpeakerList extends ExperienceInheritanceSpeakerListKey implements Serializable {
    private Integer id;

    private String employeeId;

    private String name;

    private String birthday;

    private String laborProtectionTime;

    private String occupationalAccidentProtectionTime;

    private String manager;

    private String relatives;

    private String workingHours;

    private String executionWay;

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives == null ? null : relatives.trim();
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours == null ? null : workingHours.trim();
    }

    public String getExecutionWay() {
        return executionWay;
    }

    public void setExecutionWay(String executionWay) {
        this.executionWay = executionWay == null ? null : executionWay.trim();
    }
}