package com.fis.ekyc.nfc.build_in.bouncycastle.crypto;

public interface AlphabetMapper {
    char[] convertToChars(byte[] bArr);

    byte[] convertToIndexes(char[] cArr);

    int getRadix();
}
