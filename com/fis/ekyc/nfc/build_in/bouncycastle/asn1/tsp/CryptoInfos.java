package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.Attribute;

public class CryptoInfos extends ASN1Object {
    private ASN1Sequence attributes;

    private CryptoInfos(ASN1Sequence aSN1Sequence) {
        this.attributes = aSN1Sequence;
    }

    public static CryptoInfos getInstance(Object obj) {
        if (obj instanceof CryptoInfos) {
            return (CryptoInfos) obj;
        }
        if (obj != null) {
            return new CryptoInfos(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Attribute[] getAttributes() {
        int size = this.attributes.size();
        Attribute[] attributeArr = new Attribute[size];
        for (int i = 0; i != size; i++) {
            attributeArr[i] = Attribute.getInstance(this.attributes.getObjectAt(i));
        }
        return attributeArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }

    public CryptoInfos(Attribute[] attributeArr) {
        this.attributes = new DERSequence((ASN1Encodable[]) attributeArr);
    }

    public static CryptoInfos getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
