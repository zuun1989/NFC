package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;

public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = {ISOFileInfo.DATA_BYTES1, 27, 54, 108, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    private boolean _forEncryption;
    private boolean _initialised = false;
    private final int[] k = new int[4];

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i2;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i + 12);
        int[] iArr = this.k;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = 16;
        while (true) {
            byte b = bigEndianToInt ^ bigEndianToInt3;
            byte rotateLeft = b ^ (Integers.rotateLeft(b, 8) ^ Integers.rotateLeft(b, 24));
            byte b2 = (bigEndianToInt2 ^ rotateLeft) ^ i5;
            byte b3 = (bigEndianToInt4 ^ rotateLeft) ^ i7;
            byte b4 = b2 ^ b3;
            byte rotateLeft2 = (Integers.rotateLeft(b4, 24) ^ Integers.rotateLeft(b4, 8)) ^ b4;
            byte b5 = (bigEndianToInt3 ^ i6) ^ rotateLeft2;
            byte b6 = ((bigEndianToInt ^ i4) ^ rotateLeft2) ^ (roundConstants[i8] & 255);
            i8--;
            if (i8 < 0) {
                Pack.intToBigEndian((int) b6, bArr4, i3);
                Pack.intToBigEndian((int) b2, bArr4, i3 + 4);
                Pack.intToBigEndian((int) b5, bArr4, i3 + 8);
                Pack.intToBigEndian((int) b3, bArr4, i3 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b2, 1);
            int rotateLeft4 = Integers.rotateLeft(b5, 5);
            int rotateLeft5 = Integers.rotateLeft(b3, 2);
            byte b7 = rotateLeft3 ^ ((~rotateLeft4) & (~rotateLeft5));
            byte b8 = b6 ^ (rotateLeft4 & b7);
            byte b9 = rotateLeft4 ^ ((rotateLeft5 ^ b7) ^ b8);
            byte b10 = b7 ^ ((~b8) & (~b9));
            bigEndianToInt2 = Integers.rotateLeft(b10, 31);
            bigEndianToInt3 = Integers.rotateLeft(b9, 27);
            int rotateLeft6 = Integers.rotateLeft(b8, 30);
            bigEndianToInt = rotateLeft5 ^ (b9 & b10);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i2;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i + 12);
        int[] iArr = this.k;
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        while (true) {
            byte b = bigEndianToInt ^ (roundConstants[i4] & 255);
            byte b2 = b ^ bigEndianToInt3;
            byte rotateLeft = b2 ^ (Integers.rotateLeft(b2, 8) ^ Integers.rotateLeft(b2, 24));
            byte b3 = (bigEndianToInt2 ^ rotateLeft) ^ i6;
            byte b4 = (bigEndianToInt4 ^ rotateLeft) ^ i8;
            byte b5 = b3 ^ b4;
            byte rotateLeft2 = (Integers.rotateLeft(b5, 24) ^ Integers.rotateLeft(b5, 8)) ^ b5;
            byte b6 = (b ^ i5) ^ rotateLeft2;
            byte b7 = (bigEndianToInt3 ^ i7) ^ rotateLeft2;
            i4++;
            if (i4 > 16) {
                Pack.intToBigEndian((int) b6, bArr4, i3);
                Pack.intToBigEndian((int) b3, bArr4, i3 + 4);
                Pack.intToBigEndian((int) b7, bArr4, i3 + 8);
                Pack.intToBigEndian((int) b4, bArr4, i3 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b3, 1);
            int rotateLeft4 = Integers.rotateLeft(b7, 5);
            int rotateLeft5 = Integers.rotateLeft(b4, 2);
            byte b8 = rotateLeft3 ^ ((~rotateLeft5) & (~rotateLeft4));
            byte b9 = b6 ^ (rotateLeft4 & b8);
            byte b10 = rotateLeft4 ^ ((rotateLeft5 ^ b8) ^ b9);
            byte b11 = b8 ^ ((~b9) & (~b10));
            bigEndianToInt2 = Integers.rotateLeft(b11, 31);
            bigEndianToInt3 = Integers.rotateLeft(b10, 27);
            int rotateLeft6 = Integers.rotateLeft(b9, 30);
            bigEndianToInt = rotateLeft5 ^ (b10 & b11);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    public String getAlgorithmName() {
        return "Noekeon";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this._forEncryption = z;
            this._initialised = true;
            Pack.bigEndianToInt(((KeyParameter) cipherParameters).getKey(), 0, this.k, 0, 4);
            if (!z) {
                int[] iArr = this.k;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = iArr[2];
                int i4 = iArr[3];
                int i5 = i ^ i3;
                int rotateLeft = i5 ^ (Integers.rotateLeft(i5, 8) ^ Integers.rotateLeft(i5, 24));
                int i6 = i2 ^ rotateLeft;
                int i7 = i4 ^ rotateLeft;
                int i8 = i6 ^ i7;
                int rotateLeft2 = i8 ^ (Integers.rotateLeft(i8, 8) ^ Integers.rotateLeft(i8, 24));
                int i9 = i ^ rotateLeft2;
                int i10 = i3 ^ rotateLeft2;
                int[] iArr2 = this.k;
                iArr2[0] = i9;
                iArr2[1] = i6;
                iArr2[2] = i10;
                iArr2[3] = i7;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Noekeon init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 > bArr2.length - 16) {
            throw new OutputLengthException("output buffer too short");
        } else if (this._forEncryption) {
            return encryptBlock(bArr, i, bArr2, i2);
        } else {
            return decryptBlock(bArr, i, bArr2, i2);
        }
    }

    public void reset() {
    }
}
