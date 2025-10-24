package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2mField;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.Permutation;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import java.io.IOException;
import java.security.PrivateKey;

public class BCMcElieceCCA2PrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private McElieceCCA2PrivateKeyParameters params;

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.params = mcElieceCCA2PrivateKeyParameters;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey)) {
            return false;
        }
        BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
        if (getN() != bCMcElieceCCA2PrivateKey.getN() || getK() != bCMcElieceCCA2PrivateKey.getK() || !getField().equals(bCMcElieceCCA2PrivateKey.getField()) || !getGoppaPoly().equals(bCMcElieceCCA2PrivateKey.getGoppaPoly()) || !getP().equals(bCMcElieceCCA2PrivateKey.getP()) || !getH().equals(bCMcElieceCCA2PrivateKey.getH())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), new McElieceCCA2PrivateKey(getN(), getK(), getField(), getGoppaPoly(), getP(), Utils.getDigAlgId(this.params.getDigest()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
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

    public Permutation getP() {
        return this.params.getP();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.params.getQInv();
    }

    public int getT() {
        return this.params.getGoppaPoly().getDegree();
    }

    public int hashCode() {
        return (((((((((this.params.getK() * 37) + this.params.getN()) * 37) + this.params.getField().hashCode()) * 37) + this.params.getGoppaPoly().hashCode()) * 37) + this.params.getP().hashCode()) * 37) + this.params.getH().hashCode();
    }
}
