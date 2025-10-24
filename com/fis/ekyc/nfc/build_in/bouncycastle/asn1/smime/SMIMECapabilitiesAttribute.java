package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.smime;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.Attribute;

public class SMIMECapabilitiesAttribute extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector sMIMECapabilityVector) {
        super(SMIMEAttributes.smimeCapabilities, new DERSet((ASN1Encodable) new DERSequence(sMIMECapabilityVector.toASN1EncodableVector())));
    }
}
