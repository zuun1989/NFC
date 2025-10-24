package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Object {
    protected CertificationRequestInfo reqInfo;
    protected AlgorithmIdentifier sigAlgId;
    protected DERBitString sigBits;

    public CertificationRequest() {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
    }

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificationRequestInfo getCertificationRequestInfo() {
        return this.reqInfo;
    }

    public DERBitString getSignature() {
        return this.sigBits;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.reqInfo);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(this.sigBits);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString) {
        this.reqInfo = certificationRequestInfo;
        this.sigAlgId = algorithmIdentifier;
        this.sigBits = dERBitString;
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        this.reqInfo = null;
        this.sigAlgId = null;
        this.sigBits = null;
        this.reqInfo = CertificationRequestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.sigBits = (DERBitString) aSN1Sequence.getObjectAt(2);
    }
}
