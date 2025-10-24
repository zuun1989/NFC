package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class UserNotice extends ASN1Object {
    private final DisplayText explicitText;
    private final NoticeReference noticeRef;

    public UserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.noticeRef = noticeReference;
        this.explicitText = displayText;
    }

    public static UserNotice getInstance(Object obj) {
        if (obj instanceof UserNotice) {
            return (UserNotice) obj;
        }
        if (obj != null) {
            return new UserNotice(ASN1Sequence.getInstance(obj));
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

    public UserNotice(NoticeReference noticeReference, String str) {
        this(noticeReference, new DisplayText(str));
    }

    private UserNotice(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.noticeRef = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
            this.explicitText = DisplayText.getInstance(aSN1Sequence.getObjectAt(1));
        } else if (aSN1Sequence.size() == 1) {
            if (aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence) {
                this.noticeRef = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
                this.explicitText = null;
                return;
            }
            this.explicitText = DisplayText.getInstance(aSN1Sequence.getObjectAt(0));
            this.noticeRef = null;
        } else if (aSN1Sequence.size() == 0) {
            this.noticeRef = null;
            this.explicitText = null;
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
    }
}
