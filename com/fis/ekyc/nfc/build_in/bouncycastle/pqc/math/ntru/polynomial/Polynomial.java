package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial;

public interface Polynomial {
    BigIntPolynomial mult(BigIntPolynomial bigIntPolynomial);

    IntegerPolynomial mult(IntegerPolynomial integerPolynomial);

    IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i);

    IntegerPolynomial toIntegerPolynomial();
}
