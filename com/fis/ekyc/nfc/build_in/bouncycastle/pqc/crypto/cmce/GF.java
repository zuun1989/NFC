package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.cmce;

abstract class GF {
    protected final int GFBITS;
    protected final int GFMASK;

    public GF(int i) {
        this.GFBITS = i;
        this.GFMASK = (1 << i) - 1;
    }

    public short gf_add(short s, short s2) {
        return (short) (s ^ s2);
    }

    public abstract short gf_frac(short s, short s2);

    public abstract short gf_inv(short s);

    public short gf_iszero(short s) {
        return (short) ((s - 1) >>> 19);
    }

    public abstract short gf_mul(short s, short s2);
}
