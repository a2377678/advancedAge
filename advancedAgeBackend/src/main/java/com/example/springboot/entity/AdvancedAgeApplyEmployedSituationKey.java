package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeApplyEmployedSituationKey implements Serializable {
    private String identification;

    private Integer advancedAgePlanId;

    private static final long serialVersionUID = 1L;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getAdvancedAgePlanId() {
        return advancedAgePlanId;
    }

    public void setAdvancedAgePlanId(Integer advancedAgePlanId) {
        this.advancedAgePlanId = advancedAgePlanId;
    }
}