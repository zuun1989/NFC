package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.io.Serializable;
import java.security.PublicKey;
import java.util.Arrays;

public class AAResult implements Serializable {
    private static final long serialVersionUID = 8800803919646625713L;
    private byte[] challenge;
    private String digestAlgorithm;
    private PublicKey publicKey;
    private byte[] response;
    private String signatureAlgorithm;

    public AAResult(PublicKey publicKey2, String str, String str2, byte[] bArr, byte[] bArr2) {
        this.publicKey = publicKey2;
        this.digestAlgorithm = str;
        this.signatureAlgorithm = str2;
        this.challenge = bArr;
        this.response = bArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AAResult aAResult = (AAResult) obj;
        if (!Arrays.equals(this.challenge, aAResult.challenge)) {
            return false;
        }
        String str = this.digestAlgorithm;
        if (str == null) {
            if (aAResult.digestAlgorithm != null) {
                return false;
            }
        } else if (!str.equals(aAResult.digestAlgorithm)) {
            return false;
        }
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 == null) {
            if (aAResult.publicKey != null) {
                return false;
            }
        } else if (!publicKey2.equals(aAResult.publicKey)) {
            return false;
        }
        if (!Arrays.equals(this.response, aAResult.response)) {
            return false;
        }
        String str2 = this.signatureAlgorithm;
        if (str2 == null) {
            if (aAResult.signatureAlgorithm != null) {
                return false;
            }
        } else if (!str2.equals(aAResult.signatureAlgorithm)) {
            return false;
        }
        return true;
    }

    public byte[] getChallenge() {
        return this.challenge;
    }

    public String getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public byte[] getResponse() {
        return this.response;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public int hashCode() {
        int i;
        int i2;
        int hashCode = (1303377669 + Arrays.hashCode(this.challenge)) * 1991;
        String str = this.digestAlgorithm;
        int i3 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i4 = (hashCode + i) * 1991;
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 == null) {
            i2 = 0;
        } else {
            i2 = publicKey2.hashCode();
        }
        int hashCode2 = (((i4 + i2) * 1991) + Arrays.hashCode(this.response)) * 1991;
        String str2 = this.signatureAlgorithm;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "AAResult [publicKey: " + Util.getDetailedPublicKeyAlgorithm(this.publicKey) + ", digestAlgorithm: " + this.digestAlgorithm + ", signatureAlgorithm: " + this.signatureAlgorithm + ", challenge: " + Hex.bytesToHexString(this.challenge) + ", response: " + Hex.bytesToHexString(this.response);
    }
}
