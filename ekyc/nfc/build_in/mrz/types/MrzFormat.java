package com.fis.ekyc.nfc.build_in.mrz.types;

import com.fis.ekyc.nfc.build_in.mrz.MrzParseException;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;
import com.fis.ekyc.nfc.build_in.mrz.MrzRecord;
import com.fis.ekyc.nfc.build_in.mrz.records.FrenchIdCard;
import com.fis.ekyc.nfc.build_in.mrz.records.MRP;
import com.fis.ekyc.nfc.build_in.mrz.records.MrtdTd1;
import com.fis.ekyc.nfc.build_in.mrz.records.MrtdTd2;
import com.fis.ekyc.nfc.build_in.mrz.records.MrvA;
import com.fis.ekyc.nfc.build_in.mrz.records.MrvB;
import com.fis.ekyc.nfc.build_in.mrz.records.SlovakId2_34;

public enum MrzFormat {
    MRTD_TD1(3, 30, MrtdTd1.class),
    FRENCH_ID(2, 36, FrenchIdCard.class) {
        public boolean isFormatOf(String[] strArr) {
            if (!MrzFormat.super.isFormatOf(strArr)) {
                return false;
            }
            return strArr[0].substring(0, 5).equals("IDFRA");
        }
    },
    MRV_VISA_B(2, 36, MrvB.class) {
        public boolean isFormatOf(String[] strArr) {
            if (!MrzFormat.super.isFormatOf(strArr)) {
                return false;
            }
            return strArr[0].substring(0, 1).equals("V");
        }
    },
    MRTD_TD2(2, 36, MrtdTd2.class),
    MRV_VISA_A(2, 44, MrvA.class) {
        public boolean isFormatOf(String[] strArr) {
            if (!MrzFormat.super.isFormatOf(strArr)) {
                return false;
            }
            return strArr[0].substring(0, 1).equals("V");
        }
    },
    PASSPORT(2, 44, MRP.class),
    SLOVAK_ID_234(2, 34, SlovakId2_34.class);
    
    public final int columns;
    private final Class<? extends MrzRecord> recordClass;
    public final int rows;

    public static final MrzFormat get(String str) {
        String[] split = str.split("\n");
        int length = split[0].length();
        int i = 1;
        while (i < split.length) {
            if (split[i].length() == length) {
                i++;
            } else {
                throw new MrzParseException("Different row lengths: 0: " + length + " and " + i + ": " + split[i].length(), str, new MrzRange(0, 0, 0), (MrzFormat) null);
            }
        }
        for (MrzFormat mrzFormat : values()) {
            if (mrzFormat.isFormatOf(split)) {
                return mrzFormat;
            }
        }
        throw new MrzParseException("Unknown format / unsupported number of cols/rows: " + length + "/" + split.length, str, new MrzRange(0, 0, 0), (MrzFormat) null);
    }

    public boolean isFormatOf(String[] strArr) {
        if (this.rows == strArr.length && this.columns == strArr[0].length()) {
            return true;
        }
        return false;
    }

    public final MrzRecord newRecord() {
        try {
            return (MrzRecord) this.recordClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MrzFormat(int i, int i2, Class<? extends MrzRecord> cls) {
        this.rows = i;
        this.columns = i2;
        this.recordClass = cls;
    }
}
