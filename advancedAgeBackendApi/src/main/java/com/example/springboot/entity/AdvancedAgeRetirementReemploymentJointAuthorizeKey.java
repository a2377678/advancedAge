package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentJointAuthorizeKey implements Serializable {
    private String seq;

    private Integer advancedAgeRetirementReemploymentApplyId;

    private static final long serialVersionUID = 1L;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public Integer getAdvancedAgeRetirementReemploymentApplyId() {
        return advancedAgeRetirementReemploymentApplyId;
    }

    public void setAdvancedAgeRetirementReemploymentApplyId(Integer advancedAgeRetirementReemploymentApplyId) {
        this.advancedAgeRetirementReemploymentApplyId = advancedAgeRetirementReemploymentApplyId;
    }
}