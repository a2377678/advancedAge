package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritanceExpenditureKey implements Serializable {
    private String planName;

    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private static final long serialVersionUID = 1L;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public Integer getRetirementAdvancedAgeExperienceInheritanceApplyId() {
        return retirementAdvancedAgeExperienceInheritanceApplyId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer retirementAdvancedAgeExperienceInheritanceApplyId) {
        this.retirementAdvancedAgeExperienceInheritanceApplyId = retirementAdvancedAgeExperienceInheritanceApplyId;
    }
}