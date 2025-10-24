package com.fis.ekyc.nfc.build_in.mrz;

import com.fis.ekyc.nfc.build_in.mrz.types.MrzDate;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzSex;
import java.io.PrintStream;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class MrzParser {
    private static final Map<String, String> EXPAND_CHARACTERS;
    public static final char FILLER = '<';
    private static final int[] MRZ_WEIGHTS = {7, 3, 1};
    public final MrzFormat format;
    public final String mrz;
    public final String[] rows;

    static {
        HashMap hashMap = new HashMap();
        EXPAND_CHARACTERS = hashMap;
        hashMap.put("Ä", "AE");
        hashMap.put("ä", "AE");
        hashMap.put("Å", "AA");
        hashMap.put("å", "AA");
        hashMap.put("Æ", "AE");
        hashMap.put("æ", "AE");
        hashMap.put("Ĳ", "IJ");
        hashMap.put("ĳ", "IJ");
        hashMap.put("Ö", "OE");
        hashMap.put("ö", "OE");
        hashMap.put("Ø", "OE");
        hashMap.put("ø", "OE");
        hashMap.put("Ü", "UE");
        hashMap.put("ü", "UE");
        hashMap.put("ß", "SS");
    }

    public MrzParser(String str) {
        this.mrz = str;
        this.rows = str.split("\n");
        this.format = MrzFormat.get(str);
    }

    public static int computeCheckDigit(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int characterValue = getCharacterValue(str.charAt(i2));
            int[] iArr = MRZ_WEIGHTS;
            i += characterValue * iArr[i2 % iArr.length];
        }
        return i % 10;
    }

    public static char computeCheckDigitChar(String str) {
        return (char) (computeCheckDigit(str) + 48);
    }

    private static String deaccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    private static int getCharacterValue(char c) {
        if (c == '<') {
            return 0;
        }
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'Z') {
            return c - '7';
        }
        throw new RuntimeException("Invalid character in MRZ record: " + c);
    }

    private static int getNameSize(String[] strArr, String[] strArr2) {
        int i = 0;
        for (String length : strArr) {
            i += length.length() + 1;
        }
        for (String length2 : strArr2) {
            i += length2.length() + 1;
        }
        return i;
    }

    private static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    private static boolean isValid(char c) {
        return c == '<' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    public static String nameToMrz(String str, String str2, int i) {
        if (isBlank(str)) {
            throw new IllegalArgumentException("Parameter surname: invalid value " + str + ": blank");
        } else if (isBlank(str2)) {
            throw new IllegalArgumentException("Parameter givenNames: invalid value " + str2 + ": blank");
        } else if (i > 0) {
            String replace = str.replace(", ", " ");
            String replace2 = str2.replace(", ", " ");
            String[] split = replace.trim().split("[ \n\t\f\r]+");
            String[] split2 = replace2.trim().split("[ \n\t\f\r]+");
            for (int i2 = 0; i2 < split.length; i2++) {
                split[i2] = toMrz(split[i2], -1);
            }
            for (int i3 = 0; i3 < split2.length; i3++) {
                split2[i3] = toMrz(split2[i3], -1);
            }
            int length = split2.length - 1;
            String[] strArr = split2;
            for (int nameSize = getNameSize(split, split2); nameSize > i; nameSize = getNameSize(split, split2)) {
                String str3 = strArr[length];
                int length2 = str3.length();
                if ((nameSize - length2) + 1 <= i) {
                    strArr[length] = str3.substring(0, length2 - (nameSize - i));
                } else {
                    strArr[length] = str3.substring(0, 1);
                    length--;
                    if (length >= 0) {
                        continue;
                    } else if (strArr != split) {
                        strArr = split;
                        length = split.length - 1;
                    } else {
                        throw new IllegalArgumentException("Cannot truncate name " + replace + " " + replace2 + ": length too small: " + i + "; truncated to " + toName(split, split2));
                    }
                }
            }
            return toMrz(toName(split, split2), i);
        } else {
            throw new IllegalArgumentException("Parameter length: invalid value " + i + ": not positive");
        }
    }

    public static MrzRecord parse(String str) {
        MrzRecord newRecord = MrzFormat.get(str).newRecord();
        newRecord.fromMrz(str);
        return newRecord;
    }

    public static String toMrz(String str, int i) {
        if (str == null) {
            str = "";
        }
        for (Map.Entry next : EXPAND_CHARACTERS.entrySet()) {
            str = str.replace((CharSequence) next.getKey(), (CharSequence) next.getValue());
        }
        String upperCase = deaccent(str.replace("’", "").replace("'", "")).toUpperCase();
        if (i >= 0 && upperCase.length() > i) {
            upperCase = upperCase.substring(0, i);
        }
        StringBuilder sb2 = new StringBuilder(upperCase);
        for (int i2 = 0; i2 < sb2.length(); i2++) {
            if (!isValid(sb2.charAt(i2))) {
                sb2.setCharAt(i2, FILLER);
            }
        }
        while (sb2.length() < i) {
            sb2.append(FILLER);
        }
        return sb2.toString();
    }

    private static String toName(String[] strArr, String[] strArr2) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = true;
        for (String str : strArr) {
            if (z) {
                z = false;
            } else {
                sb2.append(FILLER);
            }
            sb2.append(str);
        }
        sb2.append(FILLER);
        for (String append : strArr2) {
            sb2.append(FILLER);
            sb2.append(append);
        }
        return sb2.toString();
    }

    public boolean checkDigit(int i, int i2, MrzRange mrzRange, String str) {
        return checkDigit(i, i2, rawValue(mrzRange), str);
    }

    public void checkValidCharacters(MrzRange mrzRange) {
        String rawValue = rawValue(mrzRange);
        int i = 0;
        while (i < rawValue.length()) {
            char charAt = rawValue.charAt(i);
            if (charAt == '<' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z'))) {
                i++;
            } else {
                String str = "Invalid character in MRZ record: " + charAt;
                String str2 = this.mrz;
                int i2 = mrzRange.column;
                throw new MrzParseException(str, str2, new MrzRange(i2 + i, i2 + i + 1, mrzRange.row), this.format);
            }
        }
    }

    public MrzDate parseDate(MrzRange mrzRange) {
        int i;
        int i2;
        if (mrzRange.length() == 6) {
            int i3 = mrzRange.column;
            MrzRange mrzRange2 = new MrzRange(i3, i3 + 2, mrzRange.row);
            int i4 = -1;
            try {
                i = Integer.parseInt(rawValue(mrzRange2));
            } catch (NumberFormatException unused) {
                i = -1;
            }
            int i5 = mrzRange.column;
            try {
                i2 = Integer.parseInt(rawValue(new MrzRange(i5 + 2, i5 + 4, mrzRange.row)));
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
            int i6 = mrzRange.column;
            try {
                i4 = Integer.parseInt(rawValue(new MrzRange(i6 + 4, i6 + 6, mrzRange.row)));
            } catch (NumberFormatException unused3) {
            }
            return new MrzDate(i, i2, i4, rawValue(mrzRange));
        }
        throw new IllegalArgumentException("Parameter range: invalid value " + mrzRange + ": must be 6 characters long");
    }

    public String[] parseName(MrzRange mrzRange) {
        checkValidCharacters(mrzRange);
        String rawValue = rawValue(mrzRange);
        while (rawValue.endsWith("<")) {
            rawValue = rawValue.substring(0, rawValue.length() - 1);
        }
        String[] split = rawValue.split("<<");
        int i = mrzRange.column;
        String parseString = parseString(new MrzRange(i, split[0].length() + i, mrzRange.row));
        String str = "";
        if (split.length == 1) {
            int i2 = mrzRange.column;
            parseString = str;
            str = parseString(new MrzRange(i2, split[0].length() + i2, mrzRange.row));
        } else if (split.length > 1) {
            int i3 = mrzRange.column;
            parseString = parseString(new MrzRange(i3, split[0].length() + i3, mrzRange.row));
            str = parseString(new MrzRange(mrzRange.column + split[0].length() + 2, mrzRange.column + rawValue.length(), mrzRange.row));
        }
        return new String[]{parseString, str};
    }

    public MrzSex parseSex(int i, int i2) {
        return MrzSex.fromMrz(this.rows[i2].charAt(i));
    }

    public String parseString(MrzRange mrzRange) {
        checkValidCharacters(mrzRange);
        String rawValue = rawValue(mrzRange);
        while (rawValue.endsWith("<")) {
            rawValue = rawValue.substring(0, rawValue.length() - 1);
        }
        return rawValue.replace("<<", ", ").replace(FILLER, ' ');
    }

    public String rawValue(MrzRange... mrzRangeArr) {
        StringBuilder sb2 = new StringBuilder();
        for (MrzRange mrzRange : mrzRangeArr) {
            sb2.append(this.rows[mrzRange.row].substring(mrzRange.column, mrzRange.columnTo));
        }
        return sb2.toString();
    }

    public boolean checkDigit(int i, int i2, String str, String str2) {
        MrzRange mrzRange;
        char c = '0';
        char computeCheckDigit = (char) (computeCheckDigit(str) + 48);
        char charAt = this.rows[i2].charAt(i);
        if (charAt != '<') {
            c = charAt;
        }
        if (computeCheckDigit != c) {
            mrzRange = new MrzRange(i, i + 1, i2);
            PrintStream printStream = System.out;
            printStream.println("Check digit verification failed for " + str2 + ": expected " + computeCheckDigit + " but got " + c);
        } else {
            mrzRange = null;
        }
        return mrzRange == null;
    }
}
