package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import java.math.BigInteger;

public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters cipherParameters);

    int getFieldSize();

    void init(CipherParameters cipherParameters);
}
