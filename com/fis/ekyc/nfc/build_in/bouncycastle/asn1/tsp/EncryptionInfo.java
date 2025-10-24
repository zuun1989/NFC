package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSequence;

public class EncryptionInfo extends ASN1Object {
    private ASN1ObjectIdentifier encryptionInfoType;
    private ASN1Encodable encryptionInfoValue;

    private EncryptionInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.encryptionInfoType = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.encryptionInfoValue = aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException("wrong sequence size in constructor: " + aSN1Sequence.size());
    }

    public static EncryptionInfo getInstance(ASN1Object aSN1Object) {
        if (aSN1Object instanceof EncryptionInfo) {
            return (EncryptionInfo) aSN1Object;
        }
        if (aSN1Object != null) {
            return new EncryptionInfo(ASN1Sequence.getInstance(aSN1Object));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.encryptionInfoType);
        aSN1EncodableVector.add(this.encryptionInfoValue);
        return new DLSequence(aSN1EncodableVector);
    }

    public static EncryptionInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public EncryptionInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.encryptionInfoType = aSN1ObjectIdentifier;
        this.encryptionInfoValue = aSN1Encodable;
    }
}
