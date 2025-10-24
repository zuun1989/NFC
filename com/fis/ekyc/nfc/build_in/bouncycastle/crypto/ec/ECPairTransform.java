package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;

public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    ECPair transform(ECPair eCPair);
}
