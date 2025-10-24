package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import java.io.IOException;
import java.security.AlgorithmParameters;

public class JcaJceUtils {
    private JcaJceUtils() {
    }

    public static ASN1Encodable extractParameters(AlgorithmParameters algorithmParameters) throws IOException {
        try {
            return ASN1Primitive.fromByteArray(algorithmParameters.getEncoded("ASN.1"));
        } catch (Exception unused) {
            return ASN1Primitive.fromByteArray(algorithmParameters.getEncoded());
        }
    }

    public static String getDigestAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (PKCSObjectIdentifiers.md5.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "MD5";
        }
        if (OIWObjectIdentifiers.idSHA1.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.id_sha224.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.id_sha256.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.id_sha384.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.id_sha512.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.ripemd128.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.ripemd160.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.ripemd256.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.gostR3411.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "GOST3411";
        }
        return aSN1ObjectIdentifier.getId();
    }

    public static void loadParameters(AlgorithmParameters algorithmParameters, ASN1Encodable aSN1Encodable) throws IOException {
        try {
            algorithmParameters.init(aSN1Encodable.toASN1Primitive().getEncoded(), "ASN.1");
        } catch (Exception unused) {
            algorithmParameters.init(aSN1Encodable.toASN1Primitive().getEncoded());
        }
    }
}
