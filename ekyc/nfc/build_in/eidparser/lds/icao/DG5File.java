package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.lds.DisplayedImageDataGroup;
import com.fis.ekyc.nfc.build_in.eidparser.lds.DisplayedImageInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DG5File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = 923840683207218244L;

    public DG5File(List<DisplayedImageInfo> list) {
        super(LDSFile.EF_DG5_TAG, list, DisplayedImageInfo.DISPLAYED_PORTRAIT_TAG);
    }

    public DG5File(InputStream inputStream) throws IOException {
        super(LDSFile.EF_DG5_TAG, inputStream);
    }
}
