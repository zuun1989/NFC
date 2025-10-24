package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.bc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1BitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;

public class ExternalValue extends ASN1Object {
    private final AlgorithmIdentifier hashAlg;
    private final ASN1BitString hashVal;
    private final GeneralName location;

    public ExternalValue(GeneralName generalName, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.location = generalName;
        this.hashAlg = algorithmIdentifier;
        this.hashVal = new DERBitString(bArr);
    }

    public static ExternalValue getInstance(Object obj) {
        return null;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public ASN1BitString getHashVal() {
        return this.hashVal;
    }

    public GeneralName getLocation() {
        return this.location;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.location);
        aSN1EncodableVector.add(this.hashAlg);
        aSN1EncodableVector.add(this.hashVal);
        return new DERSequence(aSN1EncodableVector);
    }

    private ExternalValue(ASN1Sequence aSN1Sequence, ASN1BitString aSN1BitString) {
        this.hashVal = aSN1BitString;
        if (aSN1Sequence.size() == 3) {
            this.location = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
            this.hashAlg = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("unknown sequence");
    }
}
