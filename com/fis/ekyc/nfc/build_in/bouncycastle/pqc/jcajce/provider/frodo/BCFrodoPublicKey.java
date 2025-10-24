package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.frodo;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.frodo.FrodoPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.FrodoKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.FrodoParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCFrodoPublicKey implements PublicKey, FrodoKey {
    private static final long serialVersionUID = 1;
    private transient FrodoPublicKeyParameters params;

    public BCFrodoPublicKey(FrodoPublicKeyParameters frodoPublicKeyParameters) {
        this.params = frodoPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.params = (FrodoPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
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
        if (obj instanceof BCFrodoPublicKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCFrodoPublicKey) obj).params.getEncoded());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "Frodo";
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

    public FrodoPublicKeyParameters getKeyParams() {
        return this.params;
    }

    public FrodoParameterSpec getParameterSpec() {
        return FrodoParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }

    public BCFrodoPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
