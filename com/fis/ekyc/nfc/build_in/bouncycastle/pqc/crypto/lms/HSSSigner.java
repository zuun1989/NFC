package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.MessageSigner;
import java.io.IOException;

public class HSSSigner implements MessageSigner {
    private HSSPrivateKeyParameters privKey;
    private HSSPublicKeyParameters pubKey;

    public byte[] generateSignature(byte[] bArr) {
        try {
            return HSS.generateSignature(this.privKey, bArr).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage());
        }
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.privKey = (HSSPrivateKeyParameters) cipherParameters;
        } else {
            this.pubKey = (HSSPublicKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        try {
            HSSPublicKeyParameters hSSPublicKeyParameters = this.pubKey;
            return HSS.verifySignature(hSSPublicKeyParameters, HSSSignature.getInstance(bArr2, hSSPublicKeyParameters.getL()), bArr);
        } catch (IOException e) {
            throw new IllegalStateException("unable to decode signature: " + e.getMessage());
        }
    }
}
