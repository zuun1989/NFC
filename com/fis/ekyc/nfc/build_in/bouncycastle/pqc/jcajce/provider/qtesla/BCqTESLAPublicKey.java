package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCqTESLAPublicKey implements PublicKey, QTESLAKey {
    private static final long serialVersionUID = 1;
    private transient QTESLAPublicKeyParameters keyParams;

    public BCqTESLAPublicKey(QTESLAPublicKeyParameters qTESLAPublicKeyParameters) {
        this.keyParams = qTESLAPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.keyParams = (QTESLAPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
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
        if (!(obj instanceof BCqTESLAPublicKey)) {
            return false;
        }
        BCqTESLAPublicKey bCqTESLAPublicKey = (BCqTESLAPublicKey) obj;
        if (this.keyParams.getSecurityCategory() != bCqTESLAPublicKey.keyParams.getSecurityCategory() || !Arrays.areEqual(this.keyParams.getPublicData(), bCqTESLAPublicKey.keyParams.getPublicData())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return QTESLASecurityCategory.getName(this.keyParams.getSecurityCategory());
    }

    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public QTESLAParameterSpec getParams() {
        return new QTESLAParameterSpec(getAlgorithm());
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getPublicData()) * 37);
    }

    public BCqTESLAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
