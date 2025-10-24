package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.eidparser.lds.CVCAFile;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;

public abstract class HarakaBase implements Digest {
    protected static final int DIGEST_SIZE = 32;
    private static final byte[][] S = {new byte[]{99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118}, new byte[]{ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE}, new byte[]{-73, -3, -109, 38, 54, 63, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, 49, 21}, new byte[]{4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ISOFileInfo.DATA_BYTES1, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117}, new byte[]{9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, 26, 27, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124}, new byte[]{83, -47, 0, -19, ISO7816.INS_VERIFY, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49}, new byte[]{ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88}, new byte[]{81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, 33, 16, -1, -13, ISO7816.INS_WRITE_RECORD}, new byte[]{-51, IdCardService.SFI_DG12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, ISOFileInfo.FMD_BYTE, 93, 25, 115}, new byte[]{96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, IdCardService.SFI_DG11, -37}, new byte[]{ISO7816.INS_CREATE_FILE, ISO7816.INS_INCREASE, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121}, new byte[]{-25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8}, new byte[]{-70, 120, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, 31, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE}, new byte[]{ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98}, new byte[]{-31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, IdCardService.SFI_COM, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33}, new byte[]{ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, IdCardService.SFI_DG13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, 45, IdCardService.SFI_DG15, ISO7816.INS_READ_BINARY, 84, -69, 22}};

    public static byte[] aesEnc(byte[] bArr, byte[] bArr2) {
        byte[] mixColumns = mixColumns(shiftRows(subBytes(bArr)));
        xorReverse(mixColumns, bArr2);
        return mixColumns;
    }

    private static byte[] mixColumns(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 4;
            int i4 = i3 + 1;
            int i5 = i3 + 2;
            int i6 = i3 + 3;
            bArr2[i] = (byte) ((((xTime(bArr[i3]) ^ xTime(bArr[i4])) ^ bArr[i4]) ^ bArr[i5]) ^ bArr[i6]);
            bArr2[i + 1] = (byte) ((((bArr[i3] ^ xTime(bArr[i4])) ^ xTime(bArr[i5])) ^ bArr[i5]) ^ bArr[i6]);
            int i7 = i + 3;
            bArr2[i + 2] = (byte) ((((bArr[i3] ^ bArr[i4]) ^ xTime(bArr[i5])) ^ xTime(bArr[i6])) ^ bArr[i6]);
            i += 4;
            bArr2[i7] = (byte) ((((xTime(bArr[i3]) ^ bArr[i3]) ^ bArr[i4]) ^ bArr[i5]) ^ xTime(bArr[i6]));
        }
        return bArr2;
    }

    public static byte sBox(byte b) {
        return S[(b & 255) >>> 4][b & IdCardService.SFI_DG15];
    }

    public static byte[] shiftRows(byte[] bArr) {
        return new byte[]{bArr[0], bArr[5], bArr[10], bArr[15], bArr[4], bArr[9], bArr[14], bArr[3], bArr[8], bArr[13], bArr[2], bArr[7], bArr[12], bArr[1], bArr[6], bArr[11]};
    }

    public static byte[] subBytes(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        bArr2[0] = sBox(bArr[0]);
        bArr2[1] = sBox(bArr[1]);
        bArr2[2] = sBox(bArr[2]);
        bArr2[3] = sBox(bArr[3]);
        bArr2[4] = sBox(bArr[4]);
        bArr2[5] = sBox(bArr[5]);
        bArr2[6] = sBox(bArr[6]);
        bArr2[7] = sBox(bArr[7]);
        bArr2[8] = sBox(bArr[8]);
        bArr2[9] = sBox(bArr[9]);
        bArr2[10] = sBox(bArr[10]);
        bArr2[11] = sBox(bArr[11]);
        bArr2[12] = sBox(bArr[12]);
        bArr2[13] = sBox(bArr[13]);
        bArr2[14] = sBox(bArr[14]);
        bArr2[15] = sBox(bArr[15]);
        return bArr2;
    }

    public static byte xTime(byte b) {
        return (byte) (((b >>> 7) > 0 ? (b << 1) ^ 27 : b << 1) & 255);
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[16];
        int i2 = 0;
        while (i2 < 16) {
            bArr3[i2] = (byte) (bArr2[i] ^ bArr[i2]);
            i2++;
            i++;
        }
        return bArr3;
    }

    public static void xorReverse(byte[] bArr, byte[] bArr2) {
        bArr[0] = (byte) (bArr[0] ^ bArr2[15]);
        bArr[1] = (byte) (bArr[1] ^ bArr2[14]);
        bArr[2] = (byte) (bArr[2] ^ bArr2[13]);
        bArr[3] = (byte) (bArr[3] ^ bArr2[12]);
        bArr[4] = (byte) (bArr[4] ^ bArr2[11]);
        bArr[5] = (byte) (bArr[5] ^ bArr2[10]);
        bArr[6] = (byte) (bArr[6] ^ bArr2[9]);
        bArr[7] = (byte) (bArr[7] ^ bArr2[8]);
        bArr[8] = (byte) (bArr2[7] ^ bArr[8]);
        bArr[9] = (byte) (bArr2[6] ^ bArr[9]);
        bArr[10] = (byte) (bArr2[5] ^ bArr[10]);
        bArr[11] = (byte) (bArr2[4] ^ bArr[11]);
        bArr[12] = (byte) (bArr2[3] ^ bArr[12]);
        bArr[13] = (byte) (bArr2[2] ^ bArr[13]);
        bArr[14] = (byte) (bArr2[1] ^ bArr[14]);
        bArr[15] = (byte) (bArr2[0] ^ bArr[15]);
    }

    public int getDigestSize() {
        return 32;
    }
}
