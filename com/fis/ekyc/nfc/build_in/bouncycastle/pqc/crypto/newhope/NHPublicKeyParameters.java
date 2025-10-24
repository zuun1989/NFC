package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class NHPublicKeyParameters extends AsymmetricKeyParameter {
    final byte[] pubData;

    public NHPublicKeyParameters(byte[] bArr) {
        super(false);
        this.pubData = Arrays.clone(bArr);
    }

    public byte[] getPubData() {
        return Arrays.clone(this.pubData);
    }
}
