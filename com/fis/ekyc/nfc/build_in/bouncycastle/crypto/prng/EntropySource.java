package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.prng;

public interface EntropySource {
    int entropySize();

    byte[] getEntropy();

    boolean isPredictionResistant();
}
