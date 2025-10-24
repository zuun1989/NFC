package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.COMFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG11File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG12File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG1File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG2File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG3File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG4File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG5File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG6File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG7File;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LDSFileUtil {
    public static final Map<Short, Byte> FID_TO_SFI = createFIDToSFIMap();
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");

    private static Map<Short, Byte> createFIDToSFIMap() {
        HashMap hashMap = new HashMap(20);
        hashMap.put(Short.valueOf(IdCardService.EF_COM), Byte.valueOf(IdCardService.SFI_COM));
        hashMap.put(Short.valueOf(IdCardService.EF_DG1), (byte) 1);
        hashMap.put(Short.valueOf(IdCardService.EF_DG2), (byte) 2);
        hashMap.put(Short.valueOf(IdCardService.EF_DG3), (byte) 3);
        hashMap.put(Short.valueOf(IdCardService.EF_DG4), (byte) 4);
        hashMap.put(Short.valueOf(IdCardService.EF_DG5), (byte) 5);
        hashMap.put(Short.valueOf(IdCardService.EF_DG6), (byte) 6);
        hashMap.put(Short.valueOf(IdCardService.EF_DG7), (byte) 7);
        hashMap.put(Short.valueOf(IdCardService.EF_DG8), (byte) 8);
        hashMap.put(Short.valueOf(IdCardService.EF_DG9), (byte) 9);
        hashMap.put(Short.valueOf(IdCardService.EF_DG10), (byte) 10);
        hashMap.put(Short.valueOf(IdCardService.EF_DG11), Byte.valueOf(IdCardService.SFI_DG11));
        hashMap.put(Short.valueOf(IdCardService.EF_DG12), Byte.valueOf(IdCardService.SFI_DG12));
        hashMap.put(Short.valueOf(IdCardService.EF_DG13), Byte.valueOf(IdCardService.SFI_DG13));
        hashMap.put(Short.valueOf(IdCardService.EF_DG14), (byte) 14);
        hashMap.put(Short.valueOf(IdCardService.EF_DG15), Byte.valueOf(IdCardService.SFI_DG15));
        hashMap.put(Short.valueOf(IdCardService.EF_DG16), (byte) 16);
        hashMap.put((short) 285, (byte) 29);
        hashMap.put((short) 284, (byte) 28);
        return Collections.unmodifiableMap(hashMap);
    }

    public static List<Integer> getDataGroupNumbers(SODFile sODFile) {
        ArrayList arrayList = new ArrayList();
        if (sODFile == null) {
            return arrayList;
        }
        arrayList.addAll(sODFile.getDataGroupHashes().keySet());
        Collections.sort(arrayList);
        return arrayList;
    }

    public static AbstractLDSFile getLDSFile(short s, InputStream inputStream) throws IOException {
        switch (s) {
            case 257:
                return new DG1File(inputStream);
            case 258:
                return new DG2File(inputStream);
            case 259:
                return new DG3File(inputStream);
            case 260:
                return new DG4File(inputStream);
            case 261:
                return new DG5File(inputStream);
            case 262:
                return new DG6File(inputStream);
            case 263:
                return new DG7File(inputStream);
            case 264:
                throw new IllegalArgumentException("DG8 files are not yet supported");
            case 265:
                throw new IllegalArgumentException("DG9 files are not yet supported");
            case 266:
                throw new IllegalArgumentException("DG10 files are not yet supported");
            case 267:
                return new DG11File(inputStream);
            case 268:
                return new DG12File(inputStream);
            case 269:
                throw new IllegalArgumentException("DG13 files are not yet supported");
            case 270:
                return new DG14File(inputStream);
            case 271:
                return new DG15File(inputStream);
            case 272:
                throw new IllegalArgumentException("DG16 files are not yet supported");
            default:
                switch (s) {
                    case 284:
                        return new CVCAFile(inputStream);
                    case 285:
                        return new SODFile(inputStream);
                    case 286:
                        return new COMFile(inputStream);
                    default:
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 37);
                        try {
                            bufferedInputStream.mark(37);
                            return new CVCAFile(s, (InputStream) bufferedInputStream);
                        } catch (Exception e) {
                            Logger logger = LOGGER;
                            Level level = Level.WARNING;
                            logger.log(level, "Unknown file " + Integer.toHexString(s), e);
                            bufferedInputStream.reset();
                            throw new NumberFormatException("Unknown file " + Integer.toHexString(s));
                        }
                }
        }
    }

    public static int lookupDataGroupNumberByFID(short s) {
        switch (s) {
            case 257:
                return 1;
            case 258:
                return 2;
            case 259:
                return 3;
            case 260:
                return 4;
            case 261:
                return 5;
            case 262:
                return 6;
            case 263:
                return 7;
            case 264:
                return 8;
            case 265:
                return 9;
            case 266:
                return 10;
            case 267:
                return 11;
            case 268:
                return 12;
            case 269:
                return 13;
            case 270:
                return 14;
            case 271:
                return 15;
            case 272:
                return 16;
            default:
                throw new NumberFormatException("Unknown fid " + Integer.toHexString(s));
        }
    }

    public static int lookupDataGroupNumberByTag(int i) {
        if (i == 97) {
            return 1;
        }
        if (i == 99) {
            return 3;
        }
        if (i == 117) {
            return 2;
        }
        if (i == 118) {
            return 4;
        }
        switch (i) {
            case LDSFile.EF_DG5_TAG:
                return 5;
            case LDSFile.EF_DG6_TAG:
                return 6;
            case LDSFile.EF_DG7_TAG:
                return 7;
            case LDSFile.EF_DG8_TAG:
                return 8;
            case LDSFile.EF_DG9_TAG:
                return 9;
            case LDSFile.EF_DG10_TAG:
                return 10;
            case LDSFile.EF_DG11_TAG:
                return 11;
            case LDSFile.EF_DG12_TAG:
                return 12;
            case LDSFile.EF_DG13_TAG:
                return 13;
            case LDSFile.EF_DG14_TAG:
                return 14;
            case LDSFile.EF_DG15_TAG:
                return 15;
            case LDSFile.EF_DG16_TAG:
                return 16;
            default:
                throw new NumberFormatException("Unknown tag " + Integer.toHexString(i));
        }
    }

    public static short lookupFIDByDataGroupNumber(int i) {
        switch (i) {
            case 1:
                return IdCardService.EF_DG1;
            case 2:
                return IdCardService.EF_DG2;
            case 3:
                return IdCardService.EF_DG3;
            case 4:
                return IdCardService.EF_DG4;
            case 5:
                return IdCardService.EF_DG5;
            case 6:
                return IdCardService.EF_DG6;
            case 7:
                return IdCardService.EF_DG7;
            case 8:
                return IdCardService.EF_DG8;
            case 9:
                return IdCardService.EF_DG9;
            case 10:
                return IdCardService.EF_DG10;
            case 11:
                return IdCardService.EF_DG11;
            case 12:
                return IdCardService.EF_DG12;
            case 13:
                return IdCardService.EF_DG13;
            case 14:
                return IdCardService.EF_DG14;
            case 15:
                return IdCardService.EF_DG15;
            case 16:
                return IdCardService.EF_DG16;
            default:
                throw new NumberFormatException("Unknown number " + i);
        }
    }

    public static short lookupFIDBySFI(byte b) {
        switch (b) {
            case 1:
                return IdCardService.EF_DG1;
            case 2:
                return IdCardService.EF_DG2;
            case 3:
                return IdCardService.EF_DG3;
            case 4:
                return IdCardService.EF_DG4;
            case 5:
                return IdCardService.EF_DG5;
            case 6:
                return IdCardService.EF_DG6;
            case 7:
                return IdCardService.EF_DG7;
            case 8:
                return IdCardService.EF_DG8;
            case 9:
                return IdCardService.EF_DG9;
            case 10:
                return IdCardService.EF_DG10;
            case 11:
                return IdCardService.EF_DG11;
            case 12:
                return IdCardService.EF_DG12;
            case 13:
                return IdCardService.EF_DG13;
            case 14:
                return IdCardService.EF_DG14;
            case 15:
                return IdCardService.EF_DG15;
            case 16:
                return IdCardService.EF_DG16;
            default:
                switch (b) {
                    case 28:
                        return 284;
                    case 29:
                        return 285;
                    case 30:
                        return IdCardService.EF_COM;
                    default:
                        throw new NumberFormatException("Unknown SFI " + Integer.toHexString(b));
                }
        }
    }

    public static short lookupFIDByTag(int i) {
        switch (i) {
            case LDSFile.EF_COM_TAG:
                return IdCardService.EF_COM;
            case LDSFile.EF_DG1_TAG:
                return IdCardService.EF_DG1;
            case LDSFile.EF_DG3_TAG:
                return IdCardService.EF_DG3;
            case LDSFile.EF_DG5_TAG:
                return IdCardService.EF_DG5;
            case LDSFile.EF_DG6_TAG:
                return IdCardService.EF_DG6;
            case LDSFile.EF_DG7_TAG:
                return IdCardService.EF_DG7;
            case LDSFile.EF_DG8_TAG:
                return IdCardService.EF_DG8;
            case LDSFile.EF_DG9_TAG:
                return IdCardService.EF_DG9;
            case LDSFile.EF_DG10_TAG:
                return IdCardService.EF_DG10;
            case LDSFile.EF_DG11_TAG:
                return IdCardService.EF_DG11;
            case LDSFile.EF_DG12_TAG:
                return IdCardService.EF_DG12;
            case LDSFile.EF_DG13_TAG:
                return IdCardService.EF_DG13;
            case LDSFile.EF_DG14_TAG:
                return IdCardService.EF_DG14;
            case LDSFile.EF_DG15_TAG:
                return IdCardService.EF_DG15;
            case LDSFile.EF_DG16_TAG:
                return IdCardService.EF_DG16;
            case LDSFile.EF_DG2_TAG:
                return IdCardService.EF_DG2;
            case LDSFile.EF_DG4_TAG:
                return IdCardService.EF_DG4;
            case LDSFile.EF_SOD_TAG:
                return 285;
            default:
                throw new NumberFormatException("Unknown tag " + Integer.toHexString(i));
        }
    }

    public static String lookupFileNameByFID(int i) {
        if (i == 285) {
            return "EF_SOD";
        }
        if (i == 286) {
            return "EF_COM";
        }
        switch (i) {
            case 257:
                return "EF_DG1";
            case 258:
                return "EF_DG2";
            case 259:
                return "EF_DG3";
            case 260:
                return "EF_DG4";
            case 261:
                return "EF_DG5";
            case 262:
                return "EF_DG6";
            case 263:
                return "EF_DG7";
            case 264:
                return "EF_DG8";
            case 265:
                return "EF_DG9";
            case 266:
                return "EF_DG10";
            case 267:
                return "EF_DG11";
            case 268:
                return "EF_DG12";
            case 269:
                return "EF_DG13";
            case 270:
                return "EF_DG14";
            case 271:
                return "EF_DG15";
            case 272:
                return "EF_DG16";
            default:
                return "File with FID 0x" + Integer.toHexString(i);
        }
    }

    public static String lookupFileNameByTag(int i) {
        switch (i) {
            case LDSFile.EF_COM_TAG:
                return "EF_COM";
            case LDSFile.EF_DG1_TAG:
                return "EF_DG1";
            case LDSFile.EF_DG3_TAG:
                return "EF_DG3";
            case LDSFile.EF_DG5_TAG:
                return "EF_DG5";
            case LDSFile.EF_DG6_TAG:
                return "EF_DG6";
            case LDSFile.EF_DG7_TAG:
                return "EF_DG7";
            case LDSFile.EF_DG8_TAG:
                return "EF_DG8";
            case LDSFile.EF_DG9_TAG:
                return "EF_DG9";
            case LDSFile.EF_DG10_TAG:
                return "EF_DG10";
            case LDSFile.EF_DG11_TAG:
                return "EF_DG11";
            case LDSFile.EF_DG12_TAG:
                return "EF_DG12";
            case LDSFile.EF_DG13_TAG:
                return "EF_DG13";
            case LDSFile.EF_DG14_TAG:
                return "EF_DG14";
            case LDSFile.EF_DG15_TAG:
                return "EF_DG15";
            case LDSFile.EF_DG16_TAG:
                return "EF_DG16";
            case LDSFile.EF_DG2_TAG:
                return "EF_DG2";
            case LDSFile.EF_DG4_TAG:
                return "EF_DG4";
            case LDSFile.EF_SOD_TAG:
                return "EF_SOD";
            default:
                return "File with tag 0x" + Integer.toHexString(i);
        }
    }

    public static int lookupSFIByFID(short s) {
        Byte b = FID_TO_SFI.get(Short.valueOf(s));
        if (b != null) {
            return b.byteValue() & 255;
        }
        throw new NumberFormatException("Unknown FID " + Integer.toHexString(s));
    }

    public static int lookupTagByDataGroupNumber(int i) {
        switch (i) {
            case 1:
                return 97;
            case 2:
                return LDSFile.EF_DG2_TAG;
            case 3:
                return 99;
            case 4:
                return LDSFile.EF_DG4_TAG;
            case 5:
                return LDSFile.EF_DG5_TAG;
            case 6:
                return LDSFile.EF_DG6_TAG;
            case 7:
                return LDSFile.EF_DG7_TAG;
            case 8:
                return LDSFile.EF_DG8_TAG;
            case 9:
                return LDSFile.EF_DG9_TAG;
            case 10:
                return LDSFile.EF_DG10_TAG;
            case 11:
                return LDSFile.EF_DG11_TAG;
            case 12:
                return LDSFile.EF_DG12_TAG;
            case 13:
                return LDSFile.EF_DG13_TAG;
            case 14:
                return LDSFile.EF_DG14_TAG;
            case 15:
                return LDSFile.EF_DG15_TAG;
            case 16:
                return LDSFile.EF_DG16_TAG;
            default:
                throw new NumberFormatException("Unknown number " + i);
        }
    }

    public static short lookupTagByFID(short s) {
        if (s == 285) {
            return 119;
        }
        if (s == 286) {
            return 96;
        }
        switch (s) {
            case 257:
                return 97;
            case 258:
                return 117;
            case 259:
                return 99;
            case 260:
                return 118;
            case 261:
                return 101;
            case 262:
                return 102;
            case 263:
                return 103;
            case 264:
                return 104;
            case 265:
                return 105;
            case 266:
                return 106;
            case 267:
                return 107;
            case 268:
                return 108;
            case 269:
                return 109;
            case 270:
                return 110;
            case 271:
                return 111;
            case 272:
                return 112;
            default:
                throw new NumberFormatException("Unknown fid " + Integer.toHexString(s));
        }
    }

    private static List<Integer> toDataGroupList(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            try {
                arrayList.add(Integer.valueOf(lookupDataGroupNumberByTag(i)));
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Could not find DG number for tag: " + Integer.toHexString(i), e);
            }
        }
        return arrayList;
    }

    public static List<Integer> getDataGroupNumbers(COMFile cOMFile) {
        ArrayList arrayList = new ArrayList();
        if (cOMFile == null) {
            return arrayList;
        }
        arrayList.addAll(toDataGroupList(cOMFile.getTagList()));
        Collections.sort(arrayList);
        return arrayList;
    }
}
