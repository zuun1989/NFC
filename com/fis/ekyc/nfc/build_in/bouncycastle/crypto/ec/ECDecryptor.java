package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;

public interface ECDecryptor {
    ECPoint decrypt(ECPair eCPair);

    void init(CipherParameters cipherParameters);
}
