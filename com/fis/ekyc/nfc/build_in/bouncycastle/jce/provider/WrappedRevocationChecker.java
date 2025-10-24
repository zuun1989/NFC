package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationChecker;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;

class WrappedRevocationChecker implements PKIXCertRevocationChecker {
    private final PKIXCertPathChecker checker;

    public WrappedRevocationChecker(PKIXCertPathChecker pKIXCertPathChecker) {
        this.checker = pKIXCertPathChecker;
    }

    public void check(Certificate certificate) throws CertPathValidatorException {
        this.checker.check(certificate);
    }

    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) {
    }

    public void setParameter(String str, Object obj) {
    }
}
