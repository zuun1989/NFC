package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationChecker;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

class ProvCrlRevocationChecker implements PKIXCertRevocationChecker {
    private final JcaJceHelper helper;
    private PKIXCertRevocationCheckerParameters params;

    public ProvCrlRevocationChecker(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    public void check(Certificate certificate) throws CertPathValidatorException {
        Throwable th;
        try {
            PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters = this.params;
            RFC3280CertPathUtilities.checkCRLs(pKIXCertRevocationCheckerParameters, pKIXCertRevocationCheckerParameters.getParamsPKIX(), (X509Certificate) certificate, this.params.getValidDate(), this.params.getSigningCert(), this.params.getWorkingPublicKey(), this.params.getCertPath().getCertificates(), this.helper);
        } catch (AnnotatedException e) {
            if (e.getCause() != null) {
                th = e.getCause();
            } else {
                th = e;
            }
            throw new CertPathValidatorException(e.getMessage(), th, this.params.getCertPath(), this.params.getIndex());
        }
    }

    public void init(boolean z) throws CertPathValidatorException {
        if (z) {
            throw new CertPathValidatorException("forward checking not supported");
        }
    }

    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) {
        this.params = pKIXCertRevocationCheckerParameters;
    }

    public void setParameter(String str, Object obj) {
    }
}
