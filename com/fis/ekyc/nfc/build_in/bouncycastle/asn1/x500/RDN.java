package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet;

public class RDN extends ASN1Object {
    private ASN1Set values;

    private RDN(ASN1Set aSN1Set) {
        this.values = aSN1Set;
    }

    public static RDN getInstance(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        if (obj != null) {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public int collectAttributeTypes(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, int i) {
        int size = this.values.size();
        for (int i2 = 0; i2 < size; i2++) {
            aSN1ObjectIdentifierArr[i + i2] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i2)).getType();
        }
        return size;
    }

    public boolean containsAttributeType(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (AttributeTypeAndValue.getInstance(this.values.getObjectAt(i)).getType().equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int size = this.values.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        if (this.values.size() > 1) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.values.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }

    public RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(aSN1ObjectIdentifier);
        aSN1EncodableVector.add(aSN1Encodable);
        this.values = new DERSet((ASN1Encodable) new DERSequence(aSN1EncodableVector));
    }

    public RDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.values = new DERSet((ASN1Encodable) attributeTypeAndValue);
    }

    public RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.values = new DERSet((ASN1Encodable[]) attributeTypeAndValueArr);
    }
}
