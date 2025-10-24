package com.fis.ekyc.nfc.build_in.bouncycastle.util.test;

public final class NumberParsing {
    private NumberParsing() {
    }

    public static int decodeIntFromHex(String str) {
        if (str.charAt(1) == 'x' || str.charAt(1) == 'X') {
            return Integer.parseInt(str.substring(2), 16);
        }
        return Integer.parseInt(str, 16);
    }

    public static long decodeLongFromHex(String str) {
        if (str.charAt(1) == 'x' || str.charAt(1) == 'X') {
            return Long.parseLong(str.substring(2), 16);
        }
        return Long.parseLong(str, 16);
    }
}
