package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.util.Enumeration;
import java.util.Hashtable;

public class GOST28147Engine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private static byte[] DSbox_A = {10, 4, 5, 6, 8, 1, 3, 7, IdCardService.SFI_DG13, IdCardService.SFI_DG12, 14, 0, 9, 2, IdCardService.SFI_DG11, IdCardService.SFI_DG15, 5, IdCardService.SFI_DG15, 4, 0, 2, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 9, 1, 7, 6, 3, IdCardService.SFI_DG12, 14, 10, 8, 7, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 14, 9, 4, 1, 0, 3, IdCardService.SFI_DG11, 5, 2, 6, 10, 8, IdCardService.SFI_DG13, 4, 10, 7, IdCardService.SFI_DG12, 0, IdCardService.SFI_DG15, 2, 8, 14, 1, 6, 5, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 9, 3, 7, 6, 4, IdCardService.SFI_DG11, 9, IdCardService.SFI_DG12, 2, 10, 1, 8, 0, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 3, 5, 7, 6, 2, 4, IdCardService.SFI_DG13, 9, IdCardService.SFI_DG15, 0, 10, 1, 5, IdCardService.SFI_DG11, 8, 14, IdCardService.SFI_DG12, 3, IdCardService.SFI_DG13, 14, 4, 1, 7, 0, 5, 10, 3, IdCardService.SFI_DG12, 8, IdCardService.SFI_DG15, 6, 2, 9, IdCardService.SFI_DG11, 1, 3, 10, 9, 5, IdCardService.SFI_DG11, 4, IdCardService.SFI_DG15, 8, 6, 7, 14, IdCardService.SFI_DG13, 0, 2, IdCardService.SFI_DG12};
    private static byte[] DSbox_Test = {4, 10, 9, 2, IdCardService.SFI_DG13, 8, 0, 14, 6, IdCardService.SFI_DG11, 1, IdCardService.SFI_DG12, 7, IdCardService.SFI_DG15, 5, 3, 14, IdCardService.SFI_DG11, 4, IdCardService.SFI_DG12, 6, IdCardService.SFI_DG13, IdCardService.SFI_DG15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, IdCardService.SFI_DG13, 10, 3, 4, 2, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 7, 6, 0, 9, IdCardService.SFI_DG11, 7, IdCardService.SFI_DG13, 10, 1, 0, 8, 9, IdCardService.SFI_DG15, 14, 4, 6, IdCardService.SFI_DG12, IdCardService.SFI_DG11, 2, 5, 3, 6, IdCardService.SFI_DG12, 7, 1, 5, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 8, 4, 10, 9, 14, 0, 3, IdCardService.SFI_DG11, 2, 4, IdCardService.SFI_DG11, 10, 0, 7, 2, 1, IdCardService.SFI_DG13, 3, 6, 8, 5, 9, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 14, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 4, 1, 3, IdCardService.SFI_DG15, 5, 9, 0, 10, 14, 7, 6, 8, 2, IdCardService.SFI_DG12, 1, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, IdCardService.SFI_DG11, 8, IdCardService.SFI_DG12};
    private static byte[] ESbox_A = {9, 6, 3, 2, 8, IdCardService.SFI_DG11, 1, 7, 10, 4, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 0, IdCardService.SFI_DG13, 5, 3, 7, 14, 9, 8, 10, IdCardService.SFI_DG15, 0, 5, 2, 6, IdCardService.SFI_DG12, IdCardService.SFI_DG11, 4, IdCardService.SFI_DG13, 1, 14, 4, 6, 2, IdCardService.SFI_DG11, 3, IdCardService.SFI_DG13, 8, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 5, 10, 0, 7, 1, 9, 14, 7, 10, IdCardService.SFI_DG12, IdCardService.SFI_DG13, 1, 3, 9, 0, 2, IdCardService.SFI_DG11, 4, IdCardService.SFI_DG15, 8, 5, 6, IdCardService.SFI_DG11, 5, 1, 9, 8, IdCardService.SFI_DG13, IdCardService.SFI_DG15, 0, 14, 4, 2, 3, IdCardService.SFI_DG12, 7, 10, 6, 3, 10, IdCardService.SFI_DG13, IdCardService.SFI_DG12, 1, 2, 0, IdCardService.SFI_DG11, 7, 5, 9, 4, 8, IdCardService.SFI_DG15, 14, 6, 1, IdCardService.SFI_DG13, 2, 9, 7, 10, 6, 0, 8, IdCardService.SFI_DG12, 4, 5, IdCardService.SFI_DG15, 3, IdCardService.SFI_DG11, 14, IdCardService.SFI_DG11, 10, IdCardService.SFI_DG15, 5, 0, IdCardService.SFI_DG12, 14, 8, 6, 2, 3, 9, 1, 7, IdCardService.SFI_DG13, 4};
    private static byte[] ESbox_B = {8, 4, IdCardService.SFI_DG11, 1, 3, 5, 0, 9, 2, 14, 10, IdCardService.SFI_DG12, IdCardService.SFI_DG13, 6, 7, IdCardService.SFI_DG15, 0, 1, 2, 10, 4, IdCardService.SFI_DG13, 5, IdCardService.SFI_DG12, 9, 7, 3, IdCardService.SFI_DG15, IdCardService.SFI_DG11, 8, 6, 14, 14, IdCardService.SFI_DG12, 0, 10, 9, 2, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 7, 5, 8, IdCardService.SFI_DG15, 3, 6, 1, 4, 7, 5, 0, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 6, 1, 2, 3, 10, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 4, 14, 9, 8, 2, 7, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 9, 5, 10, IdCardService.SFI_DG11, 1, 4, 0, IdCardService.SFI_DG13, 6, 8, 14, 3, 8, 3, 2, 6, 4, IdCardService.SFI_DG13, 14, IdCardService.SFI_DG11, IdCardService.SFI_DG12, 1, 7, IdCardService.SFI_DG15, 10, 0, 9, 5, 5, 2, 10, IdCardService.SFI_DG11, 9, 1, IdCardService.SFI_DG12, 3, 7, 4, IdCardService.SFI_DG13, 0, 6, IdCardService.SFI_DG15, 8, 14, 0, 4, IdCardService.SFI_DG11, 14, 8, 3, 7, 1, 10, 2, 9, 6, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 5, IdCardService.SFI_DG12};
    private static byte[] ESbox_C = {1, IdCardService.SFI_DG11, IdCardService.SFI_DG12, 2, 9, IdCardService.SFI_DG13, 0, IdCardService.SFI_DG15, 4, 5, 8, 14, 10, 7, 6, 3, 0, 1, 7, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 4, 5, 2, 8, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, IdCardService.SFI_DG15, 10, 3, 7, IdCardService.SFI_DG12, IdCardService.SFI_DG13, 6, 14, 1, IdCardService.SFI_DG11, 3, 6, 0, 1, 5, IdCardService.SFI_DG13, 10, 8, IdCardService.SFI_DG11, 2, 9, 7, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 4, 8, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 0, 4, 5, 1, 2, 9, 3, IdCardService.SFI_DG12, 14, 6, IdCardService.SFI_DG15, 10, 7, IdCardService.SFI_DG12, 9, IdCardService.SFI_DG11, 1, 8, 14, 2, 4, 7, 3, 6, 5, 10, 0, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 10, 9, 6, 8, IdCardService.SFI_DG13, 14, 2, 0, IdCardService.SFI_DG15, 3, 5, IdCardService.SFI_DG11, 4, 1, IdCardService.SFI_DG12, 7, 7, 4, 0, 5, 10, 2, IdCardService.SFI_DG15, 14, IdCardService.SFI_DG12, 6, 1, IdCardService.SFI_DG11, IdCardService.SFI_DG13, 9, 3, 8};
    private static byte[] ESbox_D = {IdCardService.SFI_DG15, IdCardService.SFI_DG12, 2, 10, 6, 4, 5, 0, 7, 9, 14, IdCardService.SFI_DG13, 1, IdCardService.SFI_DG11, 8, 3, IdCardService.SFI_DG11, 6, 3, 4, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 14, 2, 7, IdCardService.SFI_DG13, 8, 0, 5, 10, 9, 1, 1, IdCardService.SFI_DG12, IdCardService.SFI_DG11, 0, IdCardService.SFI_DG15, 14, 6, 5, 10, IdCardService.SFI_DG13, 4, 8, 9, 3, 7, 2, 1, 5, 14, IdCardService.SFI_DG12, 10, 7, 0, IdCardService.SFI_DG13, 6, 2, IdCardService.SFI_DG11, 4, 9, 3, IdCardService.SFI_DG15, 8, 0, IdCardService.SFI_DG12, 8, 9, IdCardService.SFI_DG13, 2, 10, IdCardService.SFI_DG11, 7, 3, 6, 5, 4, 14, IdCardService.SFI_DG15, 1, 8, 0, IdCardService.SFI_DG15, 3, 2, 5, 14, IdCardService.SFI_DG11, 1, 10, 4, 7, IdCardService.SFI_DG12, 9, IdCardService.SFI_DG13, 6, 3, 0, 6, IdCardService.SFI_DG15, 1, 14, 9, 2, IdCardService.SFI_DG13, 8, IdCardService.SFI_DG12, 4, IdCardService.SFI_DG11, 10, 5, 7, 1, 10, 6, 8, IdCardService.SFI_DG15, IdCardService.SFI_DG11, 0, 4, IdCardService.SFI_DG12, 3, 5, 9, 7, IdCardService.SFI_DG13, 2, 14};
    private static byte[] ESbox_Test = {4, 2, IdCardService.SFI_DG15, 5, 9, 1, 0, 8, 14, 3, IdCardService.SFI_DG11, IdCardService.SFI_DG12, IdCardService.SFI_DG13, 7, 10, 6, IdCardService.SFI_DG12, 9, IdCardService.SFI_DG15, 14, 8, 1, 3, 10, 2, 7, 4, IdCardService.SFI_DG13, 6, 0, IdCardService.SFI_DG11, 5, IdCardService.SFI_DG13, 8, 14, IdCardService.SFI_DG12, 7, 3, 9, 10, 1, 5, 2, 4, 6, IdCardService.SFI_DG15, 0, IdCardService.SFI_DG11, 14, 9, IdCardService.SFI_DG11, 2, 5, IdCardService.SFI_DG15, 7, 1, 0, IdCardService.SFI_DG13, IdCardService.SFI_DG12, 6, 10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 0, IdCardService.SFI_DG13, 10, IdCardService.SFI_DG11, 7, IdCardService.SFI_DG12, 2, 1, IdCardService.SFI_DG15, 4, 8, IdCardService.SFI_DG15, 6, IdCardService.SFI_DG11, 1, 9, IdCardService.SFI_DG12, 5, IdCardService.SFI_DG13, 3, 7, 10, 0, 14, 2, 4, 9, IdCardService.SFI_DG11, IdCardService.SFI_DG12, 0, 3, 6, 7, 5, 4, 8, 14, IdCardService.SFI_DG15, 1, 10, 2, IdCardService.SFI_DG13, IdCardService.SFI_DG12, 6, 5, 2, IdCardService.SFI_DG11, 0, 9, IdCardService.SFI_DG13, 3, 14, 7, 10, IdCardService.SFI_DG15, 4, 1, 8};
    private static byte[] Param_Z = {IdCardService.SFI_DG12, 4, 6, 2, 10, 5, IdCardService.SFI_DG11, 9, 14, 8, IdCardService.SFI_DG13, 7, 0, 3, IdCardService.SFI_DG15, 1, 6, 8, 2, 3, 9, 10, 5, IdCardService.SFI_DG12, 1, 14, 4, 7, IdCardService.SFI_DG11, IdCardService.SFI_DG13, 0, IdCardService.SFI_DG15, IdCardService.SFI_DG11, 3, 5, 8, 2, IdCardService.SFI_DG15, 10, IdCardService.SFI_DG13, 14, 1, 7, 4, IdCardService.SFI_DG12, 9, 6, 0, IdCardService.SFI_DG12, 8, 2, 1, IdCardService.SFI_DG13, 4, IdCardService.SFI_DG15, 6, 7, 0, 10, 5, 3, 14, 9, IdCardService.SFI_DG11, 7, IdCardService.SFI_DG15, 5, 10, 8, 1, 6, IdCardService.SFI_DG13, 0, 9, 3, 14, IdCardService.SFI_DG11, 4, 2, IdCardService.SFI_DG12, 5, IdCardService.SFI_DG13, IdCardService.SFI_DG15, 6, 9, 2, IdCardService.SFI_DG12, 10, IdCardService.SFI_DG11, 7, 8, 1, 4, 3, 14, 0, 8, 14, 2, 5, 6, 9, 1, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 4, IdCardService.SFI_DG11, 0, IdCardService.SFI_DG13, 10, 3, 7, 1, 7, 14, IdCardService.SFI_DG13, 0, 5, 8, 3, 4, IdCardService.SFI_DG15, 10, 6, 9, IdCardService.SFI_DG12, IdCardService.SFI_DG11, 2};
    private static byte[] Sbox_Default = {4, 10, 9, 2, IdCardService.SFI_DG13, 8, 0, 14, 6, IdCardService.SFI_DG11, 1, IdCardService.SFI_DG12, 7, IdCardService.SFI_DG15, 5, 3, 14, IdCardService.SFI_DG11, 4, IdCardService.SFI_DG12, 6, IdCardService.SFI_DG13, IdCardService.SFI_DG15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, IdCardService.SFI_DG13, 10, 3, 4, 2, 14, IdCardService.SFI_DG15, IdCardService.SFI_DG12, 7, 6, 0, 9, IdCardService.SFI_DG11, 7, IdCardService.SFI_DG13, 10, 1, 0, 8, 9, IdCardService.SFI_DG15, 14, 4, 6, IdCardService.SFI_DG12, IdCardService.SFI_DG11, 2, 5, 3, 6, IdCardService.SFI_DG12, 7, 1, 5, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 8, 4, 10, 9, 14, 0, 3, IdCardService.SFI_DG11, 2, 4, IdCardService.SFI_DG11, 10, 0, 7, 2, 1, IdCardService.SFI_DG13, 3, 6, 8, 5, 9, IdCardService.SFI_DG12, IdCardService.SFI_DG15, 14, IdCardService.SFI_DG13, IdCardService.SFI_DG11, 4, 1, 3, IdCardService.SFI_DG15, 5, 9, 0, 10, 14, 7, 6, 8, 2, IdCardService.SFI_DG12, 1, IdCardService.SFI_DG15, IdCardService.SFI_DG13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, IdCardService.SFI_DG11, 8, IdCardService.SFI_DG12};
    private static Hashtable sBoxes = new Hashtable();
    private byte[] S = Sbox_Default;
    private boolean forEncryption;
    private int[] workingKey = null;

    static {
        addSBox("Default", Sbox_Default);
        addSBox("E-TEST", ESbox_Test);
        addSBox("E-A", ESbox_A);
        addSBox("E-B", ESbox_B);
        addSBox("E-C", ESbox_C);
        addSBox("E-D", ESbox_D);
        addSBox("Param-Z", Param_Z);
        addSBox("D-TEST", DSbox_Test);
        addSBox("D-A", DSbox_A);
    }

    private void GOST28147Func(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        int bytesToint = bytesToint(bArr, i);
        int bytesToint2 = bytesToint(bArr, i + 4);
        int i5 = 7;
        if (this.forEncryption) {
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = 0;
                while (i7 < 8) {
                    i7++;
                    int i8 = bytesToint;
                    bytesToint = bytesToint2 ^ GOST28147_mainStep(bytesToint, iArr[i7]);
                    bytesToint2 = i8;
                }
            }
            i3 = bytesToint2;
            i4 = bytesToint;
            while (i5 > 0) {
                i5--;
                int GOST28147_mainStep = i3 ^ GOST28147_mainStep(i4, iArr[i5]);
                i3 = i4;
                i4 = GOST28147_mainStep;
            }
        } else {
            int i9 = 0;
            while (i9 < 8) {
                i9++;
                int i10 = bytesToint;
                bytesToint = bytesToint2 ^ GOST28147_mainStep(bytesToint, iArr[i9]);
                bytesToint2 = i10;
            }
            i3 = bytesToint2;
            i4 = bytesToint;
            int i11 = 0;
            while (i11 < 3) {
                int i12 = 7;
                while (i12 >= 0 && (i11 != 2 || i12 != 0)) {
                    i12--;
                    int GOST28147_mainStep2 = i3 ^ GOST28147_mainStep(i4, iArr[i12]);
                    i3 = i4;
                    i4 = GOST28147_mainStep2;
                }
                i11++;
            }
        }
        intTobytes(i4, bArr2, i2);
        intTobytes(GOST28147_mainStep(i4, iArr[0]) ^ i3, bArr2, i2 + 4);
    }

    private int GOST28147_mainStep(int i, int i2) {
        int i3 = i2 + i;
        byte[] bArr = this.S;
        int i4 = bArr[i3 & 15] + (bArr[((i3 >> 4) & 15) + 16] << 4) + (bArr[((i3 >> 8) & 15) + 32] << 8) + (bArr[((i3 >> 12) & 15) + 48] << IdCardService.SFI_DG12) + (bArr[((i3 >> 16) & 15) + 64] << 16) + (bArr[((i3 >> 20) & 15) + 80] << 20) + (bArr[((i3 >> 24) & 15) + 96] << 24) + (bArr[((i3 >> 28) & 15) + LDSFile.EF_DG16_TAG] << 28);
        return (i4 << 11) | (i4 >>> 21);
    }

    private static void addSBox(String str, byte[] bArr) {
        sBoxes.put(Strings.toUpperCase(str), bArr);
    }

    private int bytesToint(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & -16777216) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }

    private int[] generateWorkingKey(boolean z, byte[] bArr) {
        this.forEncryption = z;
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = bytesToint(bArr, i * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public static byte[] getSBox(String str) {
        byte[] bArr = (byte[]) sBoxes.get(Strings.toUpperCase(str));
        if (bArr != null) {
            return Arrays.clone(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    public static String getSBoxName(byte[] bArr) {
        Enumeration keys = sBoxes.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (Arrays.areEqual((byte[]) sBoxes.get(str), bArr)) {
                return str;
            }
        }
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }

    private void intTobytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    public String getAlgorithmName() {
        return "GOST28147";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            byte[] sBox = parametersWithSBox.getSBox();
            if (sBox.length == Sbox_Default.length) {
                this.S = Arrays.clone(sBox);
                if (parametersWithSBox.getParameters() != null) {
                    this.workingKey = generateWorkingKey(z, ((KeyParameter) parametersWithSBox.getParameters()).getKey());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(z, ((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
        }
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            GOST28147Func(iArr, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
