package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

public class PACEGMWithECDHAgreement {
    private ECPrivateKey privateKey;

    public ECPoint doPhase(PublicKey publicKey) throws InvalidKeyException, IllegalStateException {
        if (this.privateKey == null) {
            throw new IllegalStateException("Not initialized!");
        } else if (publicKey instanceof ECPublicKey) {
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint normalize = Util.toBouncyECPublicKeyParameters((ECPublicKey) publicKey).getQ().multiply(Util.toBouncyECPrivateKeyParameters(this.privateKey).getD()).normalize();
            if (!normalize.isInfinity()) {
                return Util.fromBouncyCastleECPoint(normalize);
            }
            throw new IllegalStateException("Infinity");
        } else {
            throw new InvalidKeyException("Not an ECPublicKey");
        }
    }

    public void init(PrivateKey privateKey2) throws InvalidKeyException {
        if (privateKey2 instanceof ECPrivateKey) {
            this.privateKey = (ECPrivateKey) privateKey2;
            return;
        }
        throw new InvalidKeyException("Not an ECPrivateKey");
    }
}
