package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentPlan implements Serializable {
    private Integer advancedAgeRetirementReemploymentApplyId;

    private Integer id;

    private String workContent;

    private String friendlyMeasures;

    private Integer employeeNumber;

    private Integer beneficiaryNumber;

    private Integer subsidyType;

    private Integer amounts;

    private String multipleApplications;

    private String multipleApplicationsDescription;

    private String applySameYear;

    private String applySameYearDescription;

    private String planGoal;

    private String planContent;

    private String planStartTime;

    private String planEndTime;

    private String executionCity;

    private String qualityBenefit;

    private String quantifyBenefit;

    private String planExecutionSituation;

    private String attachBenefitList;

    private String attachExpenditure;

    private String attachBasicData;

    private String otherAttachment;

    private String hasJointUnit;

    private String executionCityAddress;

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

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getBeneficiaryNumber() {
        return beneficiaryNumber;
    }

    public void setBeneficiaryNumber(Integer beneficiaryNumber) {
        this.beneficiaryNumber = beneficiaryNumber;
    }

    public Integer getSubsidyType() {
        return subsidyType;
    }

    public void setSubsidyType(Integer subsidyType) {
        this.subsidyType = subsidyType;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public String getMultipleApplications() {
        return multipleApplications;
    }

    public void setMultipleApplications(String multipleApplications) {
        this.multipleApplications = multipleApplications == null ? null : multipleApplications.trim();
    }

    public String getMultipleApplicationsDescription() {
        return multipleApplicationsDescription;
    }

    public void setMultipleApplicationsDescription(String multipleApplicationsDescription) {
        this.multipleApplicationsDescription = multipleApplicationsDescription == null ? null : multipleApplicationsDescription.trim();
    }

    public String getApplySameYear() {
        return applySameYear;
    }

    public void setApplySameYear(String applySameYear) {
        this.applySameYear = applySameYear == null ? null : applySameYear.trim();
    }

    public String getApplySameYearDescription() {
        return applySameYearDescription;
    }

    public void setApplySameYearDescription(String applySameYearDescription) {
        this.applySameYearDescription = applySameYearDescription == null ? null : applySameYearDescription.trim();
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

    public String getExecutionCity() {
        return executionCity;
    }

    public void setExecutionCity(String executionCity) {
        this.executionCity = executionCity == null ? null : executionCity.trim();
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

    public String getAttachBenefitList() {
        return attachBenefitList;
    }

    public void setAttachBenefitList(String attachBenefitList) {
        this.attachBenefitList = attachBenefitList == null ? null : attachBenefitList.trim();
    }

    public String getAttachExpenditure() {
        return attachExpenditure;
    }

    public void setAttachExpenditure(String attachExpenditure) {
        this.attachExpenditure = attachExpenditure == null ? null : attachExpenditure.trim();
    }

    public String getAttachBasicData() {
        return attachBasicData;
    }

    public void setAttachBasicData(String attachBasicData) {
        this.attachBasicData = attachBasicData == null ? null : attachBasicData.trim();
    }

    public String getOtherAttachment() {
        return otherAttachment;
    }

    public void setOtherAttachment(String otherAttachment) {
        this.otherAttachment = otherAttachment == null ? null : otherAttachment.trim();
    }

    public String getHasJointUnit() {
        return hasJointUnit;
    }

    public void setHasJointUnit(String hasJointUnit) {
        this.hasJointUnit = hasJointUnit == null ? null : hasJointUnit.trim();
    }

    public String getExecutionCityAddress() {
        return executionCityAddress;
    }

    public void setExecutionCityAddress(String executionCityAddress) {
        this.executionCityAddress = executionCityAddress == null ? null : executionCityAddress.trim();
    }
}