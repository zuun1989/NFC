package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;

public class CRLDistPoint extends ASN1Object {
    ASN1Sequence seq;

    private CRLDistPoint(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
    }

    public static CRLDistPoint fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.cRLDistributionPoints));
    }

    public static CRLDistPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DistributionPoint[] getDistributionPoints() {
        DistributionPoint[] distributionPointArr = new DistributionPoint[this.seq.size()];
        for (int i = 0; i != this.seq.size(); i++) {
            distributionPointArr[i] = DistributionPoint.getInstance(this.seq.getObjectAt(i));
        }
        return distributionPointArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("CRLDistPoint:");
        stringBuffer.append(lineSeparator);
        DistributionPoint[] distributionPoints = getDistributionPoints();
        for (int i = 0; i != distributionPoints.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(distributionPoints[i]);
            stringBuffer.append(lineSeparator);
        }
        return stringBuffer.toString();
    }

    public static CRLDistPoint getInstance(Object obj) {
        if (obj instanceof CRLDistPoint) {
            return (CRLDistPoint) obj;
        }
        if (obj != null) {
            return new CRLDistPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CRLDistPoint(DistributionPoint[] distributionPointArr) {
        this.seq = null;
        this.seq = new DERSequence((ASN1Encodable[]) distributionPointArr);
    }
}
