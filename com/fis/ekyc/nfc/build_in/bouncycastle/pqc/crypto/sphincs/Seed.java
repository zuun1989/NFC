package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ChaChaEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.Tree;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

class Seed {
    public static void get_seed(HashFunctions hashFunctions, byte[] bArr, int i, byte[] bArr2, Tree.leafaddr leafaddr) {
        byte[] bArr3 = new byte[40];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr3[i2] = bArr2[i2];
        }
        Pack.longToLittleEndian((leafaddr.subleaf << 59) | ((long) leafaddr.level) | (leafaddr.subtree << 4), bArr3, 32);
        hashFunctions.varlen_hash(bArr, i, bArr3, 40);
    }

    public static void prg(byte[] bArr, int i, long j, byte[] bArr2, int i2) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(12);
        chaChaEngine.init(true, new ParametersWithIV(new KeyParameter(bArr2, i2, 32), new byte[8]));
        chaChaEngine.processBytes(bArr, i, (int) j, bArr, i);
    }
}
