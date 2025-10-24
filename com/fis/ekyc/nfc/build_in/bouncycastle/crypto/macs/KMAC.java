package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Mac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Xof;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.CSHAKEDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.XofUtils;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;

public class KMAC implements Mac, Xof {
    private static final byte[] padding = new byte[100];
    private final int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private boolean initialised;
    private byte[] key;
    private final int outputLength;

    public KMAC(int i, byte[] bArr) {
        this.cshake = new CSHAKEDigest(i, Strings.toByteArray("KMAC"), bArr);
        this.bitLength = i;
        this.outputLength = (i * 2) / 8;
    }

    private void bytePad(byte[] bArr, int i) {
        byte[] leftEncode = XofUtils.leftEncode((long) i);
        update(leftEncode, 0, leftEncode.length);
        byte[] encode = encode(bArr);
        update(encode, 0, encode.length);
        int length = i - ((leftEncode.length + encode.length) % i);
        if (length > 0 && length != i) {
            while (true) {
                byte[] bArr2 = padding;
                if (length > bArr2.length) {
                    update(bArr2, 0, bArr2.length);
                    length -= bArr2.length;
                } else {
                    update(bArr2, 0, length);
                    return;
                }
            }
        }
    }

    private static byte[] encode(byte[] bArr) {
        return Arrays.concatenate(XofUtils.leftEncode((long) (bArr.length * 8)), bArr);
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode((long) (getMacSize() * 8));
                this.cshake.update(rightEncode, 0, rightEncode.length);
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        int doFinal = this.cshake.doFinal(bArr, i, getMacSize());
        reset();
        return doFinal;
    }

    public int doOutput(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode(0);
                this.cshake.update(rightEncode, 0, rightEncode.length);
                this.firstOutput = false;
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        return this.cshake.doOutput(bArr, i, i2);
    }

    public String getAlgorithmName() {
        return "KMAC" + this.cshake.getAlgorithmName().substring(6);
    }

    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    public int getDigestSize() {
        return this.outputLength;
    }

    public int getMacSize() {
        return this.outputLength;
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        this.key = Arrays.clone(((KeyParameter) cipherParameters).getKey());
        this.initialised = true;
        reset();
    }

    public void reset() {
        this.cshake.reset();
        byte[] bArr = this.key;
        if (bArr != null) {
            if (this.bitLength == 128) {
                bytePad(bArr, 168);
            } else {
                bytePad(bArr, ISO781611.FORMAT_TYPE_TAG);
            }
        }
        this.firstOutput = true;
    }

    public void update(byte b) throws IllegalStateException {
        if (this.initialised) {
            this.cshake.update(b);
            return;
        }
        throw new IllegalStateException("KMAC not initialized");
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (this.initialised) {
            this.cshake.update(bArr, i, i2);
            return;
        }
        throw new IllegalStateException("KMAC not initialized");
    }

    public int doFinal(byte[] bArr, int i, int i2) {
        if (this.firstOutput) {
            if (this.initialised) {
                byte[] rightEncode = XofUtils.rightEncode((long) (i2 * 8));
                this.cshake.update(rightEncode, 0, rightEncode.length);
            } else {
                throw new IllegalStateException("KMAC not initialized");
            }
        }
        int doFinal = this.cshake.doFinal(bArr, i, i2);
        reset();
        return doFinal;
    }
}
