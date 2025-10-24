package com.fis.ekyc.nfc.build_in.eidparser.lds;

import java.io.IOException;
import java.io.InputStream;

public abstract class DataGroup extends AbstractTaggedLDSFile {
    private static final long serialVersionUID = -4761360877353069639L;

    public DataGroup(int i) {
        super(i);
    }

    public String toString() {
        return "DataGroup [" + Integer.toHexString(getTag()) + " (" + getLength() + ")]";
    }

    public DataGroup(int i, InputStream inputStream) throws IOException {
        super(i, inputStream);
    }
}
