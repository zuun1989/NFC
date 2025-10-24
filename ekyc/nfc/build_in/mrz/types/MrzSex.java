package com.fis.ekyc.nfc.build_in.mrz.types;

public enum MrzSex {
    Male('M'),
    Female('F'),
    Unspecified('X');
    
    public final char mrz;

    private MrzSex(char c) {
        this.mrz = c;
    }

    public static MrzSex fromMrz(char c) {
        if (c != '<') {
            if (c == 'F') {
                return Female;
            }
            if (c == 'M') {
                return Male;
            }
            if (c != 'X') {
                throw new RuntimeException("Invalid MRZ sex character: " + c);
            }
        }
        return Unspecified;
    }
}
