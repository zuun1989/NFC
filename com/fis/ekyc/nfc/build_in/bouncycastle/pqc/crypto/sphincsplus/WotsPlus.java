package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

class WotsPlus {
    private final SPHINCSPlusEngine engine;
    private final int w;

    public WotsPlus(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.engine = sPHINCSPlusEngine;
        this.w = sPHINCSPlusEngine.WOTS_W;
    }

    public int[] base_w(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        byte b = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            if (i3 == 0) {
                b = bArr[i4];
                i4++;
                i3 += 8;
            }
            i3 -= this.engine.WOTS_LOGW;
            iArr[i5] = (b >>> i3) & (i - 1);
            i5++;
        }
        return iArr;
    }

    public byte[] chain(byte[] bArr, int i, int i2, byte[] bArr2, ADRS adrs) {
        if (i2 == 0) {
            return Arrays.clone(bArr);
        }
        int i3 = i + i2;
        if (i3 > this.w - 1) {
            return null;
        }
        byte[] chain = chain(bArr, i, i2 - 1, bArr2, adrs);
        adrs.setHashAddress(i3 - 1);
        return this.engine.F(bArr2, adrs, chain);
    }

    public byte[] pkFromSig(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        ADRS adrs2 = adrs;
        ADRS adrs3 = new ADRS(adrs2);
        int[] base_w = base_w(bArr2, this.w, this.engine.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sPHINCSPlusEngine = this.engine;
            if (i >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.w - 1) - base_w[i];
            i++;
        }
        int i3 = sPHINCSPlusEngine.WOTS_LEN2;
        int i4 = sPHINCSPlusEngine.WOTS_LOGW;
        int[] concatenate = Arrays.concatenate(base_w, base_w(Arrays.copyOfRange(Pack.intToBigEndian(i2 << (8 - ((i3 * i4) % 8))), 4 - (((i3 * i4) + 7) / 8), 4), this.w, this.engine.WOTS_LEN2));
        SPHINCSPlusEngine sPHINCSPlusEngine2 = this.engine;
        byte[] bArr4 = new byte[sPHINCSPlusEngine2.N];
        byte[][] bArr5 = new byte[sPHINCSPlusEngine2.WOTS_LEN][];
        for (int i5 = 0; i5 < this.engine.WOTS_LEN; i5++) {
            adrs2.setChainAddress(i5);
            int i6 = this.engine.N;
            System.arraycopy(bArr, i5 * i6, bArr4, 0, i6);
            int i7 = concatenate[i5];
            bArr5[i5] = chain(bArr4, i7, (this.w - 1) - i7, bArr3, adrs);
        }
        adrs3.setType(1);
        adrs3.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr3, adrs3, Arrays.concatenate(bArr5));
    }

    public byte[] pkGen(byte[] bArr, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        byte[][] bArr3 = new byte[this.engine.WOTS_LEN][];
        for (int i = 0; i < this.engine.WOTS_LEN; i++) {
            ADRS adrs3 = new ADRS(adrs);
            adrs3.setChainAddress(i);
            adrs3.setHashAddress(0);
            bArr3[i] = chain(this.engine.PRF(bArr2, bArr, adrs3), 0, this.w - 1, bArr2, adrs3);
        }
        adrs2.setType(1);
        adrs2.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr2, adrs2, Arrays.concatenate(bArr3));
    }

    public byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        ADRS adrs2 = new ADRS(adrs);
        int[] base_w = base_w(bArr, this.w, this.engine.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sPHINCSPlusEngine = this.engine;
            if (i >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.w - 1) - base_w[i];
            i++;
        }
        int i3 = sPHINCSPlusEngine.WOTS_LOGW;
        if (i3 % 8 != 0) {
            i2 <<= 8 - ((sPHINCSPlusEngine.WOTS_LEN2 * i3) % 8);
        }
        byte[] intToBigEndian = Pack.intToBigEndian(i2);
        int[] concatenate = Arrays.concatenate(base_w, base_w(Arrays.copyOfRange(intToBigEndian, ((sPHINCSPlusEngine.WOTS_LEN2 * i3) + 7) / 8, intToBigEndian.length), this.w, this.engine.WOTS_LEN2));
        byte[][] bArr4 = new byte[this.engine.WOTS_LEN][];
        for (int i4 = 0; i4 < this.engine.WOTS_LEN; i4++) {
            adrs2.setChainAddress(i4);
            adrs2.setHashAddress(0);
            bArr4[i4] = chain(this.engine.PRF(bArr3, bArr2, adrs2), 0, concatenate[i4], bArr3, adrs2);
        }
        return Arrays.concatenate(bArr4);
    }
}
