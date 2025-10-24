package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nPolynomialField extends GF2nField {
    private boolean isPentanomial = false;
    private boolean isTrinomial = false;
    private int[] pc = new int[3];
    GF2Polynomial[] squaringMatrix;
    private int tc;

    public GF2nPolynomialField(int i, SecureRandom secureRandom) {
        super(secureRandom);
        if (i >= 3) {
            this.mDegree = i;
            computeFieldPolynomial();
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeSquaringMatrix() {
        int i = this.mDegree;
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[(i - 1)];
        this.squaringMatrix = new GF2Polynomial[i];
        int i2 = 0;
        while (true) {
            GF2Polynomial[] gF2PolynomialArr2 = this.squaringMatrix;
            if (i2 >= gF2PolynomialArr2.length) {
                break;
            }
            gF2PolynomialArr2[i2] = new GF2Polynomial(this.mDegree, "ZERO");
            i2++;
        }
        for (int i3 = 0; i3 < this.mDegree - 1; i3++) {
            gF2PolynomialArr[i3] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + i3).remainder(this.fieldPolynomial);
        }
        for (int i4 = 1; i4 <= Math.abs(this.mDegree >> 1); i4++) {
            int i5 = 1;
            while (true) {
                int i6 = this.mDegree;
                if (i5 > i6) {
                    break;
                }
                if (gF2PolynomialArr[i6 - (i4 << 1)].testBit(i6 - i5)) {
                    this.squaringMatrix[i5 - 1].setBit(this.mDegree - i4);
                }
                i5++;
            }
        }
        int abs = Math.abs(this.mDegree >> 1) + 1;
        while (true) {
            int i7 = this.mDegree;
            if (abs <= i7) {
                this.squaringMatrix[((abs << 1) - i7) - 1].setBit(i7 - abs);
                abs++;
            } else {
                return;
            }
        }
    }

    private boolean testPentanomials() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z5;
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        boolean z6 = false;
        int i = 1;
        while (i <= this.mDegree - 3 && !z6) {
            this.fieldPolynomial.setBit(i);
            int i2 = i + 1;
            int i3 = i2;
            while (i3 <= this.mDegree - 2 && !z6) {
                this.fieldPolynomial.setBit(i3);
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 <= this.mDegree - 1 && !z6) {
                    this.fieldPolynomial.setBit(i5);
                    if ((this.mDegree & 1) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((i & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z7 = z | z2;
                    if ((i3 & 1) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    boolean z8 = z7 | z3;
                    if ((i5 & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if ((!z8 && !z5) || !(z6 = this.fieldPolynomial.isIrreducible())) {
                        this.fieldPolynomial.resetBit(i5);
                        i5++;
                    } else {
                        this.isPentanomial = true;
                        int[] iArr = this.pc;
                        iArr[0] = i;
                        iArr[1] = i3;
                        iArr[2] = i5;
                        return z6;
                    }
                }
                this.fieldPolynomial.resetBit(i3);
                i3 = i4;
            }
            this.fieldPolynomial.resetBit(i);
            i = i2;
        }
        return z6;
    }

    private boolean testRandom() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
        do {
            this.fieldPolynomial.randomize();
            this.fieldPolynomial.setBit(this.mDegree);
            this.fieldPolynomial.setBit(0);
        } while (!this.fieldPolynomial.isIrreducible());
        return true;
    }

    private boolean testTrinomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        boolean z = false;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        for (int i = 1; i < this.mDegree && !z; i++) {
            this.fieldPolynomial.setBit(i);
            boolean isIrreducible = this.fieldPolynomial.isIrreducible();
            if (isIrreducible) {
                this.isTrinomial = true;
                this.tc = i;
                return isIrreducible;
            }
            this.fieldPolynomial.resetBit(i);
            z = this.fieldPolynomial.isIrreducible();
        }
        return z;
    }

    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        GF2nElement[] gF2nElementArr;
        int i = this.mDegree;
        if (i == gF2nField.mDegree) {
            boolean z = gF2nField instanceof GF2nONBField;
            if (z) {
                gF2nField.computeCOBMatrix(this);
                return;
            }
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i];
            for (int i2 = 0; i2 < this.mDegree; i2++) {
                gF2PolynomialArr[i2] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            if (randomRoot instanceof GF2nONBElement) {
                int i3 = this.mDegree;
                gF2nElementArr = new GF2nONBElement[i3];
                gF2nElementArr[i3 - 1] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
            } else {
                int i4 = this.mDegree;
                gF2nElementArr = new GF2nPolynomialElement[i4];
                gF2nElementArr[i4 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
            }
            int i5 = this.mDegree;
            gF2nElementArr[i5 - 2] = randomRoot;
            for (int i6 = i5 - 3; i6 >= 0; i6--) {
                gF2nElementArr[i6] = (GF2nElement) gF2nElementArr[i6 + 1].multiply(randomRoot);
            }
            if (z) {
                for (int i7 = 0; i7 < this.mDegree; i7++) {
                    int i8 = 0;
                    while (true) {
                        int i9 = this.mDegree;
                        if (i8 >= i9) {
                            break;
                        }
                        if (gF2nElementArr[i7].testBit((i9 - i8) - 1)) {
                            int i10 = this.mDegree;
                            gF2PolynomialArr[(i10 - i8) - 1].setBit((i10 - i7) - 1);
                        }
                        i8++;
                    }
                }
            } else {
                for (int i11 = 0; i11 < this.mDegree; i11++) {
                    for (int i12 = 0; i12 < this.mDegree; i12++) {
                        if (gF2nElementArr[i11].testBit(i12)) {
                            int i13 = this.mDegree;
                            gF2PolynomialArr[(i13 - i12) - 1].setBit((i13 - i11) - 1);
                        }
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    public void computeFieldPolynomial() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    public void computeFieldPolynomial2() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    public int[] getPc() throws RuntimeException {
        if (this.isPentanomial) {
            int[] iArr = new int[3];
            System.arraycopy(this.pc, 0, iArr, 0, 3);
            return iArr;
        }
        throw new RuntimeException();
    }

    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        int degree3 = gF2nPolynomial.getDegree();
        while (degree3 > 1) {
            while (true) {
                GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this, (Random) this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nPolynomialElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nPolynomialElement);
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

    public GF2Polynomial getSquaringVector(int i) {
        return new GF2Polynomial(this.squaringMatrix[i]);
    }

    public int getTc() throws RuntimeException {
        if (this.isTrinomial) {
            return this.tc;
        }
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.isPentanomial;
    }

    public boolean isTrinomial() {
        return this.isTrinomial;
    }

    public GF2nPolynomialField(int i, SecureRandom secureRandom, boolean z) {
        super(secureRandom);
        if (i >= 3) {
            this.mDegree = i;
            if (z) {
                computeFieldPolynomial();
            } else {
                computeFieldPolynomial2();
            }
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int i, SecureRandom secureRandom, GF2Polynomial gF2Polynomial) throws RuntimeException {
        super(secureRandom);
        if (i < 3) {
            throw new IllegalArgumentException("degree must be at least 3");
        } else if (gF2Polynomial.getLength() != i + 1) {
            throw new RuntimeException();
        } else if (gF2Polynomial.isIrreducible()) {
            this.mDegree = i;
            this.fieldPolynomial = gF2Polynomial;
            computeSquaringMatrix();
            int i2 = 2;
            for (int i3 = 1; i3 < this.fieldPolynomial.getLength() - 1; i3++) {
                if (this.fieldPolynomial.testBit(i3)) {
                    int i4 = i2 + 1;
                    if (i4 == 3) {
                        this.tc = i3;
                    }
                    if (i4 <= 5) {
                        this.pc[i2 - 2] = i3;
                    }
                    i2 = i4;
                }
            }
            if (i2 == 3) {
                this.isTrinomial = true;
            }
            if (i2 == 5) {
                this.isPentanomial = true;
            }
            this.fields = new Vector();
            this.matrices = new Vector();
        } else {
            throw new RuntimeException();
        }
    }
}
