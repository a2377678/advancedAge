package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentBenefitListKey implements Serializable {
    private String identification;

    private Integer advancedAgeRetirementReemploymentPlanId;

    private static final long serialVersionUID = 1L;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getAdvancedAgeRetirementReemploymentPlanId() {
        return advancedAgeRetirementReemploymentPlanId;
    }

    public void setAdvancedAgeRetirementReemploymentPlanId(Integer advancedAgeRetirementReemploymentPlanId) {
        this.advancedAgeRetirementReemploymentPlanId = advancedAgeRetirementReemploymentPlanId;
    }
}