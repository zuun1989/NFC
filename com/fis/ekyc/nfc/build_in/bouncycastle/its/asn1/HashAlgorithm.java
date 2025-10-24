package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;

public class HashAlgorithm {
    public static final HashAlgorithm sha256 = new HashAlgorithm(0);
    public static final HashAlgorithm sha384 = new HashAlgorithm(1);
    private final ASN1Enumerated enumerated;

    public HashAlgorithm(int i) {
        this.enumerated = new ASN1Enumerated(i);
    }

    public HashAlgorithm getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof HashAlgorithm) {
            return (HashAlgorithm) obj;
        }
        return new HashAlgorithm(ASN1Enumerated.getInstance(obj));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.enumerated;
    }

    private HashAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this.enumerated = aSN1Enumerated;
    }
}
