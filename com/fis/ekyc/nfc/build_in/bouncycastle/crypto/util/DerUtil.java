package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;

class DerUtil {
    public static ASN1OctetString getOctetString(byte[] bArr) {
        if (bArr == null) {
            return new DEROctetString(new byte[0]);
        }
        return new DEROctetString(Arrays.clone(bArr));
    }

    public static byte[] toByteArray(ASN1Primitive aSN1Primitive) {
        try {
            return aSN1Primitive.getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot get encoding: " + e.getMessage()) {
                public Throwable getCause() {
                    return e;
                }
            };
        }
    }
}
