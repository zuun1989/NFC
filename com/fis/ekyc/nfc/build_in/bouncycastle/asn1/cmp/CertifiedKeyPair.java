package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf.EncryptedKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf.EncryptedValue;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair extends ASN1Object {
    private CertOrEncCert certOrEncCert;
    private EncryptedKey privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence aSN1Sequence) {
        this.certOrEncCert = CertOrEncCert.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() < 2) {
            return;
        }
        if (aSN1Sequence.size() == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance.getTagNo() == 0) {
                this.privateKey = EncryptedKey.getInstance(instance.getObject());
            } else {
                this.publicationInfo = PKIPublicationInfo.getInstance(instance.getObject());
            }
        } else {
            this.privateKey = EncryptedKey.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)).getObject());
            this.publicationInfo = PKIPublicationInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)).getObject());
        }
    }

    public static CertifiedKeyPair getInstance(Object obj) {
        if (obj instanceof CertifiedKeyPair) {
            return (CertifiedKeyPair) obj;
        }
        if (obj != null) {
            return new CertifiedKeyPair(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public EncryptedKey getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.certOrEncCert);
        EncryptedKey encryptedKey = this.privateKey;
        if (encryptedKey != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, encryptedKey));
        }
        PKIPublicationInfo pKIPublicationInfo = this.publicationInfo;
        if (pKIPublicationInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, pKIPublicationInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2) {
        this(certOrEncCert2, (EncryptedKey) null, (PKIPublicationInfo) null);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2, EncryptedKey encryptedKey, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert2 != null) {
            this.certOrEncCert = certOrEncCert2;
            this.privateKey = encryptedKey;
            this.publicationInfo = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2, EncryptedValue encryptedValue, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert2 != null) {
            this.certOrEncCert = certOrEncCert2;
            this.privateKey = encryptedValue != null ? new EncryptedKey(encryptedValue) : null;
            this.publicationInfo = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }
}
