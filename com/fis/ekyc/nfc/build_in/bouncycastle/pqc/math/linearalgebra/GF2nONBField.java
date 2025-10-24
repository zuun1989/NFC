package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nONBField extends GF2nField {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    int[][] mMult;
    private int mType;

    public GF2nONBField(int i, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        if (i >= 3) {
            this.mDegree = i;
            int i2 = i / 64;
            this.mLength = i2;
            int i3 = i & 63;
            this.mBit = i3;
            if (i3 == 0) {
                this.mBit = 64;
            } else {
                this.mLength = i2 + 1;
            }
            computeType();
            if (this.mType < 3) {
                int i4 = this.mDegree;
                int[] iArr = new int[2];
                iArr[1] = 2;
                iArr[0] = i4;
                this.mMult = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                for (int i5 = 0; i5 < this.mDegree; i5++) {
                    int[] iArr2 = this.mMult[i5];
                    iArr2[0] = -1;
                    iArr2[1] = -1;
                }
                computeMultMatrix();
                computeFieldPolynomial();
                this.fields = new Vector();
                this.matrices = new Vector();
                return;
            }
            throw new RuntimeException("\nThe type of this field is " + this.mType);
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeMultMatrix() {
        int i;
        int i2;
        int i3 = this.mType;
        if ((i3 & 7) != 0) {
            int i4 = this.mDegree * i3;
            int i5 = i4 + 1;
            int[] iArr = new int[i5];
            if (i3 == 1) {
                i = 1;
            } else if (i3 == 2) {
                i = i4;
            } else {
                i = elementOfOrder(i3, i5);
            }
            int i6 = 1;
            int i7 = 0;
            while (true) {
                i2 = this.mType;
                if (i7 >= i2) {
                    break;
                }
                int i8 = i6;
                for (int i9 = 0; i9 < this.mDegree; i9++) {
                    iArr[i8] = i9;
                    i8 = (i8 << 1) % i5;
                    if (i8 < 0) {
                        i8 += i5;
                    }
                }
                i6 = (i6 * i) % i5;
                if (i6 < 0) {
                    i6 += i5;
                }
                i7++;
            }
            if (i2 == 1) {
                int i10 = 1;
                while (i10 < i4) {
                    int i11 = i10 + 1;
                    int[] iArr2 = this.mMult[iArr[i11]];
                    if (iArr2[0] == -1) {
                        iArr2[0] = iArr[i5 - i10];
                    } else {
                        iArr2[1] = iArr[i5 - i10];
                    }
                    i10 = i11;
                }
                int i12 = this.mDegree >> 1;
                for (int i13 = 1; i13 <= i12; i13++) {
                    int[][] iArr3 = this.mMult;
                    int i14 = i13 - 1;
                    int[] iArr4 = iArr3[i14];
                    if (iArr4[0] == -1) {
                        iArr4[0] = (i12 + i13) - 1;
                    } else {
                        iArr4[1] = (i12 + i13) - 1;
                    }
                    int[] iArr5 = iArr3[(i12 + i13) - 1];
                    if (iArr5[0] == -1) {
                        iArr5[0] = i14;
                    } else {
                        iArr5[1] = i14;
                    }
                }
            } else if (i2 == 2) {
                int i15 = 1;
                while (i15 < i4) {
                    int i16 = i15 + 1;
                    int[] iArr6 = this.mMult[iArr[i16]];
                    if (iArr6[0] == -1) {
                        iArr6[0] = iArr[i5 - i15];
                    } else {
                        iArr6[1] = iArr[i5 - i15];
                    }
                    i15 = i16;
                }
            } else {
                throw new RuntimeException("only type 1 or type 2 implemented");
            }
        } else {
            throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
        }
    }

    private void computeType() throws RuntimeException {
        if ((this.mDegree & 7) != 0) {
            this.mType = 1;
            int i = 0;
            while (i != 1) {
                int i2 = (this.mType * this.mDegree) + 1;
                if (IntegerFunctions.isPrime(i2)) {
                    int order = IntegerFunctions.order(2, i2);
                    int i3 = this.mType;
                    int i4 = this.mDegree;
                    i = IntegerFunctions.gcd((i3 * i4) / order, i4);
                }
                this.mType++;
            }
            int i5 = this.mType - 1;
            this.mType = i5;
            if (i5 == 1) {
                int i6 = (this.mDegree << 1) + 1;
                if (IntegerFunctions.isPrime(i6)) {
                    int order2 = IntegerFunctions.order(2, i6);
                    int i7 = this.mDegree;
                    if (IntegerFunctions.gcd((i7 << 1) / order2, i7) == 1) {
                        this.mType++;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("The extension degree is divisible by 8!");
    }

    private int elementOfOrder(int i, int i2) {
        Random random = new Random();
        int i3 = 0;
        while (i3 == 0) {
            int i4 = i2 - 1;
            i3 = random.nextInt() % i4;
            if (i3 < 0) {
                i3 += i4;
            }
        }
        int order = IntegerFunctions.order(i3, i2);
        while (true) {
            if (order % i == 0 && order != 0) {
                break;
            }
            while (i3 == 0) {
                int i5 = i2 - 1;
                int nextInt = random.nextInt() % i5;
                if (nextInt < 0) {
                    nextInt += i5;
                }
            }
            order = IntegerFunctions.order(i3, i2);
        }
        int i6 = i3;
        for (int i7 = 2; i7 <= i / order; i7++) {
            i6 *= i3;
        }
        return i6;
    }

    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        int i = this.mDegree;
        if (i == gF2nField.mDegree) {
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i];
            for (int i2 = 0; i2 < this.mDegree; i2++) {
                gF2PolynomialArr[i2] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            GF2nElement[] gF2nElementArr = new GF2nPolynomialElement[this.mDegree];
            gF2nElementArr[0] = (GF2nElement) randomRoot.clone();
            for (int i3 = 1; i3 < this.mDegree; i3++) {
                gF2nElementArr[i3] = gF2nElementArr[i3 - 1].square();
            }
            for (int i4 = 0; i4 < this.mDegree; i4++) {
                for (int i5 = 0; i5 < this.mDegree; i5++) {
                    if (gF2nElementArr[i4].testBit(i5)) {
                        int i6 = this.mDegree;
                        gF2PolynomialArr[(i6 - i5) - 1].setBit((i6 - i4) - 1);
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    public void computeFieldPolynomial() {
        int i = this.mType;
        if (i == 1) {
            this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1, "ALL");
        } else if (i == 2) {
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1, "ONE");
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 1, "X");
            gF2Polynomial2.addToThis(gF2Polynomial);
            GF2Polynomial gF2Polynomial3 = gF2Polynomial;
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            int i2 = 1;
            while (i2 < this.mDegree) {
                GF2Polynomial shiftLeft = gF2Polynomial4.shiftLeft();
                shiftLeft.addToThis(gF2Polynomial3);
                i2++;
                gF2Polynomial3 = gF2Polynomial4;
                gF2Polynomial4 = shiftLeft;
            }
            this.fieldPolynomial = gF2Polynomial4;
        }
    }

    public int getONBBit() {
        return this.mBit;
    }

    public int getONBLength() {
        return this.mLength;
    }

    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        int degree3 = gF2nPolynomial.getDegree();
        while (degree3 > 1) {
            while (true) {
                GF2nONBElement gF2nONBElement = new GF2nONBElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nONBElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nONBElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i = 1; i <= this.mDegree - 1; i++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (degree != 0 && degree != degree2) {
                    break;
                }
            }
            if ((degree << 1) > degree2) {
                gF2nPolynomial = gF2nPolynomial.quotient(gcd);
            } else {
                gF2nPolynomial = new GF2nPolynomial(gcd);
            }
            degree3 = gF2nPolynomial.getDegree();
        }
        return gF2nPolynomial.at(0);
    }

    public int[][] invMatrix(int[][] iArr) {
        int i = this.mDegree;
        int[] iArr2 = new int[2];
        iArr2[1] = i;
        iArr2[0] = i;
        Class cls = Integer.TYPE;
        int[][] iArr3 = (int[][]) Array.newInstance(cls, iArr2);
        int i2 = this.mDegree;
        int[] iArr4 = new int[2];
        iArr4[1] = i2;
        iArr4[0] = i2;
        int[][] iArr5 = (int[][]) Array.newInstance(cls, iArr4);
        for (int i3 = 0; i3 < this.mDegree; i3++) {
            iArr5[i3][i3] = 1;
        }
        for (int i4 = 0; i4 < this.mDegree; i4++) {
            int i5 = i4;
            while (true) {
                int i6 = this.mDegree;
                if (i5 >= i6) {
                    break;
                }
                iArr[(i6 - 1) - i4][i5] = iArr[i4][i4];
                i5++;
            }
        }
        return null;
    }
}
