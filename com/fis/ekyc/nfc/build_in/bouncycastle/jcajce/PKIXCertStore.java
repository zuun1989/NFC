package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Store;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import java.security.cert.Certificate;
import java.util.Collection;

public interface PKIXCertStore<T extends Certificate> extends Store<T> {
    Collection<T> getMatches(Selector<T> selector) throws StoreException;
}
