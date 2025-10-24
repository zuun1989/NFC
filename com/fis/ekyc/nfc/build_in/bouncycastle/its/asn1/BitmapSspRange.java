package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class BitmapSspRange extends ASN1Object {
    private final byte[] sspBitmask;
    private final byte[] sspValue;

    private BitmapSspRange(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.sspValue = Utils.octetStringFixed(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
            this.sspBitmask = Utils.octetStringFixed(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            return;
        }
        throw new IllegalArgumentException("expected sequence with sspValue and sspBitmask");
    }

    public static BitmapSspRange getInstance(Object obj) {
        if (obj instanceof BitmapSspRange) {
            return (BitmapSspRange) obj;
        }
        if (obj != null) {
            return new BitmapSspRange(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getSspBitmask() {
        return Arrays.clone(this.sspBitmask);
    }

    public byte[] getSspValue() {
        return Arrays.clone(this.sspValue);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.sspValue));
        aSN1EncodableVector.add(new DEROctetString(this.sspBitmask));
        return new DERSequence(aSN1EncodableVector);
    }
}
