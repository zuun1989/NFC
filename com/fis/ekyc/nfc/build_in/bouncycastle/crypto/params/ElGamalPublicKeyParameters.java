package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {
    private BigInteger y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.y = bigInteger;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.y) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return this.y.hashCode() ^ super.hashCode();
    }
}
