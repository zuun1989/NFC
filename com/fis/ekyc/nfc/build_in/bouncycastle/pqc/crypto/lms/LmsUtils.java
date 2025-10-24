package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;

class LmsUtils {
    public static void byteArray(byte[] bArr, Digest digest) {
        digest.update(bArr, 0, bArr.length);
    }

    public static int calculateStrength(LMSParameters lMSParameters) {
        if (lMSParameters != null) {
            LMSigParameters lMSigParam = lMSParameters.getLMSigParam();
            return (1 << lMSigParam.getH()) * lMSigParam.getM();
        }
        throw new NullPointerException("lmsParameters cannot be null");
    }

    public static void u16str(short s, Digest digest) {
        digest.update((byte) (s >>> 8));
        digest.update((byte) s);
    }

    public static void u32str(int i, Digest digest) {
        digest.update((byte) (i >>> 24));
        digest.update((byte) (i >>> 16));
        digest.update((byte) (i >>> 8));
        digest.update((byte) i);
    }

    public static void byteArray(byte[] bArr, int i, int i2, Digest digest) {
        digest.update(bArr, i, i2);
    }
}
