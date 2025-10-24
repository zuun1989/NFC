package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;

public class SymmAlgorithm extends ASN1Object {
    public static SymmAlgorithm aes128Ccm = new SymmAlgorithm(new ASN1Enumerated(0));
    private ASN1Enumerated symmAlgorithm;

    private SymmAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this.symmAlgorithm = aSN1Enumerated;
    }

    public SymmAlgorithm getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof SymmAlgorithm) {
            return (SymmAlgorithm) obj;
        }
        return new SymmAlgorithm(ASN1Enumerated.getInstance(obj));
    }

    public ASN1Enumerated getSymmAlgorithm() {
        return this.symmAlgorithm;
    }

    public void setSymmAlgorithm(ASN1Enumerated aSN1Enumerated) {
        this.symmAlgorithm = aSN1Enumerated;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.symmAlgorithm.toASN1Primitive();
    }

    public SymmAlgorithm(int i) {
        this.symmAlgorithm = new ASN1Enumerated(i);
    }
}
