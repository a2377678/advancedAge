package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeRetirementReemploymentReceiptKey implements Serializable {
    private String approveYear;

    private String seq;

    private static final long serialVersionUID = 1L;

    public String getApproveYear() {
        return approveYear;
    }

    public void setApproveYear(String approveYear) {
        this.approveYear = approveYear == null ? null : approveYear.trim();
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }
}