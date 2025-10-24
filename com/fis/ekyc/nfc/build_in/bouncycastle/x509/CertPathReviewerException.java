package com.fis.ekyc.nfc.build_in.bouncycastle.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.ErrorBundle;
import com.fis.ekyc.nfc.build_in.bouncycastle.i18n.LocalizedException;
import java.security.cert.CertPath;

public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath = null;
    private int index = -1;

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle, th);
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th, CertPath certPath2, int i) {
        super(errorBundle, th);
        if (certPath2 == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i;
        }
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath2, int i) {
        super(errorBundle);
        if (certPath2 == null || i == -1) {
            throw new IllegalArgumentException();
        } else if (i < -1 || i >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i;
        }
    }
}
