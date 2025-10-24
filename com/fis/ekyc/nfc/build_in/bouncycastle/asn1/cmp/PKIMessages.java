package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class PKIMessages extends ASN1Object {
    private ASN1Sequence content;

    private PKIMessages(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static PKIMessages getInstance(Object obj) {
        if (obj instanceof PKIMessages) {
            return (PKIMessages) obj;
        }
        if (obj != null) {
            return new PKIMessages(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public PKIMessage[] toPKIMessageArray() {
        int size = this.content.size();
        PKIMessage[] pKIMessageArr = new PKIMessage[size];
        for (int i = 0; i != size; i++) {
            pKIMessageArr[i] = PKIMessage.getInstance(this.content.getObjectAt(i));
        }
        return pKIMessageArr;
    }

    public PKIMessages(PKIMessage pKIMessage) {
        this.content = new DERSequence((ASN1Encodable) pKIMessage);
    }

    public PKIMessages(PKIMessage[] pKIMessageArr) {
        this.content = new DERSequence((ASN1Encodable[]) pKIMessageArr);
    }
}
