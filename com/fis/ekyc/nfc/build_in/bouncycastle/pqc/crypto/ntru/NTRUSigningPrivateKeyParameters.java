package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ntru;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.Polynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {
    private List<Basis> bases;
    private NTRUSigningPublicKeyParameters publicKey;

    public NTRUSigningPrivateKeyParameters(byte[] bArr, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        this((InputStream) new ByteArrayInputStream(bArr), nTRUSigningKeyGenerationParameters);
    }

    private void add(Basis basis) {
        this.bases.add(basis);
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = (NTRUSigningPrivateKeyParameters) obj;
        List<Basis> list = this.bases;
        if (list == null) {
            z = true;
        } else {
            z = false;
        }
        if (nTRUSigningPrivateKeyParameters.bases == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            return false;
        }
        if (list == null) {
            return true;
        }
        if (list.size() != nTRUSigningPrivateKeyParameters.bases.size()) {
            return false;
        }
        for (int i = 0; i < this.bases.size(); i++) {
            Basis basis = this.bases.get(i);
            Basis basis2 = nTRUSigningPrivateKeyParameters.bases.get(i);
            if (!basis.f.equals(basis2.f) || !basis.fPrime.equals(basis2.fPrime)) {
                return false;
            }
            if ((i != 0 && !basis.h.equals(basis2.h)) || !basis.params.equals(basis2.params)) {
                return false;
            }
        }
        return true;
    }

    public Basis getBasis(int i) {
        return this.bases.get(i);
    }

    public byte[] getEncoded() throws IOException {
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < this.bases.size(); i++) {
            Basis basis = this.bases.get(i);
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            basis.encode(byteArrayOutputStream, z);
        }
        byteArrayOutputStream.write(this.publicKey.getEncoded());
        return byteArrayOutputStream.toByteArray();
    }

    public NTRUSigningPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        List<Basis> list = this.bases;
        if (list == null) {
            return 31;
        }
        int hashCode = 31 + list.hashCode();
        for (Basis hashCode2 : this.bases) {
            hashCode += hashCode2.hashCode();
        }
        return hashCode;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPrivateKeyParameters(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        super(true);
        this.bases = new ArrayList();
        int i = 0;
        while (i <= nTRUSigningKeyGenerationParameters.B) {
            add(new Basis(inputStream, nTRUSigningKeyGenerationParameters, i != 0));
            i++;
        }
        this.publicKey = new NTRUSigningPublicKeyParameters(inputStream, nTRUSigningKeyGenerationParameters.getSigningParameters());
    }

    public static class Basis {
        public Polynomial f;
        public Polynomial fPrime;
        public IntegerPolynomial h;
        NTRUSigningKeyGenerationParameters params;

        public Basis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f = polynomial;
            this.fPrime = polynomial2;
            this.h = integerPolynomial;
            this.params = nTRUSigningKeyGenerationParameters;
        }

        private byte[] getEncoded(Polynomial polynomial) {
            if (polynomial instanceof ProductFormPolynomial) {
                return ((ProductFormPolynomial) polynomial).toBinary();
            }
            return polynomial.toIntegerPolynomial().toBinary3Tight();
        }

        public void encode(OutputStream outputStream, boolean z) throws IOException {
            int i = this.params.q;
            outputStream.write(getEncoded(this.f));
            if (this.params.basisType == 0) {
                IntegerPolynomial integerPolynomial = this.fPrime.toIntegerPolynomial();
                int i2 = 0;
                while (true) {
                    int[] iArr = integerPolynomial.coeffs;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iArr[i2] = iArr[i2] + (i / 2);
                    i2++;
                }
                outputStream.write(integerPolynomial.toBinary(i));
            } else {
                outputStream.write(getEncoded(this.fPrime));
            }
            if (z) {
                outputStream.write(this.h.toBinary(i));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Basis)) {
                return false;
            }
            Basis basis = (Basis) obj;
            Polynomial polynomial = this.f;
            if (polynomial == null) {
                if (basis.f != null) {
                    return false;
                }
            } else if (!polynomial.equals(basis.f)) {
                return false;
            }
            Polynomial polynomial2 = this.fPrime;
            if (polynomial2 == null) {
                if (basis.fPrime != null) {
                    return false;
                }
            } else if (!polynomial2.equals(basis.fPrime)) {
                return false;
            }
            IntegerPolynomial integerPolynomial = this.h;
            if (integerPolynomial == null) {
                if (basis.h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(basis.h)) {
                return false;
            }
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            if (nTRUSigningKeyGenerationParameters == null) {
                if (basis.params != null) {
                    return false;
                }
            } else if (!nTRUSigningKeyGenerationParameters.equals(basis.params)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            Polynomial polynomial = this.f;
            int i4 = 0;
            if (polynomial == null) {
                i = 0;
            } else {
                i = polynomial.hashCode();
            }
            int i5 = (i + 31) * 31;
            Polynomial polynomial2 = this.fPrime;
            if (polynomial2 == null) {
                i2 = 0;
            } else {
                i2 = polynomial2.hashCode();
            }
            int i6 = (i5 + i2) * 31;
            IntegerPolynomial integerPolynomial = this.h;
            if (integerPolynomial == null) {
                i3 = 0;
            } else {
                i3 = integerPolynomial.hashCode();
            }
            int i7 = (i6 + i3) * 31;
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            if (nTRUSigningKeyGenerationParameters != null) {
                i4 = nTRUSigningKeyGenerationParameters.hashCode();
            }
            return i7 + i4;
        }

        public Basis(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters, boolean z) throws IOException {
            int i = nTRUSigningKeyGenerationParameters.N;
            int i2 = nTRUSigningKeyGenerationParameters.q;
            int i3 = nTRUSigningKeyGenerationParameters.d1;
            int i4 = nTRUSigningKeyGenerationParameters.d2;
            int i5 = nTRUSigningKeyGenerationParameters.d3;
            boolean z2 = nTRUSigningKeyGenerationParameters.sparse;
            this.params = nTRUSigningKeyGenerationParameters;
            if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.f = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, i);
                this.f = z2 ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
            }
            if (nTRUSigningKeyGenerationParameters.basisType == 0) {
                IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(inputStream, i, i2);
                int i6 = 0;
                while (true) {
                    int[] iArr = fromBinary.coeffs;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    iArr[i6] = iArr[i6] - (i2 / 2);
                    i6++;
                }
                this.fPrime = fromBinary;
            } else if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.fPrime = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                this.fPrime = IntegerPolynomial.fromBinary3Tight(inputStream, i);
            }
            if (z) {
                this.h = IntegerPolynomial.fromBinary(inputStream, i, i2);
            }
        }
    }

    public NTRUSigningPrivateKeyParameters(List<Basis> list, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        super(true);
        this.bases = new ArrayList(list);
        this.publicKey = nTRUSigningPublicKeyParameters;
    }
}
