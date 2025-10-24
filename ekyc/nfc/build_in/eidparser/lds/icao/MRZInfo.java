package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.EACTags;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractLDSInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.IrisImageInfo;
import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.scuba.data.Gender;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class MRZInfo extends AbstractLDSInfo {
    public static final int DOC_TYPE_ID1 = 1;
    public static final int DOC_TYPE_ID2 = 2;
    public static final int DOC_TYPE_ID3 = 3;
    public static final int DOC_TYPE_UNSPECIFIED = 0;
    private static final String MRZ_CHARS = "<0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final long serialVersionUID = 7054965914471297804L;
    private char compositeCheckDigit;
    private String dateOfBirth;
    private char dateOfBirthCheckDigit;
    private String dateOfExpiry;
    private char dateOfExpiryCheckDigit;
    private String documentCode;
    private String documentNumber;
    private char documentNumberCheckDigit;
    private DocumentType documentType;
    private Gender gender;
    private String issuingState;
    private String nationality;
    private String optionalData1;
    private String optionalData2;
    private String primaryIdentifier;
    private String secondaryIdentifier;

    /* renamed from: com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType;
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$scuba$data$Gender;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        static {
            /*
                com.fis.ekyc.nfc.build_in.scuba.data.Gender[] r0 = com.fis.ekyc.nfc.build_in.scuba.data.Gender.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fis$ekyc$nfc$build_in$scuba$data$Gender = r0
                r1 = 1
                com.fis.ekyc.nfc.build_in.scuba.data.Gender r2 = com.fis.ekyc.nfc.build_in.scuba.data.Gender.MALE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$fis$ekyc$nfc$build_in$scuba$data$Gender     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fis.ekyc.nfc.build_in.scuba.data.Gender r3 = com.fis.ekyc.nfc.build_in.scuba.data.Gender.FEMALE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType[] r2 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType = r2
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType r3 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.TD1     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType r2 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.TD2     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType r1 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.MRVB     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType r1 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.MRVA     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo$DocumentType r1 = com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.DocumentType.TD3     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DocumentType {
        UNKNOWN(0),
        TD1(1),
        TD2(2),
        TD3(3),
        MRVA(4),
        MRVB(5);
        
        private int code;

        private DocumentType(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    @Deprecated
    public MRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender2, String str8, String str9) {
        this(getDocumentTypeFromDocumentCode(str), str, str2, str5, personalNumberToOptionalData(str9), str7, gender2, str8, str6, (String) null, str3, str4);
    }

    public static char checkDigit(String str) {
        return checkDigit(str, false);
    }

    public static MRZInfo createMRVAMRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender2, String str8, String str9) {
        return new MRZInfo(DocumentType.MRVA, str, str2, str5, str9, str7, gender2, str8, str6, (String) null, str3, str4);
    }

    public static MRZInfo createMRVBMRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender2, String str8, String str9) {
        return new MRZInfo(DocumentType.MRVB, str, str2, str5, str9, str7, gender2, str8, str6, (String) null, str3, str4);
    }

    public static MRZInfo createTD1MRZInfo(String str, String str2, String str3, String str4, String str5, Gender gender2, String str6, String str7, String str8, String str9, String str10) {
        return new MRZInfo(DocumentType.TD1, str, str2, str3, str4, str5, gender2, str6, str7, str8, str9, str10);
    }

    public static MRZInfo createTD2MRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender2, String str8, String str9) {
        return new MRZInfo(DocumentType.TD2, str, str2, str5, str9, str7, gender2, str8, str6, (String) null, str3, str4);
    }

    public static MRZInfo createTD3MRZInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, Gender gender2, String str8, String str9) {
        return new MRZInfo(DocumentType.TD3, str, str2, str5, personalNumberToOptionalData(str9), str7, gender2, str8, str6, (String) null, str3, str4);
    }

    private static int decodeMRZDigit(byte b) {
        if (b == 60) {
            return 0;
        }
        switch (b) {
            case 48:
                return 0;
            case 49:
                return 1;
            case 50:
                return 2;
            case 51:
                return 3;
            case EACTags.CARD_SEQUENCE_NUMBER:
                return 4;
            case EACTags.SEX:
                return 5;
            case EACTags.CURRENCY_EXPONENT:
                return 6;
            case 55:
                return 7;
            case 56:
                return 8;
            case 57:
                return 9;
            default:
                switch (b) {
                    case 65:
                        return 10;
                    case EACTags.ADDRESS:
                        return 11;
                    case EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE:
                        return 12;
                    case EACTags.APPLICATION_IMAGE:
                        return 13;
                    case EACTags.DISPLAY_IMAGE:
                        return 14;
                    case 70:
                        return 15;
                    case EACTags.MESSAGE_REFERENCE:
                        return 16;
                    case 72:
                        return 17;
                    case 73:
                        return 18;
                    case EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY:
                        return 19;
                    case 75:
                        return 20;
                    case 76:
                        return 21;
                    case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID:
                        return 22;
                    case 78:
                        return 23;
                    case 79:
                        return 24;
                    case 80:
                        return 25;
                    case EACTags.ANSWER_TO_RESET:
                        return 26;
                    case EACTags.HISTORICAL_BYTES:
                        return 27;
                    case ISO781611.DISCRETIONARY_DATA_FOR_PAYLOAD_TAG:
                        return 28;
                    case 84:
                        return 29;
                    case 85:
                        return 30;
                    case 86:
                        return 31;
                    case 87:
                        return 32;
                    case 88:
                        return 33;
                    case 89:
                        return 34;
                    case 90:
                        return 35;
                    default:
                        switch (b) {
                            case LDSFile.EF_DG1_TAG:
                                return 10;
                            case 98:
                                return 11;
                            case LDSFile.EF_DG3_TAG:
                                return 12;
                            case IrisImageInfo.IMAGE_QUAL_HIGH_HI /*100*/:
                                return 13;
                            case LDSFile.EF_DG5_TAG:
                                return 14;
                            case LDSFile.EF_DG6_TAG:
                                return 15;
                            case LDSFile.EF_DG7_TAG:
                                return 16;
                            case LDSFile.EF_DG8_TAG:
                                return 17;
                            case LDSFile.EF_DG9_TAG:
                                return 18;
                            case LDSFile.EF_DG10_TAG:
                                return 19;
                            case LDSFile.EF_DG11_TAG:
                                return 20;
                            case LDSFile.EF_DG12_TAG:
                                return 21;
                            case LDSFile.EF_DG13_TAG:
                                return 22;
                            case LDSFile.EF_DG14_TAG:
                                return 23;
                            case LDSFile.EF_DG15_TAG:
                                return 24;
                            case LDSFile.EF_DG16_TAG:
                                return 25;
                            case 113:
                                return 26;
                            case 114:
                                return 27;
                            case ISO781611.DISCRETIONARY_DATA_FOR_PAYLOAD_CONSTRUCTED_TAG:
                                return 28;
                            case 116:
                                return 29;
                            case LDSFile.EF_DG2_TAG:
                                return 30;
                            case LDSFile.EF_DG4_TAG:
                                return 31;
                            case LDSFile.EF_SOD_TAG:
                                return 32;
                            case 120:
                                return 33;
                            case 121:
                                return 34;
                            case 122:
                                return 35;
                            default:
                                throw new NumberFormatException("Could not decode MRZ character " + b + " ('" + Character.toString((char) b) + "')");
                        }
                }
        }
    }

    public static boolean equalsModuloFillerChars(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int max = Math.max(str.length(), str2.length());
        return mrzFormat(str, max).equals(mrzFormat(str2, max));
    }

    private static String genderToString(Gender gender2) {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$scuba$data$Gender[gender2.ordinal()];
        if (i == 1) {
            return "M";
        }
        if (i != 2) {
            return "<";
        }
        return "F";
    }

    private String getComposite(DocumentType documentType2) {
        StringBuilder sb2 = new StringBuilder();
        int length = this.documentNumber.length();
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType[documentType2.ordinal()];
        if (i == 1) {
            if (length <= 9) {
                sb2.append(mrzFormat(this.documentNumber, 9));
                sb2.append(this.documentNumberCheckDigit);
                sb2.append(mrzFormat(this.optionalData1, 15));
            } else {
                sb2.append(this.documentNumber.substring(0, 9));
                sb2.append("<");
                String substring = this.documentNumber.substring(9);
                sb2.append(substring);
                sb2.append(this.documentNumberCheckDigit);
                String substring2 = mrzFormat(this.optionalData1, 15).substring(substring.length() + 1);
                sb2.append(mrzFormat(substring2, substring2.length()));
            }
            sb2.append(this.dateOfBirth);
            sb2.append(this.dateOfBirthCheckDigit);
            sb2.append(this.dateOfExpiry);
            sb2.append(this.dateOfExpiryCheckDigit);
            sb2.append(mrzFormat(this.optionalData2, 11));
            return sb2.toString();
        } else if (i == 2 || i == 3) {
            sb2.append(this.documentNumber);
            sb2.append(this.documentNumberCheckDigit);
            sb2.append(this.dateOfBirth);
            sb2.append(this.dateOfBirthCheckDigit);
            sb2.append(this.dateOfExpiry);
            sb2.append(this.dateOfExpiryCheckDigit);
            sb2.append(mrzFormat(this.optionalData1, 7));
            return sb2.toString();
        } else if (i == 4 || i == 5) {
            sb2.append(this.documentNumber);
            sb2.append(this.documentNumberCheckDigit);
            sb2.append(this.dateOfBirth);
            sb2.append(this.dateOfBirthCheckDigit);
            sb2.append(this.dateOfExpiry);
            sb2.append(this.dateOfExpiryCheckDigit);
            sb2.append(mrzFormat(this.optionalData1, 15));
            return sb2.toString();
        } else {
            throw new IllegalStateException("Unsupported document type");
        }
    }

    private static DocumentType getDocumentTypeFromDocumentCode(String str) {
        if (str.startsWith("A") || str.startsWith("C") || str.startsWith("I")) {
            return DocumentType.TD1;
        }
        if (str.startsWith("V")) {
            return DocumentType.MRVB;
        }
        if (str.startsWith("P")) {
            return DocumentType.TD3;
        }
        return DocumentType.UNKNOWN;
    }

    private static boolean isDocumentCodeConsistentWithDocumentType(DocumentType documentType2, String str) {
        if (str == null) {
            return false;
        }
        if (str.length() != 1 && str.length() != 2) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType[documentType2.ordinal()];
        if (i == 1 || i == 2) {
            if (str.startsWith("C") || str.startsWith("I") || str.startsWith("A")) {
                return true;
            }
            return false;
        } else if (i == 3 || i == 4) {
            return str.startsWith("V");
        } else {
            if (i != 5) {
                return false;
            }
            return str.startsWith("P");
        }
    }

    private static boolean isOptionalDataConsistentWithDocumentType(DocumentType documentType2, String str, String str2) {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType[documentType2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return false;
                        }
                        if ((str == null || str.length() <= 15) && str2 == null) {
                            return true;
                        }
                        return false;
                    } else if ((str == null || str.length() <= 16) && str2 == null) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((str == null || str.length() <= 8) && str2 == null) {
                    return true;
                } else {
                    return false;
                }
            } else if ((str == null || str.length() <= 7) && str2 == null) {
                return true;
            } else {
                return false;
            }
        } else if (str != null && str.length() > 15) {
            return false;
        } else {
            if (str2 == null || str2.length() <= 11) {
                return true;
            }
            return false;
        }
    }

    private static String mrzFormat(String str, int i) {
        if (str == null) {
            return "";
        }
        if (str.length() <= i) {
            String trim = str.toUpperCase().trim();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < trim.length(); i2++) {
                char charAt = trim.charAt(i2);
                if (MRZ_CHARS.indexOf(charAt) == -1) {
                    sb2.append(MrzParser.FILLER);
                } else {
                    sb2.append(charAt);
                }
            }
            while (sb2.length() < i) {
                sb2.append("<");
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("Argument too wide (" + str.length() + " > " + i + ")");
    }

    private static String nameToString(String str, String str2, int i) {
        String[] strArr;
        String[] split = str.split(" |<");
        if (str2 == null || str2.trim().isEmpty()) {
            strArr = new String[0];
        } else {
            strArr = str2.split(" |<");
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z = true;
        boolean z2 = true;
        for (String str3 : split) {
            if (z2) {
                z2 = false;
            } else {
                sb2.append(MrzParser.FILLER);
            }
            sb2.append(str3);
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            sb2.append("<<");
            for (String str4 : strArr) {
                if (z) {
                    z = false;
                } else {
                    sb2.append(MrzParser.FILLER);
                }
                sb2.append(str4);
            }
        }
        return mrzFormat(sb2.toString(), i);
    }

    private static String personalNumberToOptionalData(String str) {
        if (str == null || equalsModuloFillerChars(str, "")) {
            return "";
        }
        if (str.length() == 15) {
            return str;
        }
        if (str.length() <= 14) {
            return mrzFormat(str, 14) + checkDigit(str, true);
        }
        throw new IllegalArgumentException("Wrong personal number: " + str);
    }

    private String readCountry(DataInputStream dataInputStream) throws IOException {
        return readString(dataInputStream, 3);
    }

    private String readDateOfBirth(DataInputStream dataInputStream) throws IOException, NumberFormatException {
        return readString(dataInputStream, 6);
    }

    private String readDateOfExpiry(DataInputStream dataInputStream) throws IOException {
        return readString(dataInputStream, 6);
    }

    private Gender readGender(DataInputStream dataInputStream) throws IOException {
        String readString = readString(dataInputStream, 1);
        if ("M".equalsIgnoreCase(readString)) {
            return Gender.MALE;
        }
        if ("F".equalsIgnoreCase(readString)) {
            return Gender.FEMALE;
        }
        return Gender.UNKNOWN;
    }

    private void readNameIdentifiers(String str) {
        int indexOf = str.indexOf("<<");
        if (indexOf < 0) {
            this.primaryIdentifier = trimTrailingFillerChars(str).replace("<", " ");
            this.secondaryIdentifier = "";
            return;
        }
        this.primaryIdentifier = trimTrailingFillerChars(str.substring(0, indexOf));
        readSecondaryIdentifiers(str.substring(indexOf + 2));
    }

    private void readObject(InputStream inputStream, int i) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        String trimTrailingFillerChars = trimTrailingFillerChars(readString(dataInputStream, 2));
        this.documentCode = trimTrailingFillerChars;
        DocumentType documentType2 = getDocumentType(trimTrailingFillerChars, i);
        this.documentType = documentType2;
        int i2 = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType[documentType2.ordinal()];
        if (i2 == 1) {
            readObjectTD1(dataInputStream);
        } else if (i2 == 2 || i2 == 3) {
            readObjectTD2orMRVB(dataInputStream);
        } else {
            readObjectTD3OrMRVA(dataInputStream);
        }
    }

    private void readObjectTD1(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        this.issuingState = readCountry(dataInputStream);
        this.documentNumber = readString(dataInputStream, 9);
        this.documentNumberCheckDigit = (char) dataInputStream.readUnsignedByte();
        String trimTrailingFillerChars = trimTrailingFillerChars(readString(dataInputStream, 15));
        this.optionalData1 = trimTrailingFillerChars;
        if (this.documentNumberCheckDigit == '<' && !trimTrailingFillerChars.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.documentNumber);
            String str = this.optionalData1;
            sb2.append(str.substring(0, str.length() - 1));
            this.documentNumber = sb2.toString();
            String str2 = this.optionalData1;
            this.documentNumberCheckDigit = str2.charAt(str2.length() - 1);
            this.optionalData1 = "";
        }
        this.documentNumber = trimTrailingFillerChars(this.documentNumber);
        this.dateOfBirth = readDateOfBirth(dataInputStream);
        this.dateOfBirthCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.gender = readGender(dataInputStream);
        this.dateOfExpiry = readDateOfExpiry(dataInputStream);
        this.dateOfExpiryCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.nationality = readCountry(dataInputStream);
        this.optionalData2 = readString(dataInputStream, 11);
        this.compositeCheckDigit = (char) dataInputStream.readUnsignedByte();
        readNameIdentifiers(readString(dataInputStream, 30));
    }

    private void readObjectTD2orMRVB(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        this.issuingState = readCountry(dataInputStream);
        readNameIdentifiers(readString(dataInputStream, 31));
        this.documentNumber = trimTrailingFillerChars(readString(dataInputStream, 9));
        this.documentNumberCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.nationality = readCountry(dataInputStream);
        this.dateOfBirth = readDateOfBirth(dataInputStream);
        this.dateOfBirthCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.gender = readGender(dataInputStream);
        this.dateOfExpiry = readDateOfExpiry(dataInputStream);
        this.dateOfExpiryCheckDigit = (char) dataInputStream.readUnsignedByte();
        String trimTrailingFillerChars = trimTrailingFillerChars(readString(dataInputStream, 7));
        this.optionalData1 = trimTrailingFillerChars;
        if (this.documentType == DocumentType.TD2 && this.documentNumberCheckDigit == '<' && !trimTrailingFillerChars.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.documentNumber);
            String str = this.optionalData1;
            sb2.append(str.substring(0, str.length() - 1));
            this.documentNumber = sb2.toString();
            String str2 = this.optionalData1;
            this.documentNumberCheckDigit = str2.charAt(str2.length() - 1);
            this.optionalData1 = "";
        }
        this.documentNumber = trimTrailingFillerChars(this.documentNumber);
        this.compositeCheckDigit = (char) dataInputStream.readUnsignedByte();
    }

    private void readObjectTD3OrMRVA(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        this.issuingState = readCountry(dataInputStream);
        readNameIdentifiers(readString(dataInputStream, 39));
        this.documentNumber = trimTrailingFillerChars(readString(dataInputStream, 9));
        this.documentNumberCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.nationality = readCountry(dataInputStream);
        this.dateOfBirth = readDateOfBirth(dataInputStream);
        this.dateOfBirthCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.gender = readGender(dataInputStream);
        this.dateOfExpiry = readDateOfExpiry(dataInputStream);
        this.dateOfExpiryCheckDigit = (char) dataInputStream.readUnsignedByte();
        this.optionalData1 = trimTrailingFillerChars(readString(dataInputStream, 15));
        this.compositeCheckDigit = (char) dataInputStream.readUnsignedByte();
    }

    private void readSecondaryIdentifiers(String str) {
        this.secondaryIdentifier = trimTrailingFillerChars(str).replace("<", " ");
    }

    private String readString(DataInputStream dataInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        return new String(bArr).trim();
    }

    private static String trimTrailingFillerChars(String str) {
        byte[] bytes = str.trim().getBytes();
        int length = bytes.length - 1;
        while (length >= 0 && bytes[length] == 60) {
            bytes[length] = ISO7816.INS_VERIFY;
            length--;
        }
        return new String(bytes).trim();
    }

    private void writeDateOfBirth(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.dateOfBirth.getBytes("UTF-8"));
    }

    private void writeDateOfExpiry(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.dateOfExpiry.getBytes("UTF-8"));
    }

    private void writeDocumentType(DataOutputStream dataOutputStream) throws IOException {
        writeString(this.documentCode, dataOutputStream, 2);
    }

    private void writeGender(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(genderToString(this.gender).getBytes("UTF-8"));
    }

    private void writeIssuingState(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.issuingState.getBytes("UTF-8"));
    }

    private void writeName(DataOutputStream dataOutputStream, int i) throws IOException {
        dataOutputStream.write(nameToString(this.primaryIdentifier, this.secondaryIdentifier, i).getBytes("UTF-8"));
    }

    private void writeNationality(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.nationality.getBytes("UTF-8"));
    }

    private void writeObjectTD1(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        writeDocumentType(dataOutputStream);
        writeIssuingState(dataOutputStream);
        if (this.documentNumber.length() <= 9 || !equalsModuloFillerChars(this.optionalData1, "")) {
            writeString(this.documentNumber, dataOutputStream, 9);
            dataOutputStream.write(this.documentNumberCheckDigit);
            writeString(this.optionalData1, dataOutputStream, 15);
        } else {
            writeString(this.documentNumber.substring(0, 9), dataOutputStream, 9);
            dataOutputStream.write(60);
            StringBuilder sb2 = new StringBuilder();
            String str = this.documentNumber;
            sb2.append(str.substring(9, str.length()));
            sb2.append(this.documentNumberCheckDigit);
            sb2.append("<");
            writeString(sb2.toString(), dataOutputStream, 15);
        }
        writeDateOfBirth(dataOutputStream);
        dataOutputStream.write(this.dateOfBirthCheckDigit);
        writeGender(dataOutputStream);
        writeDateOfExpiry(dataOutputStream);
        dataOutputStream.write(this.dateOfExpiryCheckDigit);
        writeNationality(dataOutputStream);
        writeString(this.optionalData2, dataOutputStream, 11);
        dataOutputStream.write(this.compositeCheckDigit);
        writeName(dataOutputStream, 30);
    }

    private void writeObjectTD2OrMRVB(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        boolean z;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        writeDocumentType(dataOutputStream);
        writeIssuingState(dataOutputStream);
        writeName(dataOutputStream, 31);
        if (this.documentType != DocumentType.TD2 || this.documentNumber.length() <= 9 || !equalsModuloFillerChars(this.optionalData1, "")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            writeString(this.documentNumber.substring(0, 9), dataOutputStream, 9);
            dataOutputStream.write(60);
        } else {
            writeString(this.documentNumber, dataOutputStream, 9);
            dataOutputStream.write(this.documentNumberCheckDigit);
        }
        writeNationality(dataOutputStream);
        writeDateOfBirth(dataOutputStream);
        dataOutputStream.write(this.dateOfBirthCheckDigit);
        writeGender(dataOutputStream);
        writeDateOfExpiry(dataOutputStream);
        dataOutputStream.write(this.dateOfExpiryCheckDigit);
        if (this.documentType == DocumentType.MRVB) {
            writeString(this.optionalData1, dataOutputStream, 8);
        } else if (z) {
            StringBuilder sb2 = new StringBuilder();
            String str = this.documentNumber;
            sb2.append(str.substring(9, str.length()));
            sb2.append(this.documentNumberCheckDigit);
            sb2.append("<");
            writeString(sb2.toString(), dataOutputStream, 7);
            dataOutputStream.write(this.compositeCheckDigit);
        } else {
            writeString(this.optionalData1, dataOutputStream, 7);
            dataOutputStream.write(this.compositeCheckDigit);
        }
    }

    private void writeObjectTD3OrMRVA(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        writeDocumentType(dataOutputStream);
        writeIssuingState(dataOutputStream);
        writeName(dataOutputStream, 39);
        writeString(this.documentNumber, dataOutputStream, 9);
        dataOutputStream.write(this.documentNumberCheckDigit);
        writeNationality(dataOutputStream);
        writeDateOfBirth(dataOutputStream);
        dataOutputStream.write(this.dateOfBirthCheckDigit);
        writeGender(dataOutputStream);
        writeDateOfExpiry(dataOutputStream);
        dataOutputStream.write(this.dateOfExpiryCheckDigit);
        if (this.documentType == DocumentType.MRVA) {
            writeString(this.optionalData1, dataOutputStream, 16);
            return;
        }
        writeString(this.optionalData1, dataOutputStream, 15);
        dataOutputStream.write(this.compositeCheckDigit);
    }

    private void writeString(String str, DataOutputStream dataOutputStream, int i) throws IOException {
        dataOutputStream.write(mrzFormat(str, i).getBytes("UTF-8"));
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MRZInfo mRZInfo = (MRZInfo) obj;
        String str = this.documentCode;
        if ((str != null || mRZInfo.documentCode != null) && (str == null || !str.equals(mRZInfo.documentCode))) {
            return false;
        }
        String str2 = this.issuingState;
        if ((str2 != null || mRZInfo.issuingState != null) && (str2 == null || !str2.equals(mRZInfo.issuingState))) {
            return false;
        }
        String str3 = this.primaryIdentifier;
        if ((str3 != null || mRZInfo.primaryIdentifier != null) && (str3 == null || !str3.equals(mRZInfo.primaryIdentifier))) {
            return false;
        }
        String str4 = this.secondaryIdentifier;
        if ((str4 != null || mRZInfo.secondaryIdentifier != null) && !equalsModuloFillerChars(str4, mRZInfo.secondaryIdentifier)) {
            return false;
        }
        String str5 = this.nationality;
        if ((str5 != null || mRZInfo.nationality != null) && (str5 == null || !str5.equals(mRZInfo.nationality))) {
            return false;
        }
        String str6 = this.documentNumber;
        if ((str6 != null || mRZInfo.documentNumber != null) && (str6 == null || !str6.equals(mRZInfo.documentNumber))) {
            return false;
        }
        String str7 = this.optionalData1;
        if ((str7 != null || mRZInfo.optionalData1 != null) && ((str7 == null || !str7.equals(mRZInfo.optionalData1)) && !getPersonalNumber().equals(mRZInfo.getPersonalNumber()))) {
            return false;
        }
        String str8 = this.dateOfBirth;
        if ((str8 != null || mRZInfo.dateOfBirth != null) && (str8 == null || !str8.equals(mRZInfo.dateOfBirth))) {
            return false;
        }
        Gender gender2 = this.gender;
        if ((gender2 != null || mRZInfo.gender != null) && (gender2 == null || !gender2.equals(mRZInfo.gender))) {
            return false;
        }
        String str9 = this.dateOfExpiry;
        if ((str9 != null || mRZInfo.dateOfExpiry != null) && (str9 == null || !str9.equals(mRZInfo.dateOfExpiry))) {
            return false;
        }
        String str10 = this.optionalData2;
        if ((str10 != null || mRZInfo.optionalData2 != null) && (str10 == null || !equalsModuloFillerChars(str10, mRZInfo.optionalData2))) {
            return false;
        }
        return true;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getDateOfExpiry() {
        return this.dateOfExpiry;
    }

    public String getDocumentCode() {
        return this.documentCode;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    @Deprecated
    public int getDocumentType() {
        return this.documentType.getCode();
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getIssuingState() {
        return this.issuingState;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getOptionalData1() {
        return this.optionalData1;
    }

    public String getOptionalData2() {
        return this.optionalData2;
    }

    public String getPersonalNumber() {
        String str;
        String str2 = this.optionalData1;
        if (str2 == null) {
            return null;
        }
        if (str2.length() > 14) {
            str = this.optionalData1.substring(0, 14);
        } else {
            str = this.optionalData1;
        }
        return trimTrailingFillerChars(str);
    }

    public String getPrimaryIdentifier() {
        return this.primaryIdentifier;
    }

    public String getSecondaryIdentifier() {
        return this.secondaryIdentifier;
    }

    public String[] getSecondaryIdentifierComponents() {
        return this.secondaryIdentifier.split(" |<");
    }

    public int hashCode() {
        return (toString().hashCode() * 2) + 53;
    }

    @Deprecated
    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
        checkDigit();
    }

    @Deprecated
    public void setDateOfExpiry(String str) {
        this.dateOfExpiry = str;
        checkDigit();
    }

    @Deprecated
    public void setDocumentCode(String str) {
        this.documentCode = str;
        DocumentType documentTypeFromDocumentCode = getDocumentTypeFromDocumentCode(str);
        this.documentType = documentTypeFromDocumentCode;
        if (documentTypeFromDocumentCode == DocumentType.TD1 && this.optionalData2 == null) {
            this.optionalData2 = "";
        }
    }

    @Deprecated
    public void setDocumentNumber(String str) {
        this.documentNumber = str.trim();
        checkDigit();
    }

    @Deprecated
    public void setGender(Gender gender2) {
        this.gender = gender2;
        checkDigit();
    }

    @Deprecated
    public void setIssuingState(String str) {
        this.issuingState = str;
        checkDigit();
    }

    @Deprecated
    public void setNationality(String str) {
        this.nationality = str;
        checkDigit();
    }

    @Deprecated
    public void setOptionalData2(String str) {
        this.optionalData2 = trimTrailingFillerChars(str);
        checkDigit();
    }

    @Deprecated
    public void setPersonalNumber(String str) {
        if (str == null || str.length() > 14) {
            throw new IllegalArgumentException("Wrong personal number");
        }
        this.optionalData1 = mrzFormat(str, 14) + checkDigit(str, true);
    }

    @Deprecated
    public void setPrimaryIdentifier(String str) {
        this.primaryIdentifier = str.trim();
        checkDigit();
    }

    @Deprecated
    public void setSecondaryIdentifierComponents(String[] strArr) {
        if (strArr == null) {
            this.secondaryIdentifier = null;
        } else {
            for (String str : strArr) {
            }
        }
        checkDigit();
    }

    @Deprecated
    public void setSecondaryIdentifiers(String str) {
        readSecondaryIdentifiers(str.trim());
        checkDigit();
    }

    public String toString() {
        try {
            String str = new String(getEncoded(), "UTF-8");
            int length = str.length();
            if (length == 72) {
                return str.substring(0, 36) + "\n" + str.substring(36, 72) + "\n";
            } else if (length == 88) {
                return str.substring(0, 44) + "\n" + str.substring(44, 88) + "\n";
            } else if (length != 90) {
                return str;
            } else {
                return str.substring(0, 30) + "\n" + str.substring(30, 60) + "\n" + str.substring(60, 90) + "\n";
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$eidparser$lds$icao$MRZInfo$DocumentType[this.documentType.ordinal()];
        if (i == 1) {
            writeObjectTD1(outputStream);
        } else if (i == 2 || i == 3) {
            writeObjectTD2OrMRVB(outputStream);
        } else if (i == 4 || i == 5) {
            writeObjectTD3OrMRVA(outputStream);
        } else {
            throw new IllegalStateException("Unsupported document type ");
        }
    }

    @Deprecated
    public MRZInfo(String str, String str2, String str3, String str4, String str5, Gender gender2, String str6, String str7, String str8, String str9, String str10) {
        this(getDocumentTypeFromDocumentCode(str), str, str2, str3, str4, str5, gender2, str6, str7, str8, str9, str10);
    }

    private void checkDigit() {
        this.documentNumberCheckDigit = checkDigit(this.documentNumber);
        this.dateOfBirthCheckDigit = checkDigit(this.dateOfBirth);
        this.dateOfExpiryCheckDigit = checkDigit(this.dateOfExpiry);
        if (this.documentType == DocumentType.TD3 && this.optionalData1.length() < 15) {
            String mrzFormat = mrzFormat(this.optionalData1, 14);
            char checkDigit = checkDigit(mrzFormat(this.optionalData1, 14), true);
            this.optionalData1 = mrzFormat + checkDigit;
        }
        this.compositeCheckDigit = checkDigit(getComposite(this.documentType));
    }

    private static DocumentType getDocumentType(String str, int i) {
        if (str == null || str.length() < 1 || str.length() > 2) {
            throw new IllegalArgumentException("Was expecting 1 or 2 digit document code, got " + str);
        } else if (i != 72) {
            if (i != 88) {
                if (i != 90) {
                    return DocumentType.UNKNOWN;
                }
                return DocumentType.TD1;
            } else if (str.startsWith("V")) {
                return DocumentType.MRVA;
            } else {
                return DocumentType.TD3;
            }
        } else if (str.startsWith("V")) {
            return DocumentType.MRVB;
        } else {
            return DocumentType.TD2;
        }
    }

    public MRZInfo(InputStream inputStream, int i) {
        try {
            readObject(inputStream, i);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public MRZInfo(String str) {
        if (str != null) {
            String replace = str.trim().replace("\n", "");
            try {
                readObject(new ByteArrayInputStream(replace.getBytes("UTF-8")), replace.length());
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException("Exception", e);
            } catch (IOException e2) {
                throw new IllegalArgumentException("Exception", e2);
            }
        } else {
            throw new IllegalArgumentException("Null string");
        }
    }

    private static char checkDigit(String str, boolean z) {
        byte[] bArr;
        if (str == null) {
            try {
                bArr = new byte[0];
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Error in computing check digit", e);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Error in computing check digit", e2);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Error in computing check digit", e3);
            }
        } else {
            bArr = str.getBytes("UTF-8");
        }
        int[] iArr = {7, 3, 1};
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i = (i + (iArr[i2 % 3] * decodeMRZDigit(bArr[i2]))) % 10;
        }
        String num = Integer.toString(i);
        if (num.length() == 1) {
            char c = (char) num.getBytes("UTF-8")[0];
            return (!z || c != '0') ? c : MrzParser.FILLER;
        }
        throw new IllegalStateException("Error in computing check digit.");
    }

    private MRZInfo(DocumentType documentType2, String str, String str2, String str3, String str4, String str5, Gender gender2, String str6, String str7, String str8, String str9, String str10) {
        this.documentType = documentType2;
        if (!isDocumentCodeConsistentWithDocumentType(documentType2, str)) {
            throw new IllegalArgumentException("Wrong document code");
        } else if (!isOptionalDataConsistentWithDocumentType(documentType2, str4, str8)) {
            throw new IllegalArgumentException("Wrong optional data length");
        } else if (gender2 != null) {
            this.documentCode = trimTrailingFillerChars(str);
            this.issuingState = str2;
            this.primaryIdentifier = str9;
            this.secondaryIdentifier = str10;
            this.documentNumber = trimTrailingFillerChars(str3);
            this.nationality = str7;
            this.dateOfBirth = str5;
            this.gender = gender2;
            this.dateOfExpiry = str6;
            this.optionalData1 = str4 == null ? "" : str4;
            this.optionalData2 = str8;
            checkDigit();
        } else {
            throw new IllegalArgumentException("Gender must not be null");
        }
    }
}
