package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp.PKIStatusInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.ContentInfo;
import java.util.Enumeration;

public class TimeStampResp extends ASN1Object {
    PKIStatusInfo pkiStatusInfo;
    ContentInfo timeStampToken;

    private TimeStampResp(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.pkiStatusInfo = PKIStatusInfo.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.timeStampToken = ContentInfo.getInstance(objects.nextElement());
        }
    }

    public static TimeStampResp getInstance(Object obj) {
        if (obj instanceof TimeStampResp) {
            return (TimeStampResp) obj;
        }
        if (obj != null) {
            return new TimeStampResp(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIStatusInfo getStatus() {
        return this.pkiStatusInfo;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.pkiStatusInfo);
        ContentInfo contentInfo = this.timeStampToken;
        if (contentInfo != null) {
            aSN1EncodableVector.add(contentInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampResp(PKIStatusInfo pKIStatusInfo, ContentInfo contentInfo) {
        this.pkiStatusInfo = pKIStatusInfo;
        this.timeStampToken = contentInfo;
    }
}
