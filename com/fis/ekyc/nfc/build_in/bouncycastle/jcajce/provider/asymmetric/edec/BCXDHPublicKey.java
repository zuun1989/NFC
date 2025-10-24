package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.interfaces.XDHPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public class BCXDHPublicKey implements XDHPublicKey {
    static final long serialVersionUID = 1;
    transient AsymmetricKeyParameter xdhPublicKey;

    public BCXDHPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.xdhPublicKey = asymmetricKeyParameter;
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (EdECObjectIdentifiers.id_X448.equals((ASN1Primitive) subjectPublicKeyInfo.getAlgorithm().getAlgorithm())) {
            this.xdhPublicKey = new X448PublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getOctets(), 0);
        } else {
            this.xdhPublicKey = new X25519PublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getOctets(), 0);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public AsymmetricKeyParameter engineGetKeyParameters() {
        return this.xdhPublicKey;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PublicKey)) {
            return false;
        }
        return Arrays.areEqual(((PublicKey) obj).getEncoded(), getEncoded());
    }

    public String getAlgorithm() {
        if (this.xdhPublicKey instanceof X448PublicKeyParameters) {
            return XDHParameterSpec.X448;
        }
        return XDHParameterSpec.X25519;
    }

    public byte[] getEncoded() {
        if (this.xdhPublicKey instanceof X448PublicKeyParameters) {
            byte[] bArr = KeyFactorySpi.x448Prefix;
            byte[] bArr2 = new byte[(bArr.length + 56)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            ((X448PublicKeyParameters) this.xdhPublicKey).encode(bArr2, bArr.length);
            return bArr2;
        }
        byte[] bArr3 = KeyFactorySpi.x25519Prefix;
        byte[] bArr4 = new byte[(bArr3.length + 32)];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        ((X25519PublicKeyParameters) this.xdhPublicKey).encode(bArr4, bArr3.length);
        return bArr4;
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        return Utils.keyToString("Public Key", getAlgorithm(), this.xdhPublicKey);
    }

    public BCXDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCXDHPublicKey(byte[] bArr, byte[] bArr2) throws InvalidKeySpecException {
        int length = bArr.length;
        if (!Utils.isValidPrefix(bArr, bArr2)) {
            throw new InvalidKeySpecException("raw key data not recognised");
        } else if (bArr2.length - length == 56) {
            this.xdhPublicKey = new X448PublicKeyParameters(bArr2, length);
        } else if (bArr2.length - length == 32) {
            this.xdhPublicKey = new X25519PublicKeyParameters(bArr2, length);
        } else {
            throw new InvalidKeySpecException("raw key data not recognised");
        }
    }
}
