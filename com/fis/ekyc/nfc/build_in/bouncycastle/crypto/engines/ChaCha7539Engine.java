package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc.BodyPartID;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

public class ChaCha7539Engine extends Salsa20Engine {
    public void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i <= 0) {
            int[] iArr = this.engineState;
            int i3 = iArr[12];
            int i4 = i2 + i3;
            iArr[12] = i4;
            if (i3 != 0 && i4 < i3) {
                throw new IllegalStateException("attempt to increase counter past 2^32.");
            }
            return;
        }
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    public long getCounter() {
        return ((long) this.engineState[12]) & BodyPartID.bodyIdMax;
    }

    public int getNonceSize() {
        return 12;
    }

    public void resetCounter() {
        this.engineState[12] = 0;
    }

    public void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i == 0) {
            int[] iArr = this.engineState;
            int i3 = iArr[12];
            if ((((long) i3) & BodyPartID.bodyIdMax) >= (BodyPartID.bodyIdMax & ((long) i2))) {
                iArr[12] = i3 - i2;
                return;
            }
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }

    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12];
        if (i != 0) {
            iArr[12] = i - 1;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }
}
