package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

public class BCLMSPrivateKey implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;
    private transient ASN1Set attributes;
    private transient LMSKeyParameters keyParams;

    public BCLMSPrivateKey(LMSKeyParameters lMSKeyParameters) {
        this.keyParams = lMSKeyParameters;
    }

    private void init(PrivateKeyInfo privateKeyInfo) throws IOException {
        this.attributes = privateKeyInfo.getAttributes();
        this.keyParams = (LMSKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
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
        if (!(obj instanceof BCLMSPrivateKey)) {
            return false;
        }
        try {
            return Arrays.areEqual(this.keyParams.getEncoded(), ((BCLMSPrivateKey) obj).keyParams.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    public LMSPrivateKey extractKeyShard(int i) {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        if (lMSKeyParameters instanceof LMSPrivateKeyParameters) {
            return new BCLMSPrivateKey((LMSKeyParameters) ((LMSPrivateKeyParameters) lMSKeyParameters).extractKeyShard(i));
        }
        return new BCLMSPrivateKey((LMSKeyParameters) ((HSSPrivateKeyParameters) lMSKeyParameters).extractKeyShard(i));
    }

    public String getAlgorithm() {
        return "LMS";
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

    public long getIndex() {
        if (getUsagesRemaining() != 0) {
            LMSKeyParameters lMSKeyParameters = this.keyParams;
            if (lMSKeyParameters instanceof LMSPrivateKeyParameters) {
                return (long) ((LMSPrivateKeyParameters) lMSKeyParameters).getIndex();
            }
            return ((HSSPrivateKeyParameters) lMSKeyParameters).getIndex();
        }
        throw new IllegalStateException("key exhausted");
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public int getLevels() {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        if (lMSKeyParameters instanceof LMSPrivateKeyParameters) {
            return 1;
        }
        return ((HSSPrivateKeyParameters) lMSKeyParameters).getL();
    }

    public long getUsagesRemaining() {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        if (lMSKeyParameters instanceof LMSPrivateKeyParameters) {
            return ((LMSPrivateKeyParameters) lMSKeyParameters).getUsagesRemaining();
        }
        return ((HSSPrivateKeyParameters) lMSKeyParameters).getUsagesRemaining();
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(this.keyParams.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }

    public BCLMSPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        init(privateKeyInfo);
    }
}
