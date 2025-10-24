package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCXMSSPrivateKey implements PrivateKey, XMSSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;
    private transient ASN1Set attributes;
    private transient XMSSPrivateKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSPrivateKeyParameters xMSSPrivateKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.keyParams = xMSSPrivateKeyParameters;
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.getAttributes();
        this.treeDigest = XMSSKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.keyParams = (XMSSPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
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
        if (!(obj instanceof BCXMSSPrivateKey)) {
            return false;
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
        if (!this.treeDigest.equals((ASN1Primitive) bCXMSSPrivateKey.treeDigest) || !Arrays.areEqual(this.keyParams.toByteArray(), bCXMSSPrivateKey.keyParams.toByteArray())) {
            return false;
        }
        return true;
    }

    public XMSSPrivateKey extractKeyShard(int i) {
        return new BCXMSSPrivateKey(this.treeDigest, this.keyParams.extractKeyShard(i));
    }

    public String getAlgorithm() {
        return "XMSS";
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

    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    public long getIndex() {
        if (getUsagesRemaining() != 0) {
            return (long) this.keyParams.getIndex();
        }
        throw new IllegalStateException("key exhausted");
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigest;
    }

    public long getUsagesRemaining() {
        return this.keyParams.getUsagesRemaining();
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }

    public BCXMSSPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }
}
