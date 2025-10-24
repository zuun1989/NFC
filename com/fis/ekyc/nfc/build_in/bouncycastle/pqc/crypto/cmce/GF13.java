package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.cmce;

class GF13 extends GF {
    public GF13(int i) {
        super(i);
    }

    private short gf_sq2mul(short s, short s2) {
        long[] jArr = {2301339409586323456L, 4494803534348288L, 8778913153024L, 17146314752L, 33423360, 122880};
        long j = (long) s;
        long j2 = (long) s2;
        long j3 = (j2 << 18) * (64 & j);
        long j4 = j ^ (j << 21);
        long j5 = ((j2 * (j4 & 8589934624L)) << 15) ^ (((((j3 ^ ((268435457 & j4) * j2)) ^ (((536870914 & j4) * j2) << 3)) ^ (((1073741828 & j4) * j2) << 6)) ^ (((2147483656L & j4) * j2) << 9)) ^ (((4294967312L & j4) * j2) << 12));
        for (int i = 0; i < 6; i++) {
            long j6 = jArr[i] & j5;
            j5 ^= (j6 >> 13) ^ (((j6 >> 9) ^ (j6 >> 10)) ^ (j6 >> 12));
        }
        return (short) ((int) (j5 & ((long) this.GFMASK)));
    }

    private short gf_sqmul(short s, short s2) {
        long[] jArr = {137170518016L, 267911168, 516096};
        long j = (long) s;
        long j2 = (long) s2;
        long j3 = (j2 << 6) * (64 & j);
        long j4 = j ^ (j << 7);
        long j5 = ((j2 * (j4 & 524320)) << 5) ^ (((((j3 ^ ((16385 & j4) * j2)) ^ (((32770 & j4) * j2) << 1)) ^ (((65540 & j4) * j2) << 2)) ^ (((131080 & j4) * j2) << 3)) ^ (((262160 & j4) * j2) << 4));
        for (int i = 0; i < 3; i++) {
            long j6 = jArr[i] & j5;
            j5 ^= (j6 >> 13) ^ (((j6 >> 9) ^ (j6 >> 10)) ^ (j6 >> 12));
        }
        return (short) ((int) (j5 & ((long) this.GFMASK)));
    }

    public short gf_frac(short s, short s2) {
        short gf_sqmul = gf_sqmul(s, s);
        short gf_sq2mul = gf_sq2mul(gf_sqmul, gf_sqmul);
        return gf_sqmul(gf_sq2mul(gf_sq2(gf_sq2mul(gf_sq2(gf_sq2mul), gf_sq2mul)), gf_sq2mul), s2);
    }

    public short gf_inv(short s) {
        return gf_frac(s, 1);
    }

    public short gf_mul(short s, short s2) {
        long j = (long) s;
        long j2 = (long) s2;
        long j3 = (1 & j2) * j;
        for (int i = 1; i < this.GFBITS; i++) {
            j3 ^= (((long) (1 << i)) & j2) * j;
        }
        long j4 = 33488896 & j3;
        long j5 = ((j4 >> 13) ^ (((j4 >> 9) ^ (j4 >> 10)) ^ (j4 >> 12))) ^ j3;
        long j6 = 57344 & j5;
        return (short) ((int) ((j5 ^ ((((j6 >> 10) ^ (j6 >> 9)) ^ (j6 >> 12)) ^ (j6 >> 13))) & ((long) this.GFMASK)));
    }

    public short gf_sq2(short s) {
        long[] jArr = {1229782938247303441L, 217020518514230019L, 4222189076152335L, 1095216660735L};
        long[] jArr2 = {561850441793536L, 1097364144128L, 2143289344, 4186112};
        long j = (long) s;
        long j2 = (j | (j << 24)) & jArr[3];
        long j3 = (j2 | (j2 << 12)) & jArr[2];
        long j4 = (j3 | (j3 << 6)) & jArr[1];
        long j5 = (j4 | (j4 << 3)) & jArr[0];
        for (int i = 0; i < 4; i++) {
            long j6 = jArr2[i] & j5;
            j5 ^= (j6 >> 13) ^ (((j6 >> 9) ^ (j6 >> 10)) ^ (j6 >> 12));
        }
        return (short) ((int) (((long) this.GFMASK) & j5));
    }
}
