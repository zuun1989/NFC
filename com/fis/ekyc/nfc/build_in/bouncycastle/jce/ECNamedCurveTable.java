package com.fis.ekyc.nfc.build_in.bouncycastle.jce;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec.CustomNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import java.util.Enumeration;

public class ECNamedCurveTable {
    public static Enumeration getNames() {
        return com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable.getNames();
    }

    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = CustomNamedCurves.getByOID(new ASN1ObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
            }
            if (byName == null && (byName = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable.getByName(str)) == null) {
                try {
                    byName = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(str));
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        if (byName == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }
}
