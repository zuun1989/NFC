package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.rfc8032.Ed448;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.io.Streams;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

public final class Ed448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private Ed448PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed448PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[57];
        this.data = bArr;
        Ed448.generatePrivateKey(secureRandom, bArr);
    }

    public void encode(byte[] bArr, int i) {
        System.arraycopy(this.data, 0, bArr, i, 57);
    }

    public Ed448PublicKeyParameters generatePublicKey() {
        Ed448PublicKeyParameters ed448PublicKeyParameters;
        synchronized (this.data) {
            try {
                if (this.cachedPublicKey == null) {
                    byte[] bArr = new byte[57];
                    Ed448.generatePublicKey(this.data, 0, bArr, 0);
                    this.cachedPublicKey = new Ed448PublicKeyParameters(bArr, 0);
                }
                ed448PublicKeyParameters = this.cachedPublicKey;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ed448PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int i, Ed448PublicKeyParameters ed448PublicKeyParameters, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        sign(i, bArr, bArr2, i2, i3, bArr3, i4);
    }

    public void sign(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        int i5 = i;
        byte[] bArr4 = new byte[57];
        generatePublicKey().encode(bArr4, 0);
        if (i5 == 0) {
            int i6 = i3;
            Ed448.sign(this.data, 0, bArr4, 0, bArr, bArr2, i2, i3, bArr3, i4);
        } else if (i5 != 1) {
            throw new IllegalArgumentException("algorithm");
        } else if (64 == i3) {
            Ed448.signPrehash(this.data, 0, bArr4, 0, bArr, bArr2, i2, bArr3, i4);
        } else {
            throw new IllegalArgumentException("msgLen");
        }
    }

    public Ed448PrivateKeyParameters(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[57];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 57);
    }

    public Ed448PrivateKeyParameters(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[57];
        this.data = bArr;
        if (57 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 private key");
        }
    }
}
