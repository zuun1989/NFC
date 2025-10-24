package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class GroupLinkageValue extends ASN1Object {
    private byte[] jValue;
    private byte[] value;

    private GroupLinkageValue(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.jValue = Utils.octetStringFixed(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets(), 4);
            this.value = Utils.octetStringFixed(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets(), 9);
            return;
        }
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static GroupLinkageValue getInstance(Object obj) {
        if (obj instanceof GroupLinkageValue) {
            return (GroupLinkageValue) obj;
        }
        if (obj != null) {
            return new GroupLinkageValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getJValue() {
        return this.jValue;
    }

    public byte[] getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.jValue));
        aSN1EncodableVector.add(new DEROctetString(this.value));
        return new DERSequence(aSN1EncodableVector);
    }
}
