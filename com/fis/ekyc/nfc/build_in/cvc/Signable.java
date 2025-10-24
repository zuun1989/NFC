package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;

public interface Signable {
    byte[] getTBS() throws ConstructionException;
}
