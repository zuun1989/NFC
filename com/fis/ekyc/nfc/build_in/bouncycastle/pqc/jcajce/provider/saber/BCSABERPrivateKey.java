package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.SABERKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SABERParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCSABERPrivateKey implements PrivateKey, SABERKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient SABERPrivateKeyParameters params;

    public BCSABERPrivateKey(SABERPrivateKeyParameters sABERPrivateKeyParameters) {
        this.params = sABERPrivateKeyParameters;
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.getAttributes();
        this.params = (SABERPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSABERPrivateKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCSABERPrivateKey) obj).params.getEncoded());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "SABER";
    }

    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public SABERPrivateKeyParameters getKeyParams() {
        return this.params;
    }

    public SABERParameterSpec getParameterSpec() {
        return SABERParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }

    public BCSABERPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }
}
