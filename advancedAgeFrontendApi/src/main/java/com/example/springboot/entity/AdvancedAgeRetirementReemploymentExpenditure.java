package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentExpenditure implements Serializable {
    private Integer id;

    private String planId;

    private String planName;

    private Integer unitPrice;

    private Integer amount;

    private Integer amounts;

    private Integer otherAmounts;

    private String description;

    private String filler;

    private String accountant;

    private String applicant;

    private Integer advancedAgeRetirementReemploymentApplyId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public Integer getOtherAmounts() {
        return otherAmounts;
    }

    public void setOtherAmounts(Integer otherAmounts) {
        this.otherAmounts = otherAmounts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public Integer getAdvancedAgeRetirementReemploymentApplyId() {
        return advancedAgeRetirementReemploymentApplyId;
    }

    public void setAdvancedAgeRetirementReemploymentApplyId(Integer advancedAgeRetirementReemploymentApplyId) {
        this.advancedAgeRetirementReemploymentApplyId = advancedAgeRetirementReemploymentApplyId;
    }
}