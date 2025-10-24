package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters {
    public IntegerPolynomial h;

    public NTRUEncryptionPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.h = integerPolynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUEncryptionPublicKeyParameters)) {
            return false;
        }
        NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters = (NTRUEncryptionPublicKeyParameters) obj;
        IntegerPolynomial integerPolynomial = this.h;
        if (integerPolynomial == null) {
            if (nTRUEncryptionPublicKeyParameters.h != null) {
                return false;
            }
        } else if (!integerPolynomial.equals(nTRUEncryptionPublicKeyParameters.h)) {
            return false;
        }
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters == null) {
            if (nTRUEncryptionPublicKeyParameters.params != null) {
                return false;
            }
        } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPublicKeyParameters.params)) {
            return false;
        }
        return true;
    }

    public byte[] getEncoded() {
        return this.h.toBinary(this.params.q);
    }

    public int hashCode() {
        int i;
        IntegerPolynomial integerPolynomial = this.h;
        int i2 = 0;
        if (integerPolynomial == null) {
            i = 0;
        } else {
            i = integerPolynomial.hashCode();
        }
        int i3 = (i + 31) * 31;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters != null) {
            i2 = nTRUEncryptionParameters.hashCode();
        }
        return i3 + i2;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPublicKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.h = IntegerPolynomial.fromBinary(bArr, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
    }

    public NTRUEncryptionPublicKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        super(false, nTRUEncryptionParameters);
        this.h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
    }
}
