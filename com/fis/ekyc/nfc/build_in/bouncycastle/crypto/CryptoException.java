package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public class CryptoException extends Exception {
    private Throwable cause;

    public CryptoException() {
    }

    public Throwable getCause() {
        return this.cause;
    }

    public CryptoException(String str) {
        super(str);
    }

    public CryptoException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
