package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

@Deprecated
public class BACDeniedException extends CardServiceException {
    private static final long serialVersionUID = -7094953658210693249L;
    private final BACKeySpec bacKey;

    public BACDeniedException(String str, BACKeySpec bACKeySpec, int i) {
        super(str, i);
        this.bacKey = bACKeySpec;
    }

    public BACKeySpec getBACKey() {
        return this.bacKey;
    }
}
