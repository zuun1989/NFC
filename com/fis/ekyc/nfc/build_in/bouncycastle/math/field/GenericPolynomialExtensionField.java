package com.fis.ekyc.nfc.build_in.bouncycastle.math.field;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import java.math.BigInteger;

class GenericPolynomialExtensionField implements PolynomialExtensionField {
    protected final Polynomial minimalPolynomial;
    protected final FiniteField subfield;

    public GenericPolynomialExtensionField(FiniteField finiteField, Polynomial polynomial) {
        this.subfield = finiteField;
        this.minimalPolynomial = polynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        if (!this.subfield.equals(genericPolynomialExtensionField.subfield) || !this.minimalPolynomial.equals(genericPolynomialExtensionField.minimalPolynomial)) {
            return false;
        }
        return true;
    }

    public BigInteger getCharacteristic() {
        return this.subfield.getCharacteristic();
    }

    public int getDegree() {
        return this.minimalPolynomial.getDegree();
    }

    public int getDimension() {
        return this.subfield.getDimension() * this.minimalPolynomial.getDegree();
    }

    public Polynomial getMinimalPolynomial() {
        return this.minimalPolynomial;
    }

    public FiniteField getSubfield() {
        return this.subfield;
    }

    public int hashCode() {
        return this.subfield.hashCode() ^ Integers.rotateLeft(this.minimalPolynomial.hashCode(), 16);
    }
}
