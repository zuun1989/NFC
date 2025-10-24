package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.gm.GMObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.iso.ISOIECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class MessageDigestUtils {
    private static Map<ASN1ObjectIdentifier, String> digestOidMap;

    static {
        HashMap hashMap = new HashMap();
        digestOidMap = hashMap;
        hashMap.put(PKCSObjectIdentifiers.md2, "MD2");
        digestOidMap.put(PKCSObjectIdentifiers.md4, "MD4");
        digestOidMap.put(PKCSObjectIdentifiers.md5, "MD5");
        digestOidMap.put(OIWObjectIdentifiers.idSHA1, McElieceCCA2KeyGenParameterSpec.SHA1);
        digestOidMap.put(NISTObjectIdentifiers.id_sha224, McElieceCCA2KeyGenParameterSpec.SHA224);
        digestOidMap.put(NISTObjectIdentifiers.id_sha256, "SHA-256");
        digestOidMap.put(NISTObjectIdentifiers.id_sha384, McElieceCCA2KeyGenParameterSpec.SHA384);
        digestOidMap.put(NISTObjectIdentifiers.id_sha512, "SHA-512");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD-128");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD-160");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD-128");
        digestOidMap.put(ISOIECObjectIdentifiers.ripemd128, "RIPEMD-128");
        digestOidMap.put(ISOIECObjectIdentifiers.ripemd160, "RIPEMD-160");
        digestOidMap.put(CryptoProObjectIdentifiers.gostR3411, "GOST3411");
        digestOidMap.put(GNUObjectIdentifiers.Tiger_192, "Tiger");
        digestOidMap.put(ISOIECObjectIdentifiers.whirlpool, "Whirlpool");
        digestOidMap.put(NISTObjectIdentifiers.id_sha3_224, "SHA3-224");
        digestOidMap.put(NISTObjectIdentifiers.id_sha3_256, "SHA3-256");
        digestOidMap.put(NISTObjectIdentifiers.id_sha3_384, "SHA3-384");
        digestOidMap.put(NISTObjectIdentifiers.id_sha3_512, "SHA3-512");
        digestOidMap.put(GMObjectIdentifiers.sm3, "SM3");
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = digestOidMap.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        return aSN1ObjectIdentifier.getId();
    }
}
