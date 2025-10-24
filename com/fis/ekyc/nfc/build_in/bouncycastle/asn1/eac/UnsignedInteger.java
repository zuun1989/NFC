package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import java.math.BigInteger;

public class UnsignedInteger extends ASN1Object {
    private int tagNo;
    private BigInteger value;

    public UnsignedInteger(int i, BigInteger bigInteger) {
        this.tagNo = i;
        this.value = bigInteger;
    }

    private byte[] convertValue() {
        byte[] byteArray = this.value.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static UnsignedInteger getInstance(Object obj) {
        if (obj instanceof UnsignedInteger) {
            return (UnsignedInteger) obj;
        }
        if (obj != null) {
            return new UnsignedInteger(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public BigInteger getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, new DEROctetString(convertValue()));
    }

    private UnsignedInteger(ASN1TaggedObject aSN1TaggedObject) {
        this.tagNo = aSN1TaggedObject.getTagNo();
        this.value = new BigInteger(1, ASN1OctetString.getInstance(aSN1TaggedObject, false).getOctets());
    }
}
