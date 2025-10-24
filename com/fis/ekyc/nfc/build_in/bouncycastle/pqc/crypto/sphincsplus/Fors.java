package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.util.LinkedList;

class Fors {
    SPHINCSPlusEngine engine;

    public Fors(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.engine = sPHINCSPlusEngine;
    }

    public static int[] message_to_idxs(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            iArr[i4] = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i4] = iArr[i4] ^ (((bArr[i3 >> 3] >> (i3 & 7)) & 1) << i5);
                i3++;
            }
        }
        return iArr;
    }

    public byte[] pkFromSig(SIG_FORS[] sig_forsArr, byte[] bArr, byte[] bArr2, ADRS adrs) {
        byte[] bArr3 = bArr2;
        ADRS adrs2 = adrs;
        int i = 2;
        byte[][] bArr4 = new byte[2][];
        SPHINCSPlusEngine sPHINCSPlusEngine = this.engine;
        int i2 = sPHINCSPlusEngine.K;
        byte[][] bArr5 = new byte[i2][];
        int i3 = sPHINCSPlusEngine.T;
        int[] message_to_idxs = message_to_idxs(bArr, i2, sPHINCSPlusEngine.A);
        int i4 = 0;
        while (i4 < this.engine.K) {
            int i5 = message_to_idxs[i4];
            byte[] sk = sig_forsArr[i4].getSK();
            adrs2.setTreeHeight(0);
            int i6 = (i4 * i3) + i5;
            adrs2.setTreeIndex(i6);
            bArr4[0] = this.engine.F(bArr3, adrs2, sk);
            byte[][] authPath = sig_forsArr[i4].getAuthPath();
            adrs2.setTreeIndex(i6);
            int i7 = 0;
            while (i7 < this.engine.A) {
                int i8 = i7 + 1;
                adrs2.setTreeHeight(i8);
                if ((i5 / (1 << i7)) % i == 0) {
                    adrs2.setTreeIndex(adrs.getTreeIndex() / i);
                    bArr4[1] = this.engine.H(bArr3, adrs2, bArr4[0], authPath[i7]);
                } else {
                    adrs2.setTreeIndex((adrs.getTreeIndex() - 1) / 2);
                    bArr4[1] = this.engine.H(bArr3, adrs2, authPath[i7], bArr4[0]);
                }
                bArr4[0] = bArr4[1];
                i7 = i8;
                i = 2;
            }
            bArr5[i4] = bArr4[0];
            i4++;
            i = 2;
        }
        ADRS adrs3 = new ADRS(adrs2);
        adrs3.setType(4);
        adrs3.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr3, adrs3, Arrays.concatenate(bArr5));
    }

    public SIG_FORS[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        Fors fors = this;
        ADRS adrs2 = adrs;
        SPHINCSPlusEngine sPHINCSPlusEngine = fors.engine;
        int[] message_to_idxs = message_to_idxs(bArr, sPHINCSPlusEngine.K, sPHINCSPlusEngine.A);
        SPHINCSPlusEngine sPHINCSPlusEngine2 = fors.engine;
        SIG_FORS[] sig_forsArr = new SIG_FORS[sPHINCSPlusEngine2.K];
        int i = sPHINCSPlusEngine2.T;
        int i2 = 0;
        int i3 = 0;
        while (i3 < fors.engine.K) {
            int i4 = message_to_idxs[i3];
            adrs2.setTreeHeight(i2);
            int i5 = i3 * i;
            adrs2.setTreeIndex(i5 + i4);
            byte[] PRF = fors.engine.PRF(bArr3, bArr2, adrs2);
            byte[][] bArr4 = new byte[fors.engine.A][];
            int i6 = i2;
            while (i6 < fors.engine.A) {
                int i7 = 1 << i6;
                int i8 = i6;
                byte[][] bArr5 = bArr4;
                bArr5[i8] = treehash(bArr2, i5 + (((i4 / i7) ^ 1) * i7), i8, bArr3, adrs);
                i6 = i8 + 1;
                byte[] bArr6 = bArr3;
                PRF = PRF;
                bArr4 = bArr5;
                fors = this;
            }
            sig_forsArr[i3] = new SIG_FORS(PRF, bArr4);
            i3++;
            i2 = 0;
            fors = this;
        }
        return sig_forsArr;
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        LinkedList linkedList = new LinkedList();
        int i3 = 1 << i2;
        if (i % i3 != 0) {
            return null;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            adrs2.setTreeHeight(0);
            int i5 = i + i4;
            adrs2.setTreeIndex(i5);
            byte[] F = this.engine.F(bArr2, adrs2, this.engine.PRF(bArr2, bArr, adrs2));
            adrs2.setTreeHeight(1);
            adrs2.setTreeIndex(i5);
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == adrs2.getTreeHeight()) {
                adrs2.setTreeIndex((adrs2.getTreeIndex() - 1) / 2);
                F = this.engine.H(bArr2, adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, F);
                adrs2.setTreeHeight(adrs2.getTreeHeight() + 1);
            }
            linkedList.add(0, new NodeEntry(F, adrs2.getTreeHeight()));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }
}
