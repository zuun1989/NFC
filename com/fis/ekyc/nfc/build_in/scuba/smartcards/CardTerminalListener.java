package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import java.util.EventListener;

public interface CardTerminalListener extends EventListener {
    void cardInserted(CardEvent cardEvent);

    void cardRemoved(CardEvent cardEvent);
}
