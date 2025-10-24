package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSequence;
import java.util.logging.Logger;

public class TerminalAuthenticationInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.lds");
    public static final int VERSION_1 = 1;
    private static final int VERSION_2 = 2;
    private static final long serialVersionUID = 6220506985707094044L;
    private transient ASN1Sequence efCVCA;
    private String oid;
    private int version;

    public TerminalAuthenticationInfo(String str, int i, ASN1Sequence aSN1Sequence) {
        this.oid = str;
        this.version = i;
        this.efCVCA = aSN1Sequence;
        checkFields();
    }

    private void checkFields() {
        try {
            if (checkRequiredIdentifier(this.oid)) {
                int i = this.version;
                if (!(i == 1 || i == 2)) {
                    Logger logger = LOGGER;
                    logger.warning("Wrong version. Was expecting 1 or 2, found " + this.version);
                }
                ASN1Sequence aSN1Sequence = this.efCVCA;
                if (aSN1Sequence == null) {
                    return;
                }
                if (((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets().length != 2) {
                    throw new IllegalArgumentException("Malformed FID.");
                } else if (this.efCVCA.size() != 2) {
                } else {
                    if (((ASN1OctetString) this.efCVCA.getObjectAt(1)).getOctets().length != 1) {
                        throw new IllegalArgumentException("Malformed SFI.");
                    }
                }
            } else {
                throw new IllegalArgumentException("Wrong identifier: " + this.oid);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Malformed TerminalAuthenticationInfo", e);
        }
    }

    public static boolean checkRequiredIdentifier(String str) {
        return SecurityInfo.ID_TA.equals(str);
    }

    private static ASN1Sequence constructEFCVCA(short s, byte b) {
        if (b != -1) {
            return new DLSequence(new ASN1Encodable[]{new DEROctetString(new byte[]{(byte) ((65280 & s) >> 8), (byte) (s & 255)}), new DEROctetString(new byte[]{(byte) (b & 255)})});
        }
        return new DLSequence(new ASN1Encodable[]{new DEROctetString(new byte[]{(byte) ((65280 & s) >> 8), (byte) (s & 255)})});
    }

    private static short getFID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            return -1;
        }
        byte[] octets = ((ASN1OctetString) aSN1Sequence.getObjectAt(0)).getOctets();
        return (short) ((octets[1] & 255) | ((octets[0] & 255) << 8));
    }

    private static byte getSFI(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence != null && aSN1Sequence.size() == 2) {
            return ((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets()[0];
        }
        return -1;
    }

    private String toProtocolOIDString(String str) {
        if (SecurityInfo.ID_TA.equals(str)) {
            return "id-TA";
        }
        if (SecurityInfo.ID_TA_RSA.equals(str)) {
            return "id-TA-RSA";
        }
        if (SecurityInfo.ID_TA_RSA_V1_5_SHA_1.equals(str)) {
            return "id-TA-RSA-v1-5-SHA-1";
        }
        if (SecurityInfo.ID_TA_RSA_V1_5_SHA_256.equals(str)) {
            return "id-TA-RSA-v1-5-SHA-256";
        }
        if (SecurityInfo.ID_TA_RSA_PSS_SHA_1.equals(str)) {
            return "id-TA-RSA-PSS-SHA-1";
        }
        if (SecurityInfo.ID_TA_RSA_PSS_SHA_256.equals(str)) {
            return "id-TA-RSA-PSS-SHA-256";
        }
        if (SecurityInfo.ID_TA_ECDSA.equals(str)) {
            return "id-TA-ECDSA";
        }
        if (SecurityInfo.ID_TA_ECDSA_SHA_1.equals(str)) {
            return "id-TA-ECDSA-SHA-1";
        }
        if (SecurityInfo.ID_TA_ECDSA_SHA_224.equals(str)) {
            return "id-TA-ECDSA-SHA-224";
        }
        if (SecurityInfo.ID_TA_ECDSA_SHA_256.equals(str)) {
            return "id-TA-ECDSA-SHA-256";
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!TerminalAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        TerminalAuthenticationInfo terminalAuthenticationInfo = (TerminalAuthenticationInfo) obj;
        ASN1Sequence aSN1Sequence = this.efCVCA;
        if (aSN1Sequence == null && terminalAuthenticationInfo.efCVCA != null) {
            return false;
        }
        if (aSN1Sequence == null || terminalAuthenticationInfo.efCVCA != null) {
            return getDERObject().equals(terminalAuthenticationInfo.getDERObject());
        }
        return false;
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        ASN1Sequence aSN1Sequence = this.efCVCA;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public int getFileId() {
        return getFID(this.efCVCA);
    }

    public String getObjectIdentifier() {
        return this.oid;
    }

    public String getProtocolOIDString() {
        return toProtocolOIDString(this.oid);
    }

    public byte getShortFileId() {
        return getSFI(this.efCVCA);
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
        int i3 = (i * 7) + 123 + (this.version * 5);
        ASN1Sequence aSN1Sequence = this.efCVCA;
        if (aSN1Sequence == null) {
            i2 = 1;
        } else {
            i2 = aSN1Sequence.hashCode();
        }
        return i3 + (i2 * 3);
    }

    public String toString() {
        return "TerminalAuthenticationInfo [protocol: " + toProtocolOIDString(this.oid) + ", version: " + this.version + ", fileID: " + getFileId() + ", shortFileID: " + getShortFileId() + "]";
    }

    public TerminalAuthenticationInfo(String str, int i) {
        this(str, i, (ASN1Sequence) null);
    }

    public TerminalAuthenticationInfo() {
        this(SecurityInfo.ID_TA, 1);
    }

    public TerminalAuthenticationInfo(short s, byte b) {
        this(SecurityInfo.ID_TA, 1, constructEFCVCA(s, b));
    }
}
