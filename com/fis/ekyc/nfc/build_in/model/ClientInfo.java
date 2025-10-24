package com.fis.ekyc.nfc.build_in.model;

public class ClientInfo {
    private String deviceName;
    private String deviceType = "";
    private int mSdkVersionCode;
    private String mSdkVersionName;
    private String osName = "";

    public ClientInfo(String str, String str2, int i) {
        this.deviceName = str;
        this.mSdkVersionName = str2;
        this.mSdkVersionCode = i;
    }

    public byte[] getData() {
        return null;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getOsName() {
        return this.osName;
    }

    public int getSdkVersionCode() {
        return this.mSdkVersionCode;
    }

    public String getSdkVersionName() {
        return this.mSdkVersionName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setSdkVersionCode(int i) {
        this.mSdkVersionCode = i;
    }

    public void setSdkVersionName(String str) {
        this.mSdkVersionName = str;
    }
}
