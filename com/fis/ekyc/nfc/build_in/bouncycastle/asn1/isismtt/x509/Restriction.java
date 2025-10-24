package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isismtt.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.DirectoryString;

public class Restriction extends ASN1Object {
    private DirectoryString restriction;

    private Restriction(DirectoryString directoryString) {
        this.restriction = directoryString;
    }

    public static Restriction getInstance(Object obj) {
        if (obj instanceof Restriction) {
            return (Restriction) obj;
        }
        if (obj != null) {
            return new Restriction(DirectoryString.getInstance(obj));
        }
        return null;
    }

    public DirectoryString getRestriction() {
        return this.restriction;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.restriction.toASN1Primitive();
    }

    public Restriction(String str) {
        this.restriction = new DirectoryString(str);
    }
}
