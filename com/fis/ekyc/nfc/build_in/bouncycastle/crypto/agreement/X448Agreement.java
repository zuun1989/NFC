package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.RawAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PublicKeyParameters;

public final class X448Agreement implements RawAgreement {
    private X448PrivateKeyParameters privateKey;

    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        this.privateKey.generateSecret((X448PublicKeyParameters) cipherParameters, bArr, i);
    }

    public int getAgreementSize() {
        return 56;
    }

    public void init(CipherParameters cipherParameters) {
        this.privateKey = (X448PrivateKeyParameters) cipherParameters;
    }
}
