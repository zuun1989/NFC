package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.McEliecePublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import java.io.IOException;
import java.security.PublicKey;

public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private McEliecePublicKeyParameters params;

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.params = mcEliecePublicKeyParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        if (this.params.getN() == bCMcEliecePublicKey.getN() && this.params.getT() == bCMcEliecePublicKey.getT() && this.params.getG().equals(bCMcEliecePublicKey.getG())) {
            return true;
        }
        return false;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), (ASN1Encodable) new McEliecePublicKey(this.params.getN(), this.params.getT(), this.params.getG())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public GF2Matrix getG() {
        return this.params.getG();
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

    public int getT() {
        return this.params.getT();
    }

    public int hashCode() {
        return ((this.params.getN() + (this.params.getT() * 37)) * 37) + this.params.getG().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.params.getN() + "\n") + " error correction capability: " + this.params.getT() + "\n") + " generator matrix           : " + this.params.getG();
    }
}
