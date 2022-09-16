package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BlackList implements Serializable {
    private Integer id;

    private String seq;

    private String companyName;

    private String unit;

    private String officialDocumentNumber;

    private String banStartDate;

    private String banEndDate;

    private String description;

    private String creator;

    private String updator;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getOfficialDocumentNumber() {
        return officialDocumentNumber;
    }

    public void setOfficialDocumentNumber(String officialDocumentNumber) {
        this.officialDocumentNumber = officialDocumentNumber == null ? null : officialDocumentNumber.trim();
    }

    public String getBanStartDate() {
        return banStartDate;
    }

    public void setBanStartDate(String banStartDate) {
        this.banStartDate = banStartDate == null ? null : banStartDate.trim();
    }

    public String getBanEndDate() {
        return banEndDate;
    }

    public void setBanEndDate(String banEndDate) {
        this.banEndDate = banEndDate == null ? null : banEndDate.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
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
}