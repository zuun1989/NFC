package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSABlindingFactorGenerator {
    private static BigInteger ONE = BigInteger.valueOf(1);
    private static BigInteger ZERO = BigInteger.valueOf(0);
    private RSAKeyParameters key;
    private SecureRandom random;

    public BigInteger generateBlindingFactor() {
        RSAKeyParameters rSAKeyParameters = this.key;
        if (rSAKeyParameters != null) {
            BigInteger modulus = rSAKeyParameters.getModulus();
            int bitLength = modulus.bitLength() - 1;
            while (true) {
                BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bitLength, this.random);
                BigInteger gcd = createRandomBigInteger.gcd(modulus);
                if (!createRandomBigInteger.equals(ZERO) && !createRandomBigInteger.equals(ONE) && gcd.equals(ONE)) {
                    return createRandomBigInteger;
                }
            }
        } else {
            throw new IllegalStateException("generator not initialised");
        }
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.key = (RSAKeyParameters) parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            this.key = (RSAKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        if (this.key instanceof RSAPrivateCrtKeyParameters) {
            throw new IllegalArgumentException("generator requires RSA public key");
        }
    }
}
