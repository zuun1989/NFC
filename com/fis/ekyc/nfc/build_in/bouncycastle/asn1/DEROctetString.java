package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString {
    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 4, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public boolean isConstructed() {
        return false;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }

    public DEROctetString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public static void encode(ASN1OutputStream aSN1OutputStream, boolean z, byte[] bArr, int i, int i2) throws IOException {
        aSN1OutputStream.writeEncoded(z, 4, bArr, i, i2);
    }
}
