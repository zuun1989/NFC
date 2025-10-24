package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Store;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.StoreException;
import java.security.cert.CRL;
import java.util.Collection;

public interface PKIXCRLStore<T extends CRL> extends Store<T> {
    Collection<T> getMatches(Selector<T> selector) throws StoreException;
}
