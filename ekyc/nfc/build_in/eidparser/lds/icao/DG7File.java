package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.lds.DisplayedImageDataGroup;
import com.fis.ekyc.nfc.build_in.eidparser.lds.DisplayedImageInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DG7File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = 7189545112850471359L;

    public DG7File(List<DisplayedImageInfo> list) {
        super(LDSFile.EF_DG7_TAG, list, DisplayedImageInfo.DISPLAYED_SIGNATURE_OR_MARK_TAG);
    }

    public DG7File(InputStream inputStream) throws IOException {
        super(LDSFile.EF_DG7_TAG, inputStream);
    }
}
