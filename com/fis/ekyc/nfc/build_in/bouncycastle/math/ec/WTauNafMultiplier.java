package com.fis.ekyc.nfc.build_in.bouncycastle.math.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

public class WTauNafMultiplier extends AbstractECMultiplier {
    static final String PRECOMP_NAME = "bc_wtnaf";

    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        ECPoint.AbstractF2m abstractF2m2;
        ECCurve.AbstractF2m abstractF2m3 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
        final byte byteValue = abstractF2m3.getA().toBigInteger().byteValue();
        ECPoint.AbstractF2m[] preComp = ((WTauNafPreCompInfo) abstractF2m3.precompute(abstractF2m, PRECOMP_NAME, new PreCompCallback() {
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                if (preCompInfo instanceof WTauNafPreCompInfo) {
                    return preCompInfo;
                }
                WTauNafPreCompInfo wTauNafPreCompInfo = new WTauNafPreCompInfo();
                wTauNafPreCompInfo.setPreComp(Tnaf.getPreComp(ECPoint.AbstractF2m.this, byteValue));
                return wTauNafPreCompInfo;
            }
        })).getPreComp();
        ECPoint.AbstractF2m[] abstractF2mArr = new ECPoint.AbstractF2m[preComp.length];
        for (int i = 0; i < preComp.length; i++) {
            abstractF2mArr[i] = (ECPoint.AbstractF2m) preComp[i].negate();
        }
        ECPoint.AbstractF2m abstractF2m4 = (ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        int i2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i2++;
            byte b = bArr[length];
            if (b != 0) {
                ECPoint.AbstractF2m tauPow = abstractF2m4.tauPow(i2);
                if (b > 0) {
                    abstractF2m2 = preComp[b >>> 1];
                } else {
                    abstractF2m2 = abstractF2mArr[(-b) >>> 1];
                }
                abstractF2m4 = (ECPoint.AbstractF2m) tauPow.add(abstractF2m2);
                i2 = 0;
            }
        }
        if (i2 > 0) {
            return abstractF2m4.tauPow(i2);
        }
        return abstractF2m4;
    }

    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement, byte b, byte b2) {
        ZTauElement[] zTauElementArr;
        if (b == 0) {
            zTauElementArr = Tnaf.alpha0;
        } else {
            zTauElementArr = Tnaf.alpha1;
        }
        ZTauElement[] zTauElementArr2 = zTauElementArr;
        return multiplyFromWTnaf(abstractF2m, Tnaf.tauAdicWNaf(b2, zTauElement, (byte) 4, BigInteger.valueOf(16), Tnaf.getTw(b2, 4), zTauElementArr2));
    }

    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        if (eCPoint instanceof ECPoint.AbstractF2m) {
            ECPoint.AbstractF2m abstractF2m = (ECPoint.AbstractF2m) eCPoint;
            ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
            int fieldSize = abstractF2m2.getFieldSize();
            byte byteValue = abstractF2m2.getA().toBigInteger().byteValue();
            byte mu = Tnaf.getMu((int) byteValue);
            return multiplyWTnaf(abstractF2m, Tnaf.partModReduction(bigInteger, fieldSize, byteValue, abstractF2m2.getSi(), mu, (byte) 10), byteValue, mu);
        }
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }
}
