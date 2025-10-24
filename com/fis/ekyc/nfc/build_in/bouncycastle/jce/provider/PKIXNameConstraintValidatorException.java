package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

public class PKIXNameConstraintValidatorException extends Exception {
    private Throwable cause;

    public PKIXNameConstraintValidatorException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public PKIXNameConstraintValidatorException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
