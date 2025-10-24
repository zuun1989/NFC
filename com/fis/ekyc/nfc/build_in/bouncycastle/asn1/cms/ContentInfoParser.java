package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1SequenceParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObjectParser;
import java.io.IOException;

public class ContentInfoParser {
    private ASN1TaggedObjectParser content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfoParser(ASN1SequenceParser aSN1SequenceParser) throws IOException {
        this.contentType = (ASN1ObjectIdentifier) aSN1SequenceParser.readObject();
        this.content = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public ASN1Encodable getContent(int i) throws IOException {
        ASN1TaggedObjectParser aSN1TaggedObjectParser = this.content;
        if (aSN1TaggedObjectParser != null) {
            return aSN1TaggedObjectParser.getObjectParser(i, true);
        }
        return null;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }
}
