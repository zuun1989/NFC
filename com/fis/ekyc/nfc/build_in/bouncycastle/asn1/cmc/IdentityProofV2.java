package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class IdentityProofV2 extends ASN1Object {
    private final AlgorithmIdentifier macAlgId;
    private final AlgorithmIdentifier proofAlgID;
    private final byte[] witness;

    public IdentityProofV2(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        this.proofAlgID = algorithmIdentifier;
        this.macAlgId = algorithmIdentifier2;
        this.witness = Arrays.clone(bArr);
    }

    public static IdentityProofV2 getInstance(Object obj) {
        if (obj instanceof IdentityProofV2) {
            return (IdentityProofV2) obj;
        }
        if (obj != null) {
            return new IdentityProofV2(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getMacAlgId() {
        return this.macAlgId;
    }

    public AlgorithmIdentifier getProofAlgID() {
        return this.proofAlgID;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.proofAlgID);
        aSN1EncodableVector.add(this.macAlgId);
        aSN1EncodableVector.add(new DEROctetString(getWitness()));
        return new DERSequence(aSN1EncodableVector);
    }

    private IdentityProofV2(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.proofAlgID = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.macAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.witness = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
