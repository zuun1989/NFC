package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters;
import java.security.SecureRandom;

public class X448KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public AsymmetricCipherKeyPair generateKeyPair() {
        X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x448PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x448PrivateKeyParameters);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
    }
}
