package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

class DEROutputStream extends ASN1OutputStream {
    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public DEROutputStream getDERSubStream() {
        return this;
    }

    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) throws IOException {
        aSN1Primitive.toDERObject().encode(this, z);
    }
}
