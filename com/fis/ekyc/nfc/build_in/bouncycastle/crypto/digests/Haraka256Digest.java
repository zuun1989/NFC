package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.lang.reflect.Array;

public class Haraka256Digest extends HarakaBase {
    private static final byte[][] RC;
    private final byte[] buffer;
    private int off;

    static {
        byte[] bArr = new byte[16];
        byte[] bArr2 = bArr;
        // fill-array-data instruction
        bArr[0] = 6;
        bArr[1] = -124;
        bArr[2] = 112;
        bArr[3] = 76;
        bArr[4] = -26;
        bArr[5] = 32;
        bArr[6] = -64;
        bArr[7] = 10;
        bArr[8] = -78;
        bArr[9] = -59;
        bArr[10] = -2;
        bArr[11] = -16;
        bArr[12] = 117;
        bArr[13] = -127;
        bArr[14] = 123;
        bArr[15] = -99;
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = bArr3;
        // fill-array-data instruction
        bArr3[0] = -117;
        bArr3[1] = 102;
        bArr3[2] = -76;
        bArr3[3] = -31;
        bArr3[4] = -120;
        bArr3[5] = -13;
        bArr3[6] = -96;
        bArr3[7] = 107;
        bArr3[8] = 100;
        bArr3[9] = 15;
        bArr3[10] = 107;
        bArr3[11] = -92;
        bArr3[12] = 47;
        bArr3[13] = 8;
        bArr3[14] = -9;
        bArr3[15] = 23;
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = bArr5;
        // fill-array-data instruction
        bArr5[0] = 52;
        bArr5[1] = 2;
        bArr5[2] = -34;
        bArr5[3] = 45;
        bArr5[4] = 83;
        bArr5[5] = -14;
        bArr5[6] = -124;
        bArr5[7] = -104;
        bArr5[8] = -49;
        bArr5[9] = 2;
        bArr5[10] = -99;
        bArr5[11] = 96;
        bArr5[12] = -97;
        bArr5[13] = 2;
        bArr5[14] = -111;
        bArr5[15] = 20;
        byte[] bArr7 = new byte[16];
        byte[] bArr8 = bArr7;
        // fill-array-data instruction
        bArr7[0] = 14;
        bArr7[1] = -42;
        bArr7[2] = -22;
        bArr7[3] = -26;
        bArr7[4] = 46;
        bArr7[5] = 123;
        bArr7[6] = 79;
        bArr7[7] = 8;
        bArr7[8] = -69;
        bArr7[9] = -13;
        bArr7[10] = -68;
        bArr7[11] = -81;
        bArr7[12] = -3;
        bArr7[13] = 91;
        bArr7[14] = 79;
        bArr7[15] = 121;
        byte[] bArr9 = new byte[16];
        byte[] bArr10 = bArr9;
        // fill-array-data instruction
        bArr9[0] = -53;
        bArr9[1] = -49;
        bArr9[2] = -80;
        bArr9[3] = -53;
        bArr9[4] = 72;
        bArr9[5] = 114;
        bArr9[6] = 68;
        bArr9[7] = -117;
        bArr9[8] = 121;
        bArr9[9] = -18;
        bArr9[10] = -51;
        bArr9[11] = 28;
        bArr9[12] = -66;
        bArr9[13] = 57;
        bArr9[14] = 112;
        bArr9[15] = 68;
        byte[] bArr11 = new byte[16];
        byte[] bArr12 = bArr11;
        // fill-array-data instruction
        bArr11[0] = 126;
        bArr11[1] = -22;
        bArr11[2] = -51;
        bArr11[3] = -18;
        bArr11[4] = 110;
        bArr11[5] = -112;
        bArr11[6] = 50;
        bArr11[7] = -73;
        bArr11[8] = -115;
        bArr11[9] = 83;
        bArr11[10] = 53;
        bArr11[11] = -19;
        bArr11[12] = 43;
        bArr11[13] = -118;
        bArr11[14] = 5;
        bArr11[15] = 123;
        byte[] bArr13 = new byte[16];
        byte[] bArr14 = bArr13;
        // fill-array-data instruction
        bArr13[0] = 103;
        bArr13[1] = -62;
        bArr13[2] = -113;
        bArr13[3] = 67;
        bArr13[4] = 94;
        bArr13[5] = 46;
        bArr13[6] = 124;
        bArr13[7] = -48;
        bArr13[8] = -30;
        bArr13[9] = 65;
        bArr13[10] = 39;
        bArr13[11] = 97;
        bArr13[12] = -38;
        bArr13[13] = 79;
        bArr13[14] = -17;
        bArr13[15] = 27;
        byte[] bArr15 = new byte[16];
        byte[] bArr16 = bArr15;
        // fill-array-data instruction
        bArr15[0] = 41;
        bArr15[1] = 36;
        bArr15[2] = -39;
        bArr15[3] = -80;
        bArr15[4] = -81;
        bArr15[5] = -54;
        bArr15[6] = -52;
        bArr15[7] = 7;
        bArr15[8] = 103;
        bArr15[9] = 95;
        bArr15[10] = -3;
        bArr15[11] = -30;
        bArr15[12] = 31;
        bArr15[13] = -57;
        bArr15[14] = 11;
        bArr15[15] = 59;
        byte[] bArr17 = new byte[16];
        byte[] bArr18 = bArr17;
        // fill-array-data instruction
        bArr17[0] = -85;
        bArr17[1] = 77;
        bArr17[2] = 99;
        bArr17[3] = -15;
        bArr17[4] = -26;
        bArr17[5] = -122;
        bArr17[6] = 127;
        bArr17[7] = -23;
        bArr17[8] = -20;
        bArr17[9] = -37;
        bArr17[10] = -113;
        bArr17[11] = -54;
        bArr17[12] = -71;
        bArr17[13] = -44;
        bArr17[14] = 101;
        bArr17[15] = -18;
        byte[] bArr19 = new byte[16];
        byte[] bArr20 = bArr19;
        // fill-array-data instruction
        bArr19[0] = 28;
        bArr19[1] = 48;
        bArr19[2] = -65;
        bArr19[3] = -124;
        bArr19[4] = -44;
        bArr19[5] = -73;
        bArr19[6] = -51;
        bArr19[7] = 100;
        bArr19[8] = 91;
        bArr19[9] = 42;
        bArr19[10] = 64;
        bArr19[11] = 79;
        bArr19[12] = -83;
        bArr19[13] = 3;
        bArr19[14] = 126;
        bArr19[15] = 51;
        byte[] bArr21 = new byte[16];
        byte[] bArr22 = bArr21;
        // fill-array-data instruction
        bArr21[0] = -78;
        bArr21[1] = -52;
        bArr21[2] = 11;
        bArr21[3] = -71;
        bArr21[4] = -108;
        bArr21[5] = 23;
        bArr21[6] = 35;
        bArr21[7] = -65;
        bArr21[8] = 105;
        bArr21[9] = 2;
        bArr21[10] = -117;
        bArr21[11] = 46;
        bArr21[12] = -115;
        bArr21[13] = -10;
        bArr21[14] = -104;
        bArr21[15] = 0;
        byte[] bArr23 = new byte[16];
        byte[] bArr24 = bArr23;
        // fill-array-data instruction
        bArr23[0] = -6;
        bArr23[1] = 4;
        bArr23[2] = 120;
        bArr23[3] = -90;
        bArr23[4] = -34;
        bArr23[5] = 111;
        bArr23[6] = 85;
        bArr23[7] = 114;
        bArr23[8] = 74;
        bArr23[9] = -86;
        bArr23[10] = -98;
        bArr23[11] = -56;
        bArr23[12] = 92;
        bArr23[13] = -99;
        bArr23[14] = 45;
        bArr23[15] = -118;
        byte[] bArr25 = new byte[16];
        byte[] bArr26 = bArr25;
        // fill-array-data instruction
        bArr25[0] = -33;
        bArr25[1] = -76;
        bArr25[2] = -97;
        bArr25[3] = 43;
        bArr25[4] = 107;
        bArr25[5] = 119;
        bArr25[6] = 42;
        bArr25[7] = 18;
        bArr25[8] = 14;
        bArr25[9] = -6;
        bArr25[10] = 79;
        bArr25[11] = 46;
        bArr25[12] = 41;
        bArr25[13] = 18;
        bArr25[14] = -97;
        bArr25[15] = -44;
        byte[] bArr27 = new byte[16];
        byte[] bArr28 = bArr27;
        // fill-array-data instruction
        bArr27[0] = 30;
        bArr27[1] = -95;
        bArr27[2] = 3;
        bArr27[3] = 68;
        bArr27[4] = -12;
        bArr27[5] = 73;
        bArr27[6] = -94;
        bArr27[7] = 54;
        bArr27[8] = 50;
        bArr27[9] = -42;
        bArr27[10] = 17;
        bArr27[11] = -82;
        bArr27[12] = -69;
        bArr27[13] = 106;
        bArr27[14] = 18;
        bArr27[15] = -18;
        byte[] bArr29 = new byte[16];
        // fill-array-data instruction
        bArr29[0] = -81;
        bArr29[1] = 4;
        bArr29[2] = 73;
        bArr29[3] = -120;
        bArr29[4] = 75;
        bArr29[5] = 5;
        bArr29[6] = 0;
        bArr29[7] = -124;
        bArr29[8] = 95;
        bArr29[9] = -106;
        bArr29[10] = 0;
        bArr29[11] = -55;
        bArr29[12] = -100;
        bArr29[13] = -88;
        bArr29[14] = -20;
        bArr29[15] = -90;
        byte[] bArr30 = bArr2;
        byte[] bArr31 = new byte[16];
        byte[] bArr32 = bArr31;
        // fill-array-data instruction
        bArr31[0] = 33;
        bArr31[1] = 2;
        bArr31[2] = 94;
        bArr31[3] = -40;
        bArr31[4] = -99;
        bArr31[5] = 25;
        bArr31[6] = -100;
        bArr31[7] = 79;
        bArr31[8] = 120;
        bArr31[9] = -94;
        bArr31[10] = -57;
        bArr31[11] = -29;
        bArr31[12] = 39;
        bArr31[13] = -27;
        bArr31[14] = -109;
        bArr31[15] = -20;
        byte[] bArr33 = new byte[16];
        byte[] bArr34 = bArr33;
        // fill-array-data instruction
        bArr33[0] = -65;
        bArr33[1] = 58;
        bArr33[2] = -86;
        bArr33[3] = -8;
        bArr33[4] = -89;
        bArr33[5] = 89;
        bArr33[6] = -55;
        bArr33[7] = -73;
        bArr33[8] = -71;
        bArr33[9] = 40;
        bArr33[10] = 46;
        bArr33[11] = -51;
        bArr33[12] = -126;
        bArr33[13] = -44;
        bArr33[14] = 1;
        bArr33[15] = 115;
        byte[] bArr35 = new byte[16];
        byte[] bArr36 = bArr35;
        // fill-array-data instruction
        bArr35[0] = 98;
        bArr35[1] = 96;
        bArr35[2] = 112;
        bArr35[3] = 13;
        bArr35[4] = 97;
        bArr35[5] = -122;
        bArr35[6] = -80;
        bArr35[7] = 23;
        bArr35[8] = 55;
        bArr35[9] = -14;
        bArr35[10] = -17;
        bArr35[11] = -39;
        bArr35[12] = 16;
        bArr35[13] = 48;
        bArr35[14] = 125;
        bArr35[15] = 107;
        byte[] bArr37 = new byte[16];
        // fill-array-data instruction
        bArr37[0] = 90;
        bArr37[1] = -54;
        bArr37[2] = 69;
        bArr37[3] = -62;
        bArr37[4] = 33;
        bArr37[5] = 48;
        bArr37[6] = 4;
        bArr37[7] = 67;
        bArr37[8] = -127;
        bArr37[9] = -62;
        bArr37[10] = -111;
        bArr37[11] = 83;
        bArr37[12] = -10;
        bArr37[13] = -4;
        bArr37[14] = -102;
        bArr37[15] = -58;
        byte[] bArr38 = new byte[16];
        // fill-array-data instruction
        bArr38[0] = -110;
        bArr38[1] = 35;
        bArr38[2] = -105;
        bArr38[3] = 60;
        bArr38[4] = 34;
        bArr38[5] = 107;
        bArr38[6] = 104;
        bArr38[7] = -69;
        bArr38[8] = 44;
        bArr38[9] = -81;
        bArr38[10] = -110;
        bArr38[11] = -24;
        bArr38[12] = 54;
        bArr38[13] = -47;
        bArr38[14] = -108;
        bArr38[15] = 58;
        RC = new byte[][]{bArr30, bArr4, bArr6, bArr8, bArr10, bArr12, bArr14, bArr16, bArr18, bArr20, bArr22, bArr24, bArr26, bArr28, bArr29, bArr32, bArr34, bArr36, bArr37, bArr38};
    }

