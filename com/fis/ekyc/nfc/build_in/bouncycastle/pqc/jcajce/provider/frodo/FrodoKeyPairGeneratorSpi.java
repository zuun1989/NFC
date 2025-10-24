package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.SpecUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.FrodoParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class FrodoKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;
    FrodoKeyPairGenerator engine = new FrodoKeyPairGenerator();
    boolean initialised = false;
    FrodoKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();

    static {
        HashMap hashMap = new HashMap();
        parameters = hashMap;
        hashMap.put(FrodoParameterSpec.frodokem19888r3.getName(), FrodoParameters.frodokem19888r3);
        parameters.put(FrodoParameterSpec.frodokem19888shaker3.getName(), FrodoParameters.frodokem19888shaker3);
        parameters.put(FrodoParameterSpec.frodokem31296r3.getName(), FrodoParameters.frodokem31296r3);
        parameters.put(FrodoParameterSpec.frodokem31296shaker3.getName(), FrodoParameters.frodokem31296shaker3);
        parameters.put(FrodoParameterSpec.frodokem43088r3.getName(), FrodoParameters.frodokem43088r3);
        parameters.put(FrodoParameterSpec.frodokem43088shaker3.getName(), FrodoParameters.frodokem43088shaker3);
    }

    public FrodoKeyPairGeneratorSpi() {
        super("Frodo");
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof FrodoParameterSpec) {
            return ((FrodoParameterSpec) algorithmParameterSpec).getName();
        }
        return SpecUtil.getNameFrom(algorithmParameterSpec);
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            FrodoKeyGenerationParameters frodoKeyGenerationParameters = new FrodoKeyGenerationParameters(this.random, FrodoParameters.frodokem43088shaker3);
            this.param = frodoKeyGenerationParameters;
            this.engine.init(frodoKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCFrodoPublicKey((FrodoPublicKeyParameters) generateKeyPair.getPublic()), new BCFrodoPrivateKey((FrodoPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof FrodoParameterSpec) {
            FrodoKeyGenerationParameters frodoKeyGenerationParameters = new FrodoKeyGenerationParameters(secureRandom, (FrodoParameters) parameters.get(getNameFromParams(algorithmParameterSpec)));
            this.param = frodoKeyGenerationParameters;
            this.engine.init(frodoKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a FrodoParameterSpec");
    }
}
