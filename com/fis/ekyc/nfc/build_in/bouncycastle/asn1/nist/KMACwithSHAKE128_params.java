package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class KMACwithSHAKE128_params extends ASN1Object {
    private static final int DEF_LENGTH = 256;
    private static final byte[] EMPTY_STRING = new byte[0];
    private final byte[] customizationString;
    private final int outputLength;

    public KMACwithSHAKE128_params(int i) {
        this.outputLength = i;
        this.customizationString = EMPTY_STRING;
    }

    public static KMACwithSHAKE128_params getInstance(Object obj) {
        if (obj instanceof KMACwithSHAKE128_params) {
            return (KMACwithSHAKE128_params) obj;
        }
        if (obj != null) {
            return new KMACwithSHAKE128_params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCustomizationString() {
        return Arrays.clone(this.customizationString);
    }

    public int getOutputLength() {
        return this.outputLength;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = this.outputLength;
        if (i != 256) {
            aSN1EncodableVector.add(new ASN1Integer((long) i));
        }
        if (this.customizationString.length != 0) {
            aSN1EncodableVector.add(new DEROctetString(getCustomizationString()));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public KMACwithSHAKE128_params(int i, byte[] bArr) {
        this.outputLength = i;
        this.customizationString = Arrays.clone(bArr);
    }

    private KMACwithSHAKE128_params(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("sequence size greater than 2");
        } else if (aSN1Sequence.size() == 2) {
            this.outputLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
            this.customizationString = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
        } else if (aSN1Sequence.size() != 1) {
            this.outputLength = 256;
            this.customizationString = EMPTY_STRING;
        } else if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.outputLength = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intValueExact();
            this.customizationString = EMPTY_STRING;
        } else {
            this.outputLength = 256;
            this.customizationString = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
        }
    }
}
