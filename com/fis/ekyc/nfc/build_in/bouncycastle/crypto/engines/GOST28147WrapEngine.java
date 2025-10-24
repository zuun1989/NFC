package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Wrapper;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.GOST28147Mac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithUKM;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class GOST28147WrapEngine implements Wrapper {
    private GOST28147Engine cipher = new GOST28147Engine();
    private GOST28147Mac mac = new GOST28147Mac();

    public String getAlgorithmName() {
        return "GOST28147Wrap";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.cipher.init(z, parametersWithUKM.getParameters());
        this.mac.init(new ParametersWithIV(parametersWithUKM.getParameters(), parametersWithUKM.getUKM()));
    }

    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int macSize = i2 - this.mac.getMacSize();
        byte[] bArr2 = new byte[macSize];
        this.cipher.processBlock(bArr, i, bArr2, 0);
        this.cipher.processBlock(bArr, i + 8, bArr2, 8);
        this.cipher.processBlock(bArr, i + 16, bArr2, 16);
        this.cipher.processBlock(bArr, i + 24, bArr2, 24);
        byte[] bArr3 = new byte[this.mac.getMacSize()];
        this.mac.update(bArr2, 0, macSize);
        this.mac.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[this.mac.getMacSize()];
        System.arraycopy(bArr, (i + i2) - 4, bArr4, 0, this.mac.getMacSize());
        if (Arrays.constantTimeAreEqual(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    public byte[] wrap(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
        byte[] bArr2 = new byte[(this.mac.getMacSize() + i2)];
        this.cipher.processBlock(bArr, i, bArr2, 0);
        this.cipher.processBlock(bArr, i + 8, bArr2, 8);
        this.cipher.processBlock(bArr, i + 16, bArr2, 16);
        this.cipher.processBlock(bArr, i + 24, bArr2, 24);
        this.mac.doFinal(bArr2, i2);
        return bArr2;
    }
}
