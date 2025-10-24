package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;

public interface ECEncryptor {
    ECPair encrypt(ECPoint eCPoint);

    void init(CipherParameters cipherParameters);
}
