package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.util.Enumeration;

public class GOST28147Parameters extends ASN1Object {
    private ASN1OctetString iv;
    private ASN1ObjectIdentifier paramSet;

    public GOST28147Parameters(byte[] bArr, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.iv = new DEROctetString(bArr);
        this.paramSet = aSN1ObjectIdentifier;
    }

    public static GOST28147Parameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.paramSet;
    }

    public byte[] getIV() {
        return Arrays.clone(this.iv.getOctets());
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.iv);
        aSN1EncodableVector.add(this.paramSet);
        return new DERSequence(aSN1EncodableVector);
    }

    public static GOST28147Parameters getInstance(Object obj) {
        if (obj instanceof GOST28147Parameters) {
            return (GOST28147Parameters) obj;
        }
        if (obj != null) {
            return new GOST28147Parameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private GOST28147Parameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.iv = (ASN1OctetString) objects.nextElement();
        this.paramSet = (ASN1ObjectIdentifier) objects.nextElement();
    }
}
