package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface CharToByteConverter {
    byte[] convert(char[] cArr);

    String getType();
}
