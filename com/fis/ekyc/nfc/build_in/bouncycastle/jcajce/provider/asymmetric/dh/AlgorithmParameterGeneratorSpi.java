package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.DHParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    private int l = 0;
    protected SecureRandom random;
    protected int strength = 2048;

    public AlgorithmParameters engineGenerateParameters() {
        DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
        dHParametersGenerator.init(this.strength, PrimeCertaintyCalculator.getDefaultCertainty(this.strength), CryptoServicesRegistrar.getSecureRandom(this.random));
        DHParameters generateParameters = dHParametersGenerator.generateParameters();
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance("DH");
            createParametersInstance.init(new DHParameterSpec(generateParameters.getP(), generateParameters.getG(), this.l));
            return createParametersInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.strength = dHGenParameterSpec.getPrimeSize();
            this.l = dHGenParameterSpec.getExponentSize();
            this.random = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }
}
