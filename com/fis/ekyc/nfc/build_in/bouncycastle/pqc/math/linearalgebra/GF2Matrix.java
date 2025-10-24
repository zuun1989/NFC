package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.lang.reflect.Array;
import java.security.SecureRandom;

public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(byte[] bArr) {
        if (bArr.length >= 9) {
            this.numRows = LittleEndianConversions.OS2IP(bArr, 0);
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 4);
            this.numColumns = OS2IP;
            int i = this.numRows;
            int i2 = ((OS2IP + 7) >>> 3) * i;
            if (i > 0) {
                int i3 = 8;
                if (i2 == bArr.length - 8) {
                    int i4 = (OS2IP + 31) >>> 5;
                    this.length = i4;
                    int[] iArr = new int[2];
                    iArr[1] = i4;
                    iArr[0] = i;
                    this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                    int i5 = this.numColumns;
                    int i6 = i5 >> 5;
                    int i7 = i5 & 31;
                    for (int i8 = 0; i8 < this.numRows; i8++) {
                        int i9 = 0;
                        while (i9 < i6) {
                            this.matrix[i8][i9] = LittleEndianConversions.OS2IP(bArr, i3);
                            i9++;
                            i3 += 4;
                        }
                        int i10 = 0;
                        while (i10 < i7) {
                            int[] iArr2 = this.matrix[i8];
                            iArr2[i6] = ((bArr[i3] & 255) << i10) ^ iArr2[i6];
                            i10 += 8;
                            i3++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    private static void addToRow(int[] iArr, int[] iArr2, int i) {
        for (int length2 = iArr2.length - 1; length2 >= i; length2--) {
            iArr2[length2] = iArr[length2] ^ iArr2[length2];
        }
    }

    private void assignRandomLowerTriangularMatrix(int i, SecureRandom secureRandom) {
        this.numRows = i;
        this.numColumns = i;
        int i2 = (i + 31) >>> 5;
        this.length = i2;
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i3 = 0; i3 < this.numRows; i3++) {
            int i4 = i3 >>> 5;
            int i5 = i3 & 31;
            int i6 = 31 - i5;
            int i7 = 1 << i5;
            for (int i8 = 0; i8 < i4; i8++) {
                this.matrix[i3][i8] = secureRandom.nextInt();
            }
            this.matrix[i3][i4] = i7 | (secureRandom.nextInt() >>> i6);
            while (true) {
                i4++;
                if (i4 >= this.length) {
                    break;
                }
                this.matrix[i3][i4] = 0;
            }
        }
    }

    private void assignRandomRegularMatrix(int i, SecureRandom secureRandom) {
        this.numRows = i;
        this.numColumns = i;
        int i2 = (i + 31) >>> 5;
        this.length = i2;
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        GF2Matrix gF2Matrix = (GF2Matrix) new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom).rightMultiply((Matrix) new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom));
        int[] vector = new Permutation(i, secureRandom).getVector();
        for (int i3 = 0; i3 < i; i3++) {
            System.arraycopy(gF2Matrix.matrix[i3], 0, this.matrix[vector[i3]], 0, this.length);
        }
    }

    private void assignRandomUpperTriangularMatrix(int i, SecureRandom secureRandom) {
        int i2;
        int i3;
        this.numRows = i;
        this.numColumns = i;
        int i4 = (i + 31) >>> 5;
        this.length = i4;
        int[] iArr = new int[2];
        iArr[1] = i4;
        iArr[0] = i;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i5 = i & 31;
        if (i5 == 0) {
            i2 = -1;
        } else {
            i2 = (1 << i5) - 1;
        }
        for (int i6 = 0; i6 < this.numRows; i6++) {
            int i7 = i6 >>> 5;
            int i8 = i6 & 31;
            for (int i9 = 0; i9 < i7; i9++) {
                this.matrix[i6][i9] = 0;
            }
            this.matrix[i6][i7] = (secureRandom.nextInt() | 1) << i8;
            while (true) {
                i7++;
                i3 = this.length;
                if (i7 >= i3) {
                    break;
                }
                this.matrix[i6][i7] = secureRandom.nextInt();
            }
            int[] iArr2 = this.matrix[i6];
            int i10 = i3 - 1;
            iArr2[i10] = iArr2[i10] & i2;
        }
    }

    private void assignUnitMatrix(int i) {
        this.numRows = i;
        this.numColumns = i;
        int i2 = (i + 31) >>> 5;
        this.length = i2;
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i3 = 0; i3 < this.numRows; i3++) {
            for (int i4 = 0; i4 < this.length; i4++) {
                this.matrix[i3][i4] = 0;
            }
        }
        for (int i5 = 0; i5 < this.numRows; i5++) {
            this.matrix[i5][i5 >>> 5] = 1 << (i5 & 31);
        }
    }

    private void assignZeroMatrix(int i, int i2) {
        this.numRows = i;
        this.numColumns = i2;
        int i3 = (i2 + 31) >>> 5;
        this.length = i3;
        int[] iArr = new int[2];
        iArr[1] = i3;
        iArr[0] = i;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i4 = 0; i4 < this.numRows; i4++) {
            for (int i5 = 0; i5 < this.length; i5++) {
                this.matrix[i4][i5] = 0;
            }
        }
    }

    public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int i, SecureRandom secureRandom) {
        int i2 = i;
        SecureRandom secureRandom2 = secureRandom;
        int i3 = (i2 + 31) >> 5;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom2);
        GF2Matrix gF2Matrix2 = new GF2Matrix(i2, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom2);
        GF2Matrix gF2Matrix3 = (GF2Matrix) gF2Matrix.rightMultiply((Matrix) gF2Matrix2);
        Permutation permutation = new Permutation(i2, secureRandom2);
        int[] vector = permutation.getVector();
        int[] iArr = new int[2];
        iArr[1] = i3;
        int i4 = 0;
        iArr[0] = i2;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i5 = 0; i5 < i2; i5++) {
            System.arraycopy(gF2Matrix3.matrix[vector[i5]], 0, iArr2[i5], 0, i3);
        }
        GF2Matrix gF2Matrix4 = new GF2Matrix(i2, iArr2);
        GF2Matrix gF2Matrix5 = new GF2Matrix(i2, 'I');
        int i6 = 0;
        while (i6 < i2) {
            int i7 = i6 >>> 5;
            int i8 = 1 << (i6 & 31);
            int i9 = i6 + 1;
            int i10 = i9;
            while (i10 < i2) {
                if ((gF2Matrix.matrix[i10][i7] & i8) != 0) {
                    for (int i11 = i4; i11 <= i7; i11++) {
                        int[][] iArr3 = gF2Matrix5.matrix;
                        int[] iArr4 = iArr3[i10];
                        iArr4[i11] = iArr4[i11] ^ iArr3[i6][i11];
                    }
                }
                i10++;
                i4 = 0;
            }
            i6 = i9;
        }
        GF2Matrix gF2Matrix6 = new GF2Matrix(i2, 'I');
        for (int i12 = i2 - 1; i12 >= 0; i12--) {
            int i13 = i12 >>> 5;
            int i14 = 1 << (i12 & 31);
            for (int i15 = i12 - 1; i15 >= 0; i15--) {
                if ((gF2Matrix2.matrix[i15][i13] & i14) != 0) {
                    for (int i16 = i13; i16 < i3; i16++) {
                        int[][] iArr5 = gF2Matrix6.matrix;
                        int[] iArr6 = iArr5[i15];
                        iArr6[i16] = iArr5[i12][i16] ^ iArr6[i16];
                    }
                }
            }
        }
        return new GF2Matrix[]{gF2Matrix4, (GF2Matrix) gF2Matrix6.rightMultiply(gF2Matrix5.rightMultiply(permutation))};
    }

    private static void swapRows(int[][] iArr, int i, int i2) {
        int[] iArr2 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = iArr2;
    }

    public Matrix computeInverse() {
        int i = this.numRows;
        if (i == this.numColumns) {
            int[] iArr = new int[2];
            iArr[1] = this.length;
            iArr[0] = i;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            for (int i2 = this.numRows - 1; i2 >= 0; i2--) {
                iArr2[i2] = IntUtils.clone(this.matrix[i2]);
            }
            int i3 = this.numRows;
            int[] iArr3 = new int[2];
            iArr3[1] = this.length;
            iArr3[0] = i3;
            int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
            for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
                iArr4[i4][i4 >> 5] = 1 << (i4 & 31);
            }
            for (int i5 = 0; i5 < this.numRows; i5++) {
                int i6 = i5 >> 5;
                int i7 = 1 << (i5 & 31);
                if ((iArr2[i5][i6] & i7) == 0) {
                    int i8 = i5 + 1;
                    boolean z = false;
                    while (i8 < this.numRows) {
                        if ((iArr2[i8][i6] & i7) != 0) {
                            swapRows(iArr2, i5, i8);
                            swapRows(iArr4, i5, i8);
                            i8 = this.numRows;
                            z = true;
                        }
                        i8++;
                    }
                    if (!z) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                for (int i9 = this.numRows - 1; i9 >= 0; i9--) {
                    if (i9 != i5) {
                        int[] iArr5 = iArr2[i9];
                        if ((iArr5[i6] & i7) != 0) {
                            addToRow(iArr2[i5], iArr5, i6);
                            addToRow(iArr4[i5], iArr4[i9], 0);
                        }
                    }
                }
            }
            return new GF2Matrix(this.numColumns, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public Matrix computeTranspose() {
        int i = this.numColumns;
        int[] iArr = new int[2];
        iArr[1] = (this.numRows + 31) >>> 5;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i2 = 0;
        while (true) {
            int i3 = this.numRows;
            if (i2 >= i3) {
                return new GF2Matrix(i3, iArr2);
            }
            for (int i4 = 0; i4 < this.numColumns; i4++) {
                int i5 = i2 >>> 5;
                int i6 = i2 & 31;
                if (((this.matrix[i2][i4 >>> 5] >>> (i4 & 31)) & 1) == 1) {
                    int[] iArr3 = iArr2[i4];
                    iArr3[i5] = (1 << i6) | iArr3[i5];
                }
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.numRows != gF2Matrix.numRows || this.numColumns != gF2Matrix.numColumns || this.length != gF2Matrix.length) {
            return false;
        }
        for (int i = 0; i < this.numRows; i++) {
            if (!IntUtils.equals(this.matrix[i], gF2Matrix.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public GF2Matrix extendLeftCompactForm() {
        int i = this.numColumns;
        int i2 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, i + i2);
        int i3 = this.numRows;
        int i4 = (i3 - 1) + this.numColumns;
        int i5 = i3 - 1;
        while (i5 >= 0) {
            System.arraycopy(this.matrix[i5], 0, gF2Matrix.matrix[i5], 0, this.length);
            int[] iArr = gF2Matrix.matrix[i5];
            int i6 = i4 >> 5;
            iArr[i6] = iArr[i6] | (1 << (i4 & 31));
            i5--;
            i4--;
        }
        return gF2Matrix;
    }

    public GF2Matrix extendRightCompactForm() {
        int i;
        int i2 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, this.numColumns + i2);
        int i3 = this.numRows;
        int i4 = i3 >> 5;
        int i5 = i3 & 31;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            int[] iArr = gF2Matrix.matrix[i6];
            int i7 = i6 >> 5;
            iArr[i7] = iArr[i7] | (1 << (i6 & 31));
            int i8 = 0;
            if (i5 != 0) {
                int i9 = i4;
                while (true) {
                    i = this.length;
                    if (i8 >= i - 1) {
                        break;
                    }
                    int i10 = this.matrix[i6][i8];
                    int[] iArr2 = gF2Matrix.matrix[i6];
                    int i11 = i9 + 1;
                    iArr2[i9] = iArr2[i9] | (i10 << i5);
                    iArr2[i11] = iArr2[i11] | (i10 >>> (32 - i5));
                    i8++;
                    i9 = i11;
                }
                int i12 = this.matrix[i6][i - 1];
                int[] iArr3 = gF2Matrix.matrix[i6];
                int i13 = i9 + 1;
                iArr3[i9] = iArr3[i9] | (i12 << i5);
                if (i13 < gF2Matrix.length) {
                    iArr3[i13] = iArr3[i13] | (i12 >>> (32 - i5));
                }
            } else {
                System.arraycopy(this.matrix[i6], 0, iArr, i4, this.length);
            }
        }
        return gF2Matrix;
    }

    public byte[] getEncoded() {
        int i = this.numRows;
        int i2 = 8;
        byte[] bArr = new byte[((((this.numColumns + 7) >>> 3) * i) + 8)];
        LittleEndianConversions.I2OSP(i, bArr, 0);
        LittleEndianConversions.I2OSP(this.numColumns, bArr, 4);
        int i3 = this.numColumns;
        int i4 = i3 >>> 5;
        int i5 = i3 & 31;
        for (int i6 = 0; i6 < this.numRows; i6++) {
            int i7 = 0;
            while (i7 < i4) {
                LittleEndianConversions.I2OSP(this.matrix[i6][i7], bArr, i2);
                i7++;
                i2 += 4;
            }
            int i8 = 0;
            while (i8 < i5) {
                bArr[i2] = (byte) ((this.matrix[i6][i4] >>> i8) & 255);
                i8 += 8;
                i2++;
            }
        }
        return bArr;
    }

    public double getHammingWeight() {
        int i;
        int i2 = this.numColumns & 31;
        if (i2 == 0) {
            i = this.length;
        } else {
            i = this.length - 1;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i3 = 0; i3 < this.numRows; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.matrix[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    d += (double) ((i5 >>> i6) & 1);
                    d2 += 1.0d;
                }
            }
            int i7 = this.matrix[i3][this.length - 1];
            for (int i8 = 0; i8 < i2; i8++) {
                d += (double) ((i7 >>> i8) & 1);
                d2 += 1.0d;
            }
        }
        return d / d2;
    }

    public int[][] getIntArray() {
        return this.matrix;
    }

    public GF2Matrix getLeftSubMatrix() {
        int i = this.numColumns;
        int i2 = this.numRows;
        if (i > i2) {
            int i3 = (i2 + 31) >> 5;
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = i2;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            int i4 = this.numRows;
            int i5 = (1 << (i4 & 31)) - 1;
            if (i5 == 0) {
                i5 = -1;
            }
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                System.arraycopy(this.matrix[i6], 0, iArr2[i6], 0, i3);
                int[] iArr3 = iArr2[i6];
                int i7 = i3 - 1;
                iArr3[i7] = iArr3[i7] & i5;
            }
            return new GF2Matrix(this.numRows, iArr2);
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int getLength() {
        return this.length;
    }

    public GF2Matrix getRightSubMatrix() {
        int i;
        int i2 = this.numColumns;
        int i3 = this.numRows;
        if (i2 > i3) {
            int i4 = i3 >> 5;
            int i5 = i3 & 31;
            GF2Matrix gF2Matrix = new GF2Matrix(i3, i2 - i3);
            for (int i6 = this.numRows - 1; i6 >= 0; i6--) {
                int i7 = 0;
                if (i5 != 0) {
                    int i8 = i4;
                    while (true) {
                        i = gF2Matrix.length;
                        if (i7 >= i - 1) {
                            break;
                        }
                        int[] iArr = gF2Matrix.matrix[i6];
                        int[] iArr2 = this.matrix[i6];
                        int i9 = i8 + 1;
                        iArr[i7] = (iArr2[i8] >>> i5) | (iArr2[i9] << (32 - i5));
                        i7++;
                        i8 = i9;
                    }
                    int[] iArr3 = gF2Matrix.matrix[i6];
                    int[] iArr4 = this.matrix[i6];
                    int i10 = i8 + 1;
                    iArr3[i - 1] = iArr4[i8] >>> i5;
                    if (i10 < this.length) {
                        int i11 = i - 1;
                        iArr3[i11] = iArr3[i11] | (iArr4[i10] << (32 - i5));
                    }
                } else {
                    System.arraycopy(this.matrix[i6], i4, gF2Matrix.matrix[i6], 0, gF2Matrix.length);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int[] getRow(int i) {
        return this.matrix[i];
    }

    public int hashCode() {
        int i = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            i = (i * 31) + Arrays.hashCode(this.matrix[i2]);
        }
        return i;
    }

    public boolean isZero() {
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.length; i2++) {
                if (this.matrix[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix leftMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length2 = vector.length;
        int i = this.numRows;
        if (length2 == i) {
            int[][] iArr = new int[i][];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                iArr[i2] = IntUtils.clone(this.matrix[vector[i2]]);
            }
            return new GF2Matrix(this.numRows, iArr);
        }
        throw new ArithmeticException("length mismatch");
    }

    public Vector leftMultiplyLeftCompactForm(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i = this.numRows;
            int[] iArr = new int[(((this.numColumns + i) + 31) >>> 5)];
            int i2 = i >>> 5;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = 1;
                do {
                    if ((vecArray[i4] & i5) != 0) {
                        for (int i6 = 0; i6 < this.length; i6++) {
                            iArr[i6] = iArr[i6] ^ this.matrix[i3][i6];
                        }
                        int i7 = this.numColumns;
                        int i8 = (i7 + i3) >>> 5;
                        iArr[i8] = (1 << ((i7 + i3) & 31)) | iArr[i8];
                    }
                    i3++;
                    i5 <<= 1;
                } while (i5 != 0);
            }
            int i9 = 1 << (this.numRows & 31);
            for (int i10 = 1; i10 != i9; i10 <<= 1) {
                if ((vecArray[i2] & i10) != 0) {
                    for (int i11 = 0; i11 < this.length; i11++) {
                        iArr[i11] = iArr[i11] ^ this.matrix[i3][i11];
                    }
                    int i12 = this.numColumns;
                    int i13 = (i12 + i3) >>> 5;
                    iArr[i13] = (1 << ((i12 + i3) & 31)) | iArr[i13];
                }
                i3++;
            }
            return new GF2Vector(iArr, this.numRows + this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Matrix rightMultiply(Matrix matrix2) {
        int i;
        if (!(matrix2 instanceof GF2Matrix)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        } else if (matrix2.numRows == this.numColumns) {
            GF2Matrix gF2Matrix = (GF2Matrix) matrix2;
            GF2Matrix gF2Matrix2 = new GF2Matrix(this.numRows, matrix2.numColumns);
            int i2 = this.numColumns & 31;
            if (i2 == 0) {
                i = this.length;
            } else {
                i = this.length - 1;
            }
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = this.matrix[i3][i5];
                    for (int i7 = 0; i7 < 32; i7++) {
                        if (((1 << i7) & i6) != 0) {
                            for (int i8 = 0; i8 < gF2Matrix.length; i8++) {
                                int[] iArr = gF2Matrix2.matrix[i3];
                                iArr[i8] = iArr[i8] ^ gF2Matrix.matrix[i4][i8];
                            }
                        }
                        i4++;
                    }
                }
                int i9 = this.matrix[i3][this.length - 1];
                for (int i10 = 0; i10 < i2; i10++) {
                    if (((1 << i10) & i9) != 0) {
                        for (int i11 = 0; i11 < gF2Matrix.length; i11++) {
                            int[] iArr2 = gF2Matrix2.matrix[i3];
                            iArr2[i11] = iArr2[i11] ^ gF2Matrix.matrix[i4][i11];
                        }
                    }
                    i4++;
                }
            }
            return gF2Matrix2;
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector rightMultiplyRightCompactForm(Vector vector) {
        int i;
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns + this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i2 = this.numRows;
            int[] iArr = new int[((i2 + 31) >>> 5)];
            int i3 = i2 >> 5;
            int i4 = i2 & 31;
            int i5 = 0;
            while (true) {
                int i6 = this.numRows;
                if (i5 >= i6) {
                    return new GF2Vector(iArr, i6);
                }
                int i7 = i5 >> 5;
                int i8 = i5 & 31;
                int i9 = (vecArray[i7] >>> i8) & 1;
                if (i4 != 0) {
                    int i10 = i3;
                    int i11 = 0;
                    while (true) {
                        i = this.length;
                        if (i11 >= i - 1) {
                            break;
                        }
                        int i12 = i10 + 1;
                        i9 ^= ((vecArray[i10] >>> i4) | (vecArray[i12] << (32 - i4))) & this.matrix[i5][i11];
                        i11++;
                        i10 = i12;
                    }
                    int i13 = i10 + 1;
                    int i14 = vecArray[i10] >>> i4;
                    if (i13 < vecArray.length) {
                        i14 |= vecArray[i13] << (32 - i4);
                    }
                    i9 ^= this.matrix[i5][i - 1] & i14;
                } else {
                    int i15 = i3;
                    int i16 = 0;
                    while (i16 < this.length) {
                        i9 ^= vecArray[i15] & this.matrix[i5][i16];
                        i16++;
                        i15++;
                    }
                }
                int i17 = 0;
                for (int i18 = 0; i18 < 32; i18++) {
                    i17 ^= i9 & 1;
                    i9 >>>= 1;
                }
                if (i17 == 1) {
                    iArr[i7] = iArr[i7] | (1 << i8);
                }
                i5++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public String toString() {
        int i;
        int i2 = this.numColumns & 31;
        if (i2 == 0) {
            i = this.length;
        } else {
            i = this.length - 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.numRows; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.matrix[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.matrix[i3][this.length - 1];
            for (int i8 = 0; i8 < i2; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public Vector leftMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[this.length];
            int i = this.numRows;
            int i2 = i >> 5;
            int i3 = 1 << (i & 31);
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 1;
                do {
                    if ((vecArray[i5] & i6) != 0) {
                        for (int i7 = 0; i7 < this.length; i7++) {
                            iArr[i7] = iArr[i7] ^ this.matrix[i4][i7];
                        }
                    }
                    i4++;
                    i6 <<= 1;
                } while (i6 != 0);
            }
            for (int i8 = 1; i8 != i3; i8 <<= 1) {
                if ((vecArray[i2] & i8) != 0) {
                    for (int i9 = 0; i9 < this.length; i9++) {
                        iArr[i9] = iArr[i9] ^ this.matrix[i4][i9];
                    }
                }
                i4++;
            }
            return new GF2Vector(iArr, this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public GF2Matrix(int i, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length == ((i + 31) >> 5)) {
            this.numColumns = i;
            this.numRows = iArr.length;
            this.length = iArr2.length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.numRows; i4++) {
                int[] iArr3 = iArr[i4];
                int i5 = this.length - 1;
                iArr3[i5] = iArr3[i5] & i3;
            }
            this.matrix = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public Matrix rightMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length2 = vector.length;
        int i = this.numColumns;
        if (length2 == i) {
            GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, i);
            for (int i2 = this.numColumns - 1; i2 >= 0; i2--) {
                int i3 = i2 >>> 5;
                int i4 = i2 & 31;
                int i5 = vector[i2];
                int i6 = i5 >>> 5;
                int i7 = i5 & 31;
                for (int i8 = this.numRows - 1; i8 >= 0; i8--) {
                    int[] iArr = gF2Matrix.matrix[i8];
                    iArr[i3] = iArr[i3] | (((this.matrix[i8][i6] >>> i7) & 1) << i4);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("length mismatch");
    }

    public GF2Matrix(int i, char c) {
        this(i, c, new SecureRandom());
    }

    public GF2Matrix(int i, char c, SecureRandom secureRandom) {
        if (i <= 0) {
            throw new ArithmeticException("Size of matrix is non-positive.");
        } else if (c == 'I') {
            assignUnitMatrix(i);
        } else if (c == 'L') {
            assignRandomLowerTriangularMatrix(i, secureRandom);
        } else if (c == 'R') {
            assignRandomRegularMatrix(i, secureRandom);
        } else if (c == 'U') {
            assignRandomUpperTriangularMatrix(i, secureRandom);
        } else if (c == 'Z') {
            assignZeroMatrix(i, i);
        } else {
            throw new ArithmeticException("Unknown matrix type.");
        }
    }

    public Vector rightMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[((this.numRows + 31) >>> 5)];
            int i = 0;
            while (true) {
                int i2 = this.numRows;
                if (i >= i2) {
                    return new GF2Vector(iArr, i2);
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.length; i4++) {
                    i3 ^= this.matrix[i][i4] & vecArray[i4];
                }
                int i5 = 0;
                for (int i6 = 0; i6 < 32; i6++) {
                    i5 ^= (i3 >>> i6) & 1;
                }
                if (i5 == 1) {
                    int i7 = i >>> 5;
                    iArr[i7] = iArr[i7] | (1 << (i & 31));
                }
                i++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.numColumns = gF2Matrix.getNumColumns();
        this.numRows = gF2Matrix.getNumRows();
        this.length = gF2Matrix.length;
        this.matrix = new int[gF2Matrix.matrix.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.matrix;
            if (i < iArr.length) {
                iArr[i] = IntUtils.clone(gF2Matrix.matrix[i]);
                i++;
            } else {
                return;
            }
        }
    }

    private GF2Matrix(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        assignZeroMatrix(i, i2);
    }
}
