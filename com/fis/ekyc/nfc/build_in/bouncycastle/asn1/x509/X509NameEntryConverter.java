package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERPrintableString;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.io.IOException;

public abstract class X509NameEntryConverter {
    public boolean canBePrintable(String str) {
        return DERPrintableString.isPrintableString(str);
    }

    public ASN1Primitive convertHexEncoded(String str, int i) throws IOException {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(str, i, str.length() - i));
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);
}
