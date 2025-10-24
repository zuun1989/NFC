package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.ElGamalParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ElGamalPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ElGamalPublicKeySpec;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class BCElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private transient ElGamalParameterSpec elSpec;
    private BigInteger y;

    public BCElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        this.y = elGamalPublicKeySpec.getY();
        this.elSpec = new ElGamalParameterSpec(elGamalPublicKeySpec.getParams().getP(), elGamalPublicKeySpec.getParams().getG());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.elSpec.getP());
        objectOutputStream.writeObject(this.elSpec.getG());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (!getY().equals(dHPublicKey.getY()) || !getParams().getG().equals(dHPublicKey.getParams().getG()) || !getParams().getP().equals(dHPublicKey.getParams().getP()) || getParams().getL() != dHPublicKey.getParams().getL()) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "ElGamal";
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), (ASN1Encodable) new ASN1Integer(this.y)).getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.y = dHPublicKeySpec.getY();
        this.elSpec = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.y = elGamalPublicKey.getY();
        this.elSpec = elGamalPublicKey.getParameters();
    }

    public BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.y = dHPublicKey.getY();
        this.elSpec = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.y = elGamalPublicKeyParameters.getY();
        this.elSpec = new ElGamalParameterSpec(elGamalPublicKeyParameters.getParameters().getP(), elGamalPublicKeyParameters.getParameters().getG());
    }

    public BCElGamalPublicKey(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        this.y = bigInteger;
        this.elSpec = elGamalParameterSpec;
    }

    public BCElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ElGamalParameter instance = ElGamalParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
        try {
            this.y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            this.elSpec = new ElGamalParameterSpec(instance.getP(), instance.getG());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}
