package com.fis.ekyc.nfc.build_in.eidparser;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class IDCardDetail {
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("chipAuth")
    @Expose
    private boolean chipAuth = false;
    @SerializedName("chipAuthMessage")
    @Expose
    private String chipAuthMessage = "";
    @SerializedName("citizenPid")
    @Expose
    private String citizenPid;
    @SerializedName("cscaAuth")
    @Expose
    private boolean cscaAuth = false;
    @SerializedName("cscaAuthMessage")
    @Expose
    private String cscaAuthMessage = "";
    @SerializedName("dateProvide")
    @Expose
    private String dateProvide;
    @SerializedName("ethnic")
    @Expose
    private String ethnic;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("hash_check")
    @Expose
    private boolean hash_check = false;
    @SerializedName("homeTown")
    @Expose
    private String homeTown;
    @SerializedName("husBandName")
    @Expose
    private String husBandName;
    @SerializedName("identifyCharacteristics")
    @Expose
    private String identifyCharacteristics;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("oldIdentify")
    @Expose
    private String oldIdentify;
    @SerializedName("outOfDate")
    @Expose
    private String outOfDate;
    @SerializedName("photoBase64")
    @Expose
    private String photoBase64;
    @SerializedName("regPlaceAddress")
    @Expose
    private String regPlaceAddress;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("sodBase64")
    @Expose
    private String sodBase64 = "";
    @SerializedName("wifeName")
    @Expose
    private String wifeName;

    public final String getBirthDate() {
        return this.birthDate;
    }

    public final boolean getChipAuth() {
        return this.chipAuth;
    }

    public final String getChipAuthMessage() {
        return this.chipAuthMessage;
    }

    public final String getCitizenPid() {
        return this.citizenPid;
    }

    public final boolean getCscaAuth() {
        return this.cscaAuth;
    }

    public final String getCscaAuthMessage() {
        return this.cscaAuthMessage;
    }

    public final String getDateProvide() {
        return this.dateProvide;
    }

    public final String getEthnic() {
        return this.ethnic;
    }

    public final String getFatherName() {
        return this.fatherName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getHomeTown() {
        return this.homeTown;
    }

    public final String getHusBandName() {
        return this.husBandName;
    }

    public final String getIdentifyCharacteristics() {
        return this.identifyCharacteristics;
    }

    public final String getMotherName() {
        return this.motherName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getOldIdentify() {
        return this.oldIdentify;
    }

    public final String getOutOfDate() {
        return this.outOfDate;
    }

    public final String getPhotoBase64() {
        return this.photoBase64;
    }

    public final String getRegPlaceAddress() {
        return this.regPlaceAddress;
    }

    public final String getReligion() {
        return this.religion;
    }

    public final String getSodBase64() {
        return this.sodBase64;
    }

    public final String getWifeName() {
        return this.wifeName;
    }

    public boolean isHash_check() {
        return this.hash_check;
    }

    public boolean isValid() {
        String str;
        String str2;
        String str3 = this.citizenPid;
        if (str3 == null || str3.length() != 12 || (str = this.birthDate) == null || str.length() != 10 || (str2 = this.outOfDate) == null || str2.length() != 10) {
            return false;
        }
        return true;
    }

    public final void setBirthDate(String str) {
        this.birthDate = str;
    }

    public final void setChipAuth(boolean z) {
        this.chipAuth = z;
    }

    public final void setChipAuthMessage(String str) {
        this.chipAuthMessage = str;
    }

    public final void setCitizenPid(String str) {
        this.citizenPid = str;
    }

    public final void setCscaAuth(boolean z) {
        this.cscaAuth = z;
    }

    public final void setCscaAuthMessage(String str) {
        this.cscaAuthMessage = str;
    }

    public final void setDateProvide(String str) {
        this.dateProvide = str;
    }

    public final void setEthnic(String str) {
        this.ethnic = str;
    }

    public final void setFatherName(String str) {
        this.fatherName = str;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final void setGender(String str) {
        this.gender = str;
    }

    public void setHash_check(boolean z) {
        this.hash_check = z;
    }

    public final void setHomeTown(String str) {
        this.homeTown = str;
    }

    public final void setHusBandName(String str) {
        this.husBandName = str;
    }

    public final void setIdentifyCharacteristics(String str) {
        this.identifyCharacteristics = str;
    }

    public final void setMotherName(String str) {
        this.motherName = str;
    }

    public final void setNationality(String str) {
        this.nationality = str;
    }

    public final void setOldIdentify(String str) {
        this.oldIdentify = str;
    }

    public final void setOutOfDate(String str) {
        this.outOfDate = str;
    }

    public final void setPhotoBase64(String str) {
        this.photoBase64 = str;
    }

    public final void setRegPlaceAddress(String str) {
        this.regPlaceAddress = str;
    }

    public final void setReligion(String str) {
        this.religion = str;
    }

    public final void setSodBase64(String str) {
        this.sodBase64 = str;
    }

    public final void setWifeName(String str) {
        this.wifeName = str;
    }

    public Map<String, String> toMap() {
        Gson gson = new Gson();
        return (Map) gson.fromJson(gson.toJson(this), new TypeToken<Map<String, String>>() {
        }.getType());
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
