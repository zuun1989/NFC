package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface RawAgreement {
    void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i);

    int getAgreementSize();

    void init(CipherParameters cipherParameters);
}
