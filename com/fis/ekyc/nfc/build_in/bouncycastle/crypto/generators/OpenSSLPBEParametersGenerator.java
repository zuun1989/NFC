package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.PBEParametersGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    private Digest digest = DigestFactory.createMD5();

    private byte[] generateDerivedKey(int i) {
        int i2;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        byte[] bArr2 = new byte[i];
        int i3 = 0;
        while (true) {
            Digest digest2 = this.digest;
            byte[] bArr3 = this.password;
            digest2.update(bArr3, 0, bArr3.length);
            Digest digest3 = this.digest;
            byte[] bArr4 = this.salt;
            digest3.update(bArr4, 0, bArr4.length);
            this.digest.doFinal(bArr, 0);
            if (i > digestSize) {
                i2 = digestSize;
            } else {
                i2 = i;
            }
            System.arraycopy(bArr, 0, bArr2, i3, i2);
            i3 += i2;
            i -= i2;
            if (i == 0) {
                return bArr2;
            }
            this.digest.reset();
            this.digest.update(bArr, 0, digestSize);
        }
    }

    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(i2), 0, i2);
    }

    public void init(byte[] bArr, byte[] bArr2) {
        super.init(bArr, bArr2, 1);
    }

    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] generateDerivedKey = generateDerivedKey(i3 + i4);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i3), generateDerivedKey, i3, i4);
    }
}
