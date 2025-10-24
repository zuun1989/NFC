package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Memoable;
import java.math.BigInteger;

public class CramerShoupParameters implements CipherParameters {
    private Digest H;
    private BigInteger g1;
    private BigInteger g2;
    private BigInteger p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.p = bigInteger;
        this.g1 = bigInteger2;
        this.g2 = bigInteger3;
        Digest digest2 = (Digest) ((Memoable) digest).copy();
        this.H = digest2;
        digest2.reset();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        if (!cramerShoupParameters.getP().equals(this.p) || !cramerShoupParameters.getG1().equals(this.g1) || !cramerShoupParameters.getG2().equals(this.g2)) {
            return false;
        }
        return true;
    }

    public BigInteger getG1() {
        return this.g1;
    }

    public BigInteger getG2() {
        return this.g2;
    }

    public Digest getH() {
        return (Digest) ((Memoable) this.H).copy();
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}
