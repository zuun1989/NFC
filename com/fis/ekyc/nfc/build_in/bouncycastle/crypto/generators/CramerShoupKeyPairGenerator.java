package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.CramerShoupKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.CramerShoupParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private CramerShoupKeyGenerationParameters param;

    private CramerShoupPublicKeyParameters calculatePublicKey(CramerShoupParameters cramerShoupParameters, CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters) {
        BigInteger g1 = cramerShoupParameters.getG1();
        BigInteger g2 = cramerShoupParameters.getG2();
        BigInteger p = cramerShoupParameters.getP();
        return new CramerShoupPublicKeyParameters(cramerShoupParameters, g1.modPow(cramerShoupPrivateKeyParameters.getX1(), p).multiply(g2.modPow(cramerShoupPrivateKeyParameters.getX2(), p)), g1.modPow(cramerShoupPrivateKeyParameters.getY1(), p).multiply(g2.modPow(cramerShoupPrivateKeyParameters.getY2(), p)), g1.modPow(cramerShoupPrivateKeyParameters.getZ(), p));
    }

    private CramerShoupPrivateKeyParameters generatePrivateKey(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        BigInteger p = cramerShoupParameters.getP();
        return new CramerShoupPrivateKeyParameters(cramerShoupParameters, generateRandomElement(p, secureRandom), generateRandomElement(p, secureRandom), generateRandomElement(p, secureRandom), generateRandomElement(p, secureRandom), generateRandomElement(p, secureRandom));
    }

    private BigInteger generateRandomElement(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        CramerShoupParameters parameters = this.param.getParameters();
        CramerShoupPrivateKeyParameters generatePrivateKey = generatePrivateKey(this.param.getRandom(), parameters);
        CramerShoupPublicKeyParameters calculatePublicKey = calculatePublicKey(parameters, generatePrivateKey);
        generatePrivateKey.setPk(calculatePublicKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) calculatePublicKey, (AsymmetricKeyParameter) generatePrivateKey);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (CramerShoupKeyGenerationParameters) keyGenerationParameters;
    }
}
