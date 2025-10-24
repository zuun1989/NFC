package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import java.math.BigInteger;

public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private ElGamalKeyGenerationParameters param;

    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
        ElGamalParameters parameters = this.param.getParameters();
        DHParameters dHParameters = new DHParameters(parameters.getP(), parameters.getG(), (BigInteger) null, parameters.getL());
        BigInteger calculatePrivate = dHKeyGeneratorHelper.calculatePrivate(dHParameters, this.param.getRandom());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ElGamalPublicKeyParameters(dHKeyGeneratorHelper.calculatePublic(dHParameters, calculatePrivate), parameters), (AsymmetricKeyParameter) new ElGamalPrivateKeyParameters(calculatePrivate, parameters));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (ElGamalKeyGenerationParameters) keyGenerationParameters;
    }
}
