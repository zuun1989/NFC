package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import java.security.spec.AlgorithmParameterSpec;

public class EdDSAParameterSpec implements AlgorithmParameterSpec {
    public static final String Ed25519 = "Ed25519";
    public static final String Ed448 = "Ed448";
    private final String curveName;

    public EdDSAParameterSpec(String str) {
        if (str.equalsIgnoreCase(Ed25519)) {
            this.curveName = Ed25519;
        } else if (str.equalsIgnoreCase(Ed448)) {
            this.curveName = Ed448;
        } else if (str.equals(EdECObjectIdentifiers.id_Ed25519.getId())) {
            this.curveName = Ed25519;
        } else if (str.equals(EdECObjectIdentifiers.id_Ed448.getId())) {
            this.curveName = Ed448;
        } else {
            throw new IllegalArgumentException("unrecognized curve name: " + str);
        }
    }

    public String getCurveName() {
        return this.curveName;
    }
}
