package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.eidparser.protocol.PACEProtocol;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class PACEKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -7113246293247012560L;
    private byte[] key;
    private byte keyReference;

    public PACEKeySpec(String str, byte b) {
        this(Util.getBytes(str), b);
    }

    public static PACEKeySpec createCANKey(String str) {
        return new PACEKeySpec(str, (byte) 2);
    }

    public static PACEKeySpec createMRZKey(BACKeySpec bACKeySpec) throws GeneralSecurityException {
        return new PACEKeySpec(PACEProtocol.computeKeySeedForPACE((AccessKeySpec) bACKeySpec), (byte) 1);
    }

    public static PACEKeySpec createPINKey(String str) {
        return new PACEKeySpec(str, (byte) 3);
    }

    public static PACEKeySpec createPUKKey(String str) {
        return new PACEKeySpec(str, (byte) 4);
    }

    private static String keyReferenceToString(byte b) {
        if (b == 0) {
            return "NO";
        }
        if (b == 1) {
            return "MRZ";
        }
        if (b == 2) {
            return "CAN";
        }
        if (b == 3) {
            return "PIN";
        }
        if (b != 4) {
            return Integer.toString(b);
        }
        return "PUK";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEKeySpec pACEKeySpec = (PACEKeySpec) obj;
        if (Arrays.equals(this.key, pACEKeySpec.key) && this.keyReference == pACEKeySpec.keyReference) {
            return true;
        }
        return false;
    }

    public String getAlgorithm() {
        return "PACE";
    }

    public byte[] getKey() {
        return this.key;
    }

    public byte getKeyReference() {
        return this.keyReference;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.key) + 31) * 31) + this.keyReference;
    }

    public String toString() {
        return "PACEKeySpec [key: " + Hex.bytesToHexString(this.key) + ", keyReference: " + keyReferenceToString(this.keyReference) + "]";
    }

    public PACEKeySpec(byte[] bArr, byte b) {
        this.keyReference = b;
        this.key = bArr;
    }
}
