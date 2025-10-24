package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class BCRSAPublicKey implements RSAPublicKey {
    static final AlgorithmIdentifier DEFAULT_ALGORITHM_IDENTIFIER = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
    static final long serialVersionUID = 2675817738516720772L;
    private transient AlgorithmIdentifier algorithmIdentifier;
    private BigInteger modulus;
    private BigInteger publicExponent;
    private transient RSAKeyParameters rsaPublicKey;

    public BCRSAPublicKey(RSAKeyParameters rSAKeyParameters) {
        this(DEFAULT_ALGORITHM_IDENTIFIER, rSAKeyParameters);
    }

    private void populateFromPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPublicKey instance = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            this.algorithmIdentifier = subjectPublicKeyInfo.getAlgorithm();
            this.modulus = instance.getModulus();
            this.publicExponent = instance.getPublicExponent();
            this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            this.algorithmIdentifier = AlgorithmIdentifier.getInstance(objectInputStream.readObject());
        } catch (Exception unused) {
            this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        }
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (!this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER)) {
            objectOutputStream.writeObject(this.algorithmIdentifier.getEncoded());
        }
    }

    public RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPublicKey;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        if (!getModulus().equals(rSAPublicKey.getModulus()) || !getPublicExponent().equals(rSAPublicKey.getPublicExponent())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        if (this.algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return "RSASSA-PSS";
        }
        return "RSA";
    }

    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(this.algorithmIdentifier, (ASN1Encodable) new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    public String getFormat() {
        return "X.509";
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("RSA Public Key [");
        stringBuffer.append(RSAUtil.generateKeyFingerprint(getModulus()));
        stringBuffer.append("]");
        stringBuffer.append(",[");
        stringBuffer.append(RSAUtil.generateExponentFingerprint(getPublicExponent()));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("        modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public BCRSAPublicKey(AlgorithmIdentifier algorithmIdentifier2, RSAKeyParameters rSAKeyParameters) {
        this.algorithmIdentifier = algorithmIdentifier2;
        this.modulus = rSAKeyParameters.getModulus();
        this.publicExponent = rSAKeyParameters.getExponent();
        this.rsaPublicKey = rSAKeyParameters;
    }

    public BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = rSAPublicKeySpec.getModulus();
        this.publicExponent = rSAPublicKeySpec.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = rSAPublicKey.getModulus();
        this.publicExponent = rSAPublicKey.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPublicKeyInfo(subjectPublicKeyInfo);
    }
}
