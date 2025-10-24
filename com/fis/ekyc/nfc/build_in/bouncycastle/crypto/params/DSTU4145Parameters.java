package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class DSTU4145Parameters extends ECDomainParameters {
    private final byte[] dke;

    public DSTU4145Parameters(ECDomainParameters eCDomainParameters, byte[] bArr) {
        super(eCDomainParameters.getCurve(), eCDomainParameters.getG(), eCDomainParameters.getN(), eCDomainParameters.getH(), eCDomainParameters.getSeed());
        this.dke = Arrays.clone(bArr);
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }
}
