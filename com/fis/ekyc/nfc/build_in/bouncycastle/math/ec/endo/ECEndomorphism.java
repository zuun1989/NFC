package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.endo;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPointMap;

public interface ECEndomorphism {
    ECPointMap getPointMap();

    boolean hasEfficientPointMap();
}
