package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC5Parameters;

public class RC532Engine implements BlockCipher {
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private int[] _S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int bytesToWord = bytesToWord(bArr, i);
        int bytesToWord2 = bytesToWord(bArr, i + 4);
        for (int i3 = this._noRounds; i3 >= 1; i3--) {
            int i4 = i3 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this._S[i4 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this._S[i4], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this._S[0], bArr2, i2);
        wordToBytes(bytesToWord2 - this._S[1], bArr2, i2 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int bytesToWord = bytesToWord(bArr, i) + this._S[0];
        int bytesToWord2 = bytesToWord(bArr, i + 4) + this._S[1];
        for (int i3 = 1; i3 <= this._noRounds; i3++) {
            int i4 = i3 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this._S[i4];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this._S[i4 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i2);
        wordToBytes(bytesToWord2, bArr2, i2 + 4);
        return 8;
    }

    private int rotateLeft(int i, int i2) {
        int i3 = i2 & 31;
        return (i >>> (32 - i3)) | (i << i3);
    }

    private int rotateRight(int i, int i2) {
        int i3 = i2 & 31;
        return (i << (32 - i3)) | (i >>> i3);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int i;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = i2 / 4;
            iArr2[i3] = iArr2[i3] + ((bArr[i2] & 255) << ((i2 % 4) * 8));
        }
        int[] iArr3 = new int[((this._noRounds + 1) * 2)];
        this._S = iArr3;
        iArr3[0] = P32;
        int i4 = 1;
        while (true) {
            iArr = this._S;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = iArr[i4 - 1] + Q32;
            i4++;
        }
        if (length > iArr.length) {
            i = length * 3;
        } else {
            i = iArr.length * 3;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            int[] iArr4 = this._S;
            i6 = rotateLeft(iArr4[i5] + i6 + i7, 3);
            iArr4[i5] = i6;
            i7 = rotateLeft(iArr2[i8] + i6 + i7, i7 + i6);
            iArr2[i8] = i7;
            i5 = (i5 + 1) % this._S.length;
            i8 = (i8 + 1) % length;
        }
    }

    private void wordToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    public String getAlgorithmName() {
        return "RC5-32";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
        } else if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC532 init - " + cipherParameters.getClass().getName());
        }
        this.forEncryption = z;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.forEncryption) {
            return encryptBlock(bArr, i, bArr2, i2);
        }
        return decryptBlock(bArr, i, bArr2, i2);
    }

    public void reset() {
    }
}
