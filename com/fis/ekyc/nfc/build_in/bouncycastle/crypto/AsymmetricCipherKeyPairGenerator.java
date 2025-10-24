package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface AsymmetricCipherKeyPairGenerator {
    AsymmetricCipherKeyPair generateKeyPair();

    void init(KeyGenerationParameters keyGenerationParameters);
}
