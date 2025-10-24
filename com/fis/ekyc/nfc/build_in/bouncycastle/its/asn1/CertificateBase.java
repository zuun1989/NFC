package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;

public class CertificateBase extends ASN1Object {
    private CertificateType type;
    private byte[] version;

    public CertificateBase(ASN1Sequence aSN1Sequence) {
    }

    public static CertificateBase getInstance(Object obj) {
        if (obj instanceof ImplicitCertificate) {
            return (ImplicitCertificate) obj;
        }
        if (obj instanceof ExplicitCertificate) {
            return (ExplicitCertificate) obj;
        }
        if (obj == null) {
            return null;
        }
        ASN1Sequence instance = ASN1Sequence.getInstance(obj);
        if (instance.getObjectAt(1).equals(CertificateType.Implicit)) {
            return getInstance(instance);
        }
        if (instance.getObjectAt(1).equals(CertificateType.Explicit)) {
            return getInstance(instance);
        }
        throw new IllegalArgumentException("unknown certificate type");
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
