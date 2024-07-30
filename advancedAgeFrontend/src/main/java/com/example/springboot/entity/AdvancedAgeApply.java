package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgeApply extends AdvancedAgeApplyKey implements Serializable {
    private Integer id;

    private String companyName;

    private String guaranteeNumber;

    private String principal;

    private String registerPostalCode;

    private String registerCity;

    private String registerArea;

    private String registerAddress;

    private String contactName;

    private String contactJobtitle;

    private String contactWorkPhoneAreaCode;

    private String contactWorkPhone;

    private String contactWorkPhoneExtension;

    private String contactPhone;

    private String faxAreaCode;

    private String fax;

    private String email;

    private String contactCity;

    private String contactArea;

    private String contactAddress;

    private String multipleCompany;

    private String workersEmployment;

    private String relatives;

    private String relatedAmounts;

    private String notMandatory;

    private String industry;

    private String attachDocumentsApply;

    private String attachDocumentsPlan;

    private String attachDocumentsRegisterProof;

    private String attachDocumentsInsureProof;

    private String oldEmploymentPercentage;

    private Integer oldEmploymentNumber;

    private Integer continusOldEmploymentNumber;

    private Double continusOldEmploymentPercentage;

    private String attachDocumentsSalaryProof;

    private String attachDocumentsOtherProof;

    private String attachDocumentsOtherProofDocument;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String acceptUnit;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date acceptTime;

    private String verifyPerson;

    private String businessManager;

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
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

    public String getNotMandatory() {
        return notMandatory;
    }

    public void setNotMandatory(String notMandatory) {
        this.notMandatory = notMandatory == null ? null : notMandatory.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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

    public String getAttachDocumentsRegisterProof() {
        return attachDocumentsRegisterProof;
    }

    public void setAttachDocumentsRegisterProof(String attachDocumentsRegisterProof) {
        this.attachDocumentsRegisterProof = attachDocumentsRegisterProof == null ? null : attachDocumentsRegisterProof.trim();
    }

    public String getAttachDocumentsInsureProof() {
        return attachDocumentsInsureProof;
    }

    public void setAttachDocumentsInsureProof(String attachDocumentsInsureProof) {
        this.attachDocumentsInsureProof = attachDocumentsInsureProof == null ? null : attachDocumentsInsureProof.trim();
    }

    public String getOldEmploymentPercentage() {
        return oldEmploymentPercentage;
    }

    public void setOldEmploymentPercentage(String oldEmploymentPercentage) {
        this.oldEmploymentPercentage = oldEmploymentPercentage == null ? null : oldEmploymentPercentage.trim();
    }

    public Integer getOldEmploymentNumber() {
        return oldEmploymentNumber;
    }

    public void setOldEmploymentNumber(Integer oldEmploymentNumber) {
        this.oldEmploymentNumber = oldEmploymentNumber;
    }

    public Integer getContinusOldEmploymentNumber() {
        return continusOldEmploymentNumber;
    }

    public void setContinusOldEmploymentNumber(Integer continusOldEmploymentNumber) {
        this.continusOldEmploymentNumber = continusOldEmploymentNumber;
    }

    public Double getContinusOldEmploymentPercentage() {
        return continusOldEmploymentPercentage;
    }

    public void setContinusOldEmploymentPercentage(Double continusOldEmploymentPercentage) {
        this.continusOldEmploymentPercentage = continusOldEmploymentPercentage;
    }

    public String getAttachDocumentsSalaryProof() {
        return attachDocumentsSalaryProof;
    }

    public void setAttachDocumentsSalaryProof(String attachDocumentsSalaryProof) {
        this.attachDocumentsSalaryProof = attachDocumentsSalaryProof == null ? null : attachDocumentsSalaryProof.trim();
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

    public String getAcceptUnit() {
        return acceptUnit;
    }

    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit == null ? null : acceptUnit.trim();
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getVerifyPerson() {
        return verifyPerson;
    }

    public void setVerifyPerson(String verifyPerson) {
        this.verifyPerson = verifyPerson == null ? null : verifyPerson.trim();
    }

    public String getBusinessManager() {
        return businessManager;
    }

    public void setBusinessManager(String businessManager) {
        this.businessManager = businessManager == null ? null : businessManager.trim();
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