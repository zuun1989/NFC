package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.djb;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat256;

public class Curve25519Point extends ECPoint.AbstractFp {
    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) this.x;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.y;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.zs[0];
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) eCPoint.getXCoord();
        Curve25519FieldElement curve25519FieldElement5 = (Curve25519FieldElement) eCPoint.getYCoord();
        Curve25519FieldElement curve25519FieldElement6 = (Curve25519FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat256.createExt();
        int[] create = Nat256.create();
        int[] create2 = Nat256.create();
        int[] create3 = Nat256.create();
        boolean isOne = curve25519FieldElement3.isOne();
        if (isOne) {
            iArr2 = curve25519FieldElement4.x;
            iArr = curve25519FieldElement5.x;
        } else {
            Curve25519Field.square(curve25519FieldElement3.x, create2);
            Curve25519Field.multiply(create2, curve25519FieldElement4.x, create);
            Curve25519Field.multiply(create2, curve25519FieldElement3.x, create2);
            Curve25519Field.multiply(create2, curve25519FieldElement5.x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = curve25519FieldElement6.isOne();
        if (isOne2) {
            iArr4 = curve25519FieldElement.x;
            iArr3 = curve25519FieldElement2.x;
        } else {
            Curve25519Field.square(curve25519FieldElement6.x, create3);
            Curve25519Field.multiply(create3, curve25519FieldElement.x, createExt);
            Curve25519Field.multiply(create3, curve25519FieldElement6.x, create3);
            Curve25519Field.multiply(create3, curve25519FieldElement2.x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat256.create();
        Curve25519Field.subtract(iArr4, iArr2, create4);
        Curve25519Field.subtract(iArr3, iArr, create);
        if (!Nat256.isZero(create4)) {
            int[] create5 = Nat256.create();
            Curve25519Field.square(create4, create5);
            int[] create6 = Nat256.create();
            Curve25519Field.multiply(create5, create4, create6);
            Curve25519Field.multiply(create5, iArr4, create2);
            Curve25519Field.negate(create6, create6);
            Nat256.mul(iArr3, create6, createExt);
            Curve25519Field.reduce27(Nat256.addBothTo(create2, create2, create6), create6);
            Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(create3);
            Curve25519Field.square(create, curve25519FieldElement7.x);
            int[] iArr5 = curve25519FieldElement7.x;
            Curve25519Field.subtract(iArr5, create6, iArr5);
            Curve25519FieldElement curve25519FieldElement8 = new Curve25519FieldElement(create6);
            Curve25519Field.subtract(create2, curve25519FieldElement7.x, curve25519FieldElement8.x);
            Curve25519Field.multiplyAddToExt(curve25519FieldElement8.x, create, createExt);
            Curve25519Field.reduce(createExt, curve25519FieldElement8.x);
            Curve25519FieldElement curve25519FieldElement9 = new Curve25519FieldElement(create4);
            if (!isOne) {
                int[] iArr6 = curve25519FieldElement9.x;
                Curve25519Field.multiply(iArr6, curve25519FieldElement3.x, iArr6);
            }
            if (!isOne2) {
                int[] iArr7 = curve25519FieldElement9.x;
                Curve25519Field.multiply(iArr7, curve25519FieldElement6.x, iArr7);
            }
            if (!isOne || !isOne2) {
                create5 = null;
            }
            return new Curve25519Point(curve, curve25519FieldElement7, curve25519FieldElement8, new ECFieldElement[]{curve25519FieldElement9, calculateJacobianModifiedW(curve25519FieldElement9, create5)});
        } else if (Nat256.isZero(create)) {
            return twice();
        } else {
            return curve.getInfinity();
        }
    }

    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement curve25519FieldElement, int[] iArr) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) getCurve().getA();
        if (curve25519FieldElement.isOne()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        if (iArr == null) {
            iArr = curve25519FieldElement3.x;
            Curve25519Field.square(curve25519FieldElement.x, iArr);
        }
        Curve25519Field.square(iArr, curve25519FieldElement3.x);
        int[] iArr2 = curve25519FieldElement3.x;
        Curve25519Field.multiply(iArr2, curve25519FieldElement2.x, iArr2);
        return curve25519FieldElement3;
    }

    public ECPoint detach() {
        return new Curve25519Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public Curve25519FieldElement getJacobianModifiedW() {
        ECFieldElement[] eCFieldElementArr = this.zs;
        Curve25519FieldElement curve25519FieldElement = (Curve25519FieldElement) eCFieldElementArr[1];
        if (curve25519FieldElement != null) {
            return curve25519FieldElement;
        }
        Curve25519FieldElement calculateJacobianModifiedW = calculateJacobianModifiedW((Curve25519FieldElement) eCFieldElementArr[0], (int[]) null);
        eCFieldElementArr[1] = calculateJacobianModifiedW;
        return calculateJacobianModifiedW;
    }

    public ECFieldElement getZCoord(int i) {
        if (i == 1) {
            return getJacobianModifiedW();
        }
        return super.getZCoord(i);
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new Curve25519Point(getCurve(), this.x, this.y.negate(), this.zs);
    }

    public ECPoint threeTimes() {
        if (!isInfinity() && !this.y.isZero()) {
            return twiceJacobianModified(false).add(this);
        }
        return this;
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        if (this.y.isZero()) {
            return curve.getInfinity();
        }
        return twiceJacobianModified(true);
    }

    public Curve25519Point twiceJacobianModified(boolean z) {
        Curve25519FieldElement curve25519FieldElement;
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.x;
        Curve25519FieldElement curve25519FieldElement3 = (Curve25519FieldElement) this.y;
        Curve25519FieldElement curve25519FieldElement4 = (Curve25519FieldElement) this.zs[0];
        Curve25519FieldElement jacobianModifiedW = getJacobianModifiedW();
        int[] create = Nat256.create();
        Curve25519Field.square(curve25519FieldElement2.x, create);
        Curve25519Field.reduce27(Nat256.addBothTo(create, create, create) + Nat256.addTo(jacobianModifiedW.x, create), create);
        int[] create2 = Nat256.create();
        Curve25519Field.twice(curve25519FieldElement3.x, create2);
        int[] create3 = Nat256.create();
        Curve25519Field.multiply(create2, curve25519FieldElement3.x, create3);
        int[] create4 = Nat256.create();
        Curve25519Field.multiply(create3, curve25519FieldElement2.x, create4);
        Curve25519Field.twice(create4, create4);
        int[] create5 = Nat256.create();
        Curve25519Field.square(create3, create5);
        Curve25519Field.twice(create5, create5);
        Curve25519FieldElement curve25519FieldElement5 = new Curve25519FieldElement(create3);
        Curve25519Field.square(create, curve25519FieldElement5.x);
        int[] iArr = curve25519FieldElement5.x;
        Curve25519Field.subtract(iArr, create4, iArr);
        int[] iArr2 = curve25519FieldElement5.x;
        Curve25519Field.subtract(iArr2, create4, iArr2);
        Curve25519FieldElement curve25519FieldElement6 = new Curve25519FieldElement(create4);
        Curve25519Field.subtract(create4, curve25519FieldElement5.x, curve25519FieldElement6.x);
        int[] iArr3 = curve25519FieldElement6.x;
        Curve25519Field.multiply(iArr3, create, iArr3);
        int[] iArr4 = curve25519FieldElement6.x;
        Curve25519Field.subtract(iArr4, create5, iArr4);
        Curve25519FieldElement curve25519FieldElement7 = new Curve25519FieldElement(create2);
        if (!Nat256.isOne(curve25519FieldElement4.x)) {
            int[] iArr5 = curve25519FieldElement7.x;
            Curve25519Field.multiply(iArr5, curve25519FieldElement4.x, iArr5);
        }
        if (z) {
            curve25519FieldElement = new Curve25519FieldElement(create5);
            int[] iArr6 = curve25519FieldElement.x;
            Curve25519Field.multiply(iArr6, jacobianModifiedW.x, iArr6);
            int[] iArr7 = curve25519FieldElement.x;
            Curve25519Field.twice(iArr7, iArr7);
        } else {
            curve25519FieldElement = null;
        }
        return new Curve25519Point(getCurve(), curve25519FieldElement5, curve25519FieldElement6, new ECFieldElement[]{curve25519FieldElement7, curve25519FieldElement});
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
        return twiceJacobianModified(false).add(eCPoint);
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
