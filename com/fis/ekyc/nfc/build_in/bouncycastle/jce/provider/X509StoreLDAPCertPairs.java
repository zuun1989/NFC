package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.X509LDAPCertStoreParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509CertPairStoreSelector;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509StoreParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509StoreSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.util.LDAPStoreHelper;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class X509StoreLDAPCertPairs extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509CertPairStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.helper.getCrossCertificatePairs((X509CertPairStoreSelector) selector));
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
