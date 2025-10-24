package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SPHINCSPlusParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCSPHINCSPlusPublicKey implements PublicKey, SPHINCSPlusKey {
    private static final long serialVersionUID = 1;
    private transient SPHINCSPlusPublicKeyParameters params;

    public BCSPHINCSPlusPublicKey(SPHINCSPlusPublicKeyParameters sPHINCSPlusPublicKeyParameters) {
        this.params = sPHINCSPlusPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.params = (SPHINCSPlusPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
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
        if (obj instanceof BCSPHINCSPlusPublicKey) {
            return Arrays.areEqual(this.params.getEncoded(), ((BCSPHINCSPlusPublicKey) obj).params.getEncoded());
        }
        return false;
    }

    public final String getAlgorithm() {
        return "SPHINCS+";
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

    public SPHINCSPlusParameterSpec getParameterSpec() {
        return SPHINCSPlusParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }

    public BCSPHINCSPlusPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
