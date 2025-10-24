package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.AbstractECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WTauNafMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat448;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

public class SecT409K1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT409K1_AFFINE_ZS = {new SecT409FieldElement(ECConstants.ONE)};
    private static final int SECT409K1_DEFAULT_COORDS = 6;
    protected SecT409K1Point infinity = new SecT409K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT409K1Curve() {
        super(409, 87, 0, 0);
        this.a = fromBigInteger(BigInteger.valueOf(0));
        this.b = fromBigInteger(BigInteger.valueOf(1));
        this.order = new BigInteger(1, Hex.decodeStrict("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.cofactor = BigInteger.valueOf(4);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT409K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final long[] jArr = new long[(i2 * 14)];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat448.copy64(((SecT409FieldElement) eCPoint.getRawXCoord()).x, 0, jArr, i3);
            Nat448.copy64(((SecT409FieldElement) eCPoint.getRawYCoord()).x, 0, jArr, i3 + 7);
            i3 += 14;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT409K1Curve.this.createRawPoint(new SecT409FieldElement(jArr), new SecT409FieldElement(jArr2), SecT409K1Curve.SECT409K1_AFFINE_ZS);
            }

            public int getSize() {
                return i2;
            }

            public ECPoint lookup(int i) {
                long[] create64 = Nat448.create64();
                long[] create642 = Nat448.create64();
                int i2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 7; i4++) {
                        long j2 = create64[i4];
                        long[] jArr = jArr;
                        create64[i4] = j2 ^ (jArr[i2 + i4] & j);
                        create642[i4] = create642[i4] ^ (jArr[(i2 + 7) + i4] & j);
                    }
                    i2 += 14;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i) {
                long[] create64 = Nat448.create64();
                long[] create642 = Nat448.create64();
                int i2 = i * 14;
                for (int i3 = 0; i3 < 7; i3++) {
                    long[] jArr = jArr;
                    create64[i3] = jArr[i2 + i3];
                    create642[i3] = jArr[7 + i2 + i3];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT409FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 409;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 87;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 409;
    }

    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return true;
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
