package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.crmf;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.EnvelopedData;

public class EncryptedKey extends ASN1Object implements ASN1Choice {
    private EncryptedValue encryptedValue;
    private EnvelopedData envelopedData;

    public EncryptedKey(EnvelopedData envelopedData2) {
        this.envelopedData = envelopedData2;
    }

    public static EncryptedKey getInstance(Object obj) {
        if (obj instanceof EncryptedKey) {
            return (EncryptedKey) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new EncryptedKey(EnvelopedData.getInstance((ASN1TaggedObject) obj, false));
        }
        if (obj instanceof EncryptedValue) {
            return new EncryptedKey((EncryptedValue) obj);
        }
        return new EncryptedKey(EncryptedValue.getInstance(obj));
    }

    public ASN1Encodable getValue() {
        EncryptedValue encryptedValue2 = this.encryptedValue;
        if (encryptedValue2 != null) {
            return encryptedValue2;
        }
        return this.envelopedData;
    }

    public boolean isEncryptedValue() {
        if (this.encryptedValue != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        EncryptedValue encryptedValue2 = this.encryptedValue;
        if (encryptedValue2 != null) {
            return encryptedValue2.toASN1Primitive();
        }
        return new DERTaggedObject(false, 0, this.envelopedData);
    }

    public EncryptedKey(EncryptedValue encryptedValue2) {
        this.encryptedValue = encryptedValue2;
    }
}
