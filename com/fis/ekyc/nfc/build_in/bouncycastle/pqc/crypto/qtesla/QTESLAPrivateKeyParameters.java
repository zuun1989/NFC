package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public final class QTESLAPrivateKeyParameters extends AsymmetricKeyParameter {
    private byte[] privateKey;
    private int securityCategory;

    public QTESLAPrivateKeyParameters(int i, byte[] bArr) {
        super(true);
        if (bArr.length == QTESLASecurityCategory.getPrivateSize(i)) {
            this.securityCategory = i;
            this.privateKey = Arrays.clone(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getSecret() {
        return Arrays.clone(this.privateKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
