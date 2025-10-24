package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.smime;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.Attribute;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.RecipientKeyIdentifier;

public class SMIMEEncryptionKeyPreferenceAttribute extends Attribute {
    public SMIMEEncryptionKeyPreferenceAttribute(IssuerAndSerialNumber issuerAndSerialNumber) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((ASN1Encodable) new DERTaggedObject(false, 0, issuerAndSerialNumber)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(RecipientKeyIdentifier recipientKeyIdentifier) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((ASN1Encodable) new DERTaggedObject(false, 1, recipientKeyIdentifier)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(ASN1OctetString aSN1OctetString) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((ASN1Encodable) new DERTaggedObject(false, 2, aSN1OctetString)));
    }
}
