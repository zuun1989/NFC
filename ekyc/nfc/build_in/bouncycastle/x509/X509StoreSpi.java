package com.fis.ekyc.nfc.build_in.bouncycastle.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Selector;
import java.util.Collection;

public abstract class X509StoreSpi {
    public abstract Collection engineGetMatches(Selector selector);

    public abstract void engineInit(X509StoreParameters x509StoreParameters);
}
