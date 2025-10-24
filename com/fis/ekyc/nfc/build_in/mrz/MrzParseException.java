package com.fis.ekyc.nfc.build_in.mrz;

import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;

public class MrzParseException extends RuntimeException {
    private static final long serialVersionUID = 1;
    public final MrzFormat format;
    public final String mrz;
    public final MrzRange range;

    public MrzParseException(String str, String str2, MrzRange mrzRange, MrzFormat mrzFormat) {
        super("Failed to parse MRZ " + mrzFormat + " " + str2 + " at " + mrzRange + ": " + str);
        this.mrz = str2;
        this.format = mrzFormat;
        this.range = mrzRange;
    }
}
