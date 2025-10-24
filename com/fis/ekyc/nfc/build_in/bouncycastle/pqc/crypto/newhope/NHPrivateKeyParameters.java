package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class NHPrivateKeyParameters extends AsymmetricKeyParameter {
    final short[] secData;

    public NHPrivateKeyParameters(short[] sArr) {
        super(true);
        this.secData = Arrays.clone(sArr);
    }

    public short[] getSecData() {
        return Arrays.clone(this.secData);
    }
}
