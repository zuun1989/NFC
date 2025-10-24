package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SPHINCS256KeyParams extends ASN1Object {
    private final AlgorithmIdentifier treeDigest;
    private final ASN1Integer version;

    public SPHINCS256KeyParams(AlgorithmIdentifier algorithmIdentifier) {
        this.version = new ASN1Integer(0);
        this.treeDigest = algorithmIdentifier;
    }

    public static final SPHINCS256KeyParams getInstance(Object obj) {
        if (obj instanceof SPHINCS256KeyParams) {
            return (SPHINCS256KeyParams) obj;
        }
        if (obj != null) {
            return new SPHINCS256KeyParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.treeDigest);
        return new DERSequence(aSN1EncodableVector);
    }

    private SPHINCS256KeyParams(ASN1Sequence aSN1Sequence) {
        this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.treeDigest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
