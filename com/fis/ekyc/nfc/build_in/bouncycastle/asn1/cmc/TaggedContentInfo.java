package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.ContentInfo;

public class TaggedContentInfo extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final ContentInfo contentInfo;

    public TaggedContentInfo(BodyPartID bodyPartID2, ContentInfo contentInfo2) {
        this.bodyPartID = bodyPartID2;
        this.contentInfo = contentInfo2;
    }

    public static TaggedContentInfo getInstance(Object obj) {
        if (obj instanceof TaggedContentInfo) {
            return (TaggedContentInfo) obj;
        }
        if (obj != null) {
            return new TaggedContentInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.bodyPartID);
        aSN1EncodableVector.add(this.contentInfo);
        return new DERSequence(aSN1EncodableVector);
    }

    private TaggedContentInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.bodyPartID = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.contentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static TaggedContentInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
