package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class CAST5CBCParameters extends ASN1Object {
    ASN1OctetString iv;
    ASN1Integer keyLength;

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.iv = new DEROctetString(Arrays.clone(bArr));
        this.keyLength = new ASN1Integer((long) i);
    }

    public static CAST5CBCParameters getInstance(Object obj) {
        if (obj instanceof CAST5CBCParameters) {
            return (CAST5CBCParameters) obj;
        }
        if (obj != null) {
            return new CAST5CBCParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getIV() {
        return Arrays.clone(this.iv.getOctets());
    }

    public int getKeyLength() {
        return this.keyLength.intValueExact();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.iv);
        aSN1EncodableVector.add(this.keyLength);
        return new DERSequence(aSN1EncodableVector);
    }

    private CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.keyLength = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }
}
