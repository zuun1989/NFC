package com.fis.ekyc.nfc.build_in.scuba.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.EACTags;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.IrisImageInfo;
import com.google.android.gms.auth.api.credentials.CredentialsApi;

public final class Hex {
    private static final String HEXCHARS = "0123456789abcdefABCDEF";
    private static final boolean LEFT = true;
    private static final String PRINTABLE = " .,:;'`\"<>()[]{}?/\\!@#$%^&*_-=+|~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final boolean RIGHT = false;

    private Hex() {
    }

    public static String byteToHexString(byte b) {
        String str;
        byte b2 = b & 255;
        StringBuilder sb2 = new StringBuilder();
        if (b2 < 16) {
            str = "0";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(Integer.toHexString(b2));
        return sb2.toString().toUpperCase();
    }

    public static String bytesToASCIIString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            char c = (char) b;
            if (PRINTABLE.indexOf(c) < 0) {
                c = '.';
            }
            stringBuffer.append(Character.toString(c));
        }
        return stringBuffer.toString();
    }

    public static String[] bytesToASCIIStrings(byte[] bArr, int i, int i2) {
        byte[][] split = split(bArr, i);
        String[] strArr = new String[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            strArr[i3] = bytesToASCIIString(split[i3]);
        }
        return strArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        return bytesToHexString(bArr, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT);
    }

    public static String bytesToPrettyString(byte[] bArr) {
        return bytesToPrettyString(bArr, 16, LEFT, 4, (String) null, LEFT);
    }

    public static String bytesToSpacedHexString(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(byteToHexString(bArr[i]));
            if (i < bArr.length - 1) {
                str = " ";
            } else {
                str = "";
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString().toUpperCase();
    }

    private static String[] bytesToSpacedHexStrings(byte[] bArr, int i, int i2) {
        byte[][] split = split(bArr, i);
        String[] strArr = new String[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            String bytesToSpacedHexString = bytesToSpacedHexString(split[i3]);
            strArr[i3] = bytesToSpacedHexString;
            strArr[i3] = pad(bytesToSpacedHexString, i2, ' ', RIGHT);
        }
        return strArr;
    }

    public static int hexDigitToInt(char c) throws NumberFormatException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case EACTags.CARD_SEQUENCE_NUMBER:
                return 4;
            case EACTags.SEX:
                return 5;
            case EACTags.CURRENCY_EXPONENT:
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 10;
                    case EACTags.ADDRESS:
                        return 11;
                    case EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE:
                        return 12;
                    case EACTags.APPLICATION_IMAGE:
                        return 13;
                    case EACTags.DISPLAY_IMAGE:
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case LDSFile.EF_DG1_TAG:
                                return 10;
                            case 'b':
                                return 11;
                            case LDSFile.EF_DG3_TAG:
                                return 12;
                            case IrisImageInfo.IMAGE_QUAL_HIGH_HI:
                                return 13;
                            case LDSFile.EF_DG5_TAG:
                                return 14;
                            case LDSFile.EF_DG6_TAG:
                                return 15;
                            default:
                                throw new NumberFormatException();
                        }
                }
        }
    }

    public static byte hexStringToByte(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes.length == 1) {
            return hexStringToBytes[0];
        }
        throw new NumberFormatException();
    }

    public static byte[] hexStringToBytes(String str) throws NumberFormatException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isWhitespace(charAt)) {
                if (HEXCHARS.indexOf(charAt) >= 0) {
                    stringBuffer.append(charAt);
                } else {
                    throw new NumberFormatException();
                }
            }
        }
        if (stringBuffer.length() % 2 != 0) {
            stringBuffer.insert(0, "0");
        }
        byte[] bArr = new byte[(stringBuffer.length() / 2)];
        for (int i2 = 0; i2 < stringBuffer.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) (((hexDigitToInt(stringBuffer.charAt(i2)) & 255) << 4) | (hexDigitToInt(stringBuffer.charAt(i2 + 1)) & 255));
        }
        return bArr;
    }

    public static int hexStringToInt(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes.length == 4) {
            return (hexStringToBytes[3] & 255) | ((hexStringToBytes[0] & 255) << 24) | ((hexStringToBytes[1] & 255) << 16) | ((hexStringToBytes[2] & 255) << 8);
        }
        throw new NumberFormatException();
    }

    public static short hexStringToShort(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes.length == 2) {
            return (short) ((hexStringToBytes[1] & 255) | ((hexStringToBytes[0] & 255) << 8));
        }
        throw new NumberFormatException();
    }

    public static String intToHexString(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb2 = new StringBuilder();
        String str7 = "";
        if (i < 268435456) {
            str = "0";
        } else {
            str = str7;
        }
        sb2.append(str);
        if (i < 16777216) {
            str2 = "0";
        } else {
            str2 = str7;
        }
        sb2.append(str2);
        if (i < 1048576) {
            str3 = "0";
        } else {
            str3 = str7;
        }
        sb2.append(str3);
        if (i < 65536) {
            str4 = "0";
        } else {
            str4 = str7;
        }
        sb2.append(str4);
        if (i < 4096) {
            str5 = "0";
        } else {
            str5 = str7;
        }
        sb2.append(str5);
        if (i < 256) {
            str6 = "0";
        } else {
            str6 = str7;
        }
        sb2.append(str6);
        if (i < 16) {
            str7 = "0";
        }
        sb2.append(str7);
        sb2.append(Integer.toHexString(i));
        return sb2.toString().toUpperCase();
    }

    private static String pad(String str, int i, char c, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        if (length >= i) {
            return str;
        }
        int i2 = i - length;
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(c);
        }
        if (z) {
            return stringBuffer.toString() + str;
        }
        return str + stringBuffer.toString();
    }

    public static String shortToHexString(short s) {
        String str;
        String str2;
        short s2 = 65535 & s;
        StringBuilder sb2 = new StringBuilder();
        String str3 = "";
        if (s2 < 4096) {
            str = "0";
        } else {
            str = str3;
        }
        sb2.append(str);
        if (s2 < 256) {
            str2 = "0";
        } else {
            str2 = str3;
        }
        sb2.append(str2);
        if (s2 < 16) {
            str3 = "0";
        }
        sb2.append(str3);
        sb2.append(Integer.toHexString(s));
        String sb3 = sb2.toString();
        if (sb3.length() > 4) {
            sb3 = sb3.substring(sb3.length() - 4, sb3.length());
        }
        return sb3.toUpperCase();
    }

    public static byte[][] split(byte[] bArr, int i) {
        int i2;
        int length = bArr.length / i;
        int length2 = bArr.length % i;
        if (length2 > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        byte[][] bArr2 = new byte[(i2 + length)][];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            byte[] bArr3 = new byte[i];
            bArr2[i4] = bArr3;
            System.arraycopy(bArr, i3, bArr3, 0, i);
            i3 += i;
        }
        if (length2 > 0) {
            byte[] bArr4 = new byte[length2];
            bArr2[length] = bArr4;
            System.arraycopy(bArr, i3, bArr4, 0, length2);
        }
        return bArr2;
    }

    public static String toHexString(byte[] bArr) {
        return bytesToHexString(bArr, 0, bArr.length, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT);
    }

    public static String bytesToHexString(byte[] bArr, int i) {
        if (bArr == null) {
            return "NULL";
        }
        return bytesToHexString(bArr, 0, bArr.length, i);
    }

    public static String bytesToPrettyString(byte[] bArr, int i, boolean z, int i2, String str, boolean z2) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        String[] bytesToSpacedHexStrings = bytesToSpacedHexStrings(bArr, i, i * 3);
        String[] bytesToASCIIStrings = bytesToASCIIStrings(bArr, i, i);
        for (int i3 = 0; i3 < bytesToSpacedHexStrings.length; i3++) {
            if (z) {
                String upperCase = Integer.toHexString(i3 * i).toUpperCase();
                stringBuffer.append(pad(upperCase, i2, '0', LEFT) + ": ");
            } else {
                if (i3 == 0) {
                    str2 = str;
                } else {
                    str2 = "";
                }
                stringBuffer.append(pad(str2, i2, ' ', LEFT) + " ");
            }
            stringBuffer.append(bytesToSpacedHexStrings[i3]);
            if (z2) {
                stringBuffer.append(" " + bytesToASCIIStrings[i3]);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static String toHexString(byte[] bArr, int i) {
        return bytesToHexString(bArr, 0, bArr.length, i);
    }

    public static String bytesToHexString(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            return "NULL";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 != 0 && i4 % i3 == 0) {
                stringBuffer.append("\n");
            }
            stringBuffer.append(byteToHexString(bArr[i + i4]));
        }
        return stringBuffer.toString();
    }

    public static String bytesToHexString(byte[] bArr, int i, int i2) {
        return bytesToHexString(bArr, i, i2, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT);
    }
}
