package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class SPHINCSPublicKeyParameters extends SPHINCSKeyParameters {
    private final byte[] keyData;

    public SPHINCSPublicKeyParameters(byte[] bArr) {
        super(false, (String) null);
        this.keyData = Arrays.clone(bArr);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.keyData);
    }

    public SPHINCSPublicKeyParameters(byte[] bArr, String str) {
        super(false, str);
        this.keyData = Arrays.clone(bArr);
    }
}
