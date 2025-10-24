package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.lds.DisplayedImageDataGroup;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.IOException;
import java.io.InputStream;

public class DG6File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = -583717105472408528L;

    public DG6File(InputStream inputStream) throws IOException {
        super(LDSFile.EF_DG6_TAG, inputStream);
    }
}
