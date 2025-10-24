package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class PartialHashtree extends ASN1Object {
    private ASN1Sequence values;

    private PartialHashtree(ASN1Sequence aSN1Sequence) {
        int i = 0;
        while (i != aSN1Sequence.size()) {
            if (aSN1Sequence.getObjectAt(i) instanceof DEROctetString) {
                i++;
            } else {
                throw new IllegalArgumentException("unknown object in constructor: " + aSN1Sequence.getObjectAt(i).getClass().getName());
            }
        }
        this.values = aSN1Sequence;
    }

    public static PartialHashtree getInstance(Object obj) {
        if (obj instanceof PartialHashtree) {
            return (PartialHashtree) obj;
        }
        if (obj != null) {
            return new PartialHashtree(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[][] getValues() {
        int size = this.values.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i != size; i++) {
            bArr[i] = Arrays.clone(ASN1OctetString.getInstance(this.values.getObjectAt(i)).getOctets());
        }
        return bArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }

    public PartialHashtree(byte[] bArr) {
        this(new byte[][]{bArr});
    }

    public PartialHashtree(byte[][] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(bArr.length);
        for (int i = 0; i != bArr.length; i++) {
            aSN1EncodableVector.add(new DEROctetString(Arrays.clone(bArr[i])));
        }
        this.values = new DERSequence(aSN1EncodableVector);
    }
}
