package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class FunctionPermission implements Serializable {
    private Integer jurisdiction;

    private Integer id;

    private String functionCode;

    private String functionCode2;

    private String functionCode3;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionCode2() {
        return functionCode2;
    }

    public void setFunctionCode2(String functionCode2) {
        this.functionCode2 = functionCode2 == null ? null : functionCode2.trim();
    }

    public String getFunctionCode3() {
        return functionCode3;
    }

    public void setFunctionCode3(String functionCode3) {
        this.functionCode3 = functionCode3 == null ? null : functionCode3.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}