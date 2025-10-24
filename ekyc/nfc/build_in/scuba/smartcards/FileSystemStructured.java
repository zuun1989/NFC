package com.fis.ekyc.nfc.build_in.scuba.smartcards;

public interface FileSystemStructured {
    FileInfo[] getSelectedPath() throws CardServiceException;

    byte[] readBinary(int i, int i2) throws CardServiceException;

    void selectFile(short s) throws CardServiceException;
}
