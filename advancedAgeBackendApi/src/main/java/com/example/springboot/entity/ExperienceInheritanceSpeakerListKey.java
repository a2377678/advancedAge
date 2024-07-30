package com.example.springboot.entity;

import java.io.Serializable;

public class ExperienceInheritanceSpeakerListKey implements Serializable {
    private String identification;

    private Integer retirementAdvancedAgeExperienceInheritancePlanId;

    private static final long serialVersionUID = 1L;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getRetirementAdvancedAgeExperienceInheritancePlanId() {
        return retirementAdvancedAgeExperienceInheritancePlanId;
    }

    public void setRetirementAdvancedAgeExperienceInheritancePlanId(Integer retirementAdvancedAgeExperienceInheritancePlanId) {
        this.retirementAdvancedAgeExperienceInheritancePlanId = retirementAdvancedAgeExperienceInheritancePlanId;
    }
}