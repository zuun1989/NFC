package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Time;
import java.util.Enumeration;

public class OptionalValidity extends ASN1Object {
    private Time notAfter;
    private Time notBefore;

    private OptionalValidity(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.notBefore = Time.getInstance(aSN1TaggedObject, true);
            } else {
                this.notAfter = Time.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    public static OptionalValidity getInstance(Object obj) {
        if (obj instanceof OptionalValidity) {
            return (OptionalValidity) obj;
        }
        if (obj != null) {
            return new OptionalValidity(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Time getNotAfter() {
        return this.notAfter;
    }

    public Time getNotBefore() {
        return this.notBefore;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        Time time = this.notBefore;
        if (time != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, time));
        }
        Time time2 = this.notAfter;
        if (time2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, time2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OptionalValidity(Time time, Time time2) {
        if (time == null && time2 == null) {
            throw new IllegalArgumentException("at least one of notBefore/notAfter must not be null.");
        }
        this.notBefore = time;
        this.notAfter = time2;
    }
}
