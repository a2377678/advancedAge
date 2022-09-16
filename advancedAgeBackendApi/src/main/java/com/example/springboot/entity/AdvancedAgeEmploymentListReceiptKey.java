package com.example.springboot.entity;

import java.io.Serializable;

public class AdvancedAgeEmploymentListReceiptKey implements Serializable {
    private String seq;

    private String identification;

    private Integer frequency;

    private Integer advancedAgeBaseId;

    private static final long serialVersionUID = 1L;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getAdvancedAgeBaseId() {
        return advancedAgeBaseId;
    }

    public void setAdvancedAgeBaseId(Integer advancedAgeBaseId) {
        this.advancedAgeBaseId = advancedAgeBaseId;
    }
}