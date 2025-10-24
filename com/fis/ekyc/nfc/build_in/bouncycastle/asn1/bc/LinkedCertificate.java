package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.bc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.X500Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DigestInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralName;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.GeneralNames;

public class LinkedCertificate extends ASN1Object {
    private GeneralNames cACerts;
    private X500Name certIssuer;
    private final GeneralName certLocation;
    private final DigestInfo digest;

    public LinkedCertificate(DigestInfo digestInfo, GeneralName generalName) {
        this(digestInfo, generalName, (X500Name) null, (GeneralNames) null);
    }

    public static LinkedCertificate getInstance(Object obj) {
        if (obj instanceof LinkedCertificate) {
            return (LinkedCertificate) obj;
        }
        if (obj != null) {
            return new LinkedCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getCACerts() {
        return this.cACerts;
    }

    public X500Name getCertIssuer() {
        return this.certIssuer;
    }

    public GeneralName getCertLocation() {
        return this.certLocation;
    }

    public DigestInfo getDigest() {
        return this.digest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.add(this.digest);
        aSN1EncodableVector.add(this.certLocation);
        X500Name x500Name = this.certIssuer;
        if (x500Name != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, x500Name));
        }
        GeneralNames generalNames = this.cACerts;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public LinkedCertificate(DigestInfo digestInfo, GeneralName generalName, X500Name x500Name, GeneralNames generalNames) {
        this.digest = digestInfo;
        this.certLocation = generalName;
        this.certIssuer = x500Name;
        this.cACerts = generalNames;
    }

    private LinkedCertificate(ASN1Sequence aSN1Sequence) {
        this.digest = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.certLocation = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            for (int i = 2; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.certIssuer = X500Name.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.cACerts = GeneralNames.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in tagged field");
                }
            }
        }
    }
}
