package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ElGamalPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalPrivateKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalPublicKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof ElGamalPrivateKeySpec) {
            return new BCElGamalPrivateKey((ElGamalPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof DHPrivateKeySpec) {
            return new BCElGamalPrivateKey((DHPrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof ElGamalPublicKeySpec) {
            return new BCElGamalPublicKey((ElGamalPublicKeySpec) keySpec);
        }
        if (keySpec instanceof DHPublicKeySpec) {
            return new BCElGamalPublicKey((DHPublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof DHPublicKey) {
            return new BCElGamalPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return new BCElGamalPrivateKey((DHPrivateKey) key);
        }
        if (key instanceof ElGamalPublicKey) {
            return new BCElGamalPublicKey((ElGamalPublicKey) key);
        }
        if (key instanceof ElGamalPrivateKey) {
            return new BCElGamalPrivateKey((ElGamalPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        if (algorithm.equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        if (algorithm.equals((ASN1Primitive) OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new BCElGamalPrivateKey(privateKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }

    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (algorithm.equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (algorithm.equals((ASN1Primitive) OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new BCElGamalPublicKey(subjectPublicKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }
}