    public Haraka256Digest() {
        this.buffer = new byte[32];
    }

    private int haraka256256(byte[] bArr, byte[] bArr2, int i) {
        int[] iArr = new int[2];
        iArr[1] = 16;
        iArr[0] = 2;
        Class cls = Byte.TYPE;
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = 16;
        iArr2[0] = 2;
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls, iArr2);
        System.arraycopy(bArr, 0, bArr3[0], 0, 16);
        System.arraycopy(bArr, 16, bArr3[1], 0, 16);
        byte[] bArr5 = bArr3[0];
        byte[][] bArr6 = RC;
        bArr3[0] = HarakaBase.aesEnc(bArr5, bArr6[0]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[1]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[2]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[3]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[4]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[5]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[6]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[7]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[8]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[9]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[10]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[11]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[12]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[13]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[14]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[15]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[16]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[17]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[18]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[19]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.xor(bArr4[0], bArr, 0);
        bArr3[1] = HarakaBase.xor(bArr4[1], bArr, 16);
        System.arraycopy(bArr3[0], 0, bArr2, i, 16);
        System.arraycopy(bArr3[1], 0, bArr2, i + 16, 16);
        return 32;
    }

    private void mix256(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 0, bArr2[0], 0, 4);
        System.arraycopy(bArr[1], 0, bArr2[0], 4, 4);
        System.arraycopy(bArr[0], 4, bArr2[0], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[0], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[1], 0, 4);
        System.arraycopy(bArr[1], 8, bArr2[1], 4, 4);
        System.arraycopy(bArr[0], 12, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 12, bArr2[1], 12, 4);
    }

    public int doFinal(byte[] bArr, int i) {
        if (this.off != 32) {
            throw new IllegalStateException("input must be exactly 32 bytes");
        } else if (bArr.length - i >= 32) {
            int haraka256256 = haraka256256(this.buffer, bArr, i);
            reset();
            return haraka256256;
        } else {
            throw new IllegalArgumentException("output too short to receive digest");
        }
    }

    public String getAlgorithmName() {
        return "Haraka-256";
    }

    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    public void update(byte b) {
        int i = this.off;
        if (i + 1 <= 32) {
            byte[] bArr = this.buffer;
            this.off = i + 1;
            bArr[i] = b;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }

    public Haraka256Digest(Haraka256Digest haraka256Digest) {
        this.buffer = Arrays.clone(haraka256Digest.buffer);
        this.off = haraka256Digest.off;
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = this.off;
        if (i3 + i2 <= 32) {
            System.arraycopy(bArr, i, this.buffer, i3, i2);
            this.off += i2;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }
}
