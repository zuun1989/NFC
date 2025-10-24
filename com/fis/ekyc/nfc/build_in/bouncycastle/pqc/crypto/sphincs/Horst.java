package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIFailureInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;

class Horst {
    static final int HORST_K = 32;
    static final int HORST_LOGT = 16;
    static final int HORST_SIGBYTES = 13312;
    static final int HORST_SKBYTES = 32;
    static final int HORST_T = 65536;
    static final int N_MASKS = 32;

    public static void expand_seed(byte[] bArr, byte[] bArr2) {
        Seed.prg(bArr, 0, 2097152, bArr2, 0);
    }

    public static int horst_sign(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int i2;
        byte[] bArr6 = new byte[PKIFailureInfo.badSenderNonce];
        byte[] bArr7 = new byte[4194272];
        expand_seed(bArr6, bArr3);
        for (int i3 = 0; i3 < 65536; i3++) {
            hashFunctions.hash_n_n(bArr7, (Blake2xsDigest.UNKNOWN_DIGEST_LENGTH + i3) * 32, bArr6, i3 * 32);
        }
        HashFunctions hashFunctions2 = hashFunctions;
        for (int i4 = 0; i4 < 16; i4++) {
            long j = (long) ((1 << (16 - i4)) - 1);
            int i5 = 1 << (15 - i4);
            long j2 = (long) (i5 - 1);
            int i6 = 0;
            while (i6 < i5) {
                hashFunctions.hash_2n_n_mask(bArr7, (int) ((((long) i6) + j2) * 32), bArr7, (int) ((((long) (i6 * 2)) + j) * 32), bArr4, i4 * 64);
                i6++;
                i5 = i5;
                j2 = j2;
            }
        }
        int i7 = 2016;
        int i8 = i;
        while (i7 < 4064) {
            bArr[i8] = bArr7[i7];
            i7++;
            i8++;
        }
        for (int i9 = 0; i9 < 32; i9++) {
            int i10 = i9 * 2;
            int i11 = (bArr5[i10] & 255) + ((bArr5[i10 + 1] & 255) << 8);
            int i12 = 0;
            while (i12 < 32) {
                bArr[i8] = bArr6[(i11 * 32) + i12];
                i12++;
                i8++;
            }
            int i13 = i11 + Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            for (int i14 = 0; i14 < 10; i14++) {
                if ((i13 & 1) != 0) {
                    i2 = i13 + 1;
                } else {
                    i2 = i13 - 1;
                }
                int i15 = 0;
                while (i15 < 32) {
                    bArr[i8] = bArr7[(i2 * 32) + i15];
                    i15++;
                    i8++;
                }
                i13 = (i2 - 1) / 2;
            }
        }
        for (int i16 = 0; i16 < 32; i16++) {
            bArr2[i16] = bArr7[i16];
        }
        return HORST_SIGBYTES;
    }

    public static int horst_verify(HashFunctions hashFunctions, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        HashFunctions hashFunctions2 = hashFunctions;
        byte[] bArr5 = bArr2;
        int i2 = i;
        byte[] bArr6 = new byte[1024];
        int i3 = i2 + 2048;
        int i4 = 0;
        while (i4 < 32) {
            int i5 = i4 * 2;
            int i6 = (bArr4[i5] & 255) + ((bArr4[i5 + 1] & 255) << 8);
            if ((i6 & 1) == 0) {
                hashFunctions2.hash_n_n(bArr6, 0, bArr5, i3);
                for (int i7 = 0; i7 < 32; i7++) {
                    bArr6[i7 + 32] = bArr5[i3 + 32 + i7];
                }
            } else {
                hashFunctions2.hash_n_n(bArr6, 32, bArr5, i3);
                for (int i8 = 0; i8 < 32; i8++) {
                    bArr6[i8] = bArr5[i3 + 32 + i8];
                }
            }
            int i9 = i3 + 64;
            int i10 = 1;
            while (i10 < 10) {
                int i11 = i6 >>> 1;
                if ((i11 & 1) == 0) {
                    hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, (i10 - 1) * 64);
                    for (int i12 = 0; i12 < 32; i12++) {
                        bArr6[i12 + 32] = bArr5[i9 + i12];
                    }
                } else {
                    hashFunctions.hash_2n_n_mask(bArr6, 32, bArr6, 0, bArr3, (i10 - 1) * 64);
                    for (int i13 = 0; i13 < 32; i13++) {
                        bArr6[i13] = bArr5[i9 + i13];
                    }
                }
                i9 += 32;
                i10++;
                i6 = i11;
            }
            int i14 = i6 >>> 1;
            hashFunctions.hash_2n_n_mask(bArr6, 0, bArr6, 0, bArr3, 576);
            for (int i15 = 0; i15 < 32; i15++) {
                if (bArr5[(i14 * 32) + i2 + i15] != bArr6[i15]) {
                    for (int i16 = 0; i16 < 32; i16++) {
                        bArr[i16] = 0;
                    }
                    return -1;
                }
            }
            i4++;
            i3 = i9;
        }
        for (int i17 = 0; i17 < 32; i17++) {
            hashFunctions.hash_2n_n_mask(bArr6, i17 * 32, bArr2, i2 + (i17 * 64), bArr3, 640);
        }
        for (int i18 = 0; i18 < 16; i18++) {
            hashFunctions.hash_2n_n_mask(bArr6, i18 * 32, bArr6, i18 * 64, bArr3, 704);
        }
        for (int i19 = 0; i19 < 8; i19++) {
            hashFunctions.hash_2n_n_mask(bArr6, i19 * 32, bArr6, i19 * 64, bArr3, 768);
        }
        for (int i20 = 0; i20 < 4; i20++) {
            hashFunctions.hash_2n_n_mask(bArr6, i20 * 32, bArr6, i20 * 64, bArr3, 832);
        }
        for (int i21 = 0; i21 < 2; i21++) {
            hashFunctions.hash_2n_n_mask(bArr6, i21 * 32, bArr6, i21 * 64, bArr3, 896);
        }
        hashFunctions.hash_2n_n_mask(bArr, 0, bArr6, 0, bArr3, 960);
        return 0;
    }
}
