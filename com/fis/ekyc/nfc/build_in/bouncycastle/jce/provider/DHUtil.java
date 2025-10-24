package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPublicKeyParameters;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

public class DHUtil {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
            return new DHPrivateKeyParameters(dHPrivateKey.getX(), new DHParameters(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG(), (BigInteger) null, dHPrivateKey.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            return new DHPublicKeyParameters(dHPublicKey.getY(), new DHParameters(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG(), (BigInteger) null, dHPublicKey.getParams().getL()));
        }
        throw new InvalidKeyException("can't identify DH public key.");
    }
}
