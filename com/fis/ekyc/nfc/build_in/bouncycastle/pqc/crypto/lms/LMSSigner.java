package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.MessageSigner;
import java.io.IOException;

public class LMSSigner implements MessageSigner {
    private LMSPrivateKeyParameters privKey;
    private LMSPublicKeyParameters pubKey;

    public byte[] generateSignature(byte[] bArr) {
        try {
            return LMS.generateSign(this.privKey, bArr).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage());
        }
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.privKey = (LMSPrivateKeyParameters) cipherParameters;
        } else {
            this.pubKey = (LMSPublicKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        try {
            return LMS.verifySignature(this.pubKey, LMSSignature.getInstance(bArr2), bArr);
        } catch (IOException e) {
            throw new IllegalStateException("unable to decode signature: " + e.getMessage());
        }
    }
}
