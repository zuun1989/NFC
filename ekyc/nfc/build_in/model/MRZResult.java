package com.fis.ekyc.nfc.build_in.model;

public class MRZResult {
    private String cccdId = "";
    private String expireDate = "";
    private String imageBase64 = "";
    private String issueDate = "";

    public String getCccdId() {
        return this.cccdId;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public String getImageBase64() {
        return this.imageBase64;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public void setCccdId(String str) {
        this.cccdId = str;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public void setImageBase64(String str) {
        this.imageBase64 = str;
    }

    public void setIssueDate(String str) {
        this.issueDate = str;
    }
}
