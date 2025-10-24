package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public final class QTESLAPublicKeyParameters extends AsymmetricKeyParameter {
    private byte[] publicKey;
    private int securityCategory;

    public QTESLAPublicKeyParameters(int i, byte[] bArr) {
        super(false);
        if (bArr.length == QTESLASecurityCategory.getPublicSize(i)) {
            this.securityCategory = i;
            this.publicKey = Arrays.clone(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getPublicData() {
        return Arrays.clone(this.publicKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
