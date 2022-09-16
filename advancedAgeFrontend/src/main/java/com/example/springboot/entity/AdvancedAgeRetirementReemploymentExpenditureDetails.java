package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgeRetirementReemploymentExpenditureDetails implements Serializable {
    private Integer id;

    private String companyName;

    private Integer planId;

    private String planName;

    private Integer approveAmounts;

    private Integer realAmounts;

    private Integer otherRealAmounts;

    private Integer receiptId;

    private String description;

    private String filler;

    private String accountant;

    private String applicant;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Integer advancedAgeRetirementReemploymentResultId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
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

    public Integer getOtherRealAmounts() {
        return otherRealAmounts;
    }

    public void setOtherRealAmounts(Integer otherRealAmounts) {
        this.otherRealAmounts = otherRealAmounts;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAdvancedAgeRetirementReemploymentResultId() {
        return advancedAgeRetirementReemploymentResultId;
    }

    public void setAdvancedAgeRetirementReemploymentResultId(Integer advancedAgeRetirementReemploymentResultId) {
        this.advancedAgeRetirementReemploymentResultId = advancedAgeRetirementReemploymentResultId;
    }
}