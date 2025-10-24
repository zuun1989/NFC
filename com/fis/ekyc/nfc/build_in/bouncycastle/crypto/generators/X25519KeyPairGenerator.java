package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import java.security.SecureRandom;

public class X25519KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public AsymmetricCipherKeyPair generateKeyPair() {
        X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x25519PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x25519PrivateKeyParameters);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
    }
}
