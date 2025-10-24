package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class SequenceOfRectangularRegion extends ASN1Object {
    private final RectangularRegion[] sequence;

    private SequenceOfRectangularRegion(ASN1Sequence aSN1Sequence) {
        this.sequence = new RectangularRegion[aSN1Sequence.size()];
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            this.sequence[i] = RectangularRegion.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.sequence);
    }
}
