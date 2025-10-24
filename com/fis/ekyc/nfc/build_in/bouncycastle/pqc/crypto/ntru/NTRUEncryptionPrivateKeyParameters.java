package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NTRUEncryptionPrivateKeyParameters extends NTRUEncryptionKeyParameters {
    public IntegerPolynomial fp;
    public IntegerPolynomial h;
    public Polynomial t;

    public NTRUEncryptionPrivateKeyParameters(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(true, nTRUEncryptionParameters);
        this.h = integerPolynomial;
        this.t = polynomial;
        this.fp = integerPolynomial2;
    }

    private void init() {
        if (this.params.fastFp) {
            IntegerPolynomial integerPolynomial = new IntegerPolynomial(this.params.N);
            this.fp = integerPolynomial;
            integerPolynomial.coeffs[0] = 1;
            return;
        }
        this.fp = this.t.toIntegerPolynomial().invertF3();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUEncryptionPrivateKeyParameters)) {
            return false;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) obj;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters == null) {
            if (nTRUEncryptionPrivateKeyParameters.params != null) {
                return false;
            }
        } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPrivateKeyParameters.params)) {
            return false;
        }
        Polynomial polynomial = this.t;
        if (polynomial == null) {
            if (nTRUEncryptionPrivateKeyParameters.t != null) {
                return false;
            }
        } else if (!polynomial.equals(nTRUEncryptionPrivateKeyParameters.t)) {
            return false;
        }
        if (!this.h.equals(nTRUEncryptionPrivateKeyParameters.h)) {
            return false;
        }
        return true;
    }

    public byte[] getEncoded() {
        byte[] bArr;
        byte[] binary = this.h.toBinary(this.params.q);
        Polynomial polynomial = this.t;
        if (polynomial instanceof ProductFormPolynomial) {
            bArr = ((ProductFormPolynomial) polynomial).toBinary();
        } else {
            bArr = polynomial.toIntegerPolynomial().toBinary3Tight();
        }
        byte[] bArr2 = new byte[(binary.length + bArr.length)];
        System.arraycopy(binary, 0, bArr2, 0, binary.length);
        System.arraycopy(bArr, 0, bArr2, binary.length, bArr.length);
        return bArr2;
    }

    public int hashCode() {
        int i;
        int i2;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int i3 = 0;
        if (nTRUEncryptionParameters == null) {
            i = 0;
        } else {
            i = nTRUEncryptionParameters.hashCode();
        }
        int i4 = (i + 31) * 31;
        Polynomial polynomial = this.t;
        if (polynomial == null) {
            i2 = 0;
        } else {
            i2 = polynomial.hashCode();
        }
        int i5 = (i4 + i2) * 31;
        IntegerPolynomial integerPolynomial = this.h;
        if (integerPolynomial != null) {
            i3 = integerPolynomial.hashCode();
        }
        return i5 + i3;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPrivateKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        this((InputStream) new ByteArrayInputStream(bArr), nTRUEncryptionParameters);
    }

    public NTRUEncryptionPrivateKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        super(true, nTRUEncryptionParameters);
        if (nTRUEncryptionParameters.polyType == 1) {
            int i = nTRUEncryptionParameters.N;
            int i2 = nTRUEncryptionParameters.df1;
            int i3 = nTRUEncryptionParameters.df2;
            int i4 = nTRUEncryptionParameters.df3;
            int i5 = nTRUEncryptionParameters.fastFp ? i4 : i4 - 1;
            this.h = IntegerPolynomial.fromBinary(inputStream, i, nTRUEncryptionParameters.q);
            this.t = ProductFormPolynomial.fromBinary(inputStream, i, i2, i3, i4, i5);
        } else {
            this.h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
            IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, nTRUEncryptionParameters.N);
            this.t = nTRUEncryptionParameters.sparse ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
        }
        init();
    }
}
