package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;

public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    public GeneralNames(GeneralName generalName) {
        this.names = new GeneralName[]{generalName};
    }

    private static GeneralName[] copy(GeneralName[] generalNameArr) {
        GeneralName[] generalNameArr2 = new GeneralName[generalNameArr.length];
        System.arraycopy(generalNameArr, 0, generalNameArr2, 0, generalNameArr.length);
        return generalNameArr2;
    }

    public static GeneralNames fromExtensions(Extensions extensions, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, aSN1ObjectIdentifier));
    }

    public static GeneralNames getInstance(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        if (obj != null) {
            return new GeneralNames(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName[] getNames() {
        return copy(this.names);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.names);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("GeneralNames:");
        stringBuffer.append(lineSeparator);
        for (int i = 0; i != this.names.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(this.names[i]);
            stringBuffer.append(lineSeparator);
        }
        return stringBuffer.toString();
    }

    public GeneralNames(GeneralName[] generalNameArr) {
        this.names = copy(generalNameArr);
    }

    public static GeneralNames getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralNames(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private GeneralNames(ASN1Sequence aSN1Sequence) {
        this.names = new GeneralName[aSN1Sequence.size()];
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            this.names[i] = GeneralName.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }
}
