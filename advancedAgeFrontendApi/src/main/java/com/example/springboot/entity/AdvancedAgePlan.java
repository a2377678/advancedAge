package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvancedAgePlan implements Serializable {
    private Integer advancedAgeApplyId;

    private Integer id;

    private String companyName;

    private String companyCreateTime;

    private String items;

    private Integer employmentNumber;

    private Integer highEmploymentNumber;

    private Integer middleEmploymentNumber;

    private Integer lowEmploymentNumber;

    private String friendlyMeasures;

    private String attachFriendlyMeasures;

    private Integer nearHighEmploymentNumber;

    private Integer continueEmploymentNumber;

    private Double continueEmploymentPercentage;

    private String assistanceMeasures;

    private String attachAssistanceMeasures;

    private String expectedMeasuresEffectiveness;

    private String attachExpectedMeasuresEffectiveness;

    private String attachEmploymentList;

    private String creater;

    private String businessManager;

    private String companyPrincipal;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getAdvancedAgeApplyId() {
        return advancedAgeApplyId;
    }

    public void setAdvancedAgeApplyId(Integer advancedAgeApplyId) {
        this.advancedAgeApplyId = advancedAgeApplyId;
    }

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

    public String getCompanyCreateTime() {
        return companyCreateTime;
    }

    public void setCompanyCreateTime(String companyCreateTime) {
        this.companyCreateTime = companyCreateTime == null ? null : companyCreateTime.trim();
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }

    public Integer getEmploymentNumber() {
        return employmentNumber;
    }

    public void setEmploymentNumber(Integer employmentNumber) {
        this.employmentNumber = employmentNumber;
    }

    public Integer getHighEmploymentNumber() {
        return highEmploymentNumber;
    }

    public void setHighEmploymentNumber(Integer highEmploymentNumber) {
        this.highEmploymentNumber = highEmploymentNumber;
    }

    public Integer getMiddleEmploymentNumber() {
        return middleEmploymentNumber;
    }

    public void setMiddleEmploymentNumber(Integer middleEmploymentNumber) {
        this.middleEmploymentNumber = middleEmploymentNumber;
    }

    public Integer getLowEmploymentNumber() {
        return lowEmploymentNumber;
    }

    public void setLowEmploymentNumber(Integer lowEmploymentNumber) {
        this.lowEmploymentNumber = lowEmploymentNumber;
    }

    public String getFriendlyMeasures() {
        return friendlyMeasures;
    }

    public void setFriendlyMeasures(String friendlyMeasures) {
        this.friendlyMeasures = friendlyMeasures == null ? null : friendlyMeasures.trim();
    }

    public String getAttachFriendlyMeasures() {
        return attachFriendlyMeasures;
    }

    public void setAttachFriendlyMeasures(String attachFriendlyMeasures) {
        this.attachFriendlyMeasures = attachFriendlyMeasures == null ? null : attachFriendlyMeasures.trim();
    }

    public Integer getNearHighEmploymentNumber() {
        return nearHighEmploymentNumber;
    }

    public void setNearHighEmploymentNumber(Integer nearHighEmploymentNumber) {
        this.nearHighEmploymentNumber = nearHighEmploymentNumber;
    }

    public Integer getContinueEmploymentNumber() {
        return continueEmploymentNumber;
    }

    public void setContinueEmploymentNumber(Integer continueEmploymentNumber) {
        this.continueEmploymentNumber = continueEmploymentNumber;
    }

    public Double getContinueEmploymentPercentage() {
        return continueEmploymentPercentage;
    }

    public void setContinueEmploymentPercentage(Double continueEmploymentPercentage) {
        this.continueEmploymentPercentage = continueEmploymentPercentage;
    }

    public String getAssistanceMeasures() {
        return assistanceMeasures;
    }

    public void setAssistanceMeasures(String assistanceMeasures) {
        this.assistanceMeasures = assistanceMeasures == null ? null : assistanceMeasures.trim();
    }

    public String getAttachAssistanceMeasures() {
        return attachAssistanceMeasures;
    }

    public void setAttachAssistanceMeasures(String attachAssistanceMeasures) {
        this.attachAssistanceMeasures = attachAssistanceMeasures == null ? null : attachAssistanceMeasures.trim();
    }

    public String getExpectedMeasuresEffectiveness() {
        return expectedMeasuresEffectiveness;
    }

    public void setExpectedMeasuresEffectiveness(String expectedMeasuresEffectiveness) {
        this.expectedMeasuresEffectiveness = expectedMeasuresEffectiveness == null ? null : expectedMeasuresEffectiveness.trim();
    }

    public String getAttachExpectedMeasuresEffectiveness() {
        return attachExpectedMeasuresEffectiveness;
    }

    public void setAttachExpectedMeasuresEffectiveness(String attachExpectedMeasuresEffectiveness) {
        this.attachExpectedMeasuresEffectiveness = attachExpectedMeasuresEffectiveness == null ? null : attachExpectedMeasuresEffectiveness.trim();
    }

    public String getAttachEmploymentList() {
        return attachEmploymentList;
    }

    public void setAttachEmploymentList(String attachEmploymentList) {
        this.attachEmploymentList = attachEmploymentList == null ? null : attachEmploymentList.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getBusinessManager() {
        return businessManager;
    }

    public void setBusinessManager(String businessManager) {
        this.businessManager = businessManager == null ? null : businessManager.trim();
    }

    public String getCompanyPrincipal() {
        return companyPrincipal;
    }

    public void setCompanyPrincipal(String companyPrincipal) {
        this.companyPrincipal = companyPrincipal == null ? null : companyPrincipal.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}