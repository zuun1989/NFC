package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int i);

    ECPoint lookupVar(int i);
}
