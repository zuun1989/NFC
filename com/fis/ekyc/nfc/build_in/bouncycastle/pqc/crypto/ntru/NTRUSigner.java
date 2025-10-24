package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import java.nio.ByteBuffer;

public class NTRUSigner {
    private Digest hashAlg;
    private NTRUSigningParameters params;
    private NTRUSigningPrivateKeyParameters signingKeyPair;
    private NTRUSigningPublicKeyParameters verificationKey;

    public NTRUSigner(NTRUSigningParameters nTRUSigningParameters) {
        this.params = nTRUSigningParameters;
    }

    private IntegerPolynomial sign(IntegerPolynomial integerPolynomial, NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i = nTRUSigningParameters.N;
        int i2 = nTRUSigningParameters.q;
        NTRUSigningPublicKeyParameters publicKey = nTRUSigningPrivateKeyParameters.getPublicKey();
        IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(i);
        for (int i3 = nTRUSigningParameters.B; i3 >= 1; i3--) {
            Polynomial polynomial = nTRUSigningPrivateKeyParameters.getBasis(i3).f;
            Polynomial polynomial2 = nTRUSigningPrivateKeyParameters.getBasis(i3).fPrime;
            IntegerPolynomial mult = polynomial.mult(integerPolynomial);
            mult.div(i2);
            IntegerPolynomial mult2 = polynomial2.mult(mult);
            IntegerPolynomial mult3 = polynomial2.mult(integerPolynomial);
            mult3.div(i2);
            mult2.sub(polynomial.mult(mult3));
            integerPolynomial2.add(mult2);
            IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) nTRUSigningPrivateKeyParameters.getBasis(i3).h.clone();
            if (i3 > 1) {
                integerPolynomial3.sub(nTRUSigningPrivateKeyParameters.getBasis(i3 - 1).h);
            } else {
                integerPolynomial3.sub(publicKey.h);
            }
            integerPolynomial = mult2.mult(integerPolynomial3, i2);
        }
        Polynomial polynomial3 = nTRUSigningPrivateKeyParameters.getBasis(0).f;
        Polynomial polynomial4 = nTRUSigningPrivateKeyParameters.getBasis(0).fPrime;
        IntegerPolynomial mult4 = polynomial3.mult(integerPolynomial);
        mult4.div(i2);
        IntegerPolynomial mult5 = polynomial4.mult(mult4);
        IntegerPolynomial mult6 = polynomial4.mult(integerPolynomial);
        mult6.div(i2);
        mult5.sub(polynomial3.mult(mult6));
        integerPolynomial2.add(mult5);
        integerPolynomial2.modPositive(i2);
        return integerPolynomial2;
    }

    private byte[] signHash(byte[] bArr, NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters) {
        IntegerPolynomial createMsgRep;
        IntegerPolynomial sign;
        NTRUSigningPublicKeyParameters publicKey = nTRUSigningPrivateKeyParameters.getPublicKey();
        int i = 0;
        do {
            i++;
            if (i <= this.params.signFailTolerance) {
                createMsgRep = createMsgRep(bArr, i);
                sign = sign(createMsgRep, nTRUSigningPrivateKeyParameters);
            } else {
                throw new IllegalStateException("Signing failed: too many retries (max=" + this.params.signFailTolerance + ")");
            }
        } while (!verify(createMsgRep, sign, publicKey.h));
        byte[] binary = sign.toBinary(this.params.q);
        ByteBuffer allocate = ByteBuffer.allocate(binary.length + 4);
        allocate.put(binary);
        allocate.putInt(i);
        return allocate.array();
    }

    private boolean verify(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i = nTRUSigningParameters.q;
        double d = nTRUSigningParameters.normBoundSq;
        double d2 = nTRUSigningParameters.betaSq;
        IntegerPolynomial mult = integerPolynomial3.mult(integerPolynomial2, i);
        mult.sub(integerPolynomial);
        if (((double) ((long) (((double) integerPolynomial2.centeredNormSq(i)) + (d2 * ((double) mult.centeredNormSq(i)))))) <= d) {
            return true;
        }
        return false;
    }

    private boolean verifyHash(byte[] bArr, byte[] bArr2, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        byte[] bArr3 = new byte[(bArr2.length - 4)];
        wrap.get(bArr3);
        NTRUSigningParameters nTRUSigningParameters = this.params;
        return verify(createMsgRep(bArr, wrap.getInt()), IntegerPolynomial.fromBinary(bArr3, nTRUSigningParameters.N, nTRUSigningParameters.q), nTRUSigningPublicKeyParameters.h);
    }

    public IntegerPolynomial createMsgRep(byte[] bArr, int i) {
        NTRUSigningParameters nTRUSigningParameters = this.params;
        int i2 = nTRUSigningParameters.N;
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(nTRUSigningParameters.q);
        int i3 = 31 - numberOfLeadingZeros;
        int i4 = (38 - numberOfLeadingZeros) / 8;
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i2);
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
        allocate.put(bArr);
        allocate.putInt(i);
        NTRUSignerPrng nTRUSignerPrng = new NTRUSignerPrng(allocate.array(), this.params.hashAlg);
        for (int i5 = 0; i5 < i2; i5++) {
            byte[] nextBytes = nTRUSignerPrng.nextBytes(i4);
            int i6 = (i4 * 8) - i3;
            nextBytes[nextBytes.length - 1] = (byte) ((nextBytes[nextBytes.length - 1] >> i6) << i6);
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.put(nextBytes);
            allocate2.rewind();
            integerPolynomial.coeffs[i5] = Integer.reverseBytes(allocate2.getInt());
        }
        return integerPolynomial;
    }

    public byte[] generateSignature() {
        Digest digest = this.hashAlg;
        if (digest == null || this.signingKeyPair == null) {
            throw new IllegalStateException("Call initSign first!");
        }
        byte[] bArr = new byte[digest.getDigestSize()];
        this.hashAlg.doFinal(bArr, 0);
        return signHash(bArr, this.signingKeyPair);
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.signingKeyPair = (NTRUSigningPrivateKeyParameters) cipherParameters;
        } else {
            this.verificationKey = (NTRUSigningPublicKeyParameters) cipherParameters;
        }
        Digest digest = this.params.hashAlg;
        this.hashAlg = digest;
        digest.reset();
    }

    public void update(byte b) {
        Digest digest = this.hashAlg;
        if (digest != null) {
            digest.update(b);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }

    public boolean verifySignature(byte[] bArr) {
        Digest digest = this.hashAlg;
        if (digest == null || this.verificationKey == null) {
            throw new IllegalStateException("Call initVerify first!");
        }
        byte[] bArr2 = new byte[digest.getDigestSize()];
        this.hashAlg.doFinal(bArr2, 0);
        return verifyHash(bArr2, bArr, this.verificationKey);
    }

    public void update(byte[] bArr, int i, int i2) {
        Digest digest = this.hashAlg;
        if (digest != null) {
            digest.update(bArr, i, i2);
            return;
        }
        throw new IllegalStateException("Call initSign or initVerify first!");
    }
}
