package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.EphemeralKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyEncoder;

public class EphemeralKeyPairGenerator {
    private AsymmetricCipherKeyPairGenerator gen;
    private KeyEncoder keyEncoder;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator, KeyEncoder keyEncoder2) {
        this.gen = asymmetricCipherKeyPairGenerator;
        this.keyEncoder = keyEncoder2;
    }

    public EphemeralKeyPair generate() {
        return new EphemeralKeyPair(this.gen.generateKeyPair(), this.keyEncoder);
    }
}
