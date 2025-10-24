package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public class CardServiceProtocolException extends CardServiceException {
    private static final long serialVersionUID = 8527846223511524125L;
    private int step;

    public CardServiceProtocolException(String str, int i) {
        super(str);
        this.step = i;
    }

    public String getMessage() {
        return super.getMessage() + " (step: " + this.step + ")";
    }

    public int getStep() {
        return this.step;
    }

    public CardServiceProtocolException(String str, int i, Throwable th) {
        super(str, th);
        this.step = i;
    }

    public CardServiceProtocolException(String str, int i, int i2) {
        super(str, i2);
        this.step = i;
    }

    public CardServiceProtocolException(String str, int i, Throwable th, int i2) {
        super(str, th, i2);
        this.step = i;
    }
}
