package com.fis.ekyc.nfc.build_in.bouncycastle.math.field;

public interface PolynomialExtensionField extends ExtensionField {
    Polynomial getMinimalPolynomial();
}
