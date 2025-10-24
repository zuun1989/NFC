package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardAccessFile implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.lds");
    private static final long serialVersionUID = -3536507558193769951L;
    private Set<SecurityInfo> securityInfos;

    public CardAccessFile(Collection<SecurityInfo> collection) {
        if (collection != null) {
            this.securityInfos = new HashSet(collection);
            return;
        }
        throw new IllegalArgumentException("Null securityInfos");
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        CardAccessFile cardAccessFile = (CardAccessFile) obj;
        Set<SecurityInfo> set = this.securityInfos;
        if (set != null) {
            Set<SecurityInfo> set2 = cardAccessFile.securityInfos;
            if (set2 != null) {
                return set.equals(set2);
            }
            if (set == null) {
                return true;
            }
            return false;
        } else if (cardAccessFile.securityInfos == null) {
            return true;
        } else {
            return false;
        }
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeContent(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Error closing stream", e);
            }
            return byteArray;
        } catch (IOException e2) {
            LOGGER.log(Level.WARNING, "Exception while encoding", e2);
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
                return null;
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                LOGGER.log(Level.FINE, "Error closing stream", e4);
            }
            throw th;
        }
    }

    public SecurityInfo getSecurityInfo(int i) {
        return (SecurityInfo) this.securityInfos.toArray()[i];
    }

    public Collection<SecurityInfo> getSecurityInfos() {
        return Collections.unmodifiableCollection(this.securityInfos);
    }

    public int getSecurityInfosSize() {
        return this.securityInfos.size();
    }

    public int hashCode() {
        return (this.securityInfos.hashCode() * 7) + 61;
    }

    public void readContent(InputStream inputStream) throws IOException {
        this.securityInfos = new HashSet();
        ASN1Set aSN1Set = (ASN1Set) new ASN1InputStream(inputStream).readObject();
        for (int i = 0; i < aSN1Set.size(); i++) {
            try {
                SecurityInfo instance = SecurityInfo.getInstance(aSN1Set.getObjectAt(i).toASN1Primitive());
                if (instance != null) {
                    this.securityInfos.add(instance);
                }
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        return "CardAccessFile [" + this.securityInfos.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SecurityInfo dERObject : this.securityInfos) {
            aSN1EncodableVector.add(dERObject.getDERObject());
        }
        outputStream.write(new DLSet(aSN1EncodableVector).getEncoded(ASN1Encoding.DER));
    }

    public CardAccessFile(InputStream inputStream) throws IOException {
        readContent(inputStream);
    }

    public CardAccessFile(byte[] bArr) throws IOException {
        readContent(new ByteArrayInputStream(bArr));
    }
}
