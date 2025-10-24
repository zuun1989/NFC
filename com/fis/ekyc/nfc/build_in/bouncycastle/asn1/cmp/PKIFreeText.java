package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERUTF8String;
import java.util.Enumeration;

public class PKIFreeText extends ASN1Object {
    ASN1Sequence strings;

    private PKIFreeText(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            if (!(objects.nextElement() instanceof DERUTF8String)) {
                throw new IllegalArgumentException("attempt to insert non UTF8 STRING into PKIFreeText");
            }
        }
        this.strings = aSN1Sequence;
    }

    public static PKIFreeText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERUTF8String getStringAt(int i) {
        return (DERUTF8String) this.strings.getObjectAt(i);
    }

    public int size() {
        return this.strings.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.strings;
    }

    public static PKIFreeText getInstance(Object obj) {
        if (obj instanceof PKIFreeText) {
            return (PKIFreeText) obj;
        }
        if (obj != null) {
            return new PKIFreeText(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIFreeText(DERUTF8String dERUTF8String) {
        this.strings = new DERSequence((ASN1Encodable) dERUTF8String);
    }

    public PKIFreeText(String str) {
        this(new DERUTF8String(str));
    }

    public PKIFreeText(DERUTF8String[] dERUTF8StringArr) {
        this.strings = new DERSequence((ASN1Encodable[]) dERUTF8StringArr);
    }

    public PKIFreeText(String[] strArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(strArr.length);
        for (String dERUTF8String : strArr) {
            aSN1EncodableVector.add(new DERUTF8String(dERUTF8String));
        }
        this.strings = new DERSequence(aSN1EncodableVector);
    }
}
