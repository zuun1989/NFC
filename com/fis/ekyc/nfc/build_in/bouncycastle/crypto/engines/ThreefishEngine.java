package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    /* access modifiers changed from: private */
    public static int[] MOD17 = null;
    /* access modifiers changed from: private */
    public static int[] MOD3 = null;
    /* access modifiers changed from: private */
    public static int[] MOD5 = null;
    /* access modifiers changed from: private */
    public static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;
    private long[] t;

    public static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* JADX WARNING: type inference failed for: r80v0, types: [long[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void decryptBlock(long[] r79, long[] r80) {
            /*
                r78 = this;
                r0 = r78
                long[] r1 = r0.kw
                long[] r2 = r0.t
                int[] r3 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x050b
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x0505
                r5 = 0
                r7 = r79[r5]
                r9 = 1
                r10 = r79[r9]
                r12 = 2
                r13 = r79[r12]
                r15 = 3
                r16 = r79[r15]
                r15 = 4
                r18 = r79[r15]
                r20 = r79[r6]
                r22 = 6
                r23 = r79[r22]
                r25 = 7
                r26 = r79[r25]
                r12 = 8
                r28 = r79[r12]
                r5 = 9
                r30 = r79[r5]
                r12 = 10
                r32 = r79[r12]
                r34 = 11
                r35 = r79[r34]
                r12 = 12
                r37 = r79[r12]
                r6 = 13
                r39 = r79[r6]
                r41 = 14
                r42 = r79[r41]
                r44 = 15
                r45 = r79[r44]
                r12 = 19
            L_0x0052:
                if (r12 < r9) goto L_0x047d
                r47 = r3[r12]
                r48 = r4[r12]
                int r49 = r47 + 1
                r50 = r1[r49]
                long r7 = r7 - r50
                int r50 = r47 + 2
                r51 = r1[r50]
                long r10 = r10 - r51
                int r51 = r47 + 3
                r52 = r1[r51]
                long r13 = r13 - r52
                int r52 = r47 + 4
                r53 = r1[r52]
                r55 = r10
                long r9 = r16 - r53
                int r11 = r47 + 5
                r16 = r1[r11]
                long r5 = r18 - r16
                int r16 = r47 + 6
                r18 = r1[r16]
                r54 = r3
                r57 = r4
                long r3 = r20 - r18
                int r17 = r47 + 7
                r18 = r1[r17]
                r58 = r9
                long r9 = r23 - r18
                int r18 = r47 + 8
                r19 = r1[r18]
                r60 = r3
                long r3 = r26 - r19
                int r19 = r47 + 9
                r20 = r1[r19]
                r23 = r3
                long r3 = r28 - r20
                int r20 = r47 + 10
                r26 = r1[r20]
                r28 = r3
                long r3 = r30 - r26
                int r21 = r47 + 11
                r26 = r1[r21]
                r30 = r3
                long r3 = r32 - r26
                int r26 = r47 + 12
                r32 = r1[r26]
                r62 = r3
                long r3 = r35 - r32
                int r27 = r47 + 13
                r32 = r1[r27]
                r64 = r5
                long r5 = r37 - r32
                int r32 = r47 + 14
                r35 = r1[r32]
                int r33 = r48 + 1
                r37 = r2[r33]
                long r35 = r35 + r37
                r37 = r5
                long r5 = r39 - r35
                int r35 = r47 + 15
                r39 = r1[r35]
                int r36 = r48 + 2
                r66 = r2[r36]
                long r39 = r39 + r66
                r66 = r5
                long r5 = r42 - r39
                int r36 = r47 + 16
                r39 = r1[r36]
                r68 = r1
                long r0 = (long) r12
                long r39 = r39 + r0
                r42 = 1
                long r39 = r39 + r42
                r42 = r0
                long r0 = r45 - r39
                r15 = 9
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r15, r7)
                long r7 = r7 - r0
                r15 = 48
                long r3 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r3, r15, r13)
                long r13 = r13 - r3
                r15 = 35
                r70 = r11
                r69 = r12
                r11 = r66
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r15, r9)
                long r9 = r9 - r11
                r15 = 52
                r66 = r2
                r39 = r3
                r2 = r64
                r73 = r11
                r11 = r30
                r30 = r73
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r15, r2)
                long r2 = r2 - r11
                r4 = 23
                r45 = r11
                r11 = r55
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r4, r5)
                long r5 = r5 - r11
                r4 = 31
                r55 = r5
                r5 = r60
                r73 = r0
                r0 = r28
                r28 = r73
                long r5 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r5, r4, r0)
                long r0 = r0 - r5
                r15 = 37
                r60 = r5
                r4 = r58
                r58 = r0
                r0 = r62
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r15, r0)
                long r0 = r0 - r4
                r6 = 20
                r62 = r0
                r0 = r23
                r23 = r9
                r9 = r37
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                r6 = 31
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 44
                r37 = r0
                r0 = r60
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r13)
                long r13 = r13 - r0
                r6 = 47
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 46
                r64 = r0
                r0 = r23
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r0)
                long r0 = r0 - r11
                r23 = r11
                r11 = r28
                r6 = 19
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r9)
                long r9 = r9 - r11
                r6 = 42
                r28 = r4
                r4 = r30
                r30 = r9
                r9 = r55
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 44
                r55 = r9
                r9 = r39
                r39 = r2
                r2 = r58
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r2)
                long r2 = r2 - r9
                r6 = 25
                r58 = r2
                r2 = r45
                r45 = r11
                r11 = r62
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 16
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 34
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r13)
                long r13 = r13 - r4
                r6 = 56
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r0)
                long r0 = r0 - r9
                r6 = 51
                r62 = r4
                r4 = r39
                r39 = r9
                r9 = r45
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r4)
                long r4 = r4 - r9
                r6 = 4
                r73 = r9
                r9 = r37
                r37 = r73
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r11)
                long r11 = r11 - r9
                r6 = 53
                r45 = r11
                r11 = r28
                r28 = r2
                r2 = r30
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r6 = 42
                r30 = r2
                r2 = r64
                r73 = r0
                r0 = r55
                r55 = r73
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 41
                r64 = r0
                r0 = r23
                r23 = r9
                r9 = r58
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 9
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r13)
                long r13 = r13 - r11
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r15, r4)
                long r4 = r4 - r2
                r6 = 31
                r73 = r2
                r2 = r55
                r55 = r4
                r4 = r23
                r23 = r73
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 12
                r73 = r4
                r4 = r28
                r28 = r73
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 47
                r73 = r9
                r9 = r45
                r45 = r73
                r75 = r4
                r4 = r39
                r39 = r75
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 44
                r71 = r4
                r4 = r62
                r73 = r9
                r9 = r30
                r30 = r73
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 30
                r62 = r4
                r4 = r37
                r37 = r9
                r9 = r64
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r64 = r68[r47]
                long r7 = r7 - r64
                r64 = r68[r49]
                long r0 = r0 - r64
                r49 = r68[r50]
                long r13 = r13 - r49
                r49 = r68[r51]
                long r11 = r11 - r49
                r49 = r68[r52]
                r51 = r11
                long r11 = r55 - r49
                r49 = r68[r70]
                r55 = r0
                long r0 = r23 - r49
                r23 = r68[r16]
                long r2 = r2 - r23
                r16 = r68[r17]
                r23 = r0
                long r0 = r28 - r16
                r16 = r68[r18]
                r28 = r0
                long r0 = r45 - r16
                r16 = r68[r19]
                r18 = r0
                long r0 = r39 - r16
                r16 = r68[r20]
                r39 = r0
                long r0 = r30 - r16
                r16 = r68[r21]
                r20 = r0
                long r0 = r71 - r16
                r16 = r68[r26]
                r30 = r11
                long r11 = r37 - r16
                r16 = r68[r27]
                r26 = r66[r48]
                long r16 = r16 + r26
                r26 = r11
                long r11 = r62 - r16
                r16 = r68[r32]
                r32 = r66[r33]
                long r16 = r16 + r32
                long r9 = r9 - r16
                r16 = r68[r35]
                long r16 = r16 + r42
                long r4 = r4 - r16
                r6 = 5
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r7)
                long r7 = r7 - r4
                r6 = 20
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r13)
                long r13 = r13 - r0
                r6 = 48
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r16 = r0
                r0 = r30
                r6 = 41
                r30 = r11
                r11 = r39
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r0)
                long r0 = r0 - r11
                r32 = r11
                r11 = r55
                r6 = 47
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r9)
                long r9 = r9 - r11
                r6 = 28
                r35 = r9
                r9 = r23
                r73 = r4
                r4 = r18
                r18 = r73
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r4)
                long r4 = r4 - r9
                r23 = r2
                r2 = r20
                r6 = 16
                r20 = r4
                r4 = r51
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 25
                r37 = r2
                r2 = r28
                r73 = r11
                r11 = r26
                r26 = r73
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 33
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 4
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r13)
                long r13 = r13 - r9
                r6 = 51
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 13
                r73 = r4
                r4 = r26
                r26 = r73
                r75 = r9
                r9 = r23
                r23 = r75
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 34
                r28 = r4
                r4 = r18
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r11)
                long r11 = r11 - r4
                r18 = r11
                r11 = r30
                r6 = 41
                r30 = r2
                r2 = r35
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r2)
                long r2 = r2 - r11
                r6 = 59
                r35 = r2
                r2 = r16
                r16 = r0
                r0 = r20
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 17
                r20 = r0
                r0 = r32
                r32 = r4
                r4 = r37
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 38
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 19
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r11, r6, r13)
                long r13 = r13 - r11
                r6 = 10
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 55
                r37 = r11
                r11 = r16
                r16 = r2
                r2 = r32
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r11)
                long r11 = r11 - r2
                r6 = 49
                r32 = r2
                r2 = r30
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r4)
                long r4 = r4 - r2
                r6 = 18
                r30 = r4
                r4 = r26
                r73 = r0
                r0 = r18
                r18 = r73
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 23
                r26 = r0
                r0 = r23
                r23 = r2
                r2 = r35
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r2)
                long r2 = r2 - r0
                r6 = 52
                r35 = r2
                r2 = r28
                r73 = r9
                r9 = r20
                r20 = r73
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 24
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 13
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r13)
                long r13 = r13 - r4
                r6 = 8
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r11)
                long r11 = r11 - r0
                r15 = 47
                r73 = r0
                r0 = r23
                r23 = r73
                r75 = r7
                r6 = r20
                r20 = r75
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r15, r6)
                long r6 = r6 - r0
                r8 = 8
                r73 = r0
                r0 = r18
                r18 = r73
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r8, r9)
                long r8 = r9 - r0
                r10 = 17
                r39 = r0
                r0 = r16
                r15 = r2
                r2 = r30
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r10, r2)
                long r2 = r2 - r0
                r10 = 22
                r30 = r0
                r0 = r37
                r73 = r2
                r2 = r26
                r26 = r73
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r10, r2)
                long r37 = r2 - r0
                r28 = r0
                r0 = r32
                r2 = 37
                r32 = r4
                r3 = r35
                long r45 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r2, r3)
                long r42 = r3 - r45
                int r0 = r69 + -2
                r35 = r30
                r30 = r39
                r3 = r54
                r4 = r57
                r2 = r66
                r1 = r68
                r5 = 9
                r39 = r28
                r28 = r8
                r9 = 1
                r73 = r0
                r0 = r78
                r74 = r11
                r12 = r73
                r10 = r15
                r16 = r32
                r15 = 4
                r32 = r26
                r26 = r18
                r18 = r74
                r76 = r20
                r20 = r23
                r23 = r6
                r7 = r76
                goto L_0x0052
            L_0x047d:
                r68 = r1
                r66 = r2
                r0 = 0
                r1 = r68[r0]
                long r7 = r7 - r1
                r0 = 1
                r1 = r68[r0]
                long r10 = r10 - r1
                r0 = 2
                r1 = r68[r0]
                long r13 = r13 - r1
                r0 = 3
                r1 = r68[r0]
                long r16 = r16 - r1
                r0 = 4
                r1 = r68[r0]
                long r18 = r18 - r1
                r0 = 5
                r1 = r68[r0]
                long r20 = r20 - r1
                r0 = r68[r22]
                long r23 = r23 - r0
                r0 = r68[r25]
                long r26 = r26 - r0
                r0 = 8
                r1 = r68[r0]
                long r28 = r28 - r1
                r0 = 9
                r1 = r68[r0]
                long r30 = r30 - r1
                r0 = 10
                r1 = r68[r0]
                long r32 = r32 - r1
                r0 = r68[r34]
                long r35 = r35 - r0
                r0 = 12
                r1 = r68[r0]
                long r37 = r37 - r1
                r0 = 13
                r1 = r68[r0]
                r0 = 0
                r3 = r66[r0]
                long r1 = r1 + r3
                long r39 = r39 - r1
                r1 = r68[r41]
                r3 = 1
                r4 = r66[r3]
                long r1 = r1 + r4
                long r42 = r42 - r1
                r1 = r68[r44]
                long r45 = r45 - r1
                r80[r0] = r7
                r80[r3] = r10
                r0 = 2
                r80[r0] = r13
                r0 = 3
                r80[r0] = r16
                r0 = 4
                r80[r0] = r18
                r0 = 5
                r80[r0] = r20
                r80[r22] = r23
                r80[r25] = r26
                r0 = 8
                r80[r0] = r28
                r0 = 9
                r80[r0] = r30
                r0 = 10
                r80[r0] = r32
                r80[r34] = r35
                r0 = 12
                r80[r0] = r37
                r0 = 13
                r80[r0] = r39
                r80[r41] = r42
                r80[r44] = r45
                return
            L_0x0505:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x050b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.decryptBlock(long[], long[]):void");
        }

        /* JADX WARNING: type inference failed for: r90v0, types: [long[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encryptBlock(long[] r89, long[] r90) {
            /*
                r88 = this;
                r0 = r88
                long[] r1 = r0.kw
                long[] r2 = r0.t
                int[] r3 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x04d2
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x04cc
                r5 = 0
                r7 = r89[r5]
                r9 = 1
                r10 = r89[r9]
                r12 = 2
                r13 = r89[r12]
                r15 = 3
                r16 = r89[r15]
                r15 = 4
                r19 = r89[r15]
                r21 = r89[r6]
                r23 = 6
                r24 = r89[r23]
                r26 = 7
                r27 = r89[r26]
                r6 = 8
                r30 = r89[r6]
                r6 = 9
                r33 = r89[r6]
                r6 = 10
                r36 = r89[r6]
                r38 = 11
                r39 = r89[r38]
                r6 = 12
                r42 = r89[r6]
                r6 = 13
                r45 = r89[r6]
                r47 = 14
                r48 = r89[r47]
                r50 = 15
                r51 = r89[r50]
                r53 = r1[r5]
                long r7 = r7 + r53
                r53 = r1[r9]
                long r10 = r10 + r53
                r53 = r1[r12]
                long r13 = r13 + r53
                r18 = 3
                r53 = r1[r18]
                long r16 = r16 + r53
                r53 = r1[r15]
                long r19 = r19 + r53
                r29 = 5
                r53 = r1[r29]
                long r21 = r21 + r53
                r53 = r1[r23]
                long r24 = r24 + r53
                r53 = r1[r26]
                long r27 = r27 + r53
                r32 = 8
                r53 = r1[r32]
                long r30 = r30 + r53
                r35 = 9
                r53 = r1[r35]
                long r33 = r33 + r53
                r41 = 10
                r53 = r1[r41]
                long r36 = r36 + r53
                r53 = r1[r38]
                long r39 = r39 + r53
                r44 = 12
                r53 = r1[r44]
                long r42 = r42 + r53
                r53 = r1[r6]
                r55 = r2[r5]
                long r53 = r53 + r55
                long r45 = r45 + r53
                r53 = r1[r47]
                r55 = r2[r9]
                long r53 = r53 + r55
                long r48 = r48 + r53
                r53 = r1[r50]
                long r51 = r51 + r53
                r5 = r16
                r57 = r21
                r59 = r27
                r61 = r33
                r63 = r39
                r65 = r45
                r67 = r51
            L_0x00b2:
                r12 = 20
                if (r9 >= r12) goto L_0x048f
                r27 = r3[r9]
                r28 = r4[r9]
                long r7 = r7 + r10
                r12 = 24
                long r10 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r12, r7)
                long r13 = r13 + r5
                r12 = 13
                long r5 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r12, r13)
                r12 = r1
                r33 = r3
                r34 = r4
                r3 = r57
                long r0 = r19 + r3
                r15 = 8
                long r3 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r15, r0)
                r40 = r9
                r45 = r10
                r51 = r12
                r9 = r59
                long r11 = r24 + r9
                r15 = 47
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r15, r11)
                r52 = r2
                r19 = r3
                r53 = r5
                r2 = r61
                long r4 = r30 + r2
                r6 = 8
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r4)
                r24 = r4
                r55 = r9
                r4 = r63
                long r9 = r36 + r4
                r6 = 17
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r6, r9)
                r57 = r0
                r30 = r9
                r9 = r65
                long r0 = r42 + r9
                r6 = 22
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r0)
                r36 = r0
                r59 = r4
                r0 = r67
                long r4 = r48 + r0
                r6 = 37
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r4)
                long r7 = r7 + r2
                r6 = 38
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r7)
                long r13 = r13 + r9
                r6 = 19
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r13)
                long r11 = r11 + r59
                r48 = r2
                r2 = r59
                r6 = 10
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r11)
                r59 = r2
                long r2 = r57 + r0
                r6 = 55
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r2)
                r57 = r9
                long r9 = r30 + r55
                r6 = 49
                r30 = r0
                r0 = r55
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r9)
                r55 = r9
                long r9 = r36 + r53
                r6 = 18
                r36 = r11
                r11 = r53
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r11, r6, r9)
                long r4 = r4 + r19
                r6 = 23
                r53 = r9
                r9 = r19
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r4)
                r19 = r4
                long r4 = r24 + r45
                r6 = 52
                r24 = r2
                r2 = r45
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r4)
                long r7 = r7 + r0
                r6 = 33
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r7)
                long r13 = r13 + r9
                r6 = 4
                long r9 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r9, r6, r13)
                r45 = r0
                long r0 = r24 + r11
                r6 = 51
                long r11 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r11, r6, r0)
                r24 = r11
                long r11 = r36 + r2
                r6 = 13
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r11)
                r36 = r9
                long r9 = r53 + r30
                r6 = 34
                r53 = r2
                r2 = r30
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r9)
                r30 = r9
                long r9 = r19 + r57
                r6 = 41
                r19 = r0
                r0 = r57
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r9)
                long r4 = r4 + r59
                r15 = 59
                r61 = r7
                r6 = r59
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r15, r4)
                r58 = r9
                long r8 = r55 + r48
                r15 = 17
                r55 = r11
                r10 = r48
                long r10 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r15, r8)
                r48 = r8
                long r8 = r61 + r2
                r15 = 5
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r15, r8)
                long r13 = r13 + r6
                r15 = 20
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r15, r13)
                r60 = r13
                long r12 = r55 + r0
                r14 = 48
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r14, r12)
                long r14 = r19 + r10
                r19 = r2
                r2 = 41
                long r10 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r2, r14)
                long r2 = r58 + r53
                r55 = r0
                r0 = 47
                r84 = r6
                r6 = r53
                r53 = r84
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r0, r2)
                long r4 = r4 + r36
                r0 = 28
                r58 = r2
                r1 = r36
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r1, r0, r4)
                long r2 = r48 + r24
                r36 = r10
                r10 = 16
                r48 = r4
                r4 = r24
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r10, r2)
                long r10 = r30 + r45
                r30 = r2
                r2 = 25
                r62 = r12
                r12 = r45
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r2, r10)
                r12 = r51[r27]
                long r8 = r8 + r12
                int r12 = r27 + 1
                r45 = r51[r12]
                long r6 = r6 + r45
                int r13 = r27 + 2
                r45 = r51[r13]
                long r45 = r60 + r45
                int r25 = r27 + 3
                r60 = r51[r25]
                long r4 = r4 + r60
                int r60 = r27 + 4
                r64 = r51[r60]
                long r14 = r14 + r64
                int r61 = r27 + 5
                r64 = r51[r61]
                long r0 = r0 + r64
                int r64 = r27 + 6
                r65 = r51[r64]
                long r62 = r62 + r65
                int r65 = r27 + 7
                r66 = r51[r65]
                long r2 = r2 + r66
                int r66 = r27 + 8
                r67 = r51[r66]
                long r48 = r48 + r67
                int r67 = r27 + 9
                r68 = r51[r67]
                r70 = r12
                r71 = r13
                long r12 = r36 + r68
                int r36 = r27 + 10
                r68 = r51[r36]
                long r30 = r30 + r68
                int r37 = r27 + 11
                r68 = r51[r37]
                r72 = r12
                long r12 = r53 + r68
                int r53 = r27 + 12
                r68 = r51[r53]
                long r10 = r10 + r68
                int r54 = r27 + 13
                r68 = r51[r54]
                r74 = r52[r28]
                long r68 = r68 + r74
                r74 = r10
                long r10 = r55 + r68
                int r55 = r27 + 14
                r68 = r51[r55]
                int r56 = r28 + 1
                r76 = r52[r56]
                long r68 = r68 + r76
                long r58 = r58 + r68
                int r68 = r27 + 15
                r76 = r51[r68]
                r78 = r10
                r80 = r12
                r10 = r40
                long r11 = (long) r10
                long r76 = r76 + r11
                r82 = r11
                long r10 = r19 + r76
                long r12 = r8 + r6
                r8 = 41
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r8, r12)
                long r8 = r45 + r4
                r19 = r6
                r6 = 9
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r6, r8)
                long r14 = r14 + r0
                r6 = 37
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r14)
                long r6 = r62 + r2
                r45 = r0
                r0 = 31
                long r1 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r0, r6)
                r62 = r1
                long r0 = r48 + r72
                r48 = r4
                r3 = r72
                r2 = 12
                long r3 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r2, r0)
                r72 = r6
                long r5 = r30 + r80
                r30 = r3
                r2 = r80
                r7 = 47
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r7, r5)
                r76 = r5
                long r4 = r74 + r78
                r7 = 44
                r74 = r0
                r0 = r78
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r7, r4)
                long r6 = r58 + r10
                r58 = r4
                r4 = 30
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r4, r6)
                long r12 = r12 + r30
                r10 = 16
                r84 = r6
                r6 = r30
                r30 = r84
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r10, r12)
                long r8 = r8 + r0
                r10 = 34
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r10, r8)
                long r10 = r72 + r2
                r72 = r6
                r6 = 56
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r6, r10)
                long r14 = r14 + r4
                r2 = 51
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r2, r14)
                long r2 = r76 + r62
                r76 = r6
                r6 = 4
                r84 = r0
                r0 = r62
                r62 = r84
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r2)
                long r6 = r58 + r48
                r58 = r2
                r2 = 53
                r78 = r4
                r3 = r48
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r2, r6)
                long r2 = r30 + r45
                r30 = r6
                r6 = 42
                r48 = r10
                r10 = r45
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r6, r2)
                long r10 = r74 + r19
                r45 = r2
                r2 = 41
                r84 = r4
                r3 = r19
                r19 = r84
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r3, r2, r10)
                long r12 = r12 + r0
                r2 = 31
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r12)
                r84 = r45
                r45 = r58
                r58 = r84
                long r8 = r8 + r6
                r2 = 44
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r2, r8)
                long r14 = r14 + r19
                r2 = 47
                r84 = r0
                r0 = r19
                r19 = r84
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r14)
                long r2 = r48 + r4
                r48 = r0
                r0 = 46
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r0, r2)
                long r4 = r30 + r78
                r30 = r6
                r6 = 19
                r74 = r0
                r0 = r78
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r4)
                long r6 = r58 + r62
                r57 = r4
                r4 = 42
                r78 = r14
                r14 = r62
                long r4 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r4, r6)
                long r10 = r10 + r76
                r14 = 44
                r62 = r6
                r6 = r76
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r14, r10)
                long r14 = r45 + r72
                r45 = r10
                r10 = 25
                r76 = r2
                r2 = r72
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r10, r14)
                long r12 = r12 + r0
                r10 = 9
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r10, r12)
                long r8 = r8 + r6
                r10 = 48
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r10, r8)
                long r10 = r76 + r4
                r72 = r0
                r0 = 35
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r4, r0, r10)
                long r4 = r78 + r2
                r76 = r0
                r0 = 52
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r0, r4)
                long r2 = r62 + r74
                r62 = r6
                r6 = 23
                r78 = r0
                r0 = r74
                long r0 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r6, r2)
                long r6 = r45 + r30
                r45 = r2
                r2 = 31
                r84 = r10
                r10 = r30
                r30 = r84
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r10, r2, r6)
                long r14 = r14 + r48
                r42 = r6
                r6 = r48
                r10 = 37
                long r6 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r6, r10, r14)
                long r10 = r57 + r19
                r48 = r14
                r14 = 20
                r84 = r2
                r2 = r19
                r19 = r84
                long r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.rotlXor(r2, r14, r10)
                r14 = r51[r70]
                long r12 = r12 + r14
                r14 = r51[r71]
                long r0 = r0 + r14
                r14 = r51[r25]
                long r8 = r8 + r14
                r14 = r51[r60]
                long r6 = r6 + r14
                r14 = r51[r61]
                long r4 = r4 + r14
                r14 = r51[r64]
                long r57 = r19 + r14
                r14 = r51[r65]
                long r14 = r30 + r14
                r19 = r51[r66]
                long r59 = r2 + r19
                r2 = r51[r67]
                long r30 = r42 + r2
                r2 = r51[r36]
                long r2 = r78 + r2
                r19 = r51[r37]
                long r36 = r48 + r19
                r19 = r51[r53]
                long r63 = r62 + r19
                r19 = r51[r54]
                long r42 = r10 + r19
                r10 = r51[r55]
                r19 = r52[r56]
                long r10 = r10 + r19
                long r65 = r76 + r10
                r10 = r51[r68]
                r19 = 2
                int r28 = r28 + 2
                r19 = r52[r28]
                long r10 = r10 + r19
                long r48 = r45 + r10
                r10 = 16
                int r27 = r27 + 16
                r10 = r51[r27]
                long r10 = r10 + r82
                r19 = 1
                long r10 = r10 + r19
                long r67 = r72 + r10
                int r10 = r40 + 2
                r61 = r2
                r19 = r4
                r5 = r6
                r24 = r14
                r3 = r33
                r4 = r34
                r2 = r52
                r15 = 4
                r84 = r0
                r0 = r88
                r1 = r51
                r86 = r8
                r9 = r10
                r10 = r84
                r7 = r12
                r13 = r86
                goto L_0x00b2
            L_0x048f:
                r15 = r5
                r11 = r10
                r27 = r59
                r2 = r61
                r4 = r63
                r9 = r65
                r0 = r67
                r6 = 0
                r90[r6] = r7
                r6 = 1
                r90[r6] = r11
                r6 = 2
                r90[r6] = r13
                r6 = 3
                r90[r6] = r15
                r6 = 4
                r90[r6] = r19
                r6 = 5
                r90[r6] = r57
                r90[r23] = r24
                r90[r26] = r27
                r6 = 8
                r90[r6] = r30
                r6 = 9
                r90[r6] = r2
                r2 = 10
                r90[r2] = r36
                r90[r38] = r4
                r2 = 12
                r90[r2] = r42
                r2 = 13
                r90[r2] = r9
                r90[r47] = r48
                r90[r50] = r0
                return
            L_0x04cc:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04d2:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.encryptBlock(long[], long[]):void");
        }
    }

    public static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                boolean z = false;
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                int i = 17;
                for (int i2 = 1; i >= i2; i2 = 1) {
                    int i3 = access$000[i];
                    int i4 = access$100[i];
                    int i5 = i3 + 1;
                    long j5 = j - jArr3[i5];
                    int i6 = i3 + 2;
                    int i7 = i4 + 1;
                    long j6 = j2 - (jArr3[i6] + jArr4[i7]);
                    int i8 = i3 + 3;
                    long j7 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                    long j8 = (long) i;
                    long xorRotr = ThreefishEngine.xorRotr(j4 - ((jArr3[i3 + 4] + j8) + 1), 32, j5);
                    long j9 = j5 - xorRotr;
                    int[] iArr = access$000;
                    long xorRotr2 = ThreefishEngine.xorRotr(j6, 32, j7);
                    long j10 = j7 - xorRotr2;
                    long xorRotr3 = ThreefishEngine.xorRotr(xorRotr2, 58, j9);
                    long j11 = j9 - xorRotr3;
                    long xorRotr4 = ThreefishEngine.xorRotr(xorRotr, 22, j10);
                    long j12 = j10 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr4, 46, j11);
                    long j13 = j11 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr3, 12, j12);
                    long j14 = j12 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr6, 25, j13);
                    long xorRotr8 = ThreefishEngine.xorRotr(xorRotr5, 33, j14);
                    long j15 = (j13 - xorRotr7) - jArr3[i3];
                    long j16 = xorRotr7 - (jArr3[i5] + jArr4[i4]);
                    long j17 = (j14 - xorRotr8) - (jArr3[i6] + jArr4[i7]);
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr8 - (jArr3[i8] + j8), 5, j15);
                    long j18 = j15 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(j16, 37, j17);
                    long j19 = j17 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr10, 23, j18);
                    long j20 = j18 - xorRotr11;
                    long xorRotr12 = ThreefishEngine.xorRotr(xorRotr9, 40, j19);
                    long j21 = j19 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr12, 52, j20);
                    long j22 = j20 - xorRotr13;
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr11, 57, j21);
                    long j23 = j21 - xorRotr14;
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr14, 14, j22);
                    j = j22 - xorRotr15;
                    j4 = ThreefishEngine.xorRotr(xorRotr13, 16, j23);
                    j3 = j23 - j4;
                    i -= 2;
                    j2 = xorRotr15;
                    access$000 = iArr;
                    access$100 = access$100;
                    z = false;
                }
                char c = z;
                long j24 = j2 - (jArr3[1] + jArr4[c]);
                long j25 = j3 - (jArr3[2] + jArr4[1]);
                jArr2[c] = j - jArr3[c];
                jArr2[1] = j24;
                jArr2[2] = j25;
                jArr2[3] = j4 - jArr3[3];
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = j + jArr3[0];
                long j6 = j2 + jArr3[1] + jArr4[0];
                long j7 = j3 + jArr3[2] + jArr4[1];
                int i = 1;
                long j8 = j4 + jArr3[3];
                while (i < 18) {
                    int i2 = access$000[i];
                    int i3 = access$100[i];
                    long j9 = j5 + j6;
                    long rotlXor = ThreefishEngine.rotlXor(j6, 14, j9);
                    long j10 = j7 + j8;
                    long rotlXor2 = ThreefishEngine.rotlXor(j8, 16, j10);
                    long j11 = j9 + rotlXor2;
                    long rotlXor3 = ThreefishEngine.rotlXor(rotlXor2, 52, j11);
                    long j12 = j10 + rotlXor;
                    long rotlXor4 = ThreefishEngine.rotlXor(rotlXor, 57, j12);
                    long j13 = j11 + rotlXor4;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor4, 23, j13);
                    long j14 = j12 + rotlXor3;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor3, 40, j14);
                    long j15 = j13 + rotlXor6;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor6, 5, j15);
                    long j16 = j14 + rotlXor5;
                    long rotlXor8 = ThreefishEngine.rotlXor(rotlXor5, 37, j16);
                    long j17 = j15 + jArr3[i2];
                    int i4 = i2 + 1;
                    long j18 = rotlXor8 + jArr3[i4] + jArr4[i3];
                    int i5 = i2 + 2;
                    int i6 = i3 + 1;
                    long j19 = j16 + jArr3[i5] + jArr4[i6];
                    int i7 = i2 + 3;
                    int[] iArr = access$000;
                    long j20 = (long) i;
                    long j21 = rotlXor7 + jArr3[i7] + j20;
                    long j22 = j17 + j18;
                    long rotlXor9 = ThreefishEngine.rotlXor(j18, 25, j22);
                    long j23 = j19 + j21;
                    long rotlXor10 = ThreefishEngine.rotlXor(j21, 33, j23);
                    long j24 = j22 + rotlXor10;
                    long rotlXor11 = ThreefishEngine.rotlXor(rotlXor10, 46, j24);
                    long j25 = j23 + rotlXor9;
                    long rotlXor12 = ThreefishEngine.rotlXor(rotlXor9, 12, j25);
                    long j26 = j24 + rotlXor12;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor12, 58, j26);
                    long j27 = j25 + rotlXor11;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor11, 22, j27);
                    long j28 = j26 + rotlXor14;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor14, 32, j28);
                    long j29 = j27 + rotlXor13;
                    long rotlXor16 = ThreefishEngine.rotlXor(rotlXor13, 32, j29);
                    j5 = j28 + jArr3[i4];
                    j6 = rotlXor16 + jArr3[i5] + jArr4[i6];
                    j7 = j29 + jArr3[i7] + jArr4[i3 + 2];
                    j8 = rotlXor15 + jArr3[i2 + 4] + j20 + 1;
                    i += 2;
                    access$000 = iArr;
                    access$100 = access$100;
                }
                jArr2[0] = j5;
                jArr2[1] = j6;
                jArr2[2] = j7;
                jArr2[3] = j8;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        public Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                boolean z = false;
                long j = jArr[0];
                int i = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                int i2 = 17;
                while (i2 >= i) {
                    int i3 = access$200[i2];
                    int i4 = access$100[i2];
                    int i5 = i3 + 1;
                    long j9 = j - jArr3[i5];
                    int i6 = i3 + 2;
                    long j10 = j2 - jArr3[i6];
                    int i7 = i3 + 3;
                    long j11 = j3 - jArr3[i7];
                    int i8 = i3 + 4;
                    long j12 = j4 - jArr3[i8];
                    int i9 = i3 + 5;
                    long j13 = j5 - jArr3[i9];
                    int i10 = i3 + 6;
                    int i11 = i4 + 1;
                    long j14 = j6 - (jArr3[i10] + jArr4[i11]);
                    int i12 = i3 + 7;
                    int[] iArr = access$200;
                    int[] iArr2 = access$100;
                    long j15 = j7 - (jArr3[i12] + jArr4[i4 + 2]);
                    long[] jArr5 = jArr3;
                    long j16 = (long) i2;
                    long j17 = j16;
                    int i13 = i2;
                    long j18 = j12;
                    long xorRotr = ThreefishEngine.xorRotr(j10, 8, j15);
                    long j19 = j15 - xorRotr;
                    long xorRotr2 = ThreefishEngine.xorRotr(j8 - ((jArr3[i3 + 8] + j16) + 1), 35, j9);
                    long j20 = j9 - xorRotr2;
                    long j21 = xorRotr2;
                    long j22 = j11;
                    long xorRotr3 = ThreefishEngine.xorRotr(j14, 56, j22);
                    long j23 = j22 - xorRotr3;
                    long xorRotr4 = ThreefishEngine.xorRotr(j18, 22, j13);
                    long j24 = j13 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr, 25, j24);
                    long j25 = j24 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr4, 29, j19);
                    long j26 = j19 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr3, 39, j20);
                    long j27 = xorRotr6;
                    long j28 = j21;
                    long j29 = j20 - xorRotr7;
                    long j30 = j23;
                    long xorRotr8 = ThreefishEngine.xorRotr(j28, 43, j30);
                    long j31 = j30 - xorRotr8;
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr5, 13, j31);
                    long j32 = j31 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(xorRotr8, 50, j25);
                    long j33 = j25 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr7, 10, j26);
                    long j34 = j27;
                    long[] jArr6 = jArr4;
                    long j35 = j29;
                    long j36 = xorRotr10;
                    long xorRotr12 = ThreefishEngine.xorRotr(j34, 17, j35);
                    long j37 = j35 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr9, 39, j37);
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr12, 30, j32);
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr11, 34, j33);
                    long j38 = j33 - xorRotr15;
                    long j39 = j36;
                    long j40 = xorRotr15;
                    long j41 = j26 - xorRotr11;
                    long xorRotr16 = ThreefishEngine.xorRotr(j39, 24, j41);
                    long j42 = (j37 - xorRotr13) - jArr5[i3];
                    long j43 = xorRotr13 - jArr5[i5];
                    long j44 = (j32 - xorRotr14) - jArr5[i6];
                    long j45 = xorRotr14 - jArr5[i7];
                    long j46 = j38 - jArr5[i8];
                    long j47 = j45;
                    long j48 = (j41 - xorRotr16) - (jArr5[i10] + jArr6[i11]);
                    long xorRotr17 = ThreefishEngine.xorRotr(j43, 44, j48);
                    long j49 = j48 - xorRotr17;
                    long xorRotr18 = ThreefishEngine.xorRotr(xorRotr16 - (jArr5[i12] + j17), 9, j42);
                    long j50 = j42 - xorRotr18;
                    long xorRotr19 = ThreefishEngine.xorRotr(j40 - (jArr5[i9] + jArr6[i4]), 54, j44);
                    long j51 = j44 - xorRotr19;
                    long xorRotr20 = ThreefishEngine.xorRotr(j47, 56, j46);
                    long j52 = j46 - xorRotr20;
                    long xorRotr21 = ThreefishEngine.xorRotr(xorRotr17, 17, j52);
                    long j53 = j52 - xorRotr21;
                    long xorRotr22 = ThreefishEngine.xorRotr(xorRotr20, ROTATION_2_1, j49);
                    long j54 = j49 - xorRotr22;
                    long xorRotr23 = ThreefishEngine.xorRotr(xorRotr19, 36, j50);
                    long j55 = j50 - xorRotr23;
                    long j56 = j51;
                    long xorRotr24 = ThreefishEngine.xorRotr(xorRotr18, 39, j56);
                    long j57 = j56 - xorRotr24;
                    long xorRotr25 = ThreefishEngine.xorRotr(xorRotr21, 33, j57);
                    long j58 = j57 - xorRotr25;
                    long xorRotr26 = ThreefishEngine.xorRotr(xorRotr24, 27, j53);
                    long j59 = j53 - xorRotr26;
                    long xorRotr27 = ThreefishEngine.xorRotr(xorRotr23, 14, j54);
                    long j60 = j54 - xorRotr27;
                    long j61 = j55;
                    long xorRotr28 = ThreefishEngine.xorRotr(xorRotr22, 42, j61);
                    long j62 = j61 - xorRotr28;
                    long xorRotr29 = ThreefishEngine.xorRotr(xorRotr25, 46, j62);
                    j = j62 - xorRotr29;
                    j4 = ThreefishEngine.xorRotr(xorRotr28, 36, j58);
                    j6 = ThreefishEngine.xorRotr(xorRotr27, 19, j59);
                    long j63 = j59 - j6;
                    long j64 = j60;
                    j8 = ThreefishEngine.xorRotr(xorRotr26, 37, j64);
                    j7 = j64 - j8;
                    i2 = i13 - 2;
                    j5 = j63;
                    j3 = j58 - j4;
                    j2 = xorRotr29;
                    access$200 = iArr;
                    jArr4 = jArr6;
                    access$100 = iArr2;
                    jArr3 = jArr5;
                    z = false;
                    i = 1;
                }
                long[] jArr7 = jArr3;
                long[] jArr8 = jArr4;
                char c = z;
                long j65 = j - jArr7[c];
                long j66 = j2 - jArr7[1];
                long j67 = j3 - jArr7[2];
                long j68 = j4 - jArr7[3];
                long j69 = j5 - jArr7[4];
                long j70 = j6 - (jArr7[5] + jArr8[c]);
                long j71 = j7 - (jArr7[6] + jArr8[1]);
                jArr2[c] = j65;
                jArr2[1] = j66;
                jArr2[2] = j67;
                jArr2[3] = j68;
                jArr2[4] = j69;
                jArr2[5] = j70;
                jArr2[6] = j71;
                jArr2[7] = j8 - jArr7[7];
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = j + jArr3[0];
                long j10 = j2 + jArr3[1];
                long j11 = j3 + jArr3[2];
                long j12 = j4 + jArr3[3];
                long j13 = j5 + jArr3[4];
                long j14 = j6 + jArr3[5] + jArr4[0];
                long j15 = j7 + jArr3[6] + jArr4[1];
                int i = 1;
                long j16 = j12;
                long j17 = j14;
                long j18 = j8 + jArr3[7];
                while (i < 18) {
                    int i2 = access$200[i];
                    int i3 = access$100[i];
                    long j19 = j9 + j10;
                    long rotlXor = ThreefishEngine.rotlXor(j10, 46, j19);
                    long j20 = j11 + j16;
                    long rotlXor2 = ThreefishEngine.rotlXor(j16, 36, j20);
                    int[] iArr = access$100;
                    long j21 = j17;
                    int[] iArr2 = access$200;
                    long j22 = j13 + j21;
                    long rotlXor3 = ThreefishEngine.rotlXor(j21, 19, j22);
                    long[] jArr5 = jArr3;
                    long j23 = rotlXor2;
                    long j24 = j18;
                    long j25 = j15 + j24;
                    int[] iArr3 = iArr2;
                    long rotlXor4 = ThreefishEngine.rotlXor(j24, 37, j25);
                    int i4 = i;
                    long j26 = j20 + rotlXor;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor, 33, j26);
                    long j27 = j22 + rotlXor4;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor4, 27, j27);
                    long j28 = j25 + rotlXor3;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor3, 14, j28);
                    int i5 = i2;
                    long j29 = j19 + j23;
                    int i6 = i4;
                    long j30 = rotlXor6;
                    long rotlXor8 = ThreefishEngine.rotlXor(j23, 42, j29);
                    long j31 = j27 + rotlXor5;
                    long rotlXor9 = ThreefishEngine.rotlXor(rotlXor5, 17, j31);
                    long j32 = j28 + rotlXor8;
                    long rotlXor10 = ThreefishEngine.rotlXor(rotlXor8, ROTATION_2_1, j32);
                    long j33 = j29 + rotlXor7;
                    long rotlXor11 = ThreefishEngine.rotlXor(rotlXor7, 36, j33);
                    long j34 = j26 + j30;
                    long j35 = rotlXor10;
                    long rotlXor12 = ThreefishEngine.rotlXor(j30, 39, j34);
                    long j36 = j32 + rotlXor9;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor9, 44, j36);
                    long j37 = j33 + rotlXor12;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor12, 9, j37);
                    long j38 = j34 + rotlXor11;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor11, 54, j38);
                    long j39 = j31 + j35;
                    long j40 = rotlXor14;
                    long rotlXor16 = ThreefishEngine.rotlXor(j35, 56, j39);
                    long j41 = j37 + jArr5[i5];
                    int i7 = i5 + 1;
                    long j42 = rotlXor13 + jArr5[i7];
                    int i8 = i5 + 2;
                    long j43 = j38 + jArr5[i8];
                    int i9 = i5 + 3;
                    long j44 = rotlXor16 + jArr5[i9];
                    int i10 = i5 + 4;
                    long j45 = j39 + jArr5[i10];
                    int i11 = i5 + 5;
                    long j46 = rotlXor15 + jArr5[i11] + jArr4[i3];
                    int i12 = i5 + 6;
                    int i13 = i3 + 1;
                    int i14 = i5 + 7;
                    long j47 = j36 + jArr5[i12] + jArr4[i13];
                    long j48 = (long) i6;
                    long j49 = j48;
                    long j50 = j40 + jArr5[i14] + j48;
                    long j51 = j41 + j42;
                    long rotlXor17 = ThreefishEngine.rotlXor(j42, 39, j51);
                    long j52 = j43 + j44;
                    long rotlXor18 = ThreefishEngine.rotlXor(j44, 30, j52);
                    long j53 = j45 + j46;
                    long rotlXor19 = ThreefishEngine.rotlXor(j46, 34, j53);
                    long j54 = rotlXor18;
                    long j55 = j47 + j50;
                    long rotlXor20 = ThreefishEngine.rotlXor(j50, 24, j55);
                    long j56 = j52 + rotlXor17;
                    long rotlXor21 = ThreefishEngine.rotlXor(rotlXor17, 13, j56);
                    long j57 = j53 + rotlXor20;
                    long rotlXor22 = ThreefishEngine.rotlXor(rotlXor20, 50, j57);
                    long j58 = j55 + rotlXor19;
                    long rotlXor23 = ThreefishEngine.rotlXor(rotlXor19, 10, j58);
                    long j59 = j51 + j54;
                    long j60 = rotlXor22;
                    long j61 = j54;
                    long j62 = j60;
                    long rotlXor24 = ThreefishEngine.rotlXor(j61, 17, j59);
                    long j63 = j57 + rotlXor21;
                    long rotlXor25 = ThreefishEngine.rotlXor(rotlXor21, 25, j63);
                    long j64 = j58 + rotlXor24;
                    long rotlXor26 = ThreefishEngine.rotlXor(rotlXor24, 29, j64);
                    long j65 = j59 + rotlXor23;
                    long rotlXor27 = ThreefishEngine.rotlXor(rotlXor23, 39, j65);
                    long j66 = j56 + j62;
                    long[] jArr6 = jArr4;
                    long rotlXor28 = ThreefishEngine.rotlXor(j62, 43, j66);
                    long j67 = j64 + rotlXor25;
                    long rotlXor29 = ThreefishEngine.rotlXor(rotlXor25, 8, j67);
                    long j68 = j65 + rotlXor28;
                    long rotlXor30 = ThreefishEngine.rotlXor(rotlXor28, 35, j68);
                    long j69 = j66 + rotlXor27;
                    long rotlXor31 = ThreefishEngine.rotlXor(rotlXor27, 56, j69);
                    long j70 = rotlXor30;
                    long j71 = j63 + rotlXor26;
                    long rotlXor32 = ThreefishEngine.rotlXor(rotlXor26, 22, j71);
                    long j72 = j68 + jArr5[i7];
                    j10 = rotlXor29 + jArr5[i8];
                    j16 = rotlXor32 + jArr5[i10];
                    long j73 = j71 + jArr5[i11];
                    j17 = rotlXor31 + jArr5[i12] + jArr6[i13];
                    long j74 = j67 + jArr5[i14] + jArr6[i3 + 2];
                    long j75 = j70 + jArr5[i5 + 8] + j49 + 1;
                    int i15 = i6 + 2;
                    j15 = j74;
                    j13 = j73;
                    jArr3 = jArr5;
                    access$200 = iArr3;
                    jArr4 = jArr6;
                    j18 = j75;
                    j11 = j69 + jArr5[i9];
                    j9 = j72;
                    i = i15;
                    access$100 = iArr;
                }
                jArr2[0] = j9;
                jArr2[1] = j10;
                jArr2[2] = j11;
                jArr2[3] = j16;
                jArr2[4] = j13;
                jArr2[5] = j17;
                jArr2[6] = j15;
                jArr2[7] = j18;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static abstract class ThreefishCipher {
        protected final long[] kw;
        protected final long[] t;

        public ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.t = jArr2;
        }

        public abstract void decryptBlock(long[] jArr, long[] jArr2);

        public abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i < iArr2.length) {
                MOD17[i] = i % 17;
                iArr2[i] = i % 9;
                MOD5[i] = i % 5;
                MOD3[i] = i % 3;
                i++;
            } else {
                return;
            }
        }
    }

    public ThreefishEngine(int i) {
        long[] jArr = new long[5];
        this.t = jArr;
        int i2 = i / 8;
        this.blocksizeBytes = i2;
        int i3 = i2 / 8;
        this.blocksizeWords = i3;
        this.currentBlock = new long[i3];
        long[] jArr2 = new long[((i3 * 2) + 1)];
        this.kw = jArr2;
        if (i == 256) {
            this.cipher = new Threefish256Cipher(jArr2, jArr);
        } else if (i == 512) {
            this.cipher = new Threefish512Cipher(jArr2, jArr);
        } else if (i == 1024) {
            this.cipher = new Threefish1024Cipher(jArr2, jArr);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
    }

    public static long bytesToWord(byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32);
            int i2 = i + 6;
            return ((((long) bArr[i + 7]) & 255) << 56) | j | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i2]) & 255) << 48);
        }
        throw new IllegalArgumentException();
    }

    public static long rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    private void setKey(long[] jArr) {
        if (jArr.length == this.blocksizeWords) {
            long j = C_240;
            int i = 0;
            while (true) {
                int i2 = this.blocksizeWords;
                if (i < i2) {
                    long[] jArr2 = this.kw;
                    long j2 = jArr[i];
                    jArr2[i] = j2;
                    j ^= j2;
                    i++;
                } else {
                    long[] jArr3 = this.kw;
                    jArr3[i2] = j;
                    System.arraycopy(jArr3, 0, jArr3, i2 + 1, i2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length == 2) {
            long[] jArr2 = this.t;
            long j = jArr[0];
            jArr2[0] = j;
            long j2 = jArr[1];
            jArr2[1] = j2;
            jArr2[2] = j ^ j2;
            jArr2[3] = j;
            jArr2[4] = j2;
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            bArr[i] = (byte) ((int) j);
            bArr[i + 1] = (byte) ((int) (j >> 8));
            bArr[i + 2] = (byte) ((int) (j >> 16));
            bArr[i + 3] = (byte) ((int) (j >> 24));
            bArr[i + 4] = (byte) ((int) (j >> 32));
            bArr[i + 5] = (byte) ((int) (j >> 40));
            bArr[i + 6] = (byte) ((int) (j >> 48));
            bArr[i + 7] = (byte) ((int) (j >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }

    public static long xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        byte[] bArr2;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            bArr2 = tweakableBlockCipherParameters.getKey().getKey();
            bArr = tweakableBlockCipherParameters.getTweak();
        } else if (cipherParameters instanceof KeyParameter) {
            bArr2 = ((KeyParameter) cipherParameters).getKey();
            bArr = null;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
        }
        if (bArr2 == null) {
            jArr = null;
        } else if (bArr2.length == this.blocksizeBytes) {
            int i = this.blocksizeWords;
            jArr = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = bytesToWord(bArr2, i2 * 8);
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
        }
        if (bArr != null) {
            if (bArr.length == 16) {
                jArr2 = new long[]{bytesToWord(bArr, 0), bytesToWord(bArr, 8)};
            } else {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
        }
        init(z, jArr, jArr2);
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.blocksizeBytes; i5 += 8) {
                this.currentBlock[i5 >> 3] = bytesToWord(bArr, i + i5);
            }
            long[] jArr = this.currentBlock;
            processBlock(jArr, jArr);
            while (true) {
                int i6 = this.blocksizeBytes;
                if (i4 >= i6) {
                    return i6;
                }
                wordToBytes(this.currentBlock[i4 >> 3], bArr2, i2 + i4);
                i4 += 8;
            }
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void reset() {
    }

    public int processBlock(long[] jArr, long[] jArr2) throws DataLengthException, IllegalStateException {
        long[] jArr3 = this.kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == i) {
            if (this.forEncryption) {
                this.cipher.encryptBlock(jArr, jArr2);
            } else {
                this.cipher.decryptBlock(jArr, jArr2);
            }
            return this.blocksizeWords;
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }
}
