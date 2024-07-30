package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentBasicData extends AdvancedAgeRetirementReemploymentBasicDataKey implements Serializable {
    private Integer id;

    private String companyName;

    private String guaranteeNumber;

    private String principal;

    private String contactName;

    private String contactWorkPhoneAreaCode;

    private String contactWorkPhone;

    private String contactWorkPhoneExtension;

    private String contactPhone;

    private String email;

    private String businessItem;

    private String industry;

    private String unitSize;

    private Integer employeeNumber;

    private Integer participateNumber;

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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBusinessItem() {
        return businessItem;
    }

    public void setBusinessItem(String businessItem) {
        this.businessItem = businessItem == null ? null : businessItem.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(String unitSize) {
        this.unitSize = unitSize == null ? null : unitSize.trim();
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getParticipateNumber() {
        return participateNumber;
    }

    public void setParticipateNumber(Integer participateNumber) {
        this.participateNumber = participateNumber;
    }
}