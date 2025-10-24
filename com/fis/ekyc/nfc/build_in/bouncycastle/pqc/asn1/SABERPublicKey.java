package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class SABERPublicKey extends ASN1Object {
    private byte[] b;
    private byte[] seed_A;

    public SABERPublicKey(byte[] bArr, byte[] bArr2) {
        this.seed_A = bArr;
        this.b = bArr2;
    }

    public static SABERPublicKey getInstance(Object obj) {
        if (obj instanceof SABERPublicKey) {
            return (SABERPublicKey) obj;
        }
        if (obj != null) {
            return new SABERPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getB() {
        return this.b;
    }

    public byte[] getSeed_A() {
        return this.seed_A;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.seed_A));
        aSN1EncodableVector.add(new DEROctetString(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    private SABERPublicKey(ASN1Sequence aSN1Sequence) {
        this.seed_A = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
        this.b = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
    }
}
