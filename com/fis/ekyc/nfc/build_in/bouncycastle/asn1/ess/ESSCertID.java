package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ess;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.IssuerSerial;

public class ESSCertID extends ASN1Object {
    private ASN1OctetString certHash;
    private IssuerSerial issuerSerial;

    private ESSCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.issuerSerial = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static ESSCertID getInstance(Object obj) {
        if (obj instanceof ESSCertID) {
            return (ESSCertID) obj;
        }
        if (obj != null) {
            return new ESSCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCertHash() {
        return this.certHash.getOctets();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.certHash);
        IssuerSerial issuerSerial2 = this.issuerSerial;
        if (issuerSerial2 != null) {
            aSN1EncodableVector.add(issuerSerial2);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ESSCertID(byte[] bArr) {
        this.certHash = new DEROctetString(bArr);
    }

    public ESSCertID(byte[] bArr, IssuerSerial issuerSerial2) {
        this.certHash = new DEROctetString(bArr);
        this.issuerSerial = issuerSerial2;
    }
}
