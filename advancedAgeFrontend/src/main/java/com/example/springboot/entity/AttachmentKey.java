package com.example.springboot.entity;

import java.io.Serializable;

public class AttachmentKey implements Serializable {
    private String fileName;

    private String fileBelong;

    private Integer fileBelongId;

    private String fileType;

    private Integer fileFrequency;

    private static final long serialVersionUID = 1L;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileBelong() {
        return fileBelong;
    }

    public void setFileBelong(String fileBelong) {
        this.fileBelong = fileBelong == null ? null : fileBelong.trim();
    }

    public Integer getFileBelongId() {
        return fileBelongId;
    }

    public void setFileBelongId(Integer fileBelongId) {
        this.fileBelongId = fileBelongId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Integer getFileFrequency() {
        return fileFrequency;
    }

    public void setFileFrequency(Integer fileFrequency) {
        this.fileFrequency = fileFrequency;
    }
}