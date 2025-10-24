package com.fis.ekyc.nfc.build_in.bouncycastle.math.field;

public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
