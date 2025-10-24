package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class SubjectKeyIdentifier extends ASN1Object {
    private byte[] keyidentifier;

    public SubjectKeyIdentifier(byte[] bArr) {
        this.keyidentifier = Arrays.clone(bArr);
    }

    public static SubjectKeyIdentifier fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.subjectKeyIdentifier));
    }

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1OctetString.getInstance(aSN1TaggedObject, z));
    }

    public byte[] getKeyIdentifier() {
        return Arrays.clone(this.keyidentifier);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(getKeyIdentifier());
    }

    public static SubjectKeyIdentifier getInstance(Object obj) {
        if (obj instanceof SubjectKeyIdentifier) {
            return (SubjectKeyIdentifier) obj;
        }
        if (obj != null) {
            return new SubjectKeyIdentifier(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public SubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this(aSN1OctetString.getOctets());
    }
}
