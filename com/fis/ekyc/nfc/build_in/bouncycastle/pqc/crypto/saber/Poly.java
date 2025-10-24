package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHAKEDigest;

class Poly {
    private static final int KARATSUBA_N = 64;
    private static int SCHB_N = 16;
    private final int N_RES;
    private final int N_SB;
    private final int N_SB_RES;
    private final int SABER_L;
    private final int SABER_N;
    private final SABEREngine engine;
    private final Utils utils;

    public Poly(SABEREngine sABEREngine) {
        this.engine = sABEREngine;
        this.SABER_L = sABEREngine.getSABER_L();
        int saber_n = sABEREngine.getSABER_N();
        this.SABER_N = saber_n;
        this.N_RES = saber_n << 1;
        int i = saber_n >> 2;
        this.N_SB = i;
        this.N_SB_RES = (i * 2) - 1;
        this.utils = sABEREngine.getUtils();
    }

    private short OVERFLOWING_MUL(int i, int i2) {
        return (short) (i * i2);
    }

    private void cbd(short[] sArr, byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        if (this.engine.getSABER_MU() == 6) {
            for (int i2 = 0; i2 < this.SABER_N / 4; i2++) {
                int load_littleendian = (int) load_littleendian(bArr2, i + (i2 * 3), 3);
                int i3 = 0;
                for (int i4 = 0; i4 < 3; i4++) {
                    i3 += (load_littleendian >> i4) & 2396745;
                }
                iArr[0] = i3 & 7;
                iArr[1] = (i3 >>> 6) & 7;
                iArr[2] = (i3 >>> 12) & 7;
                iArr[3] = (i3 >>> 18) & 7;
                int i5 = i2 * 4;
                sArr[i5] = (short) (iArr[0] - ((i3 >>> 3) & 7));
                sArr[i5 + 1] = (short) (iArr[1] - ((i3 >>> 9) & 7));
                sArr[i5 + 2] = (short) (iArr[2] - ((i3 >>> 15) & 7));
                sArr[i5 + 3] = (short) (iArr[3] - (i3 >>> 21));
            }
            return;
        }
        char c = 15;
        if (this.engine.getSABER_MU() == 8) {
            for (int i6 = 0; i6 < this.SABER_N / 4; i6++) {
                int i7 = i6 * 4;
                int load_littleendian2 = (int) load_littleendian(bArr2, i + i7, 4);
                int i8 = 0;
                for (int i9 = 0; i9 < 4; i9++) {
                    i8 += (load_littleendian2 >>> i9) & 286331153;
                }
                iArr[0] = i8 & 15;
                iArr[1] = (i8 >>> 8) & 15;
                iArr[2] = (i8 >>> 16) & 15;
                iArr[3] = (i8 >>> 24) & 15;
                sArr[i7] = (short) (iArr[0] - ((i8 >>> 4) & 15));
                sArr[i7 + 1] = (short) (iArr[1] - ((i8 >>> 12) & 15));
                sArr[i7 + 2] = (short) (iArr[2] - ((i8 >>> 20) & 15));
                sArr[i7 + 3] = (short) (iArr[3] - (i8 >>> 28));
            }
        } else if (this.engine.getSABER_MU() == 10) {
            int i10 = 0;
            while (i10 < this.SABER_N / 4) {
                long load_littleendian3 = load_littleendian(bArr2, i + (i10 * 5), 5);
                long j = 0;
                for (int i11 = 0; i11 < 5; i11++) {
                    j += (load_littleendian3 >>> i11) & 35468117025L;
                }
                iArr[0] = (int) (j & 31);
                iArr[1] = (int) ((j >>> 10) & 31);
                iArr[2] = (int) ((j >>> 20) & 31);
                iArr[3] = (int) ((j >>> 30) & 31);
                int i12 = i10 * 4;
                sArr[i12] = (short) (iArr[0] - ((int) ((j >>> 5) & 31)));
                sArr[i12 + 1] = (short) (iArr[1] - ((int) ((j >>> c) & 31)));
                sArr[i12 + 2] = (short) (iArr[2] - ((int) ((j >>> 25) & 31)));
                sArr[i12 + 3] = (short) (iArr[3] - ((int) (j >>> 35)));
                i10++;
                c = 15;
            }
        }
    }

