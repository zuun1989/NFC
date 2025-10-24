package com.fis.ekyc.nfc.build_in.eidparser.lds;

import java.io.Serializable;

public interface LDSElement extends Serializable {
    byte[] getEncoded();
}
