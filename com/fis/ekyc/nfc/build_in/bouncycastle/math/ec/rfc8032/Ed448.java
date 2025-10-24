package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.rfc8032;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Xof;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHAKEDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.rfc7748.X448;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.rfc7748.X448Field;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.security.SecureRandom;

public abstract class Ed448 {
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, ISOFileInfo.FMD_BYTE, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_DECREASE_STAMPED, 56};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase = null;
    private static PointExt[] precompBaseTable = null;
    private static final Object precompLock = new Object();

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    public static class F extends X448Field {
        private F() {
        }
    }

    public static class PointExt {
        int[] x;
        int[] y;
        int[] z;

        private PointExt() {
            this.x = X448Field.create();
            this.y = X448Field.create();
            this.z = X448Field.create();
        }
    }

    public static class PointPrecomp {
        int[] x;
        int[] y;

        private PointPrecomp() {
            this.x = X448Field.create();
            this.y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        if (bArr == null || bArr.length >= 256) {
            return false;
        }
        return true;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create, 39081, create);
        X448Field.subOne(create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & Byte.MAX_VALUE) != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decode32(bArr, 0, iArr, 0, 14);
        return !Nat.gte(14, iArr, P);
    }

    private static boolean checkScalarVar(byte[] bArr) {
        if (bArr[56] != 0) {
            return false;
        }
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        return !Nat.gte(14, iArr, L);
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private static int decode24(byte[] bArr, int i) {
        return ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i + 57);
        boolean z2 = false;
        if (!checkPointVar(copyOfRange)) {
            return false;
        }
        byte b = copyOfRange[56];
        int i2 = (b & ISOFileInfo.DATA_BYTES1) >>> 7;
        copyOfRange[56] = (byte) (b & Byte.MAX_VALUE);
        X448Field.decode(copyOfRange, 0, pointExt.y);
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.sqr(pointExt.y, create);
        X448Field.mul(create, 39081, create2);
        X448Field.negate(create, create);
        X448Field.addOne(create);
        X448Field.addOne(create2);
        if (!X448Field.sqrtRatioVar(create, create2, pointExt.x)) {
            return false;
        }
        X448Field.normalize(pointExt.x);
        if (i2 == 1 && X448Field.isZeroVar(pointExt.x)) {
            return false;
        }
        int[] iArr = pointExt.x;
        if (i2 != (iArr[0] & 1)) {
            z2 = true;
        }
        if (z ^ z2) {
            X448Field.negate(iArr, iArr);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        xof.update(bArr3, 0, length2);
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        X448Field.inv(pointExt.z, create2);
        X448Field.mul(pointExt.x, create2, create);
        X448Field.mul(pointExt.y, create2, create2);
        X448Field.normalize(create);
        X448Field.normalize(create2);
        int checkPoint = checkPoint(create, create2);
        X448Field.encode(create2, bArr, i);
        bArr[i + 56] = (byte) ((create[0] & 1) << 7);
        return checkPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof createXof = createXof();
        byte[] bArr3 = new byte[114];
        createXof.update(bArr, i, 57);
        createXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int i2;
        int[] iArr2 = new int[28];
        int i3 = 0;
        int i4 = 14;
        int i5 = 28;
        int i6 = 0;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            int i7 = iArr[i4];
            iArr2[i5 - 1] = (i6 << 16) | (i7 >>> 16);
            i5 -= 2;
            iArr2[i5] = i7;
            i6 = i7;
        }
        byte[] bArr = new byte[447];
        int i8 = 1 << i;
        int i9 = i8 - 1;
        int i10 = i8 >>> 1;
        int i11 = 0;
        int i12 = 0;
        while (i3 < 28) {
            int i13 = iArr2[i3];
            while (i2 < 16) {
                int i14 = i13 >>> i2;
                if ((i14 & 1) == i12) {
                    i2++;
                } else {
                    int i15 = (i14 & i9) + i12;
                    int i16 = i15 & i10;
                    int i17 = i15 - (i16 << 1);
                    i12 = i16 >>> (i - 1);
                    bArr[(i3 << 4) + i2] = (byte) i17;
                    i2 += i;
                }
            }
            i3++;
            i11 = i2 - 16;
        }
        return bArr;
    }

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] reduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(reduceScalar, bArr7, 0);
        dom4(xof, b, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] calculateS = calculateS(reduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(calculateS, 0, bArr6, i4 + 57, 57);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (checkContextVar(bArr3)) {
            int i5 = i + 57;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, i5, i + 114);
            if (!checkPointVar(copyOfRange) || !checkScalarVar(copyOfRange2)) {
                return false;
            }
            PointExt pointExt = new PointExt();
            if (!decodePointVar(bArr2, i2, true, pointExt)) {
                return false;
            }
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            dom4(createXof, b, bArr3);
            createXof.update(copyOfRange, 0, 57);
            createXof.update(bArr2, i2, 57);
            createXof.update(bArr4, i3, i4);
            createXof.doFinal(bArr5, 0, 114);
            byte[] reduceScalar = reduceScalar(bArr5);
            int[] iArr = new int[14];
            decodeScalar(copyOfRange2, 0, iArr);
            int[] iArr2 = new int[14];
            decodeScalar(reduceScalar, 0, iArr2);
            PointExt pointExt2 = new PointExt();
            scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
            byte[] bArr6 = new byte[57];
            if (encodePoint(pointExt2, bArr6, 0) == 0 || !Arrays.areEqual(bArr6, copyOfRange)) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        X448Field.mul(pointExt.z, pointExt2.z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.x, pointExt2.x, create3);
        X448Field.mul(pointExt.y, pointExt2.y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, create6);
        X448Field.sub(create2, create5, create7);
        X448Field.add(pointExt.x, pointExt.y, create2);
        X448Field.add(pointExt2.x, pointExt2.y, create5);
        X448Field.mul(create2, create5, create8);
        X448Field.add(create4, create3, create2);
        X448Field.sub(create4, create3, create5);
        X448Field.carry(create2);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.x);
        X448Field.mul(create5, create7, pointExt2.y);
        X448Field.mul(create6, create7, pointExt2.z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        X448Field.sqr(pointExt.z, create);
        X448Field.mul(pointPrecomp.x, pointExt.x, create2);
        X448Field.mul(pointPrecomp.y, pointExt.y, create3);
        X448Field.mul(create2, create3, create4);
        X448Field.mul(create4, 39081, create4);
        X448Field.add(create, create4, create5);
        X448Field.sub(create, create4, create6);
        X448Field.add(pointPrecomp.x, pointPrecomp.y, create);
        X448Field.add(pointExt.x, pointExt.y, create4);
        X448Field.mul(create, create4, create7);
        X448Field.add(create3, create2, create);
        X448Field.sub(create3, create2, create4);
        X448Field.carry(create);
        X448Field.sub(create7, create, create7);
        X448Field.mul(create7, pointExt.z, create7);
        X448Field.mul(create4, pointExt.z, create4);
        X448Field.mul(create5, create7, pointExt.x);
        X448Field.mul(create4, create6, pointExt.y);
        X448Field.mul(create5, create6, pointExt.z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        int[] create7 = X448Field.create();
        int[] create8 = X448Field.create();
        if (z) {
            X448Field.sub(pointExt.y, pointExt.x, create8);
            iArr2 = create2;
            iArr3 = create5;
            iArr4 = create6;
            iArr = create7;
        } else {
            X448Field.add(pointExt.y, pointExt.x, create8);
            iArr3 = create2;
            iArr2 = create5;
            iArr = create6;
            iArr4 = create7;
        }
        X448Field.mul(pointExt.z, pointExt2.z, create);
        X448Field.sqr(create, create2);
        X448Field.mul(pointExt.x, pointExt2.x, create3);
        X448Field.mul(pointExt.y, pointExt2.y, create4);
        X448Field.mul(create3, create4, create5);
        X448Field.mul(create5, 39081, create5);
        X448Field.add(create2, create5, iArr);
        X448Field.sub(create2, create5, iArr4);
        X448Field.add(pointExt2.x, pointExt2.y, create5);
        X448Field.mul(create8, create5, create8);
        X448Field.add(create4, create3, iArr3);
        X448Field.sub(create4, create3, iArr2);
        X448Field.carry(iArr3);
        X448Field.sub(create8, create2, create8);
        X448Field.mul(create8, create, create8);
        X448Field.mul(create5, create, create5);
        X448Field.mul(create6, create8, pointExt2.x);
        X448Field.mul(create5, create7, pointExt2.y);
        X448Field.mul(create6, create7, pointExt2.z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointDouble(PointExt pointExt) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        int[] create5 = X448Field.create();
        int[] create6 = X448Field.create();
        X448Field.add(pointExt.x, pointExt.y, create);
        X448Field.sqr(create, create);
        X448Field.sqr(pointExt.x, create2);
        X448Field.sqr(pointExt.y, create3);
        X448Field.add(create2, create3, create4);
        X448Field.carry(create4);
        X448Field.sqr(pointExt.z, create5);
        X448Field.add(create5, create5, create5);
        X448Field.carry(create5);
        X448Field.sub(create4, create5, create6);
        X448Field.sub(create, create4, create);
        X448Field.sub(create2, create3, create2);
        X448Field.mul(create, create6, pointExt.x);
        X448Field.mul(create4, create2, pointExt.y);
        X448Field.mul(create4, create6, pointExt.z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 512;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X448Field.cmov(i5, precompBase, i3, pointPrecomp.x, 0);
            X448Field.cmov(i5, precompBase, i3 + 16, pointPrecomp.y, 0);
            i3 += 32;
        }
    }

    private static int[] pointPrecompute(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        PointExt pointCopy2 = pointCopy(pointCopy);
        pointDouble(pointCopy2);
        int[] createTable = X448Field.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            X448Field.copy(pointCopy.x, 0, createTable, i2);
            X448Field.copy(pointCopy.y, 0, createTable, i2 + 16);
            X448Field.copy(pointCopy.z, 0, createTable, i2 + 32);
            i2 += 48;
            i3++;
            if (i3 == i) {
                return createTable;
            }
            pointAdd(pointCopy2, pointCopy);
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointCopy = pointCopy(pointExt);
        pointDouble(pointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointCopy2 = pointCopy(pointExtArr[i2 - 1]);
            pointExtArr[i2] = pointCopy2;
            pointAddVar(false, pointCopy, pointCopy2);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.x);
        X448Field.one(pointExt.y);
        X448Field.one(pointExt.z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            try {
                if (precompBase == null) {
                    PointExt pointExt = new PointExt();
                    X448Field.copy(B_x, 0, pointExt.x, 0);
                    X448Field.copy(B_y, 0, pointExt.y, 0);
                    pointExtendXY(pointExt);
                    precompBaseTable = pointPrecomputeVar(pointExt, 32);
                    precompBase = X448Field.createTable(160);
                    int i = 0;
                    for (int i2 = 0; i2 < 5; i2++) {
                        PointExt[] pointExtArr = new PointExt[5];
                        PointExt pointExt2 = new PointExt();
                        pointSetNeutral(pointExt2);
                        int i3 = 0;
                        while (true) {
                            if (i3 >= 5) {
                                break;
                            }
                            pointAddVar(true, pointExt, pointExt2);
                            pointDouble(pointExt);
                            pointExtArr[i3] = pointCopy(pointExt);
                            if (i2 + i3 != 8) {
                                for (int i4 = 1; i4 < 18; i4++) {
                                    pointDouble(pointExt);
                                }
                            }
                            i3++;
                        }
                        PointExt[] pointExtArr2 = new PointExt[16];
                        pointExtArr2[0] = pointExt2;
                        int i5 = 1;
                        for (int i6 = 0; i6 < 4; i6++) {
                            int i7 = 1 << i6;
                            int i8 = 0;
                            while (i8 < i7) {
                                PointExt pointCopy = pointCopy(pointExtArr2[i5 - i7]);
                                pointExtArr2[i5] = pointCopy;
                                pointAddVar(false, pointExtArr[i6], pointCopy);
                                i8++;
                                i5++;
                            }
                        }
                        int[] createTable = X448Field.createTable(16);
                        int[] create = X448Field.create();
                        X448Field.copy(pointExtArr2[0].z, 0, create, 0);
                        X448Field.copy(create, 0, createTable, 0);
                        int i9 = 0;
                        while (true) {
                            int i10 = i9 + 1;
                            if (i10 >= 16) {
                                break;
                            }
                            X448Field.mul(create, pointExtArr2[i10].z, create);
                            X448Field.copy(create, 0, createTable, i10 * 16);
                            i9 = i10;
                        }
                        X448Field.invVar(create, create);
                        int[] create2 = X448Field.create();
                        while (i9 > 0) {
                            int i11 = i9 - 1;
                            X448Field.copy(createTable, i11 * 16, create2, 0);
                            X448Field.mul(create2, create, create2);
                            X448Field.copy(create2, 0, createTable, i9 * 16);
                            X448Field.mul(create, pointExtArr2[i9].z, create);
                            i9 = i11;
                        }
                        X448Field.copy(create, 0, createTable, 0);
                        for (int i12 = 0; i12 < 16; i12++) {
                            PointExt pointExt3 = pointExtArr2[i12];
                            X448Field.copy(createTable, i12 * 16, pointExt3.z, 0);
                            int[] iArr = pointExt3.x;
                            X448Field.mul(iArr, pointExt3.z, iArr);
                            int[] iArr2 = pointExt3.y;
                            X448Field.mul(iArr2, pointExt3.z, iArr2);
                            X448Field.copy(pointExt3.x, 0, precompBase, i);
                            X448Field.copy(pointExt3.y, 0, precompBase, i + 16);
                            i += 32;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | ISOFileInfo.DATA_BYTES1);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        byte[] bArr2 = bArr;
        long decode24 = ((long) (decode24(bArr2, 4) << 4)) & 4294967295L;
        long decode32 = ((long) decode32(bArr2, 7)) & 4294967295L;
        long decode242 = ((long) (decode24(bArr2, 11) << 4)) & 4294967295L;
        long decode322 = ((long) decode32(bArr2, 14)) & 4294967295L;
        long decode243 = ((long) (decode24(bArr2, 18) << 4)) & 4294967295L;
        long decode323 = ((long) decode32(bArr2, 21)) & 4294967295L;
        long decode244 = ((long) (decode24(bArr2, 25) << 4)) & 4294967295L;
        long decode324 = ((long) decode32(bArr2, 28)) & 4294967295L;
        long decode245 = ((long) (decode24(bArr2, 32) << 4)) & 4294967295L;
        long decode325 = ((long) decode32(bArr2, 35)) & 4294967295L;
        long decode246 = ((long) (decode24(bArr2, 39) << 4)) & 4294967295L;
        long decode326 = ((long) decode32(bArr2, 42)) & 4294967295L;
        long decode247 = ((long) (decode24(bArr2, 46) << 4)) & 4294967295L;
        long decode327 = ((long) decode32(bArr2, 49)) & 4294967295L;
        long decode248 = ((long) (decode24(bArr2, 53) << 4)) & 4294967295L;
        long decode249 = ((long) (decode24(bArr2, 74) << 4)) & 4294967295L;
        long decode328 = ((long) decode32(bArr2, 77)) & 4294967295L;
        long decode2410 = ((long) (decode24(bArr2, 81) << 4)) & 4294967295L;
        long decode329 = (long) decode32(bArr2, 84);
        long j = decode329 & 4294967295L;
        long j2 = decode329;
        long decode2411 = ((long) (decode24(bArr2, 88) << 4)) & 4294967295L;
        long decode3210 = (long) decode32(bArr2, 91);
        long j3 = decode3210 & 4294967295L;
        long j4 = decode3210;
        long decode2412 = ((long) (decode24(bArr2, 95) << 4)) & 4294967295L;
        long decode3211 = (long) decode32(bArr2, 98);
        long j5 = decode3211 & 4294967295L;
        long j6 = decode3211;
        long decode2413 = ((long) (decode24(bArr2, LDSFile.EF_DG6_TAG) << 4)) & 4294967295L;
        long decode3212 = (long) decode32(bArr2, LDSFile.EF_DG9_TAG);
        long decode2414 = ((long) (decode24(bArr2, LDSFile.EF_DG13_TAG) << 4)) & 4294967295L;
        long decode16 = ((long) decode16(bArr2, LDSFile.EF_DG16_TAG)) & 4294967295L;
        long j7 = decode2410 + (decode16 * 550336261);
        long j8 = decode2414 + ((decode3212 & 4294967295L) >>> 28);
        long j9 = decode3212 & M28L;
        long decode3213 = (((long) decode32(bArr2, 56)) & 4294967295L) + (decode16 * 43969588) + (j8 * 30366549);
        long decode2415 = (((long) (decode24(bArr2, 60) << 4)) & 4294967295L) + (decode16 * 30366549) + (j8 * 163752818);
        long decode3214 = (((long) decode32(bArr2, 63)) & 4294967295L) + (decode16 * 163752818) + (j8 * 258169998);
        long decode2416 = (((long) (decode24(bArr2, 67) << 4)) & 4294967295L) + (decode16 * 258169998) + (j8 * 96434764);
        long j10 = decode328 + (decode16 * 149865618) + (j8 * 550336261);
        long j11 = decode2413 + (j5 >>> 28);
        long j12 = j6 & M28L;
        long decode3215 = (((long) decode32(bArr2, 70)) & 4294967295L) + (decode16 * 96434764) + (j8 * 227822194) + (j9 * 149865618) + (j11 * 550336261);
        long j13 = decode2412 + (j3 >>> 28);
        long j14 = j4 & M28L;
        long j15 = decode3214 + (j9 * 96434764) + (j11 * 227822194) + (j12 * 149865618) + (j13 * 550336261);
        long j16 = decode2415 + (j9 * 258169998) + (j11 * 96434764) + (j12 * 227822194) + (j13 * 149865618) + (j14 * 550336261);
        long j17 = decode2411 + (j >>> 28);
        long j18 = j2 & M28L;
        long j19 = decode249 + (decode16 * 227822194) + (j8 * 149865618) + (j9 * 550336261) + (decode3215 >>> 28);
        long j20 = decode3215 & M28L;
        long j21 = j10 + (j19 >>> 28);
        long j22 = j19 & M28L;
        long j23 = j7 + (j21 >>> 28);
        long j24 = j21 & M28L;
        long j25 = j18 + (j23 >>> 28);
        long j26 = j23 & M28L;
        long j27 = decode244 + (j26 * 43969588);
        long j28 = decode324 + (j25 * 43969588) + (j26 * 30366549);
        long j29 = decode245 + (j17 * 43969588) + (j25 * 30366549) + (j26 * 163752818);
        long j30 = decode325 + (j14 * 43969588) + (j17 * 30366549) + (j25 * 163752818) + (j26 * 258169998);
        long j31 = decode246 + (j13 * 43969588) + (j14 * 30366549) + (j17 * 163752818) + (j25 * 258169998) + (j26 * 96434764);
        long j32 = decode326 + (j12 * 43969588) + (j13 * 30366549) + (j14 * 163752818) + (j17 * 258169998) + (j25 * 96434764) + (j26 * 227822194);
        long j33 = decode327 + (j9 * 43969588) + (j11 * 30366549) + (j12 * 163752818) + (j13 * 258169998) + (j14 * 96434764) + (j17 * 227822194) + (j25 * 149865618) + (j26 * 550336261);
        long j34 = j15 + (j16 >>> 28);
        long j35 = j16 & M28L;
        long j36 = decode2416 + (j9 * 227822194) + (j11 * 149865618) + (j12 * 550336261) + (j34 >>> 28);
        long j37 = j34 & M28L;
        long j38 = j20 + (j36 >>> 28);
        long j39 = j36 & M28L;
        long j40 = j22 + (j38 >>> 28);
        long j41 = j38 & M28L;
        long j42 = decode322 + (j41 * 43969588);
        long j43 = decode243 + (j40 * 43969588) + (j41 * 30366549);
        long j44 = decode323 + (j24 * 43969588) + (j40 * 30366549) + (j41 * 163752818);
        long j45 = j27 + (j24 * 30366549) + (j40 * 163752818) + (j41 * 258169998);
        long j46 = j28 + (j24 * 163752818) + (j40 * 258169998) + (j41 * 96434764);
        long j47 = j29 + (j24 * 258169998) + (j40 * 96434764) + (j41 * 227822194);
        long j48 = j31 + (j24 * 227822194) + (j40 * 149865618) + (j41 * 550336261);
        long j49 = decode242 + (j39 * 43969588);
        long j50 = j42 + (j39 * 30366549);
        long j51 = j43 + (j39 * 163752818);
        long j52 = j44 + (j39 * 258169998);
        long j53 = j45 + (j39 * 96434764);
        long j54 = j46 + (j39 * 227822194);
        long j55 = j47 + (j39 * 149865618);
        long j56 = j30 + (j24 * 96434764) + (j40 * 227822194) + (j41 * 149865618) + (j39 * 550336261);
        long j57 = decode248 + (j8 * 43969588) + (j9 * 30366549) + (j11 * 163752818) + (j12 * 258169998) + (j13 * 96434764) + (j14 * 227822194) + (j17 * 149865618) + (j25 * 550336261) + (j33 >>> 28);
        long j58 = j33 & M28L;
        long j59 = decode3213 + (j9 * 163752818) + (j11 * 258169998) + (j12 * 96434764) + (j13 * 227822194) + (j14 * 149865618) + (j17 * 550336261) + (j57 >>> 28);
        long j60 = j57 & M28L;
        long j61 = j35 + (j59 >>> 28);
        long j62 = j59 & M28L;
        long j63 = j37 + (j61 >>> 28);
        long j64 = j61 & M28L;
        long j65 = decode32 + (j63 * 43969588);
        long j66 = j49 + (j63 * 30366549);
        long j67 = j50 + (j63 * 163752818);
        long j68 = j51 + (j63 * 258169998);
        long j69 = j52 + (j63 * 96434764);
        long j70 = j53 + (j63 * 227822194);
        long j71 = j55 + (j63 * 550336261);
        long j72 = j57 & M26L;
        long j73 = (j62 * 4) + (j60 >>> 26) + 1;
        long decode3216 = (((long) decode32(bArr2, 0)) & 4294967295L) + (78101261 * j73);
        long j74 = j65 + (30366549 * j64) + (175155932 * j73);
        long j75 = j66 + (163752818 * j64) + (64542499 * j73);
        long j76 = j67 + (258169998 * j64) + (158326419 * j73);
        long j77 = j68 + (96434764 * j64) + (191173276 * j73);
        long j78 = j70 + (149865618 * j64) + (j73 * 137584065);
        long j79 = decode24 + (43969588 * j64) + (141809365 * j73) + (decode3216 >>> 28);
        long j80 = decode3216 & M28L;
        long j81 = j74 + (j79 >>> 28);
        long j82 = j79 & M28L;
        long j83 = j75 + (j81 >>> 28);
        long j84 = j81 & M28L;
        long j85 = j76 + (j83 >>> 28);
        long j86 = j83 & M28L;
        long j87 = j77 + (j85 >>> 28);
        long j88 = j85 & M28L;
        long j89 = j69 + (227822194 * j64) + (104575268 * j73) + (j87 >>> 28);
        long j90 = j87 & M28L;
        long j91 = j78 + (j89 >>> 28);
        long j92 = j89 & M28L;
        long j93 = j54 + (j63 * 149865618) + (j64 * 550336261) + (j91 >>> 28);
        long j94 = j91 & M28L;
        long j95 = j71 + (j93 >>> 28);
        long j96 = j93 & M28L;
        long j97 = j56 + (j95 >>> 28);
        long j98 = j95 & M28L;
        long j99 = j48 + (j97 >>> 28);
        long j100 = j97 & M28L;
        long j101 = j32 + (j24 * 149865618) + (j40 * 550336261) + (j99 >>> 28);
        long j102 = j99 & M28L;
        long j103 = decode247 + (j11 * 43969588) + (j12 * 30366549) + (j13 * 163752818) + (j14 * 258169998) + (j17 * 96434764) + (j25 * 227822194) + (j26 * 149865618) + (j24 * 550336261) + (j101 >>> 28);
        long j104 = j101 & M28L;
        long j105 = j58 + (j103 >>> 28);
        long j106 = j103 & M28L;
        long j107 = j72 + (j105 >>> 28);
        long j108 = j105 & M28L;
        long j109 = j107 & M26L;
        long j110 = (j107 >>> 26) - 1;
        long j111 = j80 - (j110 & 78101261);
        long j112 = (j82 - (j110 & 141809365)) + (j111 >> 28);
        long j113 = j111 & M28L;
        long j114 = (j84 - (j110 & 175155932)) + (j112 >> 28);
        long j115 = j112 & M28L;
        long j116 = (j86 - (j110 & 64542499)) + (j114 >> 28);
        long j117 = j114 & M28L;
        long j118 = (j88 - (j110 & 158326419)) + (j116 >> 28);
        long j119 = j116 & M28L;
        long j120 = (j90 - (j110 & 191173276)) + (j118 >> 28);
        long j121 = j118 & M28L;
        long j122 = (j92 - (j110 & 104575268)) + (j120 >> 28);
        long j123 = j120 & M28L;
        long j124 = (j94 - (j110 & 137584065)) + (j122 >> 28);
        long j125 = j122 & M28L;
        long j126 = j96 + (j124 >> 28);
        long j127 = j124 & M28L;
        long j128 = j98 + (j126 >> 28);
        long j129 = j126 & M28L;
        long j130 = j100 + (j128 >> 28);
        long j131 = j128 & M28L;
        long j132 = j102 + (j130 >> 28);
        long j133 = j130 & M28L;
        long j134 = j104 + (j132 >> 28);
        long j135 = j132 & M28L;
        long j136 = j106 + (j134 >> 28);
        long j137 = j134 & M28L;
        long j138 = j108 + (j136 >> 28);
        long j139 = j136 & M28L;
        long j140 = j138 & M28L;
        byte[] bArr3 = new byte[57];
        encode56((j115 << 28) | j113, bArr3, 0);
        encode56((j119 << 28) | j117, bArr3, 7);
        encode56(j121 | (j123 << 28), bArr3, 14);
        encode56(j125 | (j127 << 28), bArr3, 21);
        encode56(j129 | (j131 << 28), bArr3, 28);
        encode56(j133 | (j135 << 28), bArr3, 35);
        encode56(j137 | (j139 << 28), bArr3, 42);
        encode56(((j109 + (j138 >> 28)) << 28) | j140, bArr3, 49);
        return bArr3;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(14, iArr, 2, 0);
        Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(14, iArr, 1);
        int[] pointPrecompute = pointPrecompute(pointExt, 8);
        PointExt pointExt3 = new PointExt();
        pointLookup(iArr, LDSFile.EF_DG15_TAG, pointPrecompute, pointExt2);
        for (int i = LDSFile.EF_DG14_TAG; i >= 0; i--) {
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointExt2);
            }
            pointLookup(iArr, i, pointPrecompute, pointExt3);
            pointAdd(pointExt3, pointExt2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                X448Field.cnegate(i6, pointPrecomp.x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt);
            } else {
                return;
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend != null) {
            byte[] bArr2 = new byte[57];
            pruneScalar(bArr, i, bArr2);
            PointExt pointExt = new PointExt();
            scalarMultBase(bArr2, pointExt);
            if (checkPoint(pointExt.x, pointExt.y, pointExt.z) != 0) {
                X448Field.copy(pointExt.x, 0, iArr, 0);
                X448Field.copy(pointExt.y, 0, iArr2, 0);
                return;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("This method is only for use by X448");
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        boolean z;
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b = wnafVar[i];
            boolean z2 = false;
            if (b != 0) {
                int i2 = b >> 31;
                int i3 = (b ^ i2) >>> 1;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                pointAddVar(z, precompBaseTable[i3], pointExt2);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i4 = b2 >> 31;
                int i5 = (b2 ^ i4) >>> 1;
                if (i4 != 0) {
                    z2 = true;
                }
                pointAddVar(z2, pointPrecomputeVar[i5], pointExt2);
            }
            i--;
            if (i >= 0) {
                pointDouble(pointExt2);
            } else {
                return;
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.x, 0, pointExt2.x, 0);
        X448Field.copy(pointExt.y, 0, pointExt2.y, 0);
        X448Field.copy(pointExt.z, 0, pointExt2.z, 0);
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            X448Field.cmov(i6, iArr2, i4, pointExt.x, 0);
            X448Field.cmov(i6, iArr2, i4 + 16, pointExt.y, 0);
            X448Field.cmov(i6, iArr2, i4 + 32, pointExt.z, 0);
            i4 += 48;
        }
        X448Field.cnegate(i2, pointExt.x);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 == xof.doFinal(bArr5, 0, 64)) {
            implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
            return;
        }
        throw new IllegalArgumentException("ph");
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = X448Field.create();
        int[] create2 = X448Field.create();
        int[] create3 = X448Field.create();
        int[] create4 = X448Field.create();
        X448Field.sqr(iArr, create2);
        X448Field.sqr(iArr2, create3);
        X448Field.sqr(iArr3, create4);
        X448Field.mul(create2, create3, create);
        X448Field.add(create2, create3, create2);
        X448Field.mul(create2, create4, create2);
        X448Field.sqr(create4, create4);
        X448Field.mul(create, 39081, create);
        X448Field.sub(create, create4, create);
        X448Field.add(create, create2, create);
        X448Field.normalize(create);
        return X448Field.isZero(create);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (checkContextVar(bArr2)) {
            Xof createXof = createXof();
            byte[] bArr5 = new byte[114];
            byte[] bArr6 = bArr;
            int i5 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr5, 0, 114);
            byte[] bArr7 = new byte[57];
            pruneScalar(bArr5, 0, bArr7);
            byte[] bArr8 = new byte[57];
            scalarMultBaseEncoded(bArr7, bArr8, 0);
            implSign(createXof, bArr5, bArr7, bArr8, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (checkContextVar(bArr3)) {
            Xof createXof = createXof();
            byte[] bArr6 = new byte[114];
            byte[] bArr7 = bArr;
            int i6 = i;
            createXof.update(bArr, i, 57);
            createXof.doFinal(bArr6, 0, 114);
            byte[] bArr8 = new byte[57];
            pruneScalar(bArr6, 0, bArr8);
            implSign(createXof, bArr6, bArr8, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
            return;
        }
        throw new IllegalArgumentException("ctx");
    }
}
