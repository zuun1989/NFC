package com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import java.security.PublicKey;

public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
