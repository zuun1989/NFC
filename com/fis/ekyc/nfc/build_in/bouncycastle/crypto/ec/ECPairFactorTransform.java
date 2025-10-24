package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec;

import java.math.BigInteger;

public interface ECPairFactorTransform extends ECPairTransform {
    BigInteger getTransformValue();
}
