package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;

public class HashedData extends ASN1Object implements ASN1Choice {
    private ASN1OctetString hashData;

    public HashedData(byte[] bArr) {
        this.hashData = new DEROctetString(bArr);
    }

    public ASN1OctetString getHashData() {
        return this.hashData;
    }

    public void setHashData(ASN1OctetString aSN1OctetString) {
        this.hashData = aSN1OctetString;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.hashData;
    }

    private HashedData(ASN1OctetString aSN1OctetString) {
        this.hashData = aSN1OctetString;
    }
}
