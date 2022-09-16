package com.example.springboot.entity;

import java.io.Serializable;

public class RretirementAdvancedAgeExperienceInheritancePlan implements Serializable {
    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private Integer id;

    private String applyYear;

    private String workContent;

    private String friendlyMeasures;

    private String planDescription;

    private String executionWay;

    private String planStartTime;

    private String planEndTime;

    private Double experienceInheritanceHours;

    private Integer participateNumber;

    private String benefit;

    private String planExecutionSituation;

    private String otherAttachment;

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

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear == null ? null : applyYear.trim();
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent == null ? null : workContent.trim();
    }

    public String getFriendlyMeasures() {
        return friendlyMeasures;
    }

    public void setFriendlyMeasures(String friendlyMeasures) {
        this.friendlyMeasures = friendlyMeasures == null ? null : friendlyMeasures.trim();
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription == null ? null : planDescription.trim();
    }

    public String getExecutionWay() {
        return executionWay;
    }

    public void setExecutionWay(String executionWay) {
        this.executionWay = executionWay == null ? null : executionWay.trim();
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime == null ? null : planStartTime.trim();
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime == null ? null : planEndTime.trim();
    }

    public Double getExperienceInheritanceHours() {
        return experienceInheritanceHours;
    }

    public void setExperienceInheritanceHours(Double experienceInheritanceHours) {
        this.experienceInheritanceHours = experienceInheritanceHours;
    }

    public Integer getParticipateNumber() {
        return participateNumber;
    }

    public void setParticipateNumber(Integer participateNumber) {
        this.participateNumber = participateNumber;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit == null ? null : benefit.trim();
    }

    public String getPlanExecutionSituation() {
        return planExecutionSituation;
    }

    public void setPlanExecutionSituation(String planExecutionSituation) {
        this.planExecutionSituation = planExecutionSituation == null ? null : planExecutionSituation.trim();
    }

    public String getOtherAttachment() {
        return otherAttachment;
    }

    public void setOtherAttachment(String otherAttachment) {
        this.otherAttachment = otherAttachment == null ? null : otherAttachment.trim();
    }
}