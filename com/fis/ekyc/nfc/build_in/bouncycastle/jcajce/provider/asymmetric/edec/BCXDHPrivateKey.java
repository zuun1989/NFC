package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.XDHPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.XDHPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCXDHPrivateKey implements XDHPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    private final boolean hasPublicKey;
    transient AsymmetricKeyParameter xdhPrivateKey;

    public BCXDHPrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.xdhPrivateKey = asymmetricKeyParameter;
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1OctetString privateKey = privateKeyInfo.getPrivateKey();
        byte[] octets = privateKey.getOctets();
        if (!(octets.length == 32 || octets.length == 56)) {
            privateKey = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey());
        }
        if (EdECObjectIdentifiers.id_X448.equals((ASN1Primitive) privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm())) {
            this.xdhPrivateKey = new X448PrivateKeyParameters(ASN1OctetString.getInstance(privateKey).getOctets(), 0);
        } else {
            this.xdhPrivateKey = new X25519PrivateKeyParameters(ASN1OctetString.getInstance(privateKey).getOctets(), 0);
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
        return this.xdhPrivateKey;
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
        if (this.xdhPrivateKey instanceof X448PrivateKeyParameters) {
            return XDHParameterSpec.X448;
        }
        return XDHParameterSpec.X25519;
    }

    public byte[] getEncoded() {
        try {
            ASN1Set instance = ASN1Set.getInstance(this.attributes);
            PrivateKeyInfo createPrivateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(this.xdhPrivateKey, instance);
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

    public XDHPublicKey getPublicKey() {
        AsymmetricKeyParameter asymmetricKeyParameter = this.xdhPrivateKey;
        if (asymmetricKeyParameter instanceof X448PrivateKeyParameters) {
            return new BCXDHPublicKey((AsymmetricKeyParameter) ((X448PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey());
        }
        return new BCXDHPublicKey((AsymmetricKeyParameter) ((X25519PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey());
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        AsymmetricKeyParameter asymmetricKeyParameter;
        AsymmetricKeyParameter asymmetricKeyParameter2 = this.xdhPrivateKey;
        if (asymmetricKeyParameter2 instanceof X448PrivateKeyParameters) {
            asymmetricKeyParameter = ((X448PrivateKeyParameters) asymmetricKeyParameter2).generatePublicKey();
        } else {
            asymmetricKeyParameter = ((X25519PrivateKeyParameters) asymmetricKeyParameter2).generatePublicKey();
        }
        return Utils.keyToString("Private Key", getAlgorithm(), asymmetricKeyParameter);
    }

    public BCXDHPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.hasPublicKey = privateKeyInfo.hasPublicKey();
        this.attributes = privateKeyInfo.getAttributes() != null ? privateKeyInfo.getAttributes().getEncoded() : null;
        populateFromPrivateKeyInfo(privateKeyInfo);
    }
}
