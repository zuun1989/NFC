package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricBlockCipher extends CipherSpiExt {
    protected ByteArrayOutputStream buf = new ByteArrayOutputStream();
    protected int cipherTextSize;
    protected int maxPlainTextSize;
    protected AlgorithmParameterSpec paramSpec;

    public void checkLength(int i) throws IllegalBlockSizeException {
        int size = i + this.buf.size();
        int i2 = this.opMode;
        if (i2 == 1) {
            if (size > this.maxPlainTextSize) {
                throw new IllegalBlockSizeException("The length of the plaintext (" + size + " bytes) is not supported by the cipher (max. " + this.maxPlainTextSize + " bytes).");
            }
        } else if (i2 == 2 && size != this.cipherTextSize) {
            throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.cipherTextSize + " bytes, was " + size + " bytes).");
        }
    }

    public final byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        checkLength(i2);
        update(bArr, i, i2);
        byte[] byteArray = this.buf.toByteArray();
        this.buf.reset();
        int i3 = this.opMode;
        if (i3 == 1) {
            return messageEncrypt(byteArray);
        }
        if (i3 != 2) {
            return null;
        }
        return messageDecrypt(byteArray);
    }

    public final int getBlockSize() {
        if (this.opMode == 1) {
            return this.maxPlainTextSize;
        }
        return this.cipherTextSize;
    }

    public final byte[] getIV() {
        return null;
    }

    public final int getOutputSize(int i) {
        if (i + this.buf.size() > getBlockSize()) {
            return 0;
        }
        if (this.opMode == 1) {
            return this.cipherTextSize;
        }
        return this.maxPlainTextSize;
    }

    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    public abstract void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void initDecrypt(Key key) throws InvalidKeyException {
        try {
            initDecrypt(key, (AlgorithmParameterSpec) null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key) throws InvalidKeyException {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, CryptoServicesRegistrar.getSecureRandom());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public abstract byte[] messageDecrypt(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    public abstract byte[] messageEncrypt(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    public final void setMode(String str) {
    }

    public final void setPadding(String str) {
    }

    public final byte[] update(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.buf.write(bArr, i, i2);
        }
        return new byte[0];
    }

    public final void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 2;
        initCipherDecrypt(key, algorithmParameterSpec);
    }

    public final void initEncrypt(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            initEncrypt(key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        update(bArr, i, i2);
        return 0;
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initEncrypt(key, algorithmParameterSpec, CryptoServicesRegistrar.getSecureRandom());
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }

    public final int doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (bArr2.length >= getOutputSize(i2)) {
            byte[] doFinal = doFinal(bArr, i, i2);
            System.arraycopy(doFinal, 0, bArr2, i3, doFinal.length);
            return doFinal.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }
}
