package com.fis.ekyc.nfc.build_in.eidparser.ext;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream;
import com.fis.ekyc.nfc.build_in.utils.StringUtil;
import java.io.IOException;
import w4.C0060a;

public class DG13File {
    private String allHex;

    public DG13File(CardFileInputStream cardFileInputStream) throws IOException {
        this.allHex = StringUtil.bytesToHex(C0060a.a(cardFileInputStream));
    }

    public byte[] getDecode() {
        return StringUtil.hexToByte(this.allHex);
    }

    public DG13File() {
    }

    public DG13File(byte[] bArr) throws IOException {
        this.allHex = StringUtil.bytesToHex(bArr);
    }
}
