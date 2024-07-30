package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgeBase implements Serializable {
    private String aaid;

    private Integer id;

    private String seq;

    private String companyName;

    private String year;

    private String unit;

    private String city;

    private String caseType;

    private String caseStatus;

    private String fileStatusRecord;

    private String fileRemark;

    private String emailContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date emailTime;

    private String fileStatus;

    private String checkMultipleCompany;

    private String checkWorkersEmployment;

    private String checkRelatives;

    private String checkRelatedAmounts;

    private String checkNotMandatory;

    private Integer checkEmploymentPerson;

    private String checkEmploymentRemark;

    private Integer checkSpeakerPerson;

    private String checkSpeakerRemark;

    private String checkScheduleRemark;

    private Integer checkExpenditureAmounts;

    private String checkExpenditureRemark;

    private String checkJointAuthorizeRemark;

    private String checkAttachmentRemark;

    private String checkBlacklistStatus;

    private String checkBlacklistRemark;

    private String checkSiteinspectionStatus;

    private String checkSiteinspectionRemark;

    private String checkInsuranceStatus;

    private String checkInsuranceRemark;

    private String checkAllowanceStatus;

    private String checkAllowanceRemark;

    private String checkCgssStatus;

    private String checkCgssRemark;

    private String checkViolationlaborlawsStatus;

    private String checkViolationlaborlawsRemark;

    private String officialDocumentNumber;

    private String caseDescription;

    private String allowanceId;

    private Integer allowanceAmounts;

    private String countersignId;

    private String allowanceCompanyName;

    private String allowanceSeq;

    private String allowancePlanName;

    private String allowanceApplyTime;

    private String allowanceApplyStartTime;

    private String allowanceApplyEndTime;

    private Integer allowanceTotalAmounts;

    private Integer allowanceApproveAmounts;

    private String allowanceApproveId;

    private String allowanceApproveTime;

    private String allowanceRemark;

    private String allowanceFrequencyRecord;

    private Integer allowanceApprovedAmounts;

    private String allowanceFileStatusRecord;

    private String allowanceFileRemark;

    private String allowanceEmailContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date allowanceEmailTime;

    private String allowanceFileStatus;

    private String checkAllowanceAttachmentRemark;

    private String reviewStatus;

    private String reviewRemark;

    private String reviewEmailContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date reviewEmailTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String updator;

    private String verifyUnit;

    private String verifyPerson;

    private static final long serialVersionUID = 1L;

    public String getAaid() {
        return aaid;
    }

    public void setAaid(String aaid) {
        this.aaid = aaid == null ? null : aaid.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus == null ? null : caseStatus.trim();
    }

    public String getFileStatusRecord() {
        return fileStatusRecord;
    }

    public void setFileStatusRecord(String fileStatusRecord) {
        this.fileStatusRecord = fileStatusRecord == null ? null : fileStatusRecord.trim();
    }

    public String getFileRemark() {
        return fileRemark;
    }

    public void setFileRemark(String fileRemark) {
        this.fileRemark = fileRemark == null ? null : fileRemark.trim();
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }

    public Date getEmailTime() {
        return emailTime;
    }

    public void setEmailTime(Date emailTime) {
        this.emailTime = emailTime;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus == null ? null : fileStatus.trim();
    }

    public String getCheckMultipleCompany() {
        return checkMultipleCompany;
    }

    public void setCheckMultipleCompany(String checkMultipleCompany) {
        this.checkMultipleCompany = checkMultipleCompany == null ? null : checkMultipleCompany.trim();
    }

    public String getCheckWorkersEmployment() {
        return checkWorkersEmployment;
    }

    public void setCheckWorkersEmployment(String checkWorkersEmployment) {
        this.checkWorkersEmployment = checkWorkersEmployment == null ? null : checkWorkersEmployment.trim();
    }

    public String getCheckRelatives() {
        return checkRelatives;
    }

    public void setCheckRelatives(String checkRelatives) {
        this.checkRelatives = checkRelatives == null ? null : checkRelatives.trim();
    }

    public String getCheckRelatedAmounts() {
        return checkRelatedAmounts;
    }

    public void setCheckRelatedAmounts(String checkRelatedAmounts) {
        this.checkRelatedAmounts = checkRelatedAmounts == null ? null : checkRelatedAmounts.trim();
    }

    public String getCheckNotMandatory() {
        return checkNotMandatory;
    }

    public void setCheckNotMandatory(String checkNotMandatory) {
        this.checkNotMandatory = checkNotMandatory == null ? null : checkNotMandatory.trim();
    }

    public Integer getCheckEmploymentPerson() {
        return checkEmploymentPerson;
    }

    public void setCheckEmploymentPerson(Integer checkEmploymentPerson) {
        this.checkEmploymentPerson = checkEmploymentPerson;
    }

    public String getCheckEmploymentRemark() {
        return checkEmploymentRemark;
    }

    public void setCheckEmploymentRemark(String checkEmploymentRemark) {
        this.checkEmploymentRemark = checkEmploymentRemark == null ? null : checkEmploymentRemark.trim();
    }

    public Integer getCheckSpeakerPerson() {
        return checkSpeakerPerson;
    }

    public void setCheckSpeakerPerson(Integer checkSpeakerPerson) {
        this.checkSpeakerPerson = checkSpeakerPerson;
    }

    public String getCheckSpeakerRemark() {
        return checkSpeakerRemark;
    }

    public void setCheckSpeakerRemark(String checkSpeakerRemark) {
        this.checkSpeakerRemark = checkSpeakerRemark == null ? null : checkSpeakerRemark.trim();
    }

    public String getCheckScheduleRemark() {
        return checkScheduleRemark;
    }

    public void setCheckScheduleRemark(String checkScheduleRemark) {
        this.checkScheduleRemark = checkScheduleRemark == null ? null : checkScheduleRemark.trim();
    }

    public Integer getCheckExpenditureAmounts() {
        return checkExpenditureAmounts;
    }

    public void setCheckExpenditureAmounts(Integer checkExpenditureAmounts) {
        this.checkExpenditureAmounts = checkExpenditureAmounts;
    }

    public String getCheckExpenditureRemark() {
        return checkExpenditureRemark;
    }

    public void setCheckExpenditureRemark(String checkExpenditureRemark) {
        this.checkExpenditureRemark = checkExpenditureRemark == null ? null : checkExpenditureRemark.trim();
    }

    public String getCheckJointAuthorizeRemark() {
        return checkJointAuthorizeRemark;
    }

    public void setCheckJointAuthorizeRemark(String checkJointAuthorizeRemark) {
        this.checkJointAuthorizeRemark = checkJointAuthorizeRemark == null ? null : checkJointAuthorizeRemark.trim();
    }

    public String getCheckAttachmentRemark() {
        return checkAttachmentRemark;
    }

    public void setCheckAttachmentRemark(String checkAttachmentRemark) {
        this.checkAttachmentRemark = checkAttachmentRemark == null ? null : checkAttachmentRemark.trim();
    }

    public String getCheckBlacklistStatus() {
        return checkBlacklistStatus;
    }

    public void setCheckBlacklistStatus(String checkBlacklistStatus) {
        this.checkBlacklistStatus = checkBlacklistStatus == null ? null : checkBlacklistStatus.trim();
    }

    public String getCheckBlacklistRemark() {
        return checkBlacklistRemark;
    }

    public void setCheckBlacklistRemark(String checkBlacklistRemark) {
        this.checkBlacklistRemark = checkBlacklistRemark == null ? null : checkBlacklistRemark.trim();
    }

    public String getCheckSiteinspectionStatus() {
        return checkSiteinspectionStatus;
    }

    public void setCheckSiteinspectionStatus(String checkSiteinspectionStatus) {
        this.checkSiteinspectionStatus = checkSiteinspectionStatus == null ? null : checkSiteinspectionStatus.trim();
    }

    public String getCheckSiteinspectionRemark() {
        return checkSiteinspectionRemark;
    }

    public void setCheckSiteinspectionRemark(String checkSiteinspectionRemark) {
        this.checkSiteinspectionRemark = checkSiteinspectionRemark == null ? null : checkSiteinspectionRemark.trim();
    }

    public String getCheckInsuranceStatus() {
        return checkInsuranceStatus;
    }

    public void setCheckInsuranceStatus(String checkInsuranceStatus) {
        this.checkInsuranceStatus = checkInsuranceStatus == null ? null : checkInsuranceStatus.trim();
    }

    public String getCheckInsuranceRemark() {
        return checkInsuranceRemark;
    }

    public void setCheckInsuranceRemark(String checkInsuranceRemark) {
        this.checkInsuranceRemark = checkInsuranceRemark == null ? null : checkInsuranceRemark.trim();
    }

    public String getCheckAllowanceStatus() {
        return checkAllowanceStatus;
    }

    public void setCheckAllowanceStatus(String checkAllowanceStatus) {
        this.checkAllowanceStatus = checkAllowanceStatus == null ? null : checkAllowanceStatus.trim();
    }

    public String getCheckAllowanceRemark() {
        return checkAllowanceRemark;
    }

    public void setCheckAllowanceRemark(String checkAllowanceRemark) {
        this.checkAllowanceRemark = checkAllowanceRemark == null ? null : checkAllowanceRemark.trim();
    }

    public String getCheckCgssStatus() {
        return checkCgssStatus;
    }

    public void setCheckCgssStatus(String checkCgssStatus) {
        this.checkCgssStatus = checkCgssStatus == null ? null : checkCgssStatus.trim();
    }

    public String getCheckCgssRemark() {
        return checkCgssRemark;
    }

    public void setCheckCgssRemark(String checkCgssRemark) {
        this.checkCgssRemark = checkCgssRemark == null ? null : checkCgssRemark.trim();
    }

    public String getCheckViolationlaborlawsStatus() {
        return checkViolationlaborlawsStatus;
    }

    public void setCheckViolationlaborlawsStatus(String checkViolationlaborlawsStatus) {
        this.checkViolationlaborlawsStatus = checkViolationlaborlawsStatus == null ? null : checkViolationlaborlawsStatus.trim();
    }

    public String getCheckViolationlaborlawsRemark() {
        return checkViolationlaborlawsRemark;
    }

    public void setCheckViolationlaborlawsRemark(String checkViolationlaborlawsRemark) {
        this.checkViolationlaborlawsRemark = checkViolationlaborlawsRemark == null ? null : checkViolationlaborlawsRemark.trim();
    }

    public String getOfficialDocumentNumber() {
        return officialDocumentNumber;
    }

    public void setOfficialDocumentNumber(String officialDocumentNumber) {
        this.officialDocumentNumber = officialDocumentNumber == null ? null : officialDocumentNumber.trim();
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription == null ? null : caseDescription.trim();
    }

    public String getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(String allowanceId) {
        this.allowanceId = allowanceId == null ? null : allowanceId.trim();
    }

    public Integer getAllowanceAmounts() {
        return allowanceAmounts;
    }

    public void setAllowanceAmounts(Integer allowanceAmounts) {
        this.allowanceAmounts = allowanceAmounts;
    }

    public String getCountersignId() {
        return countersignId;
    }

    public void setCountersignId(String countersignId) {
        this.countersignId = countersignId == null ? null : countersignId.trim();
    }

    public String getAllowanceCompanyName() {
        return allowanceCompanyName;
    }

    public void setAllowanceCompanyName(String allowanceCompanyName) {
        this.allowanceCompanyName = allowanceCompanyName == null ? null : allowanceCompanyName.trim();
    }

    public String getAllowanceSeq() {
        return allowanceSeq;
    }

    public void setAllowanceSeq(String allowanceSeq) {
        this.allowanceSeq = allowanceSeq == null ? null : allowanceSeq.trim();
    }

    public String getAllowancePlanName() {
        return allowancePlanName;
    }

    public void setAllowancePlanName(String allowancePlanName) {
        this.allowancePlanName = allowancePlanName == null ? null : allowancePlanName.trim();
    }

    public String getAllowanceApplyTime() {
        return allowanceApplyTime;
    }

    public void setAllowanceApplyTime(String allowanceApplyTime) {
        this.allowanceApplyTime = allowanceApplyTime == null ? null : allowanceApplyTime.trim();
    }

    public String getAllowanceApplyStartTime() {
        return allowanceApplyStartTime;
    }

    public void setAllowanceApplyStartTime(String allowanceApplyStartTime) {
        this.allowanceApplyStartTime = allowanceApplyStartTime == null ? null : allowanceApplyStartTime.trim();
    }

    public String getAllowanceApplyEndTime() {
        return allowanceApplyEndTime;
    }

    public void setAllowanceApplyEndTime(String allowanceApplyEndTime) {
        this.allowanceApplyEndTime = allowanceApplyEndTime == null ? null : allowanceApplyEndTime.trim();
    }

    public Integer getAllowanceTotalAmounts() {
        return allowanceTotalAmounts;
    }

    public void setAllowanceTotalAmounts(Integer allowanceTotalAmounts) {
        this.allowanceTotalAmounts = allowanceTotalAmounts;
    }

    public Integer getAllowanceApproveAmounts() {
        return allowanceApproveAmounts;
    }

    public void setAllowanceApproveAmounts(Integer allowanceApproveAmounts) {
        this.allowanceApproveAmounts = allowanceApproveAmounts;
    }

    public String getAllowanceApproveId() {
        return allowanceApproveId;
    }

    public void setAllowanceApproveId(String allowanceApproveId) {
        this.allowanceApproveId = allowanceApproveId == null ? null : allowanceApproveId.trim();
    }

    public String getAllowanceApproveTime() {
        return allowanceApproveTime;
    }

    public void setAllowanceApproveTime(String allowanceApproveTime) {
        this.allowanceApproveTime = allowanceApproveTime == null ? null : allowanceApproveTime.trim();
    }

    public String getAllowanceRemark() {
        return allowanceRemark;
    }

    public void setAllowanceRemark(String allowanceRemark) {
        this.allowanceRemark = allowanceRemark == null ? null : allowanceRemark.trim();
    }

    public String getAllowanceFrequencyRecord() {
        return allowanceFrequencyRecord;
    }

    public void setAllowanceFrequencyRecord(String allowanceFrequencyRecord) {
        this.allowanceFrequencyRecord = allowanceFrequencyRecord == null ? null : allowanceFrequencyRecord.trim();
    }

    public Integer getAllowanceApprovedAmounts() {
        return allowanceApprovedAmounts;
    }

    public void setAllowanceApprovedAmounts(Integer allowanceApprovedAmounts) {
        this.allowanceApprovedAmounts = allowanceApprovedAmounts;
    }

    public String getAllowanceFileStatusRecord() {
        return allowanceFileStatusRecord;
    }

    public void setAllowanceFileStatusRecord(String allowanceFileStatusRecord) {
        this.allowanceFileStatusRecord = allowanceFileStatusRecord == null ? null : allowanceFileStatusRecord.trim();
    }

    public String getAllowanceFileRemark() {
        return allowanceFileRemark;
    }

    public void setAllowanceFileRemark(String allowanceFileRemark) {
        this.allowanceFileRemark = allowanceFileRemark == null ? null : allowanceFileRemark.trim();
    }

    public String getAllowanceEmailContent() {
        return allowanceEmailContent;
    }

    public void setAllowanceEmailContent(String allowanceEmailContent) {
        this.allowanceEmailContent = allowanceEmailContent == null ? null : allowanceEmailContent.trim();
    }

    public Date getAllowanceEmailTime() {
        return allowanceEmailTime;
    }

    public void setAllowanceEmailTime(Date allowanceEmailTime) {
        this.allowanceEmailTime = allowanceEmailTime;
    }

    public String getAllowanceFileStatus() {
        return allowanceFileStatus;
    }

    public void setAllowanceFileStatus(String allowanceFileStatus) {
        this.allowanceFileStatus = allowanceFileStatus == null ? null : allowanceFileStatus.trim();
    }

    public String getCheckAllowanceAttachmentRemark() {
        return checkAllowanceAttachmentRemark;
    }

    public void setCheckAllowanceAttachmentRemark(String checkAllowanceAttachmentRemark) {
        this.checkAllowanceAttachmentRemark = checkAllowanceAttachmentRemark == null ? null : checkAllowanceAttachmentRemark.trim();
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus == null ? null : reviewStatus.trim();
    }

    public String getReviewRemark() {
        return reviewRemark;
    }

    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark == null ? null : reviewRemark.trim();
    }

    public String getReviewEmailContent() {
        return reviewEmailContent;
    }

    public void setReviewEmailContent(String reviewEmailContent) {
        this.reviewEmailContent = reviewEmailContent == null ? null : reviewEmailContent.trim();
    }

    public Date getReviewEmailTime() {
        return reviewEmailTime;
    }

    public void setReviewEmailTime(Date reviewEmailTime) {
        this.reviewEmailTime = reviewEmailTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public String getVerifyUnit() {
        return verifyUnit;
    }

    public void setVerifyUnit(String verifyUnit) {
        this.verifyUnit = verifyUnit == null ? null : verifyUnit.trim();
    }

    public String getVerifyPerson() {
        return verifyPerson;
    }

    public void setVerifyPerson(String verifyPerson) {
        this.verifyPerson = verifyPerson == null ? null : verifyPerson.trim();
    }
}