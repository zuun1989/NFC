package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.AccessKeySpec;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.PublicKey;

public class PACEResult implements Serializable {
    private static final long serialVersionUID = -6819675856205885052L;
    private String agreementAlg;
    private String cipherAlg;
    private String digestAlg;
    private int keyLength;
    private PACEMappingResult mappingResult;
    private PACEInfo.MappingType mappingType;
    private AccessKeySpec paceKey;
    private KeyPair pcdKeyPair;
    private PublicKey piccPublicKey;
    private SecureMessagingWrapper wrapper;

    public PACEResult(AccessKeySpec accessKeySpec, PACEInfo.MappingType mappingType2, String str, String str2, String str3, int i, PACEMappingResult pACEMappingResult, KeyPair keyPair, PublicKey publicKey, SecureMessagingWrapper secureMessagingWrapper) {
        this.paceKey = accessKeySpec;
        this.mappingType = mappingType2;
        this.agreementAlg = str;
        this.cipherAlg = str2;
        this.digestAlg = str3;
        this.keyLength = i;
        this.mappingResult = pACEMappingResult;
        this.pcdKeyPair = keyPair;
        this.piccPublicKey = publicKey;
        this.wrapper = secureMessagingWrapper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEResult pACEResult = (PACEResult) obj;
        AccessKeySpec accessKeySpec = this.paceKey;
        if (accessKeySpec == null) {
            if (pACEResult.paceKey != null) {
                return false;
            }
        } else if (!accessKeySpec.equals(pACEResult.paceKey)) {
            return false;
        }
        String str = this.agreementAlg;
        if (str == null) {
            if (pACEResult.agreementAlg != null) {
                return false;
            }
        } else if (!str.equals(pACEResult.agreementAlg)) {
            return false;
        }
        String str2 = this.cipherAlg;
        if (str2 == null) {
            if (pACEResult.cipherAlg != null) {
                return false;
            }
        } else if (!str2.equals(pACEResult.cipherAlg)) {
            return false;
        }
        String str3 = this.digestAlg;
        if (str3 == null) {
            if (pACEResult.digestAlg != null) {
                return false;
            }
        } else if (!str3.equals(pACEResult.digestAlg)) {
            return false;
        }
        PACEMappingResult pACEMappingResult = this.mappingResult;
        if (pACEMappingResult == null) {
            if (pACEResult.mappingResult != null) {
                return false;
            }
        } else if (!pACEMappingResult.equals(pACEResult.mappingResult)) {
            return false;
        }
        if (this.keyLength != pACEResult.keyLength || this.mappingType != pACEResult.mappingType) {
            return false;
        }
        KeyPair keyPair = this.pcdKeyPair;
        if (keyPair == null) {
            if (pACEResult.pcdKeyPair != null) {
                return false;
            }
        } else if (!keyPair.equals(pACEResult.pcdKeyPair)) {
            return false;
        }
        PublicKey publicKey = this.piccPublicKey;
        if (publicKey == null) {
            if (pACEResult.piccPublicKey != null) {
                return false;
            }
        } else if (!publicKey.equals(pACEResult.piccPublicKey)) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper == null) {
            if (pACEResult.wrapper != null) {
                return false;
            }
        } else if (!secureMessagingWrapper.equals(pACEResult.wrapper)) {
            return false;
        }
        return true;
    }

    public String getAgreementAlg() {
        return this.agreementAlg;
    }

    public String getCipherAlg() {
        return this.cipherAlg;
    }

    public String getDigestAlg() {
        return this.digestAlg;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public PACEMappingResult getMappingResult() {
        return this.mappingResult;
    }

    public PACEInfo.MappingType getMappingType() {
        return this.mappingType;
    }

    public AccessKeySpec getPACEKey() {
        return this.paceKey;
    }

    public KeyPair getPCDKeyPair() {
        return this.pcdKeyPair;
    }

    public PublicKey getPICCPublicKey() {
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
        int i5;
        int i6;
        int i7;
        int i8;
        AccessKeySpec accessKeySpec = this.paceKey;
        int i9 = 0;
        if (accessKeySpec == null) {
            i = 0;
        } else {
            i = accessKeySpec.hashCode();
        }
        int i10 = (21901 + i) * 1991;
        String str = this.agreementAlg;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i11 = (i10 + i2) * 1991;
        String str2 = this.cipherAlg;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.hashCode();
        }
        int i12 = (i11 + i3) * 1991;
        String str3 = this.digestAlg;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.hashCode();
        }
        int i13 = (i12 + i4) * 1991;
        PACEMappingResult pACEMappingResult = this.mappingResult;
        if (pACEMappingResult == null) {
            i5 = 0;
        } else {
            i5 = pACEMappingResult.hashCode();
        }
        int i14 = (((i13 + i5) * 1991) + this.keyLength) * 1991;
        PACEInfo.MappingType mappingType2 = this.mappingType;
        if (mappingType2 == null) {
            i6 = 0;
        } else {
            i6 = mappingType2.hashCode();
        }
        int i15 = (i14 + i6) * 1991;
        KeyPair keyPair = this.pcdKeyPair;
        if (keyPair == null) {
            i7 = 0;
        } else {
            i7 = keyPair.hashCode();
        }
        int i16 = (i15 + i7) * 1991;
        PublicKey publicKey = this.piccPublicKey;
        if (publicKey == null) {
            i8 = 0;
        } else {
            i8 = publicKey.hashCode();
        }
        int i17 = (i16 + i8) * 1991;
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper != null) {
            i9 = secureMessagingWrapper.hashCode();
        }
        return i17 + i9;
    }

    public String toString() {
        return "PACEResult [paceKey: " + this.paceKey + ", mappingType: " + this.mappingType + ", agreementAlg: " + this.agreementAlg + ", cipherAlg: " + this.cipherAlg + ", digestAlg: " + this.digestAlg + ", keyLength: " + this.keyLength + ", mappingResult: " + this.mappingResult + ", piccPublicKey: " + Util.getDetailedPublicKeyAlgorithm(this.piccPublicKey) + ", pcdPrivateKey: " + Util.getDetailedPrivateKeyAlgorithm(this.pcdKeyPair.getPrivate()) + ", pcdPublicKey: " + Util.getDetailedPublicKeyAlgorithm(this.pcdKeyPair.getPublic());
    }
}
