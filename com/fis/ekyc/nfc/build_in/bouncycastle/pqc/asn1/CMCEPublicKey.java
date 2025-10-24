package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class CMCEPublicKey extends ASN1Object {
    private byte[] T;

    public CMCEPublicKey(byte[] bArr) {
        this.T = bArr;
    }

    public static CMCEPublicKey getInstance(Object obj) {
        if (obj instanceof CMCEPrivateKey) {
            return (CMCEPublicKey) obj;
        }
        if (obj != null) {
            return new CMCEPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getT() {
        return Arrays.clone(this.T);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.T));
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCEPublicKey(ASN1Sequence aSN1Sequence) {
        this.T = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets());
    }
}
