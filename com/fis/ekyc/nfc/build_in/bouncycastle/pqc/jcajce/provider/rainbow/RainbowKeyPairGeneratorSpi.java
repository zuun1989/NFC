package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.RainbowParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator {
    RainbowKeyPairGenerator engine = new RainbowKeyPairGenerator();
    boolean initialised = false;
    RainbowKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    int strength = 1024;

    public RainbowKeyPairGeneratorSpi() {
        super("Rainbow");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            RainbowKeyGenerationParameters rainbowKeyGenerationParameters = new RainbowKeyGenerationParameters(this.random, new RainbowParameters(new RainbowParameterSpec().getVi()));
            this.param = rainbowKeyGenerationParameters;
            this.engine.init(rainbowKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCRainbowPublicKey((RainbowPublicKeyParameters) generateKeyPair.getPublic()), new BCRainbowPrivateKey((RainbowPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof RainbowParameterSpec) {
            RainbowKeyGenerationParameters rainbowKeyGenerationParameters = new RainbowKeyGenerationParameters(secureRandom, new RainbowParameters(((RainbowParameterSpec) algorithmParameterSpec).getVi()));
            this.param = rainbowKeyGenerationParameters;
            this.engine.init(rainbowKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
    }
}
