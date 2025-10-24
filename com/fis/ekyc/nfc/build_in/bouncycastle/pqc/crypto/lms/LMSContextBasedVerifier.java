package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

public interface LMSContextBasedVerifier {
    LMSContext generateLMSContext(byte[] bArr);

    boolean verify(LMSContext lMSContext);
}
