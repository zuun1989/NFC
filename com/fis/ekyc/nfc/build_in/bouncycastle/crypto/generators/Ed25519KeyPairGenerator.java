package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import java.security.SecureRandom;

public class Ed25519KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public AsymmetricCipherKeyPair generateKeyPair() {
        Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = new Ed25519PrivateKeyParameters(this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) ed25519PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) ed25519PrivateKeyParameters);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
    }
}
