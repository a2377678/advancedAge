package com.example.springboot.entity;

import java.io.Serializable;

public class EexperienceInheritanceSpeakerSituation extends EexperienceInheritanceSpeakerSituationKey implements Serializable {
    private Integer id;

    private String employeeId;

    private String name;

    private String situation;

    private Double executionMonth;

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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    public Double getExecutionMonth() {
        return executionMonth;
    }

    public void setExecutionMonth(Double executionMonth) {
        this.executionMonth = executionMonth;
    }
}