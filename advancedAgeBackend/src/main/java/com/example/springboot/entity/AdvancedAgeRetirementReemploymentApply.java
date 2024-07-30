package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class AdvancedAgeRetirementReemploymentApply extends AdvancedAgeRetirementReemploymentApplyKey implements Serializable {
    private Integer id;

    private String assistanceMeasures1;

    private String assistanceMeasures2;

    private String assistanceMeasures3;

    private String companyName;

    private String guaranteeNumber;

    private String registerPostalCode;

    private String registerCity;

    private String registerArea;

    private String registerAddress;

    private String principal;

    private String jobtitle;

    private String contactCity;

    private String contactArea;

    private String contactAddress;

    private String multipleCompany;

    private String relatedAmounts;

    private Integer employeeNumber;

    private Integer benefitNumber;

    private String companyAttributes;

    private String industry;

    private String contactName;

    private String contactJobtitle;

    private String contactWorkPhoneAreaCode;

    private String contactWorkPhone;

    private String contactWorkPhoneExtension;

    private String contactPhone;

    private String faxAreaCode;

    private String fax;

    private String email;

    private Integer amounts;

    private String applyManyGovernment;

    private String applyManyGovernmentYear;

    private String applyManyGovernmentPlanName;

    private Integer applyManyGovernmentAmounts;

    private String repeatApply;

    private String repeatApplyYear;

    private Integer repeatApplyAmounts;

    private String attachDocumentsApply;

    private String attachDocumentsPlan;

    private String attachDocumentsExpenditure;

    private String attachDocumentsRegisterProof;

    private String jointAuthorizeBasicData;

    private String attachDocumentsOtherProof;

    private String attachDocumentsOtherProofDocument;

    private Date createTime;

    private String agree;

    private String filler;

    private String applicant;

    private String updator;

    private Date updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssistanceMeasures1() {
        return assistanceMeasures1;
    }

    public void setAssistanceMeasures1(String assistanceMeasures1) {
        this.assistanceMeasures1 = assistanceMeasures1 == null ? null : assistanceMeasures1.trim();
    }

    public String getAssistanceMeasures2() {
        return assistanceMeasures2;
    }

    public void setAssistanceMeasures2(String assistanceMeasures2) {
        this.assistanceMeasures2 = assistanceMeasures2 == null ? null : assistanceMeasures2.trim();
    }

    public String getAssistanceMeasures3() {
        return assistanceMeasures3;
    }

    public void setAssistanceMeasures3(String assistanceMeasures3) {
        this.assistanceMeasures3 = assistanceMeasures3 == null ? null : assistanceMeasures3.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getGuaranteeNumber() {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(String guaranteeNumber) {
        this.guaranteeNumber = guaranteeNumber == null ? null : guaranteeNumber.trim();
    }

    public String getRegisterPostalCode() {
        return registerPostalCode;
    }

    public void setRegisterPostalCode(String registerPostalCode) {
        this.registerPostalCode = registerPostalCode == null ? null : registerPostalCode.trim();
    }

    public String getRegisterCity() {
        return registerCity;
    }

    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity == null ? null : registerCity.trim();
    }

    public String getRegisterArea() {
        return registerArea;
    }

    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea == null ? null : registerArea.trim();
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity == null ? null : contactCity.trim();
    }

    public String getContactArea() {
        return contactArea;
    }

    public void setContactArea(String contactArea) {
        this.contactArea = contactArea == null ? null : contactArea.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getMultipleCompany() {
        return multipleCompany;
    }

    public void setMultipleCompany(String multipleCompany) {
        this.multipleCompany = multipleCompany == null ? null : multipleCompany.trim();
    }

    public String getRelatedAmounts() {
        return relatedAmounts;
    }

    public void setRelatedAmounts(String relatedAmounts) {
        this.relatedAmounts = relatedAmounts == null ? null : relatedAmounts.trim();
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getBenefitNumber() {
        return benefitNumber;
    }

    public void setBenefitNumber(Integer benefitNumber) {
        this.benefitNumber = benefitNumber;
    }

    public String getCompanyAttributes() {
        return companyAttributes;
    }

    public void setCompanyAttributes(String companyAttributes) {
        this.companyAttributes = companyAttributes == null ? null : companyAttributes.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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

    public String getContactWorkPhoneAreaCode() {
        return contactWorkPhoneAreaCode;
    }

    public void setContactWorkPhoneAreaCode(String contactWorkPhoneAreaCode) {
        this.contactWorkPhoneAreaCode = contactWorkPhoneAreaCode == null ? null : contactWorkPhoneAreaCode.trim();
    }

    public String getContactWorkPhone() {
        return contactWorkPhone;
    }

    public void setContactWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone == null ? null : contactWorkPhone.trim();
    }

    public String getContactWorkPhoneExtension() {
        return contactWorkPhoneExtension;
    }

    public void setContactWorkPhoneExtension(String contactWorkPhoneExtension) {
        this.contactWorkPhoneExtension = contactWorkPhoneExtension == null ? null : contactWorkPhoneExtension.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getFaxAreaCode() {
        return faxAreaCode;
    }

    public void setFaxAreaCode(String faxAreaCode) {
        this.faxAreaCode = faxAreaCode == null ? null : faxAreaCode.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public String getApplyManyGovernment() {
        return applyManyGovernment;
    }

    public void setApplyManyGovernment(String applyManyGovernment) {
        this.applyManyGovernment = applyManyGovernment == null ? null : applyManyGovernment.trim();
    }

    public String getApplyManyGovernmentYear() {
        return applyManyGovernmentYear;
    }

    public void setApplyManyGovernmentYear(String applyManyGovernmentYear) {
        this.applyManyGovernmentYear = applyManyGovernmentYear == null ? null : applyManyGovernmentYear.trim();
    }

    public String getApplyManyGovernmentPlanName() {
        return applyManyGovernmentPlanName;
    }

    public void setApplyManyGovernmentPlanName(String applyManyGovernmentPlanName) {
        this.applyManyGovernmentPlanName = applyManyGovernmentPlanName == null ? null : applyManyGovernmentPlanName.trim();
    }

    public Integer getApplyManyGovernmentAmounts() {
        return applyManyGovernmentAmounts;
    }

    public void setApplyManyGovernmentAmounts(Integer applyManyGovernmentAmounts) {
        this.applyManyGovernmentAmounts = applyManyGovernmentAmounts;
    }

    public String getRepeatApply() {
        return repeatApply;
    }

    public void setRepeatApply(String repeatApply) {
        this.repeatApply = repeatApply == null ? null : repeatApply.trim();
    }

    public String getRepeatApplyYear() {
        return repeatApplyYear;
    }

    public void setRepeatApplyYear(String repeatApplyYear) {
        this.repeatApplyYear = repeatApplyYear == null ? null : repeatApplyYear.trim();
    }

    public Integer getRepeatApplyAmounts() {
        return repeatApplyAmounts;
    }

    public void setRepeatApplyAmounts(Integer repeatApplyAmounts) {
        this.repeatApplyAmounts = repeatApplyAmounts;
    }

    public String getAttachDocumentsApply() {
        return attachDocumentsApply;
    }

    public void setAttachDocumentsApply(String attachDocumentsApply) {
        this.attachDocumentsApply = attachDocumentsApply == null ? null : attachDocumentsApply.trim();
    }

    public String getAttachDocumentsPlan() {
        return attachDocumentsPlan;
    }

    public void setAttachDocumentsPlan(String attachDocumentsPlan) {
        this.attachDocumentsPlan = attachDocumentsPlan == null ? null : attachDocumentsPlan.trim();
    }

    public String getAttachDocumentsExpenditure() {
        return attachDocumentsExpenditure;
    }

    public void setAttachDocumentsExpenditure(String attachDocumentsExpenditure) {
        this.attachDocumentsExpenditure = attachDocumentsExpenditure == null ? null : attachDocumentsExpenditure.trim();
    }

    public String getAttachDocumentsRegisterProof() {
        return attachDocumentsRegisterProof;
    }

    public void setAttachDocumentsRegisterProof(String attachDocumentsRegisterProof) {
        this.attachDocumentsRegisterProof = attachDocumentsRegisterProof == null ? null : attachDocumentsRegisterProof.trim();
    }

    public String getJointAuthorizeBasicData() {
        return jointAuthorizeBasicData;
    }

    public void setJointAuthorizeBasicData(String jointAuthorizeBasicData) {
        this.jointAuthorizeBasicData = jointAuthorizeBasicData == null ? null : jointAuthorizeBasicData.trim();
    }

    public String getAttachDocumentsOtherProof() {
        return attachDocumentsOtherProof;
    }

    public void setAttachDocumentsOtherProof(String attachDocumentsOtherProof) {
        this.attachDocumentsOtherProof = attachDocumentsOtherProof == null ? null : attachDocumentsOtherProof.trim();
    }

    public String getAttachDocumentsOtherProofDocument() {
        return attachDocumentsOtherProofDocument;
    }

    public void setAttachDocumentsOtherProofDocument(String attachDocumentsOtherProofDocument) {
        this.attachDocumentsOtherProofDocument = attachDocumentsOtherProofDocument == null ? null : attachDocumentsOtherProofDocument.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree == null ? null : agree.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}