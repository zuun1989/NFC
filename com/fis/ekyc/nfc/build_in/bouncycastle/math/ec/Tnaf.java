package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import java.math.BigInteger;

class Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0;
    public static final byte[][] alpha0Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
    public static final ZTauElement[] alpha1;
    public static final byte[][] alpha1Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger bigInteger = ECConstants.ONE;
        BigInteger negate = bigInteger.negate();
        MINUS_ONE = negate;
        BigInteger negate2 = ECConstants.THREE.negate();
        MINUS_THREE = negate2;
        BigInteger bigInteger2 = ECConstants.ZERO;
        alpha0 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(bigInteger, negate), null};
        alpha1 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, bigInteger), null, new ZTauElement(negate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null};
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        int i3 = ((i + 5) / 2) + i2;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i4 = i3 - i2;
        BigInteger shiftRight = add.shiftRight(i4);
        if (add.testBit(i4 - 1)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(shiftRight, i2);
    }

    public static BigInteger[] getLucas(byte b, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        if (b == 1 || b == -1) {
            if (z) {
                bigInteger = ECConstants.TWO;
                bigInteger2 = BigInteger.valueOf((long) b);
            } else {
                bigInteger = ECConstants.ZERO;
                bigInteger2 = ECConstants.ONE;
            }
            int i2 = 1;
            while (i2 < i) {
                if (b == 1) {
                    bigInteger3 = bigInteger2;
                } else {
                    bigInteger3 = bigInteger2.negate();
                }
                i2++;
                BigInteger bigInteger4 = bigInteger2;
                bigInteger2 = bigInteger3.subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger4;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(int i) {
        return (byte) (i == 0 ? -1 : 1);
    }

    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m abstractF2m, byte b) {
        byte[][] bArr;
        if (b == 0) {
            bArr = alpha0Tnaf;
        } else {
            bArr = alpha1Tnaf;
        }
        ECPoint.AbstractF2m[] abstractF2mArr = new ECPoint.AbstractF2m[((bArr.length + 1) >>> 1)];
        abstractF2mArr[0] = abstractF2m;
        int length = bArr.length;
        for (int i = 3; i < length; i += 2) {
            abstractF2mArr[i >>> 1] = multiplyFromTnaf(abstractF2m, bArr[i]);
        }
        abstractF2m.getCurve().normalizeAll(abstractF2mArr);
        return abstractF2mArr;
    }

    public static int getShiftsForCofactor(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(ECConstants.TWO)) {
                return 1;
            }
            if (bigInteger.equals(ECConstants.FOUR)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static BigInteger[] getSi(ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            int fieldSize = abstractF2m.getFieldSize();
            int intValue = abstractF2m.getA().toBigInteger().intValue();
            byte mu = getMu(intValue);
            int shiftsForCofactor = getShiftsForCofactor(abstractF2m.getCofactor());
            BigInteger[] lucas = getLucas(mu, (fieldSize + 3) - intValue, false);
            if (mu == 1) {
                lucas[0] = lucas[0].negate();
                lucas[1] = lucas[1].negate();
            }
            BigInteger bigInteger = ECConstants.ONE;
            return new BigInteger[]{bigInteger.add(lucas[1]).shiftRight(shiftsForCofactor), bigInteger.add(lucas[0]).shiftRight(shiftsForCofactor).negate()};
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte b, int i) {
        if (i != 4) {
            BigInteger[] lucas = getLucas(b, i, false);
            BigInteger bit = ECConstants.ZERO.setBit(i);
            return ECConstants.TWO.multiply(lucas[0]).multiply(lucas[1].modInverse(bit)).mod(bit);
        } else if (b == 1) {
            return BigInteger.valueOf(6);
        } else {
            return BigInteger.valueOf(10);
        }
    }

    public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        ECPoint.AbstractF2m abstractF2m2;
        ECPoint.AbstractF2m abstractF2m3 = (ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        ECPoint.AbstractF2m abstractF2m4 = (ECPoint.AbstractF2m) abstractF2m.negate();
        int i = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i++;
            byte b = bArr[length];
            if (b != 0) {
                ECPoint.AbstractF2m tauPow = abstractF2m3.tauPow(i);
                if (b > 0) {
                    abstractF2m2 = abstractF2m;
                } else {
                    abstractF2m2 = abstractF2m4;
                }
                abstractF2m3 = (ECPoint.AbstractF2m) tauPow.add(abstractF2m2);
                i = 0;
            }
        }
        if (i > 0) {
            return abstractF2m3.tauPow(i);
        }
        return abstractF2m3;
    }

    public static ECPoint.AbstractF2m multiplyRTnaf(ECPoint.AbstractF2m abstractF2m, BigInteger bigInteger) {
        ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
        int fieldSize = abstractF2m2.getFieldSize();
        int intValue = abstractF2m2.getA().toBigInteger().intValue();
        byte mu = getMu(intValue);
        byte b = (byte) intValue;
        return multiplyTnaf(abstractF2m, partModReduction(bigInteger, fieldSize, b, abstractF2m2.getSi(), mu, (byte) 10));
    }

    public static ECPoint.AbstractF2m multiplyTnaf(ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement) {
        return multiplyFromTnaf(abstractF2m, tauAdicNaf(getMu(((ECCurve.AbstractF2m) abstractF2m.getCurve()).getA()), zTauElement));
    }

    public static BigInteger norm(byte b, ZTauElement zTauElement) {
        BigInteger bigInteger = zTauElement.u;
        BigInteger multiply = bigInteger.multiply(bigInteger);
        BigInteger multiply2 = zTauElement.u.multiply(zTauElement.v);
        BigInteger bigInteger2 = zTauElement.v;
        BigInteger shiftLeft = bigInteger2.multiply(bigInteger2).shiftLeft(1);
        if (b == 1) {
            return multiply.add(multiply2).add(shiftLeft);
        }
        if (b == -1) {
            return multiply.subtract(multiply2).add(shiftLeft);
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static ZTauElement partModReduction(BigInteger bigInteger, int i, byte b, BigInteger[] bigIntegerArr, byte b2, byte b3) {
        BigInteger subtract;
        byte b4 = b2;
        if (b4 == 1) {
            subtract = bigIntegerArr[0].add(bigIntegerArr[1]);
        } else {
            subtract = bigIntegerArr[0].subtract(bigIntegerArr[1]);
        }
        int i2 = i;
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = getLucas(b4, i, true)[1];
        byte b5 = b;
        int i3 = i;
        byte b6 = b3;
        ZTauElement round = round(approximateDivisionByN(bigInteger2, bigIntegerArr[0], bigInteger3, b5, i3, b6), approximateDivisionByN(bigInteger2, bigIntegerArr[1], bigInteger3, b5, i3, b6), b4);
        BigInteger bigInteger4 = bigInteger;
        return new ZTauElement(bigInteger.subtract(subtract.multiply(round.u)).subtract(BigInteger.valueOf(2).multiply(bigIntegerArr[1]).multiply(round.v)), bigIntegerArr[1].multiply(round.u).subtract(bigIntegerArr[0].multiply(round.v)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (r5.compareTo(MINUS_ONE) < 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        if (r5.compareTo(r9) >= 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r8.compareTo(MINUS_TWO) < 0) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ZTauElement round(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r8, com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r9, byte r10) {
        /*
            int r0 = r8.getScale()
            int r1 = r9.getScale()
            if (r1 != r0) goto L_0x00a8
            r0 = -1
            r1 = 1
            if (r10 == r1) goto L_0x0019
            if (r10 != r0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "mu must be 1 or -1"
            r8.<init>(r9)
            throw r8
        L_0x0019:
            java.math.BigInteger r2 = r8.round()
            java.math.BigInteger r3 = r9.round()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.subtract((java.math.BigInteger) r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r9 = r9.subtract((java.math.BigInteger) r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r4 = r8.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r8)
            if (r10 != r1) goto L_0x0034
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r4 = r4.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
            goto L_0x0038
        L_0x0034:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r4 = r4.subtract((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
        L_0x0038:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r5 = r9.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r5 = r5.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r9 = r5.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
            if (r10 != r1) goto L_0x004f
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r5 = r8.subtract((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
            goto L_0x0057
        L_0x004f:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r5 = r8.add((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal r8 = r8.subtract((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal) r9)
        L_0x0057:
            java.math.BigInteger r9 = com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants.ONE
            int r6 = r4.compareTo((java.math.BigInteger) r9)
            r7 = 0
            if (r6 < 0) goto L_0x0069
            java.math.BigInteger r6 = MINUS_ONE
            int r6 = r5.compareTo((java.math.BigInteger) r6)
            if (r6 >= 0) goto L_0x0075
            goto L_0x0071
        L_0x0069:
            java.math.BigInteger r1 = com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants.TWO
            int r1 = r8.compareTo((java.math.BigInteger) r1)
            if (r1 < 0) goto L_0x0074
        L_0x0071:
            r1 = r7
            r7 = r10
            goto L_0x0075
        L_0x0074:
            r1 = r7
        L_0x0075:
            java.math.BigInteger r6 = MINUS_ONE
            int r4 = r4.compareTo((java.math.BigInteger) r6)
            if (r4 >= 0) goto L_0x0087
            int r8 = r5.compareTo((java.math.BigInteger) r9)
            if (r8 < 0) goto L_0x0090
        L_0x0083:
            int r8 = -r10
            byte r7 = (byte) r8
        L_0x0085:
            r0 = r1
            goto L_0x0090
        L_0x0087:
            java.math.BigInteger r9 = MINUS_TWO
            int r8 = r8.compareTo((java.math.BigInteger) r9)
            if (r8 >= 0) goto L_0x0085
            goto L_0x0083
        L_0x0090:
            long r8 = (long) r0
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r2.add(r8)
            long r9 = (long) r7
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.math.BigInteger r9 = r3.add(r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ZTauElement r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ZTauElement
            r10.<init>(r8, r9)
            return r10
        L_0x00a8:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "lambda0 and lambda1 do not have same scale"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.Tnaf.round(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal, com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.SimpleBigDecimal, byte):com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ZTauElement");
    }

    public static ECPoint.AbstractF2m tau(ECPoint.AbstractF2m abstractF2m) {
        return abstractF2m.tau();
    }

    public static byte[] tauAdicNaf(byte b, ZTauElement zTauElement) {
        int i;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (b == 1 || b == -1) {
            int bitLength = norm(b, zTauElement).bitLength();
            if (bitLength > 30) {
                i = bitLength + 4;
            } else {
                i = 34;
            }
            byte[] bArr = new byte[i];
            BigInteger bigInteger3 = zTauElement.u;
            BigInteger bigInteger4 = zTauElement.v;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                BigInteger bigInteger5 = ECConstants.ZERO;
                if (!bigInteger.equals(bigInteger5) || !bigInteger4.equals(bigInteger5)) {
                    if (bigInteger.testBit(0)) {
                        byte intValue = (byte) ECConstants.TWO.subtract(bigInteger.subtract(bigInteger4.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
                        bArr[i3] = intValue;
                        if (intValue == 1) {
                            bigInteger = bigInteger.clearBit(0);
                        } else {
                            bigInteger = bigInteger.add(ECConstants.ONE);
                        }
                        i2 = i3;
                    } else {
                        bArr[i3] = 0;
                    }
                    BigInteger shiftRight = bigInteger.shiftRight(1);
                    if (b == 1) {
                        bigInteger2 = bigInteger4.add(shiftRight);
                    } else {
                        bigInteger2 = bigInteger4.subtract(shiftRight);
                    }
                    i3++;
                    BigInteger negate = bigInteger.shiftRight(1).negate();
                    bigInteger3 = bigInteger2;
                    bigInteger4 = negate;
                } else {
                    int i4 = i2 + 1;
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, 0, bArr2, 0, i4);
                    return bArr2;
                }
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }

    public static byte[] tauAdicWNaf(byte b, ZTauElement zTauElement, byte b2, BigInteger bigInteger, BigInteger bigInteger2, ZTauElement[] zTauElementArr) {
        int i;
        BigInteger bigInteger3;
        int intValue;
        boolean z;
        if (b == 1 || b == -1) {
            int bitLength = norm(b, zTauElement).bitLength();
            if (bitLength > 30) {
                i = bitLength + 4 + b2;
            } else {
                i = b2 + ISO7816.INS_MSE;
            }
            byte[] bArr = new byte[i];
            BigInteger shiftRight = bigInteger.shiftRight(1);
            BigInteger bigInteger4 = zTauElement.u;
            BigInteger bigInteger5 = zTauElement.v;
            int i2 = 0;
            while (true) {
                BigInteger bigInteger6 = ECConstants.ZERO;
                if (bigInteger4.equals(bigInteger6) && bigInteger5.equals(bigInteger6)) {
                    return bArr;
                }
                if (bigInteger4.testBit(0)) {
                    BigInteger mod = bigInteger4.add(bigInteger5.multiply(bigInteger2)).mod(bigInteger);
                    if (mod.compareTo(shiftRight) >= 0) {
                        intValue = mod.subtract(bigInteger).intValue();
                    } else {
                        intValue = mod.intValue();
                    }
                    byte b3 = (byte) intValue;
                    bArr[i2] = b3;
                    if (b3 < 0) {
                        b3 = (byte) (-b3);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        bigInteger4 = bigInteger4.subtract(zTauElementArr[b3].u);
                        bigInteger5 = bigInteger5.subtract(zTauElementArr[b3].v);
                    } else {
                        bigInteger4 = bigInteger4.add(zTauElementArr[b3].u);
                        bigInteger5 = bigInteger5.add(zTauElementArr[b3].v);
                    }
                } else {
                    bArr[i2] = 0;
                }
                if (b == 1) {
                    bigInteger3 = bigInteger5.add(bigInteger4.shiftRight(1));
                } else {
                    bigInteger3 = bigInteger5.subtract(bigInteger4.shiftRight(1));
                }
                i2++;
                BigInteger negate = bigInteger4.shiftRight(1).negate();
                bigInteger4 = bigInteger3;
                bigInteger5 = negate;
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }

    public static byte getMu(ECCurve.AbstractF2m abstractF2m) {
        if (abstractF2m.isKoblitz()) {
            return abstractF2m.getA().isZero() ? (byte) -1 : 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static byte getMu(ECFieldElement eCFieldElement) {
        return (byte) (eCFieldElement.isZero() ? -1 : 1);
    }

    public static SimpleBigDecimal norm(byte b, SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2) {
        SimpleBigDecimal multiply = simpleBigDecimal.multiply(simpleBigDecimal);
        SimpleBigDecimal multiply2 = simpleBigDecimal.multiply(simpleBigDecimal2);
        SimpleBigDecimal shiftLeft = simpleBigDecimal2.multiply(simpleBigDecimal2).shiftLeft(1);
        if (b == 1) {
            return multiply.add(multiply2).add(shiftLeft);
        }
        if (b == -1) {
            return multiply.subtract(multiply2).add(shiftLeft);
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static BigInteger[] getSi(int i, int i2, BigInteger bigInteger) {
        byte mu = getMu(i2);
        int shiftsForCofactor = getShiftsForCofactor(bigInteger);
        BigInteger[] lucas = getLucas(mu, (i + 3) - i2, false);
        if (mu == 1) {
            lucas[0] = lucas[0].negate();
            lucas[1] = lucas[1].negate();
        }
        BigInteger bigInteger2 = ECConstants.ONE;
        return new BigInteger[]{bigInteger2.add(lucas[1]).shiftRight(shiftsForCofactor), bigInteger2.add(lucas[0]).shiftRight(shiftsForCofactor).negate()};
    }
}
