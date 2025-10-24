package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public interface ASN1SetParser extends ASN1Encodable, InMemoryRepresentable {
    ASN1Encodable readObject() throws IOException;
}
