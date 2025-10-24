package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.dvcs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import java.math.BigInteger;

public class ServiceType extends ASN1Object {
    public static final ServiceType CCPD = new ServiceType(4);
    public static final ServiceType CPD = new ServiceType(1);
    public static final ServiceType VPKC = new ServiceType(3);
    public static final ServiceType VSD = new ServiceType(2);
    private ASN1Enumerated value;

    public ServiceType(int i) {
        this.value = new ASN1Enumerated(i);
    }

    public static ServiceType getInstance(Object obj) {
        if (obj instanceof ServiceType) {
            return (ServiceType) obj;
        }
        if (obj != null) {
            return new ServiceType(ASN1Enumerated.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }

    public String toString() {
        String str;
        int intValueExact = this.value.intValueExact();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(intValueExact);
        if (intValueExact == CPD.value.intValueExact()) {
            str = "(CPD)";
        } else if (intValueExact == VSD.value.intValueExact()) {
            str = "(VSD)";
        } else if (intValueExact == VPKC.value.intValueExact()) {
            str = "(VPKC)";
        } else if (intValueExact == CCPD.value.intValueExact()) {
            str = "(CCPD)";
        } else {
            str = "?";
        }
        sb2.append(str);
        return sb2.toString();
    }

    private ServiceType(ASN1Enumerated aSN1Enumerated) {
        this.value = aSN1Enumerated;
    }

    public static ServiceType getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Enumerated.getInstance(aSN1TaggedObject, z));
    }
}
