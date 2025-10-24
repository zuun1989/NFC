package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

public interface LMSContextBasedSigner {
    LMSContext generateLMSContext();

    byte[] generateSignature(LMSContext lMSContext);

    long getUsagesRemaining();
}
