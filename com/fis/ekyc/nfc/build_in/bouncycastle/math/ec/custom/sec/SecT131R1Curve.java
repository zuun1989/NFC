package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.AbstractECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat192;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import java.math.BigInteger;

public class SecT131R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT131R1_AFFINE_ZS = {new SecT131FieldElement(ECConstants.ONE)};
    private static final int SECT131R1_DEFAULT_COORDS = 6;
    protected SecT131R1Point infinity = new SecT131R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT131R1Curve() {
        super(ISO781611.CREATION_DATE_AND_TIME_TAG, 2, 3, 8);
        this.a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("07A11B09A76B562144418FF3FF8C2570B8")));
        this.b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("0217C05610884B63B9C6C7291678F9D341")));
        this.order = new BigInteger(1, Hex.decodeStrict("0400000000000000023123953A9464B54D"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT131R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final long[] jArr = new long[(i2 * 6)];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat192.copy64(((SecT131FieldElement) eCPoint.getRawXCoord()).x, 0, jArr, i3);
            Nat192.copy64(((SecT131FieldElement) eCPoint.getRawYCoord()).x, 0, jArr, i3 + 3);
            i3 += 6;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT131R1Curve.this.createRawPoint(new SecT131FieldElement(jArr), new SecT131FieldElement(jArr2), SecT131R1Curve.SECT131R1_AFFINE_ZS);
            }

            public int getSize() {
                return i2;
            }

            public ECPoint lookup(int i) {
                long[] create64 = Nat192.create64();
                long[] create642 = Nat192.create64();
                int i2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 3; i4++) {
                        long j2 = create64[i4];
                        long[] jArr = jArr;
                        create64[i4] = j2 ^ (jArr[i2 + i4] & j);
                        create642[i4] = create642[i4] ^ (jArr[(i2 + 3) + i4] & j);
                    }
                    i2 += 6;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i) {
                long[] create64 = Nat192.create64();
                long[] create642 = Nat192.create64();
                int i2 = i * 6;
                for (int i3 = 0; i3 < 3; i3++) {
                    long[] jArr = jArr;
                    create64[i3] = jArr[i2 + i3];
                    create642[i3] = jArr[3 + i2 + i3];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT131R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT131FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return ISO781611.CREATION_DATE_AND_TIME_TAG;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 3;
    }

    public int getK3() {
        return 8;
    }

    public int getM() {
        return ISO781611.CREATION_DATE_AND_TIME_TAG;
    }

    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT131R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
