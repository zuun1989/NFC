package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.est;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Attribute;
import java.io.IOException;

public class AttrOrOID extends ASN1Object implements ASN1Choice {
    private final Attribute attribute;
    private final ASN1ObjectIdentifier oid;

    public AttrOrOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.oid = aSN1ObjectIdentifier;
        this.attribute = null;
    }

    public static AttrOrOID getInstance(Object obj) {
        if (obj instanceof AttrOrOID) {
            return (AttrOrOID) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return new AttrOrOID(ASN1ObjectIdentifier.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new AttrOrOID(Attribute.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    public boolean isOid() {
        if (this.oid != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.oid;
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        return this.attribute.toASN1Primitive();
    }

    public AttrOrOID(Attribute attribute2) {
        this.oid = null;
        this.attribute = attribute2;
    }
}
