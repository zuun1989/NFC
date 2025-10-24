package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

public class ECDomainParameters implements ECConstants {
    private final ECPoint G;
    private final ECCurve curve;
    private final BigInteger h;
    private BigInteger hInv;
    private final BigInteger n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters x9ECParameters) {
        this(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        if (!this.curve.equals(eCDomainParameters.curve) || !this.G.equals(eCDomainParameters.G) || !this.n.equals(eCDomainParameters.n)) {
            return false;
        }
        return true;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.h;
    }

    public synchronized BigInteger getHInv() {
        try {
            if (this.hInv == null) {
                this.hInv = BigIntegers.modOddInverseVar(this.n, this.h);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.hInv;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        return ((((this.curve.hashCode() ^ 1028) * 257) ^ this.G.hashCode()) * 257) ^ this.n.hashCode();
    }

    public BigInteger validatePrivateScalar(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullPointerException("Scalar cannot be null");
        } else if (bigInteger.compareTo(ECConstants.ONE) >= 0 && bigInteger.compareTo(getN()) < 0) {
            return bigInteger;
        } else {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
    }

    public ECPoint validatePublicPoint(ECPoint eCPoint) {
        return validatePublicPoint(getCurve(), eCPoint);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ECConstants.ONE, (byte[]) null);
    }

    public static ECPoint validatePublicPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCPoint != null) {
            ECPoint normalize = ECAlgorithms.importPoint(eCCurve, eCPoint).normalize();
            if (normalize.isInfinity()) {
                throw new IllegalArgumentException("Point at infinity");
            } else if (normalize.isValid()) {
                return normalize;
            } else {
                throw new IllegalArgumentException("Point not on curve");
            }
        } else {
            throw new NullPointerException("Point cannot be null");
        }
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.hInv = null;
        if (eCCurve == null) {
            throw new NullPointerException("curve");
        } else if (bigInteger != null) {
            this.curve = eCCurve;
            this.G = validatePublicPoint(eCCurve, eCPoint);
            this.n = bigInteger;
            this.h = bigInteger2;
            this.seed = Arrays.clone(bArr);
        } else {
            throw new NullPointerException("n");
        }
    }
}
