package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.esf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifiers extends ASN1Object {
    ASN1Sequence qualifiers;

    private SigPolicyQualifiers(ASN1Sequence aSN1Sequence) {
        this.qualifiers = aSN1Sequence;
    }

    public static SigPolicyQualifiers getInstance(Object obj) {
        if (obj instanceof SigPolicyQualifiers) {
            return (SigPolicyQualifiers) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SigPolicyQualifiers(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SigPolicyQualifierInfo getInfoAt(int i) {
        return SigPolicyQualifierInfo.getInstance(this.qualifiers.getObjectAt(i));
    }

    public int size() {
        return this.qualifiers.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.qualifiers;
    }

    public SigPolicyQualifiers(SigPolicyQualifierInfo[] sigPolicyQualifierInfoArr) {
        this.qualifiers = new DERSequence((ASN1Encodable[]) sigPolicyQualifierInfoArr);
    }
}
