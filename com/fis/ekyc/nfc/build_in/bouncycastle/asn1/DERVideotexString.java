package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;

public class DERVideotexString extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERVideotexString(byte[] bArr) {
        this.string = Arrays.clone(bArr);
    }

    public static DERVideotexString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVideotexString)) {
            return (DERVideotexString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVideotexString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVideotexString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERVideotexString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 21, this.string);
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

    public static DERVideotexString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERVideotexString)) {
            return getInstance(object);
        }
        return new DERVideotexString(ASN1OctetString.getInstance(object).getOctets());
    }
}
