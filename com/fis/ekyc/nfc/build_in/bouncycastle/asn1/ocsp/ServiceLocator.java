package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ocsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityInformationAccess;

public class ServiceLocator extends ASN1Object {
    private final X500Name issuer;
    private final AuthorityInformationAccess locator;

    private ServiceLocator(ASN1Sequence aSN1Sequence) {
        this.issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.locator = AuthorityInformationAccess.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            this.locator = null;
        }
    }

    public static ServiceLocator getInstance(Object obj) {
        if (obj instanceof ServiceLocator) {
            return (ServiceLocator) obj;
        }
        if (obj != null) {
            return new ServiceLocator(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public AuthorityInformationAccess getLocator() {
        return this.locator;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.issuer);
        AuthorityInformationAccess authorityInformationAccess = this.locator;
        if (authorityInformationAccess != null) {
            aSN1EncodableVector.add(authorityInformationAccess);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
