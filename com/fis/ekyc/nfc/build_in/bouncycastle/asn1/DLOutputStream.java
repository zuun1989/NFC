package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

class DLOutputStream extends ASN1OutputStream {
    public DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public ASN1OutputStream getDLSubStream() {
        return this;
    }

    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) throws IOException {
        aSN1Primitive.toDLObject().encode(this, z);
    }
}
