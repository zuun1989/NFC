package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import java.math.BigInteger;

public class PsidGroupPermissions extends ASN1Object {
    private final BigInteger chainLengthRange;
    private final Object eeType;
    private final BigInteger minChainLength;
    private final SubjectPermissions subjectPermissions;

    private PsidGroupPermissions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.subjectPermissions = SubjectPermissions.getInstance(aSN1Sequence.getObjectAt(0));
            this.minChainLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
            this.chainLengthRange = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue();
            this.eeType = EndEntityType.getInstance(aSN1Sequence.getObjectAt(3));
            return;
        }
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static PsidGroupPermissions getInstance(Object obj) {
        if (obj instanceof PsidGroupPermissions) {
            return (PsidGroupPermissions) obj;
        }
        if (obj != null) {
            return new PsidGroupPermissions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return null;
    }
}
