package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf.EncryptedKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf.EncryptedValue;

public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    private CMPCertificate certificate;
    private EncryptedKey encryptedKey;

    private CertOrEncCert(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.certificate = CMPCertificate.getInstance(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.encryptedKey = EncryptedKey.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("unknown tag: " + aSN1TaggedObject.getTagNo());
        }
    }

    public static CertOrEncCert getInstance(Object obj) {
        if (obj instanceof CertOrEncCert) {
            return (CertOrEncCert) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertOrEncCert((ASN1TaggedObject) obj);
        }
        return null;
    }

    public CMPCertificate getCertificate() {
        return this.certificate;
    }

    public EncryptedKey getEncryptedCert() {
        return this.encryptedKey;
    }

    public ASN1Primitive toASN1Primitive() {
        CMPCertificate cMPCertificate = this.certificate;
        if (cMPCertificate != null) {
            return new DERTaggedObject(true, 0, cMPCertificate);
        }
        return new DERTaggedObject(true, 1, this.encryptedKey);
    }

    public CertOrEncCert(CMPCertificate cMPCertificate) {
        if (cMPCertificate != null) {
            this.certificate = cMPCertificate;
            return;
        }
        throw new IllegalArgumentException("'certificate' cannot be null");
    }

    public CertOrEncCert(EncryptedValue encryptedValue) {
        if (encryptedValue != null) {
            this.encryptedKey = new EncryptedKey(encryptedValue);
            return;
        }
        throw new IllegalArgumentException("'encryptedCert' cannot be null");
    }

    public CertOrEncCert(EncryptedKey encryptedKey2) {
        if (encryptedKey2 != null) {
            this.encryptedKey = encryptedKey2;
            return;
        }
        throw new IllegalArgumentException("'encryptedKey' cannot be null");
    }
}
