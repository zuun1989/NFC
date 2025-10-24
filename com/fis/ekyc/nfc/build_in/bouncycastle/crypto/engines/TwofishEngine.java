package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.eidparser.lds.CVCAFile;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;

public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, ISO7816.INS_READ_RECORD2, -24, 4, -3, -93, 118, -102, -110, ISOFileInfo.DATA_BYTES1, 120, ISO7816.INS_DELETE_FILE, -35, -47, 56, IdCardService.SFI_DG13, -58, 53, -104, 24, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, ISO7816.INS_WRITE_BINARY, ISOFileInfo.SECURITY_ATTR_EXP, ISO7816.INS_DECREASE, -124, 84, -33, 35, 25, 91, 61, 89, -13, -82, -94, -126, 99, 1, ISOFileInfo.FILE_IDENTIFIER, 46, -39, 81, -101, 124, -90, -21, ISOFileInfo.A5, -66, 22, IdCardService.SFI_DG12, -29, 97, ISO7816.INS_GET_RESPONSE, ISOFileInfo.SECURITY_ATTR_COMPACT, 58, -11, 115, ISO7816.INS_UNBLOCK_CHV, 37, IdCardService.SFI_DG11, -69, 78, -119, 107, 83, 106, ISO7816.INS_READ_BINARY_STAMPED, -15, -31, -26, -67, 69, ISO7816.INS_APPEND_RECORD, -12, ISO7816.INS_READ_RECORD_STAMPED, 102, -52, -107, 3, 86, -44, 28, IdCardService.SFI_COM, -41, -5, -61, ISOFileInfo.CHANNEL_SECURITY, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, ISOFileInfo.FCP_BYTE, 113, ISOFileInfo.DATA_BYTES2, 121, 9, -83, ISO7816.INS_CHANGE_CHV, -51, -7, ISO7816.INS_LOAD_KEY_FILE, -27, -59, -71, 77, ISO7816.INS_REHABILITATE_CHV, 8, -122, -25, ISOFileInfo.A1, 29, -86, -19, 6, ISO7816.INS_MANAGE_CHANNEL, -78, ISO7816.INS_WRITE_RECORD, 65, 123, ISOFileInfo.A0, 17, 49, ISO7816.INS_ENVELOPE, 39, -112, ISO7816.INS_VERIFY, -10, 96, -1, -106, 92, ISO7816.INS_READ_BINARY2, ISOFileInfo.AB, -98, -100, 82, 27, 95, -109, 10, -17, -111, ISOFileInfo.PROP_INFO, 73, -18, 45, 79, -113, 59, 71, ISOFileInfo.FCI_EXT, 109, 70, ISO7816.INS_UPDATE_BINARY, 62, 105, ISOFileInfo.FMD_BYTE, ISO7816.INS_PSO, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, 26, 75, 14, -89, 90, 40, 20, 63, 41, -120, 60, 76, 2, -72, ISO7816.INS_PUT_DATA, ISO7816.INS_READ_BINARY, 23, 85, 31, ISOFileInfo.LCS_BYTE, 125, 87, -57, ISOFileInfo.ENV_TEMP_EF, 116, -73, -60, -97, 114, 126, 21, ISO7816.INS_MSE, 18, 88, 7, -103, ISO7816.INS_DECREASE_STAMPED, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, ISO7816.INS_UPDATE_RECORD, -2, ISO7816.INS_INCREASE, -92, ISO7816.INS_GET_DATA, 16, 33, -16, -45, 93, IdCardService.SFI_DG15, 0, ISOFileInfo.FCI_BYTE, -99, 54, CVCAFile.CAR_TAG, 74, 94, -63, ISO7816.INS_CREATE_FILE}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_INCREASE, ISO7816.INS_LOAD_KEY_FILE, -3, 55, 113, -15, -31, ISO7816.INS_DECREASE, IdCardService.SFI_DG15, -8, 27, ISOFileInfo.FCI_EXT, -6, 6, 63, 94, -70, -82, 91, ISOFileInfo.LCS_BYTE, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, ISO7816.INS_READ_BINARY2, 14, ISOFileInfo.DATA_BYTES1, 93, ISO7816.INS_WRITE_RECORD, -43, ISOFileInfo.A0, -124, 7, 20, -75, -112, ISO7816.INS_UNBLOCK_CHV, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, ISO7816.INS_READ_BINARY, -67, 90, -4, 96, ISOFileInfo.FCP_BYTE, -106, 108, CVCAFile.CAR_TAG, -9, 16, 124, 40, 39, ISOFileInfo.SECURITY_ATTR_COMPACT, 19, -107, -100, -57, ISO7816.INS_CHANGE_CHV, 70, 59, ISO7816.INS_MANAGE_CHANNEL, ISO7816.INS_GET_DATA, -29, ISOFileInfo.PROP_INFO, -53, 17, ISO7816.INS_WRITE_BINARY, -109, -72, -90, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_VERIFY, -1, -97, 119, -61, -52, 3, ISOFileInfo.FCI_BYTE, 8, -65, 64, -25, 43, ISO7816.INS_APPEND_RECORD, 121, IdCardService.SFI_DG12, -86, -126, 65, 58, -22, -71, ISO7816.INS_DELETE_FILE, -102, -92, -105, 126, ISO7816.INS_PUT_DATA, 122, 23, 102, -108, ISOFileInfo.A1, 29, 61, -16, -34, ISO7816.INS_READ_RECORD2, IdCardService.SFI_DG11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, ISO7816.INS_PSO, 73, ISOFileInfo.DATA_BYTES2, -120, -18, 33, -60, 26, -21, -39, -59, 57, -103, -51, -83, 49, ISOFileInfo.SECURITY_ATTR_EXP, 1, 24, 35, -35, 31, 78, 45, -7, 72, 79, -14, 101, ISOFileInfo.CHANNEL_SECURITY, 120, 92, 88, 25, ISOFileInfo.ENV_TEMP_EF, -27, -104, 87, 103, Byte.MAX_VALUE, 5, ISOFileInfo.FMD_BYTE, -81, 99, ISO7816.INS_READ_RECORD_STAMPED, -2, -11, -73, 60, ISOFileInfo.A5, -50, -23, 104, ISO7816.INS_REHABILITATE_CHV, ISO7816.INS_CREATE_FILE, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, ISO7816.INS_DECREASE_STAMPED, 53, 106, -49, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, -55, ISO7816.INS_GET_RESPONSE, -101, -119, -44, -19, ISOFileInfo.AB, 18, -94, IdCardService.SFI_DG13, 82, -69, 2, 47, -87, -41, 97, IdCardService.SFI_COM, ISO7816.INS_READ_BINARY_STAMPED, 80, 4, -10, ISO7816.INS_ENVELOPE, 22, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        for (int i = 0; i < 256; i++) {
            byte[][] bArr = P;
            int i2 = bArr[0][i] & 255;
            int i3 = bArr[1][i] & 255;
            int[] iArr = {i2, i3};
            int[] iArr2 = {Mx_X(i2) & 255, Mx_X(i3) & 255};
            int[] iArr3 = {Mx_Y(i2) & 255, Mx_Y(i3) & 255};
            int[] iArr4 = this.gMDS0;
            int i4 = iArr[1] | (iArr2[1] << 8);
            int i5 = iArr3[1];
            iArr4[i] = i4 | (i5 << 16) | (i5 << 24);
            int[] iArr5 = this.gMDS1;
            int i6 = iArr3[0];
            iArr5[i] = i6 | (i6 << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            int[] iArr6 = this.gMDS2;
            int i7 = iArr2[1];
            int i8 = iArr3[1];
            iArr6[i] = (iArr[1] << 16) | i7 | (i8 << 8) | (i8 << 24);
            int[] iArr7 = this.gMDS3;
            int i9 = iArr2[0];
            iArr7[i] = (iArr3[0] << 16) | (iArr[0] << 8) | i9 | (i9 << 24);
        }
    }

    private void Bits32ToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    private int BytesTo32Bits(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private int F32(int i, int[] iArr) {
        int i2;
        int i3;
        int b0 = b0(i);
        int b1 = b1(i);
        int b2 = b2(i);
        int b3 = b3(i);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = this.k64Cnt & 3;
        if (i8 == 0) {
            byte[][] bArr = P;
            b0 = (bArr[1][b0] & 255) ^ b0(i7);
            b1 = (bArr[0][b1] & 255) ^ b1(i7);
            b2 = (bArr[0][b2] & 255) ^ b2(i7);
            b3 = (bArr[1][b3] & 255) ^ b3(i7);
            byte[][] bArr2 = P;
            b0 = (bArr2[1][b0] & 255) ^ b0(i6);
            b1 = (bArr2[1][b1] & 255) ^ b1(i6);
            b2 = (bArr2[0][b2] & 255) ^ b2(i6);
            b3 = (bArr2[0][b3] & 255) ^ b3(i6);
            int[] iArr2 = this.gMDS0;
            byte[][] bArr3 = P;
            byte[] bArr4 = bArr3[0];
            i2 = (iArr2[(bArr4[(bArr4[b0] & 255) ^ b0(i5)] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr3[0][(bArr3[1][b1] & 255) ^ b1(i5)] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr3[1][(bArr3[0][b2] & 255) ^ b2(i5)] & 255) ^ b2(i4)];
            int[] iArr3 = this.gMDS3;
            byte[] bArr5 = bArr3[1];
            i3 = iArr3[(bArr5[(bArr5[b3] & 255) ^ b3(i5)] & 255) ^ b3(i4)];
        } else if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
                byte[][] bArr22 = P;
                b0 = (bArr22[1][b0] & 255) ^ b0(i6);
                b1 = (bArr22[1][b1] & 255) ^ b1(i6);
                b2 = (bArr22[0][b2] & 255) ^ b2(i6);
                b3 = (bArr22[0][b3] & 255) ^ b3(i6);
            }
            int[] iArr22 = this.gMDS0;
            byte[][] bArr32 = P;
            byte[] bArr42 = bArr32[0];
            i2 = (iArr22[(bArr42[(bArr42[b0] & 255) ^ b0(i5)] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr32[0][(bArr32[1][b1] & 255) ^ b1(i5)] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr32[1][(bArr32[0][b2] & 255) ^ b2(i5)] & 255) ^ b2(i4)];
            int[] iArr32 = this.gMDS3;
            byte[] bArr52 = bArr32[1];
            i3 = iArr32[(bArr52[(bArr52[b3] & 255) ^ b3(i5)] & 255) ^ b3(i4)];
        } else {
            int[] iArr4 = this.gMDS0;
            byte[][] bArr6 = P;
            i2 = (iArr4[(bArr6[0][b0] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr6[0][b1] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr6[1][b2] & 255) ^ b2(i4)];
            i3 = this.gMDS3[(bArr6[1][b3] & 255) ^ b3(i4)];
        }
        return i2 ^ i3;
    }

    private int Fe32_0(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 24) & 255) * 2) + 513] ^ ((iArr[(i & 255) * 2] ^ iArr[(((i >>> 8) & 255) * 2) + 1]) ^ iArr[(((i >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 16) & 255) * 2) + 513] ^ ((iArr[((i >>> 24) & 255) * 2] ^ iArr[((i & 255) * 2) + 1]) ^ iArr[(((i >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i) {
        return ((i & 1) != 0 ? GF256_FDBK_2 : 0) ^ (i >> 1);
    }

    private int LFSR2(int i) {
        int i2 = 0;
        int i3 = (i >> 2) ^ ((i & 2) != 0 ? GF256_FDBK_2 : 0);
        if ((i & 1) != 0) {
            i2 = GF256_FDBK_4;
        }
        return i3 ^ i2;
    }

    private int Mx_X(int i) {
        return i ^ LFSR2(i);
    }

    private int Mx_Y(int i) {
        return LFSR2(i) ^ (LFSR1(i) ^ i);
    }

    private int RS_MDS_Encode(int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = RS_rem(i2);
        }
        int i4 = i ^ i2;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 = RS_rem(i4);
        }
        return i4;
    }

    private int RS_rem(int i) {
        int i2 = i >>> 24;
        int i3 = i2 & 255;
        int i4 = 0;
        int i5 = ((i3 << 1) ^ ((i2 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i6 = i3 >>> 1;
        if ((i2 & 1) != 0) {
            i4 = 166;
        }
        int i7 = (i6 ^ i4) ^ i5;
        return ((((i << 8) ^ (i7 << 24)) ^ (i5 << 16)) ^ (i7 << 8)) ^ i3;
    }

    private int b0(int i) {
        return i & 255;
    }

    private int b1(int i) {
        return (i >>> 8) & 255;
    }

    private int b2(int i) {
        return (i >>> 16) & 255;
    }

    private int b3(int i) {
        return (i >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[4];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[5];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[6];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[7];
        int i3 = 39;
        for (int i4 = 0; i4 < 16; i4 += 2) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = BytesTo32Bits4 ^ (((Fe32_3 * 2) + Fe32_0) + iArr[i3]);
            BytesTo32Bits3 = ((BytesTo32Bits3 >>> 31) | (BytesTo32Bits3 << 1)) ^ ((Fe32_0 + Fe32_3) + iArr[i3 - 1]);
            BytesTo32Bits4 = (i5 << 31) | (i5 >>> 1);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i6 = i3 - 3;
            int i7 = BytesTo32Bits2 ^ (((Fe32_32 * 2) + Fe32_02) + iArr2[i3 - 2]);
            i3 -= 4;
            BytesTo32Bits = ((BytesTo32Bits >>> 31) | (BytesTo32Bits << 1)) ^ ((Fe32_02 + Fe32_32) + iArr2[i6]);
            BytesTo32Bits2 = (i7 << 31) | (i7 >>> 1);
        }
        Bits32ToBytes(this.gSubKeys[0] ^ BytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[1], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ BytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ BytesTo32Bits2, bArr2, i2 + 12);
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i3 = i2;
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[0];
        int BytesTo32Bits2 = BytesTo32Bits(bArr3, i + 4) ^ this.gSubKeys[1];
        int BytesTo32Bits3 = BytesTo32Bits(bArr3, i + 8) ^ this.gSubKeys[2];
        int BytesTo32Bits4 = BytesTo32Bits(bArr3, i + 12) ^ this.gSubKeys[3];
        int i4 = 8;
        for (int i5 = 0; i5 < 16; i5 += 2) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i6 = BytesTo32Bits3 ^ ((Fe32_0 + Fe32_3) + iArr[i4]);
            BytesTo32Bits3 = (i6 << 31) | (i6 >>> 1);
            BytesTo32Bits4 = ((BytesTo32Bits4 >>> 31) | (BytesTo32Bits4 << 1)) ^ ((Fe32_0 + (Fe32_3 * 2)) + iArr[i4 + 1]);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i7 = i4 + 3;
            int i8 = BytesTo32Bits ^ ((Fe32_02 + Fe32_32) + iArr2[i4 + 2]);
            BytesTo32Bits = (i8 << 31) | (i8 >>> 1);
            i4 += 4;
            BytesTo32Bits2 = ((BytesTo32Bits2 >>> 31) | (BytesTo32Bits2 << 1)) ^ ((Fe32_02 + (Fe32_32 * 2)) + iArr2[i7]);
        }
        Bits32ToBytes(this.gSubKeys[4] ^ BytesTo32Bits3, bArr4, i3);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[5], bArr4, i3 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ BytesTo32Bits, bArr4, i3 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ BytesTo32Bits2, bArr4, i3 + 12);
    }

    private void setKey(byte[] bArr) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i = this.k64Cnt;
        if (i < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i <= 4) {
            for (int i2 = 0; i2 < this.k64Cnt; i2++) {
                int i3 = i2 * 8;
                iArr[i2] = BytesTo32Bits(bArr2, i3);
                int BytesTo32Bits = BytesTo32Bits(bArr2, i3 + 4);
                iArr2[i2] = BytesTo32Bits;
                iArr3[(this.k64Cnt - 1) - i2] = RS_MDS_Encode(iArr[i2], BytesTo32Bits);
            }
            for (int i4 = 0; i4 < 20; i4++) {
                int i5 = SK_STEP * i4;
                int F32 = F32(i5, iArr);
                int F322 = F32(i5 + SK_BUMP, iArr2);
                int i6 = (F322 >>> 24) | (F322 << 8);
                int i7 = F32 + i6;
                int[] iArr4 = this.gSubKeys;
                int i8 = i4 * 2;
                iArr4[i8] = i7;
                int i9 = i7 + i6;
                iArr4[i8 + 1] = (i9 << 9) | (i9 >>> 23);
            }
            int i10 = iArr3[0];
            int i11 = iArr3[1];
            int i12 = 2;
            int i13 = iArr3[2];
            int i14 = iArr3[3];
            this.gSBox = new int[1024];
            int i15 = 0;
            while (i15 < 256) {
                int i16 = this.k64Cnt & 3;
                if (i16 != 0) {
                    if (i16 == 1) {
                        int[] iArr5 = this.gSBox;
                        int i17 = i15 * 2;
                        int[] iArr6 = this.gMDS0;
                        byte[][] bArr3 = P;
                        iArr5[i17] = iArr6[(bArr3[0][i15] & 255) ^ b0(i10)];
                        this.gSBox[i17 + 1] = this.gMDS1[(bArr3[0][i15] & 255) ^ b1(i10)];
                        this.gSBox[i17 + 512] = this.gMDS2[(bArr3[1][i15] & 255) ^ b2(i10)];
                        this.gSBox[i17 + 513] = this.gMDS3[(bArr3[1][i15] & 255) ^ b3(i10)];
                    } else if (i16 == i12) {
                        b4 = i15;
                        b3 = b4;
                        b2 = b3;
                        b = b2;
                        int[] iArr7 = this.gSBox;
                        int i18 = i15 * 2;
                        int[] iArr8 = this.gMDS0;
                        byte[][] bArr4 = P;
                        byte[] bArr5 = bArr4[0];
                        iArr7[i18] = iArr8[(bArr5[(bArr5[b3] & 255) ^ b0(i11)] & 255) ^ b0(i10)];
                        this.gSBox[i18 + 1] = this.gMDS1[(bArr4[0][(bArr4[1][b2] & 255) ^ b1(i11)] & 255) ^ b1(i10)];
                        this.gSBox[i18 + 512] = this.gMDS2[(bArr4[1][(bArr4[0][b] & 255) ^ b2(i11)] & 255) ^ b2(i10)];
                        int[] iArr9 = this.gMDS3;
                        byte[] bArr6 = bArr4[1];
                        this.gSBox[i18 + 513] = iArr9[(bArr6[(bArr6[b4] & 255) ^ b3(i11)] & 255) ^ b3(i10)];
                    } else if (i16 == 3) {
                        b8 = i15;
                        b7 = b8;
                        b6 = b7;
                        b5 = b6;
                    }
                    i15++;
                    i12 = 2;
                } else {
                    byte[][] bArr7 = P;
                    b7 = (bArr7[1][i15] & 255) ^ b0(i14);
                    b6 = (bArr7[0][i15] & 255) ^ b1(i14);
                    b5 = (bArr7[0][i15] & 255) ^ b2(i14);
                    b8 = (bArr7[1][i15] & 255) ^ b3(i14);
                }
                byte[][] bArr8 = P;
                b3 = (bArr8[1][b7] & 255) ^ b0(i13);
                b2 = (bArr8[1][b6] & 255) ^ b1(i13);
                b = (bArr8[0][b5] & 255) ^ b2(i13);
                b4 = (bArr8[0][b8] & 255) ^ b3(i13);
                int[] iArr72 = this.gSBox;
                int i182 = i15 * 2;
                int[] iArr82 = this.gMDS0;
                byte[][] bArr42 = P;
                byte[] bArr52 = bArr42[0];
                iArr72[i182] = iArr82[(bArr52[(bArr52[b3] & 255) ^ b0(i11)] & 255) ^ b0(i10)];
                this.gSBox[i182 + 1] = this.gMDS1[(bArr42[0][(bArr42[1][b2] & 255) ^ b1(i11)] & 255) ^ b1(i10)];
                this.gSBox[i182 + 512] = this.gMDS2[(bArr42[1][(bArr42[0][b] & 255) ^ b2(i11)] & 255) ^ b2(i10)];
                int[] iArr92 = this.gMDS3;
                byte[] bArr62 = bArr42[1];
                this.gSBox[i182 + 513] = iArr92[(bArr62[(bArr62[b4] & 255) ^ b3(i11)] & 255) ^ b3(i10)];
                i15++;
                i12 = 2;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    public String getAlgorithmName() {
        return "Twofish";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            this.k64Cnt = key.length / 8;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        } else {
            decryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
    }

    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}
