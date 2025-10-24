package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.EdDSAPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCEdDSAPrivateKey implements EdDSAPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    transient AsymmetricKeyParameter eddsaPrivateKey;
    private final boolean hasPublicKey;

    public BCEdDSAPrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.eddsaPrivateKey = asymmetricKeyParameter;
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1Encodable parsePrivateKey = privateKeyInfo.parsePrivateKey();
        if (EdECObjectIdentifiers.id_Ed448.equals((ASN1Primitive) privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm())) {
            this.eddsaPrivateKey = new Ed448PrivateKeyParameters(ASN1OctetString.getInstance(parsePrivateKey).getOctets(), 0);
        } else {
            this.eddsaPrivateKey = new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(parsePrivateKey).getOctets(), 0);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPrivateKeyInfo(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public AsymmetricKeyParameter engineGetKeyParameters() {
        return this.eddsaPrivateKey;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrivateKey)) {
            return false;
        }
        return Arrays.areEqual(((PrivateKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        if (this.eddsaPrivateKey instanceof Ed448PrivateKeyParameters) {
            return EdDSAParameterSpec.Ed448;
        }
        return EdDSAParameterSpec.Ed25519;
    }

    public byte[] getEncoded() {
        try {
            ASN1Set instance = ASN1Set.getInstance(this.attributes);
            PrivateKeyInfo createPrivateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(this.eddsaPrivateKey, instance);
            if (!this.hasPublicKey || Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.pkcs8.v1_info_only")) {
                return new PrivateKeyInfo(createPrivateKeyInfo.getPrivateKeyAlgorithm(), createPrivateKeyInfo.parsePrivateKey(), instance).getEncoded();
            }
            return createPrivateKeyInfo.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public EdDSAPublicKey getPublicKey() {
        AsymmetricKeyParameter asymmetricKeyParameter = this.eddsaPrivateKey;
        if (asymmetricKeyParameter instanceof Ed448PrivateKeyParameters) {
            return new BCEdDSAPublicKey((AsymmetricKeyParameter) ((Ed448PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey());
        }
        return new BCEdDSAPublicKey((AsymmetricKeyParameter) ((Ed25519PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey());
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        AsymmetricKeyParameter asymmetricKeyParameter;
        AsymmetricKeyParameter asymmetricKeyParameter2 = this.eddsaPrivateKey;
        if (asymmetricKeyParameter2 instanceof Ed448PrivateKeyParameters) {
            asymmetricKeyParameter = ((Ed448PrivateKeyParameters) asymmetricKeyParameter2).generatePublicKey();
        } else {
            asymmetricKeyParameter = ((Ed25519PrivateKeyParameters) asymmetricKeyParameter2).generatePublicKey();
        }
        return Utils.keyToString("Private Key", getAlgorithm(), asymmetricKeyParameter);
    }

    public BCEdDSAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.hasPublicKey = privateKeyInfo.hasPublicKey();
        this.attributes = privateKeyInfo.getAttributes() != null ? privateKeyInfo.getAttributes().getEncoded() : null;
        populateFromPrivateKeyInfo(privateKeyInfo);
    }
}
