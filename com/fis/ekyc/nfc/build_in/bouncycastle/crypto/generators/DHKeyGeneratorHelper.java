package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WNafUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    public BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger bigInteger;
        BigInteger createRandomInRange;
        BigInteger bit;
        int l = dHParameters.getL();
        if (l != 0) {
            int i = l >>> 2;
            do {
                bit = BigIntegers.createRandomBigInteger(l, secureRandom).setBit(l - 1);
            } while (WNafUtil.getNafWeight(bit) < i);
            return bit;
        }
        BigInteger bigInteger2 = TWO;
        int m = dHParameters.getM();
        if (m != 0) {
            bigInteger = ONE.shiftLeft(m - 1);
        } else {
            bigInteger = bigInteger2;
        }
        BigInteger q = dHParameters.getQ();
        if (q == null) {
            q = dHParameters.getP();
        }
        BigInteger subtract = q.subtract(bigInteger2);
        int bitLength = subtract.bitLength() >>> 2;
        do {
            createRandomInRange = BigIntegers.createRandomInRange(bigInteger, subtract, secureRandom);
        } while (WNafUtil.getNafWeight(createRandomInRange) < bitLength);
        return createRandomInRange;
    }

    public BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.getG().modPow(bigInteger, dHParameters.getP());
    }
}
