package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.FixedPointCombMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WNafUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    ECDomainParameters params;
    SecureRandom random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger n = this.params.getN();
        int bitLength = n.bitLength();
        int i = bitLength >>> 2;
        while (true) {
            BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
            if (createRandomBigInteger.compareTo(ECConstants.ONE) >= 0 && createRandomBigInteger.compareTo(n) < 0 && WNafUtil.getNafWeight(createRandomBigInteger) >= i) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(createBasePointMultiplier().multiply(this.params.getG(), createRandomBigInteger), this.params), (AsymmetricKeyParameter) new ECPrivateKeyParameters(createRandomBigInteger, this.params));
            }
        }
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.random = eCKeyGenerationParameters.getRandom();
        this.params = eCKeyGenerationParameters.getDomainParameters();
    }
}
