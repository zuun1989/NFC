package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;

public class SCVPReqRes extends ASN1Object {
    private final ContentInfo request;
    private final ContentInfo response;

    private SCVPReqRes(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.request = ContentInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(0)), true);
            this.response = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        this.request = null;
        this.response = ContentInfo.getInstance(aSN1Sequence.getObjectAt(0));
    }

    public static SCVPReqRes getInstance(Object obj) {
        if (obj instanceof SCVPReqRes) {
            return (SCVPReqRes) obj;
        }
        if (obj != null) {
            return new SCVPReqRes(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo getRequest() {
        return this.request;
    }

    public ContentInfo getResponse() {
        return this.response;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ContentInfo contentInfo = this.request;
        if (contentInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, contentInfo));
        }
        aSN1EncodableVector.add(this.response);
        return new DERSequence(aSN1EncodableVector);
    }

    public SCVPReqRes(ContentInfo contentInfo) {
        this.request = null;
        this.response = contentInfo;
    }

    public SCVPReqRes(ContentInfo contentInfo, ContentInfo contentInfo2) {
        this.request = contentInfo;
        this.response = contentInfo2;
    }
}
