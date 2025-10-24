package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.DHParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.DHDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private DHParameterSpec dhSpec;
    private SubjectPublicKeyInfo info;
    private BigInteger y;

    public JCEDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.y = dHPublicKeySpec.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    private boolean isPKCSParam(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            return true;
        }
        if (aSN1Sequence.size() > 3) {
            return false;
        }
        if (ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf((long) ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().bitLength())) > 0) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.y = (BigInteger) objectInputStream.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }

    public String getAlgorithm() {
        return "DH";
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.info;
        if (subjectPublicKeyInfo != null) {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), (ASN1Encodable) new ASN1Integer(this.y));
    }

    public String getFormat() {
        return "X.509";
    }

    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    public BigInteger getY() {
        return this.y;
    }

    public JCEDHPublicKey(DHPublicKey dHPublicKey) {
        this.y = dHPublicKey.getY();
        this.dhSpec = dHPublicKey.getParams();
    }

    public JCEDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.y = dHPublicKeyParameters.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeyParameters.getParameters().getP(), dHPublicKeyParameters.getParameters().getG(), dHPublicKeyParameters.getParameters().getL());
    }

    public JCEDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.y = bigInteger;
        this.dhSpec = dHParameterSpec;
    }

    public JCEDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.info = subjectPublicKeyInfo;
        try {
            this.y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            ASN1Sequence instance = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithmId().getParameters());
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithmId().getAlgorithm();
            if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement) || isPKCSParam(instance)) {
                DHParameter instance2 = DHParameter.getInstance(instance);
                if (instance2.getL() != null) {
                    this.dhSpec = new DHParameterSpec(instance2.getP(), instance2.getG(), instance2.getL().intValue());
                } else {
                    this.dhSpec = new DHParameterSpec(instance2.getP(), instance2.getG());
                }
            } else if (algorithm.equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
                DHDomainParameters instance3 = DHDomainParameters.getInstance(instance);
                this.dhSpec = new DHParameterSpec(instance3.getP().getValue(), instance3.getG().getValue());
            } else {
                throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }
}
