package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherKeyGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class BaseKeyGenerator extends KeyGeneratorSpi {
    protected String algName;
    protected int defaultKeySize;
    protected CipherKeyGenerator engine;
    protected int keySize;
    protected boolean uninitialised = true;

    public BaseKeyGenerator(String str, int i, CipherKeyGenerator cipherKeyGenerator) {
        this.algName = str;
        this.defaultKeySize = i;
        this.keySize = i;
        this.engine = cipherKeyGenerator;
    }

    public SecretKey engineGenerateKey() {
        if (this.uninitialised) {
            this.engine.init(new KeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), this.defaultKeySize));
            this.uninitialised = false;
        }
        return new SecretKeySpec(this.engine.generateKey(), this.algName);
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }

    public void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.engine.init(new KeyGenerationParameters(secureRandom, this.defaultKeySize));
            this.uninitialised = false;
        }
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            } catch (IllegalArgumentException e) {
                throw new InvalidParameterException(e.getMessage());
            }
        }
        this.engine.init(new KeyGenerationParameters(secureRandom, i));
        this.uninitialised = false;
    }
}
