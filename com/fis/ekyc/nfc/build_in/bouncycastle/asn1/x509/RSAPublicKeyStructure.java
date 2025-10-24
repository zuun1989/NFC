package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;
import java.util.Enumeration;

public class RSAPublicKeyStructure extends ASN1Object {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RSAPublicKeyStructure(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public static RSAPublicKeyStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer(getModulus()));
        aSN1EncodableVector.add(new ASN1Integer(getPublicExponent()));
        return new DERSequence(aSN1EncodableVector);
    }

    public static RSAPublicKeyStructure getInstance(Object obj) {
        if (obj == null || (obj instanceof RSAPublicKeyStructure)) {
            return (RSAPublicKeyStructure) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RSAPublicKeyStructure((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid RSAPublicKeyStructure: " + obj.getClass().getName());
    }

    public RSAPublicKeyStructure(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.modulus = ASN1Integer.getInstance(objects.nextElement()).getPositiveValue();
            this.publicExponent = ASN1Integer.getInstance(objects.nextElement()).getPositiveValue();
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }
}
