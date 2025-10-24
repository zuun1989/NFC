package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.cmce;

class GF12 extends GF {
    public GF12(int i) {
        super(i);
    }

    public short gf_frac(short s, short s2) {
        return gf_mul(gf_inv(s), s2);
    }

    public short gf_inv(short s) {
        short gf_mul = gf_mul(gf_sq(s), s);
        short gf_mul2 = gf_mul(gf_sq(gf_sq(gf_mul)), gf_mul);
        return gf_sq(gf_mul(gf_sq(gf_mul(gf_sq(gf_sq(gf_mul(gf_sq(gf_sq(gf_sq(gf_sq(gf_mul2)))), gf_mul2))), gf_mul)), s));
    }

    public short gf_mul(short s, short s2) {
        int i = (s2 & 1) * s;
        int i2 = 1;
        while (true) {
            int i3 = this.GFBITS;
            if (i2 < i3) {
                i ^= ((1 << i2) & s2) * s;
                i2++;
            } else {
                int i4 = 8372224 & i;
                int i5 = (i4 >> 12) ^ ((i4 >> 9) ^ i);
                int i6 = i5 & 12288;
                return (short) (((i5 ^ (i6 >> 9)) ^ (i6 >> 12)) & ((1 << i3) - 1));
            }
        }
    }

    public short gf_sq(short s) {
        int[] iArr = {1431655765, 858993459, 252645135, 16711935};
        short s2 = (s | (s << 8)) & iArr[3];
        short s3 = (s2 | (s2 << 4)) & iArr[2];
        short s4 = (s3 | (s3 << 2)) & iArr[1];
        short s5 = (s4 | (s4 << 1)) & iArr[0];
        short s6 = 8372224 & s5;
        short s7 = (s5 ^ (s6 >> 9)) ^ (s6 >> 12);
        short s8 = s7 & 12288;
        return (short) (((s7 ^ (s8 >> 9)) ^ (s8 >> 12)) & ((1 << this.GFBITS) - 1));
    }
}
