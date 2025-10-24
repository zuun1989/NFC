package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;

public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i2;
        int i3;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i3 = 0;
            } else if ((blockSize * 2) + i <= bArr.length) {
                i3 = this.cipher.processBlock(this.buf, 0, bArr, i);
                this.bufOff = 0;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
            byte b = (byte) (blockSize - this.bufOff);
            while (true) {
                int i4 = this.bufOff;
                if (i4 >= blockSize) {
                    break;
                }
                this.buf[i4] = b;
                this.bufOff = i4 + 1;
            }
            i2 = i3 + this.cipher.processBlock(this.buf, 0, bArr, i + i3);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            byte[] bArr3 = this.buf;
            byte b2 = bArr3[blockSize - 1] & 255;
            if (b2 <= blockSize) {
                i2 = processBlock - b2;
                System.arraycopy(bArr3, 0, bArr, i, i2);
            } else {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return i2;
    }

    public int getOutputSize(int i) {
        int length;
        int i2 = i + this.bufOff;
        byte[] bArr = this.buf;
        int length2 = i2 % bArr.length;
        if (length2 != 0) {
            i2 -= length2;
            length = bArr.length;
        } else if (!this.forEncryption) {
            return i2;
        } else {
            length = bArr.length;
        }
        return i2 + length;
    }

    public int getUpdateOutputSize(int i) {
        int i2 = i + this.bufOff;
        byte[] bArr = this.buf;
        int length = i2 % bArr.length;
        if (length == 0) {
            return i2 - bArr.length;
        }
        return i2 - length;
    }

    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        int i2 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i3 = 0;
        if (i2 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i);
            this.bufOff = 0;
            i3 = processBlock;
        }
        byte[] bArr3 = this.buf;
        int i4 = this.bufOff;
        this.bufOff = i4 + 1;
        bArr3[i4] = b;
        return i3;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (i2 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i2);
            if (updateOutputSize <= 0 || updateOutputSize + i3 <= bArr2.length) {
                byte[] bArr3 = this.buf;
                int length = bArr3.length;
                int i4 = this.bufOff;
                int i5 = length - i4;
                int i6 = 0;
                if (i2 > i5) {
                    System.arraycopy(bArr, i, bArr3, i4, i5);
                    int processBlock = this.cipher.processBlock(this.buf, 0, bArr2, i3);
                    this.bufOff = 0;
                    i2 -= i5;
                    i += i5;
                    i6 = processBlock;
                    while (i2 > this.buf.length) {
                        i6 += this.cipher.processBlock(bArr, i, bArr2, i3 + i6);
                        i2 -= blockSize;
                        i += blockSize;
                    }
                }
                System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
                this.bufOff += i2;
                return i6;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
