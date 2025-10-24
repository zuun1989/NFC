package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng;

public interface EntropySourceProvider {
    EntropySource get(int i);
}
