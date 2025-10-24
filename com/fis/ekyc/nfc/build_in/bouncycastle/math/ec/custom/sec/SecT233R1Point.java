package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;

public class SecT233R1Point extends ECPoint.AbstractF2m {
    public SecT233R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
    }

    public ECPoint add(ECPoint eCPoint) {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        ECFieldElement eCFieldElement4;
        ECFieldElement eCFieldElement5;
        ECFieldElement eCFieldElement6;
        ECFieldElement eCFieldElement7;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement8 = this.x;
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        if (!eCFieldElement8.isZero()) {
            ECFieldElement eCFieldElement9 = this.y;
            ECFieldElement eCFieldElement10 = this.zs[0];
            ECFieldElement rawYCoord = eCPoint.getRawYCoord();
            ECFieldElement zCoord = eCPoint.getZCoord(0);
            boolean isOne = eCFieldElement10.isOne();
            if (!isOne) {
                eCFieldElement2 = rawXCoord.multiply(eCFieldElement10);
                eCFieldElement = rawYCoord.multiply(eCFieldElement10);
            } else {
                eCFieldElement2 = rawXCoord;
                eCFieldElement = rawYCoord;
            }
            boolean isOne2 = zCoord.isOne();
            if (!isOne2) {
                eCFieldElement8 = eCFieldElement8.multiply(zCoord);
                eCFieldElement3 = eCFieldElement9.multiply(zCoord);
            } else {
                eCFieldElement3 = eCFieldElement9;
            }
            ECFieldElement add = eCFieldElement3.add(eCFieldElement);
            ECFieldElement add2 = eCFieldElement8.add(eCFieldElement2);
            if (!add2.isZero()) {
                if (rawXCoord.isZero()) {
                    ECPoint normalize = normalize();
                    ECFieldElement xCoord = normalize.getXCoord();
                    ECFieldElement yCoord = normalize.getYCoord();
                    ECFieldElement divide = yCoord.add(rawYCoord).divide(xCoord);
                    eCFieldElement5 = divide.square().add(divide).add(xCoord).addOne();
                    if (eCFieldElement5.isZero()) {
                        return new SecT233R1Point(curve, eCFieldElement5, curve.getB().sqrt());
                    }
                    eCFieldElement4 = divide.multiply(xCoord.add(eCFieldElement5)).add(eCFieldElement5).add(yCoord).divide(eCFieldElement5).add(eCFieldElement5);
                    eCFieldElement6 = curve.fromBigInteger(ECConstants.ONE);
                } else {
                    ECFieldElement square = add2.square();
                    ECFieldElement multiply = add.multiply(eCFieldElement8);
                    ECFieldElement multiply2 = add.multiply(eCFieldElement2);
                    ECFieldElement multiply3 = multiply.multiply(multiply2);
                    if (multiply3.isZero()) {
                        return new SecT233R1Point(curve, multiply3, curve.getB().sqrt());
                    }
                    ECFieldElement multiply4 = add.multiply(square);
                    if (!isOne2) {
                        eCFieldElement7 = multiply4.multiply(zCoord);
                    } else {
                        eCFieldElement7 = multiply4;
                    }
                    ECFieldElement squarePlusProduct = multiply2.add(square).squarePlusProduct(eCFieldElement7, eCFieldElement9.add(eCFieldElement10));
                    if (!isOne) {
                        eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement10);
                    }
                    eCFieldElement5 = multiply3;
                    eCFieldElement6 = eCFieldElement7;
                    eCFieldElement4 = squarePlusProduct;
                }
                return new SecT233R1Point(curve, eCFieldElement5, eCFieldElement4, new ECFieldElement[]{eCFieldElement6});
            } else if (add.isZero()) {
                return twice();
            } else {
                return curve.getInfinity();
            }
        } else if (rawXCoord.isZero()) {
            return curve.getInfinity();
        } else {
            return eCPoint.add(this);
        }
    }

    public ECPoint detach() {
        return new SecT233R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public boolean getCompressionYTilde() {
        ECFieldElement rawXCoord = getRawXCoord();
        if (!rawXCoord.isZero() && getRawYCoord().testBitZero() != rawXCoord.testBitZero()) {
            return true;
        }
        return false;
    }

    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.x;
        ECFieldElement eCFieldElement2 = this.y;
        if (isInfinity() || eCFieldElement.isZero()) {
            return eCFieldElement2;
        }
        ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
        ECFieldElement eCFieldElement3 = this.zs[0];
        if (!eCFieldElement3.isOne()) {
            return multiply.divide(eCFieldElement3);
        }
        return multiply;
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        return new SecT233R1Point(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    public ECPoint twice() {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement4 = this.x;
        if (eCFieldElement4.isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement5 = this.y;
        ECFieldElement eCFieldElement6 = this.zs[0];
        boolean isOne = eCFieldElement6.isOne();
        if (isOne) {
            eCFieldElement = eCFieldElement5;
        } else {
            eCFieldElement = eCFieldElement5.multiply(eCFieldElement6);
        }
        if (isOne) {
            eCFieldElement2 = eCFieldElement6;
        } else {
            eCFieldElement2 = eCFieldElement6.square();
        }
        ECFieldElement add = eCFieldElement5.square().add(eCFieldElement).add(eCFieldElement2);
        if (add.isZero()) {
            return new SecT233R1Point(curve, add, curve.getB().sqrt());
        }
        ECFieldElement square = add.square();
        if (isOne) {
            eCFieldElement3 = add;
        } else {
            eCFieldElement3 = add.multiply(eCFieldElement2);
        }
        if (!isOne) {
            eCFieldElement4 = eCFieldElement4.multiply(eCFieldElement6);
        }
        return new SecT233R1Point(curve, square, eCFieldElement4.squarePlusProduct(add, eCFieldElement).add(square).add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        ECFieldElement zCoord = eCPoint.getZCoord(0);
        if (rawXCoord.isZero() || !zCoord.isOne()) {
            return twice().add(eCPoint);
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        ECFieldElement rawYCoord = eCPoint.getRawYCoord();
        ECFieldElement square = eCFieldElement.square();
        ECFieldElement square2 = eCFieldElement2.square();
        ECFieldElement square3 = eCFieldElement3.square();
        ECFieldElement add = square3.add(square2).add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement multiplyPlusProduct = rawYCoord.multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
        ECFieldElement multiply = rawXCoord.multiply(square3);
        ECFieldElement square4 = multiply.add(add).square();
        if (square4.isZero()) {
            if (multiplyPlusProduct.isZero()) {
                return eCPoint.twice();
            }
            return curve.getInfinity();
        } else if (multiplyPlusProduct.isZero()) {
            return new SecT233R1Point(curve, multiplyPlusProduct, curve.getB().sqrt());
        } else {
            ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
            ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
            return new SecT233R1Point(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, rawYCoord.addOne(), multiply3), new ECFieldElement[]{multiply3});
        }
    }

    public SecT233R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
