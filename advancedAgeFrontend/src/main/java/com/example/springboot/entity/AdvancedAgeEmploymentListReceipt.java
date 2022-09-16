package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgeEmploymentListReceipt extends AdvancedAgeEmploymentListReceiptKey implements Serializable {
    private Integer id;

    private String companyName;

    private String principal;

    private String employeeId;

    private String birthday;

    private String name;

    private String laborProtectionExpiredTime;

    private String occupationalAccidentProtectionExpiredTime;

    private Integer salary;

    private String salaryMethod;

    private String salaryMethodRemark;

    private String employmentMonthStartTime;

    private String employmentMonthEndTime;

    private String employmentHourStartTime;

    private String employmentHourEndTime;

    private Integer lowMonthNumber;

    private Integer highMonthNumber;

    private Integer lowHoursNumber;

    private Integer highHoursNumber;

    private Integer amounts;

    private String approveStatus;

    private Integer adjustAmounts;

    private String remark;

    private Integer baseAllowanceFrequency;

    private String verifyPerson;

    private String businessManager;

    private String headManager;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLaborProtectionExpiredTime() {
        return laborProtectionExpiredTime;
    }

    public void setLaborProtectionExpiredTime(String laborProtectionExpiredTime) {
        this.laborProtectionExpiredTime = laborProtectionExpiredTime == null ? null : laborProtectionExpiredTime.trim();
    }

    public String getOccupationalAccidentProtectionExpiredTime() {
        return occupationalAccidentProtectionExpiredTime;
    }

    public void setOccupationalAccidentProtectionExpiredTime(String occupationalAccidentProtectionExpiredTime) {
        this.occupationalAccidentProtectionExpiredTime = occupationalAccidentProtectionExpiredTime == null ? null : occupationalAccidentProtectionExpiredTime.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getSalaryMethod() {
        return salaryMethod;
    }

    public void setSalaryMethod(String salaryMethod) {
        this.salaryMethod = salaryMethod == null ? null : salaryMethod.trim();
    }

    public String getSalaryMethodRemark() {
        return salaryMethodRemark;
    }

    public void setSalaryMethodRemark(String salaryMethodRemark) {
        this.salaryMethodRemark = salaryMethodRemark == null ? null : salaryMethodRemark.trim();
    }

    public String getEmploymentMonthStartTime() {
        return employmentMonthStartTime;
    }

    public void setEmploymentMonthStartTime(String employmentMonthStartTime) {
        this.employmentMonthStartTime = employmentMonthStartTime == null ? null : employmentMonthStartTime.trim();
    }

    public String getEmploymentMonthEndTime() {
        return employmentMonthEndTime;
    }

    public void setEmploymentMonthEndTime(String employmentMonthEndTime) {
        this.employmentMonthEndTime = employmentMonthEndTime == null ? null : employmentMonthEndTime.trim();
    }

    public String getEmploymentHourStartTime() {
        return employmentHourStartTime;
    }

    public void setEmploymentHourStartTime(String employmentHourStartTime) {
        this.employmentHourStartTime = employmentHourStartTime == null ? null : employmentHourStartTime.trim();
    }

    public String getEmploymentHourEndTime() {
        return employmentHourEndTime;
    }

    public void setEmploymentHourEndTime(String employmentHourEndTime) {
        this.employmentHourEndTime = employmentHourEndTime == null ? null : employmentHourEndTime.trim();
    }

    public Integer getLowMonthNumber() {
        return lowMonthNumber;
    }

    public void setLowMonthNumber(Integer lowMonthNumber) {
        this.lowMonthNumber = lowMonthNumber;
    }

    public Integer getHighMonthNumber() {
        return highMonthNumber;
    }

    public void setHighMonthNumber(Integer highMonthNumber) {
        this.highMonthNumber = highMonthNumber;
    }

    public Integer getLowHoursNumber() {
        return lowHoursNumber;
    }

    public void setLowHoursNumber(Integer lowHoursNumber) {
        this.lowHoursNumber = lowHoursNumber;
    }

    public Integer getHighHoursNumber() {
        return highHoursNumber;
    }

    public void setHighHoursNumber(Integer highHoursNumber) {
        this.highHoursNumber = highHoursNumber;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public Integer getAdjustAmounts() {
        return adjustAmounts;
    }

    public void setAdjustAmounts(Integer adjustAmounts) {
        this.adjustAmounts = adjustAmounts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getBaseAllowanceFrequency() {
        return baseAllowanceFrequency;
    }

    public void setBaseAllowanceFrequency(Integer baseAllowanceFrequency) {
        this.baseAllowanceFrequency = baseAllowanceFrequency;
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

    public String getHeadManager() {
        return headManager;
    }

    public void setHeadManager(String headManager) {
        this.headManager = headManager == null ? null : headManager.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}