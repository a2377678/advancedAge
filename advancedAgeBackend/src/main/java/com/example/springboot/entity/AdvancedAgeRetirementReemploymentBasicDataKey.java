package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentBasicDataKey implements Serializable {
    private String seq;

    private Integer advancedAgeRetirementReemploymentJointAuthorizeId;

    private static final long serialVersionUID = 1L;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public Integer getAdvancedAgeRetirementReemploymentJointAuthorizeId() {
        return advancedAgeRetirementReemploymentJointAuthorizeId;
    }

    public void setAdvancedAgeRetirementReemploymentJointAuthorizeId(Integer advancedAgeRetirementReemploymentJointAuthorizeId) {
        this.advancedAgeRetirementReemploymentJointAuthorizeId = advancedAgeRetirementReemploymentJointAuthorizeId;
    }
}