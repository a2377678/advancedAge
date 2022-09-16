package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeEmploymentList extends AdvancedAgeEmploymentListKey implements Serializable {
    private Integer id;

    private String employeeId;

    private String name;

    private String birthday;

    private String laborProtectionTime;

    private String occupationalAccidentProtectionTime;

    private String manager;

    private String relatives;

    private Integer averageSalary;

    private String workingHours;

    private Integer recurringSalary;

    private Integer notRecurringSalary;

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

    public Integer getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Integer averageSalary) {
        this.averageSalary = averageSalary;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours == null ? null : workingHours.trim();
    }

    public Integer getRecurringSalary() {
        return recurringSalary;
    }

    public void setRecurringSalary(Integer recurringSalary) {
        this.recurringSalary = recurringSalary;
    }

    public Integer getNotRecurringSalary() {
        return notRecurringSalary;
    }

    public void setNotRecurringSalary(Integer notRecurringSalary) {
        this.notRecurringSalary = notRecurringSalary;
    }
}