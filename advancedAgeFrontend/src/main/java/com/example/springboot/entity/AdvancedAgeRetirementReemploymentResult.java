package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgeRetirementReemploymentResult extends AdvancedAgeRetirementReemploymentResultKey implements Serializable {
    private Integer id;

    private String companyName;

    private String principal;

    private String contactName;

    private String contactJobtitle;

    private String contactPhone;

    private String email;

    private Integer approveAmounts;

    private Integer realAmounts;

    private String planExecutionSituation;

    private String result;

    private String suggestion;

    private String attachment;

    private String attachDocumentsPlanApprove;

    private String attachDocumentsResult;

    private String attachDocumentsReceipt;

    private String attachDocumentsExpenditureDescription;

    private String attachDocumentsOtherProof;

    private String filler;

    private String manager;

    private String applicant;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactJobtitle() {
        return contactJobtitle;
    }

    public void setContactJobtitle(String contactJobtitle) {
        this.contactJobtitle = contactJobtitle == null ? null : contactJobtitle.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getPlanExecutionSituation() {
        return planExecutionSituation;
    }

    public void setPlanExecutionSituation(String planExecutionSituation) {
        this.planExecutionSituation = planExecutionSituation == null ? null : planExecutionSituation.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getAttachDocumentsPlanApprove() {
        return attachDocumentsPlanApprove;
    }

    public void setAttachDocumentsPlanApprove(String attachDocumentsPlanApprove) {
        this.attachDocumentsPlanApprove = attachDocumentsPlanApprove == null ? null : attachDocumentsPlanApprove.trim();
    }

    public String getAttachDocumentsResult() {
        return attachDocumentsResult;
    }

    public void setAttachDocumentsResult(String attachDocumentsResult) {
        this.attachDocumentsResult = attachDocumentsResult == null ? null : attachDocumentsResult.trim();
    }

    public String getAttachDocumentsReceipt() {
        return attachDocumentsReceipt;
    }

    public void setAttachDocumentsReceipt(String attachDocumentsReceipt) {
        this.attachDocumentsReceipt = attachDocumentsReceipt == null ? null : attachDocumentsReceipt.trim();
    }

    public String getAttachDocumentsExpenditureDescription() {
        return attachDocumentsExpenditureDescription;
    }

    public void setAttachDocumentsExpenditureDescription(String attachDocumentsExpenditureDescription) {
        this.attachDocumentsExpenditureDescription = attachDocumentsExpenditureDescription == null ? null : attachDocumentsExpenditureDescription.trim();
    }

    public String getAttachDocumentsOtherProof() {
        return attachDocumentsOtherProof;
    }

    public void setAttachDocumentsOtherProof(String attachDocumentsOtherProof) {
        this.attachDocumentsOtherProof = attachDocumentsOtherProof == null ? null : attachDocumentsOtherProof.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
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
}