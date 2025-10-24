package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;

public class PKIConfirmContent extends ASN1Object {
    private ASN1Null val;

    private PKIConfirmContent(ASN1Null aSN1Null) {
        this.val = aSN1Null;
    }

    public static PKIConfirmContent getInstance(Object obj) {
        if (obj == null || (obj instanceof PKIConfirmContent)) {
            return (PKIConfirmContent) obj;
        }
        if (obj instanceof ASN1Null) {
            return new PKIConfirmContent((ASN1Null) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public ASN1Primitive toASN1Primitive() {
        return this.val;
    }

    public PKIConfirmContent() {
        this.val = DERNull.INSTANCE;
    }
}
