package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeExperienceInheritanceSpeakerFeeListKey implements Serializable {
    private String identification;

    private Integer retirementAdvancedAgeExperienceInheritanceResultId;

    private static final long serialVersionUID = 1L;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getRetirementAdvancedAgeExperienceInheritanceResultId() {
        return retirementAdvancedAgeExperienceInheritanceResultId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceResultId(Integer retirementAdvancedAgeExperienceInheritanceResultId) {
        this.retirementAdvancedAgeExperienceInheritanceResultId = retirementAdvancedAgeExperienceInheritanceResultId;
    }
}