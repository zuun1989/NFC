package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.SpecUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SABERParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class SABERKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;
    SABERKeyPairGenerator engine = new SABERKeyPairGenerator();
    boolean initialised = false;
    SABERKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();

    static {
        HashMap hashMap = new HashMap();
        parameters = hashMap;
        hashMap.put(SABERParameterSpec.lightsaberkem128r3.getName(), SABERParameters.lightsaberkem128r3);
        parameters.put(SABERParameterSpec.saberkem128r3.getName(), SABERParameters.saberkem128r3);
        parameters.put(SABERParameterSpec.firesaberkem128r3.getName(), SABERParameters.firesaberkem128r3);
        parameters.put(SABERParameterSpec.lightsaberkem192r3.getName(), SABERParameters.lightsaberkem192r3);
        parameters.put(SABERParameterSpec.saberkem192r3.getName(), SABERParameters.saberkem192r3);
        parameters.put(SABERParameterSpec.firesaberkem192r3.getName(), SABERParameters.firesaberkem192r3);
        parameters.put(SABERParameterSpec.lightsaberkem256r3.getName(), SABERParameters.lightsaberkem256r3);
        parameters.put(SABERParameterSpec.saberkem256r3.getName(), SABERParameters.saberkem256r3);
        parameters.put(SABERParameterSpec.firesaberkem256r3.getName(), SABERParameters.firesaberkem256r3);
    }

    public SABERKeyPairGeneratorSpi() {
        super("SABER");
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SABERParameterSpec) {
            return ((SABERParameterSpec) algorithmParameterSpec).getName();
        }
        return SpecUtil.getNameFrom(algorithmParameterSpec);
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SABERKeyGenerationParameters sABERKeyGenerationParameters = new SABERKeyGenerationParameters(this.random, SABERParameters.firesaberkem256r3);
            this.param = sABERKeyGenerationParameters;
            this.engine.init(sABERKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCSABERPublicKey((SABERPublicKeyParameters) generateKeyPair.getPublic()), new BCSABERPrivateKey((SABERPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SABERParameterSpec) {
            SABERKeyGenerationParameters sABERKeyGenerationParameters = new SABERKeyGenerationParameters(secureRandom, (SABERParameters) parameters.get(getNameFromParams(algorithmParameterSpec)));
            this.param = sABERKeyGenerationParameters;
            this.engine.init(sABERKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a SABERParameterSpec");
    }
}
