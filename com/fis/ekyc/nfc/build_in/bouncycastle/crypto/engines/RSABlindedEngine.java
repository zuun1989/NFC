package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSABlindedEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSACoreEngine core = new RSACoreEngine();
    private RSAKeyParameters key;
    private SecureRandom random;

    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.core.init(z, cipherParameters);
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) parametersWithRandom.getParameters();
            this.key = rSAKeyParameters;
            if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
                this.random = parametersWithRandom.getRandom();
            } else {
                this.random = null;
            }
        } else {
            RSAKeyParameters rSAKeyParameters2 = (RSAKeyParameters) cipherParameters;
            this.key = rSAKeyParameters2;
            if (rSAKeyParameters2 instanceof RSAPrivateCrtKeyParameters) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            } else {
                this.random = null;
            }
        }
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigInteger;
        if (this.key != null) {
            BigInteger convertInput = this.core.convertInput(bArr, i, i2);
            RSAKeyParameters rSAKeyParameters = this.key;
            if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
                BigInteger publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
                if (publicExponent != null) {
                    BigInteger modulus = rSAPrivateCrtKeyParameters.getModulus();
                    BigInteger bigInteger2 = ONE;
                    BigInteger createRandomInRange = BigIntegers.createRandomInRange(bigInteger2, modulus.subtract(bigInteger2), this.random);
                    bigInteger = this.core.processBlock(createRandomInRange.modPow(publicExponent, modulus).multiply(convertInput).mod(modulus)).multiply(BigIntegers.modOddInverse(modulus, createRandomInRange)).mod(modulus);
                    if (!convertInput.equals(bigInteger.modPow(publicExponent, modulus))) {
                        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                    }
                } else {
                    bigInteger = this.core.processBlock(convertInput);
                }
            } else {
                bigInteger = this.core.processBlock(convertInput);
            }
            return this.core.convertOutput(bigInteger);
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
