package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.AbstractECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat128;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

public class SecT113R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT113R1_AFFINE_ZS = {new SecT113FieldElement(ECConstants.ONE)};
    private static final int SECT113R1_DEFAULT_COORDS = 6;
    protected SecT113R1Point infinity = new SecT113R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT113R1Curve() {
        super(113, 9, 0, 0);
        this.a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("003088250CA6E7C7FE649CE85820F7")));
        this.b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("00E8BEE4D3E2260744188BE0E9C723")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000D9CCEC8A39E56F"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT113R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final long[] jArr = new long[(i2 * 4)];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat128.copy64(((SecT113FieldElement) eCPoint.getRawXCoord()).x, 0, jArr, i3);
            Nat128.copy64(((SecT113FieldElement) eCPoint.getRawYCoord()).x, 0, jArr, i3 + 2);
            i3 += 4;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT113R1Curve.this.createRawPoint(new SecT113FieldElement(jArr), new SecT113FieldElement(jArr2), SecT113R1Curve.SECT113R1_AFFINE_ZS);
            }

            public int getSize() {
                return i2;
            }

            public ECPoint lookup(int i) {
                long[] create64 = Nat128.create64();
                long[] create642 = Nat128.create64();
                int i2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 2; i4++) {
                        long j2 = create64[i4];
                        long[] jArr = jArr;
                        create64[i4] = j2 ^ (jArr[i2 + i4] & j);
                        create642[i4] = create642[i4] ^ (jArr[(i2 + 2) + i4] & j);
                    }
                    i2 += 4;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i) {
                long[] create64 = Nat128.create64();
                long[] create642 = Nat128.create64();
                int i2 = i * 4;
                for (int i3 = 0; i3 < 2; i3++) {
                    long[] jArr = jArr;
                    create64[i3] = jArr[i2 + i3];
                    create642[i3] = jArr[2 + i2 + i3];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT113R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 113;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 9;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 113;
    }

    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return true;
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT113R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
