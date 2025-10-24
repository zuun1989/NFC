package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import java.math.BigInteger;

public class RSABlindingParameters implements CipherParameters {
    private BigInteger blindingFactor;
    private RSAKeyParameters publicKey;

    public RSABlindingParameters(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger) {
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters)) {
            this.publicKey = rSAKeyParameters;
            this.blindingFactor = bigInteger;
            return;
        }
        throw new IllegalArgumentException("RSA parameters should be for a public key");
    }

    public BigInteger getBlindingFactor() {
        return this.blindingFactor;
    }

    public RSAKeyParameters getPublicKey() {
        return this.publicKey;
    }
}
