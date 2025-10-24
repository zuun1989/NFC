package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.gost;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.GOST3410ParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410ParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    protected SecureRandom random;
    protected int strength = 1024;

    public AlgorithmParameters engineGenerateParameters() {
        GOST3410ParametersGenerator gOST3410ParametersGenerator = new GOST3410ParametersGenerator();
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            gOST3410ParametersGenerator.init(this.strength, 2, secureRandom);
        } else {
            gOST3410ParametersGenerator.init(this.strength, 2, CryptoServicesRegistrar.getSecureRandom());
        }
        GOST3410Parameters generateParameters = gOST3410ParametersGenerator.generateParameters();
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance("GOST3410");
            createParametersInstance.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getA())));
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
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}
