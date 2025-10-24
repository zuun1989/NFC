package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp.EvidenceRecord;

public class Evidence extends ASN1Object implements ASN1Choice {
    private EvidenceRecord ersEvidence;
    private ASN1Sequence otherEvidence;
    private TimeStampTokenEvidence tstEvidence;

    public Evidence(TimeStampTokenEvidence timeStampTokenEvidence) {
        this.tstEvidence = timeStampTokenEvidence;
    }

    public static Evidence getInstance(Object obj) {
        if (obj == null || (obj instanceof Evidence)) {
            return (Evidence) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Evidence(ASN1TaggedObject.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public EvidenceRecord getErsEvidence() {
        return this.ersEvidence;
    }

    public TimeStampTokenEvidence getTstEvidence() {
        return this.tstEvidence;
    }

    public ASN1Primitive toASN1Primitive() {
        TimeStampTokenEvidence timeStampTokenEvidence = this.tstEvidence;
        if (timeStampTokenEvidence != null) {
            return new DERTaggedObject(false, 0, timeStampTokenEvidence);
        }
        EvidenceRecord evidenceRecord = this.ersEvidence;
        if (evidenceRecord != null) {
            return new DERTaggedObject(false, 1, evidenceRecord);
        }
        return new DERTaggedObject(false, 2, this.otherEvidence);
    }

    public Evidence(EvidenceRecord evidenceRecord) {
        this.ersEvidence = evidenceRecord;
    }

    private Evidence(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.tstEvidence = TimeStampTokenEvidence.getInstance(aSN1TaggedObject, false);
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.ersEvidence = EvidenceRecord.getInstance(aSN1TaggedObject, false);
        } else if (aSN1TaggedObject.getTagNo() == 2) {
            this.otherEvidence = ASN1Sequence.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag in Evidence");
        }
    }

    public static Evidence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }
}
