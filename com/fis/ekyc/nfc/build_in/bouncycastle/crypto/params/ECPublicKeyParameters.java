package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {
    private final ECPoint q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.q = eCDomainParameters.validatePublicPoint(eCPoint);
    }

    public ECPoint getQ() {
        return this.q;
    }
}
