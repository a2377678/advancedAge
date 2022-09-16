package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritanceExpenditureDetails implements Serializable {
    private Integer retirementAdvancedAgeExperienceInheritanceResultId;

    private Integer id;

    private Integer planId;

    private String planName;

    private Integer approveAmounts;

    private Integer realAmounts;

    private String remark;

    private String filler;

    private String accountant;

    private String applicant;

    private static final long serialVersionUID = 1L;

    public Integer getRetirementAdvancedAgeExperienceInheritanceResultId() {
        return retirementAdvancedAgeExperienceInheritanceResultId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceResultId(Integer retirementAdvancedAgeExperienceInheritanceResultId) {
        this.retirementAdvancedAgeExperienceInheritanceResultId = retirementAdvancedAgeExperienceInheritanceResultId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getApproveAmounts() {
        return approveAmounts;
    }

    public void setApproveAmounts(Integer approveAmounts) {
        this.approveAmounts = approveAmounts;
    }

    public Integer getRealAmounts() {
        return realAmounts;
    }

    public void setRealAmounts(Integer realAmounts) {
        this.realAmounts = realAmounts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant == null ? null : accountant.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }
}