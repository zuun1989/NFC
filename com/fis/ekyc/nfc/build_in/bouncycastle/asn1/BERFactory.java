package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
    static final BERSet EMPTY_SET = new BERSet();

    public static BERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector.size() < 1) {
            return EMPTY_SEQUENCE;
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public static BERSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector.size() < 1) {
            return EMPTY_SET;
        }
        return new BERSet(aSN1EncodableVector);
    }
}
