package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import java.util.HashMap;
import java.util.Map;

public class SecretKeyUtil {
    private static Map keySizes;

    static {
        HashMap hashMap = new HashMap();
        keySizes = hashMap;
        hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), Integers.valueOf(CertificateHolderAuthorization.CVCA));
        keySizes.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
        keySizes.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(CertificateHolderAuthorization.CVCA));
        keySizes.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
        keySizes.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
        keySizes.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(CertificateHolderAuthorization.CVCA));
        keySizes.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
    }

    public static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = (Integer) keySizes.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
