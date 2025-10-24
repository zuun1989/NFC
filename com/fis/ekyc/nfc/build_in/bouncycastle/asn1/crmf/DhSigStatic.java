package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class DhSigStatic extends ASN1Object {
    private final ASN1OctetString hashValue;
    private final IssuerAndSerialNumber issuerAndSerial;

    public DhSigStatic(byte[] bArr) {
        this((IssuerAndSerialNumber) null, bArr);
    }

    public static DhSigStatic getInstance(Object obj) {
        if (obj instanceof DhSigStatic) {
            return (DhSigStatic) obj;
        }
        if (obj != null) {
            return new DhSigStatic(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getHashValue() {
        return Arrays.clone(this.hashValue.getOctets());
    }

    public IssuerAndSerialNumber getIssuerAndSerial() {
        return this.issuerAndSerial;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        IssuerAndSerialNumber issuerAndSerialNumber = this.issuerAndSerial;
        if (issuerAndSerialNumber != null) {
            aSN1EncodableVector.add(issuerAndSerialNumber);
        }
        aSN1EncodableVector.add(this.hashValue);
        return new DERSequence(aSN1EncodableVector);
    }

    public DhSigStatic(IssuerAndSerialNumber issuerAndSerialNumber, byte[] bArr) {
        this.issuerAndSerial = issuerAndSerialNumber;
        this.hashValue = new DEROctetString(Arrays.clone(bArr));
    }

    private DhSigStatic(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.issuerAndSerial = null;
            this.hashValue = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        } else if (aSN1Sequence.size() == 2) {
            this.issuerAndSerial = IssuerAndSerialNumber.getInstance(aSN1Sequence.getObjectAt(0));
            this.hashValue = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            throw new IllegalArgumentException("sequence wrong length for DhSigStatic");
        }
    }
}
