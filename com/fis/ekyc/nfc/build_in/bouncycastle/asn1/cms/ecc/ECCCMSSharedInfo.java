package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.ecc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class ECCCMSSharedInfo extends ASN1Object {
    private final byte[] entityUInfo;
    private final AlgorithmIdentifier keyInfo;
    private final byte[] suppPubInfo;

    public ECCCMSSharedInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this.keyInfo = algorithmIdentifier;
        this.entityUInfo = Arrays.clone(bArr);
        this.suppPubInfo = Arrays.clone(bArr2);
    }

    public static ECCCMSSharedInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.keyInfo);
        byte[] bArr = this.entityUInfo;
        if (bArr != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(bArr)));
        }
        aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(this.suppPubInfo)));
        return new DERSequence(aSN1EncodableVector);
    }

    public static ECCCMSSharedInfo getInstance(Object obj) {
        if (obj instanceof ECCCMSSharedInfo) {
            return (ECCCMSSharedInfo) obj;
        }
        if (obj != null) {
            return new ECCCMSSharedInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ECCCMSSharedInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.keyInfo = algorithmIdentifier;
        this.entityUInfo = null;
        this.suppPubInfo = Arrays.clone(bArr);
    }

    private ECCCMSSharedInfo(ASN1Sequence aSN1Sequence) {
        this.keyInfo = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.entityUInfo = null;
            this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true).getOctets();
            return;
        }
        this.entityUInfo = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true).getOctets();
        this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), true).getOctets();
    }
}
