package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentPlan implements Serializable {
    private Integer advancedAgeRetirementReemploymentApplyId;

    private Integer id;

    private String workContent;

    private String friendlyMeasures;

    private String planGoal;

    private String planContent;

    private String planStartTime;

    private String planEndTime;

    private String qualityBenefit;

    private String quantifyBenefit;

    private String planExecutionSituation;

    private String otherAttachment;

    private static final long serialVersionUID = 1L;

    public Integer getAdvancedAgeRetirementReemploymentApplyId() {
        return advancedAgeRetirementReemploymentApplyId;
    }

    public void setAdvancedAgeRetirementReemploymentApplyId(Integer advancedAgeRetirementReemploymentApplyId) {
        this.advancedAgeRetirementReemploymentApplyId = advancedAgeRetirementReemploymentApplyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPlanGoal() {
        return planGoal;
    }

    public void setPlanGoal(String planGoal) {
        this.planGoal = planGoal == null ? null : planGoal.trim();
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
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

    public String getQualityBenefit() {
        return qualityBenefit;
    }

    public void setQualityBenefit(String qualityBenefit) {
        this.qualityBenefit = qualityBenefit == null ? null : qualityBenefit.trim();
    }

    public String getQuantifyBenefit() {
        return quantifyBenefit;
    }

    public void setQuantifyBenefit(String quantifyBenefit) {
        this.quantifyBenefit = quantifyBenefit == null ? null : quantifyBenefit.trim();
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