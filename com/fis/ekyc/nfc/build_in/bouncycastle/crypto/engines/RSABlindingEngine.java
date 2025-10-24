package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSABlindingParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

public class RSABlindingEngine implements AsymmetricBlockCipher {
    private BigInteger blindingFactor;
    private RSACoreEngine core = new RSACoreEngine();
    private boolean forEncryption;
    private RSAKeyParameters key;

    private BigInteger blindMessage(BigInteger bigInteger) {
        return bigInteger.multiply(this.blindingFactor.modPow(this.key.getExponent(), this.key.getModulus())).mod(this.key.getModulus());
    }

    private BigInteger unblindMessage(BigInteger bigInteger) {
        BigInteger modulus = this.key.getModulus();
        return bigInteger.multiply(BigIntegers.modOddInverse(modulus, this.blindingFactor)).mod(modulus);
    }

    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        RSABlindingParameters rSABlindingParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSABlindingParameters = (RSABlindingParameters) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            rSABlindingParameters = (RSABlindingParameters) cipherParameters;
        }
        this.core.init(z, rSABlindingParameters.getPublicKey());
        this.forEncryption = z;
        this.key = rSABlindingParameters.getPublicKey();
        this.blindingFactor = rSABlindingParameters.getBlindingFactor();
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigInteger;
        BigInteger convertInput = this.core.convertInput(bArr, i, i2);
        if (this.forEncryption) {
            bigInteger = blindMessage(convertInput);
        } else {
            bigInteger = unblindMessage(convertInput);
        }
        return this.core.convertOutput(bigInteger);
    }
}
