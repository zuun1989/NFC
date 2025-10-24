package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChipAuthenticationInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    public static final int VERSION_1 = 1;
    public static final int VERSION_2 = 2;
    private static final long serialVersionUID = 5591988305059068535L;
    private BigInteger keyId;
    private String oid;
    private int version;

    public ChipAuthenticationInfo(String str, int i) {
        this(str, i, (BigInteger) null);
    }

    public static boolean checkRequiredIdentifier(String str) {
        if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
            return true;
        }
        return false;
    }

    public static String toCipherAlgorithm(String str) {
        if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str)) {
            return "DESede";
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
            return "AES";
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static String toDigestAlgorithm(String str) {
        if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str)) {
            return McElieceCCA2KeyGenParameterSpec.SHA1;
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
            return "SHA-256";
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static String toKeyAgreementAlgorithm(String str) {
        if (str == null) {
            throw new NumberFormatException("Unknown OID: null");
        } else if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str)) {
            return "DH";
        } else {
            if (SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
                return "ECDH";
            }
            throw new NumberFormatException("Unknown OID: \"" + str + "\"");
        }
    }

    public static int toKeyLength(String str) {
        if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str)) {
            return 128;
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str)) {
            return CertificateHolderAuthorization.CVCA;
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
            return 256;
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    private static String toProtocolOIDString(String str) {
        if (SecurityInfo.ID_CA_DH_3DES_CBC_CBC.equals(str)) {
            return "id-CA-DH-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_128.equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_192.equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_CA_DH_AES_CBC_CMAC_256.equals(str)) {
            return "id-CA-DH-AES-CBC-CMAC-256";
        }
        if (SecurityInfo.ID_CA_ECDH_3DES_CBC_CBC.equals(str)) {
            return "id-CA-ECDH-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_128.equals(str)) {
            return "id-CA-ECDH-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_192.equals(str)) {
            return "id-CA-ECDH-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256.equals(str)) {
            return "id-CA-ECDH-AES-CBC-CMAC-256";
        }
        return str;
    }

    public void checkFields() {
        try {
            if (checkRequiredIdentifier(this.oid)) {
                int i = this.version;
                if (i != 1 && i != 2) {
                    Logger logger = LOGGER;
                    logger.warning("Wrong version. Was expecting 1 or 2, found " + this.version);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Wrong identifier: " + this.oid);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Unexpected exception", e);
            throw new IllegalArgumentException("Malformed ChipAuthenticationInfo.");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ChipAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        ChipAuthenticationInfo chipAuthenticationInfo = (ChipAuthenticationInfo) obj;
        if (!this.oid.equals(chipAuthenticationInfo.oid) || this.version != chipAuthenticationInfo.version) {
            return false;
        }
        BigInteger bigInteger = this.keyId;
        if ((bigInteger != null || chipAuthenticationInfo.keyId != null) && (bigInteger == null || !bigInteger.equals(chipAuthenticationInfo.keyId))) {
            return false;
        }
        return true;
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        BigInteger bigInteger = this.keyId;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
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

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i;
        int i2;
        String str = this.oid;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i * 11) + 3 + (this.version * 61);
        BigInteger bigInteger = this.keyId;
        if (bigInteger == null) {
            i2 = LDSFile.EF_DG15_TAG;
        } else {
            i2 = bigInteger.hashCode();
        }
        return i3 + (i2 * 1991);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChipAuthenticationInfo [protocol: ");
        sb2.append(toProtocolOIDString(this.oid));
        sb2.append(", version: ");
        sb2.append(this.version);
        sb2.append(", keyId: ");
        Object obj = this.keyId;
        if (obj == null) {
            obj = "-";
        }
        sb2.append(obj);
        sb2.append("]");
        return sb2.toString();
    }

    public ChipAuthenticationInfo(String str, int i, BigInteger bigInteger) {
        this.oid = str;
        this.version = i;
        this.keyId = bigInteger;
        checkFields();
    }
}
