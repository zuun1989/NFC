package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import java.util.EventListener;

public interface APDUListener extends EventListener {
    void exchangedAPDU(APDUEvent aPDUEvent);
}
