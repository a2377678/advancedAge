package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritanceSchedule extends RetirementAdvancedAgeExperienceInheritanceScheduleKey implements Serializable {
    private Integer id;

    private String executionCity;

    private String introduction;

    private String speakerName;

    private Double teachingHours;

    private Integer participateNumber;

    private String participatePeople;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutionCity() {
        return executionCity;
    }

    public void setExecutionCity(String executionCity) {
        this.executionCity = executionCity == null ? null : executionCity.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName == null ? null : speakerName.trim();
    }

    public Double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(Double teachingHours) {
        this.teachingHours = teachingHours;
    }

    public Integer getParticipateNumber() {
        return participateNumber;
    }

    public void setParticipateNumber(Integer participateNumber) {
        this.participateNumber = participateNumber;
    }

    public String getParticipatePeople() {
        return participatePeople;
    }

    public void setParticipatePeople(String participatePeople) {
        this.participatePeople = participatePeople == null ? null : participatePeople.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}