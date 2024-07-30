package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RetirementAdvancedAgeExperienceInheritanceApply extends RetirementAdvancedAgeExperienceInheritanceApplyKey implements Serializable {
    private Integer id;

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

    private Integer employeeNumber;

    private Integer retirementExperienceInheritanceNumber;

    private Integer employeeNumberStructure1;

    private Integer employeeNumberStructure2;

    private Integer employeeNumberStructure3;

    private Integer employeeNumberStructure4;

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

    private String multipleCompany;

    private String workersEmployment;

    private String relatives;

    private String relatedAmounts;

    private String attachDocumentsApply;

    private String attachDocumentsPlan;

    private String attachDocumentsSchedule;

    private String attachDocumentsExpenditure;

    private String attachDocumentsRegisterProof;

    private String attachDocumentsSpeakerRetirementProof;

    private String attachDocumentsSpeakerExperienceProof;

    private String attachDocumentsEmploymentProof;

    private String attachDocumentsOtherProof;

    private String attachDocumentsOtherProofDocument;

    private String agree;

    private String filler;

    private String applicant;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String updator;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private String remark;

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

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getRetirementExperienceInheritanceNumber() {
        return retirementExperienceInheritanceNumber;
    }

    public void setRetirementExperienceInheritanceNumber(Integer retirementExperienceInheritanceNumber) {
        this.retirementExperienceInheritanceNumber = retirementExperienceInheritanceNumber;
    }

    public Integer getEmployeeNumberStructure1() {
        return employeeNumberStructure1;
    }

    public void setEmployeeNumberStructure1(Integer employeeNumberStructure1) {
        this.employeeNumberStructure1 = employeeNumberStructure1;
    }

    public Integer getEmployeeNumberStructure2() {
        return employeeNumberStructure2;
    }

    public void setEmployeeNumberStructure2(Integer employeeNumberStructure2) {
        this.employeeNumberStructure2 = employeeNumberStructure2;
    }

    public Integer getEmployeeNumberStructure3() {
        return employeeNumberStructure3;
    }

    public void setEmployeeNumberStructure3(Integer employeeNumberStructure3) {
        this.employeeNumberStructure3 = employeeNumberStructure3;
    }

    public Integer getEmployeeNumberStructure4() {
        return employeeNumberStructure4;
    }

    public void setEmployeeNumberStructure4(Integer employeeNumberStructure4) {
        this.employeeNumberStructure4 = employeeNumberStructure4;
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

    public String getMultipleCompany() {
        return multipleCompany;
    }

    public void setMultipleCompany(String multipleCompany) {
        this.multipleCompany = multipleCompany == null ? null : multipleCompany.trim();
    }

    public String getWorkersEmployment() {
        return workersEmployment;
    }

    public void setWorkersEmployment(String workersEmployment) {
        this.workersEmployment = workersEmployment == null ? null : workersEmployment.trim();
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives == null ? null : relatives.trim();
    }

    public String getRelatedAmounts() {
        return relatedAmounts;
    }

    public void setRelatedAmounts(String relatedAmounts) {
        this.relatedAmounts = relatedAmounts == null ? null : relatedAmounts.trim();
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

    public String getAttachDocumentsSchedule() {
        return attachDocumentsSchedule;
    }

    public void setAttachDocumentsSchedule(String attachDocumentsSchedule) {
        this.attachDocumentsSchedule = attachDocumentsSchedule == null ? null : attachDocumentsSchedule.trim();
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

    public String getAttachDocumentsSpeakerRetirementProof() {
        return attachDocumentsSpeakerRetirementProof;
    }

    public void setAttachDocumentsSpeakerRetirementProof(String attachDocumentsSpeakerRetirementProof) {
        this.attachDocumentsSpeakerRetirementProof = attachDocumentsSpeakerRetirementProof == null ? null : attachDocumentsSpeakerRetirementProof.trim();
    }

    public String getAttachDocumentsSpeakerExperienceProof() {
        return attachDocumentsSpeakerExperienceProof;
    }

    public void setAttachDocumentsSpeakerExperienceProof(String attachDocumentsSpeakerExperienceProof) {
        this.attachDocumentsSpeakerExperienceProof = attachDocumentsSpeakerExperienceProof == null ? null : attachDocumentsSpeakerExperienceProof.trim();
    }

    public String getAttachDocumentsEmploymentProof() {
        return attachDocumentsEmploymentProof;
    }

    public void setAttachDocumentsEmploymentProof(String attachDocumentsEmploymentProof) {
        this.attachDocumentsEmploymentProof = attachDocumentsEmploymentProof == null ? null : attachDocumentsEmploymentProof.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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