package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERGeneralizedTime;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERPrintableString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERUTF8String;
import java.io.IOException;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    public ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.EmailAddress) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.DC)) {
                return new DERIA5String(str);
            }
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.DATE_OF_BIRTH)) {
                return new DERGeneralizedTime(str);
            }
            if (aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.C) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.SN) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.DN_QUALIFIER) || aSN1ObjectIdentifier.equals((ASN1Primitive) X509Name.TELEPHONE_NUMBER)) {
                return new DERPrintableString(str);
            }
            return new DERUTF8String(str);
        }
        try {
            return convertHexEncoded(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + aSN1ObjectIdentifier.getId());
        }
    }
}
