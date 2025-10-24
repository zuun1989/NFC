package com.fis.ekyc.nfc.build_in.bouncycastle.jce;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class ECPointUtil {
    public static ECPoint decodePoint(EllipticCurve ellipticCurve, byte[] bArr) {
        ECCurve eCCurve;
        ECCurve.F2m f2m;
        if (ellipticCurve.getField() instanceof ECFieldFp) {
            eCCurve = new ECCurve.Fp(((ECFieldFp) ellipticCurve.getField()).getP(), ellipticCurve.getA(), ellipticCurve.getB());
        } else {
            int[] midTermsOfReductionPolynomial = ((ECFieldF2m) ellipticCurve.getField()).getMidTermsOfReductionPolynomial();
            if (midTermsOfReductionPolynomial.length == 3) {
                f2m = new ECCurve.F2m(((ECFieldF2m) ellipticCurve.getField()).getM(), midTermsOfReductionPolynomial[2], midTermsOfReductionPolynomial[1], midTermsOfReductionPolynomial[0], ellipticCurve.getA(), ellipticCurve.getB());
            } else {
                f2m = new ECCurve.F2m(((ECFieldF2m) ellipticCurve.getField()).getM(), midTermsOfReductionPolynomial[0], ellipticCurve.getA(), ellipticCurve.getB());
            }
            eCCurve = f2m;
        }
        return EC5Util.convertPoint(eCCurve.decodePoint(bArr));
    }
}
