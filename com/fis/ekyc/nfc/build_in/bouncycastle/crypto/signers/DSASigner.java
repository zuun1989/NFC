package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DSASigner implements DSAExt {
    private final DSAKCalculator kCalculator;
    private DSAKeyParameters key;
    private SecureRandom random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int bitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(bArr, 0, bArr2, 0, bitLength);
        return new BigInteger(1, bArr2);
    }

    private BigInteger getRandomizer(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.createRandomBigInteger(7, CryptoServicesRegistrar.getSecureRandom(secureRandom)).add(BigInteger.valueOf(128)).multiply(bigInteger);
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger q = parameters.getQ();
        BigInteger calculateE = calculateE(q, bArr);
        BigInteger x = ((DSAPrivateKeyParameters) this.key).getX();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(q, x, bArr);
        } else {
            this.kCalculator.init(q, this.random);
        }
        BigInteger nextK = this.kCalculator.nextK();
        BigInteger mod = parameters.getG().modPow(nextK.add(getRandomizer(q, this.random)), parameters.getP()).mod(q);
        return new BigInteger[]{mod, BigIntegers.modOddInverse(q, nextK).multiply(calculateE.add(x.multiply(mod))).mod(q)};
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
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
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters) r0
            r1.key = r0
            java.security.SecureRandom r3 = r3.getRandom()
            goto L_0x001f
        L_0x0015:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters) r3
            r1.key = r3
            goto L_0x001e
        L_0x001a:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPublicKeyParameters r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPublicKeyParameters) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.DSASigner.init(boolean, com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters):void");
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger q = parameters.getQ();
        BigInteger calculateE = calculateE(q, bArr);
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || q.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || q.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modOddInverseVar = BigIntegers.modOddInverseVar(q, bigInteger2);
        BigInteger mod = calculateE.multiply(modOddInverseVar).mod(q);
        BigInteger mod2 = bigInteger.multiply(modOddInverseVar).mod(q);
        BigInteger p = parameters.getP();
        return parameters.getG().modPow(mod, p).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(mod2, p)).mod(p).mod(q).equals(bigInteger);
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }
}
