package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;

public class GF2mMatrix extends Matrix {
    protected GF2mField field;
    protected int[][] matrix;

    public GF2mMatrix(GF2mField gF2mField, byte[] bArr) {
        this.field = gF2mField;
        int i = 8;
        int i2 = 1;
        while (gF2mField.getDegree() > i) {
            i2++;
            i += 8;
        }
        if (bArr.length >= 5) {
            int i3 = ((((bArr[3] & 255) << 24) ^ ((bArr[2] & 255) << 16)) ^ ((bArr[1] & 255) << 8)) ^ (bArr[0] & 255);
            this.numRows = i3;
            int i4 = i2 * i3;
            if (i3 > 0) {
                int i5 = 4;
                if ((bArr.length - 4) % i4 == 0) {
                    int length = (bArr.length - 4) / i4;
                    this.numColumns = length;
                    int[] iArr = new int[2];
                    iArr[1] = length;
                    iArr[0] = i3;
                    this.matrix = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                    for (int i6 = 0; i6 < this.numRows; i6++) {
                        int i7 = 0;
                        while (i7 < this.numColumns) {
                            int i8 = 0;
                            while (i8 < i) {
                                int[] iArr2 = this.matrix[i6];
                                iArr2[i7] = iArr2[i7] ^ ((bArr[i5] & 255) << i8);
                                i8 += 8;
                                i5++;
                            }
                            if (this.field.isElementOfThisField(this.matrix[i6][i7])) {
                                i7++;
                            } else {
                                throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
                            }
                        }
                    }
                    return;
                }
            }
            throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
        }
        throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    }

    private void addToRow(int[] iArr, int[] iArr2) {
        for (int length = iArr2.length - 1; length >= 0; length--) {
            iArr2[length] = this.field.add(iArr[length], iArr2[length]);
        }
    }

    private int[] multRowWithElement(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr2[length] = this.field.mult(iArr[length], i);
        }
        return iArr2;
    }

    private void multRowWithElementThis(int[] iArr, int i) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = this.field.mult(iArr[length], i);
        }
    }

    private static void swapColumns(int[][] iArr, int i, int i2) {
        int[] iArr2 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = iArr2;
    }

    public Matrix computeInverse() {
        int i;
        int i2 = this.numRows;
        if (i2 == this.numColumns) {
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = i2;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            for (int i3 = this.numRows - 1; i3 >= 0; i3--) {
                iArr2[i3] = IntUtils.clone(this.matrix[i3]);
            }
            int i4 = this.numRows;
            int[] iArr3 = new int[2];
            iArr3[1] = i4;
            iArr3[0] = i4;
            int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
            for (int i5 = this.numRows - 1; i5 >= 0; i5--) {
                iArr4[i5][i5] = 1;
            }
            for (int i6 = 0; i6 < this.numRows; i6++) {
                if (iArr2[i6][i6] == 0) {
                    int i7 = i6 + 1;
                    boolean z = false;
                    while (i7 < this.numRows) {
                        if (iArr2[i7][i6] != 0) {
                            swapColumns(iArr2, i6, i7);
                            swapColumns(iArr4, i6, i7);
                            i7 = this.numRows;
                            z = true;
                        }
                        i7++;
                    }
                    if (!z) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                int inverse = this.field.inverse(iArr2[i6][i6]);
                multRowWithElementThis(iArr2[i6], inverse);
                multRowWithElementThis(iArr4[i6], inverse);
                for (int i8 = 0; i8 < this.numRows; i8++) {
                    if (!(i8 == i6 || (i = iArr2[i8][i6]) == 0)) {
                        int[] multRowWithElement = multRowWithElement(iArr2[i6], i);
                        int[] multRowWithElement2 = multRowWithElement(iArr4[i6], i);
                        addToRow(multRowWithElement, iArr2[i8]);
                        addToRow(multRowWithElement2, iArr4[i8]);
                    }
                }
            }
            return new GF2mMatrix(this.field, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public boolean equals(Object obj) {
        int i;
        if (obj != null && (obj instanceof GF2mMatrix)) {
            GF2mMatrix gF2mMatrix = (GF2mMatrix) obj;
            if (this.field.equals(gF2mMatrix.field) && gF2mMatrix.numRows == (i = this.numColumns) && gF2mMatrix.numColumns == i) {
                for (int i2 = 0; i2 < this.numRows; i2++) {
                    for (int i3 = 0; i3 < this.numColumns; i3++) {
                        if (this.matrix[i2][i3] != gF2mMatrix.matrix[i2][i3]) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public byte[] getEncoded() {
        int i = 8;
        int i2 = 1;
        while (this.field.getDegree() > i) {
            i2++;
            i += 8;
        }
        int i3 = this.numRows;
        int i4 = this.numColumns * i3 * i2;
        int i5 = 4;
        byte[] bArr = new byte[(i4 + 4)];
        bArr[0] = (byte) (i3 & 255);
        bArr[1] = (byte) ((i3 >>> 8) & 255);
        bArr[2] = (byte) ((i3 >>> 16) & 255);
        bArr[3] = (byte) ((i3 >>> 24) & 255);
        for (int i6 = 0; i6 < this.numRows; i6++) {
            for (int i7 = 0; i7 < this.numColumns; i7++) {
                int i8 = 0;
                while (i8 < i) {
                    bArr[i5] = (byte) (this.matrix[i6][i7] >>> i8);
                    i8 += 8;
                    i5++;
                }
            }
        }
        return bArr;
    }

    public int hashCode() {
        int hashCode = (((this.field.hashCode() * 31) + this.numRows) * 31) + this.numColumns;
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numColumns; i2++) {
                hashCode = (hashCode * 31) + this.matrix[i][i2];
            }
        }
        return hashCode;
    }

    public boolean isZero() {
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numColumns; i2++) {
                if (this.matrix[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Vector leftMultiply(Vector vector) {
        throw new RuntimeException("Not implemented.");
    }

    public Matrix rightMultiply(Matrix matrix2) {
        throw new RuntimeException("Not implemented.");
    }

    public String toString() {
        String str = this.numRows + " x " + this.numColumns + " Matrix over " + this.field.toString() + ": \n";
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.numColumns; i2++) {
                str = str + this.field.elementToStr(this.matrix[i][i2]) + " : ";
            }
            str = str + "\n";
        }
        return str;
    }

    public Matrix rightMultiply(Permutation permutation) {
        throw new RuntimeException("Not implemented.");
    }

    public Vector rightMultiply(Vector vector) {
        throw new RuntimeException("Not implemented.");
    }

    public GF2mMatrix(GF2mMatrix gF2mMatrix) {
        int i = gF2mMatrix.numRows;
        this.numRows = i;
        this.numColumns = gF2mMatrix.numColumns;
        this.field = gF2mMatrix.field;
        this.matrix = new int[i][];
        for (int i2 = 0; i2 < this.numRows; i2++) {
            this.matrix[i2] = IntUtils.clone(gF2mMatrix.matrix[i2]);
        }
    }

    public GF2mMatrix(GF2mField gF2mField, int[][] iArr) {
        this.field = gF2mField;
        this.matrix = iArr;
        this.numRows = iArr.length;
        this.numColumns = iArr[0].length;
    }
}
