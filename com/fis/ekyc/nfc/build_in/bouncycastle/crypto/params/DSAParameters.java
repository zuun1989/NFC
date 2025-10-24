package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import java.math.BigInteger;

public class DSAParameters implements CipherParameters {
    private BigInteger g;
    private BigInteger p;
    private BigInteger q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (!dSAParameters.getP().equals(this.p) || !dSAParameters.getQ().equals(this.q) || !dSAParameters.getG().equals(this.g)) {
            return false;
        }
        return true;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.g = bigInteger3;
        this.p = bigInteger;
        this.q = bigInteger2;
        this.validation = dSAValidationParameters;
    }
}
