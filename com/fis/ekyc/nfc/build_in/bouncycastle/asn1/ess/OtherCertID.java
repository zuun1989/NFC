package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ess;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DigestInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.IssuerSerial;

public class OtherCertID extends ASN1Object {
    private IssuerSerial issuerSerial;
    private ASN1Encodable otherCertHash;

    private OtherCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        if (aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1OctetString) {
            this.otherCertHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.otherCertHash = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() > 1) {
            this.issuerSerial = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static OtherCertID getInstance(Object obj) {
        if (obj instanceof OtherCertID) {
            return (OtherCertID) obj;
        }
        if (obj != null) {
            return new OtherCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmHash() {
        if (this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
        }
        return DigestInfo.getInstance(this.otherCertHash).getAlgorithmId();
    }

    public byte[] getCertHash() {
        if (this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString) {
            return ((ASN1OctetString) this.otherCertHash.toASN1Primitive()).getOctets();
        }
        return DigestInfo.getInstance(this.otherCertHash).getDigest();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.otherCertHash);
        IssuerSerial issuerSerial2 = this.issuerSerial;
        if (issuerSerial2 != null) {
            aSN1EncodableVector.add(issuerSerial2);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial2) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
        this.issuerSerial = issuerSerial2;
    }
}
