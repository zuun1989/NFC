package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    private static final byte[] zeroBytes = new byte[0];

    private DERNull() {
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 5, zeroBytes);
    }

    public int encodedLength() {
        return 2;
    }

    public boolean isConstructed() {
        return false;
    }
}
