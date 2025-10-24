package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class LinkageValue extends ASN1Object {
    private final byte[] value;

    private LinkageValue(ASN1OctetString aSN1OctetString) {
        this.value = Arrays.clone(Utils.octetStringFixed(aSN1OctetString.getOctets(), 9));
    }

    public static LinkageValue getInstance(Object obj) {
        if (obj instanceof LinkageValue) {
            return (LinkageValue) obj;
        }
        if (obj != null) {
            return new LinkageValue(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(Arrays.clone(this.value));
    }
}
