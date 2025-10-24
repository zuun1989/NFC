package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException {
    Throwable cause;

    public ExtCRLException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
