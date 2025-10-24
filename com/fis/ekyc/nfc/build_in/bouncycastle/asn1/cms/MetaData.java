package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Boolean;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERUTF8String;

public class MetaData extends ASN1Object {
    private DERUTF8String fileName;
    private ASN1Boolean hashProtected;
    private DERIA5String mediaType;
    private Attributes otherMetaData;

    public MetaData(ASN1Boolean aSN1Boolean, DERUTF8String dERUTF8String, DERIA5String dERIA5String, Attributes attributes) {
        this.hashProtected = aSN1Boolean;
        this.fileName = dERUTF8String;
        this.mediaType = dERIA5String;
        this.otherMetaData = attributes;
    }

    public static MetaData getInstance(Object obj) {
        if (obj instanceof MetaData) {
            return (MetaData) obj;
        }
        if (obj != null) {
            return new MetaData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getFileName() {
        return this.fileName;
    }

    public DERIA5String getMediaType() {
        return this.mediaType;
    }

    public Attributes getOtherMetaData() {
        return this.otherMetaData;
    }

    public boolean isHashProtected() {
        return this.hashProtected.isTrue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.add(this.hashProtected);
        DERUTF8String dERUTF8String = this.fileName;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        DERIA5String dERIA5String = this.mediaType;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        Attributes attributes = this.otherMetaData;
        if (attributes != null) {
            aSN1EncodableVector.add(attributes);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private MetaData(ASN1Sequence aSN1Sequence) {
        this.hashProtected = ASN1Boolean.getInstance((Object) aSN1Sequence.getObjectAt(0));
        int i = 1;
        if (1 < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(1) instanceof DERUTF8String)) {
            this.fileName = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(1));
            i = 2;
        }
        if (i < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i) instanceof DERIA5String)) {
            this.mediaType = DERIA5String.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (i < aSN1Sequence.size()) {
            this.otherMetaData = Attributes.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }
}
