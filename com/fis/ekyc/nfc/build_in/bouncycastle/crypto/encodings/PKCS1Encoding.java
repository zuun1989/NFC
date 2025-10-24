package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.encodings;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.security.SecureRandom;

public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "com.fis.ekyc.nfc.build_in.bouncycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "com.fis.ekyc.nfc.build_in.bouncycastle.pkcs1.strict";
    private byte[] blockBuffer;
    private AsymmetricBlockCipher engine;
    private byte[] fallback = null;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private int pLen = -1;
    private SecureRandom random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
    }

    private static int checkPkcs1Encoding(byte[] bArr, int i) {
        byte b = bArr[0] ^ 2;
        int i2 = i + 1;
        int length = bArr.length - i2;
        for (int i3 = 1; i3 < length; i3++) {
            byte b2 = bArr[i3];
            byte b3 = b2 | (b2 >> 1);
            byte b4 = b3 | (b3 >> 2);
            b |= ((b4 | (b4 >> 4)) & 1) - 1;
        }
        byte b5 = bArr[bArr.length - i2] | b;
        byte b6 = b5 | (b5 >> 1);
        byte b7 = b6 | (b6 >> 2);
        return ~(((b7 | (b7 >> 4)) & 1) - 1);
    }

    private byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        if (this.pLen != -1) {
            return decodeBlockOrRandom(bArr, i, i2);
        }
        byte[] processBlock = this.engine.processBlock(bArr, i, i2);
        boolean z3 = this.useStrictLength;
        boolean z5 = true;
        if (processBlock.length != this.engine.getOutputBlockSize()) {
            z = true;
        } else {
            z = false;
        }
        boolean z6 = z3 & z;
        if (processBlock.length < getOutputBlockSize()) {
            processBlock = this.blockBuffer;
        }
        byte b = processBlock[0];
        if (!this.forPrivateKey ? b == 1 : b == 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        int findStart = findStart(b, processBlock) + 1;
        if (findStart >= 10) {
            z5 = false;
        }
        if (z2 || z5) {
            Arrays.fill(processBlock, (byte) 0);
            throw new InvalidCipherTextException("block incorrect");
        } else if (!z6) {
            int length = processBlock.length - findStart;
            byte[] bArr2 = new byte[length];
            System.arraycopy(processBlock, findStart, bArr2, 0, length);
            return bArr2;
        } else {
            Arrays.fill(processBlock, (byte) 0);
            throw new InvalidCipherTextException("block incorrect size");
        }
    }

    private byte[] decodeBlockOrRandom(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        boolean z;
        if (this.forPrivateKey) {
            byte[] processBlock = this.engine.processBlock(bArr, i, i2);
            byte[] bArr2 = this.fallback;
            if (bArr2 == null) {
                bArr2 = new byte[this.pLen];
                this.random.nextBytes(bArr2);
            }
            boolean z2 = this.useStrictLength;
            if (processBlock.length != this.engine.getOutputBlockSize()) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                processBlock = this.blockBuffer;
            }
            int checkPkcs1Encoding = checkPkcs1Encoding(processBlock, this.pLen);
            byte[] bArr3 = new byte[this.pLen];
            int i3 = 0;
            while (true) {
                int i4 = this.pLen;
                if (i3 < i4) {
                    bArr3[i3] = (byte) ((processBlock[(processBlock.length - i4) + i3] & (~checkPkcs1Encoding)) | (bArr2[i3] & checkPkcs1Encoding));
                    i3++;
                } else {
                    Arrays.fill(processBlock, (byte) 0);
                    return bArr3;
                }
            }
        } else {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
    }

    private byte[] encodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (i2 <= getInputBlockSize()) {
            int inputBlockSize = this.engine.getInputBlockSize();
            byte[] bArr2 = new byte[inputBlockSize];
            if (this.forPrivateKey) {
                bArr2[0] = 1;
                for (int i3 = 1; i3 != (inputBlockSize - i2) - 1; i3++) {
                    bArr2[i3] = -1;
                }
            } else {
                this.random.nextBytes(bArr2);
                bArr2[0] = 2;
                for (int i4 = 1; i4 != (inputBlockSize - i2) - 1; i4++) {
                    while (bArr2[i4] == 0) {
                        bArr2[i4] = (byte) this.random.nextInt();
                    }
                }
            }
            int i5 = inputBlockSize - i2;
            bArr2[i5 - 1] = 0;
            System.arraycopy(bArr, i, bArr2, i5, i2);
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new IllegalArgumentException("input data too large");
    }

    private int findStart(byte b, byte[] bArr) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z5;
        boolean z6;
        int i = -1;
        boolean z7 = false;
        for (int i2 = 1; i2 != bArr.length; i2++) {
            byte b2 = bArr[i2];
            if (b2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i < 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                i = i2;
            }
            if (b == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i < 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z8 = z3 & z5;
            if (b2 != -1) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 |= z6 & z8;
        }
        if (z7) {
            return -1;
        }
        return i;
    }

    private boolean useStrict() {
        if (Properties.isOverrideSetTo(NOT_STRICT_LENGTH_ENABLED_PROPERTY, true)) {
            return false;
        }
        return !Properties.isOverrideSetTo(STRICT_LENGTH_ENABLED_PROPERTY, false);
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        if (this.forEncryption) {
            return inputBlockSize - 10;
        }
        return inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return outputBlockSize;
        }
        return outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
        }
        this.engine.init(z, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z;
        this.blockBuffer = new byte[this.engine.getOutputBlockSize()];
        if (this.pLen > 0 && this.fallback == null && this.random == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.pLen = i;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.fallback = bArr;
        this.pLen = bArr.length;
    }
}
