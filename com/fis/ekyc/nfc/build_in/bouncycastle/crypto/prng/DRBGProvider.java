package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng.drbg.SP80090DRBG;

interface DRBGProvider {
    SP80090DRBG get(EntropySource entropySource);

    String getAlgorithm();
}
