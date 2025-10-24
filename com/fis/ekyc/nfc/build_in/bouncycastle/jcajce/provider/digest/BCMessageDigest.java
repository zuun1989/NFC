package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.digest;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Xof;
import java.security.MessageDigest;

public class BCMessageDigest extends MessageDigest {
    protected Digest digest;
    protected int digestSize;

    public BCMessageDigest(Digest digest2) {
        super(digest2.getAlgorithmName());
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.digestSize];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public int engineGetDigestLength() {
        return this.digestSize;
    }

    public void engineReset() {
        this.digest.reset();
    }

    public void engineUpdate(byte b) {
        this.digest.update(b);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public BCMessageDigest(Xof xof, int i) {
        super(xof.getAlgorithmName());
        this.digest = xof;
        this.digestSize = i / 8;
    }
}
