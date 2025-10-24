package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    public DERBitString(byte b, int i) {
        super(b, i);
    }

    public static DERBitString fromOctetString(byte[] bArr) {
        if (bArr.length >= 1) {
            byte b = bArr[0];
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            if (length != 0) {
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            }
            return new DERBitString(bArr2, (int) b);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static DERBitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof DLBitString) {
            DLBitString dLBitString = (DLBitString) obj;
            return new DERBitString(dLBitString.data, dLBitString.padBits);
        } else if (obj instanceof byte[]) {
            try {
                return (DERBitString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        int i;
        byte[] bArr = this.data;
        int length = bArr.length;
        if (!(length == 0 || (i = this.padBits) == 0)) {
            int i2 = length - 1;
            byte b = bArr[i2];
            if (b != ((byte) ((255 << i) & b))) {
                aSN1OutputStream.writeEncoded(z, 3, (byte) i, bArr, 0, i2, (byte) (b & (255 << i)));
                return;
            }
        }
        aSN1OutputStream.writeEncoded(z, 3, (byte) this.padBits, bArr);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
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

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(int i) {
        super(ASN1BitString.getBytes(i), ASN1BitString.getPadBits(i));
    }

    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERBitString)) {
            return getInstance(object);
        }
        return fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }
}
