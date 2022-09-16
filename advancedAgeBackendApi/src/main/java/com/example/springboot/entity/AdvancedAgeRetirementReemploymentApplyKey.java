package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentApplyKey implements Serializable {
    private String seq;

    private String applyYear;

    private static final long serialVersionUID = 1L;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getApplyYear() {
        return applyYear;
    }

    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear == null ? null : applyYear.trim();
    }
}