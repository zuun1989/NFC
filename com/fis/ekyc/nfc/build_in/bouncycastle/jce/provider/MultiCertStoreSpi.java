package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.MultiCertStoreParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultiCertStoreSpi extends CertStoreSpi {
    private MultiCertStoreParameters params;

    public MultiCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof MultiCertStoreParameters) {
            this.params = (MultiCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException("com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.MultiCertStoreSpi: parameter must be a MultiCertStoreParameters object\n" + certStoreParameters.toString());
    }

    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        List list;
        boolean searchAllStores = this.params.getSearchAllStores();
        if (searchAllStores) {
            list = new ArrayList();
        } else {
            list = Collections.EMPTY_LIST;
        }
        for (CertStore cRLs : this.params.getCertStores()) {
            Collection<? extends CRL> cRLs2 = cRLs.getCRLs(cRLSelector);
            if (searchAllStores) {
                list.addAll(cRLs2);
            } else if (!cRLs2.isEmpty()) {
                return cRLs2;
            }
        }
        return list;
    }

    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        List list;
        boolean searchAllStores = this.params.getSearchAllStores();
        if (searchAllStores) {
            list = new ArrayList();
        } else {
            list = Collections.EMPTY_LIST;
        }
        for (CertStore certificates : this.params.getCertStores()) {
            Collection<? extends Certificate> certificates2 = certificates.getCertificates(certSelector);
            if (searchAllStores) {
                list.addAll(certificates2);
            } else if (!certificates2.isEmpty()) {
                return certificates2;
            }
        }
        return list;
    }
}
