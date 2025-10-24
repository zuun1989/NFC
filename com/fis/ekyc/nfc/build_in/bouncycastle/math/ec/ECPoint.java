package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;
import java.util.Hashtable;

public abstract class ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    protected ECCurve curve;
    protected Hashtable preCompTable;
    protected ECFieldElement x;
    protected ECFieldElement y;
    protected ECFieldElement[] zs;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.x;
            ECFieldElement a = curve.getA();
            ECFieldElement b = curve.getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.zs[0];
                boolean isOne = eCFieldElement4.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.y.square();
                    if (!isOne) {
                        b = b.multiply(eCFieldElement4.square());
                    }
                    return square.equals(b);
                }
                ECFieldElement eCFieldElement5 = this.y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement5.square().add(eCFieldElement5).add(a);
                    eCFieldElement = square2.square().add(b);
                } else {
                    ECFieldElement square3 = eCFieldElement4.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement5.add(eCFieldElement4).multiplyPlusProduct(eCFieldElement5, a, square3);
                    eCFieldElement = square2.squarePlusProduct(b, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement6 = this.y;
            ECFieldElement multiply = eCFieldElement6.add(eCFieldElement3).multiply(eCFieldElement6);
            if (coordinateSystem != 0) {
                if (coordinateSystem == 1) {
                    ECFieldElement eCFieldElement7 = this.zs[0];
                    if (!eCFieldElement7.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement7.multiply(eCFieldElement7.square());
                        multiply = multiply.multiply(eCFieldElement7);
                        a = a.multiply(eCFieldElement7);
                        b = b.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return multiply.equals(eCFieldElement3.add(a).multiply(eCFieldElement3.square()).add(b));
        }

        public boolean satisfiesOrder() {
            BigInteger cofactor = this.curve.getCofactor();
            if (ECConstants.TWO.equals(cofactor)) {
                if (((ECFieldElement.AbstractF2m) normalize().getAffineXCoord()).trace() != 0) {
                    return true;
                }
                return false;
            } else if (!ECConstants.FOUR.equals(cofactor)) {
                return ECPoint.super.satisfiesOrder();
            } else {
                ECPoint normalize = normalize();
                ECFieldElement affineXCoord = normalize.getAffineXCoord();
                ECCurve eCCurve = this.curve;
                ECFieldElement solveQuadraticEquation = ((ECCurve.AbstractF2m) eCCurve).solveQuadraticEquation(affineXCoord.add(eCCurve.getA()));
                if (solveQuadraticEquation == null) {
                    return false;
                }
                if (((ECFieldElement.AbstractF2m) affineXCoord.multiply(solveQuadraticEquation).add(normalize.getAffineYCoord())).trace() == 0) {
                    return true;
                }
                return false;
            }
        }

        public ECPoint scaleX(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 5) {
                ECFieldElement rawXCoord = getRawXCoord();
                ECFieldElement rawYCoord = getRawYCoord();
                return getCurve().createRawPoint(rawXCoord, rawYCoord.add(rawXCoord).divide(eCFieldElement).add(rawXCoord.multiply(eCFieldElement)), getRawZCoords());
            } else if (curveCoordinateSystem != 6) {
                return ECPoint.super.scaleX(eCFieldElement);
            } else {
                ECFieldElement rawXCoord2 = getRawXCoord();
                ECFieldElement rawYCoord2 = getRawYCoord();
                ECFieldElement eCFieldElement2 = getRawZCoords()[0];
                ECFieldElement multiply = rawXCoord2.multiply(eCFieldElement.square());
                return getCurve().createRawPoint(multiply, rawYCoord2.add(rawXCoord2).add(multiply), new ECFieldElement[]{eCFieldElement2.multiply(eCFieldElement)});
            }
        }

        public ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
            return scaleX(eCFieldElement);
        }

        public ECPoint scaleY(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return ECPoint.super.scaleY(eCFieldElement);
            }
            ECFieldElement rawXCoord = getRawXCoord();
            return getCurve().createRawPoint(rawXCoord, getRawYCoord().add(rawXCoord).multiply(eCFieldElement).add(rawXCoord), getRawZCoords());
        }

        public ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
            return scaleY(eCFieldElement);
        }

        public ECPoint subtract(ECPoint eCPoint) {
            if (eCPoint.isInfinity()) {
                return this;
            }
            return add(eCPoint.negate());
        }

        public AbstractF2m tau() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                return (AbstractF2m) curve.createRawPoint(eCFieldElement.square(), this.y.square(), new ECFieldElement[]{this.zs[0].square()});
            }
            return (AbstractF2m) curve.createRawPoint(eCFieldElement.square(), this.y.square());
        }

        public AbstractF2m tauPow(int i) {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                return (AbstractF2m) curve.createRawPoint(eCFieldElement.squarePow(i), this.y.squarePow(i), new ECFieldElement[]{this.zs[0].squarePow(i)});
            }
            return (AbstractF2m) curve.createRawPoint(eCFieldElement.squarePow(i), this.y.squarePow(i));
        }

        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            ECFieldElement a = this.curve.getA();
            ECFieldElement b = this.curve.getB();
            ECFieldElement square = eCFieldElement2.square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement3 = this.zs[0];
                    if (!eCFieldElement3.isOne()) {
                        ECFieldElement square2 = eCFieldElement3.square();
                        ECFieldElement multiply = eCFieldElement3.multiply(square2);
                        square = square.multiply(eCFieldElement3);
                        a = a.multiply(square2);
                        b = b.multiply(multiply);
                    }
                } else if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                    ECFieldElement eCFieldElement4 = this.zs[0];
                    if (!eCFieldElement4.isOne()) {
                        ECFieldElement square3 = eCFieldElement4.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        a = a.multiply(square4);
                        b = b.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return square.equals(eCFieldElement.square().add(a).multiply(eCFieldElement).add(b));
        }

        public ECPoint subtract(ECPoint eCPoint) {
            if (eCPoint.isInfinity()) {
                return this;
            }
            return add(eCPoint.negate());
        }

        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
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
            ECFieldElement eCFieldElement8;
            ECFieldElement eCFieldElement9;
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement10 = this.x;
            ECFieldElement eCFieldElement11 = eCPoint.x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement12 = this.y;
                ECFieldElement eCFieldElement13 = eCPoint.y;
                ECFieldElement add = eCFieldElement10.add(eCFieldElement11);
                ECFieldElement add2 = eCFieldElement12.add(eCFieldElement13);
                if (!add.isZero()) {
                    ECFieldElement divide = add2.divide(add);
                    ECFieldElement add3 = divide.square().add(divide).add(add).add(curve.getA());
                    return new F2m(curve, add3, divide.multiply(eCFieldElement10.add(add3)).add(add3).add(eCFieldElement12));
                } else if (add2.isZero()) {
                    return twice();
                } else {
                    return curve.getInfinity();
                }
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement14 = this.y;
                ECFieldElement eCFieldElement15 = this.zs[0];
                ECFieldElement eCFieldElement16 = eCPoint.y;
                ECFieldElement eCFieldElement17 = eCPoint.zs[0];
                boolean isOne = eCFieldElement17.isOne();
                ECFieldElement multiply = eCFieldElement15.multiply(eCFieldElement16);
                if (isOne) {
                    eCFieldElement = eCFieldElement14;
                } else {
                    eCFieldElement = eCFieldElement14.multiply(eCFieldElement17);
                }
                ECFieldElement add4 = multiply.add(eCFieldElement);
                ECFieldElement multiply2 = eCFieldElement15.multiply(eCFieldElement11);
                if (isOne) {
                    eCFieldElement2 = eCFieldElement10;
                } else {
                    eCFieldElement2 = eCFieldElement10.multiply(eCFieldElement17);
                }
                ECFieldElement add5 = multiply2.add(eCFieldElement2);
                if (!add5.isZero()) {
                    ECFieldElement square = add5.square();
                    ECFieldElement multiply3 = square.multiply(add5);
                    if (!isOne) {
                        eCFieldElement15 = eCFieldElement15.multiply(eCFieldElement17);
                    }
                    ECFieldElement add6 = add4.add(add5);
                    ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, curve.getA()).multiply(eCFieldElement15).add(multiply3);
                    ECFieldElement multiply4 = add5.multiply(add7);
                    if (!isOne) {
                        square = square.multiply(eCFieldElement17);
                    }
                    return new F2m(curve, multiply4, add4.multiplyPlusProduct(eCFieldElement10, add5, eCFieldElement14).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply3.multiply(eCFieldElement15)});
                } else if (add4.isZero()) {
                    return twice();
                } else {
                    return curve.getInfinity();
                }
            } else if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (!eCFieldElement10.isZero()) {
                ECFieldElement eCFieldElement18 = this.y;
                ECFieldElement eCFieldElement19 = this.zs[0];
                ECFieldElement eCFieldElement20 = eCPoint.y;
                ECFieldElement eCFieldElement21 = eCPoint.zs[0];
                boolean isOne2 = eCFieldElement19.isOne();
                if (!isOne2) {
                    eCFieldElement4 = eCFieldElement11.multiply(eCFieldElement19);
                    eCFieldElement3 = eCFieldElement20.multiply(eCFieldElement19);
                } else {
                    eCFieldElement4 = eCFieldElement11;
                    eCFieldElement3 = eCFieldElement20;
                }
                boolean isOne3 = eCFieldElement21.isOne();
                if (!isOne3) {
                    eCFieldElement10 = eCFieldElement10.multiply(eCFieldElement21);
                    eCFieldElement5 = eCFieldElement18.multiply(eCFieldElement21);
                } else {
                    eCFieldElement5 = eCFieldElement18;
                }
                ECFieldElement add8 = eCFieldElement5.add(eCFieldElement3);
                ECFieldElement add9 = eCFieldElement10.add(eCFieldElement4);
                if (!add9.isZero()) {
                    if (eCFieldElement11.isZero()) {
                        ECPoint normalize = normalize();
                        ECFieldElement xCoord = normalize.getXCoord();
                        ECFieldElement yCoord = normalize.getYCoord();
                        ECFieldElement divide2 = yCoord.add(eCFieldElement20).divide(xCoord);
                        eCFieldElement7 = divide2.square().add(divide2).add(xCoord).add(curve.getA());
                        if (eCFieldElement7.isZero()) {
                            return new F2m(curve, eCFieldElement7, curve.getB().sqrt());
                        }
                        eCFieldElement6 = divide2.multiply(xCoord.add(eCFieldElement7)).add(eCFieldElement7).add(yCoord).divide(eCFieldElement7).add(eCFieldElement7);
                        eCFieldElement8 = curve.fromBigInteger(ECConstants.ONE);
                    } else {
                        ECFieldElement square2 = add9.square();
                        ECFieldElement multiply5 = add8.multiply(eCFieldElement10);
                        ECFieldElement multiply6 = add8.multiply(eCFieldElement4);
                        ECFieldElement multiply7 = multiply5.multiply(multiply6);
                        if (multiply7.isZero()) {
                            return new F2m(curve, multiply7, curve.getB().sqrt());
                        }
                        ECFieldElement multiply8 = add8.multiply(square2);
                        if (!isOne3) {
                            eCFieldElement9 = multiply8.multiply(eCFieldElement21);
                        } else {
                            eCFieldElement9 = multiply8;
                        }
                        ECFieldElement squarePlusProduct = multiply6.add(square2).squarePlusProduct(eCFieldElement9, eCFieldElement18.add(eCFieldElement19));
                        if (!isOne2) {
                            eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement19);
                        }
                        eCFieldElement7 = multiply7;
                        ECFieldElement eCFieldElement22 = squarePlusProduct;
                        eCFieldElement8 = eCFieldElement9;
                        eCFieldElement6 = eCFieldElement22;
                    }
                    return new F2m(curve, eCFieldElement7, eCFieldElement6, new ECFieldElement[]{eCFieldElement8});
                } else if (add8.isZero()) {
                    return twice();
                } else {
                    return curve.getInfinity();
                }
            } else if (eCFieldElement11.isZero()) {
                return curve.getInfinity();
            } else {
                return eCPoint.add(this);
            }
        }

        public ECPoint detach() {
            return new F2m((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return rawYCoord.divide(rawXCoord).testBitZero();
            }
            if (rawYCoord.testBitZero() != rawXCoord.testBitZero()) {
                return true;
            }
            return false;
        }

        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.y;
            }
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            if (isInfinity() || eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return multiply;
            }
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
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement));
            } else if (curveCoordinateSystem == 1) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement), new ECFieldElement[]{this.zs[0]});
            } else if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.y.addOne());
            } else if (curveCoordinateSystem == 6) {
                ECFieldElement eCFieldElement2 = this.y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement8 = this.x;
            if (eCFieldElement8.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement add = this.y.divide(eCFieldElement8).add(eCFieldElement8);
                ECFieldElement add2 = add.square().add(add).add(curve.getA());
                return new F2m(curve, add2, eCFieldElement8.squarePlusProduct(add2, add.addOne()));
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement9 = this.y;
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne = eCFieldElement10.isOne();
                if (isOne) {
                    eCFieldElement = eCFieldElement8;
                } else {
                    eCFieldElement = eCFieldElement8.multiply(eCFieldElement10);
                }
                if (!isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement10);
                }
                ECFieldElement square = eCFieldElement8.square();
                ECFieldElement add3 = square.add(eCFieldElement9);
                ECFieldElement square2 = eCFieldElement.square();
                ECFieldElement add4 = add3.add(eCFieldElement);
                ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, curve.getA());
                return new F2m(curve, eCFieldElement.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(eCFieldElement, multiplyPlusProduct, add4), new ECFieldElement[]{eCFieldElement.multiply(square2)});
            } else if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement11 = this.y;
                ECFieldElement eCFieldElement12 = this.zs[0];
                boolean isOne2 = eCFieldElement12.isOne();
                if (isOne2) {
                    eCFieldElement2 = eCFieldElement11;
                } else {
                    eCFieldElement2 = eCFieldElement11.multiply(eCFieldElement12);
                }
                if (isOne2) {
                    eCFieldElement3 = eCFieldElement12;
                } else {
                    eCFieldElement3 = eCFieldElement12.square();
                }
                ECFieldElement a = curve.getA();
                if (isOne2) {
                    eCFieldElement4 = a;
                } else {
                    eCFieldElement4 = a.multiply(eCFieldElement3);
                }
                ECFieldElement add5 = eCFieldElement11.square().add(eCFieldElement2).add(eCFieldElement4);
                if (add5.isZero()) {
                    return new F2m(curve, add5, curve.getB().sqrt());
                }
                ECFieldElement square3 = add5.square();
                if (isOne2) {
                    eCFieldElement5 = add5;
                } else {
                    eCFieldElement5 = add5.multiply(eCFieldElement3);
                }
                ECFieldElement b = curve.getB();
                if (b.bitLength() < (curve.getFieldSize() >> 1)) {
                    ECFieldElement square4 = eCFieldElement11.add(eCFieldElement8).square();
                    if (b.isOne()) {
                        eCFieldElement7 = eCFieldElement4.add(eCFieldElement3).square();
                    } else {
                        eCFieldElement7 = eCFieldElement4.squarePlusProduct(b, eCFieldElement3.square());
                    }
                    eCFieldElement6 = square4.add(add5).add(eCFieldElement3).multiply(square4).add(eCFieldElement7).add(square3);
                    if (a.isZero()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement5);
                    } else if (!a.isOne()) {
                        eCFieldElement6 = eCFieldElement6.add(a.addOne().multiply(eCFieldElement5));
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement8 = eCFieldElement8.multiply(eCFieldElement12);
                    }
                    eCFieldElement6 = eCFieldElement8.squarePlusProduct(add5, eCFieldElement2).add(square3).add(eCFieldElement5);
                }
                return new F2m(curve, square3, eCFieldElement6, new ECFieldElement[]{eCFieldElement5});
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
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
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.x;
            ECFieldElement eCFieldElement3 = eCPoint.zs[0];
            if (eCFieldElement2.isZero() || !eCFieldElement3.isOne()) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.y;
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.y;
            ECFieldElement square = eCFieldElement.square();
            ECFieldElement square2 = eCFieldElement4.square();
            ECFieldElement square3 = eCFieldElement5.square();
            ECFieldElement add = curve.getA().multiply(square3).add(square2).add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement addOne = eCFieldElement6.addOne();
            ECFieldElement multiplyPlusProduct = curve.getA().add(addOne).multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
            ECFieldElement multiply = eCFieldElement2.multiply(square3);
            ECFieldElement square4 = multiply.add(add).square();
            if (square4.isZero()) {
                if (multiplyPlusProduct.isZero()) {
                    return eCPoint.twice();
                }
                return curve.getInfinity();
            } else if (multiplyPlusProduct.isZero()) {
                return new F2m(curve, multiplyPlusProduct, curve.getB().sqrt());
            } else {
                ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
                ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
                return new F2m(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, addOne, multiply3), new ECFieldElement[]{multiply3});
            }
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static class Fp extends AbstractFp {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0136  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint add(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.isInfinity()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.isInfinity()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0019:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r2 = r16.getCurve()
                int r3 = r2.getCoordinateSystem()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r0.x
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r0.y
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r1.x
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r1.y
                if (r3 == 0) goto L_0x01d2
                r8 = 1
                r9 = 0
                if (r3 == r8) goto L_0x0142
                r10 = 4
                r11 = 2
                if (r3 == r11) goto L_0x003e
                if (r3 != r10) goto L_0x0036
                goto L_0x003e
            L_0x0036:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003e:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r12 = r0.zs
                r12 = r12[r9]
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r9]
                boolean r13 = r12.isOne()
                if (r13 != 0) goto L_0x00a3
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a3
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r4.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r13 = r1.isZero()
                if (r13 == 0) goto L_0x0070
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x006b
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x006b:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x0070:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r13 = r1.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r13)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r13)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r13 = r4.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r13.multiply(r5)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r13 = r7.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r13 = r13.subtract(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r13.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r7)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r5)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r12)
            L_0x00a0:
                r14 = 0
                goto L_0x0126
            L_0x00a3:
                if (r13 == 0) goto L_0x00a6
                goto L_0x00b6
            L_0x00a6:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r15 = r12.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r15.multiply(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r15 = r15.multiply(r12)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r15.multiply(r7)
            L_0x00b6:
                boolean r15 = r1.isOne()
                if (r15 == 0) goto L_0x00bd
                goto L_0x00cd
            L_0x00bd:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r14 = r1.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r14 = r14.multiply(r1)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r14.multiply(r5)
            L_0x00cd:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r4.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r14 = r6.isZero()
                if (r14 == 0) goto L_0x00eb
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x00e6
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x00e6:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x00eb:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r14 = r6.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r8 = r14.multiply(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r9 = r7.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r9 = r9.add(r8)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r11 = r0.two(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r9 = r9.subtract(r11)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.multiplyMinusProduct(r7, r8, r5)
                if (r13 != 0) goto L_0x0116
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r6.multiply(r12)
                goto L_0x0117
            L_0x0116:
                r5 = r6
            L_0x0117:
                if (r15 != 0) goto L_0x011e
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r5.multiply(r1)
                goto L_0x011f
            L_0x011e:
                r1 = r5
            L_0x011f:
                if (r1 != r6) goto L_0x0123
                r6 = r9
                goto L_0x0126
            L_0x0123:
                r6 = r9
                goto L_0x00a0
            L_0x0126:
                if (r3 != r10) goto L_0x0136
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r0.calculateJacobianModifiedW(r1, r14)
                r5 = 2
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[r5]
                r8 = 0
                r5[r8] = r1
                r7 = 1
                r5[r7] = r3
                goto L_0x013c
            L_0x0136:
                r7 = 1
                r8 = 0
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[r7]
                r5[r8] = r1
            L_0x013c:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp
                r1.<init>(r2, r6, r4, r5)
                return r1
            L_0x0142:
                r8 = r9
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r3 = r0.zs
                r3 = r3[r8]
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r8]
                boolean r8 = r3.isOne()
                boolean r9 = r1.isOne()
                if (r8 == 0) goto L_0x0156
                goto L_0x015a
            L_0x0156:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r7.multiply(r3)
            L_0x015a:
                if (r9 == 0) goto L_0x015d
                goto L_0x0161
            L_0x015d:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r5 = r5.multiply(r1)
            L_0x0161:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r7 = r7.subtract(r5)
                if (r8 == 0) goto L_0x0168
                goto L_0x016c
            L_0x0168:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r3)
            L_0x016c:
                if (r9 == 0) goto L_0x016f
                goto L_0x0173
            L_0x016f:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r1)
            L_0x0173:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r6.subtract(r4)
                boolean r10 = r6.isZero()
                if (r10 == 0) goto L_0x018d
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x0188
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0188:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x018d:
                if (r8 == 0) goto L_0x0191
                r3 = r1
                goto L_0x0198
            L_0x0191:
                if (r9 == 0) goto L_0x0194
                goto L_0x0198
            L_0x0194:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r3.multiply(r1)
            L_0x0198:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r6.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r8 = r1.multiply(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r7.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.multiply(r3)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r8)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r9 = r0.two(r1)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r6 = r6.multiply(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.subtract(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.multiplyMinusProduct(r7, r5, r8)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r8.multiply(r3)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[] r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement[]{r3}
                r4.<init>(r2, r6, r1, r3)
                return r4
            L_0x01d2:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r6.subtract(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r7.subtract(r5)
                boolean r7 = r1.isZero()
                if (r7 == 0) goto L_0x01f0
                boolean r1 = r3.isZero()
                if (r1 == 0) goto L_0x01eb
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x01eb:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r2.getInfinity()
                return r1
            L_0x01f0:
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r3.divide(r1)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r1.square()
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r3.subtract(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r3 = r3.subtract(r6)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r4.subtract(r3)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.subtract(r5)
                com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint$Fp
                r4.<init>(r2, r3, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint.Fp.add(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint):com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint");
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement a = getCurve().getA();
            if (a.isZero() || eCFieldElement.isOne()) {
                return a;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = a.negate();
            if (negate.bitLength() < a.bitLength()) {
                return square.multiply(negate).negate();
            }
            return square.multiply(a);
        }

        public ECPoint detach() {
            return new Fp((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.add(eCFieldElement2).square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        public ECFieldElement eight(ECFieldElement eCFieldElement) {
            return four(two(eCFieldElement));
        }

        public ECFieldElement four(ECFieldElement eCFieldElement) {
            return two(two(eCFieldElement));
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], (ECFieldElement) null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        public ECFieldElement getZCoord(int i) {
            if (i == 1 && 4 == getCurveCoordinateSystem()) {
                return getJacobianModifiedW();
            }
            return ECPoint.super.getZCoord(i);
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            if (curve.getCoordinateSystem() != 0) {
                return new Fp(curve, this.x, this.y.negate(), this.zs);
            }
            return new Fp(curve, this.x, this.y.negate());
        }

        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return two(eCFieldElement).add(eCFieldElement);
        }

        public ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.y;
            if (eCFieldElement.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement2 = this.x;
                ECFieldElement two = two(eCFieldElement);
                ECFieldElement square = two.square();
                ECFieldElement add = three(eCFieldElement2.square()).add(getCurve().getA());
                ECFieldElement subtract = three(eCFieldElement2).multiply(square).subtract(add.square());
                if (subtract.isZero()) {
                    return getCurve().getInfinity();
                }
                ECFieldElement invert = subtract.multiply(two).invert();
                ECFieldElement multiply = subtract.multiply(invert).multiply(add);
                ECFieldElement subtract2 = square.square().multiply(invert).subtract(multiply);
                ECFieldElement add2 = subtract2.subtract(multiply).multiply(multiply.add(subtract2)).add(eCFieldElement2);
                return new Fp(curve, add2, eCFieldElement2.subtract(add2).multiply(subtract2).subtract(eCFieldElement));
            } else if (coordinateSystem != 4) {
                return twice().add(this);
            } else {
                return twiceJacobianModified(false).add(this);
            }
        }

        public ECPoint timesPow2(int i) {
            ECFieldElement eCFieldElement;
            ECFieldElement multiply;
            int i2 = i;
            if (i2 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i2 == 0 || isInfinity()) {
                return this;
            } else {
                if (i2 == 1) {
                    return twice();
                }
                ECCurve curve = getCurve();
                ECFieldElement eCFieldElement2 = this.y;
                if (eCFieldElement2.isZero()) {
                    return curve.getInfinity();
                }
                int coordinateSystem = curve.getCoordinateSystem();
                ECFieldElement a = curve.getA();
                ECFieldElement eCFieldElement3 = this.x;
                ECFieldElement[] eCFieldElementArr = this.zs;
                int i3 = 0;
                if (eCFieldElementArr.length < 1) {
                    eCFieldElement = curve.fromBigInteger(ECConstants.ONE);
                } else {
                    eCFieldElement = eCFieldElementArr[0];
                }
                if (!eCFieldElement.isOne() && coordinateSystem != 0) {
                    if (coordinateSystem == 1) {
                        ECFieldElement square = eCFieldElement.square();
                        eCFieldElement3 = eCFieldElement3.multiply(eCFieldElement);
                        eCFieldElement2 = eCFieldElement2.multiply(square);
                        a = calculateJacobianModifiedW(eCFieldElement, square);
                    } else if (coordinateSystem == 2) {
                        a = calculateJacobianModifiedW(eCFieldElement, (ECFieldElement) null);
                    } else if (coordinateSystem == 4) {
                        a = getJacobianModifiedW();
                    } else {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                }
                while (i3 < i2) {
                    if (eCFieldElement2.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement three = three(eCFieldElement3.square());
                    ECFieldElement two = two(eCFieldElement2);
                    ECFieldElement multiply2 = two.multiply(eCFieldElement2);
                    ECFieldElement two2 = two(eCFieldElement3.multiply(multiply2));
                    ECFieldElement two3 = two(multiply2.square());
                    if (!a.isZero()) {
                        three = three.add(a);
                        a = two(two3.multiply(a));
                    }
                    ECFieldElement subtract = three.square().subtract(two(two2));
                    eCFieldElement2 = three.multiply(two2.subtract(subtract)).subtract(two3);
                    if (eCFieldElement.isOne()) {
                        multiply = two;
                    } else {
                        multiply = two.multiply(eCFieldElement);
                    }
                    i3++;
                    eCFieldElement3 = subtract;
                }
                if (coordinateSystem == 0) {
                    ECFieldElement invert = eCFieldElement.invert();
                    ECFieldElement square2 = invert.square();
                    return new Fp(curve, eCFieldElement3.multiply(square2), eCFieldElement2.multiply(square2.multiply(invert)));
                } else if (coordinateSystem == 1) {
                    return new Fp(curve, eCFieldElement3.multiply(eCFieldElement), eCFieldElement2, new ECFieldElement[]{eCFieldElement.multiply(eCFieldElement.square())});
                } else {
                    if (coordinateSystem == 2) {
                        return new Fp(curve, eCFieldElement3, eCFieldElement2, new ECFieldElement[]{eCFieldElement});
                    }
                    if (coordinateSystem == 4) {
                        return new Fp(curve, eCFieldElement3, eCFieldElement2, new ECFieldElement[]{eCFieldElement, a});
                    }
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement7 = this.y;
            if (eCFieldElement7.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement8 = this.x;
            if (coordinateSystem == 0) {
                ECFieldElement divide = three(eCFieldElement8.square()).add(getCurve().getA()).divide(two(eCFieldElement7));
                ECFieldElement subtract = divide.square().subtract(two(eCFieldElement8));
                return new Fp(curve, subtract, divide.multiply(eCFieldElement8.subtract(subtract)).subtract(eCFieldElement7));
            } else if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement9 = this.zs[0];
                boolean isOne = eCFieldElement9.isOne();
                ECFieldElement a = curve.getA();
                if (!a.isZero() && !isOne) {
                    a = a.multiply(eCFieldElement9.square());
                }
                ECFieldElement add = a.add(three(eCFieldElement8.square()));
                if (isOne) {
                    eCFieldElement = eCFieldElement7;
                } else {
                    eCFieldElement = eCFieldElement7.multiply(eCFieldElement9);
                }
                if (isOne) {
                    eCFieldElement2 = eCFieldElement7.square();
                } else {
                    eCFieldElement2 = eCFieldElement.multiply(eCFieldElement7);
                }
                ECFieldElement four = four(eCFieldElement8.multiply(eCFieldElement2));
                ECFieldElement subtract2 = add.square().subtract(two(four));
                ECFieldElement two = two(eCFieldElement);
                ECFieldElement multiply = subtract2.multiply(two);
                ECFieldElement two2 = two(eCFieldElement2);
                ECFieldElement subtract3 = four.subtract(subtract2).multiply(add).subtract(two(two2.square()));
                if (isOne) {
                    eCFieldElement3 = two(two2);
                } else {
                    eCFieldElement3 = two.square();
                }
                return new Fp(curve, multiply, subtract3, new ECFieldElement[]{two(eCFieldElement3).multiply(eCFieldElement)});
            } else if (coordinateSystem == 2) {
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne2 = eCFieldElement10.isOne();
                ECFieldElement square = eCFieldElement7.square();
                ECFieldElement square2 = square.square();
                ECFieldElement a2 = curve.getA();
                ECFieldElement negate = a2.negate();
                if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                    if (isOne2) {
                        eCFieldElement6 = eCFieldElement10;
                    } else {
                        eCFieldElement6 = eCFieldElement10.square();
                    }
                    eCFieldElement4 = three(eCFieldElement8.add(eCFieldElement6).multiply(eCFieldElement8.subtract(eCFieldElement6)));
                    eCFieldElement5 = four(square.multiply(eCFieldElement8));
                } else {
                    ECFieldElement three = three(eCFieldElement8.square());
                    if (isOne2) {
                        eCFieldElement4 = three.add(a2);
                    } else if (!a2.isZero()) {
                        ECFieldElement square3 = eCFieldElement10.square().square();
                        if (negate.bitLength() < a2.bitLength()) {
                            eCFieldElement4 = three.subtract(square3.multiply(negate));
                        } else {
                            eCFieldElement4 = three.add(square3.multiply(a2));
                        }
                    } else {
                        eCFieldElement4 = three;
                    }
                    eCFieldElement5 = four(eCFieldElement8.multiply(square));
                }
                ECFieldElement subtract4 = eCFieldElement4.square().subtract(two(eCFieldElement5));
                ECFieldElement subtract5 = eCFieldElement5.subtract(subtract4).multiply(eCFieldElement4).subtract(eight(square2));
                ECFieldElement two3 = two(eCFieldElement7);
                if (!isOne2) {
                    two3 = two3.multiply(eCFieldElement10);
                }
                return new Fp(curve, subtract4, subtract5, new ECFieldElement[]{two3});
            } else if (coordinateSystem == 4) {
                return twiceJacobianModified(true);
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public Fp twiceJacobianModified(boolean z) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2 = this.x;
            ECFieldElement eCFieldElement3 = this.y;
            ECFieldElement eCFieldElement4 = this.zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement add = three(eCFieldElement2.square()).add(jacobianModifiedW);
            ECFieldElement two = two(eCFieldElement3);
            ECFieldElement multiply = two.multiply(eCFieldElement3);
            ECFieldElement two2 = two(eCFieldElement2.multiply(multiply));
            ECFieldElement subtract = add.square().subtract(two(two2));
            ECFieldElement two3 = two(multiply.square());
            ECFieldElement subtract2 = add.multiply(two2.subtract(subtract)).subtract(two3);
            if (z) {
                eCFieldElement = two(two3.multiply(jacobianModifiedW));
            } else {
                eCFieldElement = null;
            }
            if (!eCFieldElement4.isOne()) {
                two = two.multiply(eCFieldElement4);
            }
            return new Fp(getCurve(), subtract, subtract2, new ECFieldElement[]{two, eCFieldElement});
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
            ECFieldElement eCFieldElement = this.y;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElement2 = this.x;
                ECFieldElement eCFieldElement3 = eCPoint.x;
                ECFieldElement eCFieldElement4 = eCPoint.y;
                ECFieldElement subtract = eCFieldElement3.subtract(eCFieldElement2);
                ECFieldElement subtract2 = eCFieldElement4.subtract(eCFieldElement);
                if (!subtract.isZero()) {
                    ECFieldElement square = subtract.square();
                    ECFieldElement subtract3 = square.multiply(two(eCFieldElement2).add(eCFieldElement3)).subtract(subtract2.square());
                    if (subtract3.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement invert = subtract3.multiply(subtract).invert();
                    ECFieldElement multiply = subtract3.multiply(invert).multiply(subtract2);
                    ECFieldElement subtract4 = two(eCFieldElement).multiply(square).multiply(subtract).multiply(invert).subtract(multiply);
                    ECFieldElement add = subtract4.subtract(multiply).multiply(multiply.add(subtract4)).add(eCFieldElement3);
                    return new Fp(curve, add, eCFieldElement2.subtract(add).multiply(subtract4).subtract(eCFieldElement));
                } else if (subtract2.isZero()) {
                    return threeTimes();
                } else {
                    return this;
                }
            } else if (coordinateSystem != 4) {
                return twice().add(eCPoint);
            } else {
                return twiceJacobianModified(false).add(eCPoint);
            }
        }

        public ECFieldElement two(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(eCCurve));
    }

    public static ECFieldElement[] getInitialZCoords(ECCurve eCCurve) {
        int i;
        if (eCCurve == null) {
            i = 0;
        } else {
            i = eCCurve.getCoordinateSystem();
        }
        if (i == 0 || i == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                return new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
            }
            if (i == 4) {
                return new ECFieldElement[]{fromBigInteger, eCCurve.getA()};
            }
            if (i != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{fromBigInteger};
    }

    public abstract ECPoint add(ECPoint eCPoint);

    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2));
    }

    public abstract ECPoint detach();

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r1 = r8.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r2 = r9.getCurve()
            r3 = 1
            if (r1 != 0) goto L_0x0011
            r4 = r3
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            if (r2 != 0) goto L_0x0016
            r5 = r3
            goto L_0x0017
        L_0x0016:
            r5 = r0
        L_0x0017:
            boolean r6 = r8.isInfinity()
            boolean r7 = r9.isInfinity()
            if (r6 != 0) goto L_0x006c
            if (r7 == 0) goto L_0x0024
            goto L_0x006c
        L_0x0024:
            if (r4 == 0) goto L_0x002a
            if (r5 == 0) goto L_0x002a
        L_0x0028:
            r1 = r8
            goto L_0x004e
        L_0x002a:
            if (r4 == 0) goto L_0x0031
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r9 = r9.normalize()
            goto L_0x0028
        L_0x0031:
            if (r5 == 0) goto L_0x0038
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r8.normalize()
            goto L_0x004e
        L_0x0038:
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r2)
            if (r2 != 0) goto L_0x003f
            return r0
        L_0x003f:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r9 = r1.importPoint(r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint[] r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint[]{r8, r9}
            r1.normalizeAll(r9)
            r1 = r9[r0]
            r9 = r9[r3]
        L_0x004e:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r2 = r1.getXCoord()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r4 = r9.getXCoord()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x006b
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r1 = r1.getYCoord()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement r9 = r9.getYCoord()
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x006b
            r0 = r3
        L_0x006b:
            return r0
        L_0x006c:
            if (r6 == 0) goto L_0x007b
            if (r7 == 0) goto L_0x007b
            if (r4 != 0) goto L_0x007a
            if (r5 != 0) goto L_0x007a
            boolean r9 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r2)
            if (r9 == 0) goto L_0x007b
        L_0x007a:
            r0 = r3
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint.equals(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint):boolean");
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public byte[] getEncoded(boolean z) {
        int i;
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint normalize = normalize();
        byte[] encoded = normalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[(encoded.length + 1)];
            if (normalize.getCompressionYTilde()) {
                i = 3;
            } else {
                i = 2;
            }
            bArr[0] = (byte) i;
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = normalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[(encoded.length + encoded2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public final ECFieldElement getRawXCoord() {
        return this.x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.y;
    }

    public final ECFieldElement[] getRawZCoords() {
        return this.zs;
    }

    public ECFieldElement getXCoord() {
        return this.x;
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return EMPTY_ZS;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    public int hashCode() {
        int i;
        ECCurve curve2 = getCurve();
        if (curve2 == null) {
            i = 0;
        } else {
            i = ~curve2.hashCode();
        }
        if (isInfinity()) {
            return i;
        }
        ECPoint normalize = normalize();
        return (i ^ (normalize.getXCoord().hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * 257);
    }

    public boolean implIsValid(final boolean z, final boolean z2) {
        if (isInfinity()) {
            return true;
        }
        return !((ValidityPrecompInfo) getCurve().precompute(this, "bc_validity", new PreCompCallback() {
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                ValidityPrecompInfo validityPrecompInfo;
                if (preCompInfo instanceof ValidityPrecompInfo) {
                    validityPrecompInfo = (ValidityPrecompInfo) preCompInfo;
                } else {
                    validityPrecompInfo = null;
                }
                if (validityPrecompInfo == null) {
                    validityPrecompInfo = new ValidityPrecompInfo();
                }
                if (validityPrecompInfo.hasFailed()) {
                    return validityPrecompInfo;
                }
                if (!validityPrecompInfo.hasCurveEquationPassed()) {
                    if (z || ECPoint.this.satisfiesCurveEquation()) {
                        validityPrecompInfo.reportCurveEquationPassed();
                    } else {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                }
                if (z2 && !validityPrecompInfo.hasOrderPassed()) {
                    if (!ECPoint.this.satisfiesOrder()) {
                        validityPrecompInfo.reportFailed();
                        return validityPrecompInfo;
                    }
                    validityPrecompInfo.reportOrderPassed();
                }
                return validityPrecompInfo;
            }
        })).hasFailed();
    }

    public boolean isInfinity() {
        if (!(this.x == null || this.y == null)) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.zs[0].isOne()) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return implIsValid(false, true);
    }

    public boolean isValidPartial() {
        return implIsValid(false, false);
    }

    public ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        if (this.curve != null) {
            ECFieldElement randomFieldElementMult = this.curve.randomFieldElementMult(CryptoServicesRegistrar.getSecureRandom());
            return normalize(zCoord.multiply(randomFieldElementMult).invert().multiply(randomFieldElementMult));
        }
        throw new IllegalStateException("Detached points must be in affine coordinates");
    }

    public abstract boolean satisfiesCurveEquation();

    public boolean satisfiesOrder() {
        BigInteger order;
        if (!ECConstants.ONE.equals(this.curve.getCofactor()) && (order = this.curve.getOrder()) != null && !ECAlgorithms.referenceMultiply(this, order).isInfinity()) {
            return false;
        }
        return true;
    }

    public ECPoint scaleX(ECFieldElement eCFieldElement) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord(), getRawZCoords());
    }

    public ECPoint scaleXNegateY(ECFieldElement eCFieldElement) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().negate(), getRawZCoords());
    }

    public ECPoint scaleY(ECFieldElement eCFieldElement) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public ECPoint scaleYNegateX(ECFieldElement eCFieldElement) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().negate(), getRawYCoord().multiply(eCFieldElement), getRawZCoords());
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int i) {
        if (i >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i--;
                if (i < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.twice();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (ECFieldElement append : this.zs) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint eCPoint) {
        return twice().add(eCPoint);
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompTable = null;
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement square = eCFieldElement.square();
                return createScaledPoint(square, square.multiply(eCFieldElement));
            } else if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        return equals((ECPoint) obj);
    }
}
