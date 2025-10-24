package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WNafUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private GOST3410KeyGenerationParameters param;

    public AsymmetricCipherKeyPair generateKeyPair() {
        GOST3410Parameters parameters = this.param.getParameters();
        SecureRandom random = this.param.getRandom();
        BigInteger q = parameters.getQ();
        BigInteger p = parameters.getP();
        BigInteger a = parameters.getA();
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(256, random);
            if (createRandomBigInteger.signum() >= 1 && createRandomBigInteger.compareTo(q) < 0 && WNafUtil.getNafWeight(createRandomBigInteger) >= 64) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GOST3410PublicKeyParameters(a.modPow(createRandomBigInteger, p), parameters), (AsymmetricKeyParameter) new GOST3410PrivateKeyParameters(createRandomBigInteger, parameters));
            }
        }
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (GOST3410KeyGenerationParameters) keyGenerationParameters;
    }
}
