package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.StreamBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class G3413OFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private byte[] Y;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean initialized = false;
    private int m;

    public G3413OFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.cipher = blockCipher;
        this.Y = new byte[blockSize2];
    }

    private void generateR() {
        byte[] LSB = GOST3413CipherUtil.LSB(this.R, this.m - this.blockSize);
        System.arraycopy(LSB, 0, this.R, 0, LSB.length);
        System.arraycopy(this.Y, 0, this.R, LSB.length, this.m - LSB.length);
    }

    private void generateY() {
        this.cipher.processBlock(GOST3413CipherUtil.MSB(this.R, this.blockSize), 0, this.Y, 0);
    }

    private void initArrays() {
        int i = this.m;
        this.R = new byte[i];
        this.R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.m = this.blockSize * 2;
    }

    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            generateY();
        }
        byte[] bArr = this.Y;
        int i = this.byteCount;
        byte b2 = (byte) (b ^ bArr[i]);
        int i2 = i + 1;
        this.byteCount = i2;
        if (i2 == getBlockSize()) {
            this.byteCount = 0;
            generateR();
        }
        return b2;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length >= this.blockSize) {
                this.m = iv.length;
                initArrays();
                byte[] clone = Arrays.clone(iv);
                this.R_init = clone;
                System.arraycopy(clone, 0, this.R, 0, clone.length);
                if (parametersWithIV.getParameters() != null) {
                    this.cipher.init(true, parametersWithIV.getParameters());
                }
            } else {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            if (cipherParameters != null) {
                this.cipher.init(true, cipherParameters);
            }
        }
        this.initialized = true;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    public void reset() {
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            Arrays.clear(this.Y);
            this.byteCount = 0;
            this.cipher.reset();
        }
    }
}
