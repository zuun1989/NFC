package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;

public interface MessageSigner {
    byte[] generateSignature(byte[] bArr);

    void init(boolean z, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, byte[] bArr2);
}
