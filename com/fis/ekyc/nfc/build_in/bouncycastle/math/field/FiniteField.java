package com.fis.ekyc.nfc.build_in.bouncycastle.math.field;

import java.math.BigInteger;

public interface FiniteField {
    BigInteger getCharacteristic();

    int getDimension();
}
