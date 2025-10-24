package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;

public class SubjectPermissions extends ASN1Object implements ASN1Choice {
    public static SubjectPermissions getInstance(Object obj) {
        if (obj instanceof SubjectPermissions) {
            return (SubjectPermissions) obj;
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
