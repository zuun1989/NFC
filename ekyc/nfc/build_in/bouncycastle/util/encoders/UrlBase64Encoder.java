package com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders;

public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr = this.encodingTable;
        bArr[bArr.length - 2] = 45;
        bArr[bArr.length - 1] = 95;
        this.padding = 46;
        initialiseDecodingTable();
    }
}
