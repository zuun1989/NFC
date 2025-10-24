package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;

public enum CVCTagEnum {
    CV_CERTIFICATE(32545, true),
    CERTIFICATE_BODY(32590, true),
    PROFILE_IDENTIFIER(24361),
    PUBLIC_KEY(32585, true),
    HOLDER_REFERENCE(24352),
    HOLDER_AUTH_TEMPLATE(32588, true),
    EFFECTIVE_DATE(24357),
    EXPIRATION_DATE(24356),
    SIGNATURE(24375),
    OID(6),
    CA_REFERENCE(66),
    REQ_AUTHENTICATION(LDSFile.EF_DG7_TAG, true),
    ROLE_AND_ACCESS_RIGHTS(83),
    MODULUS(129),
    EXPONENT(ISO781611.BIOMETRIC_SUBTYPE_TAG),
    COEFFICIENT_A(ISO781611.BIOMETRIC_SUBTYPE_TAG),
    COEFFICIENT_B(ISO781611.CREATION_DATE_AND_TIME_TAG),
    BASE_POINT_G(132),
    BASE_POINT_R_ORDER(133),
    PUBLIC_POINT_Y(ISO781611.CREATOR_OF_BIOMETRIC_REFERENCE_DATA),
    COFACTOR_F(135),
    CERTIFICATE_EXTENSIONS(LDSFile.EF_DG5_TAG, true),
    DISCRETIONARY_DATA_TEMPLATE(ISO781611.DISCRETIONARY_DATA_FOR_PAYLOAD_CONSTRUCTED_TAG, true),
    ARBITRARY_DATA(83);
    
    private boolean isSequence;
    private int value;

    private CVCTagEnum(int i) {
        this(r2, r3, i, false);
    }

    public int getValue() {
        return this.value;
    }

    public boolean isSequence() {
        return this.isSequence;
    }

    private CVCTagEnum(int i, boolean z) {
        this.value = i;
        this.isSequence = z;
    }
}
