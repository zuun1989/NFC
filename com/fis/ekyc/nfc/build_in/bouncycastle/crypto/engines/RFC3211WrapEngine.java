package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Wrapper;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class RFC3211WrapEngine implements Wrapper {
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private ParametersWithIV param;
    private SecureRandom rand;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.engine = new CBCBlockCipher(blockCipher);
    }

    public String getAlgorithmName() {
        return this.engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.rand = parametersWithRandom.getRandom();
            if (parametersWithRandom.getParameters() instanceof ParametersWithIV) {
                this.param = (ParametersWithIV) parametersWithRandom.getParameters();
                return;
            }
            throw new IllegalArgumentException("RFC3211Wrap requires an IV");
        }
        if (z) {
            this.rand = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.param = (ParametersWithIV) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("RFC3211Wrap requires an IV");
    }

    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        boolean z;
        byte[] bArr2;
        if (!this.forWrapping) {
            int blockSize = this.engine.getBlockSize();
            if (i2 >= blockSize * 2) {
                byte[] bArr3 = new byte[i2];
                byte[] bArr4 = new byte[blockSize];
                boolean z2 = false;
                System.arraycopy(bArr, i, bArr3, 0, i2);
                System.arraycopy(bArr, i, bArr4, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr4));
                for (int i3 = blockSize; i3 < i2; i3 += blockSize) {
                    this.engine.processBlock(bArr3, i3, bArr3, i3);
                }
                System.arraycopy(bArr3, i2 - blockSize, bArr4, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr4));
                this.engine.processBlock(bArr3, 0, bArr3, 0);
                this.engine.init(false, this.param);
                for (int i4 = 0; i4 < i2; i4 += blockSize) {
                    this.engine.processBlock(bArr3, i4, bArr3, i4);
                }
                byte b = bArr3[0];
                int i5 = i2 - 4;
                if ((b & 255) > i5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    bArr2 = new byte[i5];
                } else {
                    bArr2 = new byte[(b & 255)];
                }
                System.arraycopy(bArr3, 4, bArr2, 0, bArr2.length);
                int i6 = 0;
                byte b2 = 0;
                while (i6 != 3) {
                    int i7 = i6 + 1;
                    b2 |= bArr3[i6 + 4] ^ ((byte) (~bArr3[i7]));
                    i6 = i7;
                }
                Arrays.clear(bArr3);
                if (b2 != 0) {
                    z2 = true;
                }
                if (!z && !z2) {
                    return bArr2;
                }
                throw new InvalidCipherTextException("wrapped key corrupted");
            }
            throw new InvalidCipherTextException("input too short");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public byte[] wrap(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i3;
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        } else if (i2 > 255 || i2 < 0) {
            throw new IllegalArgumentException("input must be from 0 to 255 bytes");
        } else {
            this.engine.init(true, this.param);
            int blockSize = this.engine.getBlockSize();
            int i4 = i2 + 4;
            int i5 = blockSize * 2;
            if (i4 < i5) {
                bArr2 = new byte[i5];
            } else {
                if (i4 % blockSize == 0) {
                    i3 = i4;
                } else {
                    i3 = ((i4 / blockSize) + 1) * blockSize;
                }
                bArr2 = new byte[i3];
            }
            bArr2[0] = (byte) i2;
            System.arraycopy(bArr, i, bArr2, 4, i2);
            int length = bArr2.length - i4;
            byte[] bArr3 = new byte[length];
            this.rand.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i4, length);
            bArr2[1] = (byte) (~bArr2[4]);
            bArr2[2] = (byte) (~bArr2[5]);
            bArr2[3] = (byte) (~bArr2[6]);
            for (int i6 = 0; i6 < bArr2.length; i6 += blockSize) {
                this.engine.processBlock(bArr2, i6, bArr2, i6);
            }
            for (int i7 = 0; i7 < bArr2.length; i7 += blockSize) {
                this.engine.processBlock(bArr2, i7, bArr2, i7);
            }
            return bArr2;
        }
    }
}
