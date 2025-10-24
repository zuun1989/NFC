package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dsa;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DSAParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;

public class BCDSAPublicKey implements DSAPublicKey {
    private static BigInteger ZERO = BigInteger.valueOf(0);
    private static final long serialVersionUID = 1752452449903495175L;
    private transient DSAParams dsaSpec;
    private transient DSAPublicKeyParameters lwKeyParams;
    private BigInteger y;

    public BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.y = dSAPublicKeySpec.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    private boolean isNotNull(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || DERNull.INSTANCE.equals(aSN1Encodable.toASN1Primitive())) {
            return false;
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(ZERO)) {
            this.dsaSpec = null;
        } else {
            this.dsaSpec = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.dsaSpec;
        if (dSAParams == null) {
            objectOutputStream.writeObject(ZERO);
            return;
        }
        objectOutputStream.writeObject(dSAParams.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
    }

    public DSAPublicKeyParameters engineGetKeyParameters() {
        return this.lwKeyParams;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        if (this.dsaSpec != null) {
            if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() == null || !getParams().getG().equals(dSAPublicKey.getParams().getG()) || !getParams().getP().equals(dSAPublicKey.getParams().getP()) || !getParams().getQ().equals(dSAPublicKey.getParams().getQ())) {
                return false;
            }
            return true;
        } else if (!getY().equals(dSAPublicKey.getY()) || dSAPublicKey.getParams() != null) {
            return false;
        } else {
            return true;
        }
    }

    public String getAlgorithm() {
        return "DSA";
    }

    public byte[] getEncoded() {
        DSAParams dSAParams = this.dsaSpec;
        if (dSAParams == null) {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), (ASN1Encodable) new ASN1Integer(this.y));
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(dSAParams.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).toASN1Primitive()), (ASN1Encodable) new ASN1Integer(this.y));
    }

    public String getFormat() {
        return "X.509";
    }

    public DSAParams getParams() {
        return this.dsaSpec;
    }

    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        if (this.dsaSpec != null) {
            return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
        }
        return getY().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("DSA Public Key [");
        stringBuffer.append(DSAUtil.generateKeyFingerprint(this.y, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.y = dSAPublicKey.getY();
        this.dsaSpec = dSAPublicKey.getParams();
        this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    public BCDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.y = dSAPublicKeyParameters.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeyParameters.getParameters().getP(), dSAPublicKeyParameters.getParameters().getQ(), dSAPublicKeyParameters.getParameters().getG());
        this.lwKeyParams = dSAPublicKeyParameters;
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            if (isNotNull(subjectPublicKeyInfo.getAlgorithm().getParameters())) {
                DSAParameter instance = DSAParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.dsaSpec = new DSAParameterSpec(instance.getP(), instance.getQ(), instance.getG());
            } else {
                this.dsaSpec = null;
            }
            this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }
}
