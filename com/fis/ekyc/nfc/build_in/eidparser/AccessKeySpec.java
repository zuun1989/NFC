package com.fis.ekyc.nfc.build_in.eidparser;

import java.io.Serializable;
import java.security.spec.KeySpec;

public interface AccessKeySpec extends Serializable, KeySpec {
    String getAlgorithm();

    byte[] getKey();
}
