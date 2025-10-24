package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Null extends ASN1Primitive {
    public static ASN1Null getInstance(Object obj) {
        if (obj instanceof ASN1Null) {
            return (ASN1Null) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e.getMessage());
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Null)) {
            return false;
        }
        return true;
    }

    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException;

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
