package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DSAParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    protected DSAParameterGenerationParameters params;
    protected SecureRandom random;
    protected int strength = 2048;

    public AlgorithmParameters engineGenerateParameters() {
        DSAParametersGenerator dSAParametersGenerator;
        if (this.strength <= 1024) {
            dSAParametersGenerator = new DSAParametersGenerator();
        } else {
            dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
        }
        if (this.random == null) {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        int defaultCertainty = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
        int i = this.strength;
        if (i == 1024) {
            DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(1024, 160, defaultCertainty, this.random);
            this.params = dSAParameterGenerationParameters;
            dSAParametersGenerator.init(dSAParameterGenerationParameters);
        } else if (i > 1024) {
            DSAParameterGenerationParameters dSAParameterGenerationParameters2 = new DSAParameterGenerationParameters(i, 256, defaultCertainty, this.random);
            this.params = dSAParameterGenerationParameters2;
            dSAParametersGenerator.init(dSAParameterGenerationParameters2);
        } else {
            dSAParametersGenerator.init(i, defaultCertainty, this.random);
        }
        DSAParameters generateParameters = dSAParametersGenerator.generateParameters();
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance("DSA");
            createParametersInstance.init(new DSAParameterSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getG()));
            return createParametersInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        } else if (i <= 1024 && i % 64 != 0) {
            throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
        } else if (i <= 1024 || i % 1024 == 0) {
            this.strength = i;
            this.random = secureRandom;
        } else {
            throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
        }
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
