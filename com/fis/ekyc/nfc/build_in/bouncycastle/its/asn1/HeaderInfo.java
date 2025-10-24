package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class HeaderInfo extends ASN1Object {
    private HeaderInfo(ASN1Sequence aSN1Sequence) {
    }

    public static HeaderInfo getInstance(Object obj) {
        if (obj instanceof HeaderInfo) {
            return (HeaderInfo) obj;
        }
        if (obj != null) {
            return new HeaderInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
