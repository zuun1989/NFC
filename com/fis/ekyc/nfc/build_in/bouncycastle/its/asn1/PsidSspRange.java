package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class PsidSspRange extends ASN1Object {
    private ASN1Integer psid;
    private SspRange sspRange;

    public static PsidSspRange getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof PsidSspRange) {
            return (PsidSspRange) obj;
        }
        ASN1Sequence instance = ASN1Sequence.getInstance(obj);
        PsidSspRange psidSspRange = new PsidSspRange();
        if (instance.size() < 1 || instance.size() > 2) {
            throw new IllegalStateException("expected sequences with one or optionally two items");
        }
        if (instance.size() == 1) {
            psidSspRange.psid = (ASN1Integer) instance.getObjectAt(0);
        }
        if (instance.size() == 2) {
            psidSspRange.sspRange = SspRange.getInstance(instance.getObjectAt(1));
        }
        return psidSspRange;
    }

    public ASN1Integer getPsid() {
        return this.psid;
    }

    public SspRange getSspRange() {
        return this.sspRange;
    }

    public void setPsid(ASN1Integer aSN1Integer) {
        this.psid = aSN1Integer;
    }

    public void setSspRange(SspRange sspRange2) {
        this.sspRange = sspRange2;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.psid);
        SspRange sspRange2 = this.sspRange;
        if (sspRange2 != null) {
            aSN1EncodableVector.add(sspRange2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
