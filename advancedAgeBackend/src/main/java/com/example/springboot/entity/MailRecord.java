package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MailRecord implements Serializable {
    private Integer id;

    private String email;

    private String mailContent;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Integer advancedAgeBaseId;

    private String verifyUnit;

    private String verifyPerson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAdvancedAgeBaseId() {
        return advancedAgeBaseId;
    }

    public void setAdvancedAgeBaseId(Integer advancedAgeBaseId) {
        this.advancedAgeBaseId = advancedAgeBaseId;
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