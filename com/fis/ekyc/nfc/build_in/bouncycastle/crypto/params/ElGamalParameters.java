package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import java.math.BigInteger;

public class ElGamalParameters implements CipherParameters {
    private BigInteger g;
    private int l;
    private BigInteger p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (!elGamalParameters.getP().equals(this.p) || !elGamalParameters.getG().equals(this.g) || elGamalParameters.getL() != this.l) {
            return false;
        }
        return true;
    }

    public BigInteger getG() {
        return this.g;
    }

    public int getL() {
        return this.l;
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.l;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.g = bigInteger2;
        this.p = bigInteger;
        this.l = i;
    }
}
