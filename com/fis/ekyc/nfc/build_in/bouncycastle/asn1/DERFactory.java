package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

class DERFactory {
    static final ASN1Sequence EMPTY_SEQUENCE = new DERSequence();
    static final ASN1Set EMPTY_SET = new DERSet();

    public static ASN1Sequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector.size() < 1) {
            return EMPTY_SEQUENCE;
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static ASN1Set createSet(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector.size() < 1) {
            return EMPTY_SET;
        }
        return new DERSet(aSN1EncodableVector);
    }
}
