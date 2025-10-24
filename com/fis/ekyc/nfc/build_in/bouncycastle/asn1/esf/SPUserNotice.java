package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.esf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DisplayText;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.NoticeReference;
import java.util.Enumeration;

public class SPUserNotice extends ASN1Object {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    private SPUserNotice(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) objects.nextElement();
            if ((aSN1Encodable instanceof DisplayText) || (aSN1Encodable instanceof ASN1String)) {
                this.explicitText = DisplayText.getInstance(aSN1Encodable);
            } else if ((aSN1Encodable instanceof NoticeReference) || (aSN1Encodable instanceof ASN1Sequence)) {
                this.noticeRef = NoticeReference.getInstance(aSN1Encodable);
            } else {
                throw new IllegalArgumentException("Invalid element in 'SPUserNotice': " + aSN1Encodable.getClass().getName());
            }
        }
    }

    public static SPUserNotice getInstance(Object obj) {
        if (obj instanceof SPUserNotice) {
            return (SPUserNotice) obj;
        }
        if (obj != null) {
            return new SPUserNotice(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        NoticeReference noticeReference = this.noticeRef;
        if (noticeReference != null) {
            aSN1EncodableVector.add(noticeReference);
        }
        DisplayText displayText = this.explicitText;
        if (displayText != null) {
            aSN1EncodableVector.add(displayText);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SPUserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.noticeRef = noticeReference;
        this.explicitText = displayText;
    }
}
