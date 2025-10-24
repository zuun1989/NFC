package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;

public class RectangularRegion extends ASN1Object {
    private RectangularRegion(ASN1Sequence aSN1Sequence) {
    }

    public static RectangularRegion getInstance(Object obj) {
        if (obj instanceof RectangularRegion) {
            return (RectangularRegion) obj;
        }
        if (obj != null) {
            return new RectangularRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
