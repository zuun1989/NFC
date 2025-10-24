package com.fis.ekyc.nfc.build_in.model;

import com.fis.ekyc.nfc.build_in.scuba.data.Gender;
import java.io.InputStream;

public class MRZInfo extends com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo {
    public MRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender, String str8, String str9) {
        super(str, str2, str3, str4, str5, str6, str7, gender, str8, str9);
    }

    public MRZInfo(String str, String str2, String str3, String str4, String str5, Gender gender, String str6, String str7, String str8, String str9, String str10) {
        super(str, str2, str3, str4, str5, gender, str6, str7, str8, str9, str10);
    }

    public MRZInfo(InputStream inputStream, int i) {
        super(inputStream, i);
    }

    public MRZInfo(String str) {
        super(str);
    }
}
