package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECAlgorithms;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.math.BigInteger;

public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private ECCurve curve;
    private ASN1ObjectIdentifier fieldIdentifier;
    private byte[] seed;

    public X9Curve(ECCurve eCCurve) {
        this(eCCurve, (byte[]) null);
    }

    private void setFieldIdentifier() {
        if (ECAlgorithms.isFpCurve(this.curve)) {
            this.fieldIdentifier = X9ObjectIdentifiers.prime_field;
        } else if (ECAlgorithms.isF2mCurve(this.curve)) {
            this.fieldIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        if (this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.prime_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).toASN1Primitive());
        } else if (this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).toASN1Primitive());
        }
        if (this.seed != null) {
            aSN1EncodableVector.add(new DERBitString(this.seed));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.fieldIdentifier = null;
        this.curve = eCCurve;
        this.seed = Arrays.clone(bArr);
        setFieldIdentifier();
    }

    public X9Curve(X9FieldID x9FieldID, BigInteger bigInteger, BigInteger bigInteger2, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        ASN1Sequence aSN1Sequence2 = aSN1Sequence;
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.equals((ASN1Primitive) X9ObjectIdentifiers.prime_field)) {
            this.curve = new ECCurve.Fp(((ASN1Integer) x9FieldID.getParameters()).getValue(), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        } else if (this.fieldIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.characteristic_two_field)) {
            ASN1Sequence instance = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int intValueExact = ((ASN1Integer) instance.getObjectAt(0)).intValueExact();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) instance.getObjectAt(1);
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.tpBasis)) {
                i3 = ASN1Integer.getInstance(instance.getObjectAt(2)).intValueExact();
                i2 = 0;
                i = 0;
            } else if (aSN1ObjectIdentifier.equals((ASN1Primitive) X9ObjectIdentifiers.ppBasis)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(2));
                int intValueExact2 = ASN1Integer.getInstance(instance2.getObjectAt(0)).intValueExact();
                int intValueExact3 = ASN1Integer.getInstance(instance2.getObjectAt(1)).intValueExact();
                i = ASN1Integer.getInstance(instance2.getObjectAt(2)).intValueExact();
                i3 = intValueExact2;
                i2 = intValueExact3;
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            this.curve = new ECCurve.F2m(intValueExact, i3, i2, i, new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(0)).getOctets()), new BigInteger(1, ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence2.getObjectAt(2)).getBytes();
        }
    }
}
