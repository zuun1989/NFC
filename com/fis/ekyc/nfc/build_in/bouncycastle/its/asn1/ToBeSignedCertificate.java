package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;

public class ToBeSignedCertificate extends ASN1Object {
    private ToBeSignedCertificate(ASN1Sequence aSN1Sequence) {
    }

    public static ToBeSignedCertificate getInstance(Object obj) {
        if (obj instanceof ToBeSignedCertificate) {
            return (ToBeSignedCertificate) obj;
        }
        if (obj != null) {
            return new ToBeSignedCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
