package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2mField;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.Permutation;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import java.security.PrivateKey;

public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    private McEliecePrivateKeyParameters params;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.params = mcEliecePrivateKeyParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        if (getN() != bCMcEliecePrivateKey.getN() || getK() != bCMcEliecePrivateKey.getK() || !getField().equals(bCMcEliecePrivateKey.getField()) || !getGoppaPoly().equals(bCMcEliecePrivateKey.getGoppaPoly()) || !getSInv().equals(bCMcEliecePrivateKey.getSInv()) || !getP1().equals(bCMcEliecePrivateKey.getP1()) || !getP2().equals(bCMcEliecePrivateKey.getP2())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r9 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.McEliecePrivateKey r8 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.McEliecePrivateKey
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            int r1 = r0.getN()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            int r2 = r0.getK()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2mField r3 = r0.getField()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM r4 = r0.getGoppaPoly()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.Permutation r5 = r0.getP1()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.Permutation r6 = r0.getP2()
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters r0 = r9.params
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2Matrix r7 = r0.getSInv()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x0041 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers.mcEliece     // Catch:{ IOException -> 0x0041 }
            r1.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r2)     // Catch:{ IOException -> 0x0041 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0041 }
            r2.<init>(r1, r8)     // Catch:{ IOException -> 0x0041 }
            byte[] r0 = r2.getEncoded()     // Catch:{  }
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey.getEncoded():byte[]");
    }

    public GF2mField getField() {
        return this.params.getField();
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.params.getGoppaPoly();
    }

    public GF2Matrix getH() {
        return this.params.getH();
    }

    public int getK() {
        return this.params.getK();
    }

    public AsymmetricKeyParameter getKeyParams() {
        return this.params;
    }

    public int getN() {
        return this.params.getN();
    }

    public Permutation getP1() {
        return this.params.getP1();
    }

    public Permutation getP2() {
        return this.params.getP2();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.params.getQInv();
    }

    public GF2Matrix getSInv() {
        return this.params.getSInv();
    }

    public int hashCode() {
        return (((((((((((this.params.getK() * 37) + this.params.getN()) * 37) + this.params.getField().hashCode()) * 37) + this.params.getGoppaPoly().hashCode()) * 37) + this.params.getP1().hashCode()) * 37) + this.params.getP2().hashCode()) * 37) + this.params.getSInv().hashCode();
    }
}
