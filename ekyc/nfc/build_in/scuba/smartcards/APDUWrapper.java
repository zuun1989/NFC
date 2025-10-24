package com.fis.ekyc.nfc.build_in.scuba.smartcards;

public interface APDUWrapper {
    String getType();

    ResponseAPDU unwrap(ResponseAPDU responseAPDU);

    CommandAPDU wrap(CommandAPDU commandAPDU);
}
