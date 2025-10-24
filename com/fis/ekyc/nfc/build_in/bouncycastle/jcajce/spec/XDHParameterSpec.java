package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import java.security.spec.AlgorithmParameterSpec;

public class XDHParameterSpec implements AlgorithmParameterSpec {
    public static final String X25519 = "X25519";
    public static final String X448 = "X448";
    private final String curveName;

    public XDHParameterSpec(String str) {
        if (str.equalsIgnoreCase(X25519)) {
            this.curveName = X25519;
        } else if (str.equalsIgnoreCase(X448)) {
            this.curveName = X448;
        } else if (str.equals(EdECObjectIdentifiers.id_X25519.getId())) {
            this.curveName = X25519;
        } else if (str.equals(EdECObjectIdentifiers.id_X448.getId())) {
            this.curveName = X448;
        } else {
            throw new IllegalArgumentException("unrecognized curve name: " + str);
        }
    }

    public String getCurveName() {
        return this.curveName;
    }
}
