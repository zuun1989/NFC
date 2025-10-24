package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public interface InMemoryRepresentable {
    ASN1Primitive getLoadedObject() throws IOException;
}
