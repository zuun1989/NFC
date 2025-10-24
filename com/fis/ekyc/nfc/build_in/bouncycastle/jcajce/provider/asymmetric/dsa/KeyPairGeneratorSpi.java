package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DSAKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DSAParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static Object lock = new Object();
    private static Hashtable params = new Hashtable();
    DSAKeyPairGenerator engine = new DSAKeyPairGenerator();
    boolean initialised = false;
    DSAKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    int strength = 2048;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    public KeyPair generateKeyPair() {
        DSAParametersGenerator dSAParametersGenerator;
        if (!this.initialised) {
            Integer valueOf = Integers.valueOf(this.strength);
            if (params.containsKey(valueOf)) {
                this.param = (DSAKeyGenerationParameters) params.get(valueOf);
            } else {
                synchronized (lock) {
                    try {
                        if (params.containsKey(valueOf)) {
                            this.param = (DSAKeyGenerationParameters) params.get(valueOf);
                        } else {
                            int defaultCertainty = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
                            int i = this.strength;
                            if (i == 1024) {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                if (Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.dsa.FIPS186-2for1024bits")) {
                                    dSAParametersGenerator.init(this.strength, defaultCertainty, this.random);
                                } else {
                                    dSAParametersGenerator.init(new DSAParameterGenerationParameters(1024, 160, defaultCertainty, this.random));
                                }
                            } else if (i > 1024) {
                                DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(i, 256, defaultCertainty, this.random);
                                dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
                                dSAParametersGenerator.init(dSAParameterGenerationParameters);
                            } else {
                                dSAParametersGenerator = new DSAParametersGenerator();
                                dSAParametersGenerator.init(this.strength, defaultCertainty, this.random);
                            }
                            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(this.random, dSAParametersGenerator.generateParameters());
                            this.param = dSAKeyGenerationParameters;
                            params.put(valueOf, dSAKeyGenerationParameters);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            this.engine.init(this.param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCDSAPublicKey((DSAPublicKeyParameters) generateKeyPair.getPublic()), new BCDSAPrivateKey((DSAPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        DSAParameterSpec dSADefaultParameters = BouncyCastleProvider.CONFIGURATION.getDSADefaultParameters(i);
        if (dSADefaultParameters != null) {
            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSADefaultParameters.getP(), dSADefaultParameters.getQ(), dSADefaultParameters.getG()));
            this.param = dSAKeyGenerationParameters;
            this.engine.init(dSAKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        this.strength = i;
        this.random = secureRandom;
        this.initialised = false;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
            this.param = dSAKeyGenerationParameters;
            this.engine.init(dSAKeyGenerationParameters);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
    }
}
