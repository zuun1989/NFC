package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;

public class CertificateType {
    public static final CertificateType Explicit = new CertificateType(0);
    public static final CertificateType Implicit = new CertificateType(1);
    private final ASN1Enumerated enumerated;

    public CertificateType(int i) {
        this.enumerated = new ASN1Enumerated(i);
    }

    public CertificateType getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof CertificateType) {
            return (CertificateType) obj;
        }
        return new CertificateType(ASN1Enumerated.getInstance(obj));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.enumerated;
    }

    private CertificateType(ASN1Enumerated aSN1Enumerated) {
        this.enumerated = aSN1Enumerated;
    }
}
