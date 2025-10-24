package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CRLStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509StoreParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509StoreSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.util.LDAPStoreHelper;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class X509StoreLDAPCRLs extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509CRLStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CRLStoreSelector x509CRLStoreSelector = (X509CRLStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CRLStoreSelector.isDeltaCRLIndicatorEnabled()) {
            hashSet.addAll(this.helper.getDeltaCertificateRevocationLists(x509CRLStoreSelector));
        } else {
            hashSet.addAll(this.helper.getDeltaCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.helper.getAttributeAuthorityRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.helper.getAttributeCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.helper.getAuthorityRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.helper.getCertificateRevocationLists(x509CRLStoreSelector));
        }
        return hashSet;
    }

    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
