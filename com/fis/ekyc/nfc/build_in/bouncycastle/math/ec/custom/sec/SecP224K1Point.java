package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat224;

public class SecP224K1Point extends ECPoint.AbstractFp {
    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.x;
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.y;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) eCPoint.getXCoord();
        SecP224K1FieldElement secP224K1FieldElement4 = (SecP224K1FieldElement) eCPoint.getYCoord();
        SecP224K1FieldElement secP224K1FieldElement5 = (SecP224K1FieldElement) this.zs[0];
        SecP224K1FieldElement secP224K1FieldElement6 = (SecP224K1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat224.createExt();
        int[] create = Nat224.create();
        int[] create2 = Nat224.create();
        int[] create3 = Nat224.create();
        boolean isOne = secP224K1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP224K1FieldElement3.x;
            iArr = secP224K1FieldElement4.x;
        } else {
            SecP224K1Field.square(secP224K1FieldElement5.x, create2);
            SecP224K1Field.multiply(create2, secP224K1FieldElement3.x, create);
            SecP224K1Field.multiply(create2, secP224K1FieldElement5.x, create2);
            SecP224K1Field.multiply(create2, secP224K1FieldElement4.x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP224K1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP224K1FieldElement.x;
            iArr3 = secP224K1FieldElement2.x;
        } else {
            SecP224K1Field.square(secP224K1FieldElement6.x, create3);
            SecP224K1Field.multiply(create3, secP224K1FieldElement.x, createExt);
            SecP224K1Field.multiply(create3, secP224K1FieldElement6.x, create3);
            SecP224K1Field.multiply(create3, secP224K1FieldElement2.x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat224.create();
        SecP224K1Field.subtract(iArr4, iArr2, create4);
        SecP224K1Field.subtract(iArr3, iArr, create);
        if (!Nat224.isZero(create4)) {
            SecP224K1Field.square(create4, create2);
            int[] create5 = Nat224.create();
            SecP224K1Field.multiply(create2, create4, create5);
            SecP224K1Field.multiply(create2, iArr4, create2);
            SecP224K1Field.negate(create5, create5);
            Nat224.mul(iArr3, create5, createExt);
            SecP224K1Field.reduce32(Nat224.addBothTo(create2, create2, create5), create5);
            SecP224K1FieldElement secP224K1FieldElement7 = new SecP224K1FieldElement(create3);
            SecP224K1Field.square(create, secP224K1FieldElement7.x);
            int[] iArr5 = secP224K1FieldElement7.x;
            SecP224K1Field.subtract(iArr5, create5, iArr5);
            SecP224K1FieldElement secP224K1FieldElement8 = new SecP224K1FieldElement(create5);
            SecP224K1Field.subtract(create2, secP224K1FieldElement7.x, secP224K1FieldElement8.x);
            SecP224K1Field.multiplyAddToExt(secP224K1FieldElement8.x, create, createExt);
            SecP224K1Field.reduce(createExt, secP224K1FieldElement8.x);
            SecP224K1FieldElement secP224K1FieldElement9 = new SecP224K1FieldElement(create4);
            if (!isOne) {
                int[] iArr6 = secP224K1FieldElement9.x;
                SecP224K1Field.multiply(iArr6, secP224K1FieldElement5.x, iArr6);
            }
            if (!isOne2) {
                int[] iArr7 = secP224K1FieldElement9.x;
                SecP224K1Field.multiply(iArr7, secP224K1FieldElement6.x, iArr7);
            }
            return new SecP224K1Point(curve, secP224K1FieldElement7, secP224K1FieldElement8, new ECFieldElement[]{secP224K1FieldElement9});
        } else if (Nat224.isZero(create)) {
            return twice();
        } else {
            return curve.getInfinity();
        }
    }

    public ECPoint detach() {
        return new SecP224K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new SecP224K1Point(this.curve, this.x, this.y.negate(), this.zs);
    }

    public ECPoint threeTimes() {
        if (isInfinity() || this.y.isZero()) {
            return this;
        }
        return twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP224K1FieldElement secP224K1FieldElement = (SecP224K1FieldElement) this.y;
        if (secP224K1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP224K1FieldElement secP224K1FieldElement2 = (SecP224K1FieldElement) this.x;
        SecP224K1FieldElement secP224K1FieldElement3 = (SecP224K1FieldElement) this.zs[0];
        int[] create = Nat224.create();
        SecP224K1Field.square(secP224K1FieldElement.x, create);
        int[] create2 = Nat224.create();
        SecP224K1Field.square(create, create2);
        int[] create3 = Nat224.create();
        SecP224K1Field.square(secP224K1FieldElement2.x, create3);
        SecP224K1Field.reduce32(Nat224.addBothTo(create3, create3, create3), create3);
        SecP224K1Field.multiply(create, secP224K1FieldElement2.x, create);
        SecP224K1Field.reduce32(Nat.shiftUpBits(7, create, 2, 0), create);
        int[] create4 = Nat224.create();
        SecP224K1Field.reduce32(Nat.shiftUpBits(7, create2, 3, 0, create4), create4);
        SecP224K1FieldElement secP224K1FieldElement4 = new SecP224K1FieldElement(create2);
        SecP224K1Field.square(create3, secP224K1FieldElement4.x);
        int[] iArr = secP224K1FieldElement4.x;
        SecP224K1Field.subtract(iArr, create, iArr);
        int[] iArr2 = secP224K1FieldElement4.x;
        SecP224K1Field.subtract(iArr2, create, iArr2);
        SecP224K1FieldElement secP224K1FieldElement5 = new SecP224K1FieldElement(create);
        SecP224K1Field.subtract(create, secP224K1FieldElement4.x, secP224K1FieldElement5.x);
        int[] iArr3 = secP224K1FieldElement5.x;
        SecP224K1Field.multiply(iArr3, create3, iArr3);
        int[] iArr4 = secP224K1FieldElement5.x;
        SecP224K1Field.subtract(iArr4, create4, iArr4);
        SecP224K1FieldElement secP224K1FieldElement6 = new SecP224K1FieldElement(create3);
        SecP224K1Field.twice(secP224K1FieldElement.x, secP224K1FieldElement6.x);
        if (!secP224K1FieldElement3.isOne()) {
            int[] iArr5 = secP224K1FieldElement6.x;
            SecP224K1Field.multiply(iArr5, secP224K1FieldElement3.x, iArr5);
        }
        return new SecP224K1Point(curve, secP224K1FieldElement4, secP224K1FieldElement5, new ECFieldElement[]{secP224K1FieldElement6});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (this == eCPoint) {
            return threeTimes();
        }
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        if (this.y.isZero()) {
            return eCPoint;
        }
        return twice().add(eCPoint);
    }

    public SecP224K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
