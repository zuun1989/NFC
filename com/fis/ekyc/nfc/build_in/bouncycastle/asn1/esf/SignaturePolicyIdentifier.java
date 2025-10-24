package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.esf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;

public class SignaturePolicyIdentifier extends ASN1Object {
    private boolean isSignaturePolicyImplied = true;
    private SignaturePolicyId signaturePolicyId;

    public SignaturePolicyIdentifier() {
    }

    public static SignaturePolicyIdentifier getInstance(Object obj) {
        if (obj instanceof SignaturePolicyIdentifier) {
            return (SignaturePolicyIdentifier) obj;
        }
        if ((obj instanceof ASN1Null) || ASN1Object.hasEncodedTagValue(obj, 5)) {
            return new SignaturePolicyIdentifier();
        }
        if (obj != null) {
            return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(obj));
        }
        return null;
    }

    public SignaturePolicyId getSignaturePolicyId() {
        return this.signaturePolicyId;
    }

    public boolean isSignaturePolicyImplied() {
        return this.isSignaturePolicyImplied;
    }

    public ASN1Primitive toASN1Primitive() {
        if (this.isSignaturePolicyImplied) {
            return DERNull.INSTANCE;
        }
        return this.signaturePolicyId.toASN1Primitive();
    }

    public SignaturePolicyIdentifier(SignaturePolicyId signaturePolicyId2) {
        this.signaturePolicyId = signaturePolicyId2;
    }
}
