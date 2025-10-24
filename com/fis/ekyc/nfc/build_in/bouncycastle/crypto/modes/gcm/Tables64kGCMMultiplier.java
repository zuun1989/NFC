package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.gcm;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import java.lang.reflect.Array;

public class Tables64kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    public void init(byte[] bArr) {
        if (this.T == null) {
            int[] iArr = new int[3];
            iArr[2] = 2;
            iArr[1] = 256;
            iArr[0] = 16;
            this.T = (long[][][]) Array.newInstance(Long.TYPE, iArr);
        } else if (Arrays.areEqual(this.H, bArr)) {
            return;
        }
        this.H = Arrays.clone(bArr);
        for (int i = 0; i < 16; i++) {
            long[][][] jArr = this.T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                GCMUtil.asLongs(this.H, jArr2[1]);
                long[] jArr3 = jArr2[1];
                GCMUtil.multiplyP7(jArr3, jArr3);
            } else {
                GCMUtil.multiplyP8(jArr[i - 1][1], jArr2[1]);
            }
            for (int i2 = 2; i2 < 256; i2 += 2) {
                GCMUtil.divideP(jArr2[i2 >> 1], jArr2[i2]);
                GCMUtil.xor(jArr2[i2], jArr2[1], jArr2[i2 + 1]);
            }
        }
    }

    public void multiplyH(byte[] bArr) {
        long[] jArr = this.T[15][bArr[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.T[i][bArr[i] & 255];
            j ^= jArr2[0];
            j2 ^= jArr2[1];
        }
        Pack.longToBigEndian(j, bArr, 0);
        Pack.longToBigEndian(j2, bArr, 8);
    }
}
