package com.fis.ekyc.nfc.build_in.bouncycastle.util.test;

public interface TestResult {
    Throwable getException();

    boolean isSuccessful();

    String toString();
}
