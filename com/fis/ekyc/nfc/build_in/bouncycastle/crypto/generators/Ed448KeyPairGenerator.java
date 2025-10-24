package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import java.security.SecureRandom;

public class Ed448KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public AsymmetricCipherKeyPair generateKeyPair() {
        Ed448PrivateKeyParameters ed448PrivateKeyParameters = new Ed448PrivateKeyParameters(this.random);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) ed448PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) ed448PrivateKeyParameters);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
    }
}
