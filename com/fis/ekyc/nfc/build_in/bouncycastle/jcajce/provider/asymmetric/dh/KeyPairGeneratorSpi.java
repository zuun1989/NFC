package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DHParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static Object lock = new Object();
    private static Hashtable params = new Hashtable();
    DHBasicKeyPairGenerator engine = new DHBasicKeyPairGenerator();
    boolean initialised = false;
    DHKeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    int strength = 2048;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    private DHKeyGenerationParameters convertParams(SecureRandom secureRandom, DHParameterSpec dHParameterSpec) {
        if (dHParameterSpec instanceof DHDomainParameterSpec) {
            return new DHKeyGenerationParameters(secureRandom, ((DHDomainParameterSpec) dHParameterSpec).getDomainParameters());
        }
        return new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), (BigInteger) null, dHParameterSpec.getL()));
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            Integer valueOf = Integers.valueOf(this.strength);
            if (params.containsKey(valueOf)) {
                this.param = (DHKeyGenerationParameters) params.get(valueOf);
            } else {
                DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
                if (dHDefaultParameters != null) {
                    this.param = convertParams(this.random, dHDefaultParameters);
                } else {
                    synchronized (lock) {
                        try {
                            if (params.containsKey(valueOf)) {
                                this.param = (DHKeyGenerationParameters) params.get(valueOf);
                            } else {
                                DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                                int i = this.strength;
                                dHParametersGenerator.init(i, PrimeCertaintyCalculator.getDefaultCertainty(i), this.random);
                                DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(this.random, dHParametersGenerator.generateParameters());
                                this.param = dHKeyGenerationParameters;
                                params.put(valueOf, dHKeyGenerationParameters);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                }
            }
            this.engine.init(this.param);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) generateKeyPair.getPublic()), new BCDHPrivateKey((DHPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
        this.initialised = false;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            try {
                DHKeyGenerationParameters convertParams = convertParams(secureRandom, (DHParameterSpec) algorithmParameterSpec);
                this.param = convertParams;
                this.engine.init(convertParams);
                this.initialised = true;
            } catch (IllegalArgumentException e) {
                throw new InvalidAlgorithmParameterException(e.getMessage(), e);
            }
        } else {
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }
    }
}
