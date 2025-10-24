package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Xof;

class DigestUtil {
    public static byte[] getDigestResult(Digest digest) {
        int digestSize = getDigestSize(digest);
        byte[] bArr = new byte[digestSize];
        if (digest instanceof Xof) {
            ((Xof) digest).doFinal(bArr, 0, digestSize);
        } else {
            digest.doFinal(bArr, 0);
        }
        return bArr;
    }

    public static int getDigestSize(Digest digest) {
        if (digest instanceof Xof) {
            return digest.getDigestSize() * 2;
        }
        return digest.getDigestSize();
    }

    public static String getXMSSDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return "SHA256";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return "SHA512";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return "SHAKE128";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return "SHAKE256";
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }
}
