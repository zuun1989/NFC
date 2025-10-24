package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;

public class DERVisibleString extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERVisibleString(byte[] bArr) {
        this.string = bArr;
    }

    public static DERVisibleString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVisibleString)) {
            return (DERVisibleString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVisibleString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVisibleString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERVisibleString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 26, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    public String getString() {
        return Strings.fromByteArray(this.string);
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

    public DERVisibleString(String str) {
        this.string = Strings.toByteArray(str);
    }

    public static DERVisibleString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERVisibleString)) {
            return getInstance(object);
        }
        return new DERVisibleString(ASN1OctetString.getInstance(object).getOctets());
    }
}
