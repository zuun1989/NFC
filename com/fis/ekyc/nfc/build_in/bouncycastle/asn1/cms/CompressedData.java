package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CompressedData extends ASN1Object {
    private AlgorithmIdentifier compressionAlgorithm;
    private ContentInfo encapContentInfo;
    private ASN1Integer version;

    public CompressedData(AlgorithmIdentifier algorithmIdentifier, ContentInfo contentInfo) {
        this.version = new ASN1Integer(0);
        this.compressionAlgorithm = algorithmIdentifier;
        this.encapContentInfo = contentInfo;
    }

    public static CompressedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getCompressionAlgorithmIdentifier() {
        return this.compressionAlgorithm;
    }

    public ContentInfo getEncapContentInfo() {
        return this.encapContentInfo;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.compressionAlgorithm);
        aSN1EncodableVector.add(this.encapContentInfo);
        return new BERSequence(aSN1EncodableVector);
    }

    public static CompressedData getInstance(Object obj) {
        if (obj instanceof CompressedData) {
            return (CompressedData) obj;
        }
        if (obj != null) {
            return new CompressedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private CompressedData(ASN1Sequence aSN1Sequence) {
        this.version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.compressionAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.encapContentInfo = ContentInfo.getInstance(aSN1Sequence.getObjectAt(2));
    }
}
