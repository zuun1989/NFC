package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCXMSSMTPrivateKey implements PrivateKey, XMSSMTPrivateKey {
    private static final long serialVersionUID = 7682140473044521395L;
    private transient ASN1Set attributes;
    private transient XMSSMTPrivateKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.keyParams = xMSSMTPrivateKeyParameters;
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.getAttributes();
        this.treeDigest = XMSSMTKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.keyParams = (XMSSMTPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
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
        if (!(obj instanceof BCXMSSMTPrivateKey)) {
            return false;
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) obj;
        if (!this.treeDigest.equals((ASN1Primitive) bCXMSSMTPrivateKey.treeDigest) || !Arrays.areEqual(this.keyParams.toByteArray(), bCXMSSMTPrivateKey.keyParams.toByteArray())) {
            return false;
        }
        return true;
    }

    public XMSSMTPrivateKey extractKeyShard(int i) {
        return new BCXMSSMTPrivateKey(this.treeDigest, this.keyParams.extractKeyShard(i));
    }

    public String getAlgorithm() {
        return "XMSSMT";
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
            return this.keyParams.getIndex();
        }
        throw new IllegalStateException("key exhausted");
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public int getLayers() {
        return this.keyParams.getParameters().getLayers();
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

    public BCXMSSMTPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }
}
