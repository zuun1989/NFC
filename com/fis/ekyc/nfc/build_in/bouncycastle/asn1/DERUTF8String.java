package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;

public class DERUTF8String extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERUTF8String(byte[] bArr) {
        this.string = bArr;
    }

    public static DERUTF8String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTF8String)) {
            return (DERUTF8String) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERUTF8String) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTF8String)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERUTF8String) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 12, this.string);
    }

    public int encodedLength() throws IOException {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public String getString() {
        return Strings.fromUTF8ByteArray(this.string);
    }

    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }

    public DERUTF8String(String str) {
        this.string = Strings.toUTF8ByteArray(str);
    }

    public static DERUTF8String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERUTF8String)) {
            return getInstance(object);
        }
        return new DERUTF8String(ASN1OctetString.getInstance(object).getOctets());
    }
}
