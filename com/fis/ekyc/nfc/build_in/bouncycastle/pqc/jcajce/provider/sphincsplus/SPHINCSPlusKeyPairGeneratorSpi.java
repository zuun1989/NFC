package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.SpecUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SPHINCSPlusParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class SPHINCSPlusKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;
    SPHINCSPlusKeyPairGenerator engine = new SPHINCSPlusKeyPairGenerator();
    boolean initialised = false;
    SPHINCSPlusKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();

    static {
        HashMap hashMap = new HashMap();
        parameters = hashMap;
        hashMap.put(SPHINCSPlusParameterSpec.sha256_128f.getName(), SPHINCSPlusParameters.sha256_128f);
        parameters.put(SPHINCSPlusParameterSpec.sha256_128s.getName(), SPHINCSPlusParameters.sha256_128s);
        parameters.put(SPHINCSPlusParameterSpec.sha256_192f.getName(), SPHINCSPlusParameters.sha256_192f);
        parameters.put(SPHINCSPlusParameterSpec.sha256_192s.getName(), SPHINCSPlusParameters.sha256_192s);
        parameters.put(SPHINCSPlusParameterSpec.sha256_256f.getName(), SPHINCSPlusParameters.sha256_256f);
        parameters.put(SPHINCSPlusParameterSpec.sha256_256s.getName(), SPHINCSPlusParameters.sha256_256s);
        parameters.put(SPHINCSPlusParameterSpec.sha256_128f_simple.getName(), SPHINCSPlusParameters.sha256_128f_simple);
        parameters.put(SPHINCSPlusParameterSpec.sha256_128s_simple.getName(), SPHINCSPlusParameters.sha256_128s_simple);
        parameters.put(SPHINCSPlusParameterSpec.sha256_192f_simple.getName(), SPHINCSPlusParameters.sha256_192f_simple);
        parameters.put(SPHINCSPlusParameterSpec.sha256_192s_simple.getName(), SPHINCSPlusParameters.sha256_192s_simple);
        parameters.put(SPHINCSPlusParameterSpec.sha256_256f_simple.getName(), SPHINCSPlusParameters.sha256_256f_simple);
        parameters.put(SPHINCSPlusParameterSpec.sha256_256s_simple.getName(), SPHINCSPlusParameters.sha256_256s_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_128f.getName(), SPHINCSPlusParameters.shake256_128f);
        parameters.put(SPHINCSPlusParameterSpec.shake256_128s.getName(), SPHINCSPlusParameters.shake256_128s);
        parameters.put(SPHINCSPlusParameterSpec.shake256_192f.getName(), SPHINCSPlusParameters.shake256_192f);
        parameters.put(SPHINCSPlusParameterSpec.shake256_192s.getName(), SPHINCSPlusParameters.shake256_192s);
        parameters.put(SPHINCSPlusParameterSpec.shake256_256f.getName(), SPHINCSPlusParameters.shake256_256f);
        parameters.put(SPHINCSPlusParameterSpec.shake256_256s.getName(), SPHINCSPlusParameters.shake256_256s);
        parameters.put(SPHINCSPlusParameterSpec.shake256_128f_simple.getName(), SPHINCSPlusParameters.shake256_128f_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_128s_simple.getName(), SPHINCSPlusParameters.shake256_128s_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_192f_simple.getName(), SPHINCSPlusParameters.shake256_192f_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_192s_simple.getName(), SPHINCSPlusParameters.shake256_192s_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_256f_simple.getName(), SPHINCSPlusParameters.shake256_256f_simple);
        parameters.put(SPHINCSPlusParameterSpec.shake256_256s_simple.getName(), SPHINCSPlusParameters.shake256_256s_simple);
    }

    public SPHINCSPlusKeyPairGeneratorSpi() {
        super("SPHINCS+");
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SPHINCSPlusParameterSpec) {
            return ((SPHINCSPlusParameterSpec) algorithmParameterSpec).getName();
        }
        return SpecUtil.getNameFrom(algorithmParameterSpec);
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SPHINCSPlusKeyGenerationParameters sPHINCSPlusKeyGenerationParameters = new SPHINCSPlusKeyGenerationParameters(this.random, SPHINCSPlusParameters.sha256_256s);
            this.param = sPHINCSPlusKeyGenerationParameters;
            this.engine.init(sPHINCSPlusKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCSPHINCSPlusPublicKey((SPHINCSPlusPublicKeyParameters) generateKeyPair.getPublic()), new BCSPHINCSPlusPrivateKey((SPHINCSPlusPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SPHINCSPlusParameterSpec) {
            SPHINCSPlusKeyGenerationParameters sPHINCSPlusKeyGenerationParameters = new SPHINCSPlusKeyGenerationParameters(secureRandom, (SPHINCSPlusParameters) parameters.get(getNameFromParams(algorithmParameterSpec)));
            this.param = sPHINCSPlusKeyGenerationParameters;
            this.engine.init(sPHINCSPlusKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a CMCEParameterSpec");
    }
}
