package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;

public class CircularRegion extends ASN1Object {
    private CircularRegion(ASN1Sequence aSN1Sequence) {
    }

    public static CircularRegion getInstance(Object obj) {
        if (obj instanceof CircularRegion) {
            return (CircularRegion) obj;
        }
        if (obj != null) {
            return new CircularRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
