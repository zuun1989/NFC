package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.math.BigInteger;

public class ISOFileInfo extends FileInfo {
    public static final byte A0 = -96;
    public static final byte A1 = -95;
    public static final byte A2 = -94;
    public static final byte A5 = -91;
    public static final byte AB = -85;
    public static final byte AC = -84;
    public static final byte CHANNEL_SECURITY = -114;
    public static final byte DATA_BYTES1 = Byte.MIN_VALUE;
    public static final byte DATA_BYTES2 = -127;
    public static final byte DF_NAME = -124;
    public static final byte ENV_TEMP_EF = -115;
    public static final byte FCI_BYTE = 111;
    public static final byte FCI_EXT = -121;
    public static final byte FCP_BYTE = 98;
    public static final byte FILE_DESCRIPTOR = -126;
    public static final byte FILE_IDENTIFIER = -125;
    public static final byte FMD_BYTE = 100;
    public static final byte LCS_BYTE = -118;
    public static final byte PROP_INFO = -123;
    public static final byte SECURITY_ATTR_COMPACT = -116;
    public static final byte SECURITY_ATTR_EXP = -117;
    public static final byte SECURITY_ATTR_PROP = -122;
    public static final byte SHORT_EF = -120;
    byte[] a0 = null;
    byte[] a1 = null;
    byte[] a2 = null;

    /* renamed from: a5  reason: collision with root package name */
    byte[] f18a5 = null;
    byte[] ab = null;
    byte[] ac = null;
    byte channelSecurity = -1;
    byte dataCodingByte = -1;
    byte descriptorByte = -1;
    byte[] dfName = null;
    short envTempEF = -1;
    short fciExt = -1;
    short fid = -1;
    int fileLength = -1;
    int fileLengthFCI = -1;
    byte lcsByte = -1;
    byte mainTag = -1;
    short maxRecordSize = -1;
    short maxRecordsCount = -1;
    byte[] propInfo = null;
    byte[] secAttrCompact = null;
    byte[] secAttrExp = null;
    byte[] secAttrProp = null;
    byte shortEF = -1;

