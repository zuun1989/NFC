package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isismtt.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x500.DirectoryString;

public class AdditionalInformationSyntax extends ASN1Object {
    private DirectoryString information;

    private AdditionalInformationSyntax(DirectoryString directoryString) {
        this.information = directoryString;
    }

    public static AdditionalInformationSyntax getInstance(Object obj) {
        if (obj instanceof AdditionalInformationSyntax) {
            return (AdditionalInformationSyntax) obj;
        }
        if (obj != null) {
            return new AdditionalInformationSyntax(DirectoryString.getInstance(obj));
        }
        return null;
    }

    public DirectoryString getInformation() {
        return this.information;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.information.toASN1Primitive();
    }

    public AdditionalInformationSyntax(String str) {
        this(new DirectoryString(str));
    }
}
