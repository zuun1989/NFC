package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    private Throwable cause;

    public ASN1Exception(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public ASN1Exception(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
