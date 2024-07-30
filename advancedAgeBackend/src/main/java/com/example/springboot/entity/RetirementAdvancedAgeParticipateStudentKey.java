package com.example.springboot.entity;

import java.io.Serializable;

public class RetirementAdvancedAgeParticipateStudentKey implements Serializable {
    private String name;

    private Integer seniority;

    private Integer retirementAdvancedAgeExperienceInheritanceApplyId;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public Integer getRetirementAdvancedAgeExperienceInheritanceApplyId() {
        return retirementAdvancedAgeExperienceInheritanceApplyId;
    }

    public void setRetirementAdvancedAgeExperienceInheritanceApplyId(Integer retirementAdvancedAgeExperienceInheritanceApplyId) {
        this.retirementAdvancedAgeExperienceInheritanceApplyId = retirementAdvancedAgeExperienceInheritanceApplyId;
    }
}