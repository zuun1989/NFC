package com.fis.ekyc.nfc.build_in.model;

public class QRCodeResult {
    private String address = "";
    private String birthDate = "";
    private String cccdId = "";
    private String gender = "";
    private String imageBase64 = "";
    private String issueDate = "";
    private String name = "";

    public String getAddress() {
        return this.address;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getCccdId() {
        return this.cccdId;
    }

    public String getGender() {
        return this.gender;
    }

    public String getImageBase64() {
        return this.imageBase64;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBirthDate(String str) {
        this.birthDate = str;
    }

    public void setCccdId(String str) {
        this.cccdId = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setImageBase64(String str) {
        this.imageBase64 = str;
    }

    public void setIssueDate(String str) {
        this.issueDate = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
