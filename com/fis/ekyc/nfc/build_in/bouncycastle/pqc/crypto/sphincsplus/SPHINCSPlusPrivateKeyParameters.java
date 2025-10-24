package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

public class SPHINCSPlusPrivateKeyParameters extends SPHINCSPlusKeyParameters {
    final PK pk;
    final SK sk;

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(true, sPHINCSPlusParameters);
        int i = sPHINCSPlusParameters.getEngine().N;
        int i2 = i * 4;
        if (bArr.length == i2) {
            int i3 = i * 2;
            this.sk = new SK(Arrays.copyOfRange(bArr, 0, i), Arrays.copyOfRange(bArr, i, i3));
            int i4 = i * 3;
            this.pk = new PK(Arrays.copyOfRange(bArr, i3, i4), Arrays.copyOfRange(bArr, i4, i2));
            return;
        }
        throw new IllegalArgumentException("private key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        SK sk2 = this.sk;
        byte[] bArr = sk2.seed;
        byte[] bArr2 = sk2.prf;
        PK pk2 = this.pk;
        return Arrays.concatenate(intToBigEndian, Arrays.concatenate(bArr, bArr2, pk2.seed, pk2.root));
    }

    public byte[] getEncodedPublicKey() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        PK pk2 = this.pk;
        return Arrays.concatenate(intToBigEndian, pk2.seed, pk2.root);
    }

    public byte[] getPrf() {
        return Arrays.clone(this.sk.prf);
    }

    public byte[] getPublicKey() {
        PK pk2 = this.pk;
        return Arrays.concatenate(pk2.seed, pk2.root);
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.pk.seed);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.sk.seed);
    }

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, SK sk2, PK pk2) {
        super(true, sPHINCSPlusParameters);
        this.sk = sk2;
        this.pk = pk2;
    }
}
