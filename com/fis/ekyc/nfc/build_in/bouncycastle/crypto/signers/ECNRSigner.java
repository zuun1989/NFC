package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DSAExt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.ECKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECConstants;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ECNRSigner implements DSAExt {
    private boolean forSigning;
    private ECKeyParameters key;
    private SecureRandom random;

    private BigInteger extractT(ECPublicKeyParameters eCPublicKeyParameters, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = eCPublicKeyParameters.getParameters().getN();
        if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ECConstants.ZERO) < 0 || bigInteger2.compareTo(n) >= 0) {
            return null;
        }
        ECPoint normalize = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters.getParameters().getG(), bigInteger2, eCPublicKeyParameters.getQ(), bigInteger).normalize();
        if (normalize.isInfinity()) {
            return null;
        }
        return bigInteger.subtract(normalize.getAffineXCoord().toBigInteger()).mod(n);
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        AsymmetricCipherKeyPair generateKeyPair;
        BigInteger mod;
        if (this.forSigning) {
            BigInteger order = getOrder();
            BigInteger bigInteger = new BigInteger(1, bArr);
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
            if (bigInteger.compareTo(order) < 0) {
                do {
                    ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                    eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCPrivateKeyParameters.getParameters(), this.random));
                    generateKeyPair = eCKeyPairGenerator.generateKeyPair();
                    mod = ((ECPublicKeyParameters) generateKeyPair.getPublic()).getQ().getAffineXCoord().toBigInteger().add(bigInteger).mod(order);
                } while (mod.equals(ECConstants.ZERO));
                return new BigInteger[]{mod, ((ECPrivateKeyParameters) generateKeyPair.getPrivate()).getD().subtract(mod.multiply(eCPrivateKeyParameters.getD())).mod(order)};
            }
            throw new DataLengthException("input too large for ECNR key");
        }
        throw new IllegalStateException("not initialised for signing");
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    public byte[] getRecoveredMessage(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!this.forSigning) {
            BigInteger extractT = extractT((ECPublicKeyParameters) this.key, bigInteger, bigInteger2);
            if (extractT != null) {
                return BigIntegers.asUnsignedByteArray(extractT);
            }
            return null;
        }
        throw new IllegalStateException("not initialised for verifying/recovery");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        if (!z) {
            this.key = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
        } else {
            this.random = CryptoServicesRegistrar.getSecureRandom();
            this.key = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (!this.forSigning) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.key;
            BigInteger n = eCPublicKeyParameters.getParameters().getN();
            int bitLength = n.bitLength();
            BigInteger bigInteger3 = new BigInteger(1, bArr);
            if (bigInteger3.bitLength() <= bitLength) {
                BigInteger extractT = extractT(eCPublicKeyParameters, bigInteger, bigInteger2);
                if (extractT == null || !extractT.equals(bigInteger3.mod(n))) {
                    return false;
                }
                return true;
            }
            throw new DataLengthException("input too large for ECNR key.");
        }
        throw new IllegalStateException("not initialised for verifying");
    }
}
