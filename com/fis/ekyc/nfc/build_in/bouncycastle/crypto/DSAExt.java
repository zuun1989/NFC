package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

import java.math.BigInteger;

public interface DSAExt extends DSA {
    BigInteger getOrder();
}
