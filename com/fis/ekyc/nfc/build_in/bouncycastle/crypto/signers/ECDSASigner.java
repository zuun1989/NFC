package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.FixedPointCombMultiplier;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECDSASigner implements ECConstants, DSAExt {
    private final DSAKCalculator kCalculator;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        int bitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bitLength < length) {
            return bigInteger2.shiftRight(length - bitLength);
        }
        return bigInteger2;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n = parameters.getN();
        BigInteger calculateE = calculateE(n, bArr);
        BigInteger d = ((ECPrivateKeyParameters) this.key).getD();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(n, d, bArr);
        } else {
            this.kCalculator.init(n, this.random);
        }
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger nextK = this.kCalculator.nextK();
            BigInteger mod = createBasePointMultiplier.multiply(parameters.getG(), nextK).normalize().getAffineXCoord().toBigInteger().mod(n);
            BigInteger bigInteger = ECConstants.ZERO;
            if (!mod.equals(bigInteger)) {
                BigInteger mod2 = BigIntegers.modOddInverse(n, nextK).multiply(calculateE.add(d.multiply(mod))).mod(n);
                if (!mod2.equals(bigInteger)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    public ECFieldElement getDenominator(int i, ECPoint eCPoint) {
        if (i != 1) {
            if (i == 2 || i == 3 || i == 4) {
                return eCPoint.getZCoord(0).square();
            }
            if (!(i == 6 || i == 7)) {
                return null;
            }
        }
        return eCPoint.getZCoord(0);
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r2, com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x001a
            boolean r0 = r3 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom
            if (r0 == 0) goto L_0x0015
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom) r3
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r0 = r3.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters) r0
            r1.key = r0
            java.security.SecureRandom r3 = r3.getRandom()
            goto L_0x001f
        L_0x0015:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters) r3
            r1.key = r3
            goto L_0x001e
        L_0x001a:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters) r3
            r1.key = r3
        L_0x001e:
            r3 = 0
        L_0x001f:
            if (r2 == 0) goto L_0x002b
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.DSAKCalculator r2 = r1.kCalculator
            boolean r2 = r2.isDeterministic()
            if (r2 != 0) goto L_0x002b
            r2 = 1
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            java.security.SecureRandom r2 = r1.initSecureRandom(r2, r3)
            r1.random = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.ECDSASigner.init(boolean, com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters):void");
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger cofactor;
        ECFieldElement denominator;
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n = parameters.getN();
        BigInteger calculateE = calculateE(n, bArr);
        BigInteger bigInteger3 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger modOddInverseVar = BigIntegers.modOddInverseVar(n, bigInteger2);
        ECPoint sumOfTwoMultiplies = ECAlgorithms.sumOfTwoMultiplies(parameters.getG(), calculateE.multiply(modOddInverseVar).mod(n), ((ECPublicKeyParameters) this.key).getQ(), bigInteger.multiply(modOddInverseVar).mod(n));
        if (sumOfTwoMultiplies.isInfinity()) {
            return false;
        }
        ECCurve curve = sumOfTwoMultiplies.getCurve();
        if (curve == null || (cofactor = curve.getCofactor()) == null || cofactor.compareTo(ECConstants.EIGHT) > 0 || (denominator = getDenominator(curve.getCoordinateSystem(), sumOfTwoMultiplies)) == null || denominator.isZero()) {
            return sumOfTwoMultiplies.normalize().getAffineXCoord().toBigInteger().mod(n).equals(bigInteger);
        }
        ECFieldElement xCoord = sumOfTwoMultiplies.getXCoord();
        while (curve.isValidFieldElement(bigInteger)) {
            if (curve.fromBigInteger(bigInteger).multiply(denominator).equals(xCoord)) {
                return true;
            }
            bigInteger = bigInteger.add(n);
        }
        return false;
    }

    public ECDSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }
}
