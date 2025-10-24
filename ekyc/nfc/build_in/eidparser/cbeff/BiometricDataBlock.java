package com.fis.ekyc.nfc.build_in.eidparser.cbeff;

import java.io.Serializable;

public interface BiometricDataBlock extends Serializable {
    StandardBiometricHeader getStandardBiometricHeader();
}
