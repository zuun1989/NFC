package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;
    private transient NHPublicKeyParameters params;

    public BCNHPublicKey(NHPublicKeyParameters nHPublicKeyParameters) {
        this.params = nHPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.params = (NHPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
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
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return Arrays.areEqual(this.params.getPubData(), ((BCNHPublicKey) obj).params.getPubData());
    }

    public final String getAlgorithm() {
        return "NH";
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

    public CipherParameters getKeyParams() {
        return this.params;
    }

    public byte[] getPublicData() {
        return this.params.getPubData();
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getPubData());
    }

    public BCNHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
