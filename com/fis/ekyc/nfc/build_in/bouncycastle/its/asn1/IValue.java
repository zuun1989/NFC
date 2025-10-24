package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

public class IValue extends ASN1Object {
    private final BigInteger value;

    private IValue(ASN1Integer aSN1Integer) {
        int intValueExact = BigIntegers.intValueExact(aSN1Integer.getValue());
        if (intValueExact < 0 || intValueExact > 65535) {
            throw new IllegalArgumentException("value out of range");
        }
        this.value = aSN1Integer.getValue();
    }

    public static IValue getInstance(Object obj) {
        if (obj instanceof IValue) {
            return (IValue) obj;
        }
        if (obj != null) {
            return new IValue(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.value);
    }
}
