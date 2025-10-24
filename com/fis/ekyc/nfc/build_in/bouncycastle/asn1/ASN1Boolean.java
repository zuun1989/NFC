package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = new ASN1Boolean((byte) 0);
    private static final byte FALSE_VALUE = 0;
    public static final ASN1Boolean TRUE = new ASN1Boolean(TRUE_VALUE);
    private static final byte TRUE_VALUE = -1;
    private final byte value;

    private ASN1Boolean(byte b) {
        this.value = b;
    }

    public static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length == 1) {
            byte b = bArr[0];
            if (b == -1) {
                return TRUE;
            }
            if (b != 0) {
                return new ASN1Boolean(b);
            }
            return FALSE;
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Boolean)) {
            return (ASN1Boolean) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Boolean) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if ((aSN1Primitive instanceof ASN1Boolean) && isTrue() == ((ASN1Boolean) aSN1Primitive).isTrue()) {
            return true;
        }
        return false;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 1, this.value);
    }

    public int encodedLength() {
        return 3;
    }

    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        if (this.value != 0) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toDERObject() {
        if (isTrue()) {
            return TRUE;
        }
        return FALSE;
    }

    public String toString() {
        if (isTrue()) {
            return "TRUE";
        }
        return "FALSE";
    }

    public static ASN1Boolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static ASN1Boolean getInstance(int i) {
        return i != 0 ? TRUE : FALSE;
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1Boolean)) {
            return getInstance((Object) object);
        }
        return fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }
}
