package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

public class SPHINCSPlusPublicKeyParameters extends SPHINCSPlusKeyParameters {
    private final PK pk;

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(false, sPHINCSPlusParameters);
        int i = sPHINCSPlusParameters.getEngine().N;
        int i2 = i * 2;
        if (bArr.length == i2) {
            this.pk = new PK(Arrays.copyOfRange(bArr, 0, i), Arrays.copyOfRange(bArr, i, i2));
            return;
        }
        throw new IllegalArgumentException("public key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        PK pk2 = this.pk;
        return Arrays.concatenate(intToBigEndian, pk2.seed, pk2.root);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.pk.root);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.pk.seed);
    }

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, PK pk2) {
        super(false, sPHINCSPlusParameters);
        this.pk = pk2;
    }
}
