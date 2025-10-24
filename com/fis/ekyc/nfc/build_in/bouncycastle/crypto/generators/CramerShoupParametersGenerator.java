package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.CramerShoupParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class CramerShoupParametersGenerator {
    /* access modifiers changed from: private */
    public static final BigInteger ONE = BigInteger.valueOf(1);
    private int certainty;
    private SecureRandom random;
    private int size;

    public static class ParametersHelper {
        private static final BigInteger TWO = BigInteger.valueOf(2);

        private ParametersHelper() {
        }

        public static BigInteger[] generateSafePrimes(int i, int i2, SecureRandom secureRandom) {
            BigInteger createRandomPrime;
            BigInteger add;
            int i3 = i - 1;
            while (true) {
                createRandomPrime = BigIntegers.createRandomPrime(i3, 2, secureRandom);
                add = createRandomPrime.shiftLeft(1).add(CramerShoupParametersGenerator.ONE);
                if (!add.isProbablePrime(i2) || (i2 > 2 && !createRandomPrime.isProbablePrime(i2))) {
                }
            }
            return new BigInteger[]{add, createRandomPrime};
        }

        public static BigInteger selectGenerator(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(TWO);
            do {
                BigInteger bigInteger2 = TWO;
                modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (modPow.equals(CramerShoupParametersGenerator.ONE));
            return modPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger bigInteger = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
        BigInteger selectGenerator = ParametersHelper.selectGenerator(bigInteger, this.random);
        BigInteger selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        while (selectGenerator.equals(selectGenerator2)) {
            selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        }
        return new CramerShoupParameters(bigInteger, selectGenerator, selectGenerator2, new SHA256Digest());
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.size = i;
        this.certainty = i2;
        this.random = secureRandom;
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g = dHParameters.getG();
        BigInteger selectGenerator = ParametersHelper.selectGenerator(p, this.random);
        while (g.equals(selectGenerator)) {
            selectGenerator = ParametersHelper.selectGenerator(p, this.random);
        }
        return new CramerShoupParameters(p, g, selectGenerator, new SHA256Digest());
    }
}
