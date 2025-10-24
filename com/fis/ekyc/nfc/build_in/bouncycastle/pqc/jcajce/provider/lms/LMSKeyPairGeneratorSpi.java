package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSigParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.LMSHSSKeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.LMSHSSParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.LMSKeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.LMSParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class LMSKeyPairGeneratorSpi extends KeyPairGenerator {
    private AsymmetricCipherKeyPairGenerator engine = new LMSKeyPairGenerator();
    private boolean initialised = false;
    private KeyGenerationParameters param;
    private SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private ASN1ObjectIdentifier treeDigest;

    public LMSKeyPairGeneratorSpi() {
        super("LMS");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            LMSKeyGenerationParameters lMSKeyGenerationParameters = new LMSKeyGenerationParameters(new LMSParameters(LMSigParameters.lms_sha256_n32_h10, LMOtsParameters.sha256_n32_w2), this.random);
            this.param = lMSKeyGenerationParameters;
            this.engine.init(lMSKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        if (this.engine instanceof LMSKeyPairGenerator) {
            return new KeyPair(new BCLMSPublicKey((LMSKeyParameters) (LMSPublicKeyParameters) generateKeyPair.getPublic()), new BCLMSPrivateKey((LMSKeyParameters) (LMSPrivateKeyParameters) generateKeyPair.getPrivate()));
        }
        return new KeyPair(new BCLMSPublicKey((LMSKeyParameters) (HSSPublicKeyParameters) generateKeyPair.getPublic()), new BCLMSPrivateKey((LMSKeyParameters) (HSSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof LMSKeyGenParameterSpec) {
            LMSKeyGenParameterSpec lMSKeyGenParameterSpec = (LMSKeyGenParameterSpec) algorithmParameterSpec;
            this.param = new LMSKeyGenerationParameters(new LMSParameters(lMSKeyGenParameterSpec.getSigParams(), lMSKeyGenParameterSpec.getOtsParams()), secureRandom);
            LMSKeyPairGenerator lMSKeyPairGenerator = new LMSKeyPairGenerator();
            this.engine = lMSKeyPairGenerator;
            lMSKeyPairGenerator.init(this.param);
        } else {
            int i = 0;
            if (algorithmParameterSpec instanceof LMSHSSKeyGenParameterSpec) {
                LMSKeyGenParameterSpec[] lMSSpecs = ((LMSHSSKeyGenParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr = new LMSParameters[lMSSpecs.length];
                while (i != lMSSpecs.length) {
                    lMSParametersArr[i] = new LMSParameters(lMSSpecs[i].getSigParams(), lMSSpecs[i].getOtsParams());
                    i++;
                }
                this.param = new HSSKeyGenerationParameters(lMSParametersArr, secureRandom);
                HSSKeyPairGenerator hSSKeyPairGenerator = new HSSKeyPairGenerator();
                this.engine = hSSKeyPairGenerator;
                hSSKeyPairGenerator.init(this.param);
            } else if (algorithmParameterSpec instanceof LMSParameterSpec) {
                LMSParameterSpec lMSParameterSpec = (LMSParameterSpec) algorithmParameterSpec;
                this.param = new LMSKeyGenerationParameters(new LMSParameters(lMSParameterSpec.getSigParams(), lMSParameterSpec.getOtsParams()), secureRandom);
                LMSKeyPairGenerator lMSKeyPairGenerator2 = new LMSKeyPairGenerator();
                this.engine = lMSKeyPairGenerator2;
                lMSKeyPairGenerator2.init(this.param);
            } else if (algorithmParameterSpec instanceof LMSHSSParameterSpec) {
                LMSParameterSpec[] lMSSpecs2 = ((LMSHSSParameterSpec) algorithmParameterSpec).getLMSSpecs();
                LMSParameters[] lMSParametersArr2 = new LMSParameters[lMSSpecs2.length];
                while (i != lMSSpecs2.length) {
                    lMSParametersArr2[i] = new LMSParameters(lMSSpecs2[i].getSigParams(), lMSSpecs2[i].getOtsParams());
                    i++;
                }
                this.param = new HSSKeyGenerationParameters(lMSParametersArr2, secureRandom);
                HSSKeyPairGenerator hSSKeyPairGenerator2 = new HSSKeyPairGenerator();
                this.engine = hSSKeyPairGenerator2;
                hSSKeyPairGenerator2.init(this.param);
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a LMSParameterSpec/LMSHSSParameterSpec");
            }
        }
        this.initialised = true;
    }
}
