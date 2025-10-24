package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import java.math.BigInteger;

public class GeneralSubtree extends ASN1Object {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private GeneralName base;
    private ASN1Integer maximum;
    private ASN1Integer minimum;

    private GeneralSubtree(ASN1Sequence aSN1Sequence) {
        this.base = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.minimum = ASN1Integer.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.maximum = ASN1Integer.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
            }
        } else if (size == 3) {
            ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance2.getTagNo() == 0) {
                this.minimum = ASN1Integer.getInstance(instance2, false);
                ASN1TaggedObject instance3 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                if (instance3.getTagNo() == 1) {
                    this.maximum = ASN1Integer.getInstance(instance3, false);
                    return;
                }
                throw new IllegalArgumentException("Bad tag number for 'maximum': " + instance3.getTagNo());
            }
            throw new IllegalArgumentException("Bad tag number for 'minimum': " + instance2.getTagNo());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralName getBase() {
        return this.base;
    }

    public BigInteger getMaximum() {
        ASN1Integer aSN1Integer = this.maximum;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public BigInteger getMinimum() {
        ASN1Integer aSN1Integer = this.minimum;
        if (aSN1Integer == null) {
            return ZERO;
        }
        return aSN1Integer.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.base);
        ASN1Integer aSN1Integer = this.minimum;
        if (aSN1Integer != null && !aSN1Integer.hasValue(ZERO)) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.minimum));
        }
        ASN1Integer aSN1Integer2 = this.maximum;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Integer2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof GeneralSubtree) {
            return (GeneralSubtree) obj;
        }
        return new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.base = generalName;
        if (bigInteger2 != null) {
            this.maximum = new ASN1Integer(bigInteger2);
        }
        if (bigInteger == null) {
            this.minimum = null;
        } else {
            this.minimum = new ASN1Integer(bigInteger);
        }
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, (BigInteger) null, (BigInteger) null);
    }
}
