package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChipAuthenticationPublicKeyInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = 5687291829854501771L;
    private BigInteger keyId;
    private String oid;
    private PublicKey publicKey;

    public ChipAuthenticationPublicKeyInfo(PublicKey publicKey2) {
        this(publicKey2, (BigInteger) null);
    }

    public static boolean checkRequiredIdentifier(String str) {
        if (SecurityInfo.ID_PK_DH.equals(str) || SecurityInfo.ID_PK_ECDH.equals(str)) {
            return true;
        }
        return false;
    }

    public static String toKeyAgreementAlgorithm(String str) {
        if (str == null) {
            throw new NumberFormatException("Unknown OID: null");
        } else if (SecurityInfo.ID_PK_DH.equals(str)) {
            return "DH";
        } else {
            if (SecurityInfo.ID_PK_ECDH.equals(str)) {
                return "ECDH";
            }
            throw new NumberFormatException("Unknown OID: \"" + str + "\"");
        }
    }

    private static String toProtocolOIDString(String str) {
        if (SecurityInfo.ID_PK_DH.equals(str)) {
            return "id-PK-DH";
        }
        if (SecurityInfo.ID_PK_ECDH.equals(str)) {
            return "id-PK-ECDH";
        }
        return str;
    }

    public void checkFields() {
        try {
            if (!checkRequiredIdentifier(this.oid)) {
                throw new IllegalArgumentException("Wrong identifier: " + this.oid);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Malformed ChipAuthenticationInfo", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ChipAuthenticationPublicKeyInfo.class.equals(obj.getClass())) {
            return false;
        }
        ChipAuthenticationPublicKeyInfo chipAuthenticationPublicKeyInfo = (ChipAuthenticationPublicKeyInfo) obj;
        if (!this.oid.equals(chipAuthenticationPublicKeyInfo.oid)) {
            return false;
        }
        BigInteger bigInteger = this.keyId;
        if (((bigInteger != null || chipAuthenticationPublicKeyInfo.keyId != null) && (bigInteger == null || !bigInteger.equals(chipAuthenticationPublicKeyInfo.keyId))) || !this.publicKey.equals(chipAuthenticationPublicKeyInfo.publicKey)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        SubjectPublicKeyInfo subjectPublicKeyInfo = Util.toSubjectPublicKeyInfo(this.publicKey);
        if (subjectPublicKeyInfo == null) {
            LOGGER.log(Level.WARNING, "Could not convert public key to subject-public-key-info structure");
        } else {
            aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
            aSN1EncodableVector.add(subjectPublicKeyInfo.toASN1Primitive());
            BigInteger bigInteger = this.keyId;
            if (bigInteger != null) {
                aSN1EncodableVector.add(new ASN1Integer(bigInteger));
            }
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public BigInteger getKeyId() {
        return this.keyId;
    }

    public String getObjectIdentifier() {
        return this.oid;
    }

    public String getProtocolOIDString() {
        return toProtocolOIDString(this.oid);
    }

    public PublicKey getSubjectPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int i;
        int hashCode = this.oid.hashCode();
        BigInteger bigInteger = this.keyId;
        int i2 = LDSFile.EF_DG15_TAG;
        if (bigInteger == null) {
            i = 111;
        } else {
            i = bigInteger.hashCode();
        }
        int i3 = hashCode + i;
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            i2 = publicKey2.hashCode();
        }
        return ((i3 + i2) * 1337) + 123;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChipAuthenticationPublicKeyInfo [protocol: ");
        sb2.append(toProtocolOIDString(this.oid));
        sb2.append(", chipAuthenticationPublicKey: ");
        sb2.append(Util.getDetailedPublicKeyAlgorithm(getSubjectPublicKey()));
        sb2.append(", keyId: ");
        BigInteger bigInteger = this.keyId;
        if (bigInteger == null) {
            str = "-";
        } else {
            str = bigInteger.toString();
        }
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    public ChipAuthenticationPublicKeyInfo(PublicKey publicKey2, BigInteger bigInteger) {
        this(Util.inferProtocolIdentifier(publicKey2), publicKey2, bigInteger);
    }

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey2) {
        this(str, publicKey2, (BigInteger) null);
    }

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey2, BigInteger bigInteger) {
        this.oid = str;
        this.publicKey = Util.reconstructPublicKey(publicKey2);
        this.keyId = bigInteger;
        checkFields();
    }
}
