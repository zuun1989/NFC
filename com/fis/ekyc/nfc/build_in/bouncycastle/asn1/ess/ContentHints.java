package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ess;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERUTF8String;

public class ContentHints extends ASN1Object {
    private DERUTF8String contentDescription;
    private ASN1ObjectIdentifier contentType;

    private ContentHints(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt.toASN1Primitive() instanceof DERUTF8String) {
            this.contentDescription = DERUTF8String.getInstance(objectAt);
            this.contentType = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        this.contentType = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
    }

    public static ContentHints getInstance(Object obj) {
        if (obj instanceof ContentHints) {
            return (ContentHints) obj;
        }
        if (obj != null) {
            return new ContentHints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getContentDescription() {
        return this.contentDescription;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        DERUTF8String dERUTF8String = this.contentDescription;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        aSN1EncodableVector.add(this.contentType);
        return new DERSequence(aSN1EncodableVector);
    }

    public ContentHints(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.contentType = aSN1ObjectIdentifier;
        this.contentDescription = null;
    }

    public ContentHints(ASN1ObjectIdentifier aSN1ObjectIdentifier, DERUTF8String dERUTF8String) {
        this.contentType = aSN1ObjectIdentifier;
        this.contentDescription = dERUTF8String;
    }
}
