package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.io.Streams;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class X448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 56;
    private final byte[] data;

    public X448PublicKeyParameters(byte[] bArr, int i) {
        super(false);
        byte[] bArr2 = new byte[56];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 56);
    }

    public void encode(byte[] bArr, int i) {
        System.arraycopy(this.data, 0, bArr, i, 56);
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public X448PublicKeyParameters(InputStream inputStream) throws IOException {
        super(false);
        byte[] bArr = new byte[56];
        this.data = bArr;
        if (56 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 public key");
        }
    }
}
