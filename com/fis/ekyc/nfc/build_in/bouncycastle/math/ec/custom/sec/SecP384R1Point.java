package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat;

public class SecP384R1Point extends ECPoint.AbstractFp {
    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint add(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            boolean r3 = r16.isInfinity()
            if (r3 == 0) goto L_0x000c
            return r1
        L_0x000c:
            boolean r3 = r17.isInfinity()
            if (r3 == 0) goto L_0x0013
            return r0
        L_0x0013:
            if (r0 != r1) goto L_0x001a
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x001a:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r3 = r16.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r0.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r0.y
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r17.getXCoord()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r6
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r17.getYCoord()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r7
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r8 = r0.zs
            r8 = r8[r2]
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r8
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement) r1
            r9 = 24
            int[] r10 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r9)
            int[] r9 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r9)
            r11 = 12
            int[] r12 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r11)
            int[] r13 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r11)
            boolean r14 = r8.isOne()
            if (r14 == 0) goto L_0x005d
            int[] r6 = r6.x
            int[] r7 = r7.x
            goto L_0x0073
        L_0x005d:
            int[] r15 = r8.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r15, r12)
            int[] r6 = r6.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r12, r6, r9)
            int[] r6 = r8.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r12, r6, r12)
            int[] r6 = r7.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r12, r6, r12)
            r6 = r9
            r7 = r12
        L_0x0073:
            boolean r15 = r1.isOne()
            if (r15 == 0) goto L_0x007e
            int[] r4 = r4.x
            int[] r5 = r5.x
            goto L_0x0094
        L_0x007e:
            int[] r2 = r1.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r2, r13)
            int[] r2 = r4.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r2, r10)
            int[] r2 = r1.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r2, r13)
            int[] r2 = r5.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r13, r2, r13)
            r4 = r10
            r5 = r13
        L_0x0094:
            int[] r2 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r4, r6, r2)
            int[] r6 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r5, r7, r6)
            boolean r7 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.isZero(r11, r2)
            if (r7 == 0) goto L_0x00b8
            boolean r1 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.isZero(r11, r6)
            if (r1 == 0) goto L_0x00b3
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x00b3:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r3.getInfinity()
            return r1
        L_0x00b8:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r2, r12)
            int[] r7 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.create(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r12, r2, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r12, r4, r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.negate(r7, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat384.mul(r5, r7, r10)
            int r4 = com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat.addBothTo(r11, r12, r12, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.reduce32(r4, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r4.<init>((int[]) r13)
            int[] r5 = r4.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.square(r6, r5)
            int[] r5 = r4.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r5, r7, r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r5.<init>((int[]) r7)
            int[] r7 = r4.x
            int[] r11 = r5.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.subtract(r12, r7, r11)
            int[] r7 = r5.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat384.mul(r7, r6, r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.addExt(r10, r9, r10)
            int[] r6 = r5.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.reduce(r10, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1FieldElement
            r6.<init>((int[]) r2)
            if (r14 != 0) goto L_0x0108
            int[] r2 = r6.x
            int[] r7 = r8.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r2, r7, r2)
        L_0x0108:
            if (r15 != 0) goto L_0x0111
            int[] r2 = r6.x
            int[] r1 = r1.x
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Field.multiply(r2, r1, r2)
        L_0x0111:
            r1 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[r1]
            r2 = 0
            r1[r2] = r6
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Point r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Point
            r2.<init>(r3, r4, r5, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec.SecP384R1Point.add(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint):com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint");
    }

    public ECPoint detach() {
        return new SecP384R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new SecP384R1Point(this.curve, this.x, this.y.negate(), this.zs);
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.y;
        if (secP384R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.x;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.zs[0];
        int[] create = Nat.create(12);
        int[] create2 = Nat.create(12);
        int[] create3 = Nat.create(12);
        SecP384R1Field.square(secP384R1FieldElement.x, create3);
        int[] create4 = Nat.create(12);
        SecP384R1Field.square(create3, create4);
        boolean isOne = secP384R1FieldElement3.isOne();
        int[] iArr = secP384R1FieldElement3.x;
        if (!isOne) {
            SecP384R1Field.square(iArr, create2);
            iArr = create2;
        }
        SecP384R1Field.subtract(secP384R1FieldElement2.x, iArr, create);
        SecP384R1Field.add(secP384R1FieldElement2.x, iArr, create2);
        SecP384R1Field.multiply(create2, create, create2);
        SecP384R1Field.reduce32(Nat.addBothTo(12, create2, create2, create2), create2);
        SecP384R1Field.multiply(create3, secP384R1FieldElement2.x, create3);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create3, 2, 0), create3);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, create4, 3, 0, create), create);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(create4);
        SecP384R1Field.square(create2, secP384R1FieldElement4.x);
        int[] iArr2 = secP384R1FieldElement4.x;
        SecP384R1Field.subtract(iArr2, create3, iArr2);
        int[] iArr3 = secP384R1FieldElement4.x;
        SecP384R1Field.subtract(iArr3, create3, iArr3);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(create3);
        SecP384R1Field.subtract(create3, secP384R1FieldElement4.x, secP384R1FieldElement5.x);
        int[] iArr4 = secP384R1FieldElement5.x;
        SecP384R1Field.multiply(iArr4, create2, iArr4);
        int[] iArr5 = secP384R1FieldElement5.x;
        SecP384R1Field.subtract(iArr5, create, iArr5);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(create2);
        SecP384R1Field.twice(secP384R1FieldElement.x, secP384R1FieldElement6.x);
        if (!isOne) {
            int[] iArr6 = secP384R1FieldElement6.x;
            SecP384R1Field.multiply(iArr6, secP384R1FieldElement3.x, iArr6);
        }
        return new SecP384R1Point(curve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6});
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

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
