package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.SABERKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SABERParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCSABERPublicKey implements PublicKey, SABERKey {
    private static final long serialVersionUID = 1;
    private transient SABERPublicKeyParameters params;

    public BCSABERPublicKey(SABERPublicKeyParameters sABERPublicKeyParameters) {
        this.params = sABERPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.params = (SABERPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSABERPublicKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCSABERPublicKey) obj).params.getEncoded());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "SABER";
    }

    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public SABERPublicKeyParameters getKeyParams() {
        return this.params;
    }

    public SABERParameterSpec getParameterSpec() {
        return SABERParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }

    public BCSABERPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
