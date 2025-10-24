package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.gost;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.GOST3410PublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi {
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof GOST3410PrivateKeySpec) {
            return new BCGOST3410PrivateKey((GOST3410PrivateKeySpec) keySpec);
        }
        return super.engineGeneratePrivate(keySpec);
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof GOST3410PublicKeySpec) {
            return new BCGOST3410PublicKey((GOST3410PublicKeySpec) keySpec);
        }
        return super.engineGeneratePublic(keySpec);
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(GOST3410PublicKeySpec.class) && (key instanceof GOST3410PublicKey)) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) key;
            GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410PublicKey.getParameters().getPublicKeyParameters();
            return new GOST3410PublicKeySpec(gOST3410PublicKey.getY(), publicKeyParameters.getP(), publicKeyParameters.getQ(), publicKeyParameters.getA());
        } else if (!cls.isAssignableFrom(GOST3410PrivateKeySpec.class) || !(key instanceof GOST3410PrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) key;
            GOST3410PublicKeyParameterSetSpec publicKeyParameters2 = gOST3410PrivateKey.getParameters().getPublicKeyParameters();
            return new GOST3410PrivateKeySpec(gOST3410PrivateKey.getX(), publicKeyParameters2.getP(), publicKeyParameters2.getQ(), publicKeyParameters2.getA());
        }
    }

    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof GOST3410PublicKey) {
            return new BCGOST3410PublicKey((GOST3410PublicKey) key);
        }
        if (key instanceof GOST3410PrivateKey) {
            return new BCGOST3410PrivateKey((GOST3410PrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }

    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (algorithm.equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_94)) {
            return new BCGOST3410PrivateKey(privateKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }

    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (algorithm.equals((ASN1Primitive) CryptoProObjectIdentifiers.gostR3410_94)) {
            return new BCGOST3410PublicKey(subjectPublicKeyInfo);
        }
        throw new IOException("algorithm identifier " + algorithm + " in key not recognised");
    }
}
