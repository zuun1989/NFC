package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import java.util.Enumeration;

public class ArchiveTimeStampChain extends ASN1Object {
    private ASN1Sequence archiveTimestamps;

    public ArchiveTimeStampChain(ArchiveTimeStamp archiveTimeStamp) {
        this.archiveTimestamps = new DERSequence((ASN1Encodable) archiveTimeStamp);
    }

    public static ArchiveTimeStampChain getInstance(Object obj) {
        if (obj instanceof ArchiveTimeStampChain) {
            return (ArchiveTimeStampChain) obj;
        }
        if (obj != null) {
            return new ArchiveTimeStampChain(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ArchiveTimeStampChain append(ArchiveTimeStamp archiveTimeStamp) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.archiveTimestamps.size() + 1);
        for (int i = 0; i != this.archiveTimestamps.size(); i++) {
            aSN1EncodableVector.add(this.archiveTimestamps.getObjectAt(i));
        }
        aSN1EncodableVector.add(archiveTimeStamp);
        return new ArchiveTimeStampChain((ASN1Sequence) new DERSequence(aSN1EncodableVector));
    }

    public ArchiveTimeStamp[] getArchiveTimestamps() {
        int size = this.archiveTimestamps.size();
        ArchiveTimeStamp[] archiveTimeStampArr = new ArchiveTimeStamp[size];
        for (int i = 0; i != size; i++) {
            archiveTimeStampArr[i] = ArchiveTimeStamp.getInstance(this.archiveTimestamps.getObjectAt(i));
        }
        return archiveTimeStampArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.archiveTimestamps;
    }

    public ArchiveTimeStampChain(ArchiveTimeStamp[] archiveTimeStampArr) {
        this.archiveTimestamps = new DERSequence((ASN1Encodable[]) archiveTimeStampArr);
    }

    private ArchiveTimeStampChain(ASN1Sequence aSN1Sequence) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(aSN1Sequence.size());
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            aSN1EncodableVector.add(ArchiveTimeStamp.getInstance(objects.nextElement()));
        }
        this.archiveTimestamps = new DERSequence(aSN1EncodableVector);
    }
}
