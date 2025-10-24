package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.custom.sec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.AbstractECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECLookupTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.WTauNafMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.raw.Nat256;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import java.math.BigInteger;

public class SecT239K1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT239K1_AFFINE_ZS = {new SecT239FieldElement(ECConstants.ONE)};
    private static final int SECT239K1_DEFAULT_COORDS = 6;
    protected SecT239K1Point infinity = new SecT239K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT239K1Curve() {
        super(239, ISO781611.SMT_DO_DS, 0, 0);
        this.a = fromBigInteger(BigInteger.valueOf(0));
        this.b = fromBigInteger(BigInteger.valueOf(1));
        this.order = new BigInteger(1, Hex.decodeStrict("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.cofactor = BigInteger.valueOf(4);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT239K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i, final int i2) {
        final long[] jArr = new long[(i2 * 8)];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            ECPoint eCPoint = eCPointArr[i + i4];
            Nat256.copy64(((SecT239FieldElement) eCPoint.getRawXCoord()).x, 0, jArr, i3);
            Nat256.copy64(((SecT239FieldElement) eCPoint.getRawYCoord()).x, 0, jArr, i3 + 4);
            i3 += 8;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT239K1Curve.this.createRawPoint(new SecT239FieldElement(jArr), new SecT239FieldElement(jArr2), SecT239K1Curve.SECT239K1_AFFINE_ZS);
            }

            public int getSize() {
                return i2;
            }

            public ECPoint lookup(int i) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    long j = (long) (((i3 ^ i) - 1) >> 31);
                    for (int i4 = 0; i4 < 4; i4++) {
                        long j2 = create64[i4];
                        long[] jArr = jArr;
                        create64[i4] = j2 ^ (jArr[i2 + i4] & j);
                        create642[i4] = create642[i4] ^ (jArr[(i2 + 4) + i4] & j);
                    }
                    i2 += 8;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i2 = i * 8;
                for (int i3 = 0; i3 < 4; i3++) {
                    long[] jArr = jArr;
                    create64[i3] = jArr[i2 + i3];
                    create642[i3] = jArr[4 + i2 + i3];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT239K1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT239FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 239;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return ISO781611.SMT_DO_DS;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 239;
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
        return new SecT239K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
