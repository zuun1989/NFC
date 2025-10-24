package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;
import java.math.BigInteger;

public class CertId extends ASN1Object {
    private GeneralName issuer;
    private ASN1Integer serialNumber;

    private CertId(ASN1Sequence aSN1Sequence) {
        this.issuer = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static CertId getInstance(Object obj) {
        if (obj instanceof CertId) {
            return (CertId) obj;
        }
        if (obj != null) {
            return new CertId(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getIssuer() {
        return this.issuer;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.serialNumber);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertId(GeneralName generalName, BigInteger bigInteger) {
        this(generalName, new ASN1Integer(bigInteger));
    }

    public static CertId getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public CertId(GeneralName generalName, ASN1Integer aSN1Integer) {
        this.issuer = generalName;
        this.serialNumber = aSN1Integer;
    }
}