    private void karatsuba_simple(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 31;
        int[] iArr4 = new int[31];
        int[] iArr5 = new int[31];
        int[] iArr6 = new int[31];
        int[] iArr7 = new int[63];
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 16];
            int i5 = iArr[i2 + 32];
            int i6 = iArr[i2 + 48];
            int i7 = 0;
            for (int i8 = 16; i7 < i8; i8 = 16) {
                int i9 = iArr2[i7];
                int i10 = iArr2[i7 + 16];
                int i11 = i2 + i7;
                iArr3[i11] = iArr3[i11] + OVERFLOWING_MUL(i3, i9);
                int i12 = i11 + 32;
                iArr3[i12] = iArr3[i12] + OVERFLOWING_MUL(i4, i10);
                int i13 = i9 + i10;
                int i14 = i10;
                int i15 = i3;
                int[] iArr8 = iArr7;
                iArr4[i11] = (int) (((long) iArr4[i11]) + (((long) i13) * ((long) (i3 + i4))));
                int i16 = iArr2[i7 + 32];
                int i17 = iArr2[i7 + 48];
                int i18 = i11 + 64;
                iArr3[i18] = iArr3[i18] + OVERFLOWING_MUL(i16, i5);
                int i19 = i11 + 96;
                iArr3[i19] = iArr3[i19] + OVERFLOWING_MUL(i17, i6);
                iArr6[i11] = iArr6[i11] + OVERFLOWING_MUL(i5 + i6, i16 + i17);
                int i20 = i9 + i16;
                int i21 = i15 + i5;
                iArr8[i11] = iArr8[i11] + OVERFLOWING_MUL(i20, i21);
                int i22 = i14 + i17;
                int i23 = i4 + i6;
                iArr8[i12] = iArr8[i12] + OVERFLOWING_MUL(i22, i23);
                iArr5[i11] = iArr5[i11] + OVERFLOWING_MUL(i20 + i22, i21 + i23);
                i7++;
                i3 = i15;
                i2 = i2;
                iArr7 = iArr8;
            }
            int[] iArr9 = iArr7;
            i2++;
            i = 31;
        }
        int[] iArr10 = iArr7;
        int i24 = 0;
        while (i24 < i) {
            int i25 = i24 + 32;
            iArr5[i24] = (iArr5[i24] - iArr10[i24]) - iArr10[i25];
            iArr4[i24] = (iArr4[i24] - iArr3[i24]) - iArr3[i25];
            iArr6[i24] = (iArr6[i24] - iArr3[i24 + 64]) - iArr3[i24 + 96];
            i24++;
            i = 31;
        }
        for (int i26 = 0; i26 < i; i26++) {
            int i27 = i26 + 16;
            iArr10[i27] = iArr10[i27] + iArr5[i26];
            iArr3[i27] = iArr3[i27] + iArr4[i26];
            int i28 = i26 + 80;
            iArr3[i28] = iArr3[i28] + iArr6[i26];
        }
        int i29 = 63;
        int i30 = 0;
        while (i30 < i29) {
            iArr10[i30] = (iArr10[i30] - iArr3[i30]) - iArr3[i30 + 64];
            i30++;
            i29 = 63;
        }
        for (int i31 = 0; i31 < i29; i31++) {
            int i32 = i31 + 32;
            iArr3[i32] = iArr3[i32] + iArr10[i31];
        }
    }

    private long load_littleendian(byte[] bArr, int i, int i2) {
        long j = (long) (bArr[i] & 255);
        for (int i3 = 1; i3 < i2; i3++) {
            j |= ((long) (bArr[i + i3] & 255)) << (i3 * 8);
        }
        return j;
    }

    private void poly_mul_acc(short[] sArr, short[] sArr2, short[] sArr3) {
        short[] sArr4 = new short[(this.SABER_N * 2)];
        toom_cook_4way(sArr, sArr2, sArr4);
        int i = this.SABER_N;
        while (true) {
            int i2 = this.SABER_N;
            if (i < i2 * 2) {
                int i3 = i - i2;
                sArr3[i3] = (short) (sArr3[i3] + (sArr4[i - i2] - sArr4[i]));
                i++;
            } else {
                return;
            }
        }
    }

    private void toom_cook_4way(short[] sArr, short[] sArr2, short[] sArr3) {
        int i = this.N_SB;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        int[] iArr5 = new int[i];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int[] iArr10 = new int[i];
        int[] iArr11 = new int[i];
        int[] iArr12 = new int[i];
        int[] iArr13 = new int[i];
        int[] iArr14 = new int[i];
        int i2 = this.N_SB_RES;
        int[] iArr15 = iArr8;
        int[] iArr16 = new int[i2];
        int[] iArr17 = new int[i2];
        int[] iArr18 = new int[i2];
        int[] iArr19 = new int[i2];
        int[] iArr20 = new int[i2];
        int[] iArr21 = new int[i2];
        int[] iArr22 = new int[i2];
        int i3 = 0;
        while (true) {
            int i4 = this.N_SB;
            if (i3 >= i4) {
                break;
            }
            short s = sArr[i3];
            short s2 = sArr[i3 + i4];
            short s3 = sArr[i3 + (i4 * 2)];
            short s4 = sArr[(i4 * 3) + i3];
            int[] iArr23 = iArr14;
            int i5 = (short) (s + s3);
            int[] iArr24 = iArr9;
            int i6 = (short) (s2 + s4);
            iArr3[i3] = (short) (i5 + i6);
            iArr4[i3] = (short) (i5 - i6);
            int i7 = (short) (((s << 2) + s3) << 1);
            int i8 = (short) ((s2 << 2) + s4);
            iArr5[i3] = (short) (i7 + i8);
            iArr6[i3] = (short) (i7 - i8);
            iArr2[i3] = (short) ((s4 << 3) + (s3 << 2) + (s2 << 1) + s);
            iArr7[i3] = s;
            iArr[i3] = s4;
            i3++;
            iArr14 = iArr23;
            iArr9 = iArr24;
            iArr13 = iArr13;
        }
        int[] iArr25 = iArr14;
        int[] iArr26 = iArr9;
        int[] iArr27 = iArr13;
        int i9 = 0;
        while (true) {
            int i10 = this.N_SB;
            if (i9 >= i10) {
                break;
            }
            short s5 = sArr2[i9];
            short s6 = sArr2[i9 + i10];
            short s7 = sArr2[(i10 * 2) + i9];
            short s8 = sArr2[(i10 * 3) + i9];
            int i11 = s5 + s7;
            int i12 = s6 + s8;
            iArr10[i9] = i11 + i12;
            iArr11[i9] = i11 - i12;
            int i13 = ((s5 << 2) + s7) << 1;
            int i14 = (s6 << 2) + s8;
            iArr12[i9] = i13 + i14;
            iArr27[i9] = i13 - i14;
            iArr26[i9] = (s8 << 3) + (s7 << 2) + (s6 << 1) + s5;
            iArr25[i9] = s5;
            iArr15[i9] = s8;
            i9++;
        }
        int[] iArr28 = iArr16;
        karatsuba_simple(iArr, iArr15, iArr28);
        int[] iArr29 = iArr17;
        karatsuba_simple(iArr2, iArr26, iArr29);
        int[] iArr30 = iArr18;
        karatsuba_simple(iArr3, iArr10, iArr30);
        int[] iArr31 = iArr19;
        karatsuba_simple(iArr4, iArr11, iArr31);
        int[] iArr32 = iArr20;
        karatsuba_simple(iArr5, iArr12, iArr32);
        int[] iArr33 = iArr21;
        karatsuba_simple(iArr6, iArr27, iArr33);
        int[] iArr34 = iArr22;
        karatsuba_simple(iArr7, iArr25, iArr34);
        for (int i15 = 0; i15 < this.N_SB_RES; i15++) {
            int i16 = iArr28[i15];
            int i17 = iArr29[i15];
            int i18 = iArr30[i15];
            int i19 = iArr31[i15];
            int i20 = iArr32[i15];
            int i21 = iArr33[i15];
            int i22 = iArr34[i15];
            int i23 = i21 - i20;
            int i24 = ((i19 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) - (i18 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)) >>> 1;
            int i25 = i18 + i24;
            int i26 = ((i17 + i20) - (i25 << 6)) - i25;
            int i27 = (i25 - i22) - i16;
            int i28 = i26 + (i27 * 45);
            int i29 = (((((((i20 - i16) - (i22 << 6)) << 1) + i23) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) - (i27 << 3)) * 43691) >> 3;
            int i30 = i23 + i28;
            int i31 = (((i28 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) + ((i24 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) << 4)) * 36409) >> 1;
            int i32 = ((((i31 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) * 30) - (i30 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)) * 61167) >> 2;
            int i33 = i27 - i29;
            int i34 = i31 - i32;
            sArr3[i15] = (short) (sArr3[i15] + (i22 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i35 = i15 + 64;
            sArr3[i35] = (short) (sArr3[i35] + (i32 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i36 = i15 + 128;
            sArr3[i36] = (short) (sArr3[i36] + (i29 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i37 = i15 + CertificateHolderAuthorization.CVCA;
            sArr3[i37] = (short) (sArr3[i37] + ((-(i24 + i31)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i38 = i15 + 256;
            sArr3[i38] = (short) (sArr3[i38] + (i33 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i39 = i15 + 320;
            sArr3[i39] = (short) (sArr3[i39] + (i34 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
            int i40 = i15 + 384;
            sArr3[i40] = (short) (sArr3[i40] + (i16 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH));
        }
    }

    public void GenMatrix(short[][][] sArr, byte[] bArr) {
        int saber_polyvecbytes = this.SABER_L * this.engine.getSABER_POLYVECBYTES();
        byte[] bArr2 = new byte[saber_polyvecbytes];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr, 0, this.engine.getSABER_SEEDBYTES());
        sHAKEDigest.doFinal(bArr2, 0, saber_polyvecbytes);
        for (int i = 0; i < this.SABER_L; i++) {
            this.utils.BS2POLVECq(bArr2, this.engine.getSABER_POLYVECBYTES() * i, sArr[i]);
        }
    }

    public void GenSecret(short[][] sArr, byte[] bArr) {
        int saber_polycoinbytes = this.SABER_L * this.engine.getSABER_POLYCOINBYTES();
        byte[] bArr2 = new byte[saber_polycoinbytes];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr, 0, this.engine.getSABER_NOISE_SEEDBYTES());
        sHAKEDigest.doFinal(bArr2, 0, saber_polycoinbytes);
        for (int i = 0; i < this.SABER_L; i++) {
            cbd(sArr[i], bArr2, this.engine.getSABER_POLYCOINBYTES() * i);
        }
    }

    public void InnerProd(short[][] sArr, short[][] sArr2, short[] sArr3) {
        for (int i = 0; i < this.SABER_L; i++) {
            poly_mul_acc(sArr[i], sArr2[i], sArr3);
        }
    }

    public void MatrixVectorMul(short[][][] sArr, short[][] sArr2, short[][] sArr3, int i) {
        for (int i2 = 0; i2 < this.SABER_L; i2++) {
            for (int i3 = 0; i3 < this.SABER_L; i3++) {
                if (i == 1) {
                    poly_mul_acc(sArr[i3][i2], sArr2[i3], sArr3[i2]);
                } else {
                    poly_mul_acc(sArr[i2][i3], sArr2[i3], sArr3[i2]);
                }
            }
        }
    }
}
