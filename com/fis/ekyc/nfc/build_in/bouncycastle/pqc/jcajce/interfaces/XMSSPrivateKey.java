package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public interface XMSSPrivateKey extends XMSSKey, PrivateKey {
    XMSSPrivateKey extractKeyShard(int i);

    long getIndex();

    long getUsagesRemaining();
}
