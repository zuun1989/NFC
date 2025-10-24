package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    public DLApplicationSpecific(boolean z, int i, byte[] bArr) {
        super(z, i, bArr);
    }

    private static byte[] getEncodedVector(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i != aSN1EncodableVector.size()) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i)).getEncoded(ASN1Encoding.DL));
                i++;
            } catch (IOException e) {
                throw new ASN1ParsingException("malformed object: " + e, e);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] getEncoding(boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DL);
        if (z) {
            return encoded;
        }
        int lengthOfHeader = ASN1ApplicationSpecific.getLengthOfHeader(encoded);
        int length = encoded.length - lengthOfHeader;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, lengthOfHeader, bArr, 0, length);
        return bArr;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        int i;
        if (this.isConstructed) {
            i = 96;
        } else {
            i = 64;
        }
        aSN1OutputStream.writeEncoded(z, i, this.tag, this.octets);
    }

    public DLApplicationSpecific(int i, byte[] bArr) {
        this(false, i, bArr);
    }

    public DLApplicationSpecific(int i, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i, aSN1Encodable);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DLApplicationSpecific(boolean z, int i, ASN1Encodable aSN1Encodable) throws IOException {
        super(z || aSN1Encodable.toASN1Primitive().isConstructed(), i, getEncoding(z, aSN1Encodable));
    }

    public DLApplicationSpecific(int i, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i, getEncodedVector(aSN1EncodableVector));
    }
}
