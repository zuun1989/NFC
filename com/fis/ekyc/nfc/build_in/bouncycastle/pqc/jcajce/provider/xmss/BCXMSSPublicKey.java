package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.XMSSKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

public class BCXMSSPublicKey implements PublicKey, XMSSKey {
    private static final long serialVersionUID = -5617456225328969766L;
    private transient XMSSPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSPublicKeyParameters xMSSPublicKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.keyParams = xMSSPublicKeyParameters;
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.keyParams = xMSSPublicKeyParameters;
        this.treeDigest = DigestUtil.getDigestOID(xMSSPublicKeyParameters.getTreeDigest());
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
        if (obj instanceof BCXMSSPublicKey) {
            BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
            try {
                if (!this.treeDigest.equals((ASN1Primitive) bCXMSSPublicKey.treeDigest) || !Arrays.areEqual(this.keyParams.getEncoded(), bCXMSSPublicKey.keyParams.getEncoded())) {
                    return false;
                }
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public final String getAlgorithm() {
        return "XMSS";
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

    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        try {
            return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.treeDigest.hashCode();
        }
    }

    public BCXMSSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }
}
