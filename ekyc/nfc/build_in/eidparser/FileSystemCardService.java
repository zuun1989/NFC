package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;

public abstract class FileSystemCardService extends CardService {
    @Deprecated
    public abstract CardFileInputStream getInputStream(short s) throws CardServiceException;

    public abstract CardFileInputStream getInputStream(short s, int i) throws CardServiceException;
}
