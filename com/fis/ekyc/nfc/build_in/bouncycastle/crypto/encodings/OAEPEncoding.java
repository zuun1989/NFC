package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.encodings;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), (byte[]) null);
    }

    private void ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.mgf1Hash.reset();
        int i4 = 0;
        while (i4 < i3 / digestSize) {
            ItoOSP(i4, bArr4);
            this.mgf1Hash.update(bArr, i, i2);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i4 * digestSize, digestSize);
            i4++;
        }
        int i5 = digestSize * i4;
        if (i5 < i3) {
            ItoOSP(i4, bArr4);
            this.mgf1Hash.update(bArr, i, i2);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i5, i3 - i5);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        boolean z;
        byte[] bArr2;
        byte[] bArr3;
        boolean z2;
        boolean z3;
        boolean z5;
        boolean z6;
        byte[] processBlock = this.engine.processBlock(bArr, i, i2);
        int outputBlockSize = this.engine.getOutputBlockSize();
        byte[] bArr4 = new byte[outputBlockSize];
        if (outputBlockSize < (this.defHash.length * 2) + 1) {
            z = true;
        } else {
            z = false;
        }
        if (processBlock.length <= outputBlockSize) {
            System.arraycopy(processBlock, 0, bArr4, outputBlockSize - processBlock.length, processBlock.length);
        } else {
            System.arraycopy(processBlock, 0, bArr4, 0, outputBlockSize);
            z = true;
        }
        byte[] bArr5 = this.defHash;
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, bArr5.length, outputBlockSize - bArr5.length, bArr5.length);
        int i3 = 0;
        while (true) {
            bArr2 = this.defHash;
            if (i3 == bArr2.length) {
                break;
            }
            bArr4[i3] = (byte) (bArr4[i3] ^ maskGeneratorFunction1[i3]);
            i3++;
        }
        byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr4, 0, bArr2.length, outputBlockSize - bArr2.length);
        for (int length = this.defHash.length; length != outputBlockSize; length++) {
            bArr4[length] = (byte) (bArr4[length] ^ maskGeneratorFunction12[length - this.defHash.length]);
        }
        int i4 = 0;
        boolean z7 = false;
        while (true) {
            bArr3 = this.defHash;
            if (i4 == bArr3.length) {
                break;
            }
            if (bArr3[i4] != bArr4[bArr3.length + i4]) {
                z7 = true;
            }
            i4++;
        }
        int i5 = outputBlockSize;
        for (int length2 = bArr3.length * 2; length2 != outputBlockSize; length2++) {
            if (bArr4[length2] != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (i5 == outputBlockSize) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z5 && z6) {
                i5 = length2;
            }
        }
        if (i5 > outputBlockSize - 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (bArr4[i5] != 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i6 = i5 + 1;
        if (!(z2 | z3) && !(z | z7)) {
            int i7 = outputBlockSize - i6;
            byte[] bArr6 = new byte[i7];
            System.arraycopy(bArr4, i6, bArr6, 0, i7);
            return bArr6;
        }
        Arrays.fill(bArr4, (byte) 0);
        throw new InvalidCipherTextException("data wrong");
    }

    public byte[] encodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (i2 <= getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize() + 1 + (this.defHash.length * 2);
            byte[] bArr2 = new byte[inputBlockSize];
            int i3 = inputBlockSize - i2;
            System.arraycopy(bArr, i, bArr2, i3, i2);
            bArr2[i3 - 1] = 1;
            byte[] bArr3 = this.defHash;
            System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
            int length = this.defHash.length;
            byte[] bArr4 = new byte[length];
            this.random.nextBytes(bArr4);
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, length, inputBlockSize - this.defHash.length);
            for (int length2 = this.defHash.length; length2 != inputBlockSize; length2++) {
                bArr2[length2] = (byte) (bArr2[length2] ^ maskGeneratorFunction1[length2 - this.defHash.length]);
            }
            System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
            byte[] bArr5 = this.defHash;
            byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr2, bArr5.length, inputBlockSize - bArr5.length, bArr5.length);
            for (int i4 = 0; i4 != this.defHash.length; i4++) {
                bArr2[i4] = (byte) (bArr2[i4] ^ maskGeneratorFunction12[i4]);
            }
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new DataLengthException("input data too long");
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        if (this.forEncryption) {
            return (inputBlockSize - 1) - (this.defHash.length * 2);
        }
        return inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return outputBlockSize;
        }
        return (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.random = ((ParametersWithRandom) cipherParameters).getRandom();
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        this.engine.init(z, cipherParameters);
        this.forEncryption = z;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, (byte[]) null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.defHash, 0);
    }
}
