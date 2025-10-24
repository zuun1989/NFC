package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.RawAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PublicKeyParameters;

public final class X25519Agreement implements RawAgreement {
    private X25519PrivateKeyParameters privateKey;

    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        this.privateKey.generateSecret((X25519PublicKeyParameters) cipherParameters, bArr, i);
    }

    public int getAgreementSize() {
        return 32;
    }

    public void init(CipherParameters cipherParameters) {
        this.privateKey = (X25519PrivateKeyParameters) cipherParameters;
    }
}
