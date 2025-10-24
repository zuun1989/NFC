package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ocsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;

public class CertStatus extends ASN1Object implements ASN1Choice {
    private int tagNo;
    private ASN1Encodable value;

    public CertStatus() {
        this.tagNo = 0;
        this.value = DERNull.INSTANCE;
    }

    public static CertStatus getInstance(Object obj) {
        if (obj == null || (obj instanceof CertStatus)) {
            return (CertStatus) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertStatus((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public ASN1Encodable getStatus() {
        return this.value;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.value);
    }

    public CertStatus(RevokedInfo revokedInfo) {
        this.tagNo = 1;
        this.value = revokedInfo;
    }

    public static CertStatus getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public CertStatus(int i, ASN1Encodable aSN1Encodable) {
        this.tagNo = i;
        this.value = aSN1Encodable;
    }

    private CertStatus(ASN1TaggedObject aSN1TaggedObject) {
        this.tagNo = aSN1TaggedObject.getTagNo();
        int tagNo2 = aSN1TaggedObject.getTagNo();
        if (tagNo2 == 0) {
            this.value = DERNull.INSTANCE;
        } else if (tagNo2 == 1) {
            this.value = RevokedInfo.getInstance(aSN1TaggedObject, false);
        } else if (tagNo2 == 2) {
            this.value = DERNull.INSTANCE;
        } else {
            throw new IllegalArgumentException("Unknown tag encountered: " + aSN1TaggedObject.getTagNo());
        }
    }
}
