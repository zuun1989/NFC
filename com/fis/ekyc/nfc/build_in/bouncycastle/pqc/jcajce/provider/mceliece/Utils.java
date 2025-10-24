package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

class Utils {
    public static AlgorithmIdentifier getDigAlgId(String str) {
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA1)) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
        }
        if (str.equals("SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA384)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
        }
        if (str.equals("SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    public static Digest getDigest(AlgorithmIdentifier algorithmIdentifier) {
        if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) OIWObjectIdentifiers.idSHA1)) {
            return DigestFactory.createSHA1();
        }
        if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) NISTObjectIdentifiers.id_sha224)) {
            return DigestFactory.createSHA224();
        }
        if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return DigestFactory.createSHA256();
        }
        if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
            return DigestFactory.createSHA384();
        }
        if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return DigestFactory.createSHA512();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + algorithmIdentifier.getAlgorithm());
    }
}
