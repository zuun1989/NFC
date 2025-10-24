package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;

public class Ieee1609Dot2Data extends ASN1Object {
    private final Ieee1609Dot2Content content;
    private final BigInteger protcolVersion;

    private Ieee1609Dot2Data(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.protcolVersion = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue();
            this.content = Ieee1609Dot2Content.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static Ieee1609Dot2Data getInstance(Object obj) {
        if (obj instanceof Ieee1609Dot2Data) {
            return (Ieee1609Dot2Data) obj;
        }
        if (obj != null) {
            return new Ieee1609Dot2Data(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
