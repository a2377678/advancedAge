package com.example.springboot.entity;

import java.io.Serializable;

public class RretirementAdvancedAgeExperienceInheritanceSchedule implements Serializable {
    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private Integer id;

    private String executionTimeStart;

    private String executionTimeEnd;

    private String subject;

    private String introduction;

    private String speakerName;

    private Double teachingHours;

    private Integer participateNumber;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getRetirementAdvancedAgeExperienceInheritanceApplyId() {
        return retirementAdvancedAgeExperienceInheritanceApplyId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer retirementAdvancedAgeExperienceInheritanceApplyId) {
        this.retirementAdvancedAgeExperienceInheritanceApplyId = retirementAdvancedAgeExperienceInheritanceApplyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutionTimeStart() {
        return executionTimeStart;
    }

    public void setExecutionTimeStart(String executionTimeStart) {
        this.executionTimeStart = executionTimeStart == null ? null : executionTimeStart.trim();
    }

    public String getExecutionTimeEnd() {
        return executionTimeEnd;
    }

    public void setExecutionTimeEnd(String executionTimeEnd) {
        this.executionTimeEnd = executionTimeEnd == null ? null : executionTimeEnd.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}