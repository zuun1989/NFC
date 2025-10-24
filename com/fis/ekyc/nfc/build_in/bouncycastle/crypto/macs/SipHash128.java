package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

public class SipHash128 extends SipHash {
    public SipHash128() {
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        throw new UnsupportedOperationException("doFinal() is not supported");
    }

    public String getAlgorithmName() {
        return "SipHash128-" + this.c + "-" + this.d;
    }

    public int getMacSize() {
        return 16;
    }

    public void reset() {
        super.reset();
        this.v1 ^= 238;
    }

    public SipHash128(int i, int i2) {
        super(i, i2);
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        long j = this.m;
        int i2 = this.wordPos;
        this.m = ((j >>> ((7 - i2) << 3)) >>> 8) | ((((long) ((this.wordCount << 3) + i2)) & 255) << 56);
        processMessageWord();
        this.v2 ^= 238;
        applySipRounds(this.d);
        long j2 = this.v0;
        long j3 = this.v1;
        long j4 = ((j2 ^ j3) ^ this.v2) ^ this.v3;
        this.v1 = j3 ^ 221;
        applySipRounds(this.d);
        reset();
        Pack.longToLittleEndian(j4, bArr, i);
        Pack.longToLittleEndian(((this.v0 ^ this.v1) ^ this.v2) ^ this.v3, bArr, i + 8);
        return 16;
    }
}
