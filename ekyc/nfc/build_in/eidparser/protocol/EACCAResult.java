package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class EACCAResult implements Serializable {
    private static final long serialVersionUID = 4431711176589761513L;
    private byte[] keyHash;
    private BigInteger keyId;
    private PrivateKey pcdPrivateKey;
    private PublicKey pcdPublicKey;
    private PublicKey piccPublicKey;
    private SecureMessagingWrapper wrapper;

    public EACCAResult(BigInteger bigInteger, PublicKey publicKey, byte[] bArr, PublicKey publicKey2, PrivateKey privateKey, SecureMessagingWrapper secureMessagingWrapper) {
        this.keyId = bigInteger;
        this.piccPublicKey = publicKey;
        this.keyHash = bArr;
        this.pcdPublicKey = publicKey2;
        this.pcdPrivateKey = privateKey;
        this.wrapper = secureMessagingWrapper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EACCAResult eACCAResult = (EACCAResult) obj;
        if (!Arrays.equals(this.keyHash, eACCAResult.keyHash)) {
            return false;
        }
        BigInteger bigInteger = this.keyId;
        if (bigInteger == null) {
            if (eACCAResult.keyId != null) {
                return false;
            }
        } else if (!bigInteger.equals(eACCAResult.keyId)) {
            return false;
        }
        PrivateKey privateKey = this.pcdPrivateKey;
        if (privateKey == null) {
            if (eACCAResult.pcdPrivateKey != null) {
                return false;
            }
        } else if (!privateKey.equals(eACCAResult.pcdPrivateKey)) {
            return false;
        }
        PublicKey publicKey = this.pcdPublicKey;
        if (publicKey == null) {
            if (eACCAResult.pcdPublicKey != null) {
                return false;
            }
        } else if (!publicKey.equals(eACCAResult.pcdPublicKey)) {
            return false;
        }
        PublicKey publicKey2 = this.piccPublicKey;
        if (publicKey2 == null) {
            if (eACCAResult.piccPublicKey != null) {
                return false;
            }
        } else if (!publicKey2.equals(eACCAResult.piccPublicKey)) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper == null) {
            if (eACCAResult.wrapper != null) {
                return false;
            }
        } else if (!secureMessagingWrapper.equals(eACCAResult.wrapper)) {
            return false;
        }
        return true;
    }

    public byte[] getKeyHash() {
        return this.keyHash;
    }

    public BigInteger getKeyId() {
        return this.keyId;
    }

    public PrivateKey getPCDPrivateKey() {
        return this.pcdPrivateKey;
    }

    public PublicKey getPCDPublicKey() {
        return this.pcdPublicKey;
    }

    public PublicKey getPublicKey() {
        return this.piccPublicKey;
    }

    public SecureMessagingWrapper getWrapper() {
        return this.wrapper;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int hashCode = (Arrays.hashCode(this.keyHash) + 31) * 31;
        BigInteger bigInteger = this.keyId;
        int i5 = 0;
        if (bigInteger == null) {
            i = 0;
        } else {
            i = bigInteger.hashCode();
        }
        int i6 = (hashCode + i) * 31;
        PublicKey publicKey = this.piccPublicKey;
        if (publicKey == null) {
            i2 = 0;
        } else {
            i2 = publicKey.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        PublicKey publicKey2 = this.pcdPublicKey;
        if (publicKey2 == null) {
            i3 = 0;
        } else {
            i3 = publicKey2.hashCode();
        }
        int i8 = (i7 + i3) * 31;
        PrivateKey privateKey = this.pcdPrivateKey;
        if (privateKey == null) {
            i4 = 0;
        } else {
            i4 = privateKey.hashCode();
        }
        int i9 = (i8 + i4) * 31;
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper != null) {
            i5 = secureMessagingWrapper.hashCode();
        }
        return i9 + i5;
    }

    public String toString() {
        return "EACCAResult [keyId: " + this.keyId + ", PICC public key: " + this.piccPublicKey + ", wrapper: " + this.wrapper + ", key hash: " + Hex.bytesToHexString(this.keyHash) + ", PCD public key: " + Util.getDetailedPublicKeyAlgorithm(this.pcdPublicKey) + ", PCD private key: " + Util.getDetailedPrivateKeyAlgorithm(this.pcdPrivateKey) + "]";
    }
}
