package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import java.math.BigInteger;

public class DHBasicAgreement implements BasicAgreement {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (dHPublicKeyParameters.getParameters().equals(this.dhParams)) {
            BigInteger p = this.dhParams.getP();
            BigInteger y = dHPublicKeyParameters.getY();
            if (y != null) {
                BigInteger bigInteger = ONE;
                if (y.compareTo(bigInteger) > 0 && y.compareTo(p.subtract(bigInteger)) < 0) {
                    BigInteger modPow = y.modPow(this.key.getX(), p);
                    if (!modPow.equals(bigInteger)) {
                        return modPow;
                    }
                    throw new IllegalStateException("Shared key can't be 1");
                }
            }
            throw new IllegalArgumentException("Diffie-Hellman public key is weak");
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public int getFieldSize() {
        return (this.key.getParameters().getP().bitLength() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.key = dHPrivateKeyParameters;
            this.dhParams = dHPrivateKeyParameters.getParameters();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }
}
