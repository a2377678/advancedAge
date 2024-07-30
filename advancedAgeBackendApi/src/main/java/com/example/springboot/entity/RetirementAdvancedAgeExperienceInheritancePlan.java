package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritancePlan implements Serializable {
    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private Integer id;

    private String applyYear;

    private String items;

    private String friendlyMeasures;

    private Integer employmentNumber;

    private Integer highEmploymentNumber;

    private Integer middleEmploymentNumber;

    private Integer lowEmploymentNumber;

    private Integer lowerEmploymentNumber;

    private Integer retirementEmploymentNumber;

    private String planDescription;

    private String executionWay;

    private String executionWayDescription;

    private String planStartTime;

    private String planEndTime;

    private String experienceInheritance;

    private String participate;

    private String benefit;

    private String planExecutionSituation;

    private String otherAttachment;

    private String attachSpeakerList;

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

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }

    public String getFriendlyMeasures() {
        return friendlyMeasures;
    }

    public void setFriendlyMeasures(String friendlyMeasures) {
        this.friendlyMeasures = friendlyMeasures == null ? null : friendlyMeasures.trim();
    }

    public Integer getEmploymentNumber() {
        return employmentNumber;
    }

    public void setEmploymentNumber(Integer employmentNumber) {
        this.employmentNumber = employmentNumber;
    }

    public Integer getHighEmploymentNumber() {
        return highEmploymentNumber;
    }

    public void setHighEmploymentNumber(Integer highEmploymentNumber) {
        this.highEmploymentNumber = highEmploymentNumber;
    }

    public Integer getMiddleEmploymentNumber() {
        return middleEmploymentNumber;
    }

    public void setMiddleEmploymentNumber(Integer middleEmploymentNumber) {
        this.middleEmploymentNumber = middleEmploymentNumber;
    }

    public Integer getLowEmploymentNumber() {
        return lowEmploymentNumber;
    }

    public void setLowEmploymentNumber(Integer lowEmploymentNumber) {
        this.lowEmploymentNumber = lowEmploymentNumber;
    }

    public Integer getLowerEmploymentNumber() {
        return lowerEmploymentNumber;
    }

    public void setLowerEmploymentNumber(Integer lowerEmploymentNumber) {
        this.lowerEmploymentNumber = lowerEmploymentNumber;
    }

    public Integer getRetirementEmploymentNumber() {
        return retirementEmploymentNumber;
    }

    public void setRetirementEmploymentNumber(Integer retirementEmploymentNumber) {
        this.retirementEmploymentNumber = retirementEmploymentNumber;
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

    public String getExecutionWayDescription() {
        return executionWayDescription;
    }

    public void setExecutionWayDescription(String executionWayDescription) {
        this.executionWayDescription = executionWayDescription == null ? null : executionWayDescription.trim();
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

    public String getExperienceInheritance() {
        return experienceInheritance;
    }

    public void setExperienceInheritance(String experienceInheritance) {
        this.experienceInheritance = experienceInheritance == null ? null : experienceInheritance.trim();
    }

    public String getParticipate() {
        return participate;
    }

    public void setParticipate(String participate) {
        this.participate = participate == null ? null : participate.trim();
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

    public String getAttachSpeakerList() {
        return attachSpeakerList;
    }

    public void setAttachSpeakerList(String attachSpeakerList) {
        this.attachSpeakerList = attachSpeakerList == null ? null : attachSpeakerList.trim();
    }
}