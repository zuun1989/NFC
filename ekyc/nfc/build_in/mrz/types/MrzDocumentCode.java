package com.fis.ekyc.nfc.build_in.mrz.types;

import com.fis.ekyc.nfc.build_in.mrz.MrzParseException;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;

public enum MrzDocumentCode {
    Passport,
    TypeI,
    TypeA,
    CrewMember,
    TypeC,
    TypeV,
    Migrant;

    public static MrzDocumentCode parse(String str) {
        String substring = str.substring(0, 2);
        substring.hashCode();
        char c = 65535;
        switch (substring.hashCode()) {
            case 2082:
                if (substring.equals("AC")) {
                    c = 0;
                    break;
                }
                break;
            case 2343:
                if (substring.equals("IP")) {
                    c = 1;
                    break;
                }
                break;
            case 2349:
                if (substring.equals("IV")) {
                    c = 2;
                    break;
                }
                break;
            case 2456:
                if (substring.equals("ME")) {
                    c = 3;
                    break;
                }
                break;
            case 2672:
                if (substring.equals("TD")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CrewMember;
            case 1:
                return Passport;
            case 2:
                throw new MrzParseException("IV document code is not allowed", str, new MrzRange(0, 2, 0), (MrzFormat) null);
            case 3:
                return Migrant;
            case 4:
                return Migrant;
            default:
                char charAt = substring.charAt(0);
                if (charAt == 'A') {
                    return TypeA;
                }
                if (charAt == 'C') {
                    return TypeC;
                }
                if (charAt == 'I') {
                    return TypeI;
                }
                if (charAt != 'P') {
                    if (charAt == 'R') {
                        return Migrant;
                    }
                    if (charAt != 'T') {
                        if (charAt == 'V') {
                            return TypeV;
                        }
                        throw new MrzParseException("Unsupported document code: " + substring, str, new MrzRange(0, 2, 0), (MrzFormat) null);
                    }
                }
                return Passport;
        }
    }
}
