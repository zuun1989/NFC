package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DisplayText;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ExtendedDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.Primes;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Memoable;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.IrisImageInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final long[] C0 = new long[256];
    private static final long[] C1 = new long[256];
    private static final long[] C2 = new long[256];
    private static final long[] C3 = new long[256];

    /* renamed from: C4  reason: collision with root package name */
    private static final long[] f11C4 = new long[256];
    private static final long[] C5 = new long[256];
    private static final long[] C6 = new long[256];
    private static final long[] C7 = new long[256];
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, LDSFile.EF_DG15_TAG, 145, 82, 96, 188, ModuleDescriptor.MODULE_VERSION, 142, 163, 12, 123, 53, 29, 224, 215, 194, 46, 75, IrisImageInfo.IMAGE_QUAL_UNDEF, 87, 21, LDSFile.EF_SOD_TAG, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, LDSFile.EF_DG11_TAG, 133, 189, 93, 16, 244, 203, 62, 5, LDSFile.EF_DG7_TAG, 228, 39, 65, 139, 167, ISO781611.SMT_TAG, 149, 216, 251, 238, 124, LDSFile.EF_DG6_TAG, 221, 23, 71, ISO781611.SMT_DO_DS, 202, 45, 191, 7, 173, 90, ISO781611.CREATION_DATE_AND_TIME_TAG, 51, 99, 2, 170, 113, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 25, 73, 217, 242, 227, 91, ISO781611.FORMAT_TYPE_TAG, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, LDSFile.EF_DG8_TAG, 26, 174, 180, 84, 147, 34, 100, 241, ISO781611.DISCRETIONARY_DATA_FOR_PAYLOAD_CONSTRUCTED_TAG, 18, 64, 8, 195, 236, 219, 161, 141, 61, ISO7816.TAG_SM_EXPECTED_LENGTH, 0, 207, 43, LDSFile.EF_DG4_TAG, ISO781611.BIOMETRIC_SUBTYPE_TAG, 214, 27, 181, 175, LDSFile.EF_DG10_TAG, 80, 69, 243, 48, 239, 63, 85, 162, 234, LDSFile.EF_DG5_TAG, 186, 47, CertificateHolderAuthorization.CVCA, 222, 28, 253, 77, 146, LDSFile.EF_DG2_TAG, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, ISO7816.TAG_SM_STATUS_WORD, LDSFile.EF_DG13_TAG, 13, 250, IdCardService.DEFAULT_MAX_BLOCKSIZE, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, Primes.SMALL_FACTOR_LIMIT, 231, LDSFile.EF_DG14_TAG, 196, 3, 86, 68, CertificateBody.profileType, 169, 42, 187, 193, 83, 220, 11, 157, LDSFile.EF_DG12_TAG, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, LDSFile.EF_DG9_TAG, 9, LDSFile.EF_DG16_TAG, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, ISO781611.CREATOR_OF_BIOMETRIC_REFERENCE_DATA};
    private long[] _K = new long[8];
    private long[] _L = new long[8];
    private short[] _bitCount = new short[32];
    private long[] _block = new long[8];
    private byte[] _buffer = new byte[64];
    private int _bufferPos = 0;
    private long[] _hash = new long[8];
    private final long[] _rc = new long[11];
    private long[] _state = new long[8];

    static {
        short[] sArr = new short[32];
        EIGHT = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        for (int i = 0; i < 256; i++) {
            int i2 = SBOX[i];
            int maskWithReductionPolynomial = maskWithReductionPolynomial(i2 << 1);
            int maskWithReductionPolynomial2 = maskWithReductionPolynomial(maskWithReductionPolynomial << 1);
            int i3 = maskWithReductionPolynomial2 ^ i2;
            int maskWithReductionPolynomial3 = maskWithReductionPolynomial(maskWithReductionPolynomial2 << 1);
            int i4 = maskWithReductionPolynomial3 ^ i2;
            int i5 = i2;
            C0[i] = packIntoLong(i2, i5, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4);
            int i6 = i2;
            C1[i] = packIntoLong(i4, i5, i6, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial);
            int i7 = i2;
            C2[i] = packIntoLong(maskWithReductionPolynomial, i4, i6, i7, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3);
            int i8 = i2;
            C3[i] = packIntoLong(i3, maskWithReductionPolynomial, i4, i7, i8, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3);
            int i9 = i2;
            f11C4[i] = packIntoLong(maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i8, i9, maskWithReductionPolynomial2, i2);
            int i10 = i2;
            C5[i] = packIntoLong(i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i9, i10, maskWithReductionPolynomial2);
            int i11 = i2;
            C6[i] = packIntoLong(maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i10, i11);
            C7[i] = packIntoLong(i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i11);
        }
        this._rc[0] = 0;
        for (int i12 = 1; i12 <= 10; i12++) {
            int i13 = (i12 - 1) * 8;
            this._rc[i12] = (((((((C0[i13] & -72057594037927936L) ^ (C1[i13 + 1] & 71776119061217280L)) ^ (C2[i13 + 2] & 280375465082880L)) ^ (C3[i13 + 3] & 1095216660480L)) ^ (f11C4[i13 + 4] & 4278190080L)) ^ (C5[i13 + 5] & 16711680)) ^ (C6[i13 + 6] & 65280)) ^ (C7[i13 + 7] & 255);
        }
    }

    private long bytesToLongFromBuffer(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    private void convertLongToByteArray(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i + i2] = (byte) ((int) ((j >> (56 - (i2 * 8))) & 255));
        }
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 32; i++) {
            bArr[i] = (byte) (this._bitCount[i] & 255);
        }
        return bArr;
    }

    private void finish() {
        byte[] copyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        int i2 = i + 1;
        this._bufferPos = i2;
        bArr[i] = (byte) (bArr[i] | ISOFileInfo.DATA_BYTES1);
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(copyBitLength, 0, this._buffer, 32, copyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int i = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i2 = (sArr[length] & 255) + EIGHT[length] + i;
            i = i2 >>> 8;
            sArr[length] = (short) (i2 & 255);
        }
    }

    private int maskWithReductionPolynomial(int i) {
        return ((long) i) >= 256 ? i ^ REDUCTION_POLYNOMIAL : i;
    }

    private long packIntoLong(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((((long) i2) << 48) ^ (((long) i) << 56)) ^ (((long) i3) << 40)) ^ (((long) i4) << 32)) ^ (((long) i5) << 24)) ^ (((long) i6) << 16)) ^ (((long) i7) << 8)) ^ ((long) i8);
    }

    private void processFilledBuffer(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this._state.length; i2++) {
            this._block[i2] = bytesToLongFromBuffer(this._buffer, i2 * 8);
        }
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        for (int i2 = 0; i2 < 8; i2++) {
            convertLongToByteArray(this._hash[i2], bArr, (i2 * 8) + i);
        }
        reset();
        return getDigestSize();
    }

    public String getAlgorithmName() {
        return "Whirlpool";
    }

    public int getByteLength() {
        return 64;
    }

    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        for (int i = 0; i < 8; i++) {
            long[] jArr = this._state;
            long j = this._block[i];
            long[] jArr2 = this._K;
            long j2 = this._hash[i];
            jArr2[i] = j2;
            jArr[i] = j ^ j2;
        }
        int i2 = 1;
        while (i2 <= 10) {
            int i3 = 0;
            while (i3 < 8) {
                long[] jArr3 = this._L;
                jArr3[i3] = 0;
                long[] jArr4 = C0;
                long[] jArr5 = this._K;
                long j3 = jArr4[((int) (jArr5[i3 & 7] >>> 56)) & 255];
                jArr3[i3] = j3;
                long j4 = C1[((int) (jArr5[(i3 - 1) & 7] >>> 48)) & 255] ^ j3;
                jArr3[i3] = j4;
                long j5 = j4 ^ C2[((int) (jArr5[(i3 - 2) & 7] >>> 40)) & 255];
                jArr3[i3] = j5;
                long j6 = j5 ^ C3[((int) (jArr5[(i3 - 3) & 7] >>> 32)) & 255];
                jArr3[i3] = j6;
                long j7 = j6 ^ f11C4[((int) (jArr5[(i3 - 4) & 7] >>> 24)) & 255];
                jArr3[i3] = j7;
                long j8 = j7 ^ C5[((int) (jArr5[(i3 - 5) & 7] >>> 16)) & 255];
                jArr3[i3] = j8;
                long j9 = j8 ^ C6[((int) (jArr5[(i3 - 6) & 7] >>> 8)) & 255];
                jArr3[i3] = j9;
                jArr3[i3] = j9 ^ C7[((int) jArr5[(i3 - 7) & 7]) & 255];
                i3++;
                i2 = i2;
            }
            int i4 = i2;
            long[] jArr6 = this._L;
            long[] jArr7 = this._K;
            System.arraycopy(jArr6, 0, jArr7, 0, jArr7.length);
            long[] jArr8 = this._K;
            jArr8[0] = jArr8[0] ^ this._rc[i4];
            for (int i5 = 0; i5 < 8; i5++) {
                long[] jArr9 = this._L;
                long j10 = this._K[i5];
                jArr9[i5] = j10;
                long[] jArr10 = C0;
                long[] jArr11 = this._state;
                long j11 = jArr10[((int) (jArr11[i5 & 7] >>> 56)) & 255] ^ j10;
                jArr9[i5] = j11;
                long j12 = j11 ^ C1[((int) (jArr11[(i5 - 1) & 7] >>> 48)) & 255];
                jArr9[i5] = j12;
                long j13 = j12 ^ C2[((int) (jArr11[(i5 - 2) & 7] >>> 40)) & 255];
                jArr9[i5] = j13;
                long j14 = j13 ^ C3[((int) (jArr11[(i5 - 3) & 7] >>> 32)) & 255];
                jArr9[i5] = j14;
                long j15 = j14 ^ f11C4[((int) (jArr11[(i5 - 4) & 7] >>> 24)) & 255];
                jArr9[i5] = j15;
                long j16 = j15 ^ C5[((int) (jArr11[(i5 - 5) & 7] >>> 16)) & 255];
                jArr9[i5] = j16;
                long j17 = j16 ^ C6[((int) (jArr11[(i5 - 6) & 7] >>> 8)) & 255];
                jArr9[i5] = j17;
                jArr9[i5] = j17 ^ C7[((int) jArr11[(i5 - 7) & 7]) & 255];
            }
            long[] jArr12 = this._L;
            long[] jArr13 = this._state;
            System.arraycopy(jArr12, 0, jArr13, 0, jArr13.length);
            i2 = i4 + 1;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            long[] jArr14 = this._hash;
            jArr14[i6] = jArr14[i6] ^ (this._state[i6] ^ this._block[i6]);
        }
    }

    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this._K, 0);
        Arrays.fill(this._L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    public void update(byte b) {
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        bArr[i] = b;
        int i2 = i + 1;
        this._bufferPos = i2;
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    public void reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest._rc;
        long[] jArr2 = this._rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest._hash;
        long[] jArr4 = this._hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest._K;
        long[] jArr6 = this._K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest._L;
        long[] jArr8 = this._L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest._block;
        long[] jArr10 = this._block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest._state;
        long[] jArr12 = this._state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        reset(whirlpoolDigest);
    }
}
