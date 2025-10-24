package com.fis.ekyc.nfc.build_in.utils;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;

public final class StringUtil {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final String TAG = StringUtil.class.getName();

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & IdCardService.SFI_DG15];
        }
        return new String(cArr);
    }

    public static String cutTLVString(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        int indexOf = str.indexOf(str2) + str2.length();
        return str.substring(indexOf, indexOf + 2);
    }

    public static String hexToASCII(String str) {
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            sb2.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return sb2.toString();
    }

    public static byte[] hexToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String hexToUTF8(String str) throws Exception {
        return new String(hexToByte(str), "UTF-8");
    }

    public static int indexOfTagWithLength(String str, String str2) {
        if (str2 == null) {
            return -1;
        }
        return str.indexOf(str2) + str2.length() + 2;
    }
}
