package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCSphincs256PublicKey implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    private transient SPHINCSPublicKeyParameters params;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.params = sPHINCSPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.treeDigest = SPHINCS256KeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.params = (SPHINCSPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
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
        if (!(obj instanceof BCSphincs256PublicKey)) {
            return false;
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
        if (!this.treeDigest.equals((ASN1Primitive) bCSphincs256PublicKey.treeDigest) || !Arrays.areEqual(this.params.getKeyData(), bCSphincs256PublicKey.params.getKeyData())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        try {
            if (this.params.getTreeDigest() != null) {
                subjectPublicKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params);
            } else {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), this.params.getKeyData());
            }
            return subjectPublicKeyInfo.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public byte[] getKeyData() {
        return this.params.getKeyData();
    }

    public CipherParameters getKeyParams() {
        return this.params;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.params.getKeyData()) * 37);
    }

    public BCSphincs256PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
