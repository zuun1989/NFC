package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

import java.math.BigInteger;

public interface ECMultiplier {
    ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger);
}