    public ISOFileInfo(byte[] bArr) throws CardServiceException {
        if (bArr.length != 0) {
            byte b = bArr[0];
            if (b == 111 || b == 98 || b == 100) {
                this.mainTag = b;
                byte b2 = bArr[1];
                byte[] bArr2 = new byte[b2];
                System.arraycopy(bArr, 2, bArr2, 0, b2);
                int i = 0;
                while (i < b2) {
                    int i2 = i + 1;
                    try {
                        byte b3 = bArr2[i];
                        int i3 = i + 2;
                        byte b4 = bArr2[i2];
                        byte[] bArr3 = new byte[b4];
                        System.arraycopy(bArr2, i3, bArr3, 0, b4);
                        i = i3 + b4;
                        if (b3 == -91) {
                            byte[] bArr4 = new byte[b4];
                            this.f18a5 = bArr4;
                            System.arraycopy(bArr3, 0, bArr4, 0, b4);
                        } else if (b3 == -85) {
                            byte[] bArr5 = new byte[b4];
                            this.ab = bArr5;
                            System.arraycopy(bArr3, 0, bArr5, 0, b4);
                        } else if (b3 != -84) {
                            switch (b3) {
                                case Byte.MIN_VALUE:
                                    this.fileLength = new BigInteger(bArr3).abs().intValue();
                                    break;
                                case -127:
                                    checkLen(b4, 2);
                                    this.fileLengthFCI = new BigInteger(bArr3).intValue();
                                    break;
                                case -126:
                                    checkLen(b4, 1, 6);
                                    this.descriptorByte = bArr3[0];
                                    if (1 != b4) {
                                        this.dataCodingByte = bArr3[1];
                                        if (2 != b4) {
                                            byte b5 = 3;
                                            if (b4 == 3) {
                                                this.maxRecordSize = (short) bArr3[2];
                                            } else {
                                                this.maxRecordSize = new BigInteger(new byte[]{bArr3[2], bArr3[3]}).shortValue();
                                                b5 = 4;
                                            }
                                            if (b5 != b4) {
                                                if (b4 != 5) {
                                                    this.maxRecordsCount = new BigInteger(new byte[]{bArr3[b5], bArr3[b5 + 1]}).shortValue();
                                                    break;
                                                } else {
                                                    this.maxRecordsCount = (short) bArr3[b5];
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                case -125:
                                    checkLen(b4, 2);
                                    this.fid = new BigInteger(bArr3).shortValue();
                                    break;
                                case -124:
                                    checkLen(b4, 0, 16);
                                    byte[] bArr6 = new byte[b4];
                                    this.dfName = bArr6;
                                    System.arraycopy(bArr3, 0, bArr6, 0, b4);
                                    break;
                                case -123:
                                    byte[] bArr7 = new byte[b4];
                                    this.propInfo = bArr7;
                                    System.arraycopy(bArr3, 0, bArr7, 0, b4);
                                    break;
                                case -122:
                                    byte[] bArr8 = new byte[b4];
                                    this.secAttrProp = bArr8;
                                    System.arraycopy(bArr3, 0, bArr8, 0, b4);
                                    break;
                                case -121:
                                    checkLen(b4, 2);
                                    this.fciExt = new BigInteger(bArr3).shortValue();
                                    break;
                                case -120:
                                    checkLen(b4, 0, 1);
                                    if (b4 != 0) {
                                        this.shortEF = bArr3[0];
                                        break;
                                    } else {
                                        this.shortEF = 0;
                                        break;
                                    }
                                default:
                                    switch (b3) {
                                        case -118:
                                            checkLen(b4, 1);
                                            this.lcsByte = bArr3[0];
                                            break;
                                        case -117:
                                            byte[] bArr9 = new byte[b4];
                                            this.secAttrExp = bArr9;
                                            System.arraycopy(bArr3, 0, bArr9, 0, b4);
                                            break;
                                        case -116:
                                            byte[] bArr10 = new byte[b4];
                                            this.secAttrCompact = bArr10;
                                            System.arraycopy(bArr3, 0, bArr10, 0, b4);
                                            break;
                                        case -115:
                                            checkLen(b4, 2);
                                            this.envTempEF = new BigInteger(bArr3).shortValue();
                                            break;
                                        case -114:
                                            checkLen(b4, 1);
                                            this.channelSecurity = bArr3[0];
                                            break;
                                        default:
                                            switch (b3) {
                                                case -96:
                                                    byte[] bArr11 = new byte[b4];
                                                    this.a0 = bArr11;
                                                    System.arraycopy(bArr3, 0, bArr11, 0, b4);
                                                    break;
                                                case ISO781611.BIOMETRIC_HEADER_TEMPLATE_BASE_TAG:
                                                    byte[] bArr12 = new byte[b4];
                                                    this.a1 = bArr12;
                                                    System.arraycopy(bArr3, 0, bArr12, 0, b4);
                                                    break;
                                                case -94:
                                                    byte[] bArr13 = new byte[b4];
                                                    this.a2 = bArr13;
                                                    System.arraycopy(bArr3, 0, bArr13, 0, b4);
                                                    break;
                                                default:
                                                    throw new CardServiceException("Malformed FCI: unrecognized tag.");
                                            }
                                    }
                            }
                        } else {
                            byte[] bArr14 = new byte[b4];
                            this.ac = bArr14;
                            System.arraycopy(bArr3, 0, bArr14, 0, b4);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new CardServiceException("Malformed FCI.");
                    }
                }
                return;
            }
            throw new CardServiceException("Malformed FCI data");
        }
    }

    private static byte[] catArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static void checkLen(int i, int i2) throws CardServiceException {
        if (i != i2) {
            throw new CardServiceException("Malformed FCI.");
        }
    }

    private static byte[] getArray(byte b, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 2)];
        bArr2[0] = b;
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public short getFID() {
        return this.fid;
    }

    public int getFileLength() {
        return this.fileLength;
    }

    public byte[] getFormatted() {
        byte[] bArr;
        String str;
        String str2;
        byte[] bArr2 = new byte[0];
        if (this.mainTag == -1) {
            return bArr2;
        }
        int i = this.fileLength;
        if (i != -1) {
            bArr2 = catArray(bArr2, getArray(DATA_BYTES1, Hex.hexStringToBytes(Hex.shortToHexString((short) i))));
        }
        int i2 = this.fileLengthFCI;
        if (i2 != -1) {
            bArr2 = catArray(bArr2, getArray(DATA_BYTES2, Hex.hexStringToBytes(Hex.shortToHexString((short) i2))));
        }
        byte b = this.descriptorByte;
        if (b != -1) {
            byte[] bArr3 = {b};
            byte[] bArr4 = new byte[0];
            byte b2 = this.dataCodingByte;
            if (b2 != -1) {
                bArr4 = new byte[]{b2};
            }
            byte[] bArr5 = new byte[0];
            short s = this.maxRecordSize;
            if (s != -1) {
                if (s > 256) {
                    str2 = Hex.shortToHexString(s);
                } else if (this.maxRecordsCount == -1) {
                    str2 = Hex.byteToHexString((byte) s);
                } else {
                    str2 = Hex.shortToHexString(s);
                }
                bArr5 = Hex.hexStringToBytes(str2);
            }
            byte[] bArr6 = new byte[0];
            short s2 = this.maxRecordsCount;
            if (s2 != -1) {
                if (s2 <= 256) {
                    str = Hex.byteToHexString((byte) s2);
                } else {
                    str = Hex.shortToHexString(s2);
                }
                bArr6 = Hex.hexStringToBytes(str);
            }
            bArr2 = catArray(bArr2, getArray((byte) -126, catArray(catArray(catArray(bArr3, bArr4), bArr5), bArr6)));
        }
        short s3 = this.fid;
        if (s3 != -1) {
            bArr2 = catArray(bArr2, getArray(FILE_IDENTIFIER, Hex.hexStringToBytes(Hex.shortToHexString(s3))));
        }
        byte[] bArr7 = this.dfName;
        if (bArr7 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -124, bArr7));
        }
        byte[] bArr8 = this.propInfo;
        if (bArr8 != null) {
            bArr2 = catArray(bArr2, getArray(PROP_INFO, bArr8));
        }
        byte[] bArr9 = this.secAttrProp;
        if (bArr9 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -122, bArr9));
        }
        short s4 = this.fciExt;
        if (s4 != -1) {
            bArr2 = catArray(bArr2, getArray(FCI_EXT, Hex.hexStringToBytes(Hex.shortToHexString(s4))));
        }
        byte b3 = this.shortEF;
        if (b3 != -1) {
            if (b3 == 0) {
                bArr = new byte[0];
            } else {
                bArr = new byte[]{b3};
            }
            bArr2 = catArray(bArr2, getArray((byte) -120, bArr));
        }
        byte b4 = this.lcsByte;
        if (b4 != -1) {
            bArr2 = catArray(bArr2, getArray(LCS_BYTE, new byte[]{b4}));
        }
        byte[] bArr10 = this.secAttrExp;
        if (bArr10 != null) {
            bArr2 = catArray(bArr2, getArray(SECURITY_ATTR_EXP, bArr10));
        }
        byte[] bArr11 = this.secAttrCompact;
        if (bArr11 != null) {
            bArr2 = catArray(bArr2, getArray(SECURITY_ATTR_COMPACT, bArr11));
        }
        short s5 = this.envTempEF;
        if (s5 != -1) {
            bArr2 = catArray(bArr2, getArray(ENV_TEMP_EF, Hex.hexStringToBytes(Hex.shortToHexString(s5))));
        }
        byte b5 = this.channelSecurity;
        if (b5 != -1) {
            bArr2 = catArray(bArr2, getArray(CHANNEL_SECURITY, new byte[]{b5}));
        }
        byte[] bArr12 = this.a0;
        if (bArr12 != null) {
            bArr2 = catArray(bArr2, getArray(A0, bArr12));
        }
        byte[] bArr13 = this.a1;
        if (bArr13 != null) {
            bArr2 = catArray(bArr2, getArray(A1, bArr13));
        }
        byte[] bArr14 = this.a2;
        if (bArr14 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -94, bArr14));
        }
        byte[] bArr15 = this.f18a5;
        if (bArr15 != null) {
            bArr2 = catArray(bArr2, getArray(A5, bArr15));
        }
        byte[] bArr16 = this.ab;
        if (bArr16 != null) {
            bArr2 = catArray(bArr2, getArray(AB, bArr16));
        }
        byte[] bArr17 = this.ac;
        if (bArr17 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -84, bArr17));
        }
        return getArray(this.mainTag, bArr2);
    }

    public String toString() {
        return "Length: " + this.fileLength + "\nLength FCI: " + this.fileLengthFCI + "\nDesc byte: " + this.descriptorByte + "\nData byte: " + this.dataCodingByte + "\nRecord size: " + this.maxRecordSize + "\nRecord count: " + this.maxRecordsCount + "\nFID: " + Hex.shortToHexString(this.fid) + "\nDF name: " + Hex.bytesToHexString(this.dfName) + "\npropInfo: " + Hex.bytesToHexString(this.propInfo) + "\nsecAttrProp: " + Hex.bytesToHexString(this.secAttrProp) + "\nsecAttrExp: " + Hex.bytesToHexString(this.secAttrExp) + "\nsecAttrComp: " + Hex.bytesToHexString(this.secAttrCompact) + "\nFCI ext: " + Hex.shortToHexString(this.fciExt) + "\nEF env temp: " + Hex.shortToHexString(this.envTempEF) + "\nShort EF: " + Hex.byteToHexString(this.shortEF) + "\nLCS byte: " + Hex.byteToHexString(this.lcsByte) + "\nChannel sec: " + Hex.byteToHexString(this.channelSecurity) + "\na0: " + Hex.bytesToHexString(this.a0) + "\na1: " + Hex.bytesToHexString(this.a1) + "\na2: " + Hex.bytesToHexString(this.a2) + "\na5: " + Hex.bytesToHexString(this.f18a5) + "\nab: " + Hex.bytesToHexString(this.ab) + "\nac: " + Hex.bytesToHexString(this.ac) + "\n";
    }

    private static void checkLen(int i, int i2, int i3) throws CardServiceException {
        if (i < i2 || i > i3) {
            throw new CardServiceException("Malformed FCI.");
        }
    }
}
