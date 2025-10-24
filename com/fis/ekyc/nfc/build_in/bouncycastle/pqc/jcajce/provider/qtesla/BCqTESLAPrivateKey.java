package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.qtesla;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCqTESLAPrivateKey implements PrivateKey, QTESLAKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient QTESLAPrivateKeyParameters keyParams;

    public BCqTESLAPrivateKey(QTESLAPrivateKeyParameters qTESLAPrivateKeyParameters) {
        this.keyParams = qTESLAPrivateKeyParameters;
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.getAttributes();
        this.keyParams = (QTESLAPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
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
        if (!(obj instanceof BCqTESLAPrivateKey)) {
            return false;
        }
        BCqTESLAPrivateKey bCqTESLAPrivateKey = (BCqTESLAPrivateKey) obj;
        if (this.keyParams.getSecurityCategory() != bCqTESLAPrivateKey.keyParams.getSecurityCategory() || !Arrays.areEqual(this.keyParams.getSecret(), bCqTESLAPrivateKey.keyParams.getSecret())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return QTESLASecurityCategory.getName(this.keyParams.getSecurityCategory());
    }

    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.keyParams, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public QTESLAParameterSpec getParams() {
        return new QTESLAParameterSpec(getAlgorithm());
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getSecret()) * 37);
    }

    public BCqTESLAPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }
}
