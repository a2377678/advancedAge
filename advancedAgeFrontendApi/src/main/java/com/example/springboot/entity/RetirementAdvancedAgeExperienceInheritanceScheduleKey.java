package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritanceScheduleKey implements Serializable {
    private String executionStartTime;

    private String executionEndTime;

    private String executionTime;

    private String subject;

    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private static final long serialVersionUID = 1L;

    public String getExecutionStartTime() {
        return executionStartTime;
    }

    public void setExecutionStartTime(String executionStartTime) {
        this.executionStartTime = executionStartTime == null ? null : executionStartTime.trim();
    }

    public String getExecutionEndTime() {
        return executionEndTime;
    }

    public void setExecutionEndTime(String executionEndTime) {
        this.executionEndTime = executionEndTime == null ? null : executionEndTime.trim();
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime == null ? null : executionTime.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getRetirementAdvancedAgeExperienceInheritanceApplyId() {
        return retirementAdvancedAgeExperienceInheritanceApplyId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer retirementAdvancedAgeExperienceInheritanceApplyId) {
        this.retirementAdvancedAgeExperienceInheritanceApplyId = retirementAdvancedAgeExperienceInheritanceApplyId;
    }
}