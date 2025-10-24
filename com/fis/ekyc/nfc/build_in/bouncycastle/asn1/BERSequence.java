package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class BERSequence extends ASN1Sequence {
    public BERSequence() {
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodedIndef(z, 48, this.elements);
    }

    public int encodedLength() throws IOException {
        int i = 0;
        for (ASN1Encodable aSN1Primitive : this.elements) {
            i += aSN1Primitive.toASN1Primitive().encodedLength();
        }
        return i + 4;
    }

    public BERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public BERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }
}
